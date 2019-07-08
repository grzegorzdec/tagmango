package com.grzegorzdec.tagmango

import androidx.fragment.app.Fragment
import com.grzegorzdec.tagmango.api.Api
import com.grzegorzdec.tagmango.api.Repository

open class BaseFragment: Fragment() {

    protected val repository by lazy {
        Repository(Api.getApi())
    }

}