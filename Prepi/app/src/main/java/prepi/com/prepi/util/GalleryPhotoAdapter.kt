package prepi.com.prepi.util

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import prepi.com.prepi.R
import kotlinx.android.synthetic.main.gallery_photo_item.view.*
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy


class GalleryPhotoAdapter (private val products: List<String>, private val context: Context?): RecyclerView.Adapter<GalleryPhotoAdapter.ViewHolderGalleryPhoto>() {

//    var data: List<String> = ArrayList()

    class ViewHolderGalleryPhoto(itemView: View): RecyclerView.ViewHolder(itemView) {
        // utilizado para referenciar os campos do layout, para assim poderem ser alterados em onBindViewHolder
        val photo = itemView.photo
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGalleryPhoto {
        // utilizado para inflar o layout do itemlista para cada item da lista de RSSs
        val view = LayoutInflater.from(context).inflate(R.layout.gallery_photo_item, parent, false)
        return ViewHolderGalleryPhoto(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolderGalleryPhoto, position: Int) {
//        Glide.with(context).load(data[position])
//            .thumbnail(0.5f)
//            .override(200, 200)
//            .crossFade()
//            .diskCacheStrategy(DiskCacheStrategy.ALL)
//            .into((holder).photo)

        Glide.with(context).load(products.get(position))
//            .placeholder(R.drawable.ic_launcher)
            .centerCrop()
            .into(holder.photo)

        holder.photo.setOnClickListener {
            val settings: SharedPreferences? = context?.getSharedPreferences("Prepi", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor? = settings?.edit()
            editor?.putString("photo", products.get(position))
            editor?.apply()
        }

    }
}