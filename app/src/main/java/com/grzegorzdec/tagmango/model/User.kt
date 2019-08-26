package com.grzegorzdec.tagmango.model

data class User(
    val id: String? = null,
    val stamps: List<Stamp> = emptyList()
)

data class Stamp(
    val date: Long
)