package com.example.composequadrant

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FinalScreen()
                }
            }
        }
    }
}

@Composable
fun InfoCard(color: Color, title: String, content: String, modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .background(color = color)
            .padding(16.dp)
            .fillMaxHeight(1f)
    )
    {
        Text(text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(text = content,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun FinalScreen(modifier: Modifier = Modifier) {

    Column{

        Row(
            modifier = Modifier
                .weight(1f, fill = true)
        ){
            InfoCard(color = Color(0xFFEADDFF),
                title = stringResource(id = R.string.text_comp_title),
                content = stringResource(id = R.string.text_comp_content),
                modifier = Modifier.weight(weight = 1f, fill = true)
            )

            InfoCard(color = Color(0xFFD0BCFF) ,
                title = stringResource(id = R.string.image_comp_title) ,
                content = stringResource(id = R.string.image_comp_content),
                modifier = Modifier.weight(weight = 1f, fill = true)
            )
        }

        Row(
            modifier = Modifier
                .weight(1f, fill = true)
        ){
            InfoCard(color = Color(0xFFB69DF8),
                title = stringResource(id = R.string.row_comp_title),
                content = stringResource(id = R.string.row_comp_content),
                modifier = Modifier.weight(weight = 1f, fill = true)
            )

            InfoCard(color = Color(0xFFF6EDFF) ,
                title = stringResource(id = R.string.col_comp_title) ,
                content = stringResource(id = R.string.col_comp_content),
                modifier = Modifier.weight(weight = 1f, fill = true)
            )
        }

    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        FinalScreen()
    }
}