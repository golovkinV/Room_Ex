package com.example.room_ex.ui.floating

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.room_ex.databinding.FragmentFloatingBinding
import com.example.room_ex.databinding.FragmentHomeBinding
import com.example.room_ex.ui.home.HomeViewModel

class FloatingFragment: Fragment() {

    private lateinit var floatingViewModel: FloatingViewModel
    private var _binding: FragmentFloatingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        floatingViewModel = ViewModelProvider(this).get(FloatingViewModel::class.java)
        _binding = FragmentFloatingBinding.inflate(inflater, container, false)
        return binding.root
    }
}