package prepi.com.prepi


import android.os.Bundle
import android.provider.SyncStateContract
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.fragment_pedidos.*
import prepi.com.prepi.util.AdapterPedidos
import prepi.com.prepi.util.ParsePedidos


class Pedidos : Fragment() {

    val pedidosList = "[\n" +
            "    {\n" +
            "        \"_id\": \"5c06ad120b52ca002b6e8a90\",\n" +
            "        \"storeId\": \"5bbf6ef4a920c9004e3d1898\",\n" +
            "        \"name\": \"fkucuvvuv\",\n" +
            "        \"price\": 6886.86,\n" +
            "        \"description\": \" \",\n" +
            "        \"feed\": false,\n" +
            "        \"stories\": true,\n" +
            "        \"sale\": false,\n" +
            "        \"validity\": true,\n" +
            "        \"version\": \"0.0.1\",\n" +
            "        \"insertionDate\": \"2018-12-04T16:36:34.958Z\",\n" +
            "        \"normalPrice\": 6886.86,\n" +
            "        \"created\": \"2018-12-04T16:36:34.958Z\",\n" +
            "        \"updated\": \"2018-12-04T16:36:34.958Z\",\n" +
            "        \"__v\": 1,\n" +
            "        \"comments\": [],\n" +
            "        \"size\": \"P\",\n" +
            "        \"boughtBy\": [],\n" +
            "        \"buyOptions\": [\n" +
            "            {\n" +
            "                \"size\": \"M\",\n" +
            "                \"availability\": true,\n" +
            "                \"_id\": \"5c06ad120b52ca002b6e8a91\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"images\": [\n" +
            "            \"https://prepi-bucket.s3.sa-east-1.amazonaws.com/dstore/product-1543941394956-0.JPEG\"\n" +
            "        ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"_id\": \"5c06ac681dab7f002eb7235f\",\n" +
            "        \"storeId\": \"5bbf6ef4a920c9004e3d1898\",\n" +
            "        \"name\": \"teste\",\n" +
            "        \"price\": 889.79,\n" +
            "        \"description\": \" \",\n" +
            "        \"feed\": false,\n" +
            "        \"stories\": true,\n" +
            "        \"sale\": false,\n" +
            "        \"validity\": true,\n" +
            "        \"version\": \"0.0.1\",\n" +
            "        \"insertionDate\": \"2018-12-04T16:33:44.986Z\",\n" +
            "        \"normalPrice\": 889.79,\n" +
            "        \"created\": \"2018-12-04T16:33:44.986Z\",\n" +
            "        \"updated\": \"2018-12-04T16:33:44.986Z\",\n" +
            "        \"__v\": 1,\n" +
            "        \"comments\": [],\n" +
            "        \"boughtBy\": [],\n" +
            "        \"size\": \"P\",\n" +
            "        \"buyOptions\": [\n" +
            "            {\n" +
            "                \"size\": \"M\",\n" +
            "                \"availability\": true,\n" +
            "                \"_id\": \"5c06ac681dab7f002eb72360\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"images\": [\n" +
            "            \"https://prepi-bucket.s3.sa-east-1.amazonaws.com/dstore/product-1543941224984-0.JPEG\"\n" +
            "        ]\n" +
            "    }]"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pedidos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val prods = ParsePedidos(pedidosList).getListPedidos()

//        Log.i("Prepiappp", "" + prods.size)

//        recyclerPedidos.apply {
//            //         colocando para o recycle view utilizar o layout do linearlayoutmanager
//            layoutManager = GridLayoutManager(activity?.applicationContext, 1)
//            adapter = AdapterPedidos(prods, activity?.applicationContext)
//        }

        requestProducts()

    }


    fun requestProducts() {
        val queue = Volley.newRequestQueue(context)
        val url = getString(R.string.serve) + "/stores/orders/" + getString(R.string.store_id)

            val stringRequest = object: StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                val prods = ParsePedidos(response).getListPedidos()

                Log.i("Prepiappp", "pedidos qunt" + prods.size)

                recyclerPedidos.apply {
                    //         colocando para o recycle view utilizar o layout do linearlayoutmanager
                    layoutManager = GridLayoutManager(activity?.applicationContext, 1)
                    adapter = AdapterPedidos(prods, activity?.applicationContext)
                }
            },
            Response.ErrorListener {
                Toast.makeText(context, "Erro em pegar os pedidos do servidor", Toast.LENGTH_SHORT).show()
            }) {
                override fun getHeaders(): MutableMap<String, String> {
                    val headers = HashMap<String, String>()
                    headers["jwt-token"] = getString(R.string.token)
                    return headers
                }
        }

// Add the request to the RequestQueue.
        queue.add(stringRequest)
    }


    companion object {
        fun newInstance(): Pedidos = Pedidos()
    }

}
