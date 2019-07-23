package com.grzegorzdec.tagmango.seller.map

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.grzegorzdec.tagmango.databinding.ItemClientBinding
import com.grzegorzdec.tagmango.model.Client

class ClientsRecyclerAdapter(
    private val viewModelProvider: ViewModelProvider,
    private val mapViewModel: MapViewModel,
    private val onClientClickListener: (Client) -> Unit
): RecyclerView.Adapter<ClientsRecyclerAdapter.ClientViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ClientViewHolder(ItemClientBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = mapViewModel.clients.size

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        holder.binding.apply {
                viewModel = viewModelProvider.get(mapViewModel.clients[position].id, ClientItemViewModel::class.java).apply {
                    client = mapViewModel.clients[holder.adapterPosition]
                }
                root.setOnClickListener {
                    onClientClickListener(mapViewModel.clients[holder.adapterPosition])
                }
            }
        holder.binding.executePendingBindings()
    }

    inner class ClientViewHolder(val binding: ItemClientBinding) : RecyclerView.ViewHolder(binding.root)
}