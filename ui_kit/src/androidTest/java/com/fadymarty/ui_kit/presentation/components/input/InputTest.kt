package com.fadymarty.ui_kit.presentation.components.input

import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.fadymarty.ui_kit.common.theme.MatulePalette
import com.fadymarty.ui_kit.common.theme.MatuleTheme
import com.fadymarty.ui_kit.common.util.BorderColorRes
import com.fadymarty.ui_kit.common.util.ColorRes
import com.fadymarty.ui_kit.common.util.TestTags
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
                    value = "Value",
                    onValueChange = {},
                    error = "Error"
                )
            }
        }
    }

    @Test
    fun errorInput_errorState_showsErrorBackgroundBorderAndText() {
        composeTestRule
            .onNode(
                hasTestTag(TestTags.INPUT) and SemanticsMatcher.expectValue(
                    ColorRes,
                    MatulePalette.Error.copy(alpha = 0.1f)
                ),
                useUnmergedTree = true
            ).assertIsDisplayed()

        composeTestRule.onNode(
            hasTestTag(TestTags.INPUT) and SemanticsMatcher.expectValue(
                BorderColorRes,
                MatulePalette.Error
            ),
            useUnmergedTree = true
        ).assertIsDisplayed()

        composeTestRule
            .onNodeWithTag(TestTags.INPUT_ERROR_TEXT)
            .assertIsDisplayed()

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

