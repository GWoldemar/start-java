package ru.startjava.sortbubbles;

import ru.startjava.core.GraphicsCore;

import java.awt.*;

public class SortBubblesApp extends GraphicsCore {
    public static int[] mas = {11, 3, 14, 16, 7, 1};

    @Override
    protected void showGraphics(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        // 1. Нарисовать ячейки ввиде прямоугольников
        // (массив из 8 элементов)
        graphics.drawRect(25, 25, 50, 50);
        graphics.drawString(String.valueOf(24), 45, 55);

        graphics.drawRect(80, 25, 50, 50);
        graphics.drawString(String.valueOf(47), 100, 55);

        graphics.drawRect(135, 25, 50, 50);
        graphics.drawString(String.valueOf(47), 155, 55);

        graphics.drawRect(190, 25, 50, 50);
        graphics.drawString(String.valueOf(47), 210, 55);

        graphics.drawRect(245, 25, 50, 50);
        graphics.drawString(String.valueOf(47), 265, 55);

        graphics.drawRect(300, 25, 50, 50);
        graphics.drawString(String.valueOf(47), 320, 55);

        graphics.drawRect(355, 25, 50, 50);
        graphics.drawString(String.valueOf(47), 375, 55);

        graphics.drawRect(410, 25, 50, 50);
        graphics.drawString(String.valueOf(47), 430, 55);


        // 2. Отобразить элементы массива в
        // прямоугольниках

        // 3. Вызвать метод сортировки
    }

    public static void main(String[] args) {
        // 4. Вынести в функцию
        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < mas.length - 1; i++) {
                if (mas[i] > mas[i + 1]) {
                    isSorted = false;

                    buf = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = buf;
                }
            }
        }
        // ...

        run(new SortBubblesApp(), "Sort Bubble");
    }
}
