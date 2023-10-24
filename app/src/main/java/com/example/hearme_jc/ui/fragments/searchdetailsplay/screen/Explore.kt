package com.example.hearme_jc.ui.fragments.searchdetailsplay.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.hearme_jc.R
import com.example.hearme_jc.data.model.Category
import com.example.hearme_jc.data.viewmodel.CategoryViewModel
import com.example.hearme_jc.data.viewmodel.RecentSearchViewModel
import com.example.hearme_jc.navigation.Screen
import com.example.hearme_jc.ui.theme.Primary500


@Composable
fun ExploreScreen(
    navController: NavController,
    categoryViewModel: CategoryViewModel,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 24.dp, start = 24.dp),
            text = "Browse All",
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 24.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                fontWeight = FontWeight(700),
                color = MaterialTheme.colorScheme.onBackground,
            )
        )

        LazyVerticalGridCategory(modifier = Modifier, categoryViewModel = categoryViewModel, navController = navController)
    }
}

@Composable
fun LazyVerticalGridCategory(modifier: Modifier = Modifier, categoryViewModel: CategoryViewModel, navController: NavController) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(160.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(24.dp)
    ) {
        items(categoryViewModel.GetAllCategories()) {
            CategoryCard(modifier = Modifier, it, navController = navController)
        }
    }
}

@Composable
fun CategoryCard(modifier: Modifier = Modifier, category: Category, navController: NavController) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
            .clip(shape = RoundedCornerShape(28.dp))
            .clickable { navController.navigate("${Screen.DetailsCategory.route}/${category.categoryID}") },
        shape = RoundedCornerShape(28.dp), colors = CardDefaults.cardColors(category.background)
    ) {
        ConstraintLayout(modifier = Modifier) {
            Text(
                modifier = Modifier
                    .padding(20.dp),
                text = category.categoryName,
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 25.2.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                    fontWeight = FontWeight(700),
                    color = Color.White,
                    letterSpacing = 0.2.sp,
                )
            )

//            ChildImage(modifier = Modifier.size(80.dp).constrainAs(image){}, url = category.image)
        }
    }
}

@Composable
fun ChildImage(modifier: Modifier = Modifier, url: String) {
    Image(
        painter = painterResource(id = R.drawable.img_bg_01),
        contentDescription = null,
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .rotate(45f),
        contentScale = ContentScale.Fit,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppSearchBar(
    modifier: Modifier = Modifier,
    query: MutableState<String>,
    active: MutableState<Boolean>,
    recentSearchViewModel: RecentSearchViewModel,
    navController: NavController,
) {
    Box(modifier = Modifier.padding(end = if (!active.value) 24.dp else 0.dp, start = if (!active.value) 24.dp else 0.dp)) {
        SearchBar(
            modifier = modifier
                .fillMaxWidth(),
            query = query.value,
            onQueryChange = { query.value = it },
            onSearch = {
                recentSearchViewModel.UpdateRecentSearch(query.value)
                navController.navigate("${Screen.ResultSearch.route}/${query.value}")
                active.value = false
            },
            active = active.value,
            onActiveChange = { it.also { active.value = it } },
            colors = SearchBarDefaults.colors(containerColor = MaterialTheme.colorScheme.inversePrimary),
            placeholder = {
                Text(
                    text = "Artists, Songs, Podcasts, & More",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 19.6.sp,
                        fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                        fontWeight = FontWeight(400),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        letterSpacing = 0.2.sp,
                    )
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null,
                    tint = if (active.value) Primary500 else MaterialTheme.colorScheme.onSurfaceVariant
                )
            },
            trailingIcon = {
                if (query.value.isNotEmpty())
                    IconButton(onClick = { query.value = "" }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_close),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                else
                    null
            },
        ) {
            LazyColumn(
                modifier = Modifier.padding(end = 24.dp, start = 24.dp, top = 24.dp),
            ) {
                item {
                    Row {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = "Recent Searches",
                            style = TextStyle(
                                fontSize = 20.sp,
                                lineHeight = 24.sp,
                                fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                                fontWeight = FontWeight(700),
                                color = MaterialTheme.colorScheme.onBackground,
                            )
                        )

                        Text(
                            modifier = Modifier
                                .clickable { recentSearchViewModel.DeleteAllRecentSearches() }
                                .weight(1f),
                            text = "Clear All",
                            style = TextStyle(
                                fontSize = 16.sp,
                                lineHeight = 22.4.sp,
                                fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                                fontWeight = FontWeight(700),
                                color = Primary500,
                                textAlign = TextAlign.Right,
                                letterSpacing = 0.2.sp,
                            )
                        )
                    }
                }

                item {
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp, bottom = 24.dp),
                        color = MaterialTheme.colorScheme.outlineVariant,
                        thickness = 1.dp
                    )
                }

                items(recentSearchViewModel.GetAllRecentSearches().value.reversed().take(10)) {
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.height(IntrinsicSize.Max)) {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = it.name,
                            style = TextStyle(
                                fontSize = 18.sp,
                                lineHeight = 25.2.sp,
                                fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                                fontWeight = FontWeight(500),
                                color = MaterialTheme.colorScheme.onTertiaryContainer,
                                letterSpacing = 0.2.sp,
                            )
                        )

                        IconButton(onClick = { recentSearchViewModel.DeleteRecentSearch(it.name) }) {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                painter = painterResource(id = R.drawable.ic_close),
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onTertiaryContainer
                            )
                        }
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun AppSearchBarPreview() {
//    Hearme_JCTheme {
//        Surface(
//            modifier = Modifier.padding(24.dp),
//            color = MaterialTheme.colorScheme.background
//        ) {
//
//            CategoryCard(
//                category = Category(
//                    "ca009",
//                    "Jazz",
//                    "https://s3-alpha-sig.figma.com/img/9d88/5607/87f73b42744eec682913ce7eb92a19f5?Expires=1698624000&Signature=qKsngf5xqDB7e5Dr03Mmfly-UTLUwmp7qqto-an7dhEZJcSYhXWiTuXyJGe8eiN0FXBRBTjHHC-ylLuigkxi-xweLq8Z-ZWE4~4xsPtpJcXG4D5Yd2AXWsdnlTspDmgc8b4Eu-QcbJIuZ~DwbNas7B8rJxMcPVOtmCIkePCIInknhXFETHxGGSyWrNBDfh5rYU7aotxYfxDP9K7P3N2a3C2kz-qlwI8dSNmf7u678BvzLmDFVIQ6s7vzMXS7jhieb0GsTkpEDRZYYIdg~72rzHdyT1ldHNOCPVXFFriATn4d-SMHCAL98qmpv32V9sY11waSCBjL5wAmsq-opOUhrQ__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
//                    Jazz
//                )
//            )
//        }
//    }
//}