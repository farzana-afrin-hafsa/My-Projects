package com.example.pureconvo_chatapp.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pureconvo_chatapp.R
import com.example.pureconvo_chatapp.MainActivity
import com.example.pureconvo_chatapp.databinding.ActivityMainBinding
import com.example.pureconvo_chatapp.databinding.ActivityNumberBinding
import com.google.firebase.auth.FirebaseAuth

class NumberActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNumberBinding
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        if(auth.currentUser !=null){
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

        binding.button.setOnClickListener{
            if(binding.phoneNumber.text!!.isEmpty()){
                Toast.makeText(this,"Please enter your Number!!",Toast.LENGTH_SHORT).show()
            }else
            {
                var intent = Intent(this,OTPActivity::class.java)
                intent.putExtra("number",binding.phoneNumber.text!!.toString())
                startActivity(intent)
            }

        }



    }

}