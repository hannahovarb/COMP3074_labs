package ca.gbg.comp3074.bravo_hannah.labex2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.gbg.comp3074.bravo_hannah.labex2.ui.theme.LabEx2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabEx2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CounterApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CounterApp(modifier: Modifier = Modifier) {

    var count by remember { mutableIntStateOf(0) }
    var stepSize by remember { mutableIntStateOf(1) }
    val greenColor = Color(0xFF4CAF50)
    val redColor = Color(0xFFE91E63)
    val bgColor = Color.White

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(bgColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Application Logo",
            modifier = Modifier
                .width(200.dp)
                .height(100.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "$count",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(48.dp))


        Row(
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {

            Button(
                onClick = { count -= stepSize },
                colors = ButtonDefaults.buttonColors(containerColor = greenColor),
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier.width(100.dp)
            ) {
                Text(text = "-", fontSize = 24.sp, color = Color.White)
            }

            Button(
                onClick = { count += stepSize },
                colors = ButtonDefaults.buttonColors(containerColor = greenColor),
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier.width(100.dp)
            ) {
                Text(text = "+", fontSize = 24.sp, color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))


        Row(
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {

            Button(
                onClick = {
                    count = 0
                    stepSize = 1
                },
                colors = ButtonDefaults.buttonColors(containerColor = redColor),
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier.width(100.dp)
            ) {
                Text(text = "Reset", color = Color.White)
            }


            Button(
                onClick = {

                    stepSize = if (stepSize == 1) 2 else 1
                },
                colors = ButtonDefaults.buttonColors(containerColor = greenColor),
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier.width(100.dp)
            ) {
                Text(text = "Step", color = Color.White)
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterAppPreview() {
    LabEx2Theme {
        CounterApp()
    }
}
