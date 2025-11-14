package com.fadymarty.matule_ui_kit.presentation.components.input

import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.fadymarty.matule_ui_kit.common.theme.MatulePalette
import com.fadymarty.matule_ui_kit.common.theme.MatuleTheme
import com.fadymarty.matule_ui_kit.presentation.util.BorderColorRes
import com.fadymarty.matule_ui_kit.presentation.util.ColorRes
import com.fadymarty.matule_ui_kit.presentation.util.TestTags
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class InputTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            MatuleTheme {
                Input(
                    value = "value",
                    onValueChange = {},
                    error = "error"
                )
            }
        }
    }

    @Test
    fun inputWithError_backgroundHasErrorColor() {
        composeTestRule
            .onNode(
                hasTestTag(TestTags.INPUT_CONTAINER) and SemanticsMatcher.expectValue(
                    ColorRes,
                    MatulePalette.Error.copy(alpha = 0.1f)
                ),
                useUnmergedTree = true
            ).assertIsDisplayed()
    }

    @Test
    fun inputWithError_borderHasErrorColor() {
        composeTestRule.onNode(
            hasTestTag(TestTags.INPUT_CONTAINER) and SemanticsMatcher.expectValue(
                BorderColorRes,
                MatulePalette.Error
            ),
            useUnmergedTree = true
        ).assertIsDisplayed()
    }

    @Test
    fun inputWithError_errorTextIsDisplayed() {
        composeTestRule
            .onNodeWithTag(TestTags.INPUT_ERROR_TEXT)
            .assertIsDisplayed()
    }

    @Test
    fun inputWithError_errorTextHasErrorColor() {
        composeTestRule
            .onNode(
                hasTestTag(
                    testTag = TestTags.INPUT_ERROR_TEXT
                ) and SemanticsMatcher.expectValue(
                    key = ColorRes,
                    expectedValue = MatulePalette.Error
                ),
                useUnmergedTree = true
            ).assertIsDisplayed()
    }
}

