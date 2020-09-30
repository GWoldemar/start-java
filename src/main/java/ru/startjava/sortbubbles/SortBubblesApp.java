package ru.startjava.sortbubbles;

import ru.startjava.core.GraphicsCore;

import java.awt.*;
import java.util.Random;

public class SortBubblesApp extends GraphicsCore {
    public static int[] mas = new int[300];

    @Override
    protected void showGraphics(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        int widthScreen = this.getWidth();
        int heightScreen = this.getHeight();
        // 1. Нарисовать ячейки ввиде прямоугольников
        // (массив из 8 элементов)
        // 2. Отобразить элементы массива в
        // прямоугольниках
        int posX = 25;
        int posXText = 45;
        int posY = 25;
        int posYText = 55;

        int widthSquare = 50;
        for (int j = 0; j < mas.length; j++){
            if (posX + widthSquare > widthScreen) {
                posX = 25;
                posXText = 45;
                posY += 55;
                posYText += 55;
            }

            graphics.drawRect(posX, posY, widthSquare, 50);
            graphics.drawString(String.valueOf(mas[j]), posXText, posYText);

            posX += 55;
            posXText += 55;
        }

        // 3. Вызвать метод сортировки
        // 4. Вынести в функцию
        sortBubbles();
    }

    private void sortBubbles() {
        for (int i = 0; i < mas.length - 1; i++) {
            if (mas[i] > mas[i + 1]) {
                int buf = mas[i];
                mas[i] = mas[i + 1];
                mas[i + 1] = buf;
            }
        }
    }

    public static void main(String[] args) {
        init();
        run(new SortBubblesApp(), "Sort Bubble");
    }

    private static void init() {
        for (int i = 0; i < mas.length; i++) {
            mas[i] = new Random().nextInt(mas.length);
        }
    }
}
