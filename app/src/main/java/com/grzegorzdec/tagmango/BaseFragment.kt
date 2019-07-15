package com.grzegorzdec.tagmango

import androidx.fragment.app.Fragment
import com.grzegorzdec.tagmango.repository.Api
import com.grzegorzdec.tagmango.repository.Repository
import com.grzegorzdec.tagmango.repository.database.TagmangoDB

open class BaseFragment: Fragment() {

    protected val repository by lazy {
        Repository(Api.getApi(), TagmangoDB.getInstance(requireContext()))
    }

}