package com.fadymarty.ui_kit.presentation.components.input

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.fadymarty.ui_kit.common.theme.MatulePalette
import com.fadymarty.ui_kit.common.theme.MatuleTheme
import com.fadymarty.ui_kit.common.util.TestTags
import com.fadymarty.ui_kit.presentation.common.util.hasBorderColor
import com.fadymarty.ui_kit.presentation.common.util.hasColor
import org.junit.Rule
import org.junit.Test

class InputTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun errorInput_errorState_showsErrorBackgroundBorderAndText() {
        composeTestRule.setContent {
            MatuleTheme {
                Input(
                    value = "",
                    onValueChange = {},
                    error = "Введите ваше имя"
                )
            }
        }

        composeTestRule
            .onNode(
                hasTestTag(TestTags.INPUT) and hasColor(
                    MatulePalette.Error.copy(alpha = 0.1f)
                ),
                useUnmergedTree = true
            ).assertIsDisplayed()

        composeTestRule.onNode(
            hasTestTag(TestTags.INPUT) and hasBorderColor(MatulePalette.Error),
            useUnmergedTree = true
        ).assertIsDisplayed()

        composeTestRule
            .onNodeWithTag(TestTags.INPUT_ERROR_TEXT)
            .assertIsDisplayed()

        composeTestRule
            .onNode(
                hasTestTag(TestTags.INPUT_ERROR_TEXT) and hasColor(MatulePalette.Error),
                useUnmergedTree = true
            ).assertIsDisplayed()
    }
}

