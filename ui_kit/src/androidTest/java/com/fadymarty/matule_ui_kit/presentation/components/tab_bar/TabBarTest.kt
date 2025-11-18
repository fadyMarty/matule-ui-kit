package com.fadymarty.matule_ui_kit.presentation.components.tab_bar

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.dp
import com.fadymarty.matule_ui_kit.common.theme.MatulePalette
import com.fadymarty.matule_ui_kit.common.theme.MatuleTheme
import com.fadymarty.matule_ui_kit.common.util.ColorRes
import com.fadymarty.matule_ui_kit.common.util.TestTags
import com.fadymarty.matule_ui_kit.presentation.components.icons.MatuleIcons
import com.fadymarty.matule_ui_kit.presentation.navigation.Route
import org.junit.Rule
import org.junit.Test

class TabBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun tabBarWithSelectedItem_selectedItemIsActiveA_otherItemsIsUnactive() {
        composeTestRule.setContent {
            MatuleTheme {
                TabBar(
                    items = listOf(
                        TabBarItem(
                            icon = MatuleIcons.Home,
                            label = "Главная",
                            route = Route.HomeScreen
                        ),
                        TabBarItem(
                            icon = MatuleIcons.Catalog,
                            label = "Каталог",
                            route = Route.CatalogScreen
                        ),
                        TabBarItem(
                            icon = MatuleIcons.Projects,
                            label = "Проекты",
                            route = Route.ProjectsScreen,
                            iconSize = 24.dp,
                            spacing = 3.dp
                        ),
                        TabBarItem(
                            icon = MatuleIcons.Profile,
                            label = "Профиль",
                            route = Route.ProfileScreen
                        )
                    ),
                    selectedRoute = Route.HomeScreen::class.qualifiedName,
                    onItemClick = {}
                )
            }
        }

        assertTabBarItem(
            label = "Главная",
            color = MatulePalette.Accent
        )

        assertTabBarItem(
            label = "Каталог",
            color = MatulePalette.InputIcon
        )

        assertTabBarItem(
            label = "Проекты",
            color = MatulePalette.InputIcon
        )

        assertTabBarItem(
            label = "Профиль",
            color = MatulePalette.InputIcon
        )
    }

    private fun assertTabBarItem(
        label: String,
        color: Color,
    ) {
        composeTestRule.onNode(
            hasTestTag(TestTags.TAB_BAR_ITEM + label) and SemanticsMatcher.expectValue(
                ColorRes,
                color
            )
        ).assertIsDisplayed()
    }
}