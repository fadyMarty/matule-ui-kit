package com.fadymarty.matule_ui_kit.presentation.components.buttons

import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import com.fadymarty.matule_ui_kit.common.theme.MatulePalette
import com.fadymarty.matule_ui_kit.common.theme.MatuleTheme
import com.fadymarty.matule_ui_kit.presentation.util.ColorRes
import com.fadymarty.matule_ui_kit.presentation.util.TestTags
import org.junit.Rule
import org.junit.Test

class ChipButtonTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun selectedChipButton_containerColorIsAccent() {
        composeTestRule.setContent {
            MatuleTheme {
                ChipButton(
                    selected = true,
                    onClick = {},
                    label = "label"
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
    fun selectedChipButton_containerColorIs() {
        composeTestRule.setContent {
            MatuleTheme {
                ChipButton(
                    selected = false,
                    onClick = {},
                    label = "label"
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