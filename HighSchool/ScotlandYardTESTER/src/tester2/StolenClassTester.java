package tester2;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;





public class StolenClassTester extends JFrame {

    private JPanel contentPane;


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
            	StolenClassTester frame = new StolenClassTester();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public StolenClassTester() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1080, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        StolenCodePanel();
    }







    // TODO make it so you can see the postition if it's misterX's turn and if you
    // click on it
    // create our way to know the methods of transports
    // and the labels that will hold them
    private JLabel[] numbers = new JLabel[25];
    private JLabel[] transports = new JLabel[25];


    private int flag = 0;
    private int round = 1;

    public void StolenCodePanel() {
        setLayout(null);
        // setting the box to be 200x100
        setBounds(1366 - 250, 708 - 300, 400, 280);
        // setting the background to a custom rgb value (light blue)
        setBackground(new ColorUIResource(150, 150, 255));

        // creating our title with a fancy font
        JLabel title = new JLabel("Travel Log", SwingConstants.CENTER);
        title.setBounds(0, 0, 200, 40);
        title.setFont(new Font("Century Gothic", Font.PLAIN, 30));

        // add the title
        add(title);
        // create our labels and update the text
        createLabels();

        //The buttons to simulate a player moving
        JButton btnNewButton = new JButton("Taxi");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                flag = 1;
                determineTransport();
            }
        });
        btnNewButton.setBounds(285, 11, 89, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Bus");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                flag = 2;
                determineTransport();
            }
        });
        btnNewButton_1.setBounds(285, 110, 89, 23);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Tube");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                flag = 3;
                determineTransport();
            }
        });
        btnNewButton_2.setBounds(285, 191, 89, 23);
        contentPane.add(btnNewButton_2);



    }


    public void determineTransport() {
    	
    	
        ImageIcon icon = null;
        if(flag == 1) {
            icon = new ImageIcon("TesterImages/TaxiTicket.png");
            System.out.println(icon.getIconHeight());
        }else if(flag == 2) {
           icon = new ImageIcon("TesterImages/BusTicket.png");
        }else if(flag ==3 ) {
            icon = new ImageIcon("TesterImages/TubeTicket.png");
        }
        transports[round].setIcon(icon);
        flag = 0;
        round++;
    }





    private void createLabels() {
        // for each label in the first column
        for (int i = 1; i <= 12; i++) {
            int y = 20 + (i * 13);

            numbers[i] = new JLabel(i + ".)");
            numbers[i].setBounds(10, y, 90, y + 10);
            add(numbers[i]);

            transports[i] = new JLabel();
            transports[i].setBounds(60, y, 90, y + 10);
            add(transports[i]);
        }
        // for each label in the second column
        for (int i = 13; i <= 24; i++) {
            int y = 20 + ((i - 12) * 13);

            numbers[i] = new JLabel(i + ".)");
            numbers[i].setBounds(110, y, 90, y + 10);
            add(numbers[i]);

            transports[i] = new JLabel();
            transports[i].setBounds(160, y, 90, y + 10);
            add(transports[i]);
        }
    }

}