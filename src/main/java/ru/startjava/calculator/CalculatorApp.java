package ru.startjava.calculator;

import ru.startjava.core.GraphicsCore;

import java.awt.*;

public class CalculatorApp extends GraphicsCore {
    @Override
    protected void showGraphics(Graphics graphics) {
        // Макет калькулятора
        graphics.setColor(Color.BLACK);

        int num[] = new int[]{1,2,3,4,5,6,7,8,9,0};
        char fun[] = new char[]{'+','-','*','/'};


        int widthScreen = this.getWidth();

        int posX = 10;
        int posY = 140;

        int posXTeXt = 40;
        int posYText = 175;

        int widthSquare = 50;

         int posYY = 140;
        int posYT = 175;
        for (int j = 0; j < fun.length;j++){
            graphics.drawRect(225,posYY,60,60);
            graphics.drawString(String.valueOf(fun[j]),255,posYT);
            posYY += 65;
            posYT += 65;
        }

        for (int i = 0; i < num.length; i++) {
            if (posX + widthSquare > widthScreen - 100) {
                posX = 10;
                posY += 65;

                posXTeXt = 30;
                posYText += 65;
            }
            graphics.drawRect(posX, posY, 60, 60);
            graphics.drawString(String.valueOf(num[i]), posXTeXt, posYText);
            posX += 65;
            posXTeXt +=65;
        }
        graphics.drawRect(75,335,125,60);
        graphics.drawString("=",135,370);
    }

    public static void main(String[] args) {
        run(new CalculatorApp(), "Calculator");
    }
}
