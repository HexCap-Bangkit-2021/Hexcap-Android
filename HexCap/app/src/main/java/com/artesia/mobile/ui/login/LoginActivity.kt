package com.artesia.mobile.ui.login

import android.R.attr
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.artesia.mobile.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignIn
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.google.android.gms.common.api.ApiException

class LoginActivity : AppCompatActivity() {
    private lateinit var loginBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        loginBinding.btnLogin.setOnClickListener {
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("295755593311-2l0tifphvenj7r0v8hgl1qj90v7s3flh.apps.googleusercontent.com")
                .requestEmail()
                .build()

            val mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
            startActivityForResult(mGoogleSignInClient.signInIntent, 100)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 100){
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            Log.d("Testing", "test")
            // Signed in successfully, show authenticated UI.
            Log.d("Testing", account.displayName)
            Log.d("Testing", account.idToken)
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.d("Testing", "test")
            Log.w("Testing", "signInResult:failed code=" + e.statusCode)
        }
    }
}