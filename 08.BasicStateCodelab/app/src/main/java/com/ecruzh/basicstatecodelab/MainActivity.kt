package com.ecruzh.basicstatecodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ecruzh.basicstatecodelab.ui.theme.BasicStateCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicStateCodelabTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    WellnessScreen()
                }
            }
        }
    }
}

@Composable
fun WaterCount(modifier: Modifier = Modifier){
    Column(modifier = modifier.padding(16.dp)){
        // Changes to count are now tracked by Compose
        var count by rememberSaveable { mutableStateOf(0) }
        if (count > 0) {
            Text(
                text = stringResource(R.string.you_ve_had_glasses, count),
                modifier = modifier.padding(16.dp)
            )
        }
        Row(Modifier.padding(top = 8.dp)){
            Button(onClick = { count++ }, enabled = count < 10){
                Text(stringResource(R.string.add_one))
            }
        }

    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(count, { count++ }, modifier)
}

@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier){
    Column(modifier = modifier.padding(16.dp)) {
        if(count > 0) {
            Text(
                text = stringResource(R.string.you_ve_had_glasses, count)
            )
        }
        Button(onClick = { onIncrement() }, Modifier.padding(top = 8.dp), enabled = count < 10){
            Text(stringResource(R.string.add_one))
        }
    }
}
