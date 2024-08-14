package ru.hanqnero.testrange

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.hanqnero.testrange.ui.theme.TestrangeTheme

class ComingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestrangeTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ComingSoonView()
                }
            }
        }
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    @Composable
    fun BottomBar() { //a row of button oobjects
        BottomAppBar(
            // Фон и высота панели
            modifier = Modifier.height(56.dp),
            containerColor = White
        ) {
            // Содержимое панели
            Row( //строка нижней панели
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* Действие для брс кнопки */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.hat),
                        contentDescription = "БРС",
                        tint = Gray
                    )
                }
                IconButton(onClick = { /* Действие для новостей */ }) {
                    Icon(
                        //TODO: imageVector = Icons.Default.Search,
                        painter = painterResource(id = R.drawable.flash),
                        contentDescription = "Последние новости",
                        tint = Gray
                    )
                }
                IconButton(onClick = { /* Действие для профиля */ }) {
                    Icon(
                        //TODO: imageVector = Icons.Default.AccountCircle,
                        painter = painterResource(id = R.drawable.schedule),
                        contentDescription = "Расписание",
                        tint = Gray
                    )
                }
                IconButton(onClick = { navigateToMainActivity() }) {
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

    @Composable
    fun ComingSoonView() {
        Scaffold(
            bottomBar = {
                BottomBar()
            }
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                // Помещаем изображение в Box
                Image(
                    painter = painterResource(id = R.drawable.susu),
                    contentDescription = "susu logo",
                    colorFilter = ColorFilter.tint(Color.LightGray), // Изменение цвета изображения
                    modifier = Modifier
                        .size(350.dp)
                        .align(Alignment.Center) // Центрирование изображения в Box
                )

                // Содержимое экрана
                Text(
                    text = "В процессе разработки",
                    modifier = Modifier
                        .align(Alignment.TopCenter) // Центрирование текста в Box
                        .padding(16.dp).padding(top = 120.dp),
                    style = TextStyle(
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF767676),
                        textAlign = TextAlign.Center
                    )
                )
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    fun MainMenuViewPreview() {
        TestrangeTheme {
            ComingSoonView()
        }
    }
}
