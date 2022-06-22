package fr.isen.abaoubida.myriamdroidburger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import java.lang.Exception

class HomeScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        val action = supportActionBar
        action?.hide()
        try{
            Handler().postDelayed({
                startActivity(
                    Intent(
                        this,
                        MainActivity::class.java)
                )
            },6600)
        }
        catch (e: Exception){
            e.printStackTrace()
        }
    }
}