package com.alirezanasrollahzadeh.ancrashlytics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alirezanasrollahzadeh.ancrashlytics.ui.theme.AnCrashLyticsTheme

//Developed By Alireza Nasrollahzadeh

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnCrashLyticsTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CrashLytics()
                }
            }
        }
    }
}

@Composable
fun CrashLytics() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(onClick = { throw RuntimeException("Crash"); }) {
            Text("Crash")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AnCrashLyticsTheme {
        CrashLytics()
    }
}