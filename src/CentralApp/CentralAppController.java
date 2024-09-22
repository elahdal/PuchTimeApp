package CentralApp;

import CentralApp.ResourcesOrganization.Company;
import Data.TimeRecord;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class CentralAppController {

    private ViewCheckInOut app;
    private Company C;
    private String ViewType;


    public CentralAppController( Company Comp, String ViewType) {
        this.C = Comp;
        this.ViewType=  ViewType;
    }

    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Serveur démarré sur le port 12345");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     ObjectInputStream receiveOrder = new ObjectInputStream(clientSocket.getInputStream())) {

                    // Lire l'objet TimeRecord envoyé par le client
                    TimeRecord TR = (TimeRecord) receiveOrder.readObject();

                    System.out.println("Object Received!   :"+TR.toString());

                    // Ajouter l'enregistrement à l'historique de la société
                    C.addTimeRecord(TR);

                    // Récupérer l'employé par ID et lui ajouter l'enregistrement
                    if (C.getEmployeeByName(TR.getName()) != null) {
                        C.getEmployeeByName(TR.getName()).addTimeRecord(TR);
                        C.getEmployeeByName(TR.getName()).clockInOut(TR);
                        System.out.println("======>"+C.Size());


                    } else {
                        System.err.println("Employé avec le Nom " + TR.getName() + " non trouvé.");
                    }

                    // Mise à jour de l'interface
                    //Ajoute Dans le buttob 2 app.addRows(C, ViewType);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            "Erreur de réception de l'objet TimeRecord: " + e.getMessage(),
                            "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Problème de socket : " + e.getMessage(),
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
