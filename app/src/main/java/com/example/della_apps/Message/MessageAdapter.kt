package com.example.della_apps.Message

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.della_apps.databinding.ItemMessageBinding

class MessageAdapter(
    context: Context,
    private val messages: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, messages) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemMessageBinding.inflate(LayoutInflater.from(context), parent,
            false)
        val data = messages[position]

        binding.textSender.text = data.senderName
        binding.textMessage.text = data.messageText

        // Memuat gambar dari folder drawable menggunakan Glide
        Glide.with(context)
            .load(data.avatarRes)
            .circleCrop() // Agar foto profil berbentuk bulat
            .placeholder(android.R.drawable.ic_menu_gallery)
            .into(binding.avatarImg)

        return binding.root
    }
}