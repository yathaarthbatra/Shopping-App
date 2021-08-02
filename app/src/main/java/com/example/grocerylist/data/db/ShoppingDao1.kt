package com.example.grocerylist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.grocerylist.data.db.entities.ShoppingItem

@Dao
interface ShoppingDao1 {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upstart(item: ShoppingItem):Long
    //this fun will insert and update the item
    //if the item id is already present , then it doesnot insert
    //and if not then it inserts the item

    @Delete
     suspend fun deleteItem(item: ShoppingItem):Long
    //this fun will delete the matching item in the table

    @Query("SELECT * FROM ShoppingItemsTable")
    fun getAllItems():LiveData<List<ShoppingItem>>
}