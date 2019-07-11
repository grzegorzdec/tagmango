package com.grzegorzdec.tagmango.seller.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.*
import com.grzegorzdec.tagmango.R
import android.content.pm.PackageManager
import android.Manifest.permission.ACCESS_COARSE_LOCATION
import androidx.core.app.ActivityCompat
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.GoogleMap
import com.grzegorzdec.tagmango.BaseFragment
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
            recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerView.adapter = ClientsRecyclerAdapter(ViewModelProviders.of(this@MapFragment))
        }
        mapView = binding.map.apply {
            onCreate(mapViewBundle)
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