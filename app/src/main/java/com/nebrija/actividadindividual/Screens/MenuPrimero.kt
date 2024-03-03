package com.nebrija.actividadindividual.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.nebrija.actividadindividual.navigation.AppScreens
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuPrimero(navController: NavHostController) {

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
                        onClick = { navController.navigate(AppScreens.PrincipianteMENU.ruta) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .width(300.dp)
                            .height(100.dp),
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(Color(4, 104, 249, 255))
                    ) {
                        Text(
                            text = "PRINCIPIANTE",
                            fontSize = 25.sp,
                        )
                    }

                    //BOTÓN PARA IR A GUARDAR CLIENTE
                    Button(
                        onClick = { navController.navigate(AppScreens.NivelMedioMENU.ruta) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .width(300.dp)
                            .height(100.dp),
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(Color(4, 104, 249, 255))
                    ) {
                        Text(
                            text = "NIVEL MEDIO",
                            fontSize = 25.sp,
                        )
                    }

                    //BOTÓN PARA IR A MODIFICAR CLIENTE
                    Button(
                        onClick = { navController.navigate(AppScreens.ExpertoMENU.ruta) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .width(300.dp)
                            .height(100.dp),
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(Color(4, 104, 249, 255))
                    ) {
                        Text(
                            text = "EXPERTO",
                            fontSize = 25.sp,
                        )
                    }




                    //FIN DE LOS BOTONES DEL MENÚ LATERAL
                }
            }
        },
    ) {
        //Fin del cajón lateral y enpieza el Scaffold
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.mediumTopAppBarColors(
                        containerColor = Color.Blue, // Cambia el color de fondo
                        titleContentColor = Color.White, // Cambia el color del título
                    ),
                    title = {
                        Text("MENU")
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigate("Acceso") }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Localized description",
                                tint=Color.White
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Menu",
                                tint=Color.White
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
                            Icon(imageVector = Icons.Default.DateRange, contentDescription = "Search", tint = Color.White)
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
                            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "YourIcon", tint = Color.White)
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

                }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(25.dp)) // Espaciador entre botones

            // BOTÓN INICIO
            //INICIO BOTÓN
            Button(
                onClick = { navController.navigate(AppScreens.PrincipianteMENU.ruta) },
                modifier = Modifier
                    .fillMaxWidth()
                    .width(300.dp)
                    .height(100.dp),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(Color(4, 104, 249, 255))
            ) {
                Text(
                    text = "PRINCIPIANTE",
                    fontSize = 25.sp,
                )
            }
            //FIN BOTÓN
            Spacer(modifier = Modifier.height(100.dp)) // Espaciador entre botones

            //BOTÓN FIN
            Button(
                onClick = { navController.navigate(AppScreens.NivelMedioMENU.ruta) },
                modifier = Modifier
                    .fillMaxWidth()
                    .width(300.dp)
                    .height(100.dp),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(Color(4, 104, 249, 255))
            ) {
                Text(
                    text = "NIVEL MEDIO",
                    fontSize = 25.sp,
                )
            }
            //BOTÓN FIN
            Spacer(modifier = Modifier.height(100.dp)) // Espaciador entre botones

            //BOTÓN EXPERTO
            Button(
                onClick = { navController.navigate(AppScreens.ExpertoMENU.ruta) },
                modifier = Modifier
                    .fillMaxWidth()
                    .width(300.dp)
                    .height(100.dp),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(Color(4, 104, 249, 255))
            ) {
                Text(
                    text = "EXPERTO",
                    fontSize = 25.sp,
                )
            }
            //BOTÓN FIN

        }
    }
}
    }
}
