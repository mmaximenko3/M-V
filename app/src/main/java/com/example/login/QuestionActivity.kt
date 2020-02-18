package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class QuestionActivity : AppCompatActivity() {
    var i=0
    val questions : Array<String> = arrayOf("Do you like communication?","Do you want to find a friend?")
    val bacK = getString(R.string.back)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val buttonYes = findViewById<Button>(R.id.yess)
        val buttonNo = findViewById<Button>(R.id.noo)
        val tvQuestions = findViewById<TextView>(R.id.tvQuestion)
        val doorLoad = getString(R.string.doorload)
        val noO =getString(R.string.no)


        buttonYes.setOnClickListener(View.OnClickListener {

                if(i<questions.size)
                {
                    tvQuestions.setText(questions[i])
                    i=i+1
                }
                else{
                    val splash_intent = Intent(this@QuestionActivity, SplashActivity::class.java)
                    startActivity(splash_intent);
                    Toast.makeText(getApplicationContext(), doorLoad, Toast.LENGTH_SHORT).show();
                }

        })
        buttonNo.setOnClickListener(View.OnClickListener {
            Toast.makeText(getApplicationContext(), noO, Toast.LENGTH_SHORT).show();
        })


    }
    override fun onBackPressed() {
        val login_intent = Intent(this@QuestionActivity, MainActivity::class.java)
        startActivity(login_intent);
        Toast.makeText(getApplicationContext(), bacK, Toast.LENGTH_SHORT).show();
    }

}
