package com.example.navbar_drawerbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast

import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.app_bar.*
import java.lang.reflect.Array.newInstance

lateinit var drawerLayout: DrawerLayout
lateinit var navigationView: NavigationView
lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        drawerLayout=findViewById(R.id.drawer_layout)
        navigationView=findViewById(R.id.nav)
        val toolbar: Toolbar =findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        navigationView.setNavigationItemSelectedListener(this)
        actionBarDrawerToggle= object :ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.open,
            R.string.close
        ){
            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                setTitle(R.string.app_name)
            }

            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)
                setTitle(R.string.app_name)
            }
        }
        actionBarDrawerToggle.isDrawerIndicatorEnabled=true
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
    }
    override fun onBackPressed() {
        //  var layout = findViewById(R.id.drawer_layout) asDrawerLayout
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed()
        }}
    fun createFragment(fragment: Fragment){
        val currentFragment=supportFragmentManager.findFragmentById(R.id.frameCont)
        if(currentFragment==null){
            //Content.newInstance(par,pos)
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frameCont,fragment)
                .addToBackStack(null)
                .commit()

        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment:Fragment
        when (item.itemId) {
            R.id.profile -> {
                fragment=con_fragment.newInstance("Profile",item.itemId)
                createFragment(fragment)
                toolbar.setTitle("Profile")
                Toast.makeText(this, "profile", Toast.LENGTH_SHORT).show()
                // Handle favorite icon press
                true
            }
            R.id.setting -> {
                // Handle search icon press
                fragment=con_fragment.newInstance("setting",item.itemId)
                createFragment(fragment)
                toolbar.setTitle("Setting")
                Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.aboutUs -> {
                // Handle more item (inside overflow menu) press
                fragment=con_fragment.newInstance("aboutUs",item.itemId)
                createFragment(fragment)
                toolbar.setTitle("AboutUs")
                Toast.makeText(this, "aboutUs", Toast.LENGTH_SHORT).show()
                true
            }
            else -> false
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true
    }
}