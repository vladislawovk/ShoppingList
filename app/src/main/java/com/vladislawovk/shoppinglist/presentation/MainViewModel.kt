package com.vladislawovk.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import com.vladislawovk.shoppinglist.data.ShopListRepositoryImpl
import com.vladislawovk.shoppinglist.domain.DeleteShopItemUseCase
import com.vladislawovk.shoppinglist.domain.EditShopItemUseCase
import com.vladislawovk.shoppinglist.domain.GetShopListUseCase
import com.vladislawovk.shoppinglist.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeIsEnabledState(shopItem: ShopItem) {
        val newItem = shopItem.copy(isEnabled = !shopItem.isEnabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}