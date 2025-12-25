package com.fadymarty.matule_ui_kit

sealed interface Route {
    data object Home : Route
    data object Catalog : Route
    data object Projects : Route
    data object Profile : Route
}