package com.cesar.laboratorio04

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // AutoComplete
    val presidents = arrayOf(
        "José Luis Bustamante",
        "Zenón Noriega",
        "Manuel Odriá",
        "Manuel Prado",
        "Fco Morales Bermúdez",
        "Fernando Belaunde",
        "Alberto Fujimori",
        "Valentín Paniagua",
        "Alejandro Toledo",
        "Alan García",
        "Pedro Pablo Kuczynski",
        "Martín Alberto Vizcarra",
        "Pedro Castillo Terrones",
        "Dina Boluarte Zegarra",
        "Jose Jeri Ore"
    )

    // Layouts
    lateinit var layoutAuto: LinearLayout
    lateinit var layoutReloj: LinearLayout
    lateinit var layoutCalendario: LinearLayout

    // Pickers
    lateinit var timePicker: TimePicker
    lateinit var timePickerCalendario: TimePicker
    lateinit var datePicker: DatePicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Layouts
        layoutAuto = findViewById(R.id.layoutAuto)
        layoutReloj = findViewById(R.id.layoutReloj)
        layoutCalendario = findViewById(R.id.layoutCalendario)

        // Botones
        val btnAuto = findViewById<Button>(R.id.btnAuto)
        val btnReloj = findViewById<Button>(R.id.btnReloj)
        val btnCalendario = findViewById<Button>(R.id.btnCalendario)

        // AutoComplete
        val txtPresidentes = findViewById<AutoCompleteTextView>(R.id.txtPresidentes)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            presidents
        )
        txtPresidentes.setAdapter(adapter)
        txtPresidentes.threshold = 3

        // TimePicker
        timePicker = findViewById(R.id.timePicker)
        timePicker.setIs24HourView(true)

        // Calendario
        timePickerCalendario = findViewById(R.id.timePickerCalendario)
        timePickerCalendario.setIs24HourView(true)

        datePicker = findViewById(R.id.datePicker)

        // Eventos botones
        btnAuto.setOnClickListener { mostrar(layoutAuto) }
        btnReloj.setOnClickListener { mostrar(layoutReloj) }
        btnCalendario.setOnClickListener { mostrar(layoutCalendario) }
    }

    // Mostrar solo una seccion
    private fun mostrar(layout: LinearLayout) {
        layoutAuto.visibility = View.GONE
        layoutReloj.visibility = View.GONE
        layoutCalendario.visibility = View.GONE

        layout.visibility = View.VISIBLE
    }

    // Metodo de reloj
    fun onClick(view: View) {
        val hora = timePicker.hour
        val minuto = timePicker.minute

        Toast.makeText(
            baseContext,
            "Hora seleccionada $hora:$minuto",
            Toast.LENGTH_SHORT
        ).show()
    }

    // CALENDARIO
    fun mostrarFechaHora(view: View) {
        val dia = datePicker.dayOfMonth
        val mes = datePicker.month + 1
        val anio = datePicker.year

        val hora = timePickerCalendario.hour
        val minuto = timePickerCalendario.minute

        Toast.makeText(
            this,
            "Fecha: $dia/$mes/$anio Hora: $hora:$minuto",
            Toast.LENGTH_LONG
        ).show()
    }
}