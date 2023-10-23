package com.example.hearme_jc.ui.fragments.searchdetailsplay.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hearme_jc.R
import com.example.hearme_jc.data.viewmodel.CategoryViewModel
import com.example.hearme_jc.data.viewmodel.DetailsCategoryViewModel
import com.example.hearme_jc.navigation.Screen
import com.example.hearme_jc.ui.fragments.homeactionmenu.screen.DetailsCategoryCard

@Composable
fun DetailsCategory(
    navController: NavController,
    categoryViewModel: CategoryViewModel,
    categoryID: String,
    detailsCategoryViewModel: DetailsCategoryViewModel,
) {
    val nameCategory = categoryViewModel.GetCategory(categoryID).categoryName

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(top = 32.dp, end = 24.dp, start = 24.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        ContainerAlbumOfCategory(
            navController = navController,
            nameCategory = nameCategory,
            detailsCategoryViewModel = detailsCategoryViewModel,
            categoryID = categoryID
        )
        ContainerSongOfCategory(
            navController = navController,
            nameCategory = nameCategory,
            detailsCategoryViewModel = detailsCategoryViewModel,
            categoryID = categoryID
        )
    }
}

@Composable
fun ContainerSongOfCategory(
    modifier: Modifier = Modifier,
    navController: NavController,
    nameCategory: String,
    detailsCategoryViewModel: DetailsCategoryViewModel,
    categoryID: String,
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text(
            text = "Weekly Song $nameCategory",
            style = TextStyle(
                fontSize = 24.sp,
                lineHeight = 28.8.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                fontWeight = FontWeight(700),
                color = MaterialTheme.colorScheme.onBackground,
            )
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                DetailsCategoryCard(
                    modifier = Modifier.width(184.dp),
                    detailsCategory = detailsCategoryViewModel.GetDetailsCategory("c005"),
                    modifierGI = Modifier.size(184.dp),
                    onClick = { navController.navigate("${Screen.ListMusicsOfDetailsCategory.route}/$categoryID/c005") }
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Top Albums Global",
                    style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 24.sp,
                        fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                        fontWeight = FontWeight(700),
                        color = MaterialTheme.colorScheme.onBackground,
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Column(modifier = Modifier.weight(1f)) {
                DetailsCategoryCard(
                    modifier = Modifier.width(184.dp),
                    detailsCategory = detailsCategoryViewModel.GetDetailsCategory("c006"),
                    modifierGI = Modifier.size(184.dp),
                    onClick = { navController.navigate("${Screen.ListMusicsOfDetailsCategory.route}/$categoryID/c006") }
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Top Albums United States",
                    style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 24.sp,
                        fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                        fontWeight = FontWeight(700),
                        color = MaterialTheme.colorScheme.onBackground,
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun ContainerAlbumOfCategory(
    modifier: Modifier = Modifier,
    navController: NavController,
    nameCategory: String,
    detailsCategoryViewModel: DetailsCategoryViewModel,
    categoryID: String,
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text(
            text = "Weekly Album $nameCategory",
            style = TextStyle(
                fontSize = 24.sp,
                lineHeight = 28.8.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                fontWeight = FontWeight(700),
                color = MaterialTheme.colorScheme.onBackground,
            )
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                DetailsCategoryCard(
                    modifier = Modifier.width(184.dp),
                    detailsCategory = detailsCategoryViewModel.GetDetailsCategory("c003"),
                    modifierGI = Modifier.size(184.dp),
                    onClick = { navController.navigate("${Screen.ListMusicsOfDetailsCategory.route}/$categoryID/c003") }
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Top Albums Global",
                    style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 24.sp,
                        fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                        fontWeight = FontWeight(700),
                        color = MaterialTheme.colorScheme.onBackground,
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Column(modifier = Modifier.weight(1f)) {
                DetailsCategoryCard(
                    modifier = Modifier.width(184.dp),
                    detailsCategory = detailsCategoryViewModel.GetDetailsCategory("c004"),
                    modifierGI = Modifier.size(184.dp),
                    onClick = { navController.navigate("${Screen.ListMusicsOfDetailsCategory.route}/$categoryID/c004") }
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Top Albums United States",
                    style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 24.sp,
                        fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                        fontWeight = FontWeight(700),
                        color = MaterialTheme.colorScheme.onBackground,
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

//@Preview(showBackground = true, widthDp = 412, heightDp = 915)
//@Composable
//fun ChartsScreenPreview() {
//    Hearme_JCTheme {
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            val navController = rememberNavController()
//
//            ChartsScreen(navController = navController)
//        }
//    }
//}