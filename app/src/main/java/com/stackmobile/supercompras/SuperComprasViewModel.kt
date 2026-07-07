package com.stackmobile.supercompras

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class SuperComprasViewModel : ViewModel() {
    private val _listaDeItems = MutableStateFlow<List<ItemCompra>>(emptyList())
    val listaDeItems: StateFlow<List<ItemCompra>> = _listaDeItems

    fun adicionarItem( item: ItemCompra){
        _listaDeItems.update { lista ->
            lista + item
        }
    }

}