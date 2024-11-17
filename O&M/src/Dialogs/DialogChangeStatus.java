package Dialogs;
import Panels.PanelMain;
import Panels.PanelNavi;
import System.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DialogChangeStatus extends JDialog implements ActionListener {

    // Definicja obiektów
    JLabel labelDetailsEDIT = new JLabel("Edytuj status");
    JLabel labelStatusEDIT = new JLabel("Status zgłoszenia");
    String[] varStatus = {"NOWE", "PRZYJĘTE","W REALIZACJI", "ZREALIZOWANE"};
    JComboBox comboStatusEDIT = new JComboBox(varStatus);
    JLabel labelCommentEDIT = new JLabel("Edytuj opis");
    JTextArea tfCommentEDIT = new JTextArea();

    // Przycisk potwierdź
    public JButton btnConfirm = new JButton("Potwierdź");

    // Obsługa SQL
    String actualID;
    Connection connection = null;
    String zapytanie;
    Statement st = null;
    ResultSet rs = null;

    public DialogChangeStatus(String choosenID, String actualComment){
        setSize(415,430);
        setTitle("Edycja zgłoszenia");
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Style.white);
        setVisible(true);

        // Nagłówek
        labelDetailsEDIT.setBounds(30,20,340,24);
        labelDetailsEDIT.setFont(Style.fontSemibold14);
        labelDetailsEDIT.setHorizontalAlignment(SwingConstants.LEFT);
        labelDetailsEDIT.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Style.blue));

        // Edycja statusu
        labelStatusEDIT.setBounds(30,44,170,40);
        labelStatusEDIT.setFont(Style.fontRegular14);
        labelStatusEDIT.setForeground(Style.gray);
        labelStatusEDIT.setHorizontalAlignment(SwingConstants.LEFT);
        labelStatusEDIT.setVerticalAlignment(SwingConstants.CENTER);
        labelStatusEDIT.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Style.lightGray));

        comboStatusEDIT.setBounds(200,44,170,40);
        comboStatusEDIT.setFont(Style.fontSemibold14);
        comboStatusEDIT.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Style.lightGray));

        // Edycja komentarza
        labelCommentEDIT.setBounds(30,94,340,24);
        labelCommentEDIT.setFont(Style.fontSemibold14);
        labelCommentEDIT.setHorizontalAlignment(SwingConstants.LEFT);
        labelCommentEDIT.setVerticalAlignment(SwingConstants.CENTER);
        labelCommentEDIT.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Style.blue));

        tfCommentEDIT.setBounds(30,126,340,200);
        tfCommentEDIT.setFont(Style.fontRegular14);
        tfCommentEDIT.setForeground(Style.gray);
        tfCommentEDIT.setMinimumSize(new Dimension(0,0));
        tfCommentEDIT.setText(actualComment);
        tfCommentEDIT.setLineWrap(true);

        // Przycisk potwierdź
        btnConfirm.setBounds(250,340,120,30);
        btnConfirm.setFont(Style.fontRegular12);
        btnConfirm.setFocusable(false);
        btnConfirm.addActionListener(this);

        // Przypisanie argumentu z konstruktora do zmiennej
        actualID = choosenID;

        // Dodanie elementów
        add(labelDetailsEDIT);
        add(labelStatusEDIT);
        add(comboStatusEDIT);
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
                zapytanie = "UPDATE [O&M].[dbo].[Applications_L1] SET [STATUS] = '" + String.valueOf(comboStatusEDIT.getSelectedItem()) + "',[TIMEMOD] = '" + PanelNavi.time.getText() + "',[MODBY] = '" + PanelNavi.labelUserDynamic.getText() + "', [COMMENT] = '" + tfCommentEDIT.getText() +  "' WHERE [ID] = " + actualID;
                st = connection.createStatement();
                rs = st.executeQuery(zapytanie);

                // Zwolnienie zasobów
                st.close();
                connection.close();
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
