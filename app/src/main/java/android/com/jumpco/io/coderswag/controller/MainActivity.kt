package android.com.jumpco.io.coderswag.controller

import android.com.jumpco.io.coderswag.R
import android.com.jumpco.io.coderswag.model.Category
import android.com.jumpco.io.coderswag.services.DataService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: ArrayAdapter<Category>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                DataService.categories)

        categoryListView.adapter = adapter
    }
}