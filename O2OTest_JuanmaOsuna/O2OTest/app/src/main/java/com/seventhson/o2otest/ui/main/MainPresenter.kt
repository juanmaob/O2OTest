package com.seventhson.o2otest.ui.main

import com.seventhson.o2otest.data.results.DataResult
import com.seventhson.o2otest.data.results.StatusCode
import com.seventhson.o2otest.domain.interactors.GetRecipesInteractor
import com.seventhson.o2otest.domain.model.Recipe
import com.seventhson.o2otest.ui.common.BasePresenter
import javax.inject.Inject


/**
 * Created by Juanma Osuna on 4/04/19
 */
class MainPresenter @Inject constructor(private val interactor: GetRecipesInteractor) :
    BasePresenter<MainView>() {


    fun onGetRecipeList(text: String) {
        view.showLoading()
        interactor.setParams(text)
        execute(interactor, this::onRecipesReady)
    }

    private fun onRecipesReady(data: List<Recipe>) {
        view.updateRecyclerView(data)
        view.hideLoading()
    }

}