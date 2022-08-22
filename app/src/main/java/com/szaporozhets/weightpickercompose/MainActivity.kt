package com.szaporozhets.weightpickercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var weight by remember {
                mutableStateOf(80)
            }
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Select your weight",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Light
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = weight.toString(),
                        fontSize = 56.sp,
                        modifier = Modifier.alignBy(LastBaseline)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "KG",
                        fontSize = 26.sp,
                        modifier = Modifier.alignBy(LastBaseline),
                        fontWeight = FontWeight.Light,
                        color = Color.Green
                    )
                }
                Scale(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    style = ScaleStyle(
                        scaleWidth = 150.dp
                    )
                ) {
                    weight = it
                }
            }
        }
    }
}
