package com.grzegorzdec.tagmango.foodie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.grzegorzdec.tagmango.BaseFragment
import com.grzegorzdec.tagmango.databinding.FragmentMenuBinding
import com.grzegorzdec.tagmango.foodie.menu.MenuListAdapter

class MenuFragment : BaseFragment() {

    private val viewModel by lazy {
        ViewModelProviders.of(this, MenuFragmentViewModelFactory(repository))
            .get(MenuFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentMenuBinding.inflate(inflater, container, false).apply {
            viewModel = this@MenuFragment.viewModel
            recyclerView.adapter = MenuListAdapter(ViewModelProviders.of(this@MenuFragment))
        }.root
    }
}