package com.seventhson.o2otest.ui.detail

import android.os.Bundle
import com.seventhson.o2otest.R
import com.seventhson.o2otest.data.pojos.Recipe
import com.seventhson.o2otest.ui.common.BaseActivity
import com.seventhson.o2otest.utils.fromUrl
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*

class DetailActivity : BaseActivity() {

    companion object {
        const val RECIPE: String = "RECIPE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)

        val recipe: Recipe = intent.getSerializableExtra(RECIPE) as Recipe

        initView(recipe)

    }

    private fun initView(recipe: Recipe) {
        ivDetail.fromUrl(recipe.thumbnail)
        tvDetailTitle.text = recipe.title
        tvIngredientValue.text = recipe.ingredients
        tvWebRefValue.text = recipe.href
    }
}
