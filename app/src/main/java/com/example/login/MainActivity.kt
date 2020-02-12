package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import android.util.Patterns
import java.util.regex.Pattern
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {


    lateinit var btn_login: Button
    lateinit var eT_email : TextInputLayout
    lateinit var eT_password : TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(

            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_login)

        btn_login = findViewById(R.id.login_) as Button;
        eT_email = findViewById(R.id.email_) as TextInputLayout;
        eT_password = findViewById(R.id.password_) as TextInputLayout;


    }

    private val PASSWORD_PATTERN = Pattern.compile(
        "^" +
                "(?=.*[a-zA-Z])" +      //любая буква
                "(?=.*[@#$%^&+=])" +    //не менее 1 специального символа
                //"(?=\\S+$)" +           // нет белых пятен
                ".{4,}" +               //не менее 4 символов
                "$")

    //проверка электронной почты
    private fun Email(): Boolean {
        val emailInput = eT_email.getEditText().toString().trim()//getEditText().getText().toString().trim();
        if (emailInput.isEmpty())
        {
            eT_email.setError("Поле не должно быть пустым!")
            return false
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches())
        {
            eT_email.setError("Введите действительный адрес электронной почты")
            return false
        }
        else
        {
            eT_email.setError(null)
            return true
        }
    }

    //проверка пароля
    private fun Password(): Boolean {
        val passwordInput = eT_password.getEditText().toString().trim()//getEditText().getText().toString().trim();
        if (passwordInput.isEmpty())
        {
            eT_password.setError("Поле не должно быть пустым!")
            return false
        }
        else if (!PASSWORD_PATTERN.matcher(passwordInput).matches())
        {
            eT_password.setError("Пароль слишком слабый")
            return false
        }
        else {
            eT_password.setError(null)
            return true
        }
    }

    fun Najmi(v: View) {
        if (!Email() or !Password())
        {
            return
        }

        var input = "Email: " + eT_email.getEditText().toString()
        input += "\n"
        input += "Password: " + eT_password.getEditText().toString()

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show()
    }





}
