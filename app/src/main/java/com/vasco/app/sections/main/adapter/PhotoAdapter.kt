package com.vasco.app.sections.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.vasco.app.R
import com.vasco.app.sections.main.model.Photo
import com.vasco.app.utils.inflate
import com.vasco.app.utils.loadUrl
import kotlinx.android.synthetic.main.item_photo.view.*
import org.jetbrains.anko.onClick

class PhotoAdapter(val photoListener: PhotoAdapterListener) : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    private val mPhotoList = arrayListOf<Photo>()

    fun setPhotoList(photo: Photo) {
        mPhotoList.add(photo)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.displayPhoto(mPhotoList[position])
    }

    override fun getItemCount(): Int {
        return mPhotoList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view: View = parent.inflate(R.layout.item_photo)
        val holder: PhotoViewHolder = PhotoViewHolder(view)
        holder.setPhotoAdapterListener(this.photoListener)
        return holder
    }

    class PhotoViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        private var mPhotoListener: PhotoAdapterListener? = null

        fun displayPhoto(photo: Photo) {
            with(photo) {
                itemView.tvPhotoTitle.text = photoTitle
                itemView.ivPhoto.loadUrl(urlImage)
                itemView.onClick { mPhotoListener?.onClick(urlImage) }
            }
        }

        fun setPhotoAdapterListener(photoListener: PhotoAdapterListener?) {
            mPhotoListener = photoListener
        }
    }

    interface PhotoAdapterListener {
        fun onClick(urlImage: String)
    }
}