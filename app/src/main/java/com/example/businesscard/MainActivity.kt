package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF9EBC9E)),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}
@Composable
fun BusinessCardApp() {
    val colorStops = arrayOf(
        0.0f to Color.Yellow,
        0.2f to Color.Red,
        1f to Color.Blue
    )
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(Brush.horizontalGradient(colorStops = colorStops))
    ) {
        UpperEssentials()
        Spacer(modifier = Modifier.height(200.dp))
        Column{
            LowerEssentials(
                painter = painterResource(R.drawable.call_logo),
                data = stringResource(R.string.ph_no)
            )
            LowerEssentials(
                painter = painterResource(R.drawable.share_logo),
                data = stringResource(R.string.itsdevvidhan)
            )
            LowerEssentials(
                painter = painterResource(R.drawable.mail_logo),
                data = stringResource(R.string.vidhan_dev_android_com)
            )
        }
    }
}

@Composable
fun UpperEssentials() {
    val colorsL = listOf(
        Color.Yellow,Color.Red,Color.Blue
    )
    Row{
        ElevatedCard(
            modifier = Modifier
                .size(width = 300.dp, height = 222.dp)
                .shadow(elevation = 64.dp)

        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.background(Brush.horizontalGradient(colors = colorsL))
            ) {
                Image(
                    painter = painterResource(R.drawable.android_logo),
                    contentDescription = null,
                    contentScale = ContentScale.Inside
                )
                Text(
                    text = stringResource(R.string.a_vidhan_reddy),
                    fontSize = 24.sp
                )
                Text(
                    text = stringResource(R.string.android_developer)
                )
            }
        }
    }
}

@Composable
fun LowerEssentials(painter: Painter,data: String) {
      Row(
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Icon(
                painter = painter,
                contentDescription = data,
                modifier = Modifier
                    .size(28.dp)
                    .padding(end = 10.dp)
            )
            Text(
                text = data,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}