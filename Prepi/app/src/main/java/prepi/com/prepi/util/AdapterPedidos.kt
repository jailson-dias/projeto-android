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
import android.content.Intent
import kotlinx.android.synthetic.main.pedido_item_product.view.*
import prepi.com.prepi.EditProduct
import prepi.com.prepi.Gallery


class AdapterPedidos(private val products: List<PedidoItem>, private val context: Context?): RecyclerView.Adapter<AdapterPedidos.ViewHolderPedidos>() {

    class ViewHolderPedidos(itemView: View): RecyclerView.ViewHolder(itemView) {
        // utilizado para referenciar os campos do layout, para assim poderem ser alterados em onBindViewHolder
        val title = itemView.title
        val size = itemView.size
        val picture = itemView.img
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPedidos {
        // utilizado para inflar o layout do itemlista para cada item da lista de RSSs
        val view = LayoutInflater.from(context).inflate(R.layout.pedido_item_product, parent, false)
        view.setOnClickListener {
            val intent = Intent(context, EditProduct::class.java)
            context?.startActivity(intent)
        }
        return ViewHolderPedidos(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolderPedidos, position: Int) {
        val product = products[position]
        holder.title.text = product.title

        holder.size.text = ("Tamanho: " + product.size)
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
//                e.printStackTrace()
                mIcon11 = null
            }

            return mIcon11
        }

        override fun onPostExecute(result: Bitmap?) {
            if (result != null) bmImage.setImageBitmap(result)
        }
    }
}