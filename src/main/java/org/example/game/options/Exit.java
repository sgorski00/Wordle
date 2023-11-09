package org.example.game.options;

import org.example.Input;
import org.example.util.HibernateUtil;

public class Exit {
    public static void exit(){
        System.out.println("Thanks for playing!");
        Input.closeScanner();
        HibernateUtil.shutdown();
        System.exit(0);
    }
}
