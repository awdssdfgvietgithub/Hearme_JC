package com.example.hearme_jc.data.model

import com.example.hearme_jc.R

data class SpinnerItem(val image: Int, val name: String)

class MoreSongData {
    companion object {
        fun data(): ArrayList<SpinnerItem> {
            val data = ArrayList<SpinnerItem>()
            data.apply {
                add(SpinnerItem(R.drawable.ic_bold_heart, "Nothing"))
                add(SpinnerItem(R.drawable.ic_light_heart, "Like"))
                add(SpinnerItem(R.drawable.ic_add_playlist, "Add to Playlist"))
                add(SpinnerItem(R.drawable.ic_don_play, "Don't Play This"))
                add(SpinnerItem(R.drawable.ic_light_down, "Download"))
                add(SpinnerItem(R.drawable.ic_profile, "View Artist"))
                add(SpinnerItem(R.drawable.ic_playback, "Go to Album"))
                add(SpinnerItem(R.drawable.ic_check_box, "Mark as Played"))
                add(SpinnerItem(R.drawable.ic_podcast, "Go to Podcast"))
                add(SpinnerItem(R.drawable.ic_share, "Share"))
            }
            return data
        }
    }
}