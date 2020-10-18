package com.seventhson.o2otest.ui.common

import com.seventhson.o2otest.data.results.DataResult
import com.seventhson.o2otest.data.results.StatusCode.*
import com.seventhson.o2otest.domain.interactors.Interactor

/**
 * Created by Juanma Osuna on 4/04/19
 */
abstract class BasePresenter<V : BaseView> {

    lateinit var view: V

    fun attachView(view: V) {
        this.view = view
    }

    fun detachView() {
        //Do something
    }

    private fun connectionError() {
        view.hideLoading()
        view.showConnectionError()
    }

    private fun apiError(msg: String) {
        view.hideLoading()
        view.showApiError(msg)
    }

    private fun genericError() {
        view.hideLoading()
        view.showDefaultError()
    }

    open fun <T> execute(
        interactor: Interactor<T>,
        onResult: (T) -> Unit,
        onApiError: (String) -> Unit = this::apiError,
        onConnectionError: () -> Unit = this::connectionError,
        onGenericError: () -> Unit = this::genericError
    ) {
        interactor.execute {
            when(it.state.keys.first()) {
                OK.code -> onResult(it.response!!)
                NoConnection.code -> handleError(it, onResult, onConnectionError)
                GenericError.code -> handleError(it, onResult, onGenericError)
                else -> handleError(it, onResult, { onApiError(it.state.values.first()) })
            }
        }
    }

    private fun <T> handleError(dataResult: DataResult<T>, onResult: (T) -> Unit, onError: () -> Unit) {
        dataResult.response?.let { onResult(it) }
        onError()
    }

}