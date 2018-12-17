package prepi.com.prepi.util

import android.net.Uri
import android.util.Log
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception

class ParsePedidos(val products: String) {

    fun getJSONArray(): JSONArray {
        return JSONArray(products)
    }

    fun getListPedidos(): List<PedidoItem> {
        val prods: MutableList<PedidoItem> = mutableListOf()
        try {
            val productsJSON = JSONArray(products)
            Log.i("Prepiappp", ""+ productsJSON.length())
            for ( i in 0..(productsJSON.length() - 1) ) {
                Log.i("prepiapp", "1")
                val item = JSONObject(productsJSON.get(i).toString())
                Log.i("prepiapp", "2")
                val id = item.get("_id").toString()
                val option = JSONObject(JSONArray(item.get("customerOptions").toString()).get(0).toString())
                Log.i("prepiapp", "3")
                val product = JSONObject(option.get("product").toString())
                Log.i("prepiapp", "4")

//                Log.i("prepiappppp", product.get("name").toString())
//                Log.i("prepiappppp", JSONArray(product.get("images").toString()).get(0).toString())
//                Log.i("prepiappppp", option.get("size").toString())
//
//                val title = item.get("name").toString()
//                val picture = item.get("images").toString()
//                val pic = JSONArray(picture)

                prods.add(PedidoItem(product.get("name").toString(),option.get("size").toString(),
                    JSONArray(product.get("images").toString()).get(0).toString(), id))
            }

        } catch (err: Exception) {
            Log.e("Prepiappp","Erro na conversão da string para lista de produtos " + err.toString())
//            return prods
        }
        return prods
    }
}