package kz.arctan.composestateflow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CheckItemUseCase {
    operator fun invoke(
        item: Item,
        items: MutableList<Item>
    ): Flow<Result<List<Item>>> = flow {
        emit(Result.Loading())
        try {
            ItemsRepository.updateItem(item)
            emit(Result.Success(items as List<Item>))
        } catch (e: Exception) {
            emit(Result.Error("Cannot update the item"))
        }
    }
}