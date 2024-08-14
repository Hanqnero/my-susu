package ru.hanqnero.testrange

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.hanqnero.testrange.ui.theme.TestrangeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestrangeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MainMenuView()
                }
            }
        }
    }


    private fun navigateToPassActivity() {
        val intent = Intent(this, PassActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToComingActivity() {
        val intent = Intent(this, ComingActivity::class.java)
        startActivity(intent)
    }


    val GAP_SMALL = 6.dp
    val GAP_MED = 8.dp
    val GAP_BIG = 12.dp

    @Composable
    fun SubSectionTitle(text: String) {
        Text(
            text = text,
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = GAP_BIG),
            color = Color(0xFF767676),
        )
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

    @Composable
    fun SquareMenuButton(
        text: String,
        onClick: () -> Unit = { },
        modifier: Modifier,
    ) {
        Button(
            modifier = modifier
                .padding(GAP_SMALL / 2)
                .fillMaxWidth(),
            onClick = onClick,
            shape = RoundedCornerShape(12.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart,
            ) {
                Surface(
                    color = Color(0xFF4E4195),
                    modifier = Modifier.fillMaxSize()
                ) {}
                Text(
                    modifier = Modifier.padding(GAP_SMALL),
                    text = text,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Left,
                    maxLines = 1,
                )
            }
        }
    }

    @Composable
    fun CampusBlock() {
        Column {
            Box(
                modifier = Modifier
                    .height(GAP_BIG * 3),
            )
            SubSectionTitle("Избранное")
            Row(
                modifier = Modifier
                    .heightIn(max = 140.dp, min = 100.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
//                    .padding(end = 0.dp)
                        .fillMaxHeight(),
//                verticalArrangement = Arrangement.spacedBy(GAP_SMALL),
                ) {
                    SquareMenuButton(
                        "Коворкинги", modifier = Modifier.weight(0.5f),
                        onClick = { navigateToComingActivity() }
                    )
                    SquareMenuButton(
                        "Парковка",
                        modifier = Modifier.weight(0.5f),
                        onClick = { navigateToComingActivity() }
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
//                    .padding(start = GAP_SMALL)
                        .fillMaxHeight()
                ) {
                    SquareMenuButton(
                        "Турникет",
                        modifier = Modifier.weight(0.5f),
                        onClick = { navigateToPassActivity() })
                }
            }
        }
    }

    @Composable
    fun AdministrativeBlock() {
        Column {
            Box(
                modifier = Modifier.padding(top = GAP_BIG * 3)
            )
            SubSectionTitle("Учеба")

            Row(
                modifier = Modifier
                    .heightIn(max = 80.dp, min = 50.dp)
                    .fillMaxWidth(),
            ) {
                SquareMenuButton(
                    "Расписание",
                    modifier = Modifier.weight(1f),
                    onClick = { navigateToComingActivity() }
                )
                SquareMenuButton("БРС", modifier = Modifier.weight(1f))
            }
        }
    }

    @Composable
    fun CommunicationBlock() {
        Box(modifier = Modifier.padding(top = GAP_BIG * 3))
        SubSectionTitle("Коммуникации")

        Row(
            modifier = Modifier
                .heightIn(max = 120.dp, min = 100.dp)
                .fillMaxWidth(),
        ) {
            Column(modifier = Modifier.weight(1f)) {
                SquareMenuButton("", modifier = Modifier.weight(1f))
            }
            Column(modifier = Modifier.weight(1f)) {
                SquareMenuButton("", modifier = Modifier.weight(1f))
                SquareMenuButton("", modifier = Modifier.weight(1f))

            }

        }
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
    fun MainMenuView() {
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
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(GAP_BIG * 2)
                            .padding(top = GAP_BIG * 2)
                    ) {

                        SectionTitle("Сервисы")
                        CampusBlock()
                        AdministrativeBlock()
                        CommunicationBlock()
                    }
                }
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    fun MainMenuViewPreview() {
        TestrangeTheme {
            MainMenuView()
        }
    }
}

