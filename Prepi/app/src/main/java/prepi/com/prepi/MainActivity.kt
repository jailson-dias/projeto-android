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
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.support.v7.widget.LinearLayoutManager
import android.widget.EditText
import android.widget.LinearLayout


class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_songs -> {
                toolbar.title = "Home"
                val home = Home.newInstance()
                openFragment(home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_albums -> {
                toolbar.title = "Pedidos"
                val pedidos = Pedidos.newInstance()
                openFragment(pedidos)
                return@OnNavigationItemSelectedListener true
            }
//            R.id.navigation_artists -> {
//
//                return@OnNavigationItemSelectedListener true
//            }
        }
        false
    }


    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    lateinit var toolbar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
        setSupportActionBar(toolbar_main)
//        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar = supportActionBar!!
        toolbar.title = "Home"
//        toolbar_main.title = "Produtos"
        openFragment(Home.newInstance())

        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
