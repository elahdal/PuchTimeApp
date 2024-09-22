package CentralApp;

import CentralApp.ResourcesOrganization.Company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class CentralAppGui {

    public CentralAppGui(Company C) {
        // Create the frame

        JFrame frame = new JFrame("Monitoring App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLayout(new BorderLayout());


        // Load and scale the image (handling potential null pointer exception)
        ImageIcon defaultImage = null;
        try {
            defaultImage = new ImageIcon(Objects.requireNonNull(CentralAppGui.class.getResource("/Images/I.png")));
            Image rawImage = defaultImage.getImage();
            ImageIcon finalImage = new ImageIcon(rawImage.getScaledInstance(600, 450, Image.SCALE_SMOOTH));

            // Add the image label to the center
            JLabel imageLabel = new JLabel(finalImage);
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            imageLabel.setBorder(BorderFactory.createEmptyBorder(70, 20, 50, 20));
            frame.add(imageLabel, BorderLayout.CENTER);
        } catch (NullPointerException e) {
            System.err.println("Image not found: " + e.getMessage());
        }


        // Panel for buttons at the bottom (South)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 3, 10, 10)); // 2 rows, 3 columns, 10px padding

        // Create buttons with special names and actions
        String[] buttonNames = {"View CheckIn/Out", "Manage Employees", "Setting", "Export To", "Import From"};
        for (String name : buttonNames) {
            JButton button = getjButton(name, C);
            buttonPanel.add(button);
        }

        // Empty cell to maintain the structure of the grid layout
        buttonPanel.add(new JLabel(""));

        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Display the frame
        frame.setVisible(true);

        CentralAppController CAC =new CentralAppController(C,"Null");
        CAC.startServer();
    }







    private static JButton getjButton(String name, Company C) {
        JButton button = new JButton(name);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Define specific actions for each button
                switch (name) {
                    case "View CheckIn/Out":
                        System.out.println("View CheckIn/Out executed!");

                        // Créer la fenêtre
                        JFrame frame = new JFrame("Simple Frame");
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        frame.setSize(200, 100);
                        frame.setLayout(new FlowLayout()); // Utiliser un layout simple

                        // Créer les boutons
                        JButton button1 = new JButton("View All CheckIn's");
                        JButton button2 = new JButton("View Employee CheckIn");

                        // Ajouter des écouteurs d'événements aux boutons
                        button1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                ViewCheckInOut v = new ViewCheckInOut(false);
                                v.addRows(C,"Null");
                                v.startViewMonitoring();

                            }
                        });

                        button2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                ViewCheckInOut v2 = new ViewCheckInOut(true);
                                v2.startViewMonitoring();
                                CentralAppController CGui=  new CentralAppController( C, "Test");
                            }
                        });

                        // Ajouter les boutons à la fenêtre
                        frame.add(button1);
                        frame.add(button2);

                        // Rendre la fenêtre visible
                        frame.setVisible(true);
                        break; // Ajout du break ici pour sortir du switch

                    case "Manage Employees":
                        System.out.println("Action Manage Employees executed!");
                        break;
                    case "Setting":
                        System.out.println("Action Setting executed!");
                        break;
                    case "Export To":
                        System.out.println("Action ExportTo executed!");
                        break;
                    case "Import From":
                        System.out.println("Action ImportFrom executed!");
                        break;
                }
            }
        });
        return button;
    }
}
