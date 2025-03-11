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

class MultipleOpActivity : AppCompatActivity() {

    private lateinit var equationTextView: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var contadorTextView: TextView
    private var correctAnswer: Int = 0
    private var rounds: Int = 0
    private var correctCount: Int = 0
    private var incorrectCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiple_op)

        equationTextView = findViewById(R.id.EcuacionVoF)
        trueButton = findViewById(R.id.Verdadero)
        falseButton = findViewById(R.id.Falso)
        contadorTextView = findViewById(R.id.Contador)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        nextRound()

        trueButton.setOnClickListener { checkAnswer(true) }
        falseButton.setOnClickListener { checkAnswer(false) }
    }

    private fun nextRound() {
        if (rounds < 10) {
            val multiplicand = Random.nextInt(1, 11)
            val multiplier = Random.nextInt(1, 11)
            correctAnswer = multiplicand * multiplier

            val fakeAnswer = if (Random.nextBoolean()) correctAnswer else generateFakeAnswer(correctAnswer)
            equationTextView.text = "$multiplicand x $multiplier = $fakeAnswer"
            trueButton.text = "Verdadero"
            falseButton.text = "Falso"

            rounds++
            contadorTextView.text = "Llevas $rounds de 10"
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

    private fun checkAnswer(isTrue: Boolean) {
        val displayedAnswer = equationTextView.text.toString().split(" = ").last().toInt()
        val isCorrect = (displayedAnswer == correctAnswer) == isTrue

        if (isCorrect) {
            correctCount++
            showAlert("Respuesta correcta")
        } else {
            incorrectCount++
            showAlert("Respuesta incorrecta")
        }

        nextRound()
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
        val intent = Intent(this, Calificacion2Activity::class.java).apply {
            putExtra("correctCount", correctCount)
            putExtra("incorrectCount", incorrectCount)
        }
        startActivity(intent)
        finish()
    }
}