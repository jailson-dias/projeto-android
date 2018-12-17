package prepi.com.prepi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_edit_product.*
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.R.attr.path
import android.content.Context
import android.net.Uri
import android.support.v4.content.FileProvider
import java.io.File


class EditProduct : AppCompatActivity() {

    lateinit var toolbar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_product)


        setSupportActionBar(toolbar_edit)
        toolbar = supportActionBar!!
        toolbar.title = "Produto"


        toolbar.setDisplayShowHomeEnabled(true)
        toolbar.setDisplayHomeAsUpEnabled(true)
        toolbar_edit.setNavigationOnClickListener {
            onBackPressed()
        }

        val postar = intent.getBooleanExtra("postar", false)

        if (postar) {
            val sharedPreferences = getSharedPreferences("Prepi", Context.MODE_PRIVATE)
            val photo = sharedPreferences!!.getString("photo", "")
            product_photo.setImageURI(Uri.parse(photo))
        }
        publicar.setOnClickListener {
//            onBackPressed()
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)

            if (postar) {
                val sharedPreferences = getSharedPreferences("Prepi", Context.MODE_PRIVATE)
                val photo = sharedPreferences!!.getString("photo", "")
//                product_photo.setImageURI(Uri.parse(photo))
                shareStories("file://" + photo)
            }
        }
    }

    fun shareStories(path: String?) {

        if (path != null) {
            val context = applicationContext.getApplicationContext()
            val uri = FileProvider.getUriForFile(context, "com.prepiapp.fileprovider", File(path.split("file:/")[1]))

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "image/*"
            intent.putExtra(Intent.EXTRA_STREAM, uri)
            intent.setClassName(
                "com.instagram.android",
                "com.instagram.share.handleractivity.StoryShareHandlerActivity"
            )

            context.startActivity(intent)
        }
    }
}
