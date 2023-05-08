package com.example.basicapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.basicapp.databinding.FragmentRoutinesBinding
import org.w3c.dom.Text

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Routines.newInstance] factory method to
 * create an instance of this fragment.
 */
class Routines : Fragment() {


    private lateinit var binding: FragmentRoutinesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentRoutinesBinding.inflate(layoutInflater)

    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = binding.root

        val value = arguments?.getString("value")
        if(value != ""){
            binding.routineLayouts.removeAllViews()
            binding.routineLayouts.gravity = Gravity.NO_GRAVITY

            val textView = TextView(context)
            textView.text = "$value\n Last Run Never"
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_message_24, 0,0,0)

            binding.routineLayouts.addView(textView)
        }
        // Inflate the layout for this fragment
        return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Routines.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Routines().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}