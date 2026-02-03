package `in`.ggpa.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import `in`.ggpa.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Art()
                }
            }
        }
    }
}



@Composable
fun Art(){
    var currentStep by remember { mutableStateOf(1) }
    var artImage  = painterResource(R.drawable.art1)
    var heading = "Astrophile"
    var description = "Michelangelo"
    when (currentStep) {
        1 -> {
            heading = "Astrophile"
            description = "Michelangelo"
           artImage =  painterResource(R.drawable.art1)

        }
        2 ->{
            heading = "Exquisite"
            description = "Nadar"
            artImage =  painterResource(R.drawable.art2)
        }
        3 ->{
            heading = "Nephophilia"
            description = "Georges Seuret"
            artImage =  painterResource(R.drawable.art3)
        }
    }

    Column {
        Image(painter = artImage,
            contentDescription = null,
        contentScale= ContentScale.Crop,
        modifier = Modifier.fillMaxWidth()
            .height(500.dp)
            .padding(top = 20.dp))
        Text(
            text = heading,
            modifier = Modifier.padding(top = 50.dp,start=200.dp),

            fontSize = 30.sp
        )
        Text(text = description, fontSize = 20.sp,modifier=Modifier.padding(start=200.dp,bottom=50.dp))

        Row {
            if(currentStep!=1) {
                Button(
                    onClick = { currentStep-- },
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text("Previous")
                }
            }

            if(currentStep==1) {
                Button(
                    onClick = { currentStep-- },
                    modifier = Modifier.padding(20.dp),
                    enabled = false
                ) {
                    Text("Previous")
                }
            }
            if(currentStep==3) {
                Button(
                    onClick = { currentStep++ },
                    modifier = Modifier.padding(20.dp),
                    enabled = false
                ) {
                    Text("Next")
                }
            }
            if(currentStep!=3) {
                Button(
                    onClick = { currentStep++ },
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text("Next")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        Art()
    }
}