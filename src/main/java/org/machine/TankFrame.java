package org.machine;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class TankFrame extends Frame {
    Tank myTank = new Tank(200,200,Dir.LEFT);
    Bullet bullet = new Bullet(Dir.LEFT,200,200);
    private static boolean bL = false;
    private static boolean bR = false;
    private static boolean bU = false;
    private static boolean bD = false;

    public TankFrame(){
          this.setSize(480,640);
          this.setTitle("坦克大战");
          this.setResizable(true);
          this.setVisible(true);
          this.addKeyListener(new MyKeyAdapter());
          this.addWindowListener(new WindowAdapter() {
              @Override
              public void windowClosing(WindowEvent e) {
                  System.exit(0);
              }
          });
    }

    @Override
    public void paint(Graphics g) {
        myTank.paint(g);
        bullet.paint(g);
    }

    class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_LEFT:
                        bL = false;
                        break;
                    case KeyEvent.VK_UP:
                        bU = false;
                        break;
                    case KeyEvent.VK_RIGHT:
                        bR = false;
                        break;
                    case KeyEvent.VK_DOWN:
                        bD = false;
                        break;
                    default:
                        break;
            }
            setMainTankDir();
        }

        private void setMainTankDir(){
            if (!bL && !bU && !bR && !bD) {myTank.setMoving(false);}
            else {
                myTank.setMoving(true);
                if (bL) {myTank.setDir(Dir.LEFT);}
                if (bU) {myTank.setDir(Dir.UP);}
                if (bR) {myTank.setDir(Dir.RIGHT);}
                if (bD) {myTank.setDir(Dir.DOWN);}
            }
        }
    }
}
