package com.seventhson.o2otest.domain.interactors

import com.seventhson.o2otest.data.results.DataResult

abstract class Interactor<T> {

    abstract fun executeRepoCall(): DataResult<T>

    fun execute(onResult: (DataResult<T>) -> Unit) {
       onResult(executeRepoCall())
    }
}