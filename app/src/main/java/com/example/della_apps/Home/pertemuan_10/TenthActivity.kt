package com.example.della_apps.Home.pertemuan_10

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.della_apps.R
import com.example.della_apps.databinding.ActivityTenthBinding
import com.google.android.material.tabs.TabLayoutMediator

class TenthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTenthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityTenthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Setup Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Pertemuan 10"
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        // 1. Inisialisasi Adapter Utama
        val tabsAdapter = TenthTabsAdapter(this)
        binding.viewPager.adapter = tabsAdapter

        // 2. Hubungkan TabLayout & ViewPager2 + Konfigurasi Atribut Eksklusif
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Tab A"
                    tab.setIcon(R.drawable.ic_home)
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true // Memasang titik merah notifikasi dasar
                }
                1 -> {
                    tab.text = "Tab B"
                    tab.setIcon(R.drawable.ic_home)
                    val badge = tab.getOrCreateBadge()
                    badge.number = 5 // Memasang badge angka 5 sesuai instruksi target
                    badge.isVisible = true
                }
                2 -> {
                    tab.text = "Produk"
                    tab.setIcon(android.R.drawable.ic_menu_view) // Ikon bawaan sistem Android (Kacamata/View)
                }
            }
        }.attach()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}