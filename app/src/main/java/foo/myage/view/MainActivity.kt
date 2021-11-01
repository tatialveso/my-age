package foo.myage.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import foo.myage.R
import foo.myage.controller.PersonController
import foo.myage.model.Person
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

    lateinit var editPersonName: EditText
    lateinit var editBirthYear: EditText
    lateinit var btnAgeCalc: Button
    lateinit var btnNewCalc: Button
    lateinit var txtResult: TextView
    lateinit var btnLogout: Button
    lateinit var person: Person
    lateinit var personController: PersonController

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
        person = Person()
        personController = PersonController(person)

        txtResult.setText("")
    }

    private fun initButtonClick() {
        btnAgeCalc.setOnClickListener {
            var validation = true

            if(editPersonName.text.isEmpty()) {
                validation = false
                editPersonName.setError("Campo obrigatório!")
                editPersonName.requestFocus()
            }
            if(editBirthYear.text.isEmpty()) {
                validation = false
                editBirthYear.setError("Campo obrigatório!")
                editBirthYear.requestFocus()
            }

            if(validation) {
                var firstName = editPersonName.text.toString()
                val birthYear = editBirthYear.text.toString().toInt()
                person.firstName = firstName
                person.birthYear = birthYear

                val age = personController.calcAgeInYears()

                txtResult.setText("${person.firstName}, você tem $age anos de vida.")
            }
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