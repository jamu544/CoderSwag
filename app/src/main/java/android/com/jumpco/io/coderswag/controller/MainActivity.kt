package android.com.jumpco.io.coderswag.controller

import android.com.jumpco.io.coderswag.R
import android.com.jumpco.io.coderswag.adapters.CategoryAdapter
import android.com.jumpco.io.coderswag.model.Category
import android.com.jumpco.io.coderswag.services.DataService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryAdapter(this,DataService.categories)
        categoryListView.adapter = adapter
    }
}