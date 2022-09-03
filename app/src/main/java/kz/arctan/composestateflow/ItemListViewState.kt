package kz.arctan.composestateflow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class ItemListViewState(
    val items: Flow<Result<List<Item>>> = emptyFlow()
)
