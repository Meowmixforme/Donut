package uk.ac.tees.scedt.ad.b_donut

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import uk.ac.tees.scedt.ad.b_donut.databinding.ActivityMapsBinding
import uk.ac.tees.scedt.ad.b_donut.misc.CustomIfoAdapter

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.map_types_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.normal_map -> {
                map.mapType = GoogleMap.MAP_TYPE_NORMAL
            }
            R.id.hybrid_map ->{
                map.mapType = GoogleMap.MAP_TYPE_HYBRID
            }
            R.id.satellite_map ->{
                map.mapType = GoogleMap.MAP_TYPE_SATELLITE
            }
            R.id.terrain_map -> {
                map.mapType = GoogleMap.MAP_TYPE_TERRAIN
            }
            R.id.none_map ->{
                map.mapType = GoogleMap.MAP_TYPE_NONE
            }
        }
        return true
    }
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        // Add a marker in Darlington King's Church and move the camera
        val darlington = LatLng(54.541 , -1.559)


        map.addMarker(MarkerOptions()
            .position(darlington)
            .title("King's Church Foodbank (Darlington)")
            .snippet("King’s Church, Prospect Place,  Whessoe Road,  Darlington,  DL3 0QT. 01325469884 "
                    + "\n" +
                    "\n" +
                 "Needs: https://www.givefood.org.uk/needs/at/kings-darlington/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))

        // Add a marker in Darlington Citadel
        val darlington2 = LatLng(54.545781, -1.535697)
        map.addMarker(MarkerOptions()
            .position(darlington2)
            .title("Darlington Citadel Foodbank")
            .snippet("Thompson Street East\n" +
                    "Darlington\n" +
                    "DL1 3EW "
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/salvation-army/darlington-citadel/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))

        // Add a marker in Billingham
        val Billingham  = LatLng(54.607237, -1.2944457)
        map.addMarker(MarkerOptions()
            .position(Billingham)
            .title("Billingham Foodbank")
            .snippet("4-6 West Precinct\n" +
                    "Billingham Town Centre\n" +
                    "Billingham\n" +
                    "TS23 2NH "+
                    "07583575522"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/billingham-stockton-borough/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))

        // Add a marker in St Michael & All Angels Church
        val Norton  = LatLng(54.5817, -1.309182)
        map.addMarker(MarkerOptions()
            .position(Norton)
            .title("St Michael & All Angels Church Foodbank")
            .snippet("Imperial Avenue\n" +
                    "Norton\n" +
                    "Stockton on Tees\n" +
                    "TS20 2EN\n" +
                    "07854108393"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/billingham-stockton-borough/st-michael-all-angels-church/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))


        // Add a marker in Hebron Church Stockton
        val Stockton1  = LatLng(54.569004, -1.322281)
        map.addMarker(MarkerOptions()
            .position(Stockton1)
            .title("Hebron Church Stockton Foodbank")
            .snippet("Hebron Church\n" +
                    "Brittania Road\n" +
                    "Stockton-on-Tees\n" +
                    "TS19 0AJ\n"+
                    "Hebron Church\n" +
                    "Brittania Road\n" +
                    "Stockton-on-Tees\n" +
                    "TS19 0AJ"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/billingham-stockton-borough/hebron-church-stockton/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))


        // Add a marker in Stockton - Salvation Army
        val Stockton2  = LatLng(54.564918, -1.318096)
        map.addMarker(MarkerOptions()
            .position(Stockton2)
            .title("Stockton - Salvation Army Foodbank")
            .snippet("Palmerston Street\n" +
                    "Stockton-on-Tees\n" +
                    "TS18 1NU\n" +
                    "01642617629"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/salvation-army/stockton/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))


        // Add a marker in Thornaby - Salvation Army
        val Thornaby1  = LatLng(54.555582, -1.299434)
        map.addMarker(MarkerOptions()
            .position(Thornaby1)
            .title("Thornaby - Salvation Army Foodbank")
            .snippet("Westbury Street\n" +
                    "Stockton-on-Tees\n" +
                    "TS17 6NL\n" +
                    "01642672756"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/salvation-army/thornaby/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))


        // Add a marker in Thornaby Food Bank
        val Thornaby2  = LatLng(54.547117, -1.299082)
        map.addMarker(MarkerOptions()
            .position(Thornaby2)
            .title("Thornaby Food Bank")
            .snippet("Thorntree Road\n" +
                    "Thornaby\n" +
                    "Stockton-on-Tees TS17\n" +
                    "TS17 8FZ\n" +
                    "01642677328"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/thornaby/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))

        // Add a marker in Trinity Methodist Church, Whinney Banks Food Bank
        val Middlesbrough1  = LatLng(54.554016, -1.26515)
        map.addMarker(MarkerOptions()
            .position(Middlesbrough1)
            .title("Trinity Methodist Church Food Bank")
            .snippet("Trinity Methodist Church\n" +
                    "Stainsby Road\n" +
                    "Whinney Banks\n" +
                    "Middlesbrough\n" +
                    "TS5 4JS\n" +
                    "07513275409"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/middlesbrough/trinity-methodist-church-whinney-banks/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))

        // Add a marker in West Central - Salvation Army Food Bank
        val Middlesbrough2  = LatLng(54.538198, -1.262142)
        map.addMarker(MarkerOptions()
            .position(Middlesbrough2)
            .title("West Central - Salvation Army Food Bank")
            .snippet("82 Trimdon Avenue\n" +
                    "Middlesbrough\n" +
                    "TS5 8SB\n" +
                    "01642825521"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/salvation-army/middlesbrough-west-central/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))

        // Add a marker in St Timothy's Hemlington
        val Middlesbrough3  = LatLng(54.523627, -1.240467)
        map.addMarker(MarkerOptions()
            .position(Middlesbrough3)
            .title("St Timothy's Hemlington Food Bank")
            .snippet("Hemlington Medical Centre\n" +
                    "Viewley Centre\n" +
                    "Middlesbrough\n" +
                    "TS8 9JJ\n" +
                    "07561189521"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/middlesbrough/st-timothys-hemlington/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))


        // Add a marker in Coulby Newham Baptist Church Food Bank
        val Middlesbrough4  = LatLng(54.529659, 	-1.216217)
        map.addMarker(MarkerOptions()
            .position(Middlesbrough4)
            .title("Coulby Newham FoodBank")
            .snippet("Coulby Newham Baptist Church\n" +
                    "Langdon Square\n" +
                    "Coulby Newham\n" +
                    "Middlesbrough\n" +
                    "TS8 0TF\n" +
                    "07934979949"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/middlesbrough/coulby-newham-baptist-church/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))



        // Add a marker in Grove Hill Methodist Church Food Bank
        val Middlesbrough5  = LatLng(54.557444, 	-1.222504)
        map.addMarker(MarkerOptions()
            .position(Middlesbrough5)
            .title("Grove Hill Methodist Church Food Bank")
            .snippet("Grove Hill Methodist Church\n" +
                    "Marton Road\n" +
                    "Middlesbrough\n" +
                    "TS4 2PT\n" +
                    "07546121701"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/middlesbrough/grove-hill-methodist-church/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))


        // Add a marker in St Barnabas, Linthorpe Food Bank
        val Middlesbrough6  = LatLng(54.562469, 	-1.24409)
        map.addMarker(MarkerOptions()
            .position(Middlesbrough6)
            .title("St Barnabas, Linthorpe Food Bank")
            .snippet("Linthorpe Road\n" +
                    "Middlesbrough\n" +
                    "TS5 6JR\n" +
                    "07552560272"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/middlesbrough/st-barnabas-linthorpe/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))

        // Add a marker in Middlesbrough Community Church Food Bank
        val Middlesbrough7  = LatLng(54.568965, 	-1.240166)
        map.addMarker(MarkerOptions()
            .position(Middlesbrough7)
            .title("Community Church FoodBank")
            .snippet("Clifton Street\n" +
                    "Middlesbrough\n" +
                    "TS1 4NA\n" +
                    "07552456839"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/middlesbrough/middlesbrough-community-church/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))

        // Add a marker in Middlesbrough Citadel - Salvation Army Food Bank
        val Middlesbrough8  = LatLng(54.570782, 	-1.234114)
        map.addMarker(MarkerOptions()
            .position(Middlesbrough8)
            .title("Citadel Salvation Army FoodBank")
            .snippet("Southfield Road\n" +
                    "Middlesbrough\n" +
                    "TS1 3BZ\n" +
                    "01642241344"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/salvation-army/middlesbrough-citadel/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))

        // Add a marker in Middlesbrough Food Bank
        val Middlesbrough9  = LatLng(54.571481, 	-1.182916)
        map.addMarker(MarkerOptions()
            .position(Middlesbrough9)
            .title("Middlesbrough Food Bank")
            .snippet("Unit 5 Wear Court\n" +
                    "Wallis Road\n" +
                    "Skippers Lane Industrial Estate\n" +
                    "Southbank\n" +
                    "Middlesbrough\n" +
                    "TS6 6DU\n" +
                    "07954131337"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/middlesbrough/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))

        // Add a marker in Holy Trinity North Ormesby Food Bank
        val Middlesbrough10  = LatLng(54.572208, 	-1.212617)
        map.addMarker(MarkerOptions()
            .position(Middlesbrough10)
            .title("Holy Trinity North Ormesby Food Bank")
            .snippet("Holy Trinity Church\n" +
                    "Market Place\n" +
                    "North Ormesby\n" +
                    "Middlesbrough\n" +
                    "TS3 6LD\n" +
                    "07551694801"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/middlesbrough/holy-trinity-north-ormesby/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))

        // Add a marker in South Bank - Redcar Food Bank
        val Middlesbrough11  = LatLng(54.579339, 	-1.171977)
        map.addMarker(MarkerOptions()
            .position(Middlesbrough11)
            .title("South Bank - Redcar Food Bank")
            .snippet("Redcar Road East\n" +
                    "South Bank\n" +
                    "TS6 6PY\n" +
                    "01642484842"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/redcar/south-bank/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))

        // Add a marker in Eston - Salvation Army Food Bank
        val Middlesbrough12  = LatLng(54.554194, 	-1.1509)
        map.addMarker(MarkerOptions()
            .position(Middlesbrough12)
            .title("Eston - Salvation Army Food Bank")
            .snippet("Bankfields Road\n" +
                    "Middlesbrough\n" +
                    "TS6 0TA\n" +
                    "01642440834"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/salvation-army/eston/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))

        // Add a marker in St George's Church Food Bank
        val Middlesbrough13  = LatLng(54.568658, 	-1.142929)
        map.addMarker(MarkerOptions()
            .position(Middlesbrough13)
            .title("St George's Church Food Bank")
            .snippet("Spencer Road\n" +
                    "Normanby\n" +
                    "TS6 7LY\n" +
                    "01642484842"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/redcar/st-georges-church/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))

        // Add a marker in Weardale Food Bank
        val Weardale  = LatLng(54.746256, 	-2.004737)
        map.addMarker(MarkerOptions()
            .position(Weardale)
            .title("Weardale Food Bank")
            .snippet("St Thomas' Church Hall\n" +
                    "Front Street\n" +
                    "Stanhope\n" +
                    "DL13 2UE\n" +
                    "01388517572"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/weardale/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))


        // Add a marker in Guisborough Citadel - Salvation Army Food Bank
        val Guisborough  = LatLng(54.534157, -1.058421)
        map.addMarker(MarkerOptions()
            .position(Guisborough)
            .title("Guisborough Food Bank")
            .snippet("Westgate\n" +
                    "Guisborough\n" +
                    "TS14 6AW\n" +
                    "01287636192"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/salvation-army/guisborough-citadel/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))


        // Add a marker in Hexham - Salvation Army Food Bank
        val Hexham  = LatLng(54.972328, 	-2.102212)
        map.addMarker(MarkerOptions()
            .position(Hexham)
            .title("Hexham Food Bank")
            .snippet("Market Street\n" +
                    "Hexham\n" +
                    "NE46 3NS\n" +
                    "01434600462"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/salvation-army/hexham/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))

        // Add a marker in Emmanuel Church Saltburn Food Bank
        val Saltburn  = LatLng(54.581169, -0.97761)
        map.addMarker(MarkerOptions()
            .position(Saltburn)
            .title("Emmanuel Church Food Bank")
            .snippet("Windsor Road Saltburn\n" +
                    "TS12 1LE\n" +
                    "01642484842"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/redcar/emmanuel-church-saltburn/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))



        // Add a marker in Brotton Food Bank
        val Brotton  = LatLng(54.567, 	-0.939328)
        map.addMarker(MarkerOptions()
            .position(Brotton)
            .title("Brotton Food Bank")
            .snippet("Brotton Methodist Church Centre\n" +
                    "High Street\n" +
                    "Brotton\n" +
                    "TS12 2PA\n" +
                    "01642484842"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/redcar/brotton-foodbank/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))



        // Add a marker in Redcar Food Bank
        val Redcar1  = LatLng(54.618411, 	-1.069532)
        map.addMarker(MarkerOptions()
            .position(Redcar1)
            .title("Redcar Food Bank")
            .snippet("10 Queen Street\n" +
                    "Redcar\n" +
                    "TS10 1DY\n" +
                    "01642484842"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/redcar/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))

        // Add a marker in All Saints Church Food Bank
        val Redcar2  = LatLng(54.605782, 	-1.092191)
        map.addMarker(MarkerOptions()
            .position(Redcar2)
            .title("All Saints Church Food Bank")
            .snippet("South Avenue\n" +
                    "Dormanstown\n" +
                    "TS10 5LL\n" +
                    "01642484842"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/redcar/all-saints-church/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))


        // Add a marker in Mersey Road Food Bank
        val Redcar3  = LatLng(54.607786, 	-1.077856)
        map.addMarker(MarkerOptions()
            .position(Redcar3)
            .title("Mersey Road Food Bank")
            .snippet("Newcomen Methodist Church\n" +
                    "Mersey Rd\n" +
                    "Redcar\n" +
                    "TS10 1NH\n" +
                    "01642484842"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/redcar/mersey-road/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))


        // Add a marker in Angel Trust Food Bank
        val BishopAuckland  = LatLng(54.66192, 	-1.673921)
        map.addMarker(MarkerOptions()
            .position(BishopAuckland)
            .title("Angel Trust Food Bank")
            .snippet("Belvedere House\n" +
                    "Kingsway\n" +
                    "Bishop Auckland\n" +
                    "DL14 7JN\n" +
                    "01388737270"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/angel-trust/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))



        // Add a marker in Shildon - Salvation Army Food Bank
        val Shildon  = LatLng(54.626202, 	-1.643559)
        map.addMarker(MarkerOptions()
            .position(Shildon)
            .title("Shildon Food Bank")
            .snippet("Cross Street\n" +
                    "Shildon\n" +
                    "DL4 1PF\n" +
                    "01388644277"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/salvation-army/shildon/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))


        // Add a marker in Sedgefield Food Bank
        val Sedgefield  = LatLng(	54.65375, 	-1.447951)
        map.addMarker(MarkerOptions()
            .position(Sedgefield)
            .title("Sedgefield Food Bank")
            .snippet("Sedgefield Town Council\n" +
                    "Front Street\n" +
                    "Sedgefield\n" +
                    "TS21 3AT\n" +
                    "01913037559"
                    + "\n" +
                    "\n" +
                    "Needs: https://www.givefood.org.uk/needs/at/durham/sedgefield/")
            .icon(fromVectorToBitmap(R.drawable.ic_baseline_fastfood_24, Color.parseColor("#FF69B4")))
            .alpha(0.9f))

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(darlington, 15f))
        map.uiSettings.apply {
            isZoomControlsEnabled = true
            isMyLocationButtonEnabled = true
            isMapToolbarEnabled = true
            isCompassEnabled = false

            //           isZoomGesturesEnabled = false
            //          isScrollGesturesEnabled = false
        }

        map.setInfoWindowAdapter(CustomIfoAdapter(this))
        setMapStyle(map)

        checkLocationPermission()

    }

    private fun checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED
        ) {
            map.isMyLocationEnabled = true
            Toast.makeText(this, "Already Enabled", Toast.LENGTH_SHORT).show()
        } else
            requestPermission()
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            1
        )
    }

    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode != 1) {
            return
        }
        if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show()
            map.isMyLocationEnabled = true
        } else
            Toast.makeText(this, "We need your permission!", Toast.LENGTH_SHORT).show()
    }

    private fun setMapStyle(googleMap: GoogleMap){
        try{
            val success = googleMap.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                    this,
                    R.raw.style
                )
            )
            if(!success){
                Log.d("Maps", "Failed to add Style")
            }
        }catch (e: Exception){
            Log.d("Maps", e.toString())
        }
    }
    private fun fromVectorToBitmap(id: Int, color: Int): BitmapDescriptor {
        val vectorDrawable: Drawable? = ResourcesCompat.getDrawable(resources, id, null)
        if(vectorDrawable == null){
            Log.d("MapsActivity", "Resource not found")
            return BitmapDescriptorFactory.defaultMarker()
        }
        val bitmap = Bitmap.createBitmap(
            vectorDrawable.intrinsicWidth,
            vectorDrawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        vectorDrawable.setBounds(0,0, canvas.width, canvas.height)
        DrawableCompat.setTint(vectorDrawable, color)
        vectorDrawable.draw(canvas)
        return BitmapDescriptorFactory.fromBitmap(bitmap)
    }

}