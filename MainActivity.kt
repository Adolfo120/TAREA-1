package com.example.appperfil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.ui.tooling.preview.Preview
import com.example.appperfil.ui.theme.AppPerfilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppPerfilTheme {
                CreateProfileScreen()
            }
        }
    }
}

@Composable
fun CreateProfileScreen() {

    var selectedGender by remember { mutableStateOf("Boy") }
    var age by remember { mutableStateOf(5) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Create Profile",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            GenderButton(
                text = "Boy",
                selected = selectedGender == "Boy",
                color = Color(0xFF4CAF50)
            ) { selectedGender = "Boy" }

            GenderButton(
                text = "Girl",
                selected = selectedGender == "Girl",
                color = Color(0xFFE91E63)
            ) { selectedGender = "Girl" }
        }

        Spacer(modifier = Modifier.height(40.dp))

        Image(
            painter = painterResource(id = R.drawable.lion),
            contentDescription = "Lion",
            modifier = Modifier.size(300.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text("Your Age", fontSize = 18.sp)

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = age.toString(),
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Button(onClick = {
                if (age > 1) age--
            }) {
                Text("-")
            }

            Button(onClick = {
                if (age < 12) age++
            }) {
                Text("+")
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text("Save", fontSize = 18.sp)
        }
    }
}

@Composable
fun GenderButton(
    text: String,
    selected: Boolean,
    color: Color,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .height(50.dp)
            .width(120.dp)
            .background(
                if (selected) color else Color.LightGray,
                shape = RoundedCornerShape(25.dp)
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CreateProfileScreenPreview() {
    AppPerfilTheme {
        CreateProfileScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun GenderButtonPreview() {
    AppPerfilTheme {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            GenderButton(
                text = "Boy",
                selected = true,
                color = Color(0xFF4CAF50),
                onClick = {}
            )
            GenderButton(
                text = "Girl",
                selected = false,
                color = Color(0xFFE91E63),
                onClick = {}
            )
        }
    }
}