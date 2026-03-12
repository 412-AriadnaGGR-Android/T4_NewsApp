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
        item {

            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        "Noticias",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 24.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )

                    Box(
                        Modifier
                            .width(40.dp)
                            .height(4.dp)
                            .background(MiColorMorado)
                    )
                }

                Text(
                    "Eventos",
                    color = Color.LightGray,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )

                Text(
                    "Clima",
                    color = Color.LightGray,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
            }
        }

        item {

            Text(
                "Ultimas noticias",
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(12.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                items(listaNoticias) { noticia ->
                    CardGrande(noticia)
                }
            }
        }

        item {

            Text(
                "Alrededor del mundo",
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }


        item {

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                CardPequena(listaNoticias[0], Modifier.weight(1f))
                CardPequena(listaNoticias[1], Modifier.weight(1f))
            }
        }

        item {

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                CardPequena(listaNoticias[2], Modifier.weight(1f))
                CardPequena(listaNoticias[3], Modifier.weight(1f))
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun CardGrande(noticia: Noticia) {

    Box(
        modifier = Modifier
            .size(width = 300.dp, height = 180.dp)
            .clip(RoundedCornerShape(32.dp))
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MiColorMorado.copy(alpha = 0.6f))
        )

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(20.dp),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = noticia.titulo,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )

            Text(
                text = noticia.fecha,
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPantallaNoticias() {
    PantallaNoticias()
}