package prepi.com.prepi.util

import android.net.Uri

class ProductItem(val title: String, val id: String, val value: Number, val picture: String) {

    override fun toString(): String {
        return title
    }
}