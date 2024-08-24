package ru.hanqnero.mysusu.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.hanqnero.mysusu.SusuNavBar
import ru.hanqnero.mysusu.ui.theme.MySusuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySusuTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val navBar = SusuNavBar()
                    navBar.NavBar()
                }
            }
        }
    }
}

val GAP_SMALL = 6.dp
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
fun SectionTitle(
    text: String
) {
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
                    .fillMaxHeight(),
            ) {
                SquareMenuButton(
                    "Коворкинги", modifier = Modifier.weight(0.5f),
                    onClick = {}
                )
                SquareMenuButton(
                    "Парковка",
                    modifier = Modifier.weight(0.5f),
                    onClick = {}
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                SquareMenuButton(
                    "Турникет",
                    modifier = Modifier.weight(0.5f),
                    onClick = {})
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
                onClick = {}
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
fun ServicesScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(GAP_BIG * 2)
                .padding(top = GAP_BIG * 2)
                .verticalScroll(rememberScrollState()),
        ) {

            SectionTitle("Сервисы")
            CampusBlock()
            AdministrativeBlock()
            CommunicationBlock()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MainMenuViewPreview() {
    MySusuTheme {
        ServicesScreen()
    }
}
