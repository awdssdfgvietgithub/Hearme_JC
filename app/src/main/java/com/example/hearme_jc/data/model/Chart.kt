package com.example.hearme_jc.data.model

import com.example.hearme_jc.R

data class Chart(val chartId: String, val chartName: String, val image: Int)

class FakeData {
    companion object {
        fun dataChart(): ArrayList<Chart> {
            val dataChart = ArrayList<Chart>()
            dataChart.apply {
                add(
                    Chart(
                        "c001", "Top 100", R.drawable.img_bg_01
                    )
                )
                add(
                    Chart(
                        "c002", "Top 50", R.drawable.img_bg_02
                    )
                )
                add(
                    Chart(
                        "c003", "Top Albums Global", R.drawable.img_bg_03
                    )
                )
                add(
                    Chart(
                        "c004", "Top Albums United States", R.drawable.img_bg_04
                    )
                )
                add(
                    Chart(
                        "c005", "Top Songs Global", R.drawable.img_bg_05
                    )
                )
                add(
                    Chart(
                        "c006", "Top Songs United States", R.drawable.img_bg_06
                    )
                )
            }
            return dataChart
        }
    }
}