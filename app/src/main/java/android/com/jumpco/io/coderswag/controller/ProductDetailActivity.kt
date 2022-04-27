package android.com.jumpco.io.coderswag.controller

import android.com.jumpco.io.coderswag.R
import android.com.jumpco.io.coderswag.model.Product
import android.com.jumpco.io.coderswag.utilities.EXTRA_PRODUCT
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        val product = intent.getParcelableExtra<Product>(EXTRA_PRODUCT)
        val resourceId = resources.getIdentifier(product?.image,"drawable",packageName)

        detailImageView.setImageResource(resourceId)
        detailProductName.text = product?.title
        detailProductPrice.text = product?.price
    }
}