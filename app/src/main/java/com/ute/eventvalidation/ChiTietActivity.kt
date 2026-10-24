package com.ute.eventvalidation

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ChiTietActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet)

        val tvThongTin = findViewById<TextView>(R.id.tvThongTin)
        val btnQuayLai = findViewById<Button>(R.id.btnQuayLai)

        val hoTen = intent.getStringExtra("HO_TEN") ?: ""
        val email = intent.getStringExtra("EMAIL") ?: ""
        val sdt = intent.getStringExtra("SDT") ?: ""
        val msv = intent.getStringExtra("MSV") ?: ""
        val lop = intent.getStringExtra("LOP") ?: ""

        tvThongTin.text = "• Họ và tên: $hoTen\n\n" +
                "• Email: $email\n\n" +
                "• Số điện thoại: $sdt\n\n" +
                "• Mã sinh viên: $msv\n\n" +
                "• Lớp: $lop"

        btnQuayLai.setOnClickListener {
            finish()
        }
    }
}