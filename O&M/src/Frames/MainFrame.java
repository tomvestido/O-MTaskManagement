package Frames;

import Panels.*;
import javax.swing.*;

public class MainFrame extends JFrame {

    // Deklaracja obiektów - Panel główny
    PanelMain panelMain = new PanelMain();

    // Konstruktor
    public MainFrame()  {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1040);
        setTitle("O&M App");
        setLayout(null);
        setLocationRelativeTo(null);
        //setUndecorated(true);

        // Dodanie elementów do ramki
        add(panelMain);

        // Ustawienie widoczności ramki - ważne żeby było na koniec konstruktora (po dodaniu elementów)
        setVisible(true);
    }
}
