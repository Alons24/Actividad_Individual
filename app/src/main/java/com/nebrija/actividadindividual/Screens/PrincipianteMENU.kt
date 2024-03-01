package com.nebrija.actividadindividual.Screens

import android.util.Log
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrincipianteMENU(navController: NavHostController) {
    var ejerciciosEncontrados by remember { mutableStateOf(false) }
    val db = FirebaseFirestore.getInstance()
    val coleccion = "IntensidadBaja"
    var datos by remember { mutableStateOf("") }


    val scaffoldState = rememberScrollState()
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)


    /*Inicio del cajón lateral*/
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    //BOTÓN PARA BOLVER AL MENÚ DE INICIO
                    // Otros elementos del menú lateral
                    Button(
                        onClick = {
                            // Navegar a la pantalla de inicio
                            navController.navigate("MenuInicio")
                            // Cerrar el cajón de navegación modal después de la navegación
                            scope.launch {
                                drawerState.close()
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                    ) {
                        Text(
                            text = "Inicio",
                            style = TextStyle(fontSize = 30.sp)
                        )
                    }

                    //BOTÓN PARA IR A GUARDAR CLIENTE
                    Button(
                        onClick = {
                            // Navegar a la pantalla de inicio
                            navController.navigate("MenuInicio")
                            // Cerrar el cajón de navegación modal después de la navegación
                            scope.launch {
                                drawerState.close()
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                    ) {
                        Text(
                            text = "Guardar cliente",
                            style = TextStyle(fontSize = 30.sp)
                        )
                    }


                    //FIN DE LOS BOTONES DEL MENÚ LATERAL
                }
            }
        },
    ) {

        //COMIENZO DEL SCAFFOLD
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.mediumTopAppBarColors(
                        containerColor = Color.Blue, // Cambia el color de fondo
                        titleContentColor = Color.White, // Cambia el color del título
                    ),
                    title = {
                        Text("PRINCIPIANTE")
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigate("MenuBotones") }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = {(run { scope.launch { drawerState.open() } }) }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Localized description"
                            )
                        }
                    }
                )
            },
            bottomBar = {
                BottomAppBar(
                    containerColor = Color.Blue,
                    contentColor = MaterialTheme.colorScheme.primary,
                ) {
                    // Icono
                    BottomNavigationItem(
                        selected = false,
                        onClick = {/*QUE HAGA ALGOOOOOOOOOOOOOOOO*/},
                        modifier = Modifier.weight(1f),
                        icon = {
                            Icon(imageVector = Icons.Default.DateRange,
                                contentDescription = "Search",
                                tint = Color.White)
                        },
                    )

                    // Icono Adicional
                    BottomNavigationItem(
                        selected = false,
                        onClick = {
                            /* Código para la acción del segundo ícono */
                        },
                        modifier = Modifier.weight(1f),
                        icon = {
                            Icon(imageVector = Icons.Default.AccountCircle,
                                contentDescription = "YourIcon",
                                tint = Color.White)
                        },
                    )

                }
            },
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .verticalScroll(state = scaffoldState)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    var ejercicios1 :ArrayList<Ejercicios>= ArrayList()

                    // Usamos LaunchedEffect para cargar los datos cuando la pantalla se carga por primera vez
                    LaunchedEffect(Unit) {
                        val db = FirebaseFirestore.getInstance()
                        val ref = db.collection("/IntensidadBaja")

                        try {
                            val querySnapshot = ref.get().await()

                            for (document in querySnapshot) {
                                ejercicios1
                            }

                            Log.d("samuLino", ejercicios1.toString())


                        } catch (exception: Exception) {
                            // Ha ocurrido un error al realizar la consulta
                            Log.e("samuLino", "Error al realizar la consulta: ${exception.message}")
                            datos = "No se podido conectar"
                        }
                        ejercicios1=ejerciciosaux
                    }
                    Log.d("FOREACH",ejercicios1.toString())
                    ejercicios1.forEach {(clave,valor)->
                        Log.d("FOREACH",clave)
                        Log.d("FOREACHVALOR",valor.toString())
                        Box (
                            modifier=Modifier
                                .background(Color.Blue)
                        )
                        {
                            Row {
                                Text(text = clave, color = Color.White)
                                Spacer(modifier = Modifier.width(100.dp))
                                Text(text = valor.toString(), color = Color.White)
                            }


                        }
                    }

                }
            }
        }

    }




}

data class Ejercicios(
    var dia:String="",
    var ejercicios:List<String> =emptyList()
)