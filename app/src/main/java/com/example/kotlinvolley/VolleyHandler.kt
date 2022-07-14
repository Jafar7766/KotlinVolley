package com.example.kotlinvolley

interface VolleyHandler {
    fun onSuccess(response: String?)
    fun onError(error: String?)
}