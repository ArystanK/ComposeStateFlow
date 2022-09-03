package kz.arctan.composestateflow

sealed class Result<T>(
    _data: T? = null,
    _errorMessage: String? = null
) {
    data class Success<T>(val data: T) : Result<T>(data)
    data class Loading<T>(val prevData: T? = null) : Result<T>(prevData)
    data class Error<T>(val errorMessage: String) : Result<T>(_errorMessage = errorMessage)
}
