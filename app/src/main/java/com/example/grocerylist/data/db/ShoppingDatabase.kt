package com.example.grocerylist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.grocerylist.data.db.entities.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1,
    exportSchema = false

)
abstract class ShoppingDatabase : RoomDatabase(){

    //to have access to operations to the database or table , we can have a reference
    abstract fun getShoppingDao(): ShoppingDao1

    companion object{
        @Volatile
        private var instance: ShoppingDatabase?=null
        private val LOCK=Any()


        //whenever we will create instance this func will get executed
        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance =it }
            //it will have the reference to the result of createDatabase and it will assign to instance
        }


        private fun createDatabase(context: Context)=
            Room.databaseBuilder(context.applicationContext,
                ShoppingDatabase::class.java,"ShoppingDb").build()

    }




}