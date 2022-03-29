package android.com.jumpco.io.coderswag.adapters

import android.com.jumpco.io.coderswag.R
import android.com.jumpco.io.coderswag.adapters.CategoryRecycleAdapter.*
import android.com.jumpco.io.coderswag.model.Category
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryRecycleAdapter(val context: Context, val categories: List<Category>) : RecyclerView.Adapter<Holder>(){

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bindCategory(categories[position], context)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.category_list_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryImage = itemView?.findViewById<ImageView>(R.id.categoryImage)
        val categoryName = itemView?.findViewById<TextView>(R.id.categorName)

        fun bindCategory(category : Category, context: Context){
            val resourceId = context.resources.getIdentifier(category.image,
                             "drawable",context.packageName)
            categoryImage?.setImageResource(resourceId)
            categoryName?.text = category.title
        }
    }
}