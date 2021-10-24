package com.example.room_ex.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.room_ex.R
import com.example.room_ex.databinding.FragmentHomeBinding
import com.example.room_ex.ui.home.adapter.SomethingAdapter

class HomeFragment : Fragment() {

    private val somethingAdapter by lazy{
        SomethingAdapter()
    }

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUI()
        setUpViewModel()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpViewModel() {
        homeViewModel.observeAllSomething().observe(viewLifecycleOwner) {
            somethingAdapter.set(it)
        }
    }

    private fun setUpUI() {
        binding.recyclerView.apply {
            adapter= somethingAdapter
            layoutManager= LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
        }

        binding.addSomething.setOnClickListener {
            homeViewModel.addStaticSomethingModel()
        }

        binding.deleteSomething.setOnClickListener {
            val item = somethingAdapter.items.last()
            homeViewModel.deleteSomethingModel(item)
        }

        binding.updateSomething.setOnClickListener {
            val item = somethingAdapter.items.last()
            homeViewModel.updateSomethingModel(item)
        }
    }
}