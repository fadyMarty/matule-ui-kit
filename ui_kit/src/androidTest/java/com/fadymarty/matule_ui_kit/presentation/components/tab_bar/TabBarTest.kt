package com.fadymarty.matule_ui_kit.presentation.components.tab_bar

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.dp
import com.fadymarty.matule_ui_kit.R
import com.fadymarty.matule_ui_kit.common.theme.MatulePalette
import com.fadymarty.matule_ui_kit.common.theme.MatuleTheme
import com.fadymarty.matule_ui_kit.common.util.ColorRes
import com.fadymarty.matule_ui_kit.common.util.TestTags
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
                            icon = ImageVector.vectorResource(R.drawable.ic_home),
                            label = "Главная",
                            route = Route.HomeScreen
                        ),
                        TabBarItem(
                            icon = ImageVector.vectorResource(R.drawable.ic_catalog),
                            label = "Каталог",
                            route = Route.CatalogScreen
                        ),
                        TabBarItem(
                            icon = ImageVector.vectorResource(R.drawable.ic_projects),
                            label = "Проекты",
                            route = Route.ProjectsScreen,
                            iconSize = 24.dp,
                            iconPadding = PaddingValues(top = 5.dp, bottom = 3.dp)
                        ),
                        TabBarItem(
                            icon = ImageVector.vectorResource(R.drawable.ic_profile),
                            label = "Профиль",
                            route = Route.ProfileScreen
                        )
                    ),
                    currentRoute = Route.HomeScreen::class.qualifiedName,
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