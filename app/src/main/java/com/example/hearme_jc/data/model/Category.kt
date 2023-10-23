package com.example.hearme_jc.data.model

import androidx.compose.ui.graphics.Color
import com.example.hearme_jc.ui.theme.Charts
import com.example.hearme_jc.ui.theme.HipHop
import com.example.hearme_jc.ui.theme.Jazz
import com.example.hearme_jc.ui.theme.KPop
import com.example.hearme_jc.ui.theme.NewReleases
import com.example.hearme_jc.ui.theme.OnlyYou
import com.example.hearme_jc.ui.theme.Podcast
import com.example.hearme_jc.ui.theme.Pop
import com.example.hearme_jc.ui.theme.Rock
import com.example.hearme_jc.ui.theme.Romance

data class Category(
    val categoryID: String,
    val categoryName: String,
    val image: String,
    val background: Color,
)

class CategoriesData {
    companion object {
        fun dataCategory(): ArrayList<Category> {
            val dataCategory = ArrayList<Category>()
            dataCategory.apply {
                add(
                    Category(
                        "ca001",
                        "Chart",
                        "https://firebasestorage.googleapis.com/v0/b/hearme-app-16567.appspot.com/o/images%2Fartists%2FAriana_Grande.png?alt=media&token=51f77e64-3fa9-4409-b3bb-dbb5afb3a1b3&_gl=1*13i06uz*_ga*MTUyOTk3NDI1NS4xNjkzMzU5NjY4*_ga_CW55HF8NVT*MTY5NTg4MTg4Mi42LjEuMTY5NTg4MzA2MC4xNS4wLjA.",
                        Charts,

                    )
                )
                add(
                    Category(
                        "ca002",
                        "Podcast",
                        "https://firebasestorage.googleapis.com/v0/b/hearme-app-16567.appspot.com/o/images%2Fartists%2FJordan_Show.png?alt=media&token=1c2888ea-31a2-436c-809d-5ea17bc45ebc&_gl=1*1ilq7og*_ga*MTUyOTk3NDI1NS4xNjkzMzU5NjY4*_ga_CW55HF8NVT*MTY5NTg4MTg4Mi42LjEuMTY5NTg4MzMxOC4xMS4wLjA.",
                        Podcast
                    )
                )
                add(
                    Category(
                        "ca003",
                        "New Releases",
                        "https://firebasestorage.googleapis.com/v0/b/hearme-app-16567.appspot.com/o/images%2Fmusics%2Fshades_of_love.png?alt=media&token=73c0c3e8-214b-422c-a97f-7cddd372473b&_gl=1*1p8k3a8*_ga*MTUyOTk3NDI1NS4xNjkzMzU5NjY4*_ga_CW55HF8NVT*MTY5NTg4NjQxNS43LjEuMTY5NTg4ODA5OS42MC4wLjA.",
                        NewReleases
                    )
                )
                add(
                    Category(
                        "ca004",
                        "Only You",
                        "https://firebasestorage.googleapis.com/v0/b/hearme-app-16567.appspot.com/o/images%2Fmusics%2Fkiss_me_more.png?alt=media&token=d976b37a-f9a8-4477-bcb2-f4f2d655ce38&_gl=1*wesnr6*_ga*MTUyOTk3NDI1NS4xNjkzMzU5NjY4*_ga_CW55HF8NVT*MTY5NTg4NjQxNS43LjEuMTY5NTg4ODIwOC4xMi4wLjA.",
                        OnlyYou
                    )
                )
                add(
                    Category(
                        "ca005",
                        "Pop",
                        "https://firebasestorage.googleapis.com/v0/b/hearme-app-16567.appspot.com/o/images%2Fmusics%2Fdriver.png?alt=media&token=b1ca7849-d970-4c9e-98c2-28500cca6e76&_gl=1*19b29n9*_ga*MTUyOTk3NDI1NS4xNjkzMzU5NjY4*_ga_CW55HF8NVT*MTY5NTg4NjQxNS43LjEuMTY5NTg4ODI0OC41NS4wLjA.",
                        Pop
                    )
                )
                add(
                    Category(
                        "ca006",
                        "K-Pop",
                        "https://firebasestorage.googleapis.com/v0/b/hearme-app-16567.appspot.com/o/images%2Fmusics%2Fbreak_my_soul.png?alt=media&token=ffd3ef67-30ee-4bab-9b34-8102e11fde15&_gl=1*voe9qt*_ga*MTUyOTk3NDI1NS4xNjkzMzU5NjY4*_ga_CW55HF8NVT*MTY5NTg4NjQxNS43LjEuMTY5NTg4ODMxNC42MC4wLjA.",
                        KPop
                    )
                )
                add(
                    Category(
                        "ca007",
                        "Rock",
                        "https://firebasestorage.googleapis.com/v0/b/hearme-app-16567.appspot.com/o/images%2Fmusics%2Fthe_hill.png?alt=media&token=19bb8143-f14f-4d42-b0ef-e5f0f99962ba&_gl=1*e07k94*_ga*MTUyOTk3NDI1NS4xNjkzMzU5NjY4*_ga_CW55HF8NVT*MTY5NTg4NjQxNS43LjEuMTY5NTg4ODQyNS41NC4wLjA.",
                        Rock
                    )
                )
                add(
                    Category(
                        "ca008",
                        "Hip-Hop",
                        "https://firebasestorage.googleapis.com/v0/b/hearme-app-16567.appspot.com/o/images%2Fmusics%2Fdisaster.png?alt=media&token=706b8d54-9b5a-4bf8-a2cd-6441fcce342a&_gl=1*187hfe6*_ga*MTUyOTk3NDI1NS4xNjkzMzU5NjY4*_ga_CW55HF8NVT*MTY5NTg4NjQxNS43LjEuMTY5NTg4ODUxNC42MC4wLjA.",
                        HipHop
                    )
                )
                add(
                    Category(
                        "ca009",
                        "Jazz",
                        "https://s3-alpha-sig.figma.com/img/9d88/5607/87f73b42744eec682913ce7eb92a19f5?Expires=1698624000&Signature=qKsngf5xqDB7e5Dr03Mmfly-UTLUwmp7qqto-an7dhEZJcSYhXWiTuXyJGe8eiN0FXBRBTjHHC-ylLuigkxi-xweLq8Z-ZWE4~4xsPtpJcXG4D5Yd2AXWsdnlTspDmgc8b4Eu-QcbJIuZ~DwbNas7B8rJxMcPVOtmCIkePCIInknhXFETHxGGSyWrNBDfh5rYU7aotxYfxDP9K7P3N2a3C2kz-qlwI8dSNmf7u678BvzLmDFVIQ6s7vzMXS7jhieb0GsTkpEDRZYYIdg~72rzHdyT1ldHNOCPVXFFriATn4d-SMHCAL98qmpv32V9sY11waSCBjL5wAmsq-opOUhrQ__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
                        Jazz
                    )
                )
                add(
                    Category(
                        "ca010",
                        "Romance",
                        "https://s3-alpha-sig.figma.com/img/692e/8125/07e12ccaff200ac1214f42ac2c466f1a?Expires=1698624000&Signature=lSEwtXKgXYrI86cerM6PUDAPVzoK59UalQbBW092MZx8XTZ9MAD786uhYj6uEVUR8Qm79ave9UAQUo1Pfjy-epVOTuzNaoziN3-cSzEdlBTG8ZFnMfv~AtIQGNuCqn3xKCea9CQlQflw86aSEoOkfzqT9CU7WOM0HbriDGjW99apFjOhPKqP6lnycmZ5ihzGMibweGVatoJMpbxZW0A-TOssvnPuRdjUDt0bSJDwmwgtfQ9oMmSe~BZJzmgHX6o498UMm0GDFFIFGcBzdiiCbD4TpxzS2p0qaV0~ryt2epP76ZUK3a-VFcIEKeZtsyAOXjLSIrRDSciONxiWt0BMSQ__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
                        Romance
                    )
                )
            }
            return dataCategory
        }
    }
}
