package com.example.della_apps

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.della_apps.databinding.ActivityAuthBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Akses SharedPreferences untuk menyimpan status login
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        binding.btnLogin.setOnClickListener {
            val email = binding.email.text.toString().trim()
            val password = binding.password.text.toString().trim()

            // Logika: Email harus sama dengan Password dan tidak boleh kosong
            if (email == password && email.isNotEmpty()) {

                // Simpan data login ke SharedPreferences
                sharedPref.edit {
                    putBoolean("isLogin", true)
                    putString("email", email)
                    apply() // Pastikan data tersimpan secara permanen
                }

                // FIX: Arahkan ke MainActivity, bukan AuthActivity!
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

                // Tutup AuthActivity agar tidak bisa kembali dengan tombol back
                finish()

                Toast.makeText(this, "Selamat Datang, $email", Toast.LENGTH_SHORT).show()
            } else {
                // Tampilkan dialog jika login gagal
                MaterialAlertDialogBuilder(this)
                    .setTitle("Ooopss...")
                    .setMessage("Email atau password salah! (Tips: Isi email dan password dengan kata yang sama)")
                    .setPositiveButton("Tutup") { dialog, _ -> dialog.dismiss() }
                    .show()
            }
        }
    }
}