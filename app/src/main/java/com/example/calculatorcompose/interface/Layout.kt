
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.calculatorcompose.data.ButtonType
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
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    textAlign = TextAlign.End

                )

                for (i in (1..5)) {
                    // Row 1 to 5
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        buttonsList.filter { it.position == "Row $i" }.forEach { button ->
                            CalculatorButton(button,
                                onClick = {
                                    if (button.type == ButtonType.NUMBER || button.type == ButtonType.OPERATION) {
                                        displayText += button.value
                                    } else if (button.name == "Clear") {
                                        displayText = ""
                                    } else if (button.name == "Backspace") {
                                        displayText = displayText.dropLast(1)
                                    } else if (button.name == "Equal") {
                                        displayText = calculatorOperations(displayText)
                                        println(displayText)
                                    }

                            })
                        }
                    }
                }
            }
        }
    }
}


fun calculatorOperations(string: String): String {
    val numbersList = mutableListOf<String>()
    val operationsList = mutableListOf<Char>()
    val operatorsList = arrayOf('+', '-', '*', '/')

    var catchNumber = ""
    numbersList.clear()
    operationsList.clear()

    // Initialize the string with a 0 so the app won't crash
    // when we start the calculation with an operation
    var calculateString = string.replaceRange(0,0,"0" )

    for (char in calculateString) {
        if (char != '+' && char != '-' && char != '/' && char != '*') {
            catchNumber += char
        } else {
            numbersList.add(catchNumber)
            operationsList.add(char)
            catchNumber = ""

        }
    }
    // Store last number
    if (catchNumber .isNotEmpty()) {
        numbersList.add(catchNumber)
    }

    var expression = ""
    var expressionResult = numbersList[0].toDouble()

        for (i in operationsList.indices) {
            val num = numbersList[i + 1].toDouble()

            when (operationsList[i]) {
                '+' ->
                    expressionResult += num
                '-' ->
                    expressionResult -= num
                '/' ->
                    if (num != 0.0 || num.toInt() != 0) {
                        expressionResult /= num
                    } else {
                        operationsList.clear()
                        numbersList.clear()
                    }
                '*' -> expressionResult *= num
            }
            expression += numbersList[i] + operatorsList[i] + numbersList[i + 1]
        }


    return if (expressionResult % 1 == 0.0) expressionResult.toInt().toString()
    else expressionResult.toString()

//    numbersListShow.text = "${numbersList}"
//    operationsListShow.text = "${operationsList}"
//    Toast.makeText(this@MainActivity, "Expression is: $expression", Toast.LENGTH_SHORT).show()
}