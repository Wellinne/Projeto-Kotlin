package nascimento.wellinne.loginproject
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import nascimento.wellinne.loginproject.databinding.ActivityMainBinding
import java.util.Date

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("test", "onCreate")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart(){
        super.onStart()
        Log.d("test", "onStart")
    }

    override fun onResume(){
        super.onResume()
        Log.d("test", "onResume")
    }

    override fun onPause(){
        super.onPause()
        Log.d("test", "onPause")
    }

    override fun onStop(){
        super.onStop()
        Log.d("test", "onStop")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.d("test", "onDestroy")
    }

    private fun checkCredentials(email: String, password: String): Boolean{
        return email == "admin@cin.ufpe.br" && password == "admin"
    }

    fun login(view: View?){
        val email = binding.edtEmailAddress.text.toString().trim()
        val password = binding.edtPassword.text.toString().trim()
        if(checkCredentials(email, password)){
            Toast.makeText(this, "success", Toast.LENGTH_LONG).show()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("USER", email)
            intent.putExtra("DATE_HOUR", Date().toString())
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "invalid credentials", Toast.LENGTH_LONG).show()
        }
    }
}