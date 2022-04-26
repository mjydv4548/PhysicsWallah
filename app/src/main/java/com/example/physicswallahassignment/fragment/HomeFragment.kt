package com.example.physicswallahassignment.fragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.physicswallahassignment.R

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fetchData = getView()?.findViewById<Button>(R.id.fetch_data)

        fetchData?.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToListFragment()
            findNavController().navigate(action)
        }

    }


}