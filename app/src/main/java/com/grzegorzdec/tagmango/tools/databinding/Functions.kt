package com.grzegorzdec.tagmango.tools.databinding

object Functions {
    val areEqual: (first: Any?, second: Any?) -> Boolean = { first, second -> first == second }
    val areNotEqual: (first: Any?, second: Any?) -> Boolean = { first, second -> first != second }
    val alwaysEqual: (first: Any?, second: Any?) -> Boolean = { _, _ -> true }
    val alwaysTrue: (Any?) -> Boolean = { true }
}