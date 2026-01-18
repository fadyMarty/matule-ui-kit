package com.fadymarty.ui_kit.presentation.components.buttons

import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import com.fadymarty.ui_kit.common.theme.MatulePalette
import com.fadymarty.ui_kit.common.theme.MatuleTheme
import com.fadymarty.ui_kit.common.util.ColorRes
import com.fadymarty.ui_kit.common.util.TestTags
import org.junit.Rule
import org.junit.Test

class ChipButtonTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun chipButton_statusOn_matchesDesign() {
        composeTestRule.setContent {
            MatuleTheme {
                ChipButton(
                    selected = true,
                    onClick = {},
                    label = "Label"
                )
            }
        }
        composeTestRule.onNode(
            hasTestTag(TestTags.CHIP_BUTTON) and SemanticsMatcher.expectValue(
                ColorRes,
                MatulePalette.Accent
            )
        ).assertIsDisplayed()
    }

    @Test
    fun chipButton_statusOff_matchesDesign() {
        composeTestRule.setContent {
            MatuleTheme {
                ChipButton(
                    selected = false,
                    onClick = {},
                    label = "Label"
                )
            }
        }
        composeTestRule.onNode(
            hasTestTag(TestTags.CHIP_BUTTON) and SemanticsMatcher.expectValue(
                ColorRes,
                MatulePalette.InputBg
            )
        ).assertIsDisplayed()
    }
}