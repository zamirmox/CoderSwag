package com.example.coderswag.controller

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coderswag.R
import com.example.coderswag.Utilities.EXTRA_CATEGORY
import com.example.coderswag.adapters.CategoryRecycleAdapter
import com.example.coderswag.services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var  adapter:CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this, DataService.categories){ category ->
            val productIntent = Intent(this, ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productIntent)
        }
        categoryListView.adapter =adapter

        val layoutManager= LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true)
        }

    }