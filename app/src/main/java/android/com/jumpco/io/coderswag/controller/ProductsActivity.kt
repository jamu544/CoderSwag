package android.com.jumpco.io.coderswag.controller

import android.com.jumpco.io.coderswag.R
import android.com.jumpco.io.coderswag.adapters.ProductAdapter
import android.com.jumpco.io.coderswag.services.DataService
import android.com.jumpco.io.coderswag.utilities.EXTRA_CATEGORY
import android.com.jumpco.io.coderswag.utilities.EXTRA_PRODUCT
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductAdapter(this,DataService.getProducts(categoryType)){product ->
            val productDetailIntent = Intent(this,ProductDetailActivity::class.java)
            productDetailIntent.putExtra(EXTRA_PRODUCT, product)
            startActivity(productDetailIntent)
        }

        var spanCount = 2
        val orientation = resources.configuration.orientation
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            spanCount = 4
        }
        val screenSize = resources.configuration.screenWidthDp
        if(screenSize > 720){
            spanCount = 3
        }

        val layoutManager = GridLayoutManager(this,spanCount)
        productListView.layoutManager = layoutManager
        productListView.adapter = adapter
    }
}