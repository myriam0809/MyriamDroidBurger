package fr.isen.abaoubida.myriamdroidburger


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import android.widget.TimePicker
import fr.isen.abaoubida.myriamdroidburger.databinding.ActivityMainBinding
import android.content.SharedPreferences as SharedPreferences1


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        // Timetable configuration
        val timePicker = findViewById<View>(R.id.timePicker) as TimePicker
        timePicker.setIs24HourView(true)

        // Field verification
        binding.validateCommande.setOnClickListener{
            val nom = binding.lastName.text.toString()
            val prenom = binding.firstName.text.toString()
            val adress = binding.postalAdresse.text.toString()
            val portable = binding.mobile.text.toString()
            val burger = binding.spinnerchoixburger.selectedItem.toString()
            val heure = binding.timePicker.hour.toString()
            val minute = binding.timePicker.minute.toString()

            // check name field
            if (nom.isNotEmpty()){
                // check first name field
                if (prenom.isNotEmpty()){

                    // check adress field
                    if (adress.isNotEmpty()){
                        // check mobile field
                        if (portable.isNotEmpty()){
                            val intent = Intent (this, OrderConfirmationActivity::class.java)

                            //SharedPreference
                            val sharedPreferences = getSharedPreferences("addName", MODE_PRIVATE)
                            var edit = sharedPreferences.edit()

                            edit.putString("name",binding.lastName.text.toString())
                            edit.putString("firstname", binding.firstName.text.toString())
                            edit.putString("adress", binding.postalAdresse.text.toString())
                            edit.putString("tel", binding.mobile.text.toString())
                            edit.putString("burger", burger)
                            edit.putString("heure", heure)
                            edit.putString("minute", minute)


                            edit.commit()
                            Toast.makeText(this,"data saved",Toast.LENGTH_SHORT).show()

                            val name = sharedPreferences.getString("name", " ")
                            val firstname = sharedPreferences.getString("firstname", " ")


                            Toast.makeText(this,name+ "  "+firstname,Toast.LENGTH_SHORT).show()
                            //End sharedPreference

                            startActivity((intent))
                        } else {
                            Toast.makeText(this,"Le champs du numéro de téléphone est vide", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this,"Le champs adresse est vide", Toast.LENGTH_SHORT).show()
                    }

                } else {
                    Toast.makeText(this,"Le champs prénom est vide", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this,"Le champs nom est vide", Toast.LENGTH_SHORT).show()
            }

        }

    }

}