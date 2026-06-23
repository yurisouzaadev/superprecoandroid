package com.stackmobile.supercompras

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackmobile.supercompras.ui.theme.SuperComprasTheme
import com.stackmobile.supercompras.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperComprasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                //ImagemTopo(modifier = Modifier.padding(paddingValues = innerPadding))
                Titulo(modifier = Modifier.padding(innerPadding))
//                    Icone(
   //                     modifier = Modifier.padding(paddingValues = innerPadding),
      //                  icone = Icons.Default.Delete
              //      )
                }
            }
        }
    }
}


@Composable
fun Titulo(modifier: Modifier = Modifier) {
    Text(text = "Lista de Compras", modifier=modifier, style = Typography.headlineLarge)
}


@Composable
fun ImagemTopo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.imagem_topo),
        contentDescription = null,
        modifier = modifier.size(160.dp))
}

@Composable
fun Icone(icone: ImageVector, modifier: Modifier = Modifier) {
    Icon(icone, contentDescription = "Editar", modifier = modifier)
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
        Titulo()
    }
    
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SuperComprasTheme {
        Greeting("Android")
    }
}