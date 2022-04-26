package com.example.physicswallahassignment.fragment

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.physicswallahassignment.R
import com.example.physicswallahassignment.adapter.MyAdapter
import com.example.physicswallahassignment.application.UserApplication
import com.example.physicswallahassignment.models.ApiResponseItem
import com.example.physicswallahassignment.viewmodel.UsersViewModel
import com.example.physicswallahassignment.viewmodel.UsersViewModelFactory

class ListFragment : Fragment(R.layout.fragment_list) {
    private lateinit var userViewModel: UsersViewModel
    private lateinit var adapter: MyAdapter
    private val teacherList: MutableList<ApiResponseItem> = mutableListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back)

        val recycleView = getView()?.findViewById<RecyclerView>(R.id.recycle_view)
        adapter = MyAdapter(requireContext(), teacherList)
        recycleView?.layoutManager = LinearLayoutManager(context)
        recycleView?.adapter = adapter
        val userRepository = (activity?.application as UserApplication).userRepository
        userViewModel = ViewModelProvider(
            this,
            UsersViewModelFactory(userRepository)
        )[UsersViewModel::class.java]


        userViewModel.users.observe(viewLifecycleOwner, Observer {
            teacherList.clear()
            teacherList.addAll(it)
            adapter.notifyDataSetChanged()
        })
    }
}