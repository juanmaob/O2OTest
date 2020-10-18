package com.seventhson.o2otest.ui.main

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.seventhson.o2otest.R
import com.seventhson.o2otest.domain.model.Recipe
import com.seventhson.o2otest.ui.common.BaseActivity
import com.seventhson.o2otest.ui.common.Navigator
import com.seventhson.o2otest.ui.main.adapter.RecipeAdapter
import com.seventhson.o2otest.utils.hide
import com.seventhson.o2otest.utils.show
import com.seventhson.o2otest.utils.toast
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {
    override fun context(): Context {
        return this
    }

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var presenter: MainPresenter

    private lateinit var adapter: RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attachView(this)
        initView()
        showLoading()
        presenter.onGetRecipeList("")
    }

    override fun updateRecyclerView(list: List<Recipe>) {
        adapter.addAll(list)
    }

    override fun showLoading() {
        pbSpinner.show()
    }

    override fun hideLoading() {
        pbSpinner.hide()
    }

    override fun showConnectionError() {
        toast(getString(R.string.connection_error))
    }

    override fun showDefaultError() {
        toast(getString(R.string.generic_error))
    }

    override fun showApiError(msg: String) {
        toast(msg)
    }

    private fun initView() {
        setUpToolbar()
        setUpRecyclerView()
        setUpSearch()
    }

    private fun setUpSearch() {
        etSearch.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                presenter.onGetRecipeList(s.toString())
            }
        })
    }

    private fun setUpRecyclerView() {
        adapter = RecipeAdapter(mutableListOf()) { recipe, imageView -> goToDetailActivity(recipe, imageView)}
        rvRecipes.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvRecipes.setHasFixedSize(true)
        rvRecipes.adapter = adapter
    }

    fun setUpToolbar() {
        setSupportActionBar(toolbar)
    }

    fun goToDetailActivity(recipe: Recipe, imageView: ImageView) {
        navigator.goToDetail(this, recipe, imageView)
    }

}
