package nascimento.wellinne.loginproject
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import nascimento.wellinne.loginproject.databinding.ActivitySecondBinding
import java.util.Date

class SecondActivity : Activity(), OnClickListener {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userEmail = "${getString(R.string.user)} ${intent.getStringExtra("USER")}"
        val dateHour = "${getString(R.string.logged_in)} ${intent.getStringExtra("DATE_HOUR")}"

        binding.txtUser.text = userEmail
        binding.txtDateHour.text = dateHour
        binding.buttonHome.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.buttonHome -> {
                val intent = Intent(this, ThirdActivity::class.java)
                intent.putExtra("USER", "Oi")
                startActivity(intent)
                print(intent)
                finish()
            }
        }
    }
}