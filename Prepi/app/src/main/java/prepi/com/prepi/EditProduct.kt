package prepi.com.prepi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_edit_product.*
import android.content.Intent




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

        publicar.setOnClickListener {
//            onBackPressed()
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
