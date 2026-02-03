package `in`.ggpa.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import `in`.ggpa.project.R
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.input.InputMode.Companion.Keyboard
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import `in`.ggpa.project.ui.theme.ProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Design()
                }
            }
        }
    }
}
@Composable
fun Design(){ 
    val image = painterResource(R.drawable.resource_class)
    Box {
        //Modifier.background(Color.Black)
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(1f)
        )
        Project()
    }
}
@Composable
fun Project() {
    var limitStr by remember { mutableStateOf("") }
    var randomNumberStr by remember { mutableStateOf("")}

    val maxLimit = limitStr.toIntOrNull()?: 0
    // randomNumberStr = (0..maxLimit).random().toString()


    Column(
        modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,


    ) {

Row {
    TextField(

        value = limitStr,
        onValueChange = { limitStr = it },
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Gray),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier.padding(20.dp)
    )
    Button(
        onClick = { randomNumberStr = (1..maxLimit).random().toString() },
        modifier = Modifier.padding(20.dp)
    ) {
        Text("Roll")
    }
}
        Spacer(Modifier.height(24.dp))
        Text(
            text = randomNumberStr,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 200.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProjectTheme {
        Design()
    }
}