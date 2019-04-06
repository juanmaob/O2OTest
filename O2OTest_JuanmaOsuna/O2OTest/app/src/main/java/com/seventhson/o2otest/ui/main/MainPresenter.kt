package com.seventhson.o2otest.ui.main

import com.seventhson.o2otest.data.pojos.Recipe
import com.seventhson.o2otest.ui.common.BasePresenter

/**
 * Created by Juanma Osuna on 4/04/19
 */
class MainPresenter(private val mainInteractor: MainInteractor) : BasePresenter<MainView>() {

    fun onGetRecipeList(text: String) {
        mainInteractor.getRecipes(this::onRecipesReady, text)
    }

    fun onRecipesReady(list: List<Recipe>) {
        view.updateRecyclerView(list)
        view.hideLoading()
    }
}