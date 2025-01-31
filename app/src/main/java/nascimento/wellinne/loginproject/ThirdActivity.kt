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
    }

    private fun resultCalculo(gasolina: Double, etanol: Double): Double{
        val result = (etanol / gasolina)
        return result
    }

    override fun onClick(p0: View?) {
        val gasolina = binding.edtGasolina.text
        val etanol = binding.edtPorcentagem.text


        if(resultCalculo(gasolina, etanol) > 0.70) {
            binding.textCalculo.text = "É melhor o etanol"
        } else {
            binding.textCalculo.text = "É melhor a gasolina"
        }
    }
}

