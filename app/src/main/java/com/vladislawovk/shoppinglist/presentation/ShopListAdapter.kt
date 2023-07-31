package com.vladislawovk.shoppinglist.presentation

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vladislawovk.shoppinglist.domain.ShopItem

class ShopListAdapter : RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {

    val list = listOf<ShopItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ShopItemViewHolder(view: View) : RecyclerView.ViewHolder(view)
}