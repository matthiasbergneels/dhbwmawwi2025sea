package lecture.chapter10;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ComboBoxEventListener implements ItemListener {
  @Override
  public void itemStateChanged(ItemEvent event) {
    System.out.println("Infos - External ItemListener Class");
    System.out.println("Item: " + event.getItem());
    System.out.println("State Change: " + event.getStateChange());
    System.out.println("Parameters: " + event.paramString());


  }
}
