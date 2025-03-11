package VentanasLMT

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lmt.R

class JuegosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_juegos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnVorF = findViewById<Button>(R.id.VorF)
        btnVorF.setOnClickListener { NavegateVoF() }
        val btnMultiple = findViewById<Button>(R.id.Mutiple)
        btnMultiple.setOnClickListener { NavegateMultiple() }
        val btnRegresar = findViewById<Button>(R.id.Menu)
        btnRegresar.setOnClickListener { NavegateMenu() }
    }

    private fun NavegateMenu() {
        val intent = Intent(this, MenuPrincipalActivity::class.java)
        startActivity(intent)
    }

    private fun NavegateMultiple() {
        val intent = Intent(this, MultipleOpActivity::class.java)
        startActivity(intent)
    }

    private fun NavegateVoF() {
        val intent = Intent(this, VerdaderoOrFalsoActivity::class.java)
        startActivity(intent)
    }
}