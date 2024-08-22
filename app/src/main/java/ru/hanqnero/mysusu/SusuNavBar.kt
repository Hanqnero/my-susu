package ru.hanqnero.mysusu

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class SusuNavBar {

    class NavBarItem(
        val title: String,
        val iconSelected: ImageVector,
        val iconDeselected: ImageVector,
    )


    @Preview(showSystemUi = true)
    @Composable
    fun NavBar() {
        var selectedItemIndex by rememberSaveable {
            mutableIntStateOf(0)
        }

        val items = listOf(
            NavBarItem(
                stringResource(R.string.button_navbar_home),
                ImageVector.vectorResource(R.drawable.button_navbar_home_filled),
                ImageVector.vectorResource(R.drawable.button_navbar_home_outlined),
            ),
            NavBarItem(
                stringResource(R.string.button_navbar_schedule),
                ImageVector.vectorResource(R.drawable.baseline_calendar_month_24),
                ImageVector.vectorResource(R.drawable.outline_calendar_month_24),
            ),
            NavBarItem(
                stringResource(R.string.button_navbar_today),
                ImageVector.vectorResource(R.drawable.button_navbar_today_filled),
                ImageVector.vectorResource(R.drawable.button_navbar_today_outlined),
            ),
            NavBarItem(
                stringResource(R.string.button_navbar_grades),
                Icons.Filled.Done,
                Icons.Outlined.Done,
            ),
        )

        Scaffold(bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(selected = index == selectedItemIndex, onClick = {
                        selectedItemIndex = index
                    }, icon = {
                        Icon(
                            imageVector = if (selectedItemIndex == index) {
                                item.iconSelected
                            } else {
                                item.iconDeselected
                            },
                            contentDescription = item.title
                        )
                    },
                        label = {Text(item.title)})
                }
            }
        }) { innerPadding ->
            Box(
                modifier = Modifier.padding(innerPadding)
            ) {

            }
        }
    }

    @Composable
    fun BottomBar() { //a row of button objects
        BottomAppBar(
            // Фон и высота панели
            modifier = Modifier.height(56.dp), containerColor = White
        ) {
            // Содержимое панели
            Row( //строка нижней панели
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /*TODO: Действие для брс кнопки */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.hat), contentDescription = "БРС", tint = Gray
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        //TODO: imageVector = Icons.Default.Search,
                        painter = painterResource(id = R.drawable.flash),
                        contentDescription = "Последние новости",
                        tint = Gray
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        //TODO: imageVector = Icons.Default.AccountCircle,
                        painter = painterResource(id = R.drawable.schedule),
                        contentDescription = "Расписание",
                        tint = Gray
                    )
                }
                IconButton(onClick = {
                    // Переход на домашнюю страницу при нажатии на иконку
                }) {
                    Icon(
                        //TODO: imageVector = Icons.Default.AccountCircle,
                        painter = painterResource(id = R.drawable.homepage_icon),
                        contentDescription = "Домашняя страница",
                        tint = Gray
                    )
                }
            }
        }
    }
}