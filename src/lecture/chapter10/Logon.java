package lecture.chapter10;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class Logon extends JFrame {

  // Component Name Constants
  private static final String COMPONENT_NAME_PORT_INPUTFIELD = "PORT_INPUTFIELD";

  enum PROTOCOLS{
    SSH(22), FTP(21), HTTP(80), HTTPS(443);

    private int standardPort;

    PROTOCOLS(int standardPort){
      this.standardPort = standardPort;
    }

    public int getStandardPort(){
      return standardPort;
    }

    @Override
    public String toString() {
      return switch (this) {
        case HTTPS -> "HTTP(s)";
        default -> super.toString();
      };
    }
  }

  // Instanzattribute
  private final JFormattedTextField portField;

  private Logon() throws ParseException {
    super();
    this.setTitle("Logon");
    //this.setResizable(false);

    //JComboBox<String> myComboBox = new JComboBox<>(new String[]{"SSH", "FTP", "HTTP", "HTTPS"});
    JComboBox<PROTOCOLS> myComboBox = new JComboBox<>(PROTOCOLS.values());

    portField = new JFormattedTextField(new MaskFormatter("#####"));
    portField.setColumns(3);

    myComboBox.addItemListener(new ComboBoxEventListener());

    myComboBox.addItemListener((event)->{
      if(event.getStateChange() == ItemEvent.SELECTED) {
        System.out.println("Infos - Internal ItemListener Lambda Function");
        System.out.println("Item: " + event.getItem());
        System.out.println("State Change: " + event.getStateChange());
        System.out.println("Parameters: " + event.paramString());

        PROTOCOLS protocolType = (PROTOCOLS) event.getItem();
        portField.setText("" + protocolType.getStandardPort());

        /*if(protocolType.equals(PROTOCOLS.SSH)){
          portField.setText("" + protocolType.getStandardPort());
        }else if(protocolType.equals(PROTOCOLS.FTP)){
          portField.setText("21");
        }else if(protocolType.equals(PROTOCOLS.HTTP)){
          portField.setText("80");
        }else if(protocolType.equals(PROTOCOLS.HTTPS)){
          portField.setText("443");
        }

         */
      }

      System.out.println("Item Event Verarbeitung - " + Thread.currentThread());
    });

    /* --> ItemListener als Anonyme Klasse
    myComboBox.addItemListener(new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED) {
          System.out.println("Item: " + e.getItem());
          System.out.println("State Change: " + e.getStateChange());
          System.out.println("Parameters: " + e.paramString());
        }

      }
    });
     */

    // initialize Panels
    JPanel mainPanel = new JPanel(new BorderLayout());

    JPanel southPanel = new JPanel(new FlowLayout());
    JPanel centerPanel = new JPanel(new FlowLayout());

    JPanel connectionPanel = new JPanel(new GridLayout(0, 2));
    JPanel filePanel = new JPanel(new GridLayout(0, 2));

    FlowLayout cellFlowLayout = new FlowLayout(FlowLayout.LEFT);

    //create and assign elements for connection area
    JPanel flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JLabel("User:"));
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    JTextField userNameField = new JTextField(3);
    flowLayoutForCell.add(userNameField);
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JLabel("Passwort:"));
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    JPasswordField userPasswordField = new JPasswordField(3);
    flowLayoutForCell.add(userPasswordField);
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JLabel("Art:"));
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(myComboBox);
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JLabel("Host:"));
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    JTextField host = new JTextField(5);
    flowLayoutForCell.add(host);
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JLabel("Port:"));
    connectionPanel.add(flowLayoutForCell);
    connectionPanel.add(portField);

    // create and add Fields for File Area
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JLabel("Quelle:"));
    filePanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JTextField(10));
    filePanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JLabel("Ziel:"));
    filePanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JTextField(10));
    filePanel.add(flowLayoutForCell);

    // create & assign Buttons
    JButton okButton = new JButton("Login");
    JButton cancelButton = new JButton("Beenden");

    ActionListener buttonActionListener = (actionEvent)->{
      System.out.println("Infos zu Button Action:");
      System.out.println("Action Command: " + actionEvent.getActionCommand());
      System.out.println("Timestamp: " + actionEvent.getWhen());
      System.out.println("Modifiers: " + actionEvent.getModifiers());
      System.out.println("Parameter String: " + actionEvent.paramString());

      System.exit(0);
    };

    okButton.addActionListener(buttonActionListener);
    cancelButton.addActionListener(buttonActionListener);

    southPanel.add(okButton);
    southPanel.add(cancelButton);

    // create and assign Borders
    Border etchedBorder = BorderFactory.createEtchedBorder();
    Border connectionBorder = BorderFactory.createTitledBorder(etchedBorder, "Verbindung");
    Border fileBorder = BorderFactory.createTitledBorder(etchedBorder, "Datei");
    Border centerBorder = BorderFactory.createBevelBorder(BevelBorder.LOWERED);

    connectionPanel.setBorder(connectionBorder);
    filePanel.setBorder(fileBorder);
    centerPanel.setBorder(centerBorder);

    // combine Panels
    centerPanel.add(connectionPanel);
    centerPanel.add(filePanel);

    mainPanel.add(centerPanel, BorderLayout.CENTER);
    mainPanel.add(southPanel, BorderLayout.SOUTH);

    this.add(mainPanel);

    // set JFrame behavior
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.pack();
  }

  public static void main(String[] args) throws ParseException{

    // using invokeLater for safe parallel processing
    SwingUtilities.invokeLater(() -> {
        JFrame logonUI = null;
        try {
          logonUI = new Logon();
          logonUI.setVisible(true);
        } catch (ParseException e) {
          throw new RuntimeException(e);
        }

        System.out.println("Starting UI-Frame - " + Thread.currentThread());
      }
    );
    System.out.println("Added UI-Frame to starting queue - " + Thread.currentThread());
  }

}