package com.example.basicapp

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.basicapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var toolBar: Toolbar

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //make the app open by default with the favourites fragment
        replaceFragment(Favorites())

        val preferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(this)

        val value = preferences.getString("value", "")

        val bundle = Bundle()
        bundle.putString("value", value)

        val fragmentRoutines = Routines()
        fragmentRoutines.arguments = bundle

        binding.bottomNavigationView3.setOnItemSelectedListener {
            when(it.itemId){
                R.id.favorites -> replaceFragment(Favorites())
                R.id.things -> replaceFragment(Things())
                R.id.routines -> replaceFragment(fragmentRoutines)
                R.id.ideas -> replaceFragment(Ideas())
                R.id.settings -> replaceFragment(Settings())

                else -> {

                }
            }

            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout3, fragment)
        fragmentTransaction.commit()
    }

    fun Back(view: View) {
        finish()
    }

}