package com.seventhson.o2otest.ui.main


import com.seventhson.o2otest.domain.model.Recipe
import com.seventhson.o2otest.ui.common.BaseView

/**
 * Created by Juanma Osuna on 4/04/19
 */
interface MainView: BaseView {
    fun updateRecyclerView(list: List<Recipe>)
}