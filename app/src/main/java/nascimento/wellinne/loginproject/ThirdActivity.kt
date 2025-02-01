package nascimento.wellinne.loginproject
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.util.Log
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.activity.ComponentActivity
import nascimento.wellinne.loginproject.databinding.ActivityThirdBinding
import java.util.Date

class ThirdActivity : ComponentActivity(), OnClickListener {

    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        Log.d("test", "onCreate")

        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculo.setOnClickListener(this)
        binding.buttonVoltar.setOnClickListener(this)
    }

    private fun resultCalculo(gasolina: Double, etanol: Double): Double {
        return if (gasolina != 0.0) {
            etanol / gasolina
        } else {
            0.0
        }
    }

    override fun onClick(v: View?) {
        try {
            when(v?.id) {
                R.id.buttonCalculo -> {
                    val gasolina = binding.edtGasolina.text.toString().toDouble()
                    val etanol = binding.edtEtanol.text.toString().toDouble()

                    val resultado = resultCalculo(gasolina, etanol)
                    if (resultado < 0.7) {
                        binding.textCalculo.text =
                            "Melhor abastecer com Etanol (Rácio: %.2f)".format(resultado)
                    } else {
                        binding.textCalculo.text =
                            "Melhor abastecer com Gasolina (Rácio: %.2f)".format(resultado)
                    }
                }
                R.id.buttonVoltar -> {
                    val user = intent.getStringExtra("USER")
                    val dateHour = intent.getStringExtra("DATE_HOUR")
                    val intent = Intent(this, SecondActivity::class.java)
                    intent.putExtra("USER", user)
                    intent.putExtra("DATE_HOUR", dateHour)
                    startActivity(intent)
                    finish()
                }
            }
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Por favor, insira valores válidos!", Toast.LENGTH_SHORT).show()
        }
    }
}

