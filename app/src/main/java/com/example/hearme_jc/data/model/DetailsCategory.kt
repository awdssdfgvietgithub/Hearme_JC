package com.example.hearme_jc.data.model

import com.example.hearme_jc.R

data class DetailsCategory(
    val chartId: String,
    val chartName: String,
    val image: Int,
)

class DetailsCategoryData {
    companion object {
        fun dataDetailsCategory(): ArrayList<DetailsCategory> {
            val dataDetailsCategory = ArrayList<DetailsCategory>()
            dataDetailsCategory.apply {
                add(
                    DetailsCategory(
                        "c001", "Top 100", R.drawable.img_bg_01
                    )
                )
                add(
                    DetailsCategory(
                        "c002", "Top 50", R.drawable.img_bg_02
                    )
                )
                add(
                    DetailsCategory(
                        "c003", "Top Albums Global", R.drawable.img_bg_03
                    )
                )
                add(
                    DetailsCategory(
                        "c004", "Top Albums United States", R.drawable.img_bg_04
                    )
                )
                add(
                    DetailsCategory(
                        "c005", "Top Songs Global", R.drawable.img_bg_05
                    )
                )
                add(
                    DetailsCategory(
                        "c006", "Top Songs United States", R.drawable.img_bg_06
                    )
                )
            }
            return dataDetailsCategory
        }
    }
}