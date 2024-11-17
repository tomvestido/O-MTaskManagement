package System;

import Frames.MainFrame;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.*;
import Refresh.RefreshValues;

public class Main {
    public static void main(String[] args) throws Exception {

        // Ustawienia LookAndFeel
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch(Exception ex) {
            System.err.println("Nieudana inicjalizacja LAF");
        }

        // Obsługa SQL
        DataReader dataReader = new DataReader();
        dataReader.readUsers();
        DataReader.readDataLocation1();

        // Uruchomienie ekranu logowania
        LoginFront loginFront = new LoginFront(dataReader.getLoginInfo());

        // Klasa Runnable
        RefreshValues refreshValues = new RefreshValues();

        // Utworzenie tablicy wątków
        Thread[] threads = new Thread[1];

        // Przekazanie klasy typu Runnable
        threads[0] = new Thread(refreshValues);

        // Start wątku
        threads[0].start();

    }
}
