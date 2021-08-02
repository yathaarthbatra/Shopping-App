package com.example.grocerylist.ui.shoppingList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.grocerylist.R
import com.example.grocerylist.adapters.ShoppingListAdapter
import com.example.grocerylist.data.db.ShoppingDatabase
import com.example.grocerylist.data.db.entities.ShoppingItem
import com.example.grocerylist.repositories.ShoppingRepository
import kotlinx.android.synthetic.main.activity_shopping.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class ShoppingListActivity : AppCompatActivity() , KodeinAware{

    override val kodein by kodein()
    private val factory: ShoppingViewModelFactory by instance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)




        val viewModel= ViewModelProviders.of(this,factory).get(ShoppingViewModel::class.java)

        //creating adapter object
        val adapter=ShoppingListAdapter(listOf(),viewModel)
        val layoutManager=LinearLayoutManager(this)

        shoppingListRecyclerView.adapter=adapter
        shoppingListRecyclerView.layoutManager=layoutManager

        //now to get data , we will use ViewModel object as that has the fun of getAllItems
        viewModel.getAllItems().observe(this, Observer {
            //it has the list of ShoppingList and as it returns from Live Data, it will automatically update
            adapter.items=it
            adapter.notifyDataSetChanged() //whenever the data or items will change ,adapter will change
        })

        floatingAddButton.setOnClickListener {
            ItemDialog(this,
            object :AddItemDialogListener{
                override fun onAddItem(item: ShoppingItem) {
                    viewModel.upStart(item)
                }
            }).show() //to open the dialog Box
        }






    }
}