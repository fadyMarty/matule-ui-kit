package com.fadymarty.matule_ui_kit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fadymarty.matule_ui_kit.common.theme.MatuleTheme
import com.fadymarty.matule_ui_kit.presentation.components.buttons.BackButton
import com.fadymarty.matule_ui_kit.presentation.components.buttons.BigButton
import com.fadymarty.matule_ui_kit.presentation.components.buttons.CartButton
import com.fadymarty.matule_ui_kit.presentation.components.buttons.ChipButton
import com.fadymarty.matule_ui_kit.presentation.components.buttons.FilterButton
import com.fadymarty.matule_ui_kit.presentation.components.buttons.LoginButton
import com.fadymarty.matule_ui_kit.presentation.components.buttons.SmallButton
import com.fadymarty.matule_ui_kit.presentation.components.cards.CardBackground
import com.fadymarty.matule_ui_kit.presentation.components.cards.CartCard
import com.fadymarty.matule_ui_kit.presentation.components.cards.PrimaryCard
import com.fadymarty.matule_ui_kit.presentation.components.cards.ProjectCard
import com.fadymarty.matule_ui_kit.presentation.components.controls.Counter
import com.fadymarty.matule_ui_kit.presentation.components.controls.Toggle
import com.fadymarty.matule_ui_kit.presentation.components.header.BigHeader
import com.fadymarty.matule_ui_kit.presentation.components.header.SmallHeader
import com.fadymarty.matule_ui_kit.presentation.components.input.Input
import com.fadymarty.matule_ui_kit.presentation.components.input.PasswordInput
import com.fadymarty.matule_ui_kit.presentation.components.input.SearchInput
import com.fadymarty.matule_ui_kit.presentation.components.select.Select
import com.fadymarty.matule_ui_kit.presentation.components.snack_bar.SnackBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MatuleTheme {
                Scaffold { innerPadding ->
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(
                            start = 20.dp,
                            top = innerPadding.calculateTopPadding() + 32.dp,
                            bottom = innerPadding.calculateBottomPadding() + 32.dp,
                            end = 20.dp
                        ),
                        verticalArrangement = Arrangement.spacedBy(64.dp)
                    ) {
                        item {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                Text(
                                    text = "Контролы",
                                    style = MatuleTheme.typography.title1ExtraBold
                                )
                                Text(
                                    text = "Toggle",
                                    style = MatuleTheme.typography.title3Semibold
                                )
                                Toggle(
                                    checked = false,
                                    onClick = {}
                                )
                                Toggle(
                                    checked = true,
                                    onClick = {}
                                )
                                Text(
                                    text = "Counter",
                                    style = MatuleTheme.typography.title3Semibold
                                )
                                Counter(
                                    count = 1,
                                    onMinusClick = {},
                                    onPlusClick = {}
                                )
                                Counter(
                                    count = 1,
                                    onMinusClick = {},
                                    onPlusClick = {}
                                )
                            }
                        }
                        item {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                Text(
                                    text = "Хэдер",
                                    style = MatuleTheme.typography.title1ExtraBold
                                )
                                SmallHeader(
                                    label = "Корзина",
                                    onNavigateBack = {},
                                    onDeleteClick = {}
                                )
                                BigHeader(
                                    label = "Корзина",
                                    onNavigateBack = {},
                                    onDeleteClick = {}
                                )
                            }
                        }

                        item {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                Text(
                                    text = "Модальные окна",
                                    style = MatuleTheme.typography.title1ExtraBold
                                )
                                Text(
                                    text = "SnackBar",
                                    style = MatuleTheme.typography.title3Semibold
                                )
                                SnackBar(
                                    message = "Произошла ошибка\nНу вот опять",
                                    onClose = {}
                                )
                            }
                        }

                        item {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                Text(
                                    text = "Карточки",
                                    style = MatuleTheme.typography.title1ExtraBold
                                )
                                Text(
                                    text = "Card background",
                                    style = MatuleTheme.typography.title3Semibold
                                )
                                CardBackground {
                                    Spacer(Modifier.height(138.dp))
                                }
                                Text(
                                    text = "Primary",
                                    style = MatuleTheme.typography.title3Semibold
                                )
                                PrimaryCard(
                                    title = "Рубашка Воскресенье для машинного вязания",
                                    type = "Мужская одежда",
                                    price = 300,
                                    added = true,
                                    onClick = {}
                                )
                                PrimaryCard(
                                    title = "Рубашка Воскресенье для машинного вязания",
                                    type = "Мужская одежда",
                                    price = 300,
                                    added = false,
                                    onClick = {}
                                )
                                Text(
                                    text = "Cart",
                                    style = MatuleTheme.typography.title3Semibold
                                )
                                CartCard(
                                    title = "Рубашка воскресенье для машинного вязания",
                                    price = 300,
                                    count = 1,
                                    onPlusClick = {},
                                    onMinusClick = {},
                                    onDeleteClick = {}
                                )
                                Text(
                                    text = "Project",
                                    style = MatuleTheme.typography.title3Semibold
                                )
                                ProjectCard(
                                    title = "Мой первый проект",
                                    onClick = {}
                                )
                            }
                        }

                        item {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                Text(
                                    text = "Инпуты",
                                    style = MatuleTheme.typography.title1ExtraBold
                                )
                                Input(
                                    value = "",
                                    onValueChange = {},
                                    hint = "Введите имя"
                                )
                                Input(
                                    value = "Иван",
                                    onValueChange = {}
                                )
                                Input(
                                    value = "",
                                    onValueChange = {},
                                    hint = "Введите имя",
                                    label = "Имя",
                                    focus = true
                                )
                                Input(
                                    value = "",
                                    onValueChange = {},
                                    hint = "Имя",
                                    error = "Введите ваше имя"
                                )
                                Input(
                                    value = "",
                                    onValueChange = {},
                                    hint = "Введите имя",
                                    label = "Имя"
                                )
                                Input(
                                    value = "Введите имя",
                                    onValueChange = {},
                                    label = "Имя"
                                )
                                PasswordInput(
                                    value = "123456789",
                                    onValueChange = {}
                                )
                                Input(
                                    value = "",
                                    onValueChange = {},
                                    hint = "--.--.----",
                                    focus = true
                                )
                            }
                        }
                        item {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                Text(
                                    text = "Селекты",
                                    style = MatuleTheme.typography.title1ExtraBold
                                )
                                Select(
                                    items = listOf("Мужской", "Женский"),
                                    selectedItem = null,
                                    hint = "Пол",
                                    onItemClick = {}
                                )
                                Select(
                                    items = listOf("Мужской", "Женский"),
                                    selectedItem = "Мужской",
                                    hint = "Пол",
                                    onItemClick = {}
                                )
                                Select(
                                    items = listOf("Гарвард Троцкий"),
                                    selectedItem = "Гарвард Троцкий",
                                    onItemClick = {},
                                    leadingIcon = {
                                        Text(
                                            text = "👨",
                                            fontSize = 24.sp
                                        )
                                    }
                                )
                            }
                        }
                        item {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                Text(
                                    text = "Поиск",
                                    style = MatuleTheme.typography.title1ExtraBold
                                )
                                SearchInput(
                                    value = "",
                                    onValueChange = {},
                                    hint = "Искать описание",
                                    onClear = {},
                                    focus = true
                                )
                                SearchInput(
                                    value = "",
                                    onValueChange = {},
                                    hint = "Искать описание",
                                    onClear = {}
                                )
                            }
                        }
                        item {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                Text(
                                    text = "Кнопки",
                                    style = MatuleTheme.typography.title1ExtraBold
                                )
                                Text(
                                    text = "Big",
                                    style = MatuleTheme.typography.title3Semibold
                                )
                                BigButton(
                                    label = "Подтвердить",
                                    onClick = {}
                                )
                                BigButton(
                                    label = "Подтвердить",
                                    onClick = {},
                                    enabled = false
                                )
                                BigButton(
                                    label = "Подтвердить",
                                    onClick = {},
                                    outlined = true
                                )
                                BigButton(
                                    label = "Подтвердить",
                                    onClick = {},
                                    tertiary = true
                                )
                                Text(
                                    text = "Small",
                                    style = MatuleTheme.typography.title3Semibold
                                )
                                SmallButton(
                                    label = "Подтвердить",
                                    onClick = {}
                                )
                                SmallButton(
                                    label = "Подтвердить",
                                    onClick = {},
                                    outlined = true
                                )
                                SmallButton(
                                    label = "Подтвердить",
                                    onClick = {},
                                    enabled = false
                                )
                                SmallButton(
                                    label = "Подтвердить",
                                    onClick = {},
                                    tertiary = true
                                )
                                Text(
                                    text = "Chips",
                                    style = MatuleTheme.typography.title3Semibold
                                )
                                ChipButton(
                                    selected = true,
                                    label = "Популярные",
                                    onClick = {}
                                )
                                ChipButton(
                                    selected = false,
                                    label = "Популярные",
                                    onClick = {}
                                )
                                Text(
                                    text = "Cart",
                                    style = MatuleTheme.typography.title3Semibold
                                )
                                CartButton(
                                    price = 500,
                                    onClick = {}
                                )
                                Text(
                                    text = "Log in",
                                    style = MatuleTheme.typography.title3Semibold
                                )
                                LoginButton(
                                    label = "Войти с VK",
                                    leadingIcon = ImageVector.vectorResource(R.drawable.ic_vk),
                                    onClick = {}
                                )
                                LoginButton(
                                    label = "Войти с Yandex",
                                    leadingIcon = ImageVector.vectorResource(R.drawable.ic_yandex),
                                    onClick = {}
                                )
                                Text(
                                    text = "Bubble",
                                    style = MatuleTheme.typography.title3Semibold
                                )
                                BackButton(
                                    onClick = {}
                                )
                                FilterButton(
                                    onClick = {}
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}