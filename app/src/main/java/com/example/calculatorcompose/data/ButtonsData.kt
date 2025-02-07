package com.example.calculatorcompose.data

enum class ButtonType {
    NUMBER, OPERATION, CONTROL
}

data class CalculatorButton(
    val name: String,
    val type: ButtonType,
    val value: String,
    val position: String
)

val buttonsList = listOf(
    CalculatorButton("0", ButtonType.NUMBER, "0", "Row 5"),
    CalculatorButton("1", ButtonType.NUMBER, "1", "Row 4"),
    CalculatorButton("2", ButtonType.NUMBER, "2", "Row 4"),
    CalculatorButton("3", ButtonType.NUMBER, "3", "Row 4"),
    CalculatorButton("4", ButtonType.NUMBER, "4", "Row 3"),
    CalculatorButton("5", ButtonType.NUMBER, "5", "Row 3"),
    CalculatorButton("6", ButtonType.NUMBER, "6", "Row 3"),
    CalculatorButton("7", ButtonType.NUMBER, "7", "Row 2"),
    CalculatorButton("8", ButtonType.NUMBER, "8", "Row 2"),
    CalculatorButton("9", ButtonType.NUMBER, "9", "Row 2"),
    CalculatorButton("Equal", ButtonType.CONTROL, "=", "Row 4"),
    CalculatorButton("+", ButtonType.OPERATION, "+", "Row 3"),
    CalculatorButton("-", ButtonType.OPERATION, "-", "Row 2"),
    CalculatorButton(".", ButtonType.OPERATION, ".", "Row 5"),
    CalculatorButton("/", ButtonType.OPERATION, "/", "Row 1"),
    CalculatorButton("*", ButtonType.OPERATION, "*", "Row 1"),
    CalculatorButton("Clear", ButtonType.CONTROL, "C", "Row 1"),
    CalculatorButton("Backspace", ButtonType.CONTROL, "⌫", "Row 1")
)
