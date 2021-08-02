package com.example.grocerylist.ui.shoppingList

import com.example.grocerylist.data.db.entities.ShoppingItem

interface AddItemDialogListener {
    fun onAddItem(item:ShoppingItem)
}