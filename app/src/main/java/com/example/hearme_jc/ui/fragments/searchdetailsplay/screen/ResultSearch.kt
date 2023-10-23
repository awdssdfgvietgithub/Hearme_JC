package com.example.hearme_jc.ui.fragments.searchdetailsplay.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hearme_jc.R
import com.example.hearme_jc.data.model.TopicSearch
import com.example.hearme_jc.data.viewmodel.TopicSearchViewModel
import com.example.hearme_jc.ui.theme.Primary500

enum class TabSearch(val title: String) {
    Top("Top"),
    Songs("Songs"),
    Artists("Artists"),
    Albums("Albums"),
    Podcasts("Podcasts"),
    Playlists("Playlists"),
    Profiles("Profiles")
}

@Composable
fun ResultSearchScreen(
    navController: NavController,
    topicSearchViewModel: TopicSearchViewModel,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        LazyRowTopicSearches(_topicSearches = topicSearchViewModel._topicSearches)

        LazyColumn(modifier = Modifier.padding(end = 24.dp, start = 24.dp)) {

        }
    }
}

@Composable
fun LazyRowTopicSearches(_topicSearches: MutableState<ArrayList<TopicSearch>>) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(start = 24.dp, end = 24.dp)
    ) {
        items(_topicSearches.value) {
            TopicSearchCard(topicSearch = it, _topicSearches = _topicSearches)
        }
    }
}

@Composable
fun TopicSearchCard(
    modifier: Modifier = Modifier,
    topicSearch: TopicSearch,
    _topicSearches: MutableState<ArrayList<TopicSearch>>,
) {
    val isChecked = rememberSaveable {
        mutableStateOf(false)
    }
    AppToggleButtonTopicSearch(_topicSearches = _topicSearches, name = topicSearch.name)
}

//@Preview(showBackground = true)
//@Composable
//fun TopicSearchCardPreview() {
//    Hearme_JCTheme {
//        Surface(color = MaterialTheme.colors.background, modifier = Modifier.padding(24.dp)) {
//            TopicSearchCard(tabSearch = TabSearch.Top)
//        }
//    }
//}

@Composable
fun AppToggleButtonTopicSearch(
    modifier: Modifier = Modifier,
    _topicSearches: MutableState<ArrayList<TopicSearch>>,
    name: String,
) {
//    isChecked.value = topicSearchViewModel.GetTopicSearch(name).isChecked
    OutlinedButton(
        onClick = {
            _topicSearches.value.forEach {
                it.isChecked = false
            }
            _topicSearches.value.first { it.name == name }.apply {
                this.isChecked = true
            }
        },
        modifier = modifier
            .defaultMinSize(minHeight = 1.dp)
            .padding(top = 2.dp, bottom = 2.dp),
        colors = if (_topicSearches.value.first { it.name == name }.isChecked) ButtonDefaults.buttonColors(Primary500) else ButtonDefaults.buttonColors(
            Color.Transparent
        ),
        border = BorderStroke(width = 2.dp, color = Primary500)
    ) {
        Text(
            modifier = Modifier,
            text = name,
            style = if (_topicSearches.value.first { it.name == name }.isChecked) TextStyle(
                fontSize = 14.sp,
                lineHeight = 19.6.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
                fontWeight = FontWeight(600),
                color = Color.White,
                textAlign = TextAlign.Center,
                letterSpacing = 0.2.sp,
            ) else TextStyle(
                fontSize = 14.sp,
                lineHeight = 19.6.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
                fontWeight = FontWeight(600),
                color = Primary500,
                textAlign = TextAlign.Center,
                letterSpacing = 0.2.sp,
            )
        )
    }
}
