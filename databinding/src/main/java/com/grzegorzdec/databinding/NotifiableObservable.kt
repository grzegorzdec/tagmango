package com.grzegorzdec.databinding

import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LifecycleObserver


interface NotifiableObservable : Observable, LifecycleObserver {
    fun setDelegator(notifiableObservable: NotifiableObservable)
    fun notifyPropertyChanged(propertyId: Int)
    fun notifyChange()
    fun initDelegator(observableViewModel: NotifiableObservable)

    object delegate :
            () -> NotifiableObservable {
        private const val ALL_PROPERTIES = 0

        override fun invoke(): NotifiableObservable =
            BaseNotifiableObservable()

        private class BaseNotifiableObservable : NotifiableObservable {


            private val changeRegisterProperty = lazy { PropertyChangeRegistry() }
            private val changeRegistry: PropertyChangeRegistry by changeRegisterProperty
            private lateinit var delegator: NotifiableObservable

            override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
                changeRegistry.remove(callback)
            }

            override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
                changeRegistry.add(callback)
            }

            override fun setDelegator(notifiableObservable: NotifiableObservable) {
                this.delegator = notifiableObservable
            }

            override fun notifyPropertyChanged(propertyId: Int) {
                if (changeRegisterProperty.isInitialized()) {
                    changeRegistry.notifyCallbacks(delegator, propertyId, null)
                }
            }

            override fun notifyChange() {
                if (changeRegisterProperty.isInitialized()) {
                    changeRegistry.notifyCallbacks(
                        delegator,
                        ALL_PROPERTIES, null
                    )
                }
            }

            override fun initDelegator(notifiableObservable: NotifiableObservable) {
                delegator = notifiableObservable
            }
        }
    }
}