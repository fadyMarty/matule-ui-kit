package com.fadymarty.ui_kit.presentation.components.select

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.fadymarty.ui_kit.common.theme.MatuleTheme
import com.fadymarty.ui_kit.common.util.TestTags
import org.junit.Rule
import org.junit.Test

class SelectTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun selectWithoutIcon_onClick_opensBottomSheet() {
        composeTestRule.setContent {
            MatuleTheme {
                Select(
                    items = listOf(
                        SelectItem("Мужской"),
                        SelectItem("Женский")
                    ),
                    selectedItemLabel = "Мужской",
                    onItemClick = {}
                )
            }
        }

        composeTestRule.onNodeWithTag(TestTags.SELECT)
            .performClick()

        composeTestRule.onNodeWithTag(TestTags.SELECT_MODAL)
            .assertIsDisplayed()
    }

}