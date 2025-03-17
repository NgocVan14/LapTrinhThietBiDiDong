package com.example.bt3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bt3.display.ImageScreen
import com.example.bt3.display.TextScreen
import com.example.bt3.input.PasswordFieldScreen
import com.example.bt3.input.TextFieldScreen
import com.example.bt3.layout.ColumnScreen
import com.example.bt3.layout.RowScreen
import com.example.bt3.ui.theme.Bt3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Bt3Theme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "main",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("main") { MainLayout(navController) }
                        composable("text") { TextScreen(navController) }
                        composable("image") { ImageScreen() }
                        composable("textField") { TextFieldScreen() }
                        composable("passwordField") { PasswordFieldScreen() }
                        composable("column") { ColumnScreen() }
                        composable("row") { RowScreen() }
                    }
                }
            }
        }
    }
}