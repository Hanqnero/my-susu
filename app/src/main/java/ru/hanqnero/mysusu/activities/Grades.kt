package ru.hanqnero.mysusu.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.hanqnero.mysusu.ui.theme.GAP_BIG
import ru.hanqnero.mysusu.ui.theme.MySusuTheme

class Grades : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySusuTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    GradesRow("Test", 56)
                }
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
            .background(Color.White, RoundedCornerShape(16.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
        ) {
            SubjectLabel(label, modifier = Modifier.weight(0.8f))
            SubjectGrade(grade, modifier = Modifier.weight(0.4f))
        }
        Divider(color = Color.LightGray, thickness = 1.dp)
    }
}

@Composable
fun SubjectLabel(
    text: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
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
    modifier: Modifier = Modifier) {
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
fun GradesScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(GAP_BIG *2)
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

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    MySusuTheme {
    }
}