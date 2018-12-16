package prepi.com.prepi.components

import android.content.Context
import android.net.Uri
import android.support.annotation.StyleableRes
import android.support.v7.widget.AppCompatSpinner
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.horizontal_select_button.view.*
import org.w3c.dom.Text
import prepi.com.prepi.R

class PedidoItemProduct(context: Context?, attrs: AttributeSet?) :
    LinearLayout(context, attrs) {

    @StyleableRes
    internal var img = 0
    @StyleableRes
    internal var title = 1
    @StyleableRes
    internal var size = 2
    @StyleableRes
    internal var selected = 3

    internal var imgProduct: ImageView? = null
    internal var titleTextView: TextView? = null
    internal var sizeTextView: TextView? = null
    internal var yesButton: Button? = null
    internal var noButton: Button? = null

    init {
        init(context, attrs)
    }

    private fun init(context: Context?, attrs: AttributeSet?) {
        View.inflate(context, R.layout.pedido_item_product, this)

//        Log.i("Prepiappp", attrs.toString())
        val sets = intArrayOf(
            R.attr.image,
            R.attr.title,
            R.attr.size,
            R.attr.selected
        )
        val typedArray = context?.obtainStyledAttributes(attrs, sets)
//        Log.i("Prepiappp", " valor do type array ")
        val imageUrl = typedArray?.getText(img)
        val titleText = typedArray?.getText(title)
        val sizeText = typedArray?.getText(size)
//        val selectedAction = typedArray?.getText(selected)
        typedArray?.recycle()

        initComponents()

        setTitle(titleText)
        setSize(sizeText)
        setImage(imageUrl)
    }

    private fun initComponents() {
        imgProduct = findViewById(R.id.img) as ImageView
        titleTextView = findViewById(R.id.title) as TextView
        sizeTextView = findViewById(R.id.size) as TextView
    }

//    fun getTitle(): CharSequence {
//        return labelTextView!!.text
//    }

    fun setTitle(value: CharSequence?) {
        if (value != null) {
            titleTextView?.text = value
        }
    }

    fun setSize(value: CharSequence?) {
        if (value != null) {
            sizeTextView?.text = "Tamanho: "+ value
        }
    }

    fun setImage(value: CharSequence?) {
        if (value != null) {
            imgProduct?.setImageURI(Uri.parse(value.toString()))
        }
    }
}