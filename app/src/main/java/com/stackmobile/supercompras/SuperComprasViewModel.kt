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


    fun removerItem(item: ItemCompra){
        _listaDeItems.update { lista ->
            lista - item
        }
    }

    fun editarItem(itemEditado: ItemCompra, novoTexto: String){
        _listaDeItems.update { lista ->
            lista.map {itemAtual ->
                if (itemAtual == itemEditado) {
                    itemAtual.copy(texto = novoTexto)
                } else {
                    itemAtual
                }
            }
        }
    }

    fun mudarStatus(itemSelecionado: ItemCompra){
        _listaDeItems.update { lista ->
            lista.map { itemMap ->
                if (itemSelecionado == itemMap) {
                    itemSelecionado.copy(foiComprado = !itemSelecionado.foiComprado)
                } else {
                    itemMap
                }
            }
        }
    }
}