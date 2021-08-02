package com.example.grocerylist.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ShoppingItemsTable")
data class ShoppingItem(
    @ColumnInfo(name = "item_Name")
    var name:String,
    @ColumnInfo(name = "item_amount")
    var quantity:Int,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="uniqueId")
    var id:Int
)