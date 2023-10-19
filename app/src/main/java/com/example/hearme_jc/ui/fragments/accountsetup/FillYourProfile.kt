package com.example.hearme_jc.ui.fragments.accountsetup

import android.net.Uri
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.hearme_jc.R
import com.example.hearme_jc.data.model.Name
import com.example.hearme_jc.data.viewmodel.UserViewModel
import com.example.hearme_jc.navigation.Screen
import com.example.hearme_jc.ui.theme.Primary500
import com.example.hearme_jc.ui.theme.White
import com.example.mylibrary.AppTextField
import com.example.mylibrary.AppTextFieldDate
import com.example.mylibrary.AppTextFieldHaveTrailingIcon
import com.example.mylibrary.PairButton
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FillYourProfileScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    userViewModel: UserViewModel,
    email: String,
) {
    val fullName = rememberSaveable {
        mutableStateOf("")
    }

    val nickName = rememberSaveable {
        mutableStateOf("")
    }

    val dob = rememberSaveable {
        mutableStateOf(LocalDate.parse("1500-01-01"))
    }

    val secEmail = rememberSaveable {
        mutableStateOf("")
    }

    val phone = rememberSaveable {
        mutableStateOf("")
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 24.dp, end = 24.dp, start = 24.dp)
            .background(MaterialTheme.colorScheme.background),
    ) {
        ContainerFillData(modifier = Modifier.weight(1f), fullName, nickName, dob, secEmail, phone)

        PairButton(
            text1 = "Skip",
            text2 = "Continue",
            textColor1 = MaterialTheme.colorScheme.onTertiary,
            textColor2 = White,
            bgColor1 = MaterialTheme.colorScheme.onSecondaryContainer,
            bgColor2 = Primary500,
            font = FontFamily(Font(R.font.urbanist_bold)),
            onButtonClick1 = { navController.navigate(Screen.CreateNewPin.route) },
            onButtonClick2 = {
                val rs = userViewModel.FillProfile(
                    email,
                    Name(fullName.value, nickName.value),
                    dob.value,
                    secEmail.value,
                    phone.value
                ).toInt()
                if (rs == 0) {

                } else if (rs == 1) {
                    navController.navigate(Screen.CreateNewPin.route)
                } else {

                }
            },
        )

        Spacer(modifier = Modifier.height(48.dp))
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ContainerFillData(
    modifier: Modifier = Modifier,
    fullName: MutableState<String>,
    nickName: MutableState<String>,
    dob: MutableState<LocalDate>,
    secEmail: MutableState<String>,
    phone: MutableState<String>,
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(24.dp)) {
        ContainerChooseAvatar()

        AppTextField(
            placeholderText = "Full Name",
            placeholderFont = FontFamily(Font(R.font.urbanist_regular)),
            inputFont = FontFamily(Font(R.font.urbanist_semibold)),
            mainColor = MaterialTheme.colorScheme.onBackground,
            bgColor = MaterialTheme.colorScheme.primary,
            text = fullName,
        )

        AppTextField(
            placeholderText = "Nick Name",
            placeholderFont = FontFamily(Font(R.font.urbanist_regular)),
            inputFont = FontFamily(Font(R.font.urbanist_semibold)),
            mainColor = MaterialTheme.colorScheme.onBackground,
            bgColor = MaterialTheme.colorScheme.primary,
            text = nickName
        )

        AppTextFieldDate(
            placeholderText = "Date of Birth",
            placeholderFont = FontFamily(Font(R.font.urbanist_regular)),
            inputFont = FontFamily(Font(R.font.urbanist_semibold)),
            mainColor = MaterialTheme.colorScheme.onBackground,
            bgColor = MaterialTheme.colorScheme.primary,
            dob = dob,
            trailingIcon = R.drawable.ic_date,
        )

        AppTextFieldHaveTrailingIcon(
            placeholderText = "Email",
            placeholderFont = FontFamily(Font(R.font.urbanist_regular)),
            inputFont = FontFamily(Font(R.font.urbanist_semibold)),
            mainColor = MaterialTheme.colorScheme.onBackground,
            bgColor = MaterialTheme.colorScheme.primary,
            text = secEmail,
            trailingIcon = R.drawable.ic_mail
        )

        AppTextField(
            placeholderText = "Phone Number",
            placeholderFont = FontFamily(Font(R.font.urbanist_regular)),
            inputFont = FontFamily(Font(R.font.urbanist_semibold)),
            mainColor = MaterialTheme.colorScheme.onBackground,
            bgColor = MaterialTheme.colorScheme.primary,
            text = phone
        )
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

//@Preview(showBackground = true, widthDp = 412, heightDp = 915)
//@Composable
//fun FillYourProfileScreenPreview() {
//    Hearme_JCTheme {
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            val navController = rememberNavController()
//
//            FillYourProfileScreen(navController = navController)
//        }
//    }
//}