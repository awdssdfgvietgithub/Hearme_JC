package com.example.hearme_jc.ui.activities

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.hearme_jc.R
import com.example.hearme_jc.data.viewmodel.RecentSearchViewModel
import com.example.hearme_jc.navigation.NavGraph
import com.example.hearme_jc.navigation.Screen
import com.example.hearme_jc.ui.activities.data.Destinations
import com.example.hearme_jc.ui.fragments.searchdetailsplay.screen.AppSearchBar
import com.example.hearme_jc.ui.theme.Greyscale500
import com.example.hearme_jc.ui.theme.Hearme_JCTheme
import com.example.hearme_jc.ui.theme.Primary500

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val recentSearchViewModel: RecentSearchViewModel = viewModel()
            Hearme_JCTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(recentSearchViewModel)
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(recentSearchViewModel: RecentSearchViewModel) {
    val navController: NavHostController = rememberNavController()

    //State of topBar, false is its invisible
    val isShowToolbar = rememberSaveable {
        mutableStateOf(false)
    }

    //State of navBar, false is its invisible
    val isShowNavBar = rememberSaveable {
        mutableStateOf(false)
    }

    //State of topBar, title of its
    val onTitleChange = rememberSaveable {
        mutableStateOf("")
    }

    //State of navIcon
    val navIconChanged = rememberSaveable {
        mutableIntStateOf(0)
    }

    //State of navIcon
    val isShowAvatar = rememberSaveable {
        mutableStateOf(false)
    }

    //Show actions toolbar
    val isShowSearch = rememberSaveable {
        mutableStateOf(false)
    }

    val isShowNotification = rememberSaveable {
        mutableStateOf(false)
    }

    val isShowMore = rememberSaveable {
        mutableStateOf(false)
    }

    val isShowFilter = rememberSaveable {
        mutableStateOf(false)
    }

    val isShowScan = rememberSaveable {
        mutableStateOf(false)
    }

    val isShowEdit = rememberSaveable {
        mutableStateOf(false)
    }

    //Search bar
    val query = rememberSaveable {
        mutableStateOf("")
    }

    val active = rememberSaveable {
        mutableStateOf(false)
    }

    val isShowSearchBar = rememberSaveable {
        mutableStateOf(false)
    }

    //Get current screen/fragment
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val route = navBackStackEntry?.destination?.route
    Log.v("navBackStackEntry", route.toString())

    //Check to recompose topBar when navigating to a screen/fragment
    when (route) {
        //Onboard
        Screen.Splash.route -> {
            isShowNavBar.value = false
            isShowToolbar.value = false

        }

        Screen.Walkthrough.route -> {
            isShowNavBar.value = false
            isShowToolbar.value = false
        }

        Screen.LetYouIn.route -> {
            isShowNavBar.value = false
            isShowToolbar.value = true
            navIconChanged.value = R.drawable.ic_arrow_back
            isShowAvatar.value = false
        }

        //Authentication
        Screen.SignUp.route -> {
            isShowNavBar.value = false
            isShowToolbar.value = true
            onTitleChange.value = ""
            navIconChanged.value = R.drawable.ic_arrow_back
            isShowAvatar.value = false
        }

        Screen.SignIn.route -> {
            isShowNavBar.value = false
            isShowToolbar.value = true
            onTitleChange.value = ""
            navIconChanged.value = R.drawable.ic_arrow_back
            isShowAvatar.value = false
        }

        Screen.SelectMethods.route -> {
            isShowNavBar.value = false
            isShowToolbar.value = true
            onTitleChange.value = "Forgot Password"
            navIconChanged.value = R.drawable.ic_arrow_back
            isShowAvatar.value = false
        }

        Screen.TypeOTP.route -> {
            isShowNavBar.value = false
            isShowToolbar.value = true
            onTitleChange.value = "Forgot Password"
            navIconChanged.value = R.drawable.ic_arrow_back
            isShowAvatar.value = false
        }

        Screen.CreateNewPassword.route -> {
            isShowNavBar.value = false
            isShowToolbar.value = true
            onTitleChange.value = "Create New Password"
            navIconChanged.value = R.drawable.ic_arrow_back
            isShowAvatar.value = false
        }

        //Account Setup
        Screen.FillYourProfile.route -> {
            isShowNavBar.value = false
            isShowToolbar.value = true
            onTitleChange.value = "Fill Your Profile"
            navIconChanged.value = R.drawable.ic_arrow_back
            isShowAvatar.value = false
        }

        Screen.CreateNewPin.route -> {
            isShowNavBar.value = false
            isShowToolbar.value = true
            onTitleChange.value = "Create New PIN"
            navIconChanged.value = R.drawable.ic_arrow_back
            isShowAvatar.value = false
        }

        Screen.SetYourFingerprint.route -> {
            isShowNavBar.value = false
            isShowToolbar.value = true
            onTitleChange.value = "Set Your Fingerprint"
            navIconChanged.value = R.drawable.ic_arrow_back
            isShowAvatar.value = false
        }

        Screen.FollowArtists.route -> {
            isShowNavBar.value = false
            isShowToolbar.value = true
            onTitleChange.value = "Follow Artists"
            navIconChanged.value = R.drawable.ic_arrow_back
            isShowAvatar.value = false
        }

        //Tab Home
        Screen.Home.route -> {
            isShowNavBar.value = true
            isShowToolbar.value = true
            onTitleChange.value = ""
            isShowAvatar.value = true
            isShowSearchBar.value = false

            isShowSearch.value = true
            isShowNotification.value = true
            isShowMore.value = false
            isShowFilter.value = false
            isShowScan.value = false
            isShowEdit.value = false
        }

        Screen.SeeAllTrendingNow.route -> {
            isShowNavBar.value = true
            isShowToolbar.value = true
            onTitleChange.value = "Trending Now"
            navIconChanged.value = R.drawable.ic_arrow_back
            isShowAvatar.value = false
            isShowSearchBar.value = false

            isShowSearch.value = true
            isShowNotification.value = false
            isShowMore.value = false
            isShowFilter.value = false
            isShowScan.value = false
            isShowEdit.value = false
        }

        Screen.SeeAllPopularArtists.route -> {
            isShowNavBar.value = true
            isShowToolbar.value = true
            onTitleChange.value = "Popular Artists"
            navIconChanged.value = R.drawable.ic_arrow_back
            isShowAvatar.value = false
            isShowSearchBar.value = false

            isShowSearch.value = true
            isShowNotification.value = false
            isShowMore.value = false
            isShowFilter.value = false
            isShowScan.value = false
            isShowEdit.value = false
        }

        Screen.Notification.route -> {
            isShowNavBar.value = true
            isShowToolbar.value = true
            onTitleChange.value = "Popular Artists"
            navIconChanged.value = R.drawable.ic_arrow_back
            isShowAvatar.value = false
            isShowSearchBar.value = false

            isShowSearch.value = false
            isShowNotification.value = false
            isShowMore.value = true
            isShowFilter.value = false
            isShowScan.value = false
            isShowEdit.value = false
        }

        //Tab Explore
        Screen.Explore.route -> {
            isShowNavBar.value = true
            isShowToolbar.value = true
            onTitleChange.value = "Explore"
            navIconChanged.value = R.drawable.ic_music
            isShowAvatar.value = false
            isShowSearchBar.value = true

            isShowSearch.value = false
            isShowNotification.value = false
            isShowMore.value = true
            isShowFilter.value = false
            isShowScan.value = false
            isShowEdit.value = false
        }

        "${Screen.DetailsCategory.route}/{categoryID}" -> {
            isShowNavBar.value = false
            isShowToolbar.value = true
            onTitleChange.value = "Charts"
            navIconChanged.value = R.drawable.ic_arrow_back
            isShowAvatar.value = false
            isShowSearchBar.value = false

            isShowSearch.value = true
            isShowNotification.value = false
            isShowMore.value = false
            isShowFilter.value = false
            isShowScan.value = false
            isShowEdit.value = false
        }

        "${Screen.ListMusicsOfDetailsCategory.route}/{categoryID}/{detailsCategoryID}" -> {
            isShowNavBar.value = false
            isShowToolbar.value = true
            onTitleChange.value = ""
            navIconChanged.value = R.drawable.ic_arrow_back
            isShowAvatar.value = false
            isShowSearchBar.value = false

            isShowSearch.value = false
            isShowNotification.value = false
            isShowMore.value = false
            isShowFilter.value = false
            isShowScan.value = false
            isShowEdit.value = false
        }

        Screen.ResultSearch.route -> {
            isShowNavBar.value = false
            isShowToolbar.value = true
            onTitleChange.value = ""
            navIconChanged.value = R.drawable.ic_music
            isShowAvatar.value = false
            isShowSearchBar.value = true

            isShowSearch.value = false
            isShowNotification.value = false
            isShowMore.value = false
            isShowFilter.value = false
            isShowScan.value = false
            isShowEdit.value = false
        }
        //Tab Library
        Screen.Library.route -> {
            isShowNavBar.value = true
            isShowToolbar.value = true
            onTitleChange.value = ""
            isShowAvatar.value = true
            isShowSearchBar.value = false

            isShowSearch.value = true
            isShowNotification.value = false
            isShowMore.value = true
            isShowFilter.value = false
            isShowScan.value = false
            isShowEdit.value = false
        }

        //Tab Profile
        Screen.Profile.route -> {
            isShowNavBar.value = true
            isShowToolbar.value = true
            onTitleChange.value = ""
            isShowAvatar.value = true
            isShowSearchBar.value = false

            isShowSearch.value = false
            isShowNotification.value = false
            isShowMore.value = true
            isShowFilter.value = false
            isShowScan.value = false
            isShowEdit.value = false
        }
    }

    val buttonsVisible = remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            Column(modifier = Modifier) {
                AnimatedVisibility(visible = !active.value) {
                    TopBar(
                        isVisible = isShowToolbar,
                        onTitleChange = onTitleChange,
                        onNavIconClicked = {
                            if (route == Screen.LetYouIn.route ||
                                route == Screen.SignUp.route ||
                                route == Screen.SignIn.route ||
                                route == Screen.FillYourProfile.route ||
                                route == Screen.CreateNewPin.route ||
                                route == Screen.SetYourFingerprint.route ||
                                route == Screen.FollowArtists.route ||
                                route == Screen.SelectMethods.route ||
                                route == Screen.TypeOTP.route ||
                                route == Screen.CreateNewPassword.route ||
                                route == Screen.SeeAllTrendingNow.route ||
                                route == Screen.SeeAllPopularArtists.route ||
                                route == Screen.Notification.route ||
                                route == "${Screen.DetailsCategory.route}/{categoryID}" ||
                                route == "${Screen.ListMusicsOfDetailsCategory.route}/{categoryID}/{detailsCategoryID}"
                            )
                                navController.popBackStack()
                        },
                        isShowAvatar = isShowAvatar,
                        navIcon = navIconChanged,
                        isShowSearch = isShowSearch,
                        isShowNotification = isShowNotification,
                        isShowMore = isShowMore,
                        isShowFilter = isShowFilter,
                        isShowScan = isShowScan,
                        isShowEdit = isShowEdit,
                        navController = navController,
                        recentSearchViewModel = recentSearchViewModel
                    )
                }
                AnimatedVisibility(visible = isShowSearchBar.value) {
                    AppSearchBar(
                        query = query,
                        active = active,
                        recentSearchViewModel = recentSearchViewModel,
                        navController = navController
                    )
                }
            }
        },
        bottomBar = {
            AnimatedVisibility(visible = !active.value) {
                BottomBar(navController = navController, state = buttonsVisible, modifier = Modifier, isVisible = isShowNavBar)
            }
        },
    ) { values ->
        Box(
            modifier = Modifier
                .padding(values)
                .fillMaxSize()
        ) {
            NavGraph(
                navController = navController,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    isVisible: MutableState<Boolean>,
    onTitleChange: MutableState<String> = mutableStateOf(""),
    onNavIconClicked: () -> Unit,
    isShowAvatar: MutableState<Boolean>,
    navIcon: MutableIntState,
    isShowSearch: MutableState<Boolean>,
    isShowNotification: MutableState<Boolean>,
    isShowMore: MutableState<Boolean>,
    isShowFilter: MutableState<Boolean>,
    isShowScan: MutableState<Boolean>,
    isShowEdit: MutableState<Boolean>,
    navController: NavController,
    recentSearchViewModel: RecentSearchViewModel,
) {
    AnimatedVisibility(visible = isVisible.value) {
        TopAppBar(
            modifier = modifier.padding(start = 12.dp, end = 12.dp),
            title = {
                if (!isShowAvatar.value) {
                    Text(
                        text = onTitleChange.value, style = TextStyle(
                            fontSize = 24.sp,
                            lineHeight = 28.8.sp,
                            fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                            fontWeight = FontWeight(700),
                            color = MaterialTheme.colorScheme.onBackground,
                        )
                    )
                } else {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 14.dp, end = 14.dp), Arrangement.Center
                    ) {
                        Text(
                            text = "Good Morning 👋",
                            style = TextStyle(
                                fontSize = 16.sp,
                                lineHeight = 22.4.sp,
                                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                                fontWeight = FontWeight(400),
                                color = MaterialTheme.colorScheme.onTertiaryContainer,
                                letterSpacing = 0.2.sp,
                            )
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "Andrew Ainsley",
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
            },
            navigationIcon = {
                if (!isShowAvatar.value)
                    IconButton(onClick = {
                        onNavIconClicked()
                    }) {
                        Icon(
                            painter = painterResource(id = navIcon.value),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                else
                    IconButton(onClick = { }) {
                        GlideImage(
                            model = "https://firebasestorage.googleapis.com/v0/b/hearme-app-16567.appspot.com/o/images%2Fusers%2Fuser_phuongviet.huit%40gmail.com.png?alt=media&token=584ab9c3-4b4b-461d-b7ea-e263e3cd2123&_gl=1*11vbk9i*_ga*MTUyOTk3NDI1NS4xNjkzMzU5NjY4*_ga_CW55HF8NVT*MTY5NTk2MDMwNi4xMS4xLjE2OTU5NjIxMTkuMzIuMC4w",
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(48.dp)
                                .clip(shape = CircleShape),
                        )
                    }

            },
            actions = {
                AnimatedVisibility(visible = isShowSearch.value) {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = "Search",
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
                AnimatedVisibility(visible = isShowNotification.value) {
                    IconButton(onClick = { navController.navigate(Screen.Notification.route) }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_notification),
                            contentDescription = "Notification",
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
                AnimatedVisibility(visible = isShowMore.value) {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_more_circle),
                            contentDescription = "More",
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
                AnimatedVisibility(visible = isShowFilter.value) {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_filter),
                            contentDescription = "Filter",
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
                AnimatedVisibility(visible = isShowScan.value) {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_scan),
                            contentDescription = "Scan",
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
                AnimatedVisibility(visible = isShowEdit.value) {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_edit),
                            contentDescription = "Edit",
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
            })
    }
}

@Composable
fun BottomBar(
    navController: NavHostController,
    state: MutableState<Boolean>,
    modifier: Modifier = Modifier,
    isVisible: MutableState<Boolean>,
) {

    AnimatedVisibility(visible = isVisible.value) {
        val screens = listOf(
            Destinations.HomeScreen, Destinations.ExploreScreen, Destinations.LibraryScreen, Destinations.ProfileScreen
        )

        NavigationBar(
            modifier = modifier,
            containerColor = MaterialTheme.colorScheme.background,
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            screens.forEach { screen ->

                NavigationBarItem(
                    modifier = Modifier
                        .padding(4.dp)
                        .background(MaterialTheme.colorScheme.background, RoundedCornerShape(24.dp))
                        .clip(RoundedCornerShape(24.dp)),
                    icon = {
                        Icon(
                            painter = painterResource(id = screen.icon!!),
                            contentDescription = "",
                            modifier = Modifier.size(24.dp),
                        )
                    },
                    label = {
                        Text(
                            text = screen.title!!,
                            style = TextStyle(
                                fontSize = 10.sp,
                                fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                                fontWeight = FontWeight(500),
                                textAlign = TextAlign.Center,
                                letterSpacing = 0.2.sp,
                            )
                        )
                    },
                    onClick = {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        unselectedTextColor = Greyscale500,
                        selectedTextColor = Primary500,
                        selectedIconColor = Primary500,
                        unselectedIconColor = Greyscale500,
                        indicatorColor = MaterialTheme.colorScheme.background
                    ),
                    selected = currentRoute == screen.route,
                )
            }
        }
    }


}
