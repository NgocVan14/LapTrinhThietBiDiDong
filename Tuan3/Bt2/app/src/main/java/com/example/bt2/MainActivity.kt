package com.example.bt2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bt2.ui.theme.Bt2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Bt2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyLayout(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun MyLayout(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally, // Căn giữa theo chiều ngang
        verticalArrangement = Arrangement.Center // Căn giữa theo chiều dọc
    ) {
        // Image
        Image(
            painter = painterResource(id = R.drawable.logobt2),
            contentDescription = "App Logo",
            modifier = Modifier
                .size(width = 216.dp, height = 233.dp)
                .offset(y = (-120).dp)
        )

        // Text
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Jetpack Compose",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 25.dp)
            )
            Text(
                text = "Jetpack Compose is a modern UI toolkit for building native Android applications using a declarative programming approach.",
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        // Button
        Button(
            onClick = {
               //xử lý thao tác click(bổ sung sau)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00B7EB),
                contentColor = Color.White
            ),
            modifier = Modifier
                .size(width = 315.dp, height = 52.dp)
                .offset(y = 190.dp)
        ) {
            Text(
                text = "I'm ready",
                fontSize = 20.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyLayoutPreview() {
    Bt2Theme {
        MyLayout()
    }
}
