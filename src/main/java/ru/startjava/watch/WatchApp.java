package ru.startjava.watch;

import ru.startjava.core.GraphicsCore;

import java.awt.*;
import java.time.LocalDateTime;

import static java.lang.Math.*;

public class WatchApp extends GraphicsCore {
    public WatchApp() {
        super();
    }

    private int getHour() {
        return LocalDateTime.now().getHour();
    }

    private int getMinute() {
        return LocalDateTime.now().getMinute();
    }

    private int getSecond() {
        return LocalDateTime.now().getSecond();
    }

    @Override
    protected void showGraphics(Graphics graphics) {
//        graphics.setColor(Color.GREEN);
//        graphics.drawOval(100, 200, 100, 100);
//        graphics.fillOval(); // центр
//        graphics.setColor(Color.MAGENTA);
//        graphics.drawString(String.valueOf(12), 20, 20);
        // 1. Нарисовать окружность
        graphics.setColor(Color.BLACK);
        graphics.drawOval(20,20,550,550);
        // 2. Нарисовать циферблат
        for (int i = 1; i <= 12; i++) {
            final int xt = (int) (295 + round(240 * sin(6.28 * 30 * i / 360)));
            final int yt = (int) (295 - round(240 * cos(6.28 * 30 * i / 360)));
            // отобразить число
            graphics.drawString(String.valueOf(i),xt,yt);
        }

        // 3. Нарисовать центр
        graphics.fillOval(295,295,10,10);

        // 4. Нарисовать минутную стрелку
        // i = 12
        final int xm = (int) (300 + round(240 * sin(6.28 * getMinute() / 60)));
        final int ym = (int) (300 - round(240 * cos(6.28 * getMinute() / 60)));
        graphics.drawLine(300,300,xm,ym);

        // 5. Нарисовать часовую стрелку
        // i = 4
        final int xh = (int) (300 + round(150 * sin(6.28 * getHour() / 12)));
        final int yh = (int) (300 - round(150 * cos(6.28 * getHour() / 12)));
        graphics.drawLine(300,300,xh,yh);

        // 6. Нарисовать секундную стрелку
        // i = 10
        final int xs = (int) (300 + round(200 * sin(6.28 * getSecond() / 60)));
        final int ys = (int) (300 - round(200 * cos(6.28 * getSecond() / 60)));
        graphics.setColor(Color.RED);
        graphics.drawLine(300,300,xs,ys);
    }

    public static void main(String[] args) {
        run(new WatchApp(), "Watch");
    }
}
