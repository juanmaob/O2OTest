package com.seventhson.o2otest.data.results

data class DataResult<T>(val state: Map<Int, String>, var response: T?)