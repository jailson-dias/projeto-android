package prepi.com.prepi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.json.JSONArray
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import prepi.com.prepi.util.AdapterProduct
import prepi.com.prepi.util.ParseProduct
import prepi.com.prepi.util.ProductItem
import android.R.array
import android.support.v7.widget.LinearLayoutManager
import android.widget.EditText
import android.widget.LinearLayout


class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView? = null

    val products = "[\n" +
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
            "    },\n" +
            "    {\n" +
            "        \"_id\": \"5c069cf21dab7f002eb72356\",\n" +
            "        \"storeId\": \"5bbf6ef4a920c9004e3d1898\",\n" +
            "        \"name\": \"jdjdjd\",\n" +
            "        \"price\": 646.46,\n" +
            "        \"description\": \" \",\n" +
            "        \"feed\": false,\n" +
            "        \"stories\": true,\n" +
            "        \"sale\": false,\n" +
            "        \"validity\": true,\n" +
            "        \"version\": \"0.0.1\",\n" +
            "        \"insertionDate\": \"2018-12-04T15:27:46.608Z\",\n" +
            "        \"normalPrice\": 646.46,\n" +
            "        \"created\": \"2018-12-04T15:27:46.608Z\",\n" +
            "        \"updated\": \"2018-12-04T15:27:46.608Z\",\n" +
            "        \"__v\": 1,\n" +
            "        \"comments\": [],\n" +
            "        \"boughtBy\": [],\n" +
            "        \"buyOptions\": [\n" +
            "            {\n" +
            "                \"size\": \"M\",\n" +
            "                \"availability\": true,\n" +
            "                \"_id\": \"5c069cf21dab7f002eb72357\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"images\": [\n" +
            "            \"https://prepi-bucket.s3.sa-east-1.amazonaws.com/dstore/product-1543937266607-0.JPEG\"\n" +
            "        ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"_id\": \"5c069ca41dab7f002eb72352\",\n" +
            "        \"storeId\": \"5bbf6ef4a920c9004e3d1898\",\n" +
            "        \"name\": \"djjsjskdkd\",\n" +
            "        \"price\": 959.86,\n" +
            "        \"description\": \" \",\n" +
            "        \"feed\": false,\n" +
            "        \"stories\": true,\n" +
            "        \"sale\": false,\n" +
            "        \"validity\": true,\n" +
            "        \"version\": \"0.0.1\",\n" +
            "        \"insertionDate\": \"2018-12-04T15:26:28.105Z\",\n" +
            "        \"normalPrice\": 959.86,\n" +
            "        \"created\": \"2018-12-04T15:26:28.105Z\",\n" +
            "        \"updated\": \"2018-12-04T15:26:28.105Z\",\n" +
            "        \"__v\": 1,\n" +
            "        \"comments\": [],\n" +
            "        \"boughtBy\": [],\n" +
            "        \"buyOptions\": [\n" +
            "            {\n" +
            "                \"size\": \"M\",\n" +
            "                \"availability\": true,\n" +
            "                \"_id\": \"5c069ca41dab7f002eb72353\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"images\": [\n" +
            "            \"https://prepi-bucket.s3.sa-east-1.amazonaws.com/dstore/product-1543937188104-0.JPEG\"\n" +
            "        ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"_id\": \"5c069bca0b52ca002b6e8a8c\",\n" +
            "        \"storeId\": \"5bbf6ef4a920c9004e3d1898\",\n" +
            "        \"name\": \"bdjsjs\",\n" +
            "        \"price\": 97.94,\n" +
            "        \"description\": \" \",\n" +
            "        \"feed\": false,\n" +
            "        \"stories\": true,\n" +
            "        \"sale\": false,\n" +
            "        \"validity\": true,\n" +
            "        \"version\": \"0.0.1\",\n" +
            "        \"insertionDate\": \"2018-12-04T15:22:50.480Z\",\n" +
            "        \"normalPrice\": 97.94,\n" +
            "        \"created\": \"2018-12-04T15:22:50.480Z\",\n" +
            "        \"updated\": \"2018-12-04T15:22:50.480Z\",\n" +
            "        \"__v\": 1,\n" +
            "        \"comments\": [],\n" +
            "        \"boughtBy\": [],\n" +
            "        \"buyOptions\": [\n" +
            "            {\n" +
            "                \"size\": \"U\",\n" +
            "                \"availability\": true,\n" +
            "                \"_id\": \"5c069bca0b52ca002b6e8a8d\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"images\": [\n" +
            "            \"https://prepi-bucket.s3.sa-east-1.amazonaws.com/dstore/product-1543936970478-0.JPEG\"\n" +
            "        ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"_id\": \"5c05eb5f0b52ca002b6e8a8a\",\n" +
            "        \"storeId\": \"5bbf6ef4a920c9004e3d1898\",\n" +
            "        \"name\": \"hdjdj\",\n" +
            "        \"price\": 65.65,\n" +
            "        \"description\": \" \",\n" +
            "        \"feed\": false,\n" +
            "        \"stories\": true,\n" +
            "        \"sale\": false,\n" +
            "        \"validity\": true,\n" +
            "        \"version\": \"0.0.1\",\n" +
            "        \"insertionDate\": \"2018-12-04T02:50:07.536Z\",\n" +
            "        \"normalPrice\": 65.65,\n" +
            "        \"created\": \"2018-12-04T02:50:07.536Z\",\n" +
            "        \"updated\": \"2018-12-04T02:50:07.536Z\",\n" +
            "        \"__v\": 1,\n" +
            "        \"comments\": [],\n" +
            "        \"boughtBy\": [],\n" +
            "        \"buyOptions\": [\n" +
            "            {\n" +
            "                \"size\": \"PP\",\n" +
            "                \"availability\": true,\n" +
            "                \"_id\": \"5c05eb5f0b52ca002b6e8a8b\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"images\": [\n" +
            "            \"https://prepi-bucket.s3.sa-east-1.amazonaws.com/dstore/product-1543891807534-0.JPEG\"\n" +
            "        ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"_id\": \"5c05a2ca1dab7f002eb7234b\",\n" +
            "        \"storeId\": \"5bbf6ef4a920c9004e3d1898\",\n" +
            "        \"name\": \"dhufvuuvvu\",\n" +
            "        \"price\": 5.55,\n" +
            "        \"description\": \" \",\n" +
            "        \"feed\": false,\n" +
            "        \"stories\": true,\n" +
            "        \"sale\": false,\n" +
            "        \"validity\": true,\n" +
            "        \"version\": \"0.0.1\",\n" +
            "        \"insertionDate\": \"2018-12-03T21:40:26.230Z\",\n" +
            "        \"normalPrice\": 5.55,\n" +
            "        \"created\": \"2018-12-03T21:40:26.230Z\",\n" +
            "        \"updated\": \"2018-12-03T21:40:26.230Z\",\n" +
            "        \"__v\": 1,\n" +
            "        \"comments\": [],\n" +
            "        \"boughtBy\": [],\n" +
            "        \"buyOptions\": [\n" +
            "            {\n" +
            "                \"size\": \"P\",\n" +
            "                \"availability\": true,\n" +
            "                \"_id\": \"5c05a2ca1dab7f002eb7234c\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"images\": [\n" +
            "            \"https://prepi-bucket.s3.sa-east-1.amazonaws.com/dstore/product-1543873226227-0.JPEG\"\n" +
            "        ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"_id\": \"5c05a1031dab7f002eb72349\",\n" +
            "        \"storeId\": \"5bbf6ef4a920c9004e3d1898\",\n" +
            "        \"name\": \"hdhshd\",\n" +
            "        \"price\": 7.55,\n" +
            "        \"description\": \" \",\n" +
            "        \"feed\": false,\n" +
            "        \"stories\": true,\n" +
            "        \"sale\": false,\n" +
            "        \"validity\": true,\n" +
            "        \"version\": \"0.0.1\",\n" +
            "        \"insertionDate\": \"2018-12-03T21:32:51.806Z\",\n" +
            "        \"normalPrice\": 7.55,\n" +
            "        \"created\": \"2018-12-03T21:32:51.806Z\",\n" +
            "        \"updated\": \"2018-12-03T21:32:51.806Z\",\n" +
            "        \"__v\": 1,\n" +
            "        \"comments\": [],\n" +
            "        \"boughtBy\": [],\n" +
            "        \"buyOptions\": [\n" +
            "            {\n" +
            "                \"size\": \"G\",\n" +
            "                \"availability\": true,\n" +
            "                \"_id\": \"5c05a1031dab7f002eb7234a\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"images\": [\n" +
            "            \"https://prepi-bucket.s3.sa-east-1.amazonaws.com/dstore/product-1543872771804-0.JPEG\"\n" +
            "        ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"_id\": \"5c059f510b52ca002b6e8a88\",\n" +
            "        \"storeId\": \"5bbf6ef4a920c9004e3d1898\",\n" +
            "        \"name\": \"hdhdjj\",\n" +
            "        \"price\": 8.75,\n" +
            "        \"description\": \" \",\n" +
            "        \"feed\": false,\n" +
            "        \"stories\": true,\n" +
            "        \"sale\": false,\n" +
            "        \"validity\": true,\n" +
            "        \"version\": \"0.0.1\",\n" +
            "        \"insertionDate\": \"2018-12-03T21:25:37.515Z\",\n" +
            "        \"normalPrice\": 8.75,\n" +
            "        \"created\": \"2018-12-03T21:25:37.515Z\",\n" +
            "        \"updated\": \"2018-12-03T21:25:37.515Z\",\n" +
            "        \"__v\": 1,\n" +
            "        \"comments\": [],\n" +
            "        \"boughtBy\": [],\n" +
            "        \"buyOptions\": [\n" +
            "            {\n" +
            "                \"size\": \"M\",\n" +
            "                \"availability\": true,\n" +
            "                \"_id\": \"5c059f510b52ca002b6e8a89\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"images\": [\n" +
            "            \"https://prepi-bucket.s3.sa-east-1.amazonaws.com/dstore/product-1543872337513-0.JPEG\"\n" +
            "        ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"_id\": \"5c059e5a0b52ca002b6e8a86\",\n" +
            "        \"storeId\": \"5bbf6ef4a920c9004e3d1898\",\n" +
            "        \"name\": \"fhfhjf\",\n" +
            "        \"price\": 5.55,\n" +
            "        \"description\": \" \",\n" +
            "        \"feed\": false,\n" +
            "        \"stories\": true,\n" +
            "        \"sale\": false,\n" +
            "        \"validity\": true,\n" +
            "        \"version\": \"0.0.1\",\n" +
            "        \"insertionDate\": \"2018-12-03T21:21:30.141Z\",\n" +
            "        \"normalPrice\": 5.55,\n" +
            "        \"created\": \"2018-12-03T21:21:30.141Z\",\n" +
            "        \"updated\": \"2018-12-03T21:21:30.141Z\",\n" +
            "        \"__v\": 1,\n" +
            "        \"comments\": [],\n" +
            "        \"boughtBy\": [],\n" +
            "        \"buyOptions\": [\n" +
            "            {\n" +
            "                \"size\": \"GG\",\n" +
            "                \"availability\": true,\n" +
            "                \"_id\": \"5c059e5a0b52ca002b6e8a87\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"images\": [\n" +
            "            \"https://prepi-bucket.s3.sa-east-1.amazonaws.com/dstore/product-1543872090139-0.JPEG\"\n" +
            "        ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"_id\": \"5c059ae70b52ca002b6e8a84\",\n" +
            "        \"storeId\": \"5bbf6ef4a920c9004e3d1898\",\n" +
            "        \"name\": \"vermelho \",\n" +
            "        \"price\": 5.45,\n" +
            "        \"description\": \" \",\n" +
            "        \"feed\": false,\n" +
            "        \"stories\": true,\n" +
            "        \"sale\": false,\n" +
            "        \"validity\": true,\n" +
            "        \"version\": \"0.0.1\",\n" +
            "        \"insertionDate\": \"2018-12-03T21:06:47.935Z\",\n" +
            "        \"normalPrice\": 5.45,\n" +
            "        \"created\": \"2018-12-03T21:06:47.935Z\",\n" +
            "        \"updated\": \"2018-12-03T21:06:47.935Z\",\n" +
            "        \"__v\": 1,\n" +
            "        \"comments\": [],\n" +
            "        \"boughtBy\": [],\n" +
            "        \"buyOptions\": [\n" +
            "            {\n" +
            "                \"size\": \"G\",\n" +
            "                \"availability\": true,\n" +
            "                \"_id\": \"5c059ae70b52ca002b6e8a85\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"images\": [\n" +
            "            \"https://prepi-bucket.s3.sa-east-1.amazonaws.com/dstore/product-1543871207933-0.JPEG\"\n" +
            "        ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"_id\": \"5c0599c10b52ca002b6e8a82\",\n" +
            "        \"storeId\": \"5bbf6ef4a920c9004e3d1898\",\n" +
            "        \"name\": \"senhor filho\",\n" +
            "        \"price\": 8.55,\n" +
            "        \"description\": \" \",\n" +
            "        \"feed\": false,\n" +
            "        \"stories\": true,\n" +
            "        \"sale\": false,\n" +
            "        \"validity\": true,\n" +
            "        \"version\": \"0.0.1\",\n" +
            "        \"insertionDate\": \"2018-12-03T21:01:53.436Z\",\n" +
            "        \"normalPrice\": 8.55,\n" +
            "        \"created\": \"2018-12-03T21:01:53.436Z\",\n" +
            "        \"updated\": \"2018-12-03T21:01:53.436Z\",\n" +
            "        \"__v\": 1,\n" +
            "        \"comments\": [],\n" +
            "        \"boughtBy\": [],\n" +
            "        \"buyOptions\": [\n" +
            "            {\n" +
            "                \"size\": \"M\",\n" +
            "                \"availability\": true,\n" +
            "                \"_id\": \"5c0599c10b52ca002b6e8a83\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"images\": [\n" +
            "            \"https://prepi-bucket.s3.sa-east-1.amazonaws.com/dstore/product-1543870913435-0.JPEG\"\n" +
            "        ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"_id\": \"5c0598b90b52ca002b6e8a80\",\n" +
            "        \"storeId\": \"5bbf6ef4a920c9004e3d1898\",\n" +
            "        \"name\": \"teste 6\",\n" +
            "        \"price\": 5.55,\n" +
            "        \"description\": \" \",\n" +
            "        \"feed\": false,\n" +
            "        \"stories\": true,\n" +
            "        \"sale\": false,\n" +
            "        \"validity\": true,\n" +
            "        \"version\": \"0.0.1\",\n" +
            "        \"insertionDate\": \"2018-12-03T20:57:29.210Z\",\n" +
            "        \"normalPrice\": 5.55,\n" +
            "        \"created\": \"2018-12-03T20:57:29.210Z\",\n" +
            "        \"updated\": \"2018-12-03T20:57:29.210Z\",\n" +
            "        \"__v\": 1,\n" +
            "        \"comments\": [],\n" +
            "        \"boughtBy\": [],\n" +
            "        \"buyOptions\": [\n" +
            "            {\n" +
            "                \"size\": \"M\",\n" +
            "                \"availability\": true,\n" +
            "                \"_id\": \"5c0598b90b52ca002b6e8a81\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"images\": [\n" +
            "            \"https://prepi-bucket.s3.sa-east-1.amazonaws.com/dstore/product-1543870649208-0.JPEG\"\n" +
            "        ]\n" +
            "    }]"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val prods = ParseProduct(products).getListProducts()
        Log.i("Prepiappp", prods.get(12).title)
        val mLayoutManager = GridLayoutManager(this, 2)
        recyclerView?.setLayoutManager(mLayoutManager)
        recyclerView?.setHasFixedSize(true)
        recyclerView?.adapter= AdapterProduct(prods, this)

        recyclerProducts.apply {
            // colocando para o recycle view utilizar o layout do linearlayoutmanager
//            layoutManager = LinearLayoutManager(applicationContext)
//            adapter = AdapterProduct(prods, applicationContext)
            layoutManager = GridLayoutManager(applicationContext, 2)
            adapter = AdapterProduct(prods, applicationContext)
        }
    }
}
