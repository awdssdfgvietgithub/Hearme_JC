package com.example.hearme_jc.ui.fragments.homeactionmenu.screen.childscreen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.hearme_jc.R
import com.example.hearme_jc.data.model.User
import com.example.hearme_jc.data.viewmodel.EmailViewModel
import com.example.hearme_jc.data.viewmodel.UserViewModel
import com.example.hearme_jc.ui.theme.Primary500
import com.example.hearme_jc.ui.theme.White
import com.example.mylibrary.AppToggleButton

@Composable
fun ProfilesSearchResultsScreen(
    navController: NavController, query: String,
    userViewModel: UserViewModel,
    emailViewModel: EmailViewModel,
) {
    val usersData = userViewModel.GetAllUsers()

    LazyColumn(
        contentPadding = PaddingValues(end = 24.dp, start = 24.dp, bottom = 48.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items(usersData) {
            UserItemView(user = it, userViewModel = userViewModel, emailViewModel = emailViewModel)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun UserItemView(modifier: Modifier = Modifier, user: User, userViewModel: UserViewModel, emailViewModel: EmailViewModel) {
    val isCheck = rememberSaveable {
        mutableStateOf(userViewModel.IsFollowUser(emailViewModel.GetEmail(), user.email))
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.background),
        verticalAlignment = Alignment.CenterVertically
    ) {
        GlideImage(
            model = user.avatarUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(shape = CircleShape),
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text(
                text = user.name?.fullName.toString(),
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 21.6.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                    fontWeight = FontWeight(700),
                    color = MaterialTheme.colorScheme.onBackground,
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = "${user.listFollowers.size} Followers",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                    fontWeight = FontWeight(500),
                    color = MaterialTheme.colorScheme.onSecondary,
                    letterSpacing = 0.2.sp,
                ),
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        AppToggleButton(
            bgColorFalse = Primary500,
            txtColorFalse = White,
            bgColorTrue = White,
            txtColorTrue = Primary500,
            borderColorFalse = White,
            borderColorTrue = Primary500,
            fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
            isChecked = isCheck.value,
            textTrue = "Following",
            textFalse = "Follow",
            onClick = {
                isCheck.value = !isCheck.value
                when (userViewModel.UpdateUserFollowing(emailViewModel.GetEmail(), user.email, isCheck.value).toInt()) {
                    0 -> {
                        Log.v("UpdateUserFollowing", "Email rong")
                    }

                    2 -> {
                        Log.v("UpdateUserFollowing", "User id khong ton tai")
                    }

                    1 -> {
                        Log.v("UpdateUserFollowing", "Thanh cong")
                    }

                    else -> {
                        Log.v("UpdateUserFollowing", "Email khong ton tai")
                    }
                }

                isCheck.value =
                    userViewModel.IsFollowUser(emailViewModel.GetEmail(), user.email)

            }
        )
    }
}