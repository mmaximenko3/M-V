package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Matcher
import java.util.regex.Pattern

class SingupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singup)


        val buttonCreate = findViewById<Button>(R.id.create)
        val etUserName = findViewById<TextInputLayout>(R.id.userName)
        val etPasswordCreate = findViewById<TextInputLayout>(R.id.passwordCreate)
        val etPasswordConfirm = findViewById<TextInputLayout>(R.id.passwordConfirm)
        val cb18old = findViewById<CheckBox>(R.id.yesOld)

        buttonCreate.setOnClickListener(View.OnClickListener {

            val username: String = etUserName.editText?.text.toString()
            val validusername = "^[a-zA-Z0-9]+$"
            val matcher3: Matcher
            matcher3 = Pattern.compile(validusername).matcher(username)
            val nameWwod = getString(R.string.namewwod)
            val nameNeverno = getString(R.string.nameneverno)

            if (matcher3.matches()) {
                etUserName.setErrorEnabled(false)
            } else if (etUserName.editText?.text.toString().equals("")) {
                etUserName.setError(nameWwod)
            } else {
                etUserName.setError(nameNeverno)
            }

            val password: String = etPasswordCreate.editText?.text.toString()
            val validpassword = ".{4,}" + "$"//не менее 4 символов
            val matcher4: Matcher
            matcher4 = Pattern.compile(validpassword).matcher(password)
            val pasWwod = getString(R.string.paswwod)
            val pasNeverno = getString(R.string.pasneverno)
            val pasNesovp = getString(R.string.pasnesovp)

            if (matcher4.matches()) {
                etPasswordCreate.setErrorEnabled(false)
            } else if (etPasswordCreate.editText?.text.toString().equals("") || etPasswordConfirm.editText?.text.toString().equals(
                    ""
                )
            ) {
                etPasswordCreate.setError(pasWwod)
            } else {
                etPasswordCreate.setError(pasNeverno)
            }



            if (etPasswordCreate.editText?.text.toString().equals(etPasswordConfirm.editText?.text.toString())) {
                if (etUserName.editText?.text.toString().equals("")) {
                    Toast.makeText(getApplicationContext(), nameWwod, Toast.LENGTH_SHORT).show();
                } else {

                    val question1_intent =
                        Intent(this@SingupActivity, QuestionActivity::class.java)
                    val doorQuestion = getString(R.string.doorquestion)
                    if (cb18old.isChecked) {
                        buttonCreate.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_));
                        startActivity(question1_intent);
                        Toast.makeText(getApplicationContext(), doorQuestion, Toast.LENGTH_SHORT)
                            .show();
                    } else {
                        buttonCreate.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_2));
                        startActivity(question1_intent);
                        Toast.makeText(getApplicationContext(), doorQuestion, Toast.LENGTH_SHORT)
                            .show();
                    }
                }
            } else {
                etPasswordConfirm.setError(pasNesovp)
            }

        })

    }

}
