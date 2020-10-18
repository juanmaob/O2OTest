package com.seventhson.o2otest.ui.common

import android.content.Context

/**
 * Created by Juanma Osuna on 4/04/19
 */
interface BaseView {

    fun showLoading()

    fun hideLoading()

    fun showConnectionError()

    fun showDefaultError()

    fun context(): Context

    fun showApiError(msg: String)

}