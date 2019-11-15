package org.machine;

import java.util.concurrent.TimeUnit;

public class T {
    public static void main(String[] args) {
        TankFrame tf = new TankFrame();
        while (true){
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                tf.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
