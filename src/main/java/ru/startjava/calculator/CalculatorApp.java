package ru.startjava.calculator;

import ru.startjava.core.GraphicsCore;

import java.awt.*;
import java.util.Arrays;

public class CalculatorApp extends GraphicsCore {
    private int x = 0;
    private int y = 0;
    private TextField textField = new TextField();

    private Point getCursorLocation() {
        return MouseInfo.getPointerInfo()
                .getLocation();
    }

    private int getCursorCoordinateX() {
        return getCursorLocation().x;
    }

    private int getCursorCoordinateY() {
        return getCursorLocation().y;
    }

    @Override
    protected void showGraphics(Graphics graphics) {
        // Макет калькулятора
        graphics.setColor(Color.BLACK);

        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        char[] operations = new char[]{'+', '-', '*', '/'};

        int widthScreen = this.getWidth();

        int posX = 10;
        int posY = 140;

        int posXTeXt = 40;
        int posYText = 175;

        int widthSquare = 50;

        int posXX = 225;
        int posYY = 140;

        int posYT = 175;
        for (int j = 0; j < operations.length; j++) {
            graphics.drawRect(posXX, posYY, 60, 60);
            graphics.drawString(String.valueOf(operations[j]), 255, posYT);
            posYY += 65;
            posYT += 65;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (posX + widthSquare > widthScreen - 100) {
                posX = 10;
                posY += 65;

                posXTeXt = 30;
                posYText += 65;
            }

            if (isMouseClick) {
                if ((mousePosX >= posX && mousePosX <= posX + 60) && (mousePosY >= posY && mousePosY <= posY + 60)) {
                    System.out.println("Click key: " + numbers[i]);
                    isMouseClick = false;
                    String newSymbol = String.valueOf(numbers[i]);
                    String oldSymbol = textField.getText();
                    textField.setText(oldSymbol + newSymbol);
                    textField.setCaretPosition(textField.getText().length());
                }

            }

            graphics.drawRect(posX, posY, 60, 60);
            graphics.drawString(String.valueOf(numbers[i]), posXTeXt, posYText);
            posX += 65;
            posXTeXt += 65;
        }

        int XRes = 75;
        int YRes = 335;
        graphics.drawRect(XRes, YRes, 125, 60);
        graphics.drawString("=", 135, 370);

        if (Arrays.stream(this.getComponents()).allMatch(component -> component != textField)) {
            graphics.drawRect(10, 50, widthScreen - 25, 50);
            Font font = new Font("Family", Font.BOLD, 32);
            textField.setFont(font);
            textField.setPreferredSize(new Dimension(widthScreen - 25, 50));
            this.add(textField);
        }

    }

    public static void main(String[] args) {
        run(new CalculatorApp(), "Calculator");
    }
}
