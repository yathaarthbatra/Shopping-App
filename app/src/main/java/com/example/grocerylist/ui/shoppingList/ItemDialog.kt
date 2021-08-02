package com.example.grocerylist.ui.shoppingList

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.grocerylist.R
import com.example.grocerylist.data.db.entities.ShoppingItem
import kotlinx.android.synthetic.main.add_item_dialog.*

class ItemDialog(context: Context,var addOkItemListener:AddItemDialogListener):AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_item_dialog)
       dialogOkButton.setOnClickListener {
           var itemName=dialogitemName.text.toString()
           var itemQuantity=dialogitemQuantity.text.toString()

           if(itemName.isEmpty() || itemQuantity.isEmpty()) {
               Toast.makeText(context, "Please enter all the information", Toast.LENGTH_SHORT)
                   .show()
               return@setOnClickListener //to again start the onclickListener on Ok button
           }
           var item=ShoppingItem(itemName,itemQuantity.toInt())
           addOkItemListener.onAddItem(item)
           dismiss() //to dismiss the dialog Box

       }

        dialogCancelButton.setOnClickListener{
            cancel() //to cancel the dialog Box
        }
    }

}