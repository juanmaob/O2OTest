package com.seventhson.o2otest.ui.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.seventhson.o2otest.R
import com.seventhson.o2otest.data.pojos.Recipe
import com.seventhson.o2otest.ui.common.BaseActivity
import com.seventhson.o2otest.ui.common.Navigator
import com.seventhson.o2otest.ui.main.adapter.RecipeAdapter
import com.seventhson.o2otest.ui.main.di.MainModule
import com.seventhson.o2otest.utils.hide
import com.seventhson.o2otest.utils.show
import com.seventhson.o2otest.utils.toast
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var presenter: MainPresenter

    private lateinit var adapter: RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getApplicationComponent().plus(MainModule(this)).inject(this)
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

    fun initView() {
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

    fun setUpRecyclerView() {
        adapter = RecipeAdapter(mutableListOf()) { recipe, imageView ->  goToDetailActivity(recipe, imageView)}
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
