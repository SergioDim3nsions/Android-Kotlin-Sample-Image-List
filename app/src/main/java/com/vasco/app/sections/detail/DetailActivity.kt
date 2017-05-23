package com.vasco.app.sections.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import com.vasco.app.R
import com.vasco.app.utils.IMAGE_SIZE_LARGE
import com.vasco.app.utils.loadUrl
import kotlinx.android.synthetic.main.activity_detail.*

const val KEY_URL: String = "KEY_URL"

class DetailActivity : AppCompatActivity() {

    companion object {
        fun startActivity(parent: Activity, url: String) {
            val intent = Intent(parent, DetailActivity::class.java)
            intent.putExtra(KEY_URL, url)
            val options: ActivityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(parent)
            parent.startActivity(intent, options.toBundle())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        ivPhotoDetail.loadUrl(intent.getStringExtra(KEY_URL), IMAGE_SIZE_LARGE, IMAGE_SIZE_LARGE)
    }
}
