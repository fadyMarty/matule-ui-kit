package com.fadymarty.ui_kit.presentation.common.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.SemanticsMatcher
import com.fadymarty.ui_kit.common.util.BorderColorRes
import com.fadymarty.ui_kit.common.util.ColorRes

fun hasColor(color: Color) =
    SemanticsMatcher.expectValue(ColorRes, color)

fun hasBorderColor(color: Color) =
    SemanticsMatcher.expectValue(BorderColorRes, color)