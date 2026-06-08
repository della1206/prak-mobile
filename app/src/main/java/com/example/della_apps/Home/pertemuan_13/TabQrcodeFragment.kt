package com.example.della_apps.Home.pertemuan_13

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.della_apps.R
import com.example.della_apps.databinding.FragmentTabQrcodeBinding

class TabQrcodeFragment : Fragment() {
    private var _binding: FragmentTabQrcodeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentTabQrcodeBinding.inflate(inflater, container, false)
        return binding.root
    }
}