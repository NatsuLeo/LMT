package VentanasLMT

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lmt.R

class MenuPrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_principal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val botonperfil = findViewById<Button>(R.id.perfil)
        botonperfil.setOnClickListener { NevagateappP() }
        val botonjuegos = findViewById<Button>(R.id.Juegos)
        botonjuegos.setOnClickListener { NevagateappJ() }
        val botontablas = findViewById<Button>(R.id.Tablas)
        botontablas.setOnClickListener { NevagateappT() }
    }
    private fun NevagateappP(){
        val intent = Intent(this, PerfilActivity::class.java)
        startActivity(intent)
    }
    private fun NevagateappJ(){
        val intent = Intent(this, JuegosActivity::class.java)
        startActivity(intent)
    }
    private fun NevagateappT(){
        val intent = Intent(this, TablasActivity::class.java)
        startActivity(intent)
    }
}