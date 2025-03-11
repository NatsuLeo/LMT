package VentanasLMT

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lmt.R

class Calificacion2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calificacion2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val correctCount = intent.getIntExtra("correctCount", 0)
        val incorrectCount = intent.getIntExtra("incorrectCount", 0)

        val calificacionTextView = findViewById<TextView>(R.id.calificacionTextView2)
        calificacionTextView.text = "Felicidades tu calificacion es: \nAciertos: $correctCount\nErrores: $incorrectCount"

        findViewById<Button>(R.id.Regresar2).setOnClickListener {
            val intent = Intent(this, JuegosActivity::class.java)
            startActivity(intent)
            finish()
        }

        findViewById<Button>(R.id.Reintentar2).setOnClickListener {
            val intent = Intent(this, MultipleOpActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
