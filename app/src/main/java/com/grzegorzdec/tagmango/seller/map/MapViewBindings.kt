package com.grzegorzdec.tagmango.seller.map

import android.view.View
import android.widget.FrameLayout
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import com.grzegorzdec.tagmango.common.animation.onAnimationEnd
import com.grzegorzdec.tagmango.model.Client
import com.grzegorzdec.tagmango.seller.panel.PanelLayout

@BindingAdapter("mapMarkers")
fun mapMarkers(mapView: MapView, clients: List<Client>) {
    if(clients.isNotEmpty()) {
        mapView.getMapAsync { googleMap ->
            val latLngBuilder = LatLngBounds.Builder()
            clients.forEach {
                val latLng = LatLng(it.latitude, it.longitude)
                latLngBuilder.include(latLng)
                googleMap.addMarker(
                    MarkerOptions()
                        .position(latLng)
                        .title(it.name)
                )
            }
            val latLngBounds = latLngBuilder.build()
            googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, 120))
        }
    }
}

@BindingAdapter("onMarkerClick")
fun addMarkerClickListeners(mapView: MapView, onMarkerClickListener: GoogleMap.OnMarkerClickListener) {
    mapView.getMapAsync { googleMap ->
        googleMap.setOnMarkerClickListener(onMarkerClickListener)
    }
}

@BindingAdapter("selectedClient")
fun selectedClient(mapView: MapView, client: Client?) {
    if(client != null) {
        mapView.getMapAsync {
            val latLng = LatLng(client.latitude, client.longitude)
            if(it.cameraPosition.target.latitude != latLng.latitude || it.cameraPosition.target.longitude != latLng.longitude ) {
                it.moveCamera(CameraUpdateFactory.newLatLng(LatLng(client.latitude, client.longitude)))
            }
        }
    }
}

@BindingAdapter("updateFrame")
fun selectedClient(layout: PanelLayout, client: Client?) {
    if(client == null) {
        if (layout.visibility == View.VISIBLE) {
            layout.animate()
                .translationY(-layout.height.toFloat())
                .onAnimationEnd { layout.visibility = View.GONE }
                .start()
        }
    } else {
        if (layout.visibility == View.GONE) {
            layout.visibility = View.VISIBLE
            layout.animate()
                .translationY(0f)
                .setListener(null)
                .start()
        } else {

        }
    }
}

