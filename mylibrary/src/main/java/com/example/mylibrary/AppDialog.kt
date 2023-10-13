package com.example.mylibrary

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogWindowProvider
import androidx.constraintlayout.compose.ConstraintLayout
import kotlinx.coroutines.delay

@Composable
fun Painter(modifier: Modifier = Modifier, circleColor: Color, mainBackground: Int, mainIcon: Int) {
    ConstraintLayout(modifier.fillMaxWidth()) {
        val (main, secon, circle1, circle2, circle3, circle4, circle5, circle6, circle7, circle8, circle9) = createRefs()

        Image(
            painter = painterResource(id = mainBackground), contentDescription = null,
            modifier = Modifier
                .size(141.dp)
                .constrainAs(main) {
                    top.linkTo(circle1.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                },
        )

        Image(
            painter = painterResource(id = mainIcon),
            contentDescription = null,
            modifier = Modifier.constrainAs(secon) {
                top.linkTo(main.top)
                bottom.linkTo(main.bottom)
                end.linkTo(main.end)
                start.linkTo(main.start)
            }
        )

        Image(
            painter = rememberVectorPainter(image = Icons.Default.Circle),
            contentDescription = null,
            colorFilter = ColorFilter.tint(circleColor),
            modifier = Modifier
                .constrainAs(circle1) {
                    top.linkTo(parent.top)
                    start.linkTo(
                        main.start
                    )
                }
                .size(20.dp)
        )

        Image(
            painter = rememberVectorPainter(image = Icons.Default.Circle),
            contentDescription = null,
            colorFilter = ColorFilter.tint(circleColor),
            modifier = Modifier
                .constrainAs(circle2) {
                    start.linkTo(circle1.end, margin = 70.dp)
                }
                .size(5.dp)
        )

        Image(
            painter = rememberVectorPainter(image = Icons.Default.Circle),
            contentDescription = null,
            colorFilter = ColorFilter.tint(circleColor),
            modifier = Modifier
                .constrainAs(circle3) {
                    top.linkTo(main.top)
                    start.linkTo(main.end)
                }
                .size(15.dp)
        )

        Image(
            painter = rememberVectorPainter(image = Icons.Default.Circle),
            contentDescription = null,
            colorFilter = ColorFilter.tint(circleColor),
            modifier = Modifier
                .constrainAs(circle4) {
                    top.linkTo(circle3.top, margin = 73.dp)
                    end.linkTo(main.end)
                }
                .size(5.dp)
        )

        Image(
            painter = rememberVectorPainter(image = Icons.Default.Circle),
            contentDescription = null,
            colorFilter = ColorFilter.tint(circleColor),
            modifier = Modifier
                .constrainAs(circle5) {
                    top.linkTo(circle4.top, margin = 45.dp)
                    end.linkTo(circle4.end, margin = 5.dp)
                }
                .size(5.dp)
        )

        Image(
            painter = rememberVectorPainter(image = Icons.Default.Circle),
            contentDescription = null,
            colorFilter = ColorFilter.tint(circleColor),
            modifier = Modifier
                .constrainAs(circle6) {
                    top.linkTo(circle5.bottom, margin = 10.dp)
                    end.linkTo(circle5.start, margin = 40.dp)
                }
                .size(2.dp)
        )

        Image(
            painter = rememberVectorPainter(image = Icons.Default.Circle),
            contentDescription = null,
            colorFilter = ColorFilter.tint(circleColor),
            modifier = Modifier
                .constrainAs(circle7) {
                    top.linkTo(circle6.bottom, margin = 1.dp)
                    end.linkTo(circle6.start, margin = 50.dp)
                }
                .size(7.dp)
        )

        Image(
            painter = rememberVectorPainter(image = Icons.Default.Circle),
            contentDescription = null,
            colorFilter = ColorFilter.tint(circleColor),
            modifier = Modifier
                .constrainAs(circle8) {
                    end.linkTo(main.start)
                    top.linkTo(circle1.bottom, margin = 100.dp)
                }
                .size(7.dp)
        )

        Image(
            painter = rememberVectorPainter(image = Icons.Default.Circle),
            contentDescription = null,
            colorFilter = ColorFilter.tint(circleColor),
            modifier = Modifier
                .constrainAs(circle9) {
                    end.linkTo(circle1.start)
                    top.linkTo(circle1.bottom, margin = 50.dp)
                }
                .size(2.dp)
        )
    }
}

@Composable
fun AppDialogNavigation(
    modifier: Modifier = Modifier,
    setShowDialog: (Boolean) -> Unit,
    painterCircleColor: Color,
    painterMainBackground: Int,
    painterMainIcon: Int,
    background: Color,
    fontFamily: FontFamily,
    title: String,
    body: String,
    titleColor: Color,
    bodyColor: Color,
    onNavigation: () -> Unit,
) {
    Dialog(onDismissRequest = { setShowDialog(false) }) {
        androidx.compose.material3.Card(
            modifier = modifier
                .width(340.dp),
            shape = RoundedCornerShape(40.dp),
            colors = CardDefaults.cardColors(background),
        ) {
            (LocalView.current.parent as DialogWindowProvider).window.setDimAmount(0f)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp, end = 32.dp, start = 32.dp, bottom = 32.dp)
            ) {
                Painter(circleColor = painterCircleColor, mainBackground = painterMainBackground, mainIcon = painterMainIcon)

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = title,
                    style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 28.8.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight(700),
                        color = titleColor,
                        textAlign = TextAlign.Center,
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = body,
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 22.4.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight(400),
                        color = bodyColor,
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.2.sp,
                    )
                )

                val scale = remember {
                    Animatable(0f)
                }
                LaunchedEffect(key1 = true) {
                    scale.animateTo(
                        targetValue = 0.3f,
                        animationSpec = tween(
                            durationMillis = 500,
                            easing = {
                                OvershootInterpolator(2f).getInterpolation(it)
                            }
                        )
                    )
                    delay(2000L)
                    onNavigation()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppProgressDialogPreview() {

}