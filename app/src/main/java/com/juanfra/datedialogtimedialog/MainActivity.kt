package com.juanfra.datedialogtimedialog

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

/*
Autor: Juan Francisco Sánchez González
Fecha: 20/10/2024
Clase: Actividad con 2 botones, uno para mostrar un cuadro de diálogo DatePickerDialog y otro para
mostrar un TimePickerDialog. Los datos seleccionados por el usuario son mostrados por un mensaje Toast.
*/

class MainActivity : AppCompatActivity() {

    // Objetos para los botnoes
    lateinit var btnDate: Button
    lateinit var btnTime: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        init()
    }

    // Se instancian los botones y se les asignan sus manejadores de eventos
    private fun init() {
        btnDate = findViewById(R.id.DateDialog)
        btnTime = findViewById(R.id.TimeDialog)

        btnDate.setOnClickListener {
            mostrarDatePickerDialog()
        }

        btnTime.setOnClickListener {
            mostrarTimePickerDialog()
        }
    }

    // Se muestra el cuadro de diálogo DatePickerDialog
    private fun mostrarDatePickerDialog() {
        // Obtén la fecha actual
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        // Crea el DatePickerDialog con la fecha actual
        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                // Aquí puedes manejar la fecha seleccionada, si lo necesitas
                // Por ejemplo, mostrarla en un TextView o usarla en otra parte
                Toast.makeText(this, getString(R.string.toast_date_text, selectedDay, selectedMonth, selectedYear), Toast.LENGTH_SHORT).show()
            },
            year,
            month,
            day
        )
        // Muestra el DatePickerDialog
        datePickerDialog.show()
    }

    // Se muestra el cuadro de diálogo TimePickerDialog
    private fun mostrarTimePickerDialog() {
        // Obtén la hora actual
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        // Crea el TimePickerDialog con la hora actual
        val timePickerDialog = TimePickerDialog(
            this,
            { _, selectedHour, selectedMinute ->
                // Aquí puedes manejar la hora seleccionada, si lo necesitas
                // Por ejemplo, mostrarla en un TextView o usarla en otra parte
                Toast.makeText(this, getString(R.string.toast_time_text, selectedHour, selectedMinute), Toast.LENGTH_SHORT).show()
            },
            hour,
            minute,
            true // true para formato 24 horas, false para formato 12 horas
        )
        // Muestra el TimePickerDialog
        timePickerDialog.show()
    }

}