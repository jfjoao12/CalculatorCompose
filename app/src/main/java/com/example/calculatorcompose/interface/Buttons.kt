import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorcompose.data.ButtonType
import com.example.calculatorcompose.data.CalculatorButton

@Composable
fun CalculatorButton(button: CalculatorButton, onClick: (String) -> Unit) {
    Button(
        onClick = { onClick(button.value) },
        modifier = Modifier
            .padding(4.dp)
            .size(80.dp),
        shape = RoundedCornerShape(60.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor =
            if (button.type == ButtonType.NUMBER) {
                Color.Gray
            }
            else if (button.type == ButtonType.CONTROL) {
                Color(0XFFFF9800)
            } else {
                Color.Blue
            }
        )
    ) {
        Text(button.name, fontSize = 24.sp,
            color = if (button.type == ButtonType.CONTROL) Color.Black else Color.White)
    }
}
