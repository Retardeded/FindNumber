package com.example.findnumber.presentation.main_screen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.findnumber.Screen

@Composable
fun MainScreen(navController: NavController) {

    var text by rememberSaveable { mutableStateOf("1,2,3,5,7,9") }
    val context = LocalContext.current
    
    Column(verticalArrangement = Arrangement.Center,
    modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 50.dp)) {
        TextField(value = text, onValueChange = {
            text = it
        },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            var pattern = "(-?[0-9]+,)+-?[0-9]+$".toRegex()
            if(text.matches(pattern)) {
                navController.navigate(Screen.DetailScreen.withArgs(text))
            }
            else {
                //
                Toast.makeText(
                    context,
                    "Wrong input....",
                    Toast.LENGTH_SHORT
                ).show()
            }
        },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Find Number")
        }
    }
}