package kz.arctan.composestateflow

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {
    private val _itemListViewStateFlow = MutableStateFlow(ItemListViewState())
    val itemListViewStateFlow: StateFlow<ItemListViewState> = _itemListViewStateFlow

    init {
        val getItemsUseCase = GetItemsUseCase()
        val items = getItemsUseCase()
        _itemListViewStateFlow.update {
            it.copy(items = items)
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