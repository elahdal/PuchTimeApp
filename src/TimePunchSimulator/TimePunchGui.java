package TimePunchSimulator;

import CentralApp.ResourcesOrganization.Employee;
import Data.TimeRecord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TimePunchGui {

    // Static instance for Singleton
    private static TimePunchGui instance;

    // Attributs GUI
    private JTextField userIdField;  // Utiliser JTextField à la place de JComboBox
    private JLabel heureLabel;
    private JButton sendButton;
    private Timer timer;

    // Private constructor to prevent instantiation from outside
    private TimePunchGui() {
        // Configuration de la fenêtre
        JFrame frame = new JFrame("TimePunch App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new BorderLayout());

        // Créer et configurer l'heure exacte
        heureLabel = new JLabel("Time Now: ");
        heureLabel.setHorizontalAlignment(JLabel.CENTER);
        heureLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
        heureLabel.setBorder(BorderFactory.createEmptyBorder(50, 20, 20, 20));
        frame.add(heureLabel, BorderLayout.NORTH); // Ajouter l'heure en haut

        // Charger et redimensionner l'image
        ImageIcon defaultImage = null;
        try {
            defaultImage = new ImageIcon(getClass().getResource("/Images/PointeuseLG.png"));
            Image rawImage = defaultImage.getImage();
            ImageIcon finalImage = new ImageIcon(rawImage.getScaledInstance(280, 280, Image.SCALE_SMOOTH));

            // Ajouter le label d'image au centre
            JLabel imageLabel = new JLabel(finalImage);
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            imageLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            frame.add(imageLabel, BorderLayout.CENTER);
        } catch (NullPointerException e) {
            System.err.println("Image not found: " + e.getMessage());
        }

        // Créer et configurer les composants
        userIdField = new JTextField(20);  // Créer un champ de texte pour entrer manuellement l'ID de l'employé
        sendButton = new JButton("Check IN / Check OUT");

        // Panneau pour les composants
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Ajouter les composants au panneau
        panel.add(new JLabel("User Id:"));
        panel.add(userIdField);  // Ajouter le champ de texte au lieu de la JComboBox
        panel.add(sendButton);

        // Ajouter le panneau en bas de la fenêtre
        frame.add(panel, BorderLayout.SOUTH);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 55, 20));

        // Initialiser le timer pour mettre à jour l'heure chaque seconde
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCurrentTime();
            }
        });
        timer.start(); // Démarrer le timer

        // Ajouter un ActionListener au bouton
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkInOut();
            }
        });

        // Rendre la fenêtre visible
        frame.setVisible(true);
    }

    // Singleton pattern: method to get the single instance of TimePunchGui
    public static TimePunchGui getInstance() {
        if (instance == null) {
            instance = new TimePunchGui();
        }
        return instance;
    }

    // Méthode pour mettre à jour l'heure actuelle
    private void updateCurrentTime() {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        heureLabel.setText("Time Now: " + currentTime.format(formatter));
    }

    // Méthode pour gérer l'enregistrement de pointage (Check IN / Check OUT)
    private void checkInOut() {
        String enteredUserId = userIdField.getText();  // Obtenir l'ID de l'utilisateur à partir du champ de texte
        if (!enteredUserId.isEmpty()) {
            TimeRecord timeRecord = new TimeRecord();
            timeRecord.setName(enteredUserId);
            TimePunchController TPC = new TimePunchController();
            TPC.sendTimeRecord(timeRecord);
            System.out.println("Time Record for Employee ID: " + enteredUserId);
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a user ID.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void ReceiveEmployeeList() {
        // Si tu veux remplir le champ de texte avec un ID d'employé par défaut, tu peux le faire ici
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> TimePunchGui.getInstance());
    }
}
