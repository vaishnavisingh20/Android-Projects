package `in`.ggpa.businesscard

import androidx.compose.ui.graphics.Color
import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import `in`.ggpa.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BuinessCard()
                }
            }
        }
    }
}

@Composable
fun BuinessCard( modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Image(
            painter = image,
            contentDescription = null,
            
            modifier = Modifier.padding(top = 200.dp)
                .height(110.dp)
                .width(110.dp)
        )
        Text(text = "Jennifer Doe", fontSize = 40.sp,modifier= Modifier.padding(bottom= 5.dp))
        Text(text = "Android Developer Extraordinaire", color = Color.Green, fontSize = 15.sp)
        Row(modifier = Modifier.padding(top=200.dp)){
            Row (){
                PhoneIcon()
            }
            Row{
            Text(text = "++11(123)444 555 666", fontSize = 15.sp,modifier= Modifier.padding(bottom= 5.dp))}
        }
        Row{
            Row {
                ShareIcon()
            }
            Row{
            Text(text = "@AndroidDev", fontSize = 15.sp, modifier= Modifier.padding(bottom = 5.dp))}
        }
        Row {
            Row {
                EmailIcon()
            }
            Row {
                Text(
                    text = "jen.doe@android.com",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(bottom = 5.dp)
                )
            }
        }
    }
}
@Composable
fun PhoneIcon(modifier: Modifier = Modifier) {
    Icon(imageVector = Icons.Default.Phone,
        contentDescription = "Person Icon",
        tint=Color.Green,modifier = Modifier.size(25.dp)
            .padding(end= 5.dp))

}
@Composable
fun ShareIcon(modifier: Modifier = Modifier) {
    Icon(imageVector = Icons.Default.Share,
        contentDescription = "Person Icon",
        tint=Color.Green,modifier = Modifier.size(25.dp)
            .padding(end= 5.dp))
}
@Composable
fun EmailIcon(modifier: Modifier = Modifier) {
    Icon(imageVector = Icons.Default.Email,
        contentDescription = null,
        tint=Color.Green,modifier = Modifier.size(25.dp)
            .padding(end= 5.dp))
}

@Preview(showBackground = false)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BuinessCard()
    }
}