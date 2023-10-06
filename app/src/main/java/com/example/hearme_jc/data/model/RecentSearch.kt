package com.example.hearme_jc.data.model

data class RecentSearch(val name: String)

class RecentSearchesData {
    companion object {
        fun data(): ArrayList<RecentSearch> {
            val data = ArrayList<RecentSearch>()
            data.apply {
                add(RecentSearch("Ariana Grande"))
                add(RecentSearch("Morgan Wallen"))
                add(RecentSearch("Justin Bieber"))
                add(RecentSearch("Drake"))
                add(RecentSearch("Olivia Rodrigo"))
                add(RecentSearch("The Weeknd"))
                add(RecentSearch("Taylor Swift"))
                add(RecentSearch("Juice Wrld"))
            }
            return data
        }
    }
}