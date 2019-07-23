package com.grzegorzdec.tagmango.common

fun <E> Iterable<E>.replace(new: E, predicate: (E) -> Boolean): List<E> = map {
    if(predicate(it))
        new
    else
        it
}