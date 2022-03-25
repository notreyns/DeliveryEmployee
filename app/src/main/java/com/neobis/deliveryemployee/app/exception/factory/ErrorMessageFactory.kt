package com.neobis.deliveryclient.app.exception.factory

import com.example.evergreenclient.data.exception.ConnectionLostException
import com.example.evergreenclient.data.exception.UnauthorizedException


class ErrorMessageFactory {

    companion object {
        fun create(throwable: Throwable): String? {
            val error = throwable.message
            return when(throwable) {
                is ConnectionLostException -> {
                    "Проверьте интернет соедниение"
                }
                is UnauthorizedException -> {
                    "Уйди разбойник"
                }
                else ->  {
                    "Ой, что-то пошло не так...$error"
                }
            }
        }
    }
}