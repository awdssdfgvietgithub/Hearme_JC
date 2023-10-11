package com.example.lib

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.TextUtils
import java.util.regex.Pattern

class MyClass {
    companion object {
        val EMAIL_ADDRESS_PATTERN: Pattern = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )

        fun ValidateEmail(email: String): Boolean {
            return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
        }
    }
}