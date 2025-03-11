package VentanasLMT

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lmt.R

class PerfilActivity : AppCompatActivity() {

    private lateinit var Nombre: EditText
    private lateinit var NickName: EditText
    private lateinit var btnGuardar: Button
    private lateinit var btnSelectImage: Button
    private lateinit var profileImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_perfil)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Nombre = findViewById(R.id.Nombre)
        NickName = findViewById(R.id.NickName)
        btnGuardar = findViewById(R.id.ButtonNN)
        btnSelectImage = findViewById(R.id.ButtonSelectImage)
        profileImage = findViewById(R.id.ProfileImage)

        cargarValoresGuardados()

        btnGuardar.setOnClickListener { Guardado() }
        btnSelectImage.setOnClickListener { selectImageFromGallery() }
    }

    fun Guardado() {
        val nombreTexto = Nombre.text.toString()
        val nickNameTexto = NickName.text.toString()

        val sharedPreferences = getSharedPreferences("PerfilPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("Nombre", nombreTexto)
        editor.putString("NickName", nickNameTexto)
        editor.apply()

        ListaGuardado(nombreTexto, nickNameTexto)
    }

    fun ListaGuardado(nombreTexto: String, nickNameTexto: String) {
        val ListaName: MutableList<String> = mutableListOf(nombreTexto, nickNameTexto)
    }

    fun cargarValoresGuardados() {
        val sharedPreferences = getSharedPreferences("PerfilPrefs", Context.MODE_PRIVATE)
        val nombreTexto = sharedPreferences.getString("Nombre", "")
        val nickNameTexto = sharedPreferences.getString("NickName", "")

        Nombre.setText(nombreTexto)
        NickName.setText(nickNameTexto)
    }

    private fun selectImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        resultLauncher.launch(intent)
    }

    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val imageUri: Uri? = data?.data
            if (imageUri != null) {
                val inputStream = contentResolver.openInputStream(imageUri)
                val bitmap = BitmapFactory.decodeStream(inputStream)
                profileImage.setImageBitmap(bitmap)
            }
        }
    }
}