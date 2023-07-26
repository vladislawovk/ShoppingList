package com.vladislawovk.shoppinglist.presentation

import androidx.lifecycle.MutableLiveData
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

    val shopList = MutableLiveData<List<ShopItem>>()

    fun getShopList() {
        val list = getShopListUseCase.getShopList()
        shopList.value = list
    }

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
        getShopList()
    }

    fun changeIsEnabledState(shopItem: ShopItem) {
        val newItem = shopItem.copy(isEnabled = !shopItem.isEnabled)
        editShopItemUseCase.editShopItem(newItem)
        getShopList()
    }
}