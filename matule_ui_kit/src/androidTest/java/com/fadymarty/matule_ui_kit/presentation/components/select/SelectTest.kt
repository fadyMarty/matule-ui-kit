package com.fadymarty.matule_ui_kit.presentation.components.select

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.fadymarty.matule_ui_kit.common.theme.MatuleTheme
import com.fadymarty.matule_ui_kit.presentation.util.TestTags
import org.junit.Rule
import org.junit.Test

class SelectTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun selectWithoutIcon_selectBottomSheetIsVisible() {
        composeTestRule.setContent {
            MatuleTheme {
                Select(
                    hint = "hint",
                    items = listOf("item1", "item2"),
                    selectedItem = null,
                    onItemClick = {}
                )
            }
        }

        composeTestRule.onNodeWithTag(TestTags.SELECT)
            .performClick()

        composeTestRule.onNodeWithTag(TestTags.SELECT_BOTTOM_SHEET)
            .assertIsDisplayed()
    }

}