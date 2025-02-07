package nascimento.wellinne.loginproject
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.util.Log
import android.view.View.OnClickListener
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import nascimento.wellinne.loginproject.databinding.ActivityCadastroBinding

class CadastroActivity : ComponentActivity(), OnClickListener {

    private lateinit var binding: ActivityCadastroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()

        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCadastrar.setOnClickListener(this)
        binding.btnVoltarCadastro.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()

        val filename: String = "login"
        var content: String = ""
        applicationContext.openFileInput(filename).bufferedReader().use {
            content = it.readLine()
        }
        Log.d("Log", "resume")
        Log.d("Log", "content" + content)

        val split = content.split(":")

        binding.edtCadastroNome.setText(split[0].toString())
        binding.edtCadastroEmailAddress.setText(split[1].toString())
        binding.edtCadastroPassword.setText(split[2].toString())
    }

    fun validator(): Boolean {
        if(binding.edtCadastroNome.text.toString() != ""
            && binding.edtCadastroEmailAddress.text.toString() != ""
            && binding.edtCadastroPassword.text.toString() != ""){
            return true
        }

        return false
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btnCadastrar -> {
                if(validator()){
                    Log.d("botao cadastro", "validando")
                        val filename: String = "login"
                        var content: String = binding.edtCadastroNome.text.toString() + ":" + binding.edtCadastroEmailAddress.text.toString() + ":" + binding.edtCadastroPassword.text.toString()
                        applicationContext.openFileOutput(filename, MODE_PRIVATE).use {
                            it.write(content.toByteArray())
                    }
                }
            }
            R.id.btnVoltarCadastro -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}