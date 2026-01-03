package ru.klokov.simpledice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.klokov.simpledice.ui.theme.MyFont
import ru.klokov.simpledice.ui.theme.SimpleDiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleDiceTheme {
                DiceRollerApp()
            }
        }
    }

    @Preview (showBackground = true)
    @Composable
    fun DiceRollerApp() {
        DiceWithButtonAndImage()
    }

    @Composable
    fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
        val haptic = LocalHapticFeedback.current
        var result by remember { mutableIntStateOf(20) }
        val imageResource = when (result) {
            1 -> R.drawable.d20_face_blue_1
            2 -> R.drawable.d20_face_blue_2
            3 -> R.drawable.d20_face_blue_3
            4 -> R.drawable.d20_face_blue_4
            5 -> R.drawable.d20_face_blue_5
            6 -> R.drawable.d20_face_blue_6
            7 -> R.drawable.d20_face_blue_7
            8 -> R.drawable.d20_face_blue_8
            9 -> R.drawable.d20_face_blue_9
            10 -> R.drawable.d20_face_blue_10
            11 -> R.drawable.d20_face_blue_11
            12 -> R.drawable.d20_face_blue_12
            13 -> R.drawable.d20_face_blue_13
            14 -> R.drawable.d20_face_blue_14
            15 -> R.drawable.d20_face_blue_15
            16 -> R.drawable.d20_face_blue_16
            17 -> R.drawable.d20_face_blue_17
            18 -> R.drawable.d20_face_blue_18
            19 -> R.drawable.d20_face_blue_19
            else -> R.drawable.d20_face_blue_20

        }
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = result.toString(),
                Modifier.size(250.dp)
            )
            Spacer(modifier = Modifier.height(80.dp))
            Button(onClick = {
                result = (1..20).random()
                haptic.performHapticFeedback(HapticFeedbackType.LongPress)}, colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            )) {
                Text(
                    stringResource(R.string.roll),
                    fontSize = 34.sp,
                    fontFamily = MyFont
                )
                Spacer(Modifier.size(12.dp))
                Icon(
                    painter = painterResource(R.drawable.button_icon),
                    contentDescription = null,
                    Modifier.size(32.dp))
            }
        }
    }
}

