package com.example.hearme_jc.ui.fragments.accountsetup

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.hearme_jc.R
import com.example.hearme_jc.ui.Screen
import com.example.hearme_jc.ui.activities.MainTextField
import com.example.hearme_jc.ui.activities.PairButton
import com.example.hearme_jc.ui.theme.Hearme_JCTheme
import com.example.hearme_jc.ui.theme.Primary100
import com.example.hearme_jc.ui.theme.Primary500
import com.example.hearme_jc.ui.theme.White

@Composable
fun FillYourProfileScreen(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 24.dp, end = 24.dp, start = 24.dp)
            .background(MaterialTheme.colorScheme.background),
    ) {
        ContainerFillData(modifier = Modifier.weight(1f), navController = navController)

        PairButton(
            text1 = "Skip",
            text2 = "Continue",
            route1 = Screen.CreateNewPin.route,
            route2 = Screen.CreateNewPin.route,
            textColor1 = MaterialTheme.colorScheme.onTertiary,
            textColor2 = White,
            bgColor1 = MaterialTheme.colorScheme.onSecondaryContainer,
            bgColor2 = Primary500,
            navController = navController,
        )

        Spacer(modifier = Modifier.height(48.dp))
    }
}

@Composable
fun ContainerFillData(modifier: Modifier = Modifier, navController: NavController) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(24.dp)) {
        ContainerChooseAvatar()

        MainTextField(placeholderText = "Full Name")

        MainTextField(placeholderText = "Nick Name")

        MainTextField(placeholderText = "Date of Birth")

        MainTextField(placeholderText = "Email")

        MainTextField(placeholderText = "Phone Number")
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable

fun ContainerChooseAvatar(modifier: Modifier = Modifier) {
    var uri by rememberSaveable {
        mutableStateOf<Uri?>(null)
    }

    val singlePhotoPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {
            uri = it
        }
    )

    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        ConstraintLayout {
            val (avt, btnImage) = createRefs()

            GlideImage(
                model = uri,
                contentDescription = null,
                modifier = Modifier
                    .size(140.dp)
                    .constrainAs(avt) {
                        top.linkTo(parent.top)
                    }
                    .clip(CircleShape),
                failure = placeholder(painterResource(id = R.drawable.image_none_avt)),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(id = R.drawable.ic_picker_avatar),
                contentDescription = null,
                modifier = Modifier
                    .size(29.16.dp)
                    .constrainAs(btnImage) {
                        bottom.linkTo(avt.bottom)
                        end.linkTo(avt.end)
                    }
                    .clickable {
                        singlePhotoPicker.launch(
                            PickVisualMediaRequest(
                                ActivityResultContracts.PickVisualMedia.ImageOnly
                            )
                        )
                    }
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 412, heightDp = 915)
@Composable
fun FillYourProfileScreenPreview() {
    Hearme_JCTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()

            FillYourProfileScreen(navController = navController)
        }
    }
}