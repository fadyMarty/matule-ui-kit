package com.fadymarty.ui_kit.presentation.components.select

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fadymarty.ui_kit.common.theme.MatuleTheme
import com.fadymarty.ui_kit.common.util.TestTags
import com.fadymarty.ui_kit.presentation.components.icons.MatuleIcons
import com.fadymarty.ui_kit.presentation.components.modal.Modal

@Composable
fun Select(
    modifier: Modifier = Modifier,
    items: List<SelectItem>,
    selectedItemLabel: String?,
    onItemClick: (SelectItem) -> Unit,
    hint: String? = null,
    label: String? = null,
) {
    val selectedItem = items.firstOrNull { it.label == selectedItemLabel }
    var isModalVisible by rememberSaveable {
        mutableStateOf(false)
    }

    Column(modifier) {
        label?.let {
            Text(
                text = label,
                style = MatuleTheme.typography.captionRegular,
                color = MatuleTheme.colorScheme.description
            )
            Spacer(Modifier.height(4.dp))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .border(
                    width = 1.dp,
                    color = MatuleTheme.colorScheme.inputStroke,
                    shape = RoundedCornerShape(10.dp)
                )
                .clip(RoundedCornerShape(10.dp))
                .background(MatuleTheme.colorScheme.inputBg)
                .clickable {
                    isModalVisible = true
                }
                .padding(
                    start = if (selectedItem?.icon != null) 12.dp else 14.dp,
                    end = 14.dp
                )
                .testTag(TestTags.SELECT),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                selectedItem?.icon?.let { icon ->
                    Text(
                        text = icon,
                        fontSize = 24.sp
                    )
                }
                if (selectedItem == null && hint != null) {
                    Text(
                        text = hint,
                        style = MatuleTheme.typography.headlineRegular,
                        color = MatuleTheme.colorScheme.placeholder
                    )
                }
                selectedItemLabel?.let {
                    Text(
                        text = selectedItemLabel,
                        style = MatuleTheme.typography.headlineRegular,
                    )
                }
            }
            Icon(
                imageVector = MatuleIcons.ChevronDown,
                contentDescription = null,
                tint = MatuleTheme.colorScheme.description
            )
        }
    }

    if (isModalVisible) {
        Modal(
            modifier = Modifier.testTag(TestTags.SELECT_MODAL),
            onDismissRequest = {
                isModalVisible = false
            },
            title = hint
        ) {
            Spacer(Modifier.height(8.dp))
            LazyColumn(
                contentPadding = PaddingValues(
                    top = 12.dp,
                    bottom = 20.dp
                )
            ) {
                items(items) { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .clickable {
                                onItemClick(item)
                                isModalVisible = false
                            }
                            .padding(
                                start = if (selectedItem?.icon != null) 18.dp else 20.dp,
                                end = 20.dp
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        item.icon?.let { icon ->
                            Text(
                                text = icon,
                                fontSize = 24.sp
                            )
                        }
                        Text(
                            text = item.label,
                            style = MatuleTheme.typography.headlineRegular,
                        )
                    }
                }
            }
        }
    }
}