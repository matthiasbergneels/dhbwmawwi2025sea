package lecture.chapter10;

import javax.swing.*;
import java.awt.*;

public class MyFirstFrame {

  static void main() {

    JFrame myFirstFrame = new JFrame();



    myFirstFrame.add(new JButton("Aus"));
    myFirstFrame.add(new JLabel("Hallo Welt:"), BorderLayout.NORTH);

    myFirstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //myFirstFrame.pack();
    myFirstFrame.setSize(500, 500);
    myFirstFrame.setVisible(true);

  }

}
