package ru.hanqnero.mysusu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import ru.hanqnero.mysusu.activities.GradesScreen
import ru.hanqnero.mysusu.activities.ServicesScreen

class SusuNavBar {
    class NavBarItem(
        val title: String,
        val iconSelected: ImageVector,
        val iconDeselected: ImageVector,
    )

    @Composable
    fun NavBar(
        // content: @Composable BoxScope.() -> Unit
    ) {

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
                        label = { Text(item.title) })
                }
            }
        }) { innerPadding ->
            Box(
                modifier = Modifier.padding(innerPadding)
            ) {
                when (selectedItemIndex) {
                    0 -> ServicesScreen()
                    1 -> ServicesScreen()
                    2 -> ServicesScreen()
                    3 -> GradesScreen()
                }
            }
        }
    }
}

//    @Preview(showSystemUi = true)
//    @Composable
//    fun SusuNavBarPreview() {
//        NavBar {
//            Box(
//                modifier = Modifier.fillMaxSize().background(Red),
//            )
//        }
//    }
//}