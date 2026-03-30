package lecture.chapter10;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutExampleFrame extends JFrame {

  BorderLayoutExampleFrame() {
    super("Border Layout Example");

    //this.setLayout(new BorderLayout());

    Panel centerPanel = new Panel();
    centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    centerPanel.add(new JButton("Center Button"));

    this.add(centerPanel);
    this.add(new JButton("North Button"),  BorderLayout.NORTH);
    this.add(new JButton("South Button"),  BorderLayout.SOUTH);
    this.add(new JButton("East Button"),  BorderLayout.EAST);
    this.add(new JButton("West Button"),  BorderLayout.WEST);


    this.pack();
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  static void main() {
    SwingUtilities.invokeLater(()->{
      new BorderLayoutExampleFrame();
    });
  }
}
