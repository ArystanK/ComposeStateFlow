package kz.arctan.composestateflow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _itemListViewState = MutableStateFlow(ItemListViewState())
    val itemListViewState: StateFlow<ItemListViewState> = _itemListViewState

    init {
        val getItemsUseCase = GetItemsUserCase()
        val items = getItemsUseCase()
        viewModelScope.launch {
            _itemListViewState.emit(items)
        }
    }

    fun onParseEvent(event: ItemListViewEvent) {
        when (event) {
            is ItemListViewEvent.ItemCheckEvent -> {
                val checkItemUseCase = CheckItemUseCase()
                
            }
            is ItemListViewEvent.ItemDeleteEvent -> TODO()
        }
    }
}