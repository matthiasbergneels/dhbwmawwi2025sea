package lecture.chapter10;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutExampleFrame extends JFrame {

  public FlowLayoutExampleFrame() {
    super("FlowLayout Example Frame");

    this.setLayout(new FlowLayout(FlowLayout.CENTER));

    this.add(new JLabel("Bitte den Namen eingeben: "));
    this.add(new JTextField(20));
    this.add(new JButton("Grüßen"));

    this.pack();
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  static void main() {
    SwingUtilities.invokeLater(()->{
      new FlowLayoutExampleFrame();
    });
  }

}
