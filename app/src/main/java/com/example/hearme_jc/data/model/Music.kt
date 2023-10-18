package com.example.hearme_jc.data.model

import java.util.Calendar
import java.util.Date

data class Music(
    val musicID: String,
    val musicName: String,
    val totalListeners: Int = 0,
    val image: String,
    val duration: Time,
    val release: Date,
    val categoryID: String,
    val artistID: String,
    val isAlbum: Boolean,
    val path: String = "https://cdn.pixabay.com/audio/2023/07/03/audio_80cd47077b.mp3",
    val information: String? = null,
    var isPlaying: Boolean? = false,
) {
    fun GetArtist(artistID: String): Artist? {
        return ArtistsData.dataArtist().firstOrNull { it.artistId == artistID }
    }
}

class MusicsData {
    companion object {
        fun dataMusic(): ArrayList<Music> {
            val dataMusic = ArrayList<Music>()
            val calToday = Calendar.getInstance()
            val calYesterday = Calendar.getInstance()
            calYesterday.add(Calendar.DATE, -1)

            dataMusic.apply {
                add(
                    Music(
                        "ms001",
                        "Shades of Love",
                        231,
                        "https://firebasestorage.googleapis.com/v0/b/hearme-app-16567.appspot.com/o/images%2Fmusics%2Fshades_of_love.png?alt=media&token=73c0c3e8-214b-422c-a97f-7cddd372473b&_gl=1*1p8k3a8*_ga*MTUyOTk3NDI1NS4xNjkzMzU5NjY4*_ga_CW55HF8NVT*MTY5NTg4NjQxNS43LjEuMTY5NTg4ODA5OS42MC4wLjA.",
                        Time(0, 4, 30),
                        calToday.time,
                        "ca001",
                        "ar001",
                        true,
//                        "http://api.mp3.zing.vn/api/streaming/song/Z66IABZF/128"
                    )
                )
                add(
                    Music(
                        "ms002",
                        "Without You",
                        55,
                        "https://firebasestorage.googleapis.com/v0/b/hearme-app-16567.appspot.com/o/images%2Fmusics%2Fwithout_you.png?alt=media&token=e78ac2d2-7e0e-4373-84f1-5f2d3b7ef445&_gl=1*1gfxh8m*_ga*MTUyOTk3NDI1NS4xNjkzMzU5NjY4*_ga_CW55HF8NVT*MTY5NTg4NjQxNS43LjEuMTY5NTg4ODExOS40MC4wLjA.",
                        Time(0, 3, 30),
                        Date("02/5/2023"),
                        "ca001",
                        "ar001",
                        false
                    )
                )
                add(
                    Music(
                        "ms003",
                        "Save Your Tears",
                        4,
                        "https://firebasestorage.googleapis.com/v0/b/hearme-app-16567.appspot.com/o/images%2Fmusics%2Fsave_of_tear.png?alt=media&token=9d820dc3-834b-4e68-9416-2b5004d69c1f&_gl=1*o4326x*_ga*MTUyOTk3NDI1NS4xNjkzMzU5NjY4*_ga_CW55HF8NVT*MTY5NTg4NjQxNS43LjEuMTY5NTg4ODE2MC42MC4wLjA.",
                        Time(0, 5, 30),
                        calYesterday.time,
                        "ca005",
                        "ar001",
                        true
                    )
                )
                add(
                    Music(
                        "ms004",
                        "Kiss Me More",
                        45,
                        "https://firebasestorage.googleapis.com/v0/b/hearme-app-16567.appspot.com/o/images%2Fmusics%2Fkiss_me_more.png?alt=media&token=d976b37a-f9a8-4477-bcb2-f4f2d655ce38&_gl=1*wesnr6*_ga*MTUyOTk3NDI1NS4xNjkzMzU5NjY4*_ga_CW55HF8NVT*MTY5NTg4NjQxNS43LjEuMTY5NTg4ODIwOC4xMi4wLjA.",
                        Time(0, 3, 20),
                        Date("01/08/2023"),
                        "ca005",
                        "ar002",
                        false
                    )
                )
                add(
                    Music(
                        "ms005",
                        "Drivers License",
                        200,
                        "https://firebasestorage.googleapis.com/v0/b/hearme-app-16567.appspot.com/o/images%2Fmusics%2Fdriver.png?alt=media&token=b1ca7849-d970-4c9e-98c2-28500cca6e76&_gl=1*19b29n9*_ga*MTUyOTk3NDI1NS4xNjkzMzU5NjY4*_ga_CW55HF8NVT*MTY5NTg4NjQxNS43LjEuMTY5NTg4ODI0OC41NS4wLjA.",
                        Time(0, 2, 15),
                        calYesterday.time,
                        "ca003",
                        "ar002",
                        false
                    )
                )
                add(
                    Music(
                        "ms006",
                        "Forever After All",
                        600,
                        "https://s3-alpha-sig.figma.com/img/8328/f145/8bf703f1334a093e8168e707aa49ae97?Expires=1698624000&Signature=IcktGDcoRJLhKFug0RTAIIdK93GfkY1tQYeV1yr1EQxtaQNKSBSg6ljb8PwCMvJHCgBcnTpY5PACkXtwPc4FimYIysroMk3LTW6OJyrAWOVM3ZcfrluHyWtGUz-V0OQuuhINTqMisBieZ6mhNeo1Ry0~sdgZnfjzY~AlC4e-rbhsYIap2Iar5rGfzbJpv5N1ZTIdjmKM3vq01AjcLH4SWbowsIHbiul-kB0z4Eo7yYIbHn6D0JR~EDLymES27C40RS0d3IGSZj5mb4~vWq9tB1DG754xuTbCDnA-zbfNEAxFUqNDCVzW9rfOQZ-umXCKWiTlKS2ohaBQjWbqrJNDpw__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
                        Time(0, 4, 40),
                        Date("11/05/2023"),
                        "ca003",
                        "ar003",
                        true
                    )
                )
                add(
                    Music(
                        "ms007",
                        "Break My Soul",
                        48,
                        "https://firebasestorage.googleapis.com/v0/b/hearme-app-16567.appspot.com/o/images%2Fmusics%2Fbreak_my_soul.png?alt=media&token=ffd3ef67-30ee-4bab-9b34-8102e11fde15&_gl=1*voe9qt*_ga*MTUyOTk3NDI1NS4xNjkzMzU5NjY4*_ga_CW55HF8NVT*MTY5NTg4NjQxNS43LjEuMTY5NTg4ODMxNC42MC4wLjA.",
                        Time(0, 5, 10),
                        Date("12/07/2023"),
                        "ca004",
                        "ar003",
                        false
                    )
                )
                add(
                    Music(
                        "ms008",
                        "The Hills",
                        120,
                        "https://firebasestorage.googleapis.com/v0/b/hearme-app-16567.appspot.com/o/images%2Fmusics%2Fthe_hill.png?alt=media&token=19bb8143-f14f-4d42-b0ef-e5f0f99962ba&_gl=1*e07k94*_ga*MTUyOTk3NDI1NS4xNjkzMzU5NjY4*_ga_CW55HF8NVT*MTY5NTg4NjQxNS43LjEuMTY5NTg4ODQyNS41NC4wLjA.",
                        Time(0, 5, 20),
                        calYesterday.time,
                        "ca004",
                        "ar005",
                        true
                    )
                )
                add(
                    Music(
                        "ms009",
                        "593: Dallas Taylor | The Psychology of Sound Design",
                        200,
                        "https://s3-alpha-sig.figma.com/img/9b23/9488/35a4ee044e985f4fc0ad99aa61f67225?Expires=1698624000&Signature=AvIjUeybpAxfaTa3Eq8nRn9Z6qUkdAJUw2ptKzKsASxdJwl4fACjs4~amXdkwMZwyUUgjamoRKgckUq4aJ1t56o5PsmPYfVWEFCO-uRtOaEtFSOUCAtcfEwq~f1K7VGZd7lxeThbMtLygS-Afn2J5OBLA5iDwwOfMFCXhlk7n5lEnYms8rmRk8u1PvY5hQjjnAkx4lEFEpXpVB6lkL0c80HUsWxZex6hBs5zdIaIetLGg4y6PbwxxEYOcJ3VId8R3KpQA0Q-mmJTZnoNwPfx0V4Mfd3uhRAFM~rb~~CQf1V-bWKgumVCpvtR1QaRG7akyyulIOjIo272OnB-1GKZhg__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
                        Time(0, 48, 35),
                        calYesterday.time,
                        "ca002",
                        "ar008",
                        false,
                        "https://cdn.pixabay.com/audio/2023/07/03/audio_80cd47077b.mp3",
                        "Shaquille O'Neal (@SHAQ) has been retired from basketball for years, but he’s still got his irons in plenty of fires. Here, we’ll discuss everything from superheroes to law enforcement to business to sports to podcasting to — yes — the Flat Earth Theory. What We Discuss with Shaquille O'Neal: The real-world experience Shaq endured preparing for a political race in 2020. How Shaq assembled what he calls The Panel to help manage not only his career but all his important life decisions — and how you can do the same. Why Shaq doesn’t consider himself a celebrity (and why that still isn’t a good reason to bug him in the middle of dinner). How Shaq manages his emotions so he stays non-reactive on and off the court. Does Shaq really believe in the Flat Earth Theory?"
                    )
                )
                add(
                    Music(
                        "ms010",
                        "837: Amy Webb | Changing Lives with Synthetic Biology  ",
                        500,
                        "https://s3-alpha-sig.figma.com/img/bd8c/dd28/bedb56fafecef4a4741a242dd3d897e9?Expires=1698624000&Signature=Ar3-S5YATjVkDNEmO3FU~SetkwsFoPSi7my2skmzbYQvbcdqCx4kidTARSVnnFkTVn4a-CJiKbq74MZoZKSgMtsAASmrdJ0W4nkKvskWyPyP45PE~C7-euhEc9-7SYMxVsbyAwak6t5U9i-9aQgT5emVVcTxEvzY2ugYpGnkHbr2EZZj6DVwATaij7nrr0pxXggqtEUDb-Y1liCeMZyaedfKBIwnM9PtJxoGi9W~v83A2CdeQ46Xovf5wdaYP3zXbVXLDmm8ZAU6VJudSExWJUn96HY7p5Az3flPOnuLcor-qF3J7kqnUR-h08RreIa3OjHeMBIj1aCJbHF9myjjKg__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
                        Time(0, 34, 54),
                        calToday.time,
                        "ca002",
                        "ar007",
                        false,
                        "https://cdn.pixabay.com/audio/2023/07/03/audio_80cd47077b.mp3",
                        "Shaquille O'Neal (@SHAQ) has been retired from basketball for years, but he’s still got his irons in plenty of fires. Here, we’ll discuss everything from superheroes to law enforcement to business to sports to podcasting to — yes — the Flat Earth Theory. What We Discuss with Shaquille O'Neal: The real-world experience Shaq endured preparing for a political race in 2020. How Shaq assembled what he calls The Panel to help manage not only his career but all his important life decisions — and how you can do the same. Why Shaq doesn’t consider himself a celebrity (and why that still isn’t a good reason to bug him in the middle of dinner). How Shaq manages his emotions so he stays non-reactive on and off the court. Does Shaq really believe in the Flat Earth Theory?"
                    )
                )
                add(
                    Music(
                        "ms011",
                        "Disater",
                        1050,
                        "https://firebasestorage.googleapis.com/v0/b/hearme-app-16567.appspot.com/o/images%2Fmusics%2Fdisaster.png?alt=media&token=706b8d54-9b5a-4bf8-a2cd-6441fcce342a&_gl=1*187hfe6*_ga*MTUyOTk3NDI1NS4xNjkzMzU5NjY4*_ga_CW55HF8NVT*MTY5NTg4NjQxNS43LjEuMTY5NTg4ODUxNC42MC4wLjA.",
                        Time(0, 5, 23),
                        Date("25/03/2023"),
                        "ca006",
                        "ar001",
                        true
                    )
                )
                add(
                    Music(
                        "ms012",
                        "Handsome",
                        100,
                        "https://firebasestorage.googleapis.com/v0/b/hearme-app-16567.appspot.com/o/images%2Fmusics%2Fhandsome.png?alt=media&token=770408f8-69bb-423a-bdec-d47338d19542&_gl=1*4sn7ya*_ga*MTUyOTk3NDI1NS4xNjkzMzU5NjY4*_ga_CW55HF8NVT*MTY5NTg4NjQxNS43LjEuMTY5NTg4ODUzNS4zOS4wLjA.",
                        Time(0, 4, 43),
                        Date("13/04/2023"),
                        "ca006",
                        "ar002",
                        true
                    )
                )
                add(
                    Music(
                        "ms013",
                        "Sharks",
                        200,
                        "https://s3-alpha-sig.figma.com/img/9d88/5607/87f73b42744eec682913ce7eb92a19f5?Expires=1698624000&Signature=qKsngf5xqDB7e5Dr03Mmfly-UTLUwmp7qqto-an7dhEZJcSYhXWiTuXyJGe8eiN0FXBRBTjHHC-ylLuigkxi-xweLq8Z-ZWE4~4xsPtpJcXG4D5Yd2AXWsdnlTspDmgc8b4Eu-QcbJIuZ~DwbNas7B8rJxMcPVOtmCIkePCIInknhXFETHxGGSyWrNBDfh5rYU7aotxYfxDP9K7P3N2a3C2kz-qlwI8dSNmf7u678BvzLmDFVIQ6s7vzMXS7jhieb0GsTkpEDRZYYIdg~72rzHdyT1ldHNOCPVXFFriATn4d-SMHCAL98qmpv32V9sY11waSCBjL5wAmsq-opOUhrQ__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
                        Time(0, 3, 35),
                        Date("9/08/2023"),
                        "ca007",
                        "ar003",
                        false
                    )
                )
                add(
                    Music(
                        "ms014",
                        "621: Reid Hoffman | Surprising Entrepreneurial Truths",
                        15,
                        "https://s3-alpha-sig.figma.com/img/0bb2/dbba/64cde090ac8a56c1e620b12d7e7f51a6?Expires=1698624000&Signature=HrmY4Mo5vwVI2v0GTZufCRS3mj2OehVvRcupPvP32DOc3EYP~bqvz2xQgh8I8abLlWpGsW05ED8uS5KGXjTYazWx9EvhiUn~cb-f-kELuopwJQSc1tC7ClbF0uZDnfWY8731Q6i1uFGtFUJCj7YCdtmDaeCfu4nSLui67WB69uac7XKPA3HPRG3ip9o1IVxl7kHaTog-r-gUn-Wb~R5~msU3Dmf2AYqN~3L1VEUidnMgt1JMGTqUWTnpTADDtPdL3INvueTsoUfsk7be1H9jz1hDcueWAqCEN01g76QM7y5A5p1aaEBn9CCSPLrsplyyw3XGd5QsMUIPXoWtNM0oFQ__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
                        Time(0, 28, 25),
                        calToday.time,
                        "ca002",
                        "ar007",
                        false,
                        "https://cdn.pixabay.com/audio/2023/07/03/audio_80cd47077b.mp3",
                        "Shaquille O'Neal (@SHAQ) has been retired from basketball for years, but he’s still got his irons in plenty of fires. Here, we’ll discuss everything from superheroes to law enforcement to business to sports to podcasting to — yes — the Flat Earth Theory. What We Discuss with Shaquille O'Neal: The real-world experience Shaq endured preparing for a political race in 2020. How Shaq assembled what he calls The Panel to help manage not only his career but all his important life decisions — and how you can do the same. Why Shaq doesn’t consider himself a celebrity (and why that still isn’t a good reason to bug him in the middle of dinner). How Shaq manages his emotions so he stays non-reactive on and off the court. Does Shaq really believe in the Flat Earth Theory?"
                    )
                )
                add(
                    Music(
                        "ms015",
                        "Pain",
                        692,
                        "https://s3-alpha-sig.figma.com/img/692e/8125/07e12ccaff200ac1214f42ac2c466f1a?Expires=1698624000&Signature=lSEwtXKgXYrI86cerM6PUDAPVzoK59UalQbBW092MZx8XTZ9MAD786uhYj6uEVUR8Qm79ave9UAQUo1Pfjy-epVOTuzNaoziN3-cSzEdlBTG8ZFnMfv~AtIQGNuCqn3xKCea9CQlQflw86aSEoOkfzqT9CU7WOM0HbriDGjW99apFjOhPKqP6lnycmZ5ihzGMibweGVatoJMpbxZW0A-TOssvnPuRdjUDt0bSJDwmwgtfQ9oMmSe~BZJzmgHX6o498UMm0GDFFIFGcBzdiiCbD4TpxzS2p0qaV0~ryt2epP76ZUK3a-VFcIEKeZtsyAOXjLSIrRDSciONxiWt0BMSQ__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
                        Time(0, 3, 23),
                        Date("15/04/2023"),
                        "ca007",
                        "ar004",
                        false
                    )
                )
                add(
                    Music(
                        "ms016",
                        "Motomami",
                        1203,
                        "https://s3-alpha-sig.figma.com/img/36e6/bfb5/58b9b28e29d52bd7f484b799db3341f6?Expires=1698624000&Signature=Z9oRLhP5FWwstTYxaAYwL1eBlSrXSJ2l9QhbtqwjyNPYUOegHoeERm0ld5XbPvrIJIFx6ZzCviX2up~NOORnaSAubCcNk2hDB~ls3g4R~WREijiqf~uRoFs2Sj09wpAjgmDZv4~ge3U-IUKVbRa-NYtw6sQ7MSODPPE~~EnfrzVqEuwPWR3F9EYH-KwzFo6Qp11oNjK0DCwoQNpWiINRO1Sw3Ysd0YAC1z6wKrksAntFy4t0eFiiyaHIAnpsI3yL94WDmDyUbOffq-u2cqGPk8mRQyErGhzl7A4GlaEZ3P24nqvo1J2-zwLMOg2WYyb8uwCvl7PzgxKXboDkQYdkCw__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
                        Time(0, 3, 43),
                        calYesterday.time,
                        "ca008",
                        "ar003",
                        true
                    )
                )
                add(
                    Music(
                        "ms017",
                        "Positions",
                        982,
                        "https://s3-alpha-sig.figma.com/img/9c08/fb16/f1449e135ce592b7fb46860f97792e50?Expires=1698624000&Signature=Mk6dCKGWEd~5KCHTTWKr22CUD1EPJk0IBvK1IMtniWFvoM-5M3f5XSqedOk7Le1Bt3yU4rwGZXsNcvZVxdZZGrc690NCWbUPcWhGzKgiLH9qc1GihYv4ejMsS76SfPidme-S9PFAoawT3--1XhfIbCJlmf-Mqxu1wPtwPe~4PH1IEwO31M7FyIMhmFv2s5I~jNL-qGfQYrNjOSWCbfWjZH0fK0XyX~5dwyc8A14aMSEdqWyk2m85Tn2d4TMrEpoQEBZObKeDMomN6BrTSAd9czVGaHct3XwOEFuELGWf4SBCRVAd1EDFE4-WZprV583FDuZOzw-7EdreX~ZWXGvSLg__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
                        Time(0, 4, 23),
                        Date("11/09/2023"),
                        "ca008",
                        "ar002",
                        false
                    )
                )
                add(
                    Music(
                        "ms018",
                        "Firework - Acoustic",
                        32,
                        "https://s3-alpha-sig.figma.com/img/a378/e53f/76aed56f8d8581b227777d466c0b5116?Expires=1698624000&Signature=e5B0uaaCxFor~1BnqHhTQrK0cZw9~IxoDVbQlFcNt38UwmbEgbhIaGqwROZhoISGNp44qBDB4kVKFyQCcitvvcQt~f5c9TflnLq~cWjIDXns~yhM1DvSSaliuuKSMVcRjvlcwOq~wey8XwBBep~~SF8MnBb77eW-D28NDj-PVp~4j~MMT6u~-pP7QqaUQWt6WWW9Rtd~2mKoJppSG4RKNb36vnLpyFHoUtCq1YBUJpFvxrpJTs91QD9hT3wZHPi7a7Swsdqg01Uwx3GkxZkgguvES2GDAT1bP1ZfyxKXQzrrYnCMFaBSjavsPtZ9syT5bmqkQHTRsmJqgLGCxlXBDA__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
                        Time(0, 3, 56),
                        Date("06/03/2023"),
                        "ca009",
                        "ar001",
                        false
                    )
                )
                add(
                    Music(
                        "ms019",
                        "Roar",
                        2031,
                        "https://s3-alpha-sig.figma.com/img/2b42/112c/fc6f30c195474a93f691153f3d390bcf?Expires=1698624000&Signature=muvbaZEzj2NKYJisO3pJCKRGbGb~ERXItx3DgmTOiUB8KccaHJp4aXOudE64CAx2~PHv8PcNW7qOwpf8NRrjD9ovfsEboIgp2eA~FDKyCY8g~BKQAEvPNI0~EPjM6MpTZSpUoejJgQj39TKa2oBMCgilim6ZdCSJl6KM3DWhfOiUvrJR3tPQX2mzBW08NqK0J~KtMWlur0at6FcamcbcjCXTZOuANAQ79f0YKyLol6AXVuWGoVBANYjlwtySytFswPzc-UffWJeXk8B2beZkchIu35U9dzRfqeke3hqq-8zrAg2UPGlfCLe~oFg0S-mP71qsK3eiQ7z9Y6~7VTXJsQ__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
                        Time(0, 3, 23),
                        calToday.time,
                        "ca009",
                        "ar001",
                        true
                    )
                )
                add(
                    Music(
                        "ms020",
                        "Teenage Dream",
                        92,
                        "https://s3-alpha-sig.figma.com/img/01b3/9d00/9dbf61695471ddeda0845c05273cd4ee?Expires=1698624000&Signature=YXfh9x0VAkgUU-GLKQIUh1I4Q8zq~kmk5L3fDsqaH-DWtcGq~n74-TfdVqkfF3OMP3AIuZgDMqk7rU9EJDNQC9yJnQbjKEyyJ1pp7M6Ydzr9P-137QC02rx2EzNVcENh87R9wvI7CLe~1C4nrwG7PJ4E93oAW9U-RTaaTwLY6MAIFpED4QM8MpxuPTmXXh3kwM~1s3DSypKfwmIZy8apAmB56QSulBtxcxKUouTiSSGbqpg90U0~DSB3tDudbdJULtD8CPsmE0lm6Qcd1~aJav--sLiNQcMwSEuzn2r6HFC40RFr7mizt51x-QOlVQb-AjOKOOJFOkhtLW-mOvShLA__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
                        Time(0, 2, 34),
                        Date("24/03/2023"),
                        "ca010",
                        "ar006",
                        false
                    )
                )
                add(
                    Music(
                        "ms021",
                        "Last Friday Night",
                        572,
                        "https://s3-alpha-sig.figma.com/img/5822/25eb/7dd77abaa2a7d741d2ea6db5f4748610?Expires=1698624000&Signature=UPItPx~BdXt4wnTSd1ZaJLV2-xaoOrlkItnDmjKSn5f3oniVYVf7mxapQ-n-19hM9hhxr-MvTF4W~ZlB1A8a6zzQMdXJtiZhJz3jqu0Y9cY8G4uuKzIDvtu-ZERxav-ozhQuILbtErI4W7eWqjfBF~2RyKMuhzT190F2km86J7~0nCP9sk2zL7EjYezsGJmO7Vtofw4T~gWTMioAlQjWgxZj7k2lIGS7EhNhtnN3~pVAkffTDjYUaN61FDfJZ1pvFoGqmX~v05hmlgsF0GV007-tTUV1lBynwZ90zYXUh8sXxwUFmpXDqtidlabBVfcUgPYhn4ZZT1Q~X3HnIDMb9w__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
                        Time(0, 4, 45),
                        Date("01/02/2023"),
                        "ca010",
                        "ar002",
                        false
                    )
                )
                add(
                    Music(
                        "ms022",
                        "487: Mike Rowe | Dirty Jobs",
                        42,
                        "https://s3-alpha-sig.figma.com/img/bd8c/dd28/bedb56fafecef4a4741a242dd3d897e9?Expires=1698624000&Signature=Ar3-S5YATjVkDNEmO3FU~SetkwsFoPSi7my2skmzbYQvbcdqCx4kidTARSVnnFkTVn4a-CJiKbq74MZoZKSgMtsAASmrdJ0W4nkKvskWyPyP45PE~C7-euhEc9-7SYMxVsbyAwak6t5U9i-9aQgT5emVVcTxEvzY2ugYpGnkHbr2EZZj6DVwATaij7nrr0pxXggqtEUDb-Y1liCeMZyaedfKBIwnM9PtJxoGi9W~v83A2CdeQ46Xovf5wdaYP3zXbVXLDmm8ZAU6VJudSExWJUn96HY7p5Az3flPOnuLcor-qF3J7kqnUR-h08RreIa3OjHeMBIj1aCJbHF9myjjKg__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
                        Time(0, 50, 53),
                        Date("23/06/2023"),
                        "ca002",
                        "ar002",
                        false,
                        "https://cdn.pixabay.com/audio/2023/07/03/audio_80cd47077b.mp3",
                        "Shaquille O'Neal (@SHAQ) has been retired from basketball for years, but he’s still got his irons in plenty of fires. Here, we’ll discuss everything from superheroes to law enforcement to business to sports to podcasting to — yes — the Flat Earth Theory. What We Discuss with Shaquille O'Neal: The real-world experience Shaq endured preparing for a political race in 2020. How Shaq assembled what he calls The Panel to help manage not only his career but all his important life decisions — and how you can do the same. Why Shaq doesn’t consider himself a celebrity (and why that still isn’t a good reason to bug him in the middle of dinner). How Shaq manages his emotions so he stays non-reactive on and off the court. Does Shaq really believe in the Flat Earth Theory?"
                    )
                )
                add(
                    Music(
                        "ms023",
                        "938: Tom Wright | Billion Dollar",
                        15,
                        "https://s3-alpha-sig.figma.com/img/27ec/c26e/388f34cee13da5fc9b512da39e876b3e?Expires=1698624000&Signature=ajxgDcQGM4gOMQ8xUEuO5-ZYvsGKZ7lwSVG~Yu7UdDHmjW90bxaXxNkCytIYZw-VBP2onfJjDocMQXgYw5wHEknNWxQrkgyJJfqq6c3N9z8EzRjaxWe2ecxIP2CTleKiv-S4fp0UIDTOlLGhg2OM~0~LUwNp7q8ubpKRkI2J0siwd53xSmKe2XZ07E-m1kA5icVOYHq4~h5Q7aNr~8ibWLNX2K8UWlmst6sw2KmKB0pHxPsgZVSl~08R3woGC9SDUR-JpBFeEMIIlW6QPKaETNqOQFqfTUmkKRWbj5jHfFAcmQkyCfgY0-k1~oZwFZ2dsLVSg3B7j4PyOdPCpUzgRQ__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
                        Time(0, 40, 33),
                        Date("05/02/2023"),
                        "ca002",
                        "ar007",
                        false,
                        "https://cdn.pixabay.com/audio/2023/07/03/audio_80cd47077b.mp3"
                    )
                )
                add(
                    Music(
                        "ms024",
                        "610: Bill Sullivan | Pleased to Meet",
                        292,
                        "https://s3-alpha-sig.figma.com/img/4743/c387/a4ee427a3f240139dc1f70f94ffe5351?Expires=1698624000&Signature=Az4tbLlqCqD5cc57eop6d1Ekm8gbGRdIEBhOutVgMOCGhMI0cifGt3r92otQb0y~j3O8xq7K0c7cm3sMTRy9j~W96va3nEYc7rwcbCBvHCfT17KbyMi9z3nssbelCeZvn8nvTZxeqcSgTGfdp3yAXQXRdmv3fe-FOVYpmY3ZlYiqHmpmwopLKES0JK8m1TH62oYFlUJe2A7WD7Pxff~JMkX6uniUYCl-QrrjKh8Z0jyI3dPh2cWWB-pYIYEh8IHcs99eFx6ucJfFtsor5BpMCjA1dH6yLtnQFf4~MGFKbRztzs~CRb8xb9TgD7dwAn3i6hkk9Rpcow3YZaaX5iWaXA__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
                        Time(0, 15, 35),
                        Date("10/05/2023"),
                        "ca002",
                        "ar008",
                        false,
                        "https://cdn.pixabay.com/audio/2023/07/03/audio_80cd47077b.mp3",
                        "Shaquille O'Neal (@SHAQ) has been retired from basketball for years, but he’s still got his irons in plenty of fires. Here, we’ll discuss everything from superheroes to law enforcement to business to sports to podcasting to — yes — the Flat Earth Theory. What We Discuss with Shaquille O'Neal: The real-world experience Shaq endured preparing for a political race in 2020. How Shaq assembled what he calls The Panel to help manage not only his career but all his important life decisions — and how you can do the same. Why Shaq doesn’t consider himself a celebrity (and why that still isn’t a good reason to bug him in the middle of dinner). How Shaq manages his emotions so he stays non-reactive on and off the court. Does Shaq really believe in the Flat Earth Theory?"
                    )
                )
                add(
                    Music(
                        "ms025",
                        "688: A-Rod | Still Having a Ball After All",
                        292,
                        "https://s3-alpha-sig.figma.com/img/2c49/b0ed/e234f658c60075523c1ddbadd5543d8a?Expires=1698624000&Signature=Pkt6lSXknOKmduH4qCPEu1m6I1Tdl2ifw26sh8sJZCQeX8ntU0j9nI-ZB0a1x-b5ytgyKClIRf6CEpgV9tjKFJCxYoqcvqxtrEDqReAYTIybH67CfuNdq~FSNtLeeA~2yPFnheHy3tVT-ip6OWpsX9yLAbX046sccL9iHtjIWcIilAPLVQFfu~Iaa5NDOkTErTq7fC2zslgJof2iDVCYSBCE6R-jGld4a-6CVr5695UTWn0enObcB4FgFapCebncpzu4QAxHLVjd-P3RnDf2~nPzr~8jTEed-4dJ489SLVeRbYC8y7HoJSu18Y7ZMDM5GULyQXMBd8kGh1Yiv~mHzg__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
                        Time(0, 25, 35),
                        Date("15/07/2023"),
                        "ca002",
                        "ar007",
                        false,
                        "https://cdn.pixabay.com/audio/2023/07/03/audio_80cd47077b.mp3"
                    )
                )
                add(
                    Music(
                        "ms026",
                        "831: Desmond Shum | Wealth, Power, Corruption, and Ven",
                        292,
                        "https://s3-alpha-sig.figma.com/img/70a7/4f46/b2666580eb98313b4d05502d23eafc39?Expires=1698624000&Signature=PHE5J9~taJrzpNJtJLzqNMwUX2nUTsRxJ~~HGT7rltZwFBraf-3Ji4mp499gm7ZcJDD1oPkfx~-AgAlR1qr2uhSt~9u6lYNatlQE7-9gXqhB77SI2ICSMk7QFp1GqjvWKwuVtDvD6YTyAIi06W4b0EvFUqXVwaI3nt~A5ztyXpn~7006TfkEGCblU3jfLn-on9dbesLecwONxzXKGCAC5IbC4YI4MxEbWPf7jdGK73uX4HR-KCyrgzkzRPuEqXr94hQivlolLYpsiTenlVEWmHYwYBlPXcA5aAL17T9ImpEO6qLvUfV8YEs8As~dDGx5VqHbY3N6SHGOgbOjx0ZFFg__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
                        Time(0, 32, 12),
                        Date("12/08/2023"),
                        "ca002",
                        "ar008",
                        false,
                        "https://cdn.pixabay.com/audio/2023/07/03/audio_80cd47077b.mp3",
                        "Shaquille O'Neal (@SHAQ) has been retired from basketball for years, but he’s still got his irons in plenty of fires. Here, we’ll discuss everything from superheroes to law enforcement to business to sports to podcasting to — yes — the Flat Earth Theory. What We Discuss with Shaquille O'Neal: The real-world experience Shaq endured preparing for a political race in 2020. How Shaq assembled what he calls The Panel to help manage not only his career but all his important life decisions — and how you can do the same. Why Shaq doesn’t consider himself a celebrity (and why that still isn’t a good reason to bug him in the middle of dinner). How Shaq manages his emotions so he stays non-reactive on and off the court. Does Shaq really believe in the Flat Earth Theory?"
                    )
                )
                add(
                    Music(
                        "ms027",
                        "396: Chris Voss | Hostage Negotiation Tactics",
                        292,
                        "https://s3-alpha-sig.figma.com/img/d314/77c1/0dd76442332f9af797ad4cf0c673f073?Expires=1698624000&Signature=ZzN1E5kwuOuZ1MfL7zsedSnEn31uoeb-618ipRoIlSeigBGGRgiidO2bY6mptA03QuSlVgEgEcoGs-I4IdiqQRBKnUDI~SBmG3iMRGGhoe9Bp0-QZGcnNzLJ5X3kx0RfZYERxRNYL45E5RRudlTxCJYLZ-fD2bUccFB-qd~h4bZJnAHLGl5mMpfpbNuPSmVffzHLUB8JrULundXxprDS8MdX9o03uP0jFZYa8TQg3ULqLoOAKjSQTomRx4gbxQtBeq5NecrXy7kiy3rRCk5UQG3RQPJiEEamTtCUWnobOcUvGKUSS0q~d4TOOHgyEqCXCHnC4En-WOs-59ID5C5T6g__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
                        Time(0, 23, 32),
                        Date("05/09/2023"),
                        "ca002",
                        "ar009",
                        false,
                        "https://cdn.pixabay.com/audio/2023/07/03/audio_80cd47077b.mp3",
                        "Shaquille O'Neal (@SHAQ) has been retired from basketball for years, but he’s still got his irons in plenty of fires. Here, we’ll discuss everything from superheroes to law enforcement to business to sports to podcasting to — yes — the Flat Earth Theory. What We Discuss with Shaquille O'Neal: The real-world experience Shaq endured preparing for a political race in 2020. How Shaq assembled what he calls The Panel to help manage not only his career but all his important life decisions — and how you can do the same. Why Shaq doesn’t consider himself a celebrity (and why that still isn’t a good reason to bug him in the middle of dinner). How Shaq manages his emotions so he stays non-reactive on and off the court. Does Shaq really believe in the Flat Earth Theory?"
                    )
                )
            }
            return dataMusic
        }
    }
}
