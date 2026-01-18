package com.fadymarty.matule_ui_kit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fadymarty.ui_kit.R
import com.fadymarty.ui_kit.common.theme.MatuleTheme
import com.fadymarty.ui_kit.presentation.components.buttons.BackButton
import com.fadymarty.ui_kit.presentation.components.buttons.BigButton
import com.fadymarty.ui_kit.presentation.components.buttons.CartButton
import com.fadymarty.ui_kit.presentation.components.buttons.Chip
import com.fadymarty.ui_kit.presentation.components.buttons.FilterButton
import com.fadymarty.ui_kit.presentation.components.buttons.LoginButton
import com.fadymarty.ui_kit.presentation.components.buttons.SmallButton
import com.fadymarty.ui_kit.presentation.components.cards.CardBackground
import com.fadymarty.ui_kit.presentation.components.cards.CartCard
import com.fadymarty.ui_kit.presentation.components.cards.PrimaryCard
import com.fadymarty.ui_kit.presentation.components.cards.ProjectCard
import com.fadymarty.ui_kit.presentation.components.controls.Counter
import com.fadymarty.ui_kit.presentation.components.controls.Toggle
import com.fadymarty.ui_kit.presentation.components.header.BigHeader
import com.fadymarty.ui_kit.presentation.components.header.SmallHeader
import com.fadymarty.ui_kit.presentation.components.icons.MatuleIcons
import com.fadymarty.ui_kit.presentation.components.input.Input
import com.fadymarty.ui_kit.presentation.components.input.PasswordInput
import com.fadymarty.ui_kit.presentation.components.input.SearchInput
import com.fadymarty.ui_kit.presentation.components.select.Select
import com.fadymarty.ui_kit.presentation.components.select.SelectItem
import com.fadymarty.ui_kit.presentation.components.snack_bar.SnackBar
import com.fadymarty.ui_kit.presentation.components.tab_bar.TabBar
import com.fadymarty.ui_kit.presentation.components.tab_bar.TabBarItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val tabBarItems = remember {
                listOf(
                    TabBarItem(
                        icon = R.drawable.ic_home,
                        label = "Главная",
                        route = Route.Home
                    ),
                    TabBarItem(
                        icon = R.drawable.ic_catalog,
                        label = "Каталог",
                        route = Route.Catalog
                    ),
                    TabBarItem(
                        icon = R.drawable.ic_projects,
                        label = "Проекты",
                        route = Route.Projects,
                        iconSize = 24.dp,
                        iconPadding = PaddingValues(top = 5.dp, bottom = 3.dp)
                    ),
                    TabBarItem(
                        icon = R.drawable.ic_profile,
                        label = "Профиль",
                        route = Route.Profile
                    )
                )
            }

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
                            Column(
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                Text(
                                    text = "Контролы",
                                    style = MatuleTheme.typography.title1ExtraBold
                                )
                                Toggle(
                                    checked = false,
                                    onClick = {}
                                )
                                Toggle(
                                    checked = true,
                                    onClick = {}
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
                                BigHeader(
                                    title = "Корзина",
                                    navigationIcon = {
                                        BackButton(
                                            onClick = {}
                                        )
                                    },
                                    trailingIcon = {
                                        Icon(
                                            modifier = Modifier.size(20.dp),
                                            imageVector = MatuleIcons.Delete,
                                            contentDescription = null,
                                            tint = MatuleTheme.colorScheme.inputIcon
                                        )
                                    }
                                )
                                SmallHeader(
                                    title = "Корзина",
                                    navigationIcon = {
                                        BackButton(
                                            onClick = {}
                                        )
                                    },
                                    trailingIcon = {
                                        Icon(
                                            modifier = Modifier.size(20.dp),
                                            imageVector = MatuleIcons.Delete,
                                            contentDescription = null,
                                            tint = MatuleTheme.colorScheme.inputIcon
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
                                    text = "Модальные окна",
                                    style = MatuleTheme.typography.title1ExtraBold
                                )
                                SnackBar(
                                    message = "Произошла ошибка\nНу вот опять",
                                    onDismiss = {}
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
                                CardBackground(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(138.dp),
                                    content = {}
                                )
                                PrimaryCard(
                                    title = "Рубашка Воскресенье для машинного вязания",
                                    type = "Мужская одежда",
                                    price = "300 ₽",
                                    added = true,
                                    onClick = {},
                                    onButtonClick = {}
                                )
                                PrimaryCard(
                                    title = "Рубашка Воскресенье для машинного вязания",
                                    type = "Мужская одежда",
                                    price = "300 ₽",
                                    added = false,
                                    onClick = {},
                                    onButtonClick = {}
                                )
                                CartCard(
                                    title = "Рубашка воскресенье для машинного вязания",
                                    price = "300 ₽",
                                    count = 1,
                                    onPlusClick = {},
                                    onMinusClick = {},
                                    onDeleteClick = {}
                                )
                                ProjectCard(
                                    title = "Мой первый проект",
                                    date = "Прошло 2 дня",
                                    onOpenClick = {}
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
                                    focused = true
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
                                    onValueChange = {},
                                    isVisible = false,
                                    onTrailingIconClick = {}
                                )
                                PasswordInput(
                                    value = "123456789",
                                    onValueChange = {},
                                    isVisible = true,
                                    onTrailingIconClick = {}
                                )
                                Input(
                                    value = "",
                                    onValueChange = {},
                                    hint = "--.--.----",
                                    focused = true
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
                                    items = listOf(
                                        SelectItem(label = "Мужской"),
                                        SelectItem(label = "Женский")
                                    ),
                                    selectedItemLabel = null,
                                    hint = "Пол",
                                    onItemClick = {}
                                )
                                Select(
                                    items = listOf(
                                        SelectItem(label = "Мужской"),
                                        SelectItem(label = "Женский")
                                    ),
                                    selectedItemLabel = "Мужской",
                                    hint = "Пол",
                                    onItemClick = {}
                                )
                                Select(
                                    items = listOf(
                                        SelectItem(
                                            label = "Гарвард Троцкий",
                                            icon = "👨"
                                        )
                                    ),
                                    selectedItemLabel = "Гарвард Троцкий",
                                    onItemClick = {}
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
                                    onClearClick = {},
                                    focused = true
                                )
                                SearchInput(
                                    value = "",
                                    onValueChange = {},
                                    hint = "Искать описание",
                                    onClearClick = {}
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
                                Chip(
                                    selected = true,
                                    label = "Популярные",
                                    onClick = {}
                                )
                                Chip(
                                    selected = false,
                                    label = "Популярные",
                                    onClick = {}
                                )
                                CartButton(
                                    price = 500,
                                    onClick = {}
                                )
                                LoginButton(
                                    label = "Войти с VK",
                                    icon = R.drawable.ic_vk,
                                    onClick = {}
                                )
                                LoginButton(
                                    label = "Войти с Yandex",
                                    icon = R.drawable.ic_yandex,
                                    onClick = {}
                                )
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                                ) {
                                    BackButton(
                                        onClick = {}
                                    )
                                    FilterButton(
                                        onClick = {}
                                    )
                                }
                            }
                        }
                        item {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                Text(
                                    text = "Tabbar",
                                    style = MatuleTheme.typography.title1ExtraBold
                                )
                                TabBar(
                                    items = tabBarItems,
                                    currentRoute = Route.Home::class.qualifiedName,
                                    onItemClick = {}
                                )
                                TabBar(
                                    items = tabBarItems,
                                    currentRoute = Route.Catalog::class.qualifiedName,
                                    onItemClick = {}
                                )
                                TabBar(
                                    items = tabBarItems,
                                    currentRoute = Route.Projects::class.qualifiedName,
                                    onItemClick = {}
                                )
                                TabBar(
                                    items = tabBarItems,
                                    currentRoute = Route.Profile::class.qualifiedName,
                                    onItemClick = {}
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}