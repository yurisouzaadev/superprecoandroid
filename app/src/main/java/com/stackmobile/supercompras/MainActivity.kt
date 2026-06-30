package com.stackmobile.supercompras

import android.R.attr.value
import android.os.Bundle
import android.widget.CheckBox
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackmobile.supercompras.ui.theme.Marinho
import com.stackmobile.supercompras.ui.theme.SuperComprasTheme
import com.stackmobile.supercompras.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperComprasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(verticalArrangement = Arrangement.Top) {
                        ImagemTopo()
                        AdicionarItem()
                        Titulo(
                            texto = "Lista de Compras",
                        )
                        ItemDaLista()
                        Titulo(texto = "Comprado")

                    }
                }
            }
        }
    }
}

@Composable
fun AdicionarItem(modifier: Modifier = Modifier) {
    var texto = remember { mutableStateOf("") }
    TextField(
        value = "",
        onValueChange = { texto.value = it },
        modifier = modifier,

    )
}

@Composable
fun Titulo(texto: String, modifier: Modifier = Modifier) {
    Text(text = texto, style = Typography.headlineLarge, modifier = modifier)
}

@Composable
fun ItemDaLista(modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.Top, modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Checkbox(
                checked = false,
                onCheckedChange = {},
                modifier = Modifier
                    .padding(end = 8.dp)
                    .requiredSize(24.dp)
            )
            Text(
                text = "Suco",
                modifier = Modifier.weight(1f),
                style = Typography.bodyMedium,
                textAlign = TextAlign.Start
            )
            Icone(
                Icons.Default.Delete,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(16.dp)
            )
            Icone(
                Icons.Default.Edit,
                modifier = Modifier
                    .size(16.dp)
            )

        }
        Text(
            text = "Segunda-Feira (29/06/2026) às 01:15",
            Modifier.padding(top = 8.dp),
            style = Typography.labelSmall
        )
    }
}


@Composable
fun ImagemTopo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.imagem_topo),
        contentDescription = null,
        modifier = modifier.size(160.dp)
    )
}

@Composable
fun Icone(icone: ImageVector, modifier: Modifier = Modifier) {
    Icon(icone, contentDescription = "Editar", modifier = modifier, tint = Marinho)
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello Yuri",
        modifier = modifier
    )
}

@Preview
@Composable
private fun AdicionarItemPreview() {
    SuperComprasTheme {
        AdicionarItem()
    }
    
}


@Preview
@Composable
private fun ItemDaListaPreview() {
    SuperComprasTheme {
        ItemDaLista()
    }
}

@Preview
@Composable
private fun IconsEditPreview() {
    SuperComprasTheme {
        Icone(Icons.Default.Delete)
    }

}

@Preview
@Composable
private fun TopoPreview() {
    SuperComprasTheme {
        ImagemTopo()
    }
}

@Preview
@Composable
private fun TituloPreview() {
    SuperComprasTheme {
        Titulo(texto = "Lista de Compras")
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SuperComprasTheme {
        Greeting("Android")
    }
}