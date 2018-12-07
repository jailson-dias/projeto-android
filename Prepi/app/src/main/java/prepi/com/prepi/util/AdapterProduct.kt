package prepi.com.prepi.util

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.card_product.view.*
import prepi.com.prepi.R
import java.math.RoundingMode
import java.text.DecimalFormat
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.ImageView


class AdapterProduct (private val products: List<ProductItem>, private val context: Context): RecyclerView.Adapter<AdapterProduct.ViewHolderProduct>() {

    class ViewHolderProduct(itemView: View): RecyclerView.ViewHolder(itemView) {
        // utilizado para referenciar os campos do layout, para assim poderem ser alterados em onBindViewHolder
        val title = itemView.product_name
        val price = itemView.product_price
        val picture = itemView.product_picture
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderProduct {
        // utilizado para inflar o layout do itemlista para cada item da lista de RSSs
        val view = LayoutInflater.from(context).inflate(R.layout.card_product, parent, false)
        return ViewHolderProduct(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolderProduct, position: Int) {
        val product = products[position]
        holder.title.text = product.title

        Log.i("Prepiappp", product.title)
        val formatNumber = DecimalFormat("R$ #,##")
        formatNumber.roundingMode = RoundingMode.CEILING

        holder.price.text = formatNumber.format(product.value)
//        holder.picture
        DownloadImageTask(holder.picture).execute(product.picture)
    }

    private inner class DownloadImageTask(internal var bmImage: ImageView) : AsyncTask<String, Void, Bitmap>() {

        override fun doInBackground(vararg urls: String): Bitmap? {
            val urldisplay = urls[0]
            var mIcon11: Bitmap? = null
            try {
                val `in` = java.net.URL(urldisplay).openStream()
                mIcon11 = BitmapFactory.decodeStream(`in`)
            } catch (e: Exception) {
                Log.e("Error", e.message)
                e.printStackTrace()
            }

            return mIcon11
        }

        override fun onPostExecute(result: Bitmap) {
            bmImage.setImageBitmap(result)
        }
    }
}