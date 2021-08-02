package com.example.grocerylist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.grocerylist.R
import com.example.grocerylist.data.db.entities.ShoppingItem
import com.example.grocerylist.ui.shoppingList.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingListAdapter(
    var items:List<ShoppingItem>,
    private var viewModel:ShoppingViewModel
) : RecyclerView.Adapter<ShoppingListAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
       //in this fun we will inflate the View
        var view=LayoutInflater.from(parent.context).inflate(R.layout.shopping_item,parent,false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        //in this fun , we will bind or set the values to the ViewHolder
        var currentShoppingItem=items[position]
        holder.itemView.itemName.text=currentShoppingItem.name
        holder.itemView.itemQuantity.text="${currentShoppingItem.quantity}"

        //setting the onClick Listners
        holder.itemView.addButton.setOnClickListener{
            currentShoppingItem.quantity++
            viewModel.upStart(currentShoppingItem)
        }

        //for sub Button
        holder.itemView.subButton.setOnClickListener {
            if(currentShoppingItem.quantity>0){
            currentShoppingItem.quantity--
            viewModel.upStart(currentShoppingItem)
            }
        }

        //for delete option
        holder.itemView.deleteButton.setOnClickListener {
            viewModel.deleteItem(currentShoppingItem)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ShoppingViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

}