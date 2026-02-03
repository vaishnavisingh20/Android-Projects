package `in`.ggpa.composeactivity2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.ModifierLocalReadScope
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import `in`.ggpa.composeactivity2.ui.theme.ComposeActivity2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeActivity2Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    composeActivity2(message = "All tasks completed", from = "Nice work!")
                }
            }
        }
    }
}
@Composable
fun composeActivity2(message: String, from: String, modifier: Modifier = Modifier){
    val image= painterResource(R.drawable.c)
    Column( modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(painter=image,contentDescription=null)
        Text(
            text=message,
            fontWeight= FontWeight.Bold,
            modifier = Modifier
                .padding(top=24.dp, bottom = 8.dp)
        )
        Text(
            text=from,
            fontSize= 16.sp,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ComposeActivity2Preview() {
    ComposeActivity2Theme {
        composeActivity2(message = "All tasks completed", from = "Nice work!")
    }
}