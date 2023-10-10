package com.example.hearme_jc.data.model

import androidx.compose.ui.res.stringResource
import com.example.hearme_jc.R

data class SignInMethod(val icon: Int, val name: String)

class SignInMethodData {
    companion object {
        fun data(): ArrayList<SignInMethod> {
            val data = ArrayList<SignInMethod>()
            data.apply {
                add(SignInMethod(R.drawable.vector_facebook, "Continue with Facebook"))
                add(SignInMethod(R.drawable.vector_google, "Continue with Google"))
                add(SignInMethod(R.drawable.vector_apple, "Continue with Apple"))
            }
            return data
        }
    }
}
