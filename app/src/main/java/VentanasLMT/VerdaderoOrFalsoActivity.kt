package VentanasLMT

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lmt.R
import kotlin.random.Random

class VerdaderoOrFalsoActivity : AppCompatActivity() {

    private lateinit var equationTextView: TextView
    private lateinit var optionButtons: List<Button>
    private lateinit var contadorTextView: TextView
    private var correctAnswer: Int = 0
    private var rounds: Int = 0
    private var correctCount: Int = 0
    private var incorrectCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verdadero_or_falso)

        equationTextView = findViewById(R.id.equation)
        optionButtons = listOf(
            findViewById(R.id.Opcion1),
            findViewById(R.id.Opcion2),
            findViewById(R.id.Opcion3),
            findViewById(R.id.Opcion4)
        )
        contadorTextView = findViewById(R.id.Contador)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        nextRound()
    }

    private fun nextRound() {
        if (rounds < 10) {
            val multiplicand = Random.nextInt(1, 11)
            val multiplier = Random.nextInt(1, 11)
            correctAnswer = multiplicand * multiplier
            equationTextView.text = "$multiplicand x $multiplier = ?"

            val answers = mutableListOf(correctAnswer)
            while (answers.size < optionButtons.size) {
                val fakeAnswer = generateFakeAnswer(correctAnswer)
                if (fakeAnswer !in answers) {
                    answers.add(fakeAnswer)
                }
            }

            answers.shuffle()

            optionButtons.forEachIndexed { index, button ->
                button.text = answers[index].toString()
                button.setOnClickListener {
                    if (button.text.toString().toInt() == correctAnswer) {
                        correctCount++
                        showAlert("Respuesta correcta")
                    } else {
                        incorrectCount++
                        showAlert("Respuesta incorrecta")
                    }
                    rounds++
                    contadorTextView.text = "Llevas $rounds de 10"
                    nextRound()
                }
            }
        } else {
            finishGame()
        }
    }

    private fun generateFakeAnswer(correctAnswer: Int): Int {
        var fakeAnswer: Int
        do {
            fakeAnswer = Random.nextInt(1, 101)
        } while (fakeAnswer == correctAnswer || fakeAnswer % (correctAnswer / 2) == 0)
        return fakeAnswer
    }

    private fun showAlert(message: String) {
        val builder = android.app.AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.custom_alert_dialog, null)
        val alertTitle = dialogLayout.findViewById<TextView>(R.id.alertTitle)
        val alertMessage = dialogLayout.findViewById<TextView>(R.id.alertMessage)
        val positiveButton = dialogLayout.findViewById<Button>(R.id.positiveButton)

        alertTitle.text = "Resultado"
        alertMessage.text = message

        val dialog = builder.setView(dialogLayout).create()

        positiveButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun finishGame() {
        val intent = Intent(this, CalificacionVoFActivity::class.java).apply {
            putExtra("correctCount", correctCount)
            putExtra("incorrectCount", incorrectCount)
        }
        startActivity(intent)
        finish()
    }
}