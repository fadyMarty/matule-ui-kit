package com.fadymarty.matule_ui_kit.presentation.navigation

sealed interface Route {
    data object Home : Route
    data object Catalog : Route
    data object Projects : Route
    data object Profile : Route
}