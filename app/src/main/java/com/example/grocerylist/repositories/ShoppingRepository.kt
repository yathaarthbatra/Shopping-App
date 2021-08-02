package com.example.grocerylist.repositories

import com.example.grocerylist.data.db.ShoppingDatabase

import com.example.grocerylist.data.db.entities.ShoppingItem

class ShoppingRepository(
    val db:ShoppingDatabase
) {
    //we need to have functions of the DAO class
    //as repository gets the data from the data source
     suspend fun upstart(item:ShoppingItem)= db.getShoppingDao().upstart(item)

     suspend fun delete(item: ShoppingItem)=db.getShoppingDao().deleteItem(item)

    fun getAllItems()=db.getShoppingDao().getAllItems()
}