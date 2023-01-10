package com.saitawngpha.drawableexample

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout : DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        val navView : NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //set nav click listener
        navView.setNavigationItemSelectedListener {
            closeDrawer()
            when(it.itemId){
                R.id.home -> {
                    Toast.makeText(applicationContext, "Home coming soon!", Toast.LENGTH_SHORT).show()}
                R.id.favorite -> Toast.makeText(applicationContext, "Favorite coming soon!", Toast.LENGTH_SHORT).show()
                R.id.settings -> Toast.makeText(applicationContext, "Settings coming soon!", Toast.LENGTH_SHORT).show()
                R.id.share -> Toast.makeText(applicationContext, "Share coming soon!", Toast.LENGTH_SHORT).show()
                R.id.rate -> Toast.makeText(applicationContext, "Rate us coming soon!", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    fun openDrawer(v: View){
        closeDrawer()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun closeDrawer() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            drawerLayout.openDrawer(GravityCompat.START)
        }
    }
}