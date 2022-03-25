package com.neobis.deliveryclient.domain.interactor.usecase.base

import com.neobis.deliveryclient.domain.interactor.result.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

abstract class UseCase<T, Params> {
    abstract suspend fun doOnBackground(params: Params?): Result<T>

    fun execute(scope: CoroutineScope, params: Params? = null, onResult: (Result<T>) -> Unit) {
        scope.launch(Dispatchers.Main) {
            try {
                val deferred = async(Dispatchers.IO) {
                    try {
                        doOnBackground(params)
                    } catch (e: Throwable) {
                        Result.Exception(e)
                    }
                }
                onResult(deferred.await())
            } catch (t: Throwable) {
                t.printStackTrace()
                onResult(Result.Exception(t))
            }
        }
    }
}
