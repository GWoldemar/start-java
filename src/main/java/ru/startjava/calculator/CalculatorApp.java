package ru.startjava.calculator;

import ru.startjava.core.GraphicsCore;

import java.awt.*;

public class CalculatorApp extends GraphicsCore {
    @Override
    protected void showGraphics(Graphics graphics) {
        // Макет калькулятора
    }

    public static void main(String[] args) {
        run(new CalculatorApp(), "Calculator");
    }
}
