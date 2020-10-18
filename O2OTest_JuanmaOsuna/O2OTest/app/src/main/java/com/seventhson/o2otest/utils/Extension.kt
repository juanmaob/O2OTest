package com.seventhson.o2otest.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import com.seventhson.o2otest.R
import com.squareup.picasso.Picasso

/**
 * Created by Juanma Osuna on 5/04/19
 */

fun Context.toast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun ImageView.fromUrl(url: String) {
    if(url.isNotEmpty())
        Picasso.get().load(url).placeholder(R.drawable.ic_android_green).into(this)
}

fun ProgressBar.show(){
    if(this.visibility == View.GONE)
        this.visibility = View.VISIBLE
}

fun ProgressBar.hide(){
    if(this.visibility == View.VISIBLE)
        this.visibility = View.GONE
}
