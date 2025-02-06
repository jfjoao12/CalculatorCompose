package com.example.calculatorcompose

import CalculatorScreen
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculatorcompose.ui.theme.CalculatorComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorComposeTheme {
                Scaffold(modifier = Modifier
                    .fillMaxSize()) { innerPadding ->
                    Box() {
                        ShowCalculatorScreen(
                            onButtonClick = {buttonValue ->
//                                Toast.makeText(this, "MINHA PICA MANE", Toast.LENGTH_SHORT).show()
                                println("Button clicked: $buttonValue")},
                            modifier = Modifier.padding(innerPadding)
                        )

                    }

                }
            }
        }
    }
}

@Composable
fun ShowCalculatorScreen(
    onButtonClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CalculatorScreen(onButtonClick)
    }
}

//@Composable
//fun ShowTextScreen(modifier: Modifier = Modifier) {
//
//    Box(modifier = Modifier
//        .height(20.dp))
//    {
//        Text (
//            textAlign = TextAlign.Center,
//            text = "test"
//        )
//    }
//}


