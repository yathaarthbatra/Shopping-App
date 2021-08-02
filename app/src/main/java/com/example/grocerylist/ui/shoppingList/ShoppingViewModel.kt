package com.example.grocerylist.ui.shoppingList

import androidx.lifecycle.ViewModel
import com.example.grocerylist.data.db.entities.ShoppingItem
import com.example.grocerylist.repositories.ShoppingRepository
import kotlinx.coroutines.*

class ShoppingViewModel(
    private val shoppingRepository: ShoppingRepository
) : ViewModel() {

    fun upStart(item: ShoppingItem)=  GlobalScope.launch {
        shoppingRepository.upstart(item)
    }

    fun deleteItem(item: ShoppingItem) = GlobalScope.launch {
        shoppingRepository.delete(item)
    }

    fun getAllItems()=shoppingRepository.getAllItems()

}