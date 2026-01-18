package com.fadymarty.ui_kit.presentation.components.buttons

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import com.fadymarty.ui_kit.common.theme.MatulePalette
import com.fadymarty.ui_kit.common.theme.MatuleTheme
import com.fadymarty.ui_kit.common.util.TestTags
import com.fadymarty.ui_kit.presentation.common.util.hasColor
import org.junit.Rule
import org.junit.Test

class ChipTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun chip_statusOn_matchesDesign() {
        composeTestRule.setContent {
            MatuleTheme {
                Chip(
                    selected = true,
                    onClick = {},
                    label = "Популярные"
                )
            }
        }

        composeTestRule.onNode(
            hasTestTag(TestTags.CHIP_BUTTON) and hasColor(MatulePalette.Accent)
        ).assertIsDisplayed()
    }

    @Test
    fun chipButton_statusOff_matchesDesign() {
        composeTestRule.setContent {
            MatuleTheme {
                Chip(
                    selected = false,
                    onClick = {},
                    label = "Популярные"
                )
            }
        }

        composeTestRule.onNode(
            hasTestTag(TestTags.CHIP_BUTTON) and hasColor(MatulePalette.InputBg)
        ).assertIsDisplayed()
    }
}