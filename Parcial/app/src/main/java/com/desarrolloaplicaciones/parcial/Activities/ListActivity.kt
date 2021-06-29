package com.desarrolloaplicaciones.parcial.activities

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.preference.PreferenceManager
import com.desarrolloaplicaciones.parcial.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.LabelVisibilityMode.LABEL_VISIBILITY_LABELED
import com.google.android.material.bottomnavigation.LabelVisibilityMode.LABEL_VISIBILITY_UNLABELED


class ListActivity : AppCompatActivity() {

    private lateinit var bottomNavView : BottomNavigationView
    private lateinit var navHostFragment : NavHostFragment



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            setContentView(R.layout.activity_list)
            // ... rest of body of onCreateView() ...
        } catch (e: Exception) {
            Log.e("LIST ACTIVITY FAILURE", "onCreateView", e)
            throw e
        }



        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment

        bottomNavView = findViewById(R.id.bottom_bar)

        NavigationUI.setupWithNavController(bottomNavView, navHostFragment.navController)

        val prefs = PreferenceManager.getDefaultSharedPreferences(this.applicationContext)

        when (prefs.getBoolean("button_key",false)) {
            true -> bottomNavView.labelVisibilityMode = LABEL_VISIBILITY_LABELED
            false -> bottomNavView.labelVisibilityMode = LABEL_VISIBILITY_UNLABELED

        }


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.top_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.action_settings -> {
                val intent = Intent(this, SettingsActivity::class.java).apply {
                    putExtra(AlarmClock.EXTRA_MESSAGE,  "going settingss")

                }
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}