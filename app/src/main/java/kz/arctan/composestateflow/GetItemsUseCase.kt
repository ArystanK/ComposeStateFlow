package kz.arctan.composestateflow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class GetItemsUseCase {
    operator fun invoke(): Flow<Result<List<Item>>> = flow {
        try {
            emit(Result.Loading())
            val items: List<Item> = ItemsRepository.getAllItems()
            emit(Result.Success(items))
        } catch (e: Exception) {
            emit(Result.Error("Cannot get items"))
        }
    }
}