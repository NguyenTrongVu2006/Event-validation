package com.ute.eventvalidation

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var edtHoTen: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtSdt: EditText
    private lateinit var edtMsv: EditText
    private lateinit var edtLop: EditText
    private lateinit var btnDangKy: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtHoTen = findViewById(R.id.edtHoTen)
        edtEmail = findViewById(R.id.edtEmail)
        edtSdt = findViewById(R.id.edtSdt)
        edtMsv = findViewById(R.id.edtMsv)
        edtLop = findViewById(R.id.edtLop)
        btnDangKy = findViewById(R.id.btnDangKy)

        btnDangKy.setOnClickListener {
            if (kiemTraValidation()) {
                val hoTen = edtHoTen.text.toString().trim()
                val email = edtEmail.text.toString().trim()
                val sdt = edtSdt.text.toString().trim()
                val msv = edtMsv.text.toString().trim()
                val lop = edtLop.text.toString().trim()

                Snackbar.make(findViewById(R.id.mainLayout), "Đăng ký thành công!", Snackbar.LENGTH_LONG)
                    .setAction("XEM CHI TIẾT") {
                        val intent = Intent(this, ChiTietActivity::class.java).apply {
                            putExtra("HO_TEN", hoTen)
                            putExtra("EMAIL", email)
                            putExtra("SDT", sdt)
                            putExtra("MSV", msv)
                            putExtra("LOP", lop)
                        }
                        startActivity(intent)
                    }.show()
            }
        }
    }

    private fun kiemTraValidation(): Boolean {
        var isValid = true

        val hoTen = edtHoTen.text.toString().trim()
        val email = edtEmail.text.toString().trim()
        val sdt = edtSdt.text.toString().trim()
        val msv = edtMsv.text.toString().trim()
        val lop = edtLop.text.toString().trim()

        if (hoTen.isEmpty()) {
            edtHoTen.error = "Họ tên không được để trống"
            isValid = false
        }

        if (email.isEmpty()) {
            edtEmail.error = "Email không được để trống"
            isValid = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtEmail.error = "Email không đúng định dạng (VD: abc@gmail.com)"
            isValid = false
        }

        if (sdt.isEmpty()) {
            edtSdt.error = "Số điện thoại không được để trống"
            isValid = false
        } else if (!sdt.matches(Regex("^0[0-9]{9}$"))) {
            edtSdt.error = "SĐT phải có 10 chữ số và bắt đầu bằng số 0"
            isValid = false
        }

        if (msv.isEmpty()) {
            edtMsv.error = "Mã sinh viên không được để trống"
            isValid = false
        }

        if (lop.isEmpty()) {
            edtLop.error = "Lớp không được để trống"
            isValid = false
        }

        return isValid
    }
}