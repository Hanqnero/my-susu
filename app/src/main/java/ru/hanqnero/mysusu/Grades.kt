package ru.hanqnero.mysusu

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.hanqnero.mysusu.ui.theme.GAP_BIG
import ru.hanqnero.mysusu.ui.theme.TestrangeTheme

class Grades : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestrangeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    GreetingPreview2()
                }
            }
        }
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToComingActivity() {
        val intent = Intent(this, ComingActivity::class.java)
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
                IconButton(onClick = { /*TODO: Действие для брс кнопки */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.hat),
                        contentDescription = "БРС",
                        tint = Gray
                    )
                }
                IconButton(onClick = { navigateToComingActivity() }) {
                    Icon(
                        //TODO: imageVector = Icons.Default.Search,
                        painter = painterResource(id = R.drawable.flash),
                        contentDescription = "Последние новости",
                        tint = Gray
                    )
                }
                IconButton(onClick = { navigateToComingActivity() }) {
                    Icon(
                        //TODO: imageVector = Icons.Default.AccountCircle,
                        painter = painterResource(id = R.drawable.schedule),
                        contentDescription = "Расписание",
                        tint = Gray
                    )
                }
                IconButton(onClick = {
                    navigateToMainActivity()
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

    @Composable
    fun GradesRow(
        label: String,
        grade: Int
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 50.dp, max = 120.dp)
                .background(Color.White, RoundedCornerShape(6.dp))
                .shadow(elevation = 2.dp, shape = RoundedCornerShape(6.dp), spotColor = MaterialTheme.colorScheme.background)
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                SubjectLabel(label, modifier = Modifier.weight(0.8f))
                SubjectGrade(grade, modifier = Modifier.weight(0.4f))
            }
        }
    }

    @Composable
    fun SubjectLabel(
        text: String,
        modifier: Modifier = Modifier
    ) {
        Box(
            modifier = modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterStart,

            ) {
            Text(
                modifier = Modifier.padding(GAP_BIG),
                text = text,
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
            )
        }
    }

    @Composable
    fun SubjectGrade(
        grade: Int,
        modifier: Modifier = Modifier
    ) {
        Box(
            modifier = modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        )
        {
            Text(
                text = "$grade/100",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,

                )
        }
    }

    @Composable
    fun SectionTitle(text: String) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            color = Color(0xFF767676),
        )
    }

    @Preview(showSystemUi = true)
    @Composable
    fun GreetingPreview2() {

        TestrangeTheme {
            Scaffold(
                bottomBar = {
                    BottomBar()
                }
            ) { paddingValues ->
                // Основное содержимое приложения
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(GAP_BIG * 2)
                        .padding()
                        .verticalScroll(rememberScrollState()),
                ) {
                    SectionTitle("Оценки")
                    GradesRow("Экономика", 65)
                    GradesRow("Математический Анализ", 100)
                    GradesRow("Введение в ООП", 0)
                    GradesRow("Дискретная математика", 0)
                    GradesRow("Электротехника", 0)
                    GradesRow("Философия", 0)
                    GradesRow("Метрология", 0)
                    GradesRow("Физическая культура", 0)
                }
            }
        }
    }
}