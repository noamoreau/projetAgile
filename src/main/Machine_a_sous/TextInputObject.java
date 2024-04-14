package main.Machine_a_sous;

import main.App;

/**
 * TextInputObject
 */
public class TextInputObject extends Thread {

  public void run(){
    try {
        Machine_a_sous.rep = App.scanner.nextLine();
    }catch(Exception ignored) {}
    
  }
}