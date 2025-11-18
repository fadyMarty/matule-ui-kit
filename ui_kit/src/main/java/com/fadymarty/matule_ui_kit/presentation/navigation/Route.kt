package com.fadymarty.matule_ui_kit.presentation.navigation

sealed interface Route {

    data object HomeScreen : Route

    data object CatalogScreen : Route

    data object ProjectsScreen : Route

    data object ProfileScreen : Route

}