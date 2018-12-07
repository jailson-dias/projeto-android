package prepi.com.prepi

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.support.annotation.StyleableRes
import android.widget.Button


/**
 * TODO: document your custom view class.
 */
//class ProductCard(context: Context?) : LinearLayout(context) {
//
//}

class ProductCard(context: Context?, attrs: AttributeSet?) :
    LinearLayout(context, attrs) {

    @StyleableRes
    internal var index0 = 0
    @StyleableRes
    internal var index1 = 1
    @StyleableRes
    internal var index2 = 2

    internal var artistText: TextView? = null
    internal var trackText: TextView? = null
    internal var buyButton: Button? = null

//    var button: CharSequence
//        get() = buyButton!!.getText()
//        set(value) {
//            buyButton!!.setText(value)
//        }

    init {
        if (context != null && attrs != null) {
            init(context, attrs)
        }
    }

    private fun init(context: Context, attrs: AttributeSet) {
        View.inflate(context, R.layout.sample_product_card, this)

        val sets = intArrayOf(R.attr.artistText, R.attr.trackText, R.attr.buyButton)
        val typedArray = context.obtainStyledAttributes(attrs, sets)
        val artist = typedArray.getText(index0)
        val track = typedArray.getText(index1)
        val buyButton = typedArray.getText(index2)
        typedArray.recycle()

        initComponents()

        setArtistText(artist)
        setTrackText(track)
        setButton(buyButton)
    }

    private fun initComponents() {
        artistText = findViewById(R.id.artist_Text) as TextView

        trackText = findViewById(R.id.track_Text) as TextView

        buyButton = findViewById(R.id.buy_Button) as Button
    }


    fun getButton(): CharSequence {
        return buyButton!!.text
    }

    fun setButton(value: CharSequence) {
        buyButton?.text = value
    }


    fun getArtistText(): CharSequence {
        return artistText!!.text
    }

    fun setArtistText(value: CharSequence) {
        artistText?.text = value
    }

    fun getTrackText(): CharSequence {
        return trackText!!.text
    }

    fun setTrackText(value: CharSequence) {
        trackText?.text = value
    }
}
