package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.appbar.MaterialToolbar
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the content view to the activity_main.xml layout
        setContentView(R.layout.activity_main)
        // Find the MaterialToolbar view in the layout by its ID
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        // Set the toolbar as the support action bar
        setSupportActionBar(toolbar)
        // Find the NavHostFragment by its ID
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        // Get the NavController associated with the NavHostFragment
        val navController = navHostFragment.navController
        // Create an AppBarConfiguration based on the NavController's graph
        val builder = AppBarConfiguration.Builder(navController.graph)
        val appBarConfiguration = builder.build()
        // Set up the toolbar with the NavController and AppBarConfiguration
        toolbar.setupWithNavController(navController, appBarConfiguration)

        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNavView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu_toolbar.xml menu resource
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        // Call the superclass method for creating the options menu
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Get the NavController associated with the NavHostFragment
        val navController = findNavController(R.id.nav_host_fragment)
        // Use the onNavDestinationSelected method to handle menu item clicks
        return item.onNavDestinationSelected(navController)
                || super.onOptionsItemSelected(item)
    }
}
