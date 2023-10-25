package com.example.hearme_jc.data.model

data class PlaylistOfSinger(
    val playlistOfSingerID: String,
    val playlistOfSingerName: String,
    val image: String? = null,
    val artistID: String,
    val release: Int? = 2023,
    val createdBy: String? = "Theresa Wilona",
)

class PlaylistOfSingerData {
    companion object {
        fun data(): ArrayList<PlaylistOfSinger> {
            val data = ArrayList<PlaylistOfSinger>()
            data.apply {
                add(
                    PlaylistOfSinger(
                        "pos001",
                        "All Songs",
                        "https://firebasestorage.googleapis.com/v0/b/hearme-app-16567.appspot.com/o/images%2Fartists%2FRyan_Jones.png?alt=media&token=30821e3f-4d83-4c95-8e37-c7b4e6d9a5c6&_gl=1*1y0plpm*_ga*MTUyOTk3NDI1NS4xNjkzMzU5NjY4*_ga_CW55HF8NVT*MTY5NTg4MTg4Mi42LjEuMTY5NTg4MzExOC4yNC4wLjA.",
                        "ar001",
                        2022,
                    )
                )
                add(
                    PlaylistOfSinger(
                        "pos002",
                        "Top Greatest Hits",
                        "https://firebasestorage.googleapis.com/v0/b/hearme-app-16567.appspot.com/o/images%2Fartists%2FRyan_Jones.png?alt=media&token=30821e3f-4d83-4c95-8e37-c7b4e6d9a5c6&_gl=1*1y0plpm*_ga*MTUyOTk3NDI1NS4xNjkzMzU5NjY4*_ga_CW55HF8NVT*MTY5NTg4MTg4Mi42LjEuMTY5NTg4MzExOC4yNC4wLjA.",
                        "ar001",
                        2021,
                    )
                )
                add(
                    PlaylistOfSinger(
                        "pos003",
                        "Most Listened Songs",
                        "https://firebasestorage.googleapis.com/v0/b/hearme-app-16567.appspot.com/o/images%2Fartists%2FRyan_Jones.png?alt=media&token=30821e3f-4d83-4c95-8e37-c7b4e6d9a5c6&_gl=1*1y0plpm*_ga*MTUyOTk3NDI1NS4xNjkzMzU5NjY4*_ga_CW55HF8NVT*MTY5NTg4MTg4Mi42LjEuMTY5NTg4MzExOC4yNC4wLjA.",
                        "ar001",
                        2023,
                    )
                )
                add(
                    PlaylistOfSinger(
                        "pos004",
                        "Complete Albums",
                        "https://firebasestorage.googleapis.com/v0/b/hearme-app-16567.appspot.com/o/images%2Fartists%2FRyan_Jones.png?alt=media&token=30821e3f-4d83-4c95-8e37-c7b4e6d9a5c6&_gl=1*1y0plpm*_ga*MTUyOTk3NDI1NS4xNjkzMzU5NjY4*_ga_CW55HF8NVT*MTY5NTg4MTg4Mi42LjEuMTY5NTg4MzExOC4yNC4wLjA.",
                        "ar001",
                        2020,
                    )
                )
            }
            return data
        }
    }
}
