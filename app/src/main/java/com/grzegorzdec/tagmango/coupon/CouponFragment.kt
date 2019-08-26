package com.grzegorzdec.tagmango.coupon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.grzegorzdec.tagmango.BaseFragment
import com.grzegorzdec.tagmango.databinding.FragmentCouponBinding

class CouponFragment : BaseFragment() {

    private val viewModel by lazy {
        ViewModelProviders.of(this, CouponFragmentViewModelFactory(repository))
            .get(CouponFragmentViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        FragmentCouponBinding.inflate(inflater, container, false).apply {
            viewModel = this@CouponFragment.viewModel
        }.root
}