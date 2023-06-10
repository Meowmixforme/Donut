package uk.ac.tees.scedt.ad.b_donut

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import uk.ac.tees.scedt.ad.b_donut.databinding.MapMainBinding


class MenuActivity : AppCompatActivity() {

    lateinit var binding: MapMainBinding
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= MapMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            toggle = ActionBarDrawerToggle(this@MenuActivity, drawerLayout, R.string.open,R.string.close)
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()


            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            navView.setNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.Registration->{
                        Toast.makeText(this@MenuActivity, "Registration Clicked", Toast.LENGTH_SHORT).show()}
                    R.id.Login->{Toast.makeText(this@MenuActivity, "Login Clicked", Toast.LENGTH_SHORT).show()}
                    R.id.Order->{Toast.makeText(this@MenuActivity, "Order Clicked", Toast.LENGTH_SHORT).show()}
                    R.id.Map->{Toast.makeText(this@MenuActivity, "Map Clicked", Toast.LENGTH_SHORT).show()}
                    R.id.Recipe->{Toast.makeText(this@MenuActivity, "Recipe Clicked", Toast.LENGTH_SHORT).show()}


                }
                true
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}