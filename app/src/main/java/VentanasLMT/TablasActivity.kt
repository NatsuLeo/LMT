package VentanasLMT

import VentanasLMT.TablasUnoAlDiez.Tabla10Activity
import VentanasLMT.TablasUnoAlDiez.Tabla1Activity
import VentanasLMT.TablasUnoAlDiez.Tabla2Activity
import VentanasLMT.TablasUnoAlDiez.Tabla3Activity
import VentanasLMT.TablasUnoAlDiez.Tabla4Activity
import VentanasLMT.TablasUnoAlDiez.Tabla5Activity
import VentanasLMT.TablasUnoAlDiez.Tabla6Activity
import VentanasLMT.TablasUnoAlDiez.Tabla7Activity
import VentanasLMT.TablasUnoAlDiez.Tabla8Activity
import VentanasLMT.TablasUnoAlDiez.Tabla9Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lmt.R

class TablasActivity : AppCompatActivity() {

    private lateinit var btntabla1: Button
    private lateinit var btntabla2: Button
    private lateinit var btntabla3: Button
    private lateinit var btntabla4: Button
    private lateinit var btntabla5: Button
    private lateinit var btntabla6: Button
    private lateinit var btntabla7: Button
    private lateinit var btntabla8: Button
    private lateinit var btntabla9: Button
    private lateinit var btntabla10: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tablas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btntabla1 = findViewById(R.id.TablaUno)
        btntabla1.setOnClickListener { NavegateTabla1() }
        btntabla2 = findViewById(R.id.TablaDos)
        btntabla2.setOnClickListener { NavegateTabla2() }
        btntabla3 = findViewById(R.id.TablaTres)
        btntabla3.setOnClickListener { NavegateTabla3() }
        btntabla4 = findViewById(R.id.TablaCuatro)
        btntabla4.setOnClickListener { NavegateTabla4() }
        btntabla5 = findViewById(R.id.TablaCinco)
        btntabla5.setOnClickListener { NavegateTabla5() }
        btntabla6 = findViewById(R.id.TablaSeis)
        btntabla6.setOnClickListener { NavegateTabla6() }
        btntabla7 = findViewById(R.id.TablaSiete)
        btntabla7.setOnClickListener { NavegateTabla7() }
        btntabla8 = findViewById(R.id.TablaOcho)
        btntabla8.setOnClickListener { NavegateTabla8() }
        btntabla9 = findViewById(R.id.TablaNueve)
        btntabla9.setOnClickListener { NavegateTabla9() }
        btntabla10 = findViewById(R.id.TablaDiez)
        btntabla10.setOnClickListener { NavegateTabla10() }
    }

    private fun NavegateTabla1() {
        val intent = Intent(this, Tabla1Activity::class.java)
        startActivity(intent)
    }
    private fun NavegateTabla2() {
        val intent = Intent(this, Tabla2Activity::class.java)
        startActivity(intent)
    }
    private fun NavegateTabla3() {
        val intent = Intent(this, Tabla3Activity::class.java)
        startActivity(intent)
    }
    private fun NavegateTabla4() {
        val intent = Intent(this, Tabla4Activity::class.java)
        startActivity(intent)
    }
    private fun NavegateTabla5() {
        val intent = Intent(this, Tabla5Activity::class.java)
        startActivity(intent)
    }
    private fun NavegateTabla6() {
        val intent = Intent(this, Tabla6Activity::class.java)
        startActivity(intent)
    }
    private fun NavegateTabla7() {
        val intent = Intent(this, Tabla7Activity::class.java)
        startActivity(intent)
    }
    private fun NavegateTabla8() {
        val intent = Intent(this, Tabla8Activity::class.java)
        startActivity(intent)
    }
    private fun NavegateTabla9() {
        val intent = Intent(this, Tabla9Activity::class.java)
        startActivity(intent)
    }
    private fun NavegateTabla10() {
        val intent = Intent(this, Tabla10Activity::class.java)
        startActivity(intent)
    }
}