package com.example.hearme_jc.data.model

import com.example.hearme_jc.R

data class CardPayment(val img: Int, val name: String, var isSelected: Boolean)

class CardPaymentData {
    companion object {
        fun data() = arrayListOf<CardPayment>().apply {
            add(CardPayment(R.drawable.ic_paypal, "Paypal", true))
            add(CardPayment(R.drawable.vector_google, "Google Pay", false))
            add(CardPayment(R.drawable.vector_apple, "Apple Pay", false))
        }
    }
}