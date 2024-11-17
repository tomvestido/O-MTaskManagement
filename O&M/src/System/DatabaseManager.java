package System;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    // Metoda nawiązująca połączenie z SQL
    public static Connection getConnection() {
        Connection connection;
        try {
            String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driverName);
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            try {
                // Adres silnika bazy danych wraz z parametrami
                String dbURL = "jdbc:sqlserver://DESKTOP-8G0Q1BN;Database=O&M;integratedSecurity=false;encrypt=true;trustServerCertificate=true";

                // Definicja użytkownika
                String user = "tom";

                // Definicja hasła
                String pass = "tomakie124";

                // Wykonanie połączenia z wykorzystaniem wcześniej zdeklarowanych parametrów
                connection = DriverManager.getConnection(dbURL, user, pass);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Połączenie nieudane", "Komunikat", JOptionPane.ERROR_MESSAGE);
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Nie odnaleziono klasy", "Komunikat", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Operacja nieudana", "Komunikat", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
        return connection;
    }
}
