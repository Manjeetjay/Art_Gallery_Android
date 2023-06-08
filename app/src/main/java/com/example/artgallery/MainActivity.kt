package com.example.artgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artgallery.ui.theme.ArtGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtGalleryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   ArtWorkGallery()
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ArtWorkGallery() {
    ArtGalleryTheme {
        var nextCounter by remember { mutableStateOf(0) }

        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(25.dp)
            ) {
                when(nextCounter) {
                    0 -> {
                        ShowUi(R.drawable.image1, "The Desperate Man (Self-Portrait)", "Artist: Gustave Courbet (1845)")
                        Row {
                            ButtonControls(click = { nextCounter = 4 }, name = "Previous")
                            Spacer(modifier = Modifier.padding(20.dp))
                            ButtonControls(click = { nextCounter = 1 }, name = "Next")
                        }
                    }
                    1 -> {
                        ShowUi(R.drawable.image2,  "Portrait Of Lady Agnew Of Lochnaw", "Artist: John Singer Sargent (1892)")
                        Row {
                            ButtonControls(click = { nextCounter = 0 }, name = "Previous")
                            Spacer(modifier = Modifier.padding(20.dp))
                            ButtonControls(click = { nextCounter = 2 }, name = "Next")
                        }
                    }
                    2 -> {
                        ShowUi(R.drawable.image3, "Portrait Of Madame X", "Portrait Of Madame X (1884)")
                        Row {
                            ButtonControls(click = { nextCounter = 1 }, name = "Previous")
                            Spacer(modifier = Modifier.padding(20.dp))
                            ButtonControls(click = { nextCounter = 3 }, name = "Next")
                        }
                    }
                    3 -> {
                        ShowUi(R.drawable.image4, "Portrait Of Madame De Florian", "Artist: Giovanni Boldini (1910)")
                        Row {
                            ButtonControls(click = { nextCounter = 2 }, name = "Previous")
                            Spacer(modifier = Modifier.padding(20.dp))
                            ButtonControls(click = { nextCounter = 4 }, name = "Next")
                        }
                    }
                    4 -> {
                        ShowUi(R.drawable.image5, "Mona Lisa", "Artist: Leonardo Da Vinci (1506)")
                        Row {
                            ButtonControls(click = { nextCounter = 3 }, name = "Previous")
                            Spacer(modifier = Modifier.padding(20.dp))
                            ButtonControls(click = { nextCounter = 0 }, name = "Next")
                        }
                    }
                }
            }
        }

    }
}



@Composable
fun ShowUi(destination: Int, title: String = "Not Found", description: String = "Not Found") {
    ArtWorkWall(destination = destination)
    Spacer(modifier = Modifier.padding(10.dp))
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.background(Color.Gray).padding(5.dp).height(80.dp)
    ) {
        ArtWorkDescriptor(detail = title, size = 22, SemiBold)
        ArtWorkDescriptor(detail = description, size = 16, Bold)
    }
    Spacer(modifier = Modifier.padding(15.dp))
}

@Composable
fun ArtWorkWall(destination: Int, modifier: Modifier = Modifier) {
    Surface(shadowElevation = 16.dp) {
        Image(
            painter = painterResource(destination),
            contentDescription = null,
            modifier = modifier
                .height(450.dp)
                .width(350.dp)
                .padding(5.dp)
        )
    }
}

@Composable
fun ArtWorkDescriptor(detail: String,size: Int, style: FontWeight = Normal, modifier: Modifier = Modifier) {
    Text(
        text = detail,
        fontSize = size.sp,
        fontWeight = style,
        modifier = modifier
            .padding(vertical = 1.dp, horizontal = 5.dp)
            .fillMaxWidth()
    )
}


@Composable
fun ButtonControls(modifier: Modifier = Modifier, click: () -> Unit, name: String ) {
    Button(onClick = { click() }, contentPadding = ButtonDefaults.ContentPadding) {
        Text(
            text = name,
            modifier = modifier
                .width(100.dp)
                .height(30.dp),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}
















