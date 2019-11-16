package org.machine;

import java.awt.*;

public class Bullet {
    /**
     * 子弹速度
     * */
    private static final int SPEED = 10;
    /**
     * 子弹方向
     * */
    private Dir dir;
    /**
     * 子弹位置
     * */
    private int x, y;
    /**
     * 子弹大小
     * */
    private static final int WIDTH = 5,HEIGHT = 5;

    public Bullet() {
    }

    public Bullet(Dir dir, int x, int y) {
        this.dir = dir;
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y,WIDTH,HEIGHT);
        g.setColor(color);
        move();
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
    }
}
