package com.grzegorzdec.tagmango

import androidx.fragment.app.Fragment
import com.grzegorzdec.tagmango.repository.Api
import com.grzegorzdec.tagmango.repository.Repository
import com.grzegorzdec.tagmango.repository.database.TagmangoDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

open class BaseFragment: Fragment() {

    private val parentJob = Job()
    private val coroutineContext: CoroutineContext get() = parentJob + Dispatchers.Default
    protected val scope = CoroutineScope(coroutineContext)

    override fun onDestroy() {
        coroutineContext.cancel()
        super.onDestroy()
    }

    protected val repository by lazy {
        Repository(Api.getApi(), TagmangoDB.getInstance(requireContext()))
    }

}