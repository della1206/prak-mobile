package com.example.della_apps.Home.pertemuan_5

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.della_apps.databinding.ActivityFifthBinding
import com.example.della_apps.R

class FifthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFifthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnWebView.iconTint = ColorStateList.valueOf(Color.parseColor("#FFD700"))

        setSupportActionBar(binding.toolbar)

        supportActionBar?.apply {
            title = "Della apps"
            subtitle = "Mode Improvisasi Aktif"
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
            setDisplayHomeAsUpEnabled(true)
        }
        binding.btnWebView.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }
    }

    // 4. Membuat/Meng-inflate Option Menu dari XML
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    // 5. Menangani klik pada item menu di Toolbar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            // Menangani tombol Back di Toolbar
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }
            // Menangani klik Search
            R.id.action_search -> {
                Toast.makeText(this, "Search Clicked", Toast.LENGTH_SHORT).show()
                true
            }
            // Menangani klik Settings
            R.id.action_settings -> {
                Toast.makeText(this, "Settings Clicked", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
