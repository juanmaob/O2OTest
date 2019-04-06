package com.seventhson.o2otest.ui.common

/**
 * Created by Juanma Osuna on 4/04/19
 */
abstract class BasePresenter<V : BaseView> {

    lateinit var view: V

    fun attachView(view: V) {
        this.view = view
    }

    fun dettachView() {

    }

    fun connectionError() {
        view.hideLoading()
        view.showDefaultError()
    }

    fun generciError() {
        view.hideLoading()
        view.showDefaultError()
    }

}