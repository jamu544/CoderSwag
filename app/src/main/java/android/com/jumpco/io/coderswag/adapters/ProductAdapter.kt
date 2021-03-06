package android.com.jumpco.io.coderswag.adapters

import android.com.jumpco.io.coderswag.R
import android.com.jumpco.io.coderswag.model.Product
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(val context: Context, val products: List<Product>, val itemClick: (Product) -> Unit) :
    RecyclerView.Adapter<ProductAdapter.ProductHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.product_list_item,parent,false)
        return ProductHolder(view,itemClick)
    }
    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder?.bindProduct(products[position], context)
    }
    override fun getItemCount(): Int {
        return products.count()
    }
    inner class ProductHolder(itemView: View?,val itemClick:(Product)-> Unit): RecyclerView.ViewHolder(itemView!!){
            val productImage = itemView?.findViewById<ImageView>(R.id.productImage)
            val productName = itemView?.findViewById<TextView>(R.id.productName)
            val productPrice = itemView?.findViewById<TextView>(R.id.productPrice)

        fun bindProduct(product: Product, context:Context){
            val resourcId = context.resources.getIdentifier(product.image,"drawable", context.packageName)
            productImage?.setImageResource(resourcId)
            productName?.text = product.title
            productPrice?.text = product.price
            itemView.setOnClickListener { itemClick(product) }
        }

    }
}