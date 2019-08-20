package com.lambdaschool.sprint2_challenge

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_grocery_detial.*
import kotlinx.android.synthetic.main.grocery_list_item.*

class GroceryDetial : AppCompatActivity() {
   companion object {

       const val ITEM_KEY = "GROCERY_ITEM"
   }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grocery_detial)

        val item = intent.getSerializableExtra(ITEM_KEY)as GroceryItem


    }
}
