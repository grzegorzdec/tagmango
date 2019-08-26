package com.grzegorzdec.tagmango

import com.grzegorzdec.tagmango.tools.databinding.ObservableViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext


open class BaseViewModel : ObservableViewModel() {

    private val parentJob = Job()
    private val coroutineContext: CoroutineContext get() = parentJob + Dispatchers.Default
    protected val scope = CoroutineScope(coroutineContext)

    override fun onCleared() {
        coroutineContext.cancel()
    }
}