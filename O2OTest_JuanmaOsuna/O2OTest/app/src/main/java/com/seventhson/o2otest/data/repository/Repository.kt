package com.seventhson.o2otest.data.repository

import com.seventhson.o2otest.data.results.DataResult
import com.seventhson.o2otest.data.results.StatusCode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response
import java.net.UnknownHostException

open class Repository {

    fun execute(call: Call<*>): DataResult<out Response<*>> = runBlocking {
        withContext(Dispatchers.IO) {
            try {
                val response = call.execute()
                if (response.isSuccessful) {
                    return@withContext DataResult(
                        mapOf(
                            response.code() to ""
                        ), response = response
                    )
                } else {
                    val code = response.code()
                    val msg = response.message()
                    return@withContext DataResult(
                        state = mapOf(
                            code to msg
                        ), response = null
                    )
                }
            } catch (e: UnknownHostException) {
                return@withContext DataResult(
                    state = mapOf(
                        StatusCode.NoConnection.code to ""
                    ), response = null
                )
            } catch (e: Exception) {
                return@withContext DataResult(
                    state = mapOf(
                        StatusCode.GenericError.code to ""
                    ), response = null
                )
            }

        }
    }


}
