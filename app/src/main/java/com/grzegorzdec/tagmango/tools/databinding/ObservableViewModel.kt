package com.grzegorzdec.tagmango.tools.databinding

import androidx.lifecycle.ViewModel


open class ObservableViewModel : ViewModel(), NotifiableObservable by NotifiableObservable.delegate() {

    init {
        initDelegator(this)
    }
}