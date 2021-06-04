package com.rivaldofez.hexcap.ui.maps

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.rivaldofez.hexcap.R
import com.rivaldofez.hexcap.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var mapsBinding: ActivityMapsBinding
    private lateinit var lastLocation: Location
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private var latTemple: Double = 0.0
    private var longTemple: Double = 0.0
    private lateinit var titleTemple: String

    companion object {
        private const val LOCATION_REQUEST_CODE = 111
        const val EXTRA_LAT = "extra_lat"
        const val EXTRA_LONG = "extra_long"
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mapsBinding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(mapsBinding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync(this)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        val bundle = intent.extras
        if(bundle != null){
            this.latTemple = bundle.getDouble(EXTRA_LAT)
            this.longTemple = bundle.getDouble(EXTRA_LONG)
            this.titleTemple = bundle.getString(EXTRA_NAME).toString()
        }
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.uiSettings.isZoomControlsEnabled = true

        setUpMap()
        setTempleMarker(latTemple, longTemple, titleTemple)
    }

    private fun setTempleMarker(lat: Double, long: Double, title: String){
        val currentLatLong = LatLng(lat, long)
        mMap.addMarker(MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marker_candi))
            .position(currentLatLong).title(title))
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLong, 12f))
    }

    private fun setUpMap(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_REQUEST_CODE)
            return
        }
        mMap.isMyLocationEnabled = true
        fusedLocationClient.lastLocation.addOnSuccessListener(this) { location ->
            if(location != null){
                lastLocation = location
                val currentLatLong = LatLng(location.latitude, location.longitude)

                mMap.addMarker(MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marker_user))
                    .position(currentLatLong).title("Your Location"))
            }
        }
    }
}