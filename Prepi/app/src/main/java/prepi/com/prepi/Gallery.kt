package prepi.com.prepi

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.ActionBar
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_gallery.*
import prepi.com.prepi.util.GalleryPhotoAdapter

class Gallery : AppCompatActivity(), SharedPreferences.OnSharedPreferenceChangeListener {
    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
//        Log.i("prepiapp share", key)
        val uri = sharedPreferences?.getString(key, "")
        img_selected.setImageURI(Uri.parse(uri))
    }

    val PERMISSION = 10

    lateinit var toolbar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        setSupportActionBar(toolbar_gallery)
        toolbar = supportActionBar!!
        toolbar.title = "Fotos"

        toolbar.setDisplayShowHomeEnabled(true)
        toolbar.setDisplayHomeAsUpEnabled(true)
        toolbar_gallery.setNavigationOnClickListener {
            onBackPressed()
        }

        proximo.setOnClickListener {
            val intent = Intent(applicationContext, EditProduct::class.java)
            applicationContext?.startActivity(intent)
        }

        val sharedPreferences = getSharedPreferences("Prepi", Context.MODE_PRIVATE)
        val photo = sharedPreferences!!.getString("photo", "")
        sharedPreferences.registerOnSharedPreferenceChangeListener(this)

        Log.i("Prepiappp", "foto: "+ photo)

        if (ContextCompat.checkSelfPermission(
                applicationContext,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                listOf(Manifest.permission.READ_EXTERNAL_STORAGE).toTypedArray(),
                PERMISSION);
        } else {

            val images = getAllShownImagesPath(applicationContext)

            val settings: SharedPreferences? = getSharedPreferences("Prepi", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor? = settings?.edit()
            editor?.putString("photo", images.get(0))
            editor?.apply()

            recyclerPhotos.apply {
                //         colocando para o recycle view utilizar o layout do linearlayoutmanager
                layoutManager = GridLayoutManager(applicationContext, 3)
                adapter = GalleryPhotoAdapter(images.toList(), applicationContext)
            }
//            Log.i("Prepiappp", getAllShownImagesPath(applicationContext)[0])

        }
    }

    private fun getAllShownImagesPath(context: Context): ArrayList<String> {
        val uri: Uri
        val cursor: Cursor?
        val column_index_data: Int
        Log.i("Prepiappp", "Chegou aqui")
        val column_index_folder_name: Int
        val listOfAllImages = ArrayList<String>()
        var absolutePathOfImage: String? = null
        uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        Log.i("Prepiappp", "Chegou aqui 1")

        val projection = arrayOf(MediaStore.MediaColumns.DATA, MediaStore.Images.Media.BUCKET_DISPLAY_NAME)

        cursor = context.contentResolver.query(uri, projection, null, null, null)

        Log.i("Prepiappp", "Chegou aqui 2")
        column_index_data = cursor!!.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA)
        column_index_folder_name = cursor
            .getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME)
        while (cursor.moveToNext()) {
            absolutePathOfImage = cursor.getString(column_index_data)

            listOfAllImages.add(absolutePathOfImage)
        }
        Log.i("Prepiappp", "Chegou aqui 3")
        return listOfAllImages
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSION -> {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.


                    Log.i("Prepiappp", getAllShownImagesPath(applicationContext)[0])
                } else {

                    Toast.makeText(applicationContext, "Permissão não aceita", Toast.LENGTH_LONG).show()
                }
                return
            }
        }
    }
}
