package com.example.basicapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.basicapp.databinding.FragmentFavoritesBinding


class Favorites : Fragment() {
 private lateinit var binding: FragmentFavoritesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentFavoritesBinding.inflate(layoutInflater)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = binding.root
        binding.toCreate.setOnClickListener{
            val intent = Intent(context, CreateRoutines::class.java )
            startActivity(intent)
        }
        return  v
    }

    fun Route(view: View) {}

}