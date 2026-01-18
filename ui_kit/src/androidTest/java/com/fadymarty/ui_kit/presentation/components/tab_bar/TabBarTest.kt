package com.fadymarty.ui_kit.presentation.components.tab_bar

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.dp
import com.fadymarty.ui_kit.R
import com.fadymarty.ui_kit.common.theme.MatulePalette
import com.fadymarty.ui_kit.common.theme.MatuleTheme
import com.fadymarty.ui_kit.common.util.TestTags
import com.fadymarty.ui_kit.presentation.common.util.hasColor
import org.junit.Rule
import org.junit.Test

class TabBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun tabBar_whenTabFocused_setsFocusedTabActiveAndOthersInactive() {
        composeTestRule.setContent {
            MatuleTheme {
                TabBar(
                    items = listOf(
                        TabBarItem(
                            icon = R.drawable.ic_home,
                            label = "Главная",
                            route = TestRoute.Home
                        ),
                        TabBarItem(
                            icon = R.drawable.ic_catalog,
                            label = "Каталог",
                            route = TestRoute.Catalog
                        ),
                        TabBarItem(
                            icon = R.drawable.ic_projects,
                            label = "Проекты",
                            route = TestRoute.Projects,
                            iconSize = 24.dp,
                            iconPadding = PaddingValues(top = 5.dp, bottom = 3.dp)
                        ),
                        TabBarItem(
                            icon = R.drawable.ic_profile,
                            label = "Профиль",
                            route = TestRoute.Profile
                        )
                    ),
                    currentRoute = TestRoute.Home::class.qualifiedName,
                    onItemClick = {}
                )
            }
        }

        assertIsTabBarItemDisplayed(
            label = "Главная",
            color = MatulePalette.Accent
        )

        assertIsTabBarItemDisplayed(
            label = "Каталог",
            color = MatulePalette.InputIcon
        )

        assertIsTabBarItemDisplayed(
            label = "Проекты",
            color = MatulePalette.InputIcon
        )

        assertIsTabBarItemDisplayed(
            label = "Профиль",
            color = MatulePalette.InputIcon
        )
    }

    private fun assertIsTabBarItemDisplayed(
        label: String,
        color: Color,
    ) {
        composeTestRule.onNode(
            hasTestTag(TestTags.TAB_BAR_ITEM + label) and hasColor(color)
        ).assertIsDisplayed()
    }
}