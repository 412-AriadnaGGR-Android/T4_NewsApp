package com.example.arit4_newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Noticia(val titulo: String, val fecha: String, val imagen: Int)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.White
            ) {
                PantallaNoticias()
            }
        }
    }
}

val MiColorMorado = Color(0xFF4A2EFF)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaNoticias() {

    val listaNoticias = listOf(
        Noticia("El presidente de EUA no muestra signos de arrepentimiento", "febrero 08 - 2024", R.drawable.presidente_eua),
        Noticia("Banarse en la piscina del desierto de Cleopatra", "febrero 09 - 2024", R.drawable.cleopatra_egipt),
        Noticia("Gigantes tecnologicos e IA", "febrero 10 - 2024", R.drawable.inteligencia_artificial),
        Noticia("El rover de Marte envia datos", "febrero 11 - 2024", R.drawable.robot_marte)
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        item {

            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(50.dp)),

                placeholder = {
                    Text(
                        "Buscar",
                        color = Color.Gray,
                        textAlign = TextAlign.Center
                    )
                },

                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = MiColorMorado,
                    focusedBorderColor = MiColorMorado
                )
            )
        }


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPantallaNoticias() {
    PantallaNoticias()
}