package com.fadymarty.ui_kit.presentation.components.cards

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.fadymarty.ui_kit.common.theme.MatuleTheme
import com.fadymarty.ui_kit.common.util.TestTags
import org.junit.Rule
import org.junit.Test

class PrimaryCardTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun primaryCard_statusAdd_matchesDesign() {
        composeTestRule.setContent {
            MatuleTheme {
                PrimaryCard(
                    title = "Рубашка Воскресенье для машинного вязания",
                    type = "Мужская одежда",
                    price = "300 ₽",
                    onClick = {},
                    onButtonClick = {},
                    added = false
                )
            }
        }

        composeTestRule.onNodeWithTag(TestTags.BUTTON)
            .assertIsDisplayed()
    }

    @Test
    fun primaryCard_statusDelete_matchesDesign() {
        composeTestRule.setContent {
            MatuleTheme {
                PrimaryCard(
                    title = "Рубашка Воскресенье для машинного вязания",
                    type = "Мужская одежда",
                    price = "300 ₽",
                    onClick = {},
                    onButtonClick = {},
                    added = true
                )
            }
        }

        composeTestRule.onNodeWithTag(TestTags.OUTLINED_BUTTON)
            .assertIsDisplayed()
    }
}