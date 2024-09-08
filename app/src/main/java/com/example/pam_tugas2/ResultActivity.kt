package com.example.pam_tugas2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    private lateinit var textViewResult: TextView
    private lateinit var textViewNim: TextView
    private lateinit var textViewNama: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        textViewResult = findViewById(R.id.textViewResult)
        textViewNim = findViewById(R.id.textViewNim)
        textViewNama = findViewById(R.id.textViewNama)

        // Ambil data dari Intent
        val result = intent.getDoubleExtra("result", 0.0)
        val nim = intent.getStringExtra("nim")
        val nama = intent.getStringExtra("nama")

        // Tampilkan hasil
        textViewResult.text = "Hasil Perhitungan: $result"
        textViewNim.text = "NIM: $nim"
        textViewNama.text = "Nama: $nama"
    }
}
