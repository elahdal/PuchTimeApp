package TimePunchSimulator;

import Data.TimeRecord;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TimePunchController {

    public void sendTimeRecord(TimeRecord TR) {
        try (Socket clientSocket = new Socket("localhost", 12345);
             ObjectOutputStream sendPipe = new ObjectOutputStream(clientSocket.getOutputStream())) {

            // Envoyer l'objet TimeRecord au serveur
            sendPipe.writeObject(TR);
            sendPipe.flush();  // Assurez-vous que les données sont bien envoyées

            System.out.println("TimeRecord envoyé avec succès : " + TR);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Erreur de connexion Socket: " + e.getMessage(),
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
