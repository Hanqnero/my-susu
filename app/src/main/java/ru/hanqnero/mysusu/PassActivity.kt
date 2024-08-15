package ru.hanqnero.mysusu

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.hanqnero.mysusu.ui.theme.TestrangeTheme

class PassActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestrangeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    qrCode()
                }
            }
        }
    }

    // Перемещаем функцию внутрь класса, чтобы использовать `this` для контекста
    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToComingActivity() {
        val intent = Intent(this, ComingActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToGrades() {
        val intent = Intent(this, Grades::class.java)
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
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { navigateToGrades() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.hat),
                        contentDescription = "БРС",
                        tint = Gray
                    )
                }
                IconButton(onClick = { navigateToComingActivity() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.flash),
                        contentDescription = "Последние новости",
                        tint = Gray
                    )
                }
                IconButton(onClick = { navigateToComingActivity() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.schedule),
                        contentDescription = "Расписание",
                        tint = Gray
                    )
                }
                IconButton(onClick = { navigateToMainActivity() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.homepage_icon),
                        contentDescription = "Домашняя страница",
                        tint = Gray
                    )
                }
            }
        }
    }

    @Composable
    fun qrCode() {
        TestrangeTheme {
            Scaffold(
                bottomBar = {
                    BottomBar()
                }
            ) { paddingValues ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    Column(
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .padding(top = 150.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.qr),
                            contentDescription = "QR code",
                            modifier = Modifier.size(350.dp)
                        )
                        Spacer(modifier = Modifier.height(18.dp))
                        Text(
                            text = "Прибылов Артемий МЕН-230206",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        TestrangeTheme {
            qrCode()
        }
    }
}
