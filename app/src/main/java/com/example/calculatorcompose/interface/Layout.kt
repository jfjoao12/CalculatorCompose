
import android.media.VolumeShaper.Operation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.calculatorcompose.data.CalculatorButton
import com.example.calculatorcompose.data.buttonsList

@Composable
fun CalculatorScreen(onButtonClick: (String) -> Unit) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(16.dp)) {
            }

            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                buttonsList.forEach{ button ->
                    var i = 0;
                    if (buttonsList[i].position == "Row 1") {
                        CalculatorButton(buttonsList[i], onClick = onButtonClick)
                    }
                    i++
                }

                }
            }
//            LazyVerticalGrid(
//                columns = GridCells.Fixed(4),
//                modifier = Modifier.weight(3f)
//            ) {
//                items(buttonsList.size) { index ->
//                    CalculatorButton(buttonsList[index], onClick = onButtonClick)
//                }
//            }
}

