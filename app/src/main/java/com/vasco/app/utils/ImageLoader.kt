package com.vasco.app.utils

import android.content.Context
import com.squareup.picasso.Picasso

object ImageLoader {

    fun loadUrl(context: Context): Picasso {
        return Picasso.with(context)
    }
}