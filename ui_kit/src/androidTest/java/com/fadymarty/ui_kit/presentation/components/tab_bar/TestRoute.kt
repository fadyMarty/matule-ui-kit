package com.fadymarty.ui_kit.presentation.components.tab_bar

sealed interface TestRoute {
    data object Home : TestRoute
    data object Catalog : TestRoute
    data object Projects : TestRoute
    data object Profile : TestRoute
}