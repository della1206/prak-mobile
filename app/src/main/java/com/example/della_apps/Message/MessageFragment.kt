package com.example.della_apps.Message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.della_apps.R
import com.example.della_apps.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val messageList = listOf(
            MessageModel("Alya", "Halo Della! Apa kabar?", R.drawable.alya),
            MessageModel("Budi", "Sudah makan belum?", R.drawable.budi), // Pastikan sudah di-rename jadi huruf kecil
            MessageModel("Citra", "Jangan lupa tugasnya ya!", R.drawable.citra),
            MessageModel("Dika", "Besok kita rapat jam 9", R.drawable.dika),
            MessageModel("Eka", "Nice job buat project-nya!", R.drawable.eka)
        )

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}