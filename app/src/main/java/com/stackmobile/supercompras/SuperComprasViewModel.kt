package com.stackmobile.supercompras

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SuperComprasViewModel : ViewModel() {
    private val _listaDeItems = MutableStateFlow<List<ItemCompra>>(emptyList())
    val listaDeItems: StateFlow<List<ItemCompra>> = _listaDeItems

    fun adicionarItem(item: ItemCompra) {
        viewModelScope.launch {
            _listaDeItems.update { lista ->
                lista + item
            }
        }
    }


    fun removerItem(item: ItemCompra){
        viewModelScope.launch {
            _listaDeItems.update { lista ->
                lista - item
            }
        }
    }

    fun editarItem(itemEditado: ItemCompra, novoTexto: String){
        viewModelScope.launch {
            _listaDeItems.update { lista ->
                lista.map { itemAtual ->
                    if (itemAtual == itemEditado) {
                        itemAtual.copy(texto = novoTexto)
                    } else {
                        itemAtual
                    }
                }
            }
        }
    }

    fun mudarStatus(itemSelecionado: ItemCompra) {
        viewModelScope.launch {
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
}