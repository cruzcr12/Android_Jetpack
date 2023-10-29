package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

val softColor: Color = Color(0xFFAAC5B2)
val boldColor: Color = Color(0xFF094718)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(color = softColor)
    ) {
        Spacer(Modifier.weight(1f))
        PersonalInfoCard(photo = R.drawable.charles_photo,
            name = "Charles Francis Xavier", title = "Researcher, Teacher")

        Spacer(Modifier.weight(1f))

        ContactInfoCard(phone = "+555 1234-5647",
            socialMedia = "@professorx.facebook", email = "professor.x@gmail.com")

    }
}

@Composable
fun PersonalInfoCard(photo: Int, name: String, title: String, modifier: Modifier = Modifier){
    var profilePic = painterResource(id = photo)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(painter = profilePic, contentDescription = null)
        Text(text = name,
            fontSize = 28.sp)
        Text(text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = boldColor)
    }
}

@Composable
fun ContactInfoCard(phone: String, socialMedia: String,
                    email: String, modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .padding(bottom = 40.dp)
    ) {
        Row(){
            Icon(Icons.Rounded.Call, contentDescription = "Phone number", Modifier
                .padding(end = 16.dp), tint = boldColor)
            Text(phone)
        }
        Row(){
            Icon(Icons.Rounded.Share, contentDescription = "Social Media Handler", Modifier
                .padding(end = 16.dp), tint = boldColor)
            Text(socialMedia)
        }
        Row(){
            Icon(Icons.Rounded.Email, contentDescription = "Email", Modifier
                .padding(end = 16.dp), tint = boldColor)
            Text(email)
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}