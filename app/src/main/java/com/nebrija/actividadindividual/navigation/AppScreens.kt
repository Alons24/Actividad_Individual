package com.nebrija.actividadindividual.navigation



// Definición de una clase sellada llamada AppScreens con una propiedad ruta
sealed class AppScreens(val ruta: String) {


    object Acceso : AppScreens("Acceso")
    object MenuPrimero : AppScreens("MenuPrimero")
    object PrincipianteMENU : AppScreens("PrincipianteMENU")
    object NivelMedioMENU : AppScreens("NivelMedioMENU")
    object ExpertoMENU : AppScreens("ExpertoMENU")



}
