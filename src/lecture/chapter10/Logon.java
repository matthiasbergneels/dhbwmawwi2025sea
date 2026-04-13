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

  private final String ACTION_LOGIN = "LOGIN";
  private final String ACTION_BEENDEN = "CLOSE";

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
    okButton.setActionCommand(ACTION_LOGIN);
    JButton cancelButton = new JButton("Beenden");
    cancelButton.setActionCommand(ACTION_BEENDEN);

    ActionListener buttonActionListener = (actionEvent)->{
      System.out.println("Infos zu Button Action:");
      System.out.println("Action Command: " + actionEvent.getActionCommand());
      System.out.println("Timestamp: " + actionEvent.getWhen());
      System.out.println("Modifiers: " + actionEvent.getModifiers() + " - " + Integer.toBinaryString(actionEvent.getModifiers()));
      System.out.println("Parameter String: " + actionEvent.paramString());

      /* --> Funktioniert aber nur für genau diesen Button
      if(actionEvent.getSource() == cancelButton){
        System.exit(0);
      }
       */

      System.out.println("Steuerung: " + ActionEvent.CTRL_MASK + " - " + Integer.toBinaryString(ActionEvent.CTRL_MASK));
      System.out.println("Alt / Option: " + ActionEvent.ALT_MASK + " - " + Integer.toBinaryString(ActionEvent.ALT_MASK));
      System.out.println("Windows / Command: " + ActionEvent.META_MASK + " - " + Integer.toBinaryString(ActionEvent.META_MASK));
      System.out.println("Shift: " + ActionEvent.SHIFT_MASK + " - " + Integer.toBinaryString(ActionEvent.SHIFT_MASK));

      // Beispiel:
      // Modifier   10100 (Command gedrückt)
      // META_MASK &00100
      //            00100 --> Identisch zur Maske, also wurde die Taste gedrückt
      if((actionEvent.getModifiers() & ActionEvent.META_MASK) == ActionEvent.META_MASK){
        System.out.println(" -> Windows Taste / Command Taste gedrückt!");
      }

      if(actionEvent.getActionCommand().equals(ACTION_BEENDEN)){
        System.exit(0);
      }else if(actionEvent.getActionCommand().equals(ACTION_LOGIN)){
        System.out.println("Login mit Protokoll: " + myComboBox.getSelectedItem() + " auf Port: " + portField.getText());
      }
    };

    okButton.addActionListener(buttonActionListener);
    cancelButton.addActionListener(buttonActionListener);

    southPanel.add(okButton);
    southPanel.add(cancelButton);

    // Lambda Funktion nicht möglich --> mehrere Methoden im Interface zu implementieren
    okButton.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {

      }

      @Override
      public void mousePressed(MouseEvent e) {

      }

      @Override
      public void mouseReleased(MouseEvent e) {

      }

      @Override
      public void mouseEntered(MouseEvent e) {
        JButton currentButton = (JButton)e.getSource();
        currentButton.setText("Nicht drücken!");

      }

      @Override
      public void mouseExited(MouseEvent e) {
        JButton currentButton = (JButton)e.getSource();
        currentButton.setText("Login");

      }
    });

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

    // add JMenuBar --> Swing Menü
    JMenuBar logonMenuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("Datei");
    JMenuItem loginMenuItem = new JMenuItem("Einloggen");
    loginMenuItem.setActionCommand(ACTION_LOGIN);
    loginMenuItem.addActionListener(buttonActionListener);
    JMenuItem closeMenuItem = new JMenuItem("Schliessen");
    closeMenuItem.setActionCommand(ACTION_BEENDEN);
    closeMenuItem.addActionListener(buttonActionListener);

    fileMenu.add(loginMenuItem);
    fileMenu.add(closeMenuItem);

    logonMenuBar.add(fileMenu);

    this.setJMenuBar(logonMenuBar);

    // add Menubar --> AWT
    MenuBar logonMenuBarAWT = new MenuBar();
    Menu fileMenuAWT = new Menu("Datei");
    MenuItem loginMenuItemAWT = new MenuItem("Einloggen");
    loginMenuItemAWT.setActionCommand(ACTION_LOGIN);
    loginMenuItemAWT.addActionListener(buttonActionListener);
    MenuItem closeMenuItemAWT = new MenuItem("Schliessen");
    closeMenuItemAWT.setActionCommand(ACTION_BEENDEN);
    closeMenuItemAWT.addActionListener(buttonActionListener);

    fileMenuAWT.add(loginMenuItemAWT);
    fileMenuAWT.add(closeMenuItemAWT);

    logonMenuBarAWT.add(fileMenuAWT);

    this.setMenuBar(logonMenuBarAWT);


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