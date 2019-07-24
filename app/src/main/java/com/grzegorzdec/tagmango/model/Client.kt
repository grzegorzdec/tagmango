package com.grzegorzdec.tagmango.model

data class Client(
    val id: String = "",
    val name: String = "",
    val latitude: Double = 51.107883,
    val longitude: Double = 17.038538,
    val isSelected: Boolean = false
)