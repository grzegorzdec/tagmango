package com.grzegorzdec.tagmango.coupon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.grzegorzdec.tagmango.repository.Repository

class CouponFragmentViewModelFactory(val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = CouponFragmentViewModel(repository) as T
}