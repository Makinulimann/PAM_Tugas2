package com.example.pam_tugas2


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pam_tugas2.ui.theme.PAM_Tugas2Theme

class MainActivity : AppCompatActivity() {
    private lateinit var editTextNumber1: EditText
    private lateinit var editTextNumber2: EditText
    private lateinit var radioGroupOperations: RadioGroup
    private lateinit var buttonCalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextNumber1 = findViewById(R.id.editTextNumber1)
        editTextNumber2 = findViewById(R.id.editTextNumber2)
        radioGroupOperations = findViewById(R.id.radioGroupOperations)
        buttonCalculate = findViewById(R.id.buttonCalculate)

        buttonCalculate.setOnClickListener {
            val num1 = editTextNumber1.text.toString().toDoubleOrNull() ?: 0.0
            val num2 = editTextNumber2.text.toString().toDoubleOrNull() ?: 0.0
            var result = 0.0

            when (radioGroupOperations.checkedRadioButtonId) {
                R.id.radioButtonAdd -> result = num1 + num2
                R.id.radioButtonSubtract -> result = num1 - num2
                R.id.radioButtonMultiply -> result = num1 * num2
                R.id.radioButtonDivide -> result = if (num2 != 0.0) num1 / num2 else 0.0
            }

            // Kirim data ke halaman kedua
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("result", result)
            intent.putExtra("nim", "12345678") // Ganti dengan NIM Anda
            intent.putExtra("nama", "Nama Anda") // Ganti dengan Nama Anda
            startActivity(intent)
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PAM_Tugas2Theme {
        Greeting("Android")
    }
}