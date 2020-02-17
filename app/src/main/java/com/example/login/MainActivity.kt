package com.example.login

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.util.regex.Pattern
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Matcher
import android.os.Handler


open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonLogin = findViewById<Button>(R.id.login)
        val buttonSignUp = findViewById<Button>(R.id.signUp)
        val buttonPrivacyPolicy = findViewById<Button>(R.id.privacyPolicy)
        val etEmail = findViewById<TextInputLayout>(R.id.email)
        val etPassword = findViewById<TextInputLayout>(R.id.passwordLogin)

        buttonLogin.setOnClickListener(View.OnClickListener {

            val email: String = etEmail.editText?.text.toString()
            val validemail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+"
            val matcher1: Matcher
            matcher1 = Pattern.compile(validemail).matcher(email)
            val emailWwod = getString(R.string.emailwwod)
            val emailNeverno = getString(R.string.emailneverno)

            if (matcher1.matches()) {
                etEmail.setErrorEnabled(false)
            } else if (etEmail.editText?.text.toString().equals("")) {
                etEmail.setError(emailWwod)
            } else {
                etEmail.setError(emailNeverno)
            }

            val password: String = etPassword.editText?.text.toString()
            val validpassword = ".{4,}" + "$"//не менее 4 символов

            val matcher2: Matcher
            matcher2 = Pattern.compile(validpassword).matcher(password)
            val pasWwod = getString(R.string.paswwod)
            val pasNeverno = getString(R.string.pasneverno)

            if (matcher2.matches()) {
                etPassword.setErrorEnabled(false)
            } else if (etPassword.editText?.text.toString().equals("")) {
                etPassword.setError(pasWwod)
            } else {
                etPassword.setError(pasNeverno)
            }

            if (matcher1.matches() && matcher2.matches()) {
                val progressDialog = ProgressDialog(this)
                val Load = getString(R.string.load)
                val tryAgain = getString(R.string.tryagain)
                progressDialog.setMessage(Load)
                progressDialog.setCancelable(false)
                progressDialog.show()
                Handler().postDelayed({
                    progressDialog.dismiss();Toast.makeText(
                    getApplicationContext(),
                    tryAgain,
                    Toast.LENGTH_LONG
                ).show();
                }, 3500)
            }
        })

        buttonSignUp.setOnClickListener(View.OnClickListener {

            val doorReg = getString(R.string.doorreg)
            val singUp_intent = Intent(this@MainActivity, SingupActivity::class.java)
            startActivity(singUp_intent);
            Toast.makeText(getApplicationContext(), doorReg, Toast.LENGTH_SHORT).show();

        })

        buttonPrivacyPolicy.setOnClickListener(View.OnClickListener {
            val link = getString(R.string.link_string)
            val intentBtnPwr = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intentBtnPwr)
        })

    }


}
