package com.example.composedialogsexample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun MyConfirmationDialog(
    show: Boolean,
    onDismiss: () -> Unit,
) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Card {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                ) {
                    MyTittleDialog(text = "Phone ringtone", modifier = Modifier.padding(24.dp))
                    Divider(modifier = Modifier.fillMaxWidth(), color = Color.LightGray)
                    var status by remember { mutableStateOf("") }
                    MyRadioButtonList(status) { status = it }
                    Divider(modifier = Modifier.fillMaxWidth(), color = Color.LightGray)
                    Row(
                        Modifier
                            .align(Alignment.End)
                            .padding(8.dp)) {
                        TextButton(onClick = { onDismiss() }) {
                            Text(text = "Cancel".uppercase())
                        }
                        TextButton(onClick = { onDismiss() }) {
                            Text(text = "Ok".uppercase())
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit) {

    Column(Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(6.dp)) {
            RadioButton(
                selected = name == "Small", onClick = { onItemSelected("Small") }
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(text = "Small")
        }
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(6.dp)) {
            RadioButton(
                selected = name == "Big tone", onClick = { onItemSelected("Big tone") }
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(text = "Big tone")
        }
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(6.dp)) {
            RadioButton(
                selected = name == "Ring", onClick = { onItemSelected("Ring") }
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(text = "Ring")
        }
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(6.dp)) {
            RadioButton(
                selected = name == "Down ton", onClick = { onItemSelected("Down ton") }
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(text = "Down ton")
        }
    }
}