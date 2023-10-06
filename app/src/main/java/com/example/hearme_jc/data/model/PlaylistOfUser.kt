package com.example.hearme_jc.data.model

class PlaylistOfUser(
    val playlistOfUserID: String,
    val playlistOfUserName: String,
    val image: String? = null,
    val email: String,
    val listMusic: ArrayList<String> = ArrayList(),
)

class PlaylistOfUserData {
    companion object {
        fun dataPlaylist(): ArrayList<PlaylistOfUser> {
            val dataPlaylist = ArrayList<PlaylistOfUser>()
            dataPlaylist.apply {
                add(
                    PlaylistOfUser(
                        "pou001",
                        "My Favorite Pop Songs",
                        null,
                        "phuongviet.huit@gmail.com",
                        arrayListOf("ms001", "ms002", "ms005", "ms008")
                    )
                )
                add(
                    PlaylistOfUser(
                        "pou002",
                        "90s Old Song",
                        null,
                        "phuongviet.huit@gmail.com",
                        arrayListOf("ms004", "ms003", "ms006", "ms008")
                    )
                )
                add(
                    PlaylistOfUser(
                        "pou003",
                        "Legend Rock Song",
                        null,
                        "phuongviet.huit@gmail.com",
                        arrayListOf("ms011", "ms010", "ms005", "ms003")
                    )
                )
            }
            return dataPlaylist
        }
    }
}

