package com.fadymarty.ui_kit.common.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver

val ColorRes = SemanticsPropertyKey<Color>("ColorRes")
var SemanticsPropertyReceiver.colorRes by ColorRes

val BorderColorRes = SemanticsPropertyKey<Color>("BorderColorRes")
var SemanticsPropertyReceiver.borderColorRes by BorderColorRes