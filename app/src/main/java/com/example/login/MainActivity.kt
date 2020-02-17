package com.example.login

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import java.util.regex.Pattern
import com.google.android.material.textfield.TextInputLayout
import android.widget.CheckBox
import java.util.regex.Matcher
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Handler


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val button_login = findViewById<Button>(R.id.login)
        val button_signUp = findViewById<Button>(R.id.sign_up)
        val button_privacy_p = findViewById<Button>(R.id.privacy_policy)
        val cb_remember = findViewById<CheckBox>(R.id.remeber_)
        val et_email = findViewById<TextInputLayout>(R.id.email_)
        val et_password = findViewById<TextInputLayout>(R.id.password_)

        button_login.setOnClickListener(View.OnClickListener {
            /*val email: String = et_email.editText?.text.toString()
            val password: String = et_password.editText?.text.toString()

            val validemail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+"
            val validpassword = "(?=.*[a-zA-Z])" +      //любая буква
                    "(?=.*[@#$%^&+=])" +    //не менее 1 специального символа
                    ".{5,}" +               //не менее 4 символов
                    "$"
            val matcher1: Matcher
            matcher1 = Pattern.compile(validemail).matcher(email)

            val matcher2: Matcher
            matcher2 = Pattern.compile(validpassword).matcher(password)

            if (matcher1.matches() && matcher2.matches()) {
                et_email.setErrorEnabled(false)
                et_password.setErrorEnabled(false)
                val progressDialog = ProgressDialog(this)
                progressDialog.setMessage("Loading please wait")
                progressDialog.setCancelable(false)
                progressDialog.show()
                Handler().postDelayed({ progressDialog.dismiss() }, 3500)
            } else if (et_email.editText?.text.toString().equals("")) {
                et_email.setError("Введите e-mail")
            } else {
                et_email.setError("Не действительный e-mail")
            }


            if (matcher1.matches() && matcher2.matches()) {
                et_email.setErrorEnabled(false)
                et_password.setErrorEnabled(false)
                val progressDialog = ProgressDialog(this)
                progressDialog.setMessage("Loading please wait")
                progressDialog.setCancelable(false)
                progressDialog.show()
                Handler().postDelayed({ progressDialog.dismiss() }, 3500)
            } else if (et_password.editText?.text.toString().equals("")) {
                et_password.setError("Введите пароль")
            } else {
                et_password.setError("Не верный пароль")
            }*/

            val email: String = et_email.editText?.text.toString()
            val validemail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+"
            val matcher1: Matcher
            matcher1 = Pattern.compile(validemail).matcher(email)

            if (matcher1.matches()) {
                et_email.setErrorEnabled(false)
            } else if (et_email.editText?.text.toString().equals("")) {
                et_email.setError("Введите e-mail")
            } else {
                et_email.setError("Не действительный e-mail")
            }

            val password: String = et_password.editText?.text.toString()
            val validpassword = "(?=.*[a-zA-Z])" +      //любая буква
                    "(?=.*[@#$%^&+=])" +    //не менее 1 специального символа
                    ".{4,}" +               //не менее 4 символов
                    "$"
            val matcher2: Matcher
            matcher2 = Pattern.compile(validpassword).matcher(password)

            if (matcher2.matches()) {
                et_password.setErrorEnabled(false)
            } else if (et_password.editText?.text.toString().equals("")) {
                et_password.setError("Введите пароль")
            } else {
                et_password.setError("Не верный пароль")
            }

            if (matcher1.matches() && matcher2.matches()) {
                val progressDialog = ProgressDialog(this)
                progressDialog.setMessage("Loading please wait")
                progressDialog.setCancelable(false)
                progressDialog.show()
                Handler().postDelayed({ progressDialog.dismiss() }, 3500)
                //тут я не знаю, как сделать задержку, чтобы тост срабатывал после загрузчика

                Toast.makeText(getApplicationContext(), "Something went wrong. Login or password is invalid. Please try again...", Toast.LENGTH_SHORT).show();
            }

        })

        button_signUp.setOnClickListener(View.OnClickListener {

            val singUp_intent = Intent(this@MainActivity, SingupActivity::class.java)
            startActivity(singUp_intent);
            Toast.makeText(
                getApplicationContext(),
                "Вы перешли в окно регестрации",
                Toast.LENGTH_SHORT
            ).show();

        })

        button_privacy_p.setOnClickListener(View.OnClickListener {
            val link = getString(R.string.link_string)
            val intentBtnPwr = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intentBtnPwr)
        })

        cb_remember.setOnClickListener(View.OnClickListener {
            if (cb_remember.isChecked) {
                Toast.makeText(getApplicationContext(), "true", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "false", Toast.LENGTH_SHORT).show();
            }
        })
    }


}
