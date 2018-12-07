package prepi.com.prepi.util

import android.net.Uri
import android.util.Log
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception

class ParseProduct(val products: String) {

    fun getJSONArray(): JSONArray {
        return JSONArray(products)
    }

    fun getListProducts(): List<ProductItem> {
        val prods: MutableList<ProductItem> = mutableListOf()
        try {
            val productsJSON = JSONArray(products)
            Log.i("Prepiappp", ""+ productsJSON.length())
            for ( i in 0..(productsJSON.length() - 1) ) {
                val item = JSONObject(productsJSON.get(i).toString())
                val title = item.get("name").toString()
                val id = item.get("_id").toString()
                val price = item.get("price").toString()
                val picture = item.get("images").toString()
                val pic = JSONArray(picture)
                var priceDouble = price.toDoubleOrNull()
                if (priceDouble == null) {
                    priceDouble = 0.0
                }
                prods.add(ProductItem(title,id, priceDouble, pic.get(0).toString()))
            }

        } catch (err: Exception) {
            Log.e("Prepiappp","Erro na conversão da string para lista de produtos " + err.toString())
            return emptyList()
        }
        return prods
    }
}