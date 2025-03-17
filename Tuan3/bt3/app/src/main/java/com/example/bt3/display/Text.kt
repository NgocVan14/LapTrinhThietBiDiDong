package com.example.bt3.display

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun TextScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .wrapContentWidth(align = Alignment.Start)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Text Detail",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
                modifier = Modifier
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.weight(1f))
        }

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(2.dp, Color.Blue)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "The quick ",
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Text(
                    text = "Brown",
                    fontSize = 16.sp,
                    color = Color(0xFFA52A2A),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "fox jumps over the lazy dog.",
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }
        }
    }
}