package fr.isen.abaoubida.myriamdroidburger

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.abaoubida.myriamdroidburger.databinding.ActivityMainBinding
import fr.isen.abaoubida.myriamdroidburger.databinding.ActivityOrderConfirmationBinding

class OrderConfirmationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderConfirmationBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOrderConfirmationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("addName", Context.MODE_PRIVATE)

        val name = sharedPreferences.getString("name", " ")
        val firstname = sharedPreferences.getString("firstname", " ")
        val postalAdresse = sharedPreferences.getString("adress", " ")
        val mobile = sharedPreferences.getString("tel", " ")
        val burger = sharedPreferences.getString("burger"," ")
        val heure = sharedPreferences.getString("heure"," ")
        val minute = sharedPreferences.getString("minute"," ")



        binding.user.text = name + " " + firstname

        binding.postal.text = postalAdresse

        binding.phone.text = mobile

        binding.burger.text = burger

        binding.time.text = heure + "h" + minute






    }
}