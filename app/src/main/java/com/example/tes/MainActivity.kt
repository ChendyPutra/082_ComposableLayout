package com.example.tes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tes.ui.theme.TesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TampilLayar(pesan = getString(R.string.greeting), dari = getString(R.string.name), kirim = getString(R.string.send))
                }
            }
        }
    }
}
@Composable
fun TampilText(message: String, from: String, send: String, modifier: Modifier = Modifier){
    Column (verticalArrangement = Arrangement.Center, modifier = modifier){
        Text(
            color= Color.White,
            text = message,
            fontSize = 30.sp,
            fontWeight = FontWeight .Bold,
            lineHeight = 40.sp,
            textAlign = TextAlign.Center
        )
        Text(
            color = Color.White,
            text =  from,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 40.sp,
            modifier = Modifier
                .padding(5.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            color = Color.Red,
            text =  send,
            fontSize = 19.sp,
            fontWeight = FontWeight.ExtraBold,
            lineHeight = 40.sp,
            modifier = Modifier
                .padding(5.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun TampilLayar(pesan: String, dari: String, kirim:String){
    val image = painterResource(R.drawable.img_1)
    Box{
        Image(painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxSize())
        TampilText(
            message = pesan,
            from = dari,
            send = kirim,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TesTheme {
        TampilLayar(pesan ="Selamat Datang di Kampus", dari = "Muda Mendunia", kirim = "Universitas Muhammadiyah Yogyakarta")
    }
}