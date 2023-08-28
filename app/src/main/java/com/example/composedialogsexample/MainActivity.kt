package com.example.composedialogsexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.composedialogsexample.ui.theme.ComposeDialogsExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDialogsExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var show by remember {
                        mutableStateOf(false)
                    }
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Button(onClick = { show = true }) {
                            Text(text = "Mostrar diálogo")
                        }
                    }
                    /*MyAlertDialog(
                        show = show,
                        onDismiss = { show = false },
                        onConfirm = { Log.i("willy", "click") })
                     */
                    /* MyCustomDialog(
                        show = show,
                        onDismiss = { show = false }
                    ) */
                    MyConfirmationDialog(
                        show = show,
                        onDismiss = { show = false }
                    )
                }
            }
        }
    }
}

