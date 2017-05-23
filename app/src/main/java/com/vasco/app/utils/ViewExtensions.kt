package com.vasco.app.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast

const val DEFAULT_IMAGE_SIZE = 400
const val IMAGE_SIZE_LARGE = 400

fun Context.toast(text: CharSequence) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun ViewGroup.inflate(layout: Int): View {
    return LayoutInflater.from(context).inflate(layout, this, false)
}

fun ImageView.loadUrl(url: String, width: Int = DEFAULT_IMAGE_SIZE, height: Int = DEFAULT_IMAGE_SIZE) {
    ImageLoader.loadUrl(context).load(url).resize(width, height).into(this)
}


