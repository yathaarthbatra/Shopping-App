package com.example.grocerylist.ui.shoppingList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.grocerylist.repositories.ShoppingRepository

class ShoppingViewModelFactory(
    val shoppingRepository: ShoppingRepository
):ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingViewModel(shoppingRepository) as T
    }
}