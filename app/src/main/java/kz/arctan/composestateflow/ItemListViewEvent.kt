package kz.arctan.composestateflow

sealed interface ItemListViewEvent {
    data class ItemCheckEvent(val item: Item) : ItemListViewEvent
    data class ItemDeleteEvent(val item: Item) : ItemListViewEvent
}
