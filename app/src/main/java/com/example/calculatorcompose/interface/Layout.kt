
import android.media.VolumeShaper.Operation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorcompose.data.CalculatorButton
import com.example.calculatorcompose.data.buttonsList

@Composable
fun CalculatorScreen(onButtonClick: (String) -> Unit) {
    var displayText by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .padding(16.dp)
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = displayText,
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    textAlign = TextAlign.End // Align text to the right

                )

                for (i in (1..5)) {
                    // Row 1 to 5
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        buttonsList.filter { it.position == "Row ${i}" }.forEach { button ->
                            CalculatorButton(button, onClick = {})
                        }
                    }
                }
            }
        }
    }
}

