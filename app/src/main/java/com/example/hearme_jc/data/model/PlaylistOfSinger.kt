package com.example.hearme_jc.data.model

data class PlaylistOfSinger(
    val playlistOfSingerID: String,
    val playlistOfSingerName: String,
    val image: String? = null,
    val artistID: String,
    val release: Int? = 2023,
    val listMusic: ArrayList<String> = ArrayList(),
)

class PlaylistOfSingerData {
    companion object {
        fun data(): ArrayList<PlaylistOfSinger> {
            val data = ArrayList<PlaylistOfSinger>()
            data.apply {
                add(
                    PlaylistOfSinger(
                        "pos001",
                        "Sweetener",
                        null,
                        "ar001",
                        2018,
                        arrayListOf("ms019")
                    )
                )
                add(
                    PlaylistOfSinger(
                        "pos002",
                        "Dangerous Woman",
                        null,
                        "ar001",
                        2016,
                        arrayListOf("ms018")
                    )
                )
                add(
                    PlaylistOfSinger(
                        "pos003",
                        "Yours Truly",
                        null,
                        "ar001",
                        2013,
                        arrayListOf("ms011")
                    )
                )
                add(
                    PlaylistOfSinger(
                        "pos004",
                        "My Everything",
                        null,
                        "ar001",
                        2014,
                        arrayListOf("ms003")
                    )
                )
            }
            return data
        }
    }
}
