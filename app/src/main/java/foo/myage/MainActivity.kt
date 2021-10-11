package foo.myage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

    lateinit var editPersonName: EditText
    lateinit var editBirthYear: EditText
    lateinit var btnAgeCalc: Button
    lateinit var btnNewCalc: Button
    lateinit var txtResult: TextView
    lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()
        initButtonClick()
    }

    private fun initComponents() {
        editPersonName = findViewById(R.id.editPersonName)
        editBirthYear = findViewById(R.id.editBirthYear)
        btnAgeCalc = findViewById(R.id.btnAgeCalc)
        btnNewCalc = findViewById(R.id.btnNewCalc)
        txtResult = findViewById(R.id.txtResult)
        btnLogout = findViewById(R.id.btnLogout)

        txtResult.setText("")
    }

    private fun initButtonClick() {
        btnAgeCalc.setOnClickListener {
            val personName = editPersonName.text
            val birthYear = editBirthYear.text.toString().toInt()
            val thisYear = LocalDate.now().year

            val age = thisYear - birthYear

            txtResult.setText("$personName, você tem $age anos de idade")
        }

        btnNewCalc.setOnClickListener {
            editPersonName.setText("")
            editBirthYear.setText("")
            txtResult.setText("")
        }

        btnLogout.setOnClickListener {
            finish()
        }
    }
}