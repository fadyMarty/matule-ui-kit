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
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.fadymarty.matule_ui_kit.presentation.navigation.Route
import com.fadymarty.ui_kit.R
import com.fadymarty.ui_kit.common.theme.MatuleTheme
import com.fadymarty.ui_kit.presentation.components.buttons.BackButton
import com.fadymarty.ui_kit.presentation.components.buttons.BigButton
import com.fadymarty.ui_kit.presentation.components.buttons.MatuleChip
import com.fadymarty.ui_kit.presentation.components.buttons.SmallButton
import com.fadymarty.ui_kit.presentation.components.card.CardBackground
import com.fadymarty.ui_kit.presentation.components.header.BigHeader
import com.fadymarty.ui_kit.presentation.components.header.SmallHeader
import com.fadymarty.ui_kit.presentation.components.icons.MatuleIcons
import com.fadymarty.ui_kit.presentation.components.input.Input
import com.fadymarty.ui_kit.presentation.components.input.PasswordInput
import com.fadymarty.ui_kit.presentation.components.input.SearchInput
import com.fadymarty.ui_kit.presentation.components.tab_bar.TabBar
import com.fadymarty.ui_kit.presentation.components.tab_bar.TabBarItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val tabBarItems = listOf(
                TabBarItem(
                    icon = ImageVector.vectorResource(R.drawable.ic_home),
                    label = "Главная",
                    route = Route.Home
                ),
                TabBarItem(
                    icon = ImageVector.vectorResource(R.drawable.ic_catalog),
                    label = "Главная",
                    route = Route.Catalog
                ),
                TabBarItem(
                    icon = ImageVector.vectorResource(R.drawable.ic_projects),
                    label = "Проекты",
                    iconSize = 24.dp,
                    iconPadding = PaddingValues(top = 5.dp, bottom = 3.dp),
                    route = Route.Projects
                ),
                TabBarItem(
                    icon = ImageVector.vectorResource(R.drawable.ic_profile),
                    label = "Профиль",
                    route = Route.Profile
                )
            )

            MatuleTheme {
                Scaffold { innerPadding ->
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(
                            start = 20.dp,
                            top = innerPadding.calculateTopPadding() + 32.dp,
                            end = 20.dp,
                            bottom = innerPadding.calculateBottomPadding() + 32.dp
                        ),
                        verticalArrangement = Arrangement.spacedBy(64.dp)
                    ) {
                        item {
                            Text(
                                text = "Инпуты",
                                style = MatuleTheme.typography.title1ExtraBold
                            )
                            Spacer(Modifier.height(32.dp))
                            Column(
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
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
                                    value = "Введите имя",
                                    onValueChange = {},
                                    label = "Имя"
                                )
                                PasswordInput(
                                    value = "123456789",
                                    onValueChange = {},
                                    isPasswordVisible = false,
                                    onTrailingIconClick = {}
                                )
                                PasswordInput(
                                    value = "123456789",
                                    onValueChange = {},
                                    isPasswordVisible = true,
                                    onTrailingIconClick = {}
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
                            Text(
                                text = "Кнопки",
                                style = MatuleTheme.typography.title1ExtraBold
                            )
                            Spacer(Modifier.height(32.dp))
                            Column(
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
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
                                    label = "Добавить",
                                    onClick = {}
                                )
                                SmallButton(
                                    label = "Убрать",
                                    onClick = {},
                                    outlined = true
                                )
                                SmallButton(
                                    label = "Добавить",
                                    onClick = {},
                                    enabled = false
                                )
                                SmallButton(
                                    label = "Добавить",
                                    onClick = {},
                                    tertiary = true
                                )
                                Text(
                                    text = "Chips",
                                    style = MatuleTheme.typography.title3Semibold
                                )
                                MatuleChip(
                                    selected = true,
                                    label = "Популярные",
                                    onClick = {}
                                )
                                MatuleChip(
                                    selected = false,
                                    label = "Популярные",
                                    onClick = {}
                                )
                                Text(
                                    text = "Bubble",
                                    style = MatuleTheme.typography.title3Semibold
                                )
                                BackButton(
                                    onClick = {}
                                )
                            }
                        }
                        item {
                            Text(
                                text = "Tabbar",
                                style = MatuleTheme.typography.title1ExtraBold
                            )
                            Spacer(Modifier.height(32.dp))
                            Column(
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                TabBar(
                                    items = tabBarItems,
                                    selectedRoute = Route.Home::class.qualifiedName,
                                    onItemClick = {}
                                )
                                TabBar(
                                    items = tabBarItems,
                                    selectedRoute = Route.Catalog::class.qualifiedName,
                                    onItemClick = {}
                                )
                                TabBar(
                                    items = tabBarItems,
                                    selectedRoute = Route.Projects::class.qualifiedName,
                                    onItemClick = {}
                                )
                                TabBar(
                                    items = tabBarItems,
                                    selectedRoute = Route.Profile::class.qualifiedName,
                                    onItemClick = {}
                                )
                            }
                        }
                        item {
                            Text(
                                text = "Хэдер",
                                style = MatuleTheme.typography.title1ExtraBold
                            )
                            Spacer(Modifier.height(32.dp))
                            Column(
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                BigHeader(
                                    label = "Корзина",
                                    leadingIcon = {
                                        BackButton(onClick = {})
                                    },
                                    trailingIcon = {
                                        Icon(
                                            imageVector = MatuleIcons.Delete,
                                            contentDescription = null
                                        )
                                    }
                                )
                                SmallHeader(
                                    label = "Корзина",
                                    leadingIcon = {
                                        BackButton(onClick = {})
                                    },
                                    trailingIcon = {
                                        Icon(
                                            imageVector = MatuleIcons.Delete,
                                            contentDescription = null
                                        )
                                    }
                                )
                            }
                        }
                        item {
                            Text(
                                text = "Поиск",
                                style = MatuleTheme.typography.title1ExtraBold
                            )
                            Spacer(Modifier.height(32.dp))
                            Column(
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                SearchInput(
                                    value = "",
                                    onValueChange = {},
                                    onClearClick = {},
                                    hint = "Искать описания",
                                    focus = true
                                )
                                SearchInput(
                                    value = "",
                                    onValueChange = {},
                                    onClearClick = {},
                                    hint = "Искать описания"
                                )
                            }
                        }
                        item {
                            Text(
                                text = "Карточки",
                                style = MatuleTheme.typography.title1ExtraBold
                            )
                            Spacer(Modifier.height(32.dp))
                            Column(
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                Text(
                                    text = "CardBackground",
                                    style = MatuleTheme.typography.title3Semibold
                                )
                                CardBackground {
                                    Spacer(Modifier.height(138.dp))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}