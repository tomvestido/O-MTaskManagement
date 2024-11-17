package Dialogs;

import Panels.PanelMain;
import Panels.PanelNavi;
import System.DataReader;
import System.DatabaseManager;
import System.Style;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DialogAdd extends JDialog implements ActionListener {

    // Definicja obiektów
    JLabel labelCommentEDIT = new JLabel("Opis zgłoszenia");
    JTextArea tfCommentEDIT = new JTextArea();

    // Przycisk potwierdź
    public JButton btnConfirm = new JButton("Potwierdź");

    // Obsługa SQL
    Connection connection = null;
    String zapytanie;
    Statement st = null;
    ResultSet rs = null;

    public DialogAdd(){
        setSize(415,430);
        setTitle("Dodawanie zgłoszenia");
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Style.white);
        setVisible(true);

        // Edycja komentarza
        labelCommentEDIT.setBounds(30,64,340,24);
        labelCommentEDIT.setFont(Style.fontSemibold14);
        labelCommentEDIT.setHorizontalAlignment(SwingConstants.LEFT);
        labelCommentEDIT.setVerticalAlignment(SwingConstants.CENTER);
        labelCommentEDIT.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Style.blue));

        tfCommentEDIT.setBounds(30,96,340,200);
        tfCommentEDIT.setFont(Style.fontRegular14);
        tfCommentEDIT.setForeground(Style.gray);
        tfCommentEDIT.setMinimumSize(new Dimension(0,0));
        tfCommentEDIT.setLineWrap(true);

        // Przycisk potwierdź
        btnConfirm.setBounds(250,310,120,30);
        btnConfirm.setFont(Style.fontRegular12);
        btnConfirm.setFocusable(false);
        btnConfirm.addActionListener(this);

        // Dodanie elementów
        add(labelCommentEDIT);
        add(tfCommentEDIT);
        add(btnConfirm);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Czynności po wciśnięciu przycisku
        if(e.getSource() == btnConfirm){
            // Wykonanie aktualizacji
            try {
                connection = DatabaseManager.getConnection();
                zapytanie = "INSERT INTO [O&M].[dbo].[Applications_L1] ([STATUS],[TIME],[TIMEMOD],[MODBY],[COMMENT]) VALUES ('NOWE','" + PanelNavi.time.getText() + "', null, null, '" + tfCommentEDIT.getText() + "')";
                st = connection.createStatement();
                rs = st.executeQuery(zapytanie);
            } catch (Exception g){
            }

            // Odświeżenie tabeli
            PanelMain.panelLocation1.modelApplications.setRowCount(0);
            DataReader.readDataLocation1();

            // Zamknięcie okna po wykonaniu czynności
            dispose();
        }
    }
}
