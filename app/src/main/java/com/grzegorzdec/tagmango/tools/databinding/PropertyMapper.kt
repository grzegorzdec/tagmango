package com.midrive.databinding

import com.midrive.databinding.PropertyMapper.bindableResourceClass
import kotlin.reflect.KProperty

/**
 * Provides a hassle free way of mapping a [KProperty] to an id from a generated `BR` databinding classes.
 *
 * To use, initialise the [bindableResourceClass] once in your [Application] like so:
 * ```
 * override fun onCreate() {
 *   super.onCreate()
 *   PropertyMapper.bindableResourceClass = BR::class.java
 * }
 *
 * ```
 */
object PropertyMapper {

    private val resourceIdMap = hashMapOf<String, Int>()
    lateinit var bindableResourceClass: Class<*>

    fun bindableResourceIdForKProperty(property: KProperty<*>): Int {
        return resourceIdMap.getOrPut(property.name) { property.name.bindableResourceId }
    }

    val preCache: Unit by lazy {
        bindableResourceClass.let {
            it.fields.forEach { field ->
                try {
                    val key = field.name
                    val value = it.getDeclaredField(key).getInt(it)
                    resourceIdMap.put(key, value)
                } catch (e: IllegalArgumentException) {
                    // instant run adds some fields..
                }
            }
        }
    }

    private val String.bindableResourceId: Int
        get() {
            return bindableResourceClass.let { it.getDeclaredField(this).getInt(it) }!!
        }
}