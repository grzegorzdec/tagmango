package com.grzegorzdec.tagmango.seller.map

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.grzegorzdec.tagmango.databinding.ItemClientBinding
import com.grzegorzdec.tagmango.model.Client
import com.grzegorzdec.tagmango.tools.BindableAdapter

class ClientsRecyclerAdapter(private val viewModelProvider: ViewModelProvider):
RecyclerView.Adapter<ClientsRecyclerAdapter.ViewHolder>(),
    BindableAdapter<List<Client>> {

    private var clients: List<Client> = emptyList()

    override fun setData(data: List<Client>) {
        clients = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemClientBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = clients.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            viewModel = viewModelProvider.get(clients[position].id, ClientItemViewModel::class.java).apply {
                client = clients[holder.adapterPosition]
            }
        }
    }

    inner class ViewHolder(val binding: ItemClientBinding) : RecyclerView.ViewHolder(binding.root)
}