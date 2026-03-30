package lecture.chapter10;

import javax.swing.*;
import java.awt.*;

public class GridLayoutExampleFrame extends JFrame {

  GridLayoutExampleFrame(){
    super("GridLayout Example Frame");

    this.setLayout(new GridLayout(0,3));

    Panel panel = new Panel();
    panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5,5));
    panel.add(new JLabel("Bitte den Namen eingeben: "));
    panel.add(new JButton("Button 10"));

    this.add(new JButton("Button 1"));
    this.add(new JButton("Button 2"));
    this.add(new JButton("Button 3"));
    this.add(new JButton("Button 4"));
    this.add(new JButton("Button 5000000000000000000000000000000"));
    this.add(new JButton("Button 6"));
    this.add(new JButton("Button 7"));
    this.add(new JButton("Button 8"));
    this.add(new JButton("Button 9"));
    this.add(panel);

    this.pack();
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  static void main() {
    SwingUtilities.invokeLater(()->{
      new GridLayoutExampleFrame();
    });
  }
}
