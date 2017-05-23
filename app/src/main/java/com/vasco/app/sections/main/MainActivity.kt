package com.vasco.app.sections.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.vasco.app.sections.main.model.Photo
import com.vasco.app.sections.main.adapter.PhotoAdapter
import com.vasco.app.R
import com.vasco.app.sections.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), PhotoAdapter.PhotoAdapterListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter: PhotoAdapter = PhotoAdapter(this)

        for (i in 1..10) {
            val photo: Photo = Photo(i, "photo $i", "http://lorempixel.com/1920/1920/abstract/$i")
            adapter.setPhotoList(photo)
        }

        rvPhotos.adapter = adapter
        rvPhotos.layoutManager = GridLayoutManager(this, 2)
    }

    override fun onClick(urlImage: String) {
        DetailActivity.startActivity(this, urlImage)
    }
}
