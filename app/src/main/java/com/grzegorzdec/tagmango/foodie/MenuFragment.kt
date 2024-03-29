package com.grzegorzdec.tagmango.foodie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import com.grzegorzdec.tagmango.BaseFragment
import com.grzegorzdec.tagmango.databinding.FragmentMenuBinding
import com.grzegorzdec.tagmango.foodie.menu.MenuItemViewModelFactory
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
            recyclerView.run {
                adapter =
                    MenuListAdapter(ViewModelProviders.of(this@MenuFragment, MenuItemViewModelFactory(repository)))
                addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            }

            repository.getAllMeals().observe(viewLifecycleOwner, Observer {
                this@MenuFragment.viewModel.meals = it
            })

            repository.getLikes().observe(viewLifecycleOwner, Observer {
                this@MenuFragment.viewModel.likedMeals = it
            })

        }.root
    }
}