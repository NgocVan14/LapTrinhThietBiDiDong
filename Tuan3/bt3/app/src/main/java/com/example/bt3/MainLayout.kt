package com.example.bt3

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun MainLayout(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        // Tiêu đề chính
        Text(
            text = "UI Components List",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp)
        )

        // Danh sách các mục
        Text(
            text = "Display:",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        UIComponentItem(title = "Text", description = "Displays text") {
            navController.navigate("text")
        }
        UIComponentItem(title = "Image", description = "Displays an image") {
            navController.navigate("image")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Input:",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        UIComponentItem(title = "TextField", description = "Input field for text") {
            navController.navigate("textField")
        }
        UIComponentItem(title = "PasswordField", description = "Input field for passwords") {
            navController.navigate("passwordField")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Layout:",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        UIComponentItem(title = "Column", description = "Arranges elements vertically") {
            navController.navigate("column")
        }
        UIComponentItem(title = "Row", description = "Arranges elements horizontally") {
            navController.navigate("row")
        }
    }
}

@Composable
fun UIComponentItem(title: String, description: String, onClick: () -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(8.dp),
        color = Color(0xFFBBDEFB)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = description,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}