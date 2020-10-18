package com.seventhson.o2otest.data.results

enum class StatusCode(val code: Int) {
    GenericError(0),
    NoConnection(1001),
    OK(200)
}