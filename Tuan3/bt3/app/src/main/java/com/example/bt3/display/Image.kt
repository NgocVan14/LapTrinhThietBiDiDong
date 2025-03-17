package com.example.bt3.display

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import com.example.bt3.R

@Composable
fun ImageScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Image Component",
            fontSize = 24.sp
        )

        Image(
            painter = painterResource(id = R.drawable.ic_profile),
            contentDescription = "Sample Image",
            modifier = Modifier
                .padding(top = 8.dp)
                .size(width = 200.dp, height = 200.dp)
        )
    }
}