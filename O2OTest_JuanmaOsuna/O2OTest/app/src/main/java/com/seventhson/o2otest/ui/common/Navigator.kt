package com.seventhson.o2otest.ui.common

import android.content.Context
import android.content.Intent
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import com.seventhson.o2otest.domain.model.Recipe
import com.seventhson.o2otest.ui.detail.DetailActivity
import com.seventhson.o2otest.ui.detail.DetailActivity.Companion.RECIPE

/**
 * Created by Juanma Osuna on 4/04/19
 */
class Navigator {

    fun navigate(context: Context, intent: Intent?, options: ActivityOptionsCompat) {
        (context as BaseActivity).startActivity(intent, options.toBundle())
    }

    fun goToDetail(context: Context, recipe: Recipe, image: ImageView) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(RECIPE, recipe)
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(context as BaseActivity, image, "detailTransition")
        navigate(context, intent, options)
    }

}