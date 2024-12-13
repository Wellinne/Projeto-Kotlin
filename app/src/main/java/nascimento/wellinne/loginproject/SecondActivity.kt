package nascimento.wellinne.loginproject
import android.app.Activity
import android.os.Bundle
import nascimento.wellinne.loginproject.databinding.ActivitySecondBinding

class SecondActivity : Activity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userEmail = "${getString(R.string.user)} ${intent.getStringExtra("USER")}"
        val dateHour = "${getString(R.string.logged_in)} ${intent.getStringExtra("DATE_HOUR")}"

        binding.txtUser.text = userEmail
        binding.txtDateHour.text = dateHour
    }
}