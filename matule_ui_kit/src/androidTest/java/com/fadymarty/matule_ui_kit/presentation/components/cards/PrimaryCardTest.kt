package com.fadymarty.matule_ui_kit.presentation.components.cards

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.fadymarty.matule_ui_kit.common.theme.MatuleTheme
import com.fadymarty.matule_ui_kit.presentation.util.TestTags
import org.junit.Rule
import org.junit.Test

class PrimaryCardTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun notAddedPrimaryCard_deleteButtonDisplayed() {
        composeTestRule.setContent {
            MatuleTheme {
                PrimaryCard(
                    title = "title",
                    type = "type",
                    price = 0,
                    onClick = {},
                    added = false
                )
            }
        }

        composeTestRule.onNodeWithTag(TestTags.SMALL_BUTTON)
            .assertIsDisplayed()
    }

    @Test
    fun addedPrimaryCard_addButtonDisplayed() {
        composeTestRule.setContent {
            MatuleTheme {
                PrimaryCard(
                    title = "title",
                    type = "type",
                    price = 0,
                    onClick = {},
                    added = true
                )
            }
        }

        composeTestRule.onNodeWithTag(TestTags.OUTLINED_SMALL_BUTTON)
            .assertIsDisplayed()
    }

}