package com.lambdaschool.sprint2_challenge
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.ViewGroup
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.lambdaschool.sprint2_challenge.GroceryRepository.Companion.groceryList
import kotlinx.android.synthetic.main.grocery_list_item.view.*

class GroceryAdapter(val groceryList: MutableList<GroceryItem>) : RecyclerView.Adapter<GroceryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.grocery_list_item, parent, false) as View)
    }

    override fun getItemCount(): Int {
        return groceryList.size
    }


    fun setEnterAnimation(viewToAnimate:View, position: Int){
        val animation: Animation = AnimationUtils.loadAnimation(viewToAnimate.context,android.R.anim.slide_in_left)
        viewToAnimate.startAnimation(animation)


    }




    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val grocery = groceryList[position]
        holder.bindModel(grocery)

        holder.FoodItemParent.setOnClickListener {  }
        setEnterAnimation(holder.FoodItemParent,position)

        holder.FoodItemParent.setOnClickListener {
            grocery.Isselected = !grocery.Isselected
            notifyItemChanged(position)


        }


        //holder.FoodImageView.setOnClickListener {  }
        //setEnterAnimation(holder.FoodImageView,position)
    }
        var shoppinglist = mutableListOf<String>()
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val FoodImageView: ImageView = view.food_view
        val FoodNameView: TextView = view.food_name_view
        val FoodItemParent: LinearLayout = view.grocery_item_parent

        fun bindModel(food: GroceryItem) {
            FoodImageView.setImageResource(food.imageId)
            FoodNameView.text = food.name
            if (food.Isselected)
                FoodItemParent.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.colorAccent))
            else
                FoodItemParent.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.colorPrimaryDark))


        }
    }


}


//commit