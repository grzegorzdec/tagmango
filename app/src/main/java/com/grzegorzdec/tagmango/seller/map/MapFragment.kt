package com.grzegorzdec.tagmango.seller.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.*
import com.grzegorzdec.tagmango.R
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.grzegorzdec.tagmango.BaseFragment
import com.grzegorzdec.tagmango.common.recyclerview.HorizontalMarginItemDecoration
import com.grzegorzdec.tagmango.databinding.FragmentMapBinding


const val MAPVIEW_BUNDLE_KEY = "MAPVIEW_BUNDLE_KEY"

class MapFragment : BaseFragment() {

    private lateinit var mapView: MapView
    private var mapViewBundle: Bundle? = null

    private val viewModel by lazy {
        ViewModelProviders.of(this, MapFragmentViewModelFactory(repository))
            .get(MapViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMapBinding.inflate(inflater, container, false).apply {
            viewModel = this@MapFragment.viewModel
            recyclerView.addItemDecoration(
                HorizontalMarginItemDecoration(
                    resources.getDimensionPixelSize(R.dimen.client_item_offset)
                )
            )
            recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerView.itemAnimator = null
            recyclerView.adapter = ClientsRecyclerAdapter(ViewModelProviders.of(this@MapFragment),  viewModel) {
                this@MapFragment.viewModel.selectedClient = it
            }
            mapView = map.apply {
                onCreate(mapViewBundle)
            }
        }
        initMap()
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val mapViewBundle = outState.getBundle(MAPVIEW_BUNDLE_KEY)
            ?: Bundle().apply { putBundle(MAPVIEW_BUNDLE_KEY, this) }
        mapView.onSaveInstanceState(mapViewBundle)
    }

    private fun initMap() {
        mapView.getMapAsync {
            viewModel.loadClients()
        }
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }
}