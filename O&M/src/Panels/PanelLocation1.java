package Panels;

import Dialogs.*;
import System.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import System.Style;

public class PanelLocation1 extends JPanel implements ActionListener {

    JPanel panelServices = new JPanel();
    JLabel labelHeadline = new JLabel("Komorów I/II");
    JPanel panelLine = new JPanel();
    JPanel panelDetails = new JPanel();
    JLabel labelDetails = new JLabel("Szczegóły");
    JLabel labelID = new JLabel("ID zgłoszenia");
    public JLabel labelIDDynamic = new JLabel("Nieznany");
    JLabel labelStatus = new JLabel("Status zgłoszenia");
    public JLabel labelStatusDynamic = new JLabel("Nieznany");
    JLabel labelTimeget = new JLabel("Czas wpłynięcia");
    public JLabel labelTimegetDynamic = new JLabel("Nieznany");
    JLabel labelTimeaccept = new JLabel("Czas przyjęcia");
    public JLabel labelTimeacceptDynamic = new JLabel("Nieznany");
    JLabel labelModby = new JLabel("Modyfikacja");
    public JLabel labelModbyDynamic = new JLabel("Nieznany");

    JLabel labelComment = new JLabel("Opis");
    public JTextArea labelCommentDynamic = new JTextArea();
    JLabel labelManage = new JLabel("Zarządzaj");

    // Model tabeli z wyłączeniem możliwości edycji
    public DefaultTableModel modelApplications = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public JTable tableApplications = new JTable(modelApplications);
    JScrollPane scrollApplications = new JScrollPane(tableApplications);
    JPanel panelApplications = new JPanel();
    DefaultTableCellRenderer centerElements = new DefaultTableCellRenderer();

    // Przyciski
    public JButton btnAdd = new JButton("Dodaj");
    public static JButton btnStatusChange = new JButton("Edycja");
    public static JButton btnDelete = new JButton("Usuń");
    public JButton btnBack = new JButton("Powrót");

    // Obsługa SQL
    String actualID;
    Connection connection = null;
    String zapytanie;
    Statement st = null;
    ResultSet rs = null;

    // Konstruktor
    public PanelLocation1(){
        setBounds(0, 80, 1920, 960);
        setBackground(Style.whiteBlue);
        setOpaque(true);
        setLayout(null);
        setVisible(false);

        modelApplications.addColumn("ID");
        modelApplications.addColumn("Status");
        modelApplications.addColumn("Czas wpłynięcia");
        modelApplications.addColumn("Czas modyfikacji");
        modelApplications.addColumn("Zmodyfikowano przez");
        modelApplications.addColumn("Komentarz");

        tableApplications.setPreferredSize(new Dimension(1380,730));
        tableApplications.setBackground(Style.white);
        tableApplications.setFont(Style.fontRegular12);
        tableApplications.setForeground(Style.black);
        tableApplications.getTableHeader().setBackground(Style.white);
        tableApplications.getTableHeader().setForeground(Style.black);
        tableApplications.getTableHeader().setFont(Style.fontSemibold12);
        tableApplications.setSelectionBackground(Style.blue);
        tableApplications.setRowHeight(25);
        tableApplications.setShowGrid(true);
        tableApplications.getTableHeader().setReorderingAllowed(false);
        tableApplications.getTableHeader().setResizingAllowed(false);
        tableApplications.setFocusable(false);
        tableApplications.getColumnModel().getColumn(0).setWidth(10);

        scrollApplications.setSize(new Dimension(1380,710));

        centerElements.setHorizontalAlignment(JLabel.CENTER);
        for(int i=0; i<5; i++) {
            tableApplications.getColumnModel().getColumn(i).setCellRenderer(centerElements);
        }

        panelApplications.setBounds(20,80,1380,790);
        panelApplications.setOpaque(false);
        panelApplications.setLayout(null);
        panelApplications.add(scrollApplications);

        panelLine.setBounds(20,49,1760,2);
        panelLine.setBackground(Style.blue);

        labelHeadline.setBounds(30,0,200,50);
        labelHeadline.setFont(Style.fontSemibold18);
        labelHeadline.setHorizontalAlignment(SwingConstants.LEFT);

        // Prawa strona
        labelDetails.setBounds(30,0,340,24);
        labelDetails.setFont(Style.fontSemibold14);
        labelDetails.setHorizontalAlignment(SwingConstants.LEFT);
        labelDetails.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Style.blue));

        labelID.setBounds(30,24,170,40);
        labelID.setFont(Style.fontRegular14);
        labelID.setForeground(Style.gray);
        labelID.setHorizontalAlignment(SwingConstants.LEFT);
        labelID.setVerticalAlignment(SwingConstants.CENTER);
        labelID.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Style.lightGray));

        labelIDDynamic.setBounds(200,24,170,40);
        labelIDDynamic.setFont(Style.fontSemibold14);
        labelIDDynamic.setForeground(Style.gray);
        labelIDDynamic.setHorizontalAlignment(SwingConstants.RIGHT);
        labelIDDynamic.setVerticalAlignment(SwingConstants.CENTER);
        labelIDDynamic.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Style.lightGray));

        labelStatus.setBounds(30,64,170,40);
        labelStatus.setFont(Style.fontRegular14);
        labelStatus.setForeground(Style.gray);
        labelStatus.setHorizontalAlignment(SwingConstants.LEFT);
        labelStatus.setVerticalAlignment(SwingConstants.CENTER);
        labelStatus.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Style.lightGray));

        labelStatusDynamic.setBounds(200,64,170,40);
        labelStatusDynamic.setFont(Style.fontSemibold14);
        labelStatusDynamic.setForeground(Style.gray);
        labelStatusDynamic.setHorizontalAlignment(SwingConstants.RIGHT);
        labelStatusDynamic.setVerticalAlignment(SwingConstants.CENTER);
        labelStatusDynamic.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Style.lightGray));

        labelTimeget.setBounds(30,104,170,40);
        labelTimeget.setFont(Style.fontRegular14);
        labelTimeget.setForeground(Style.gray);
        labelTimeget.setHorizontalAlignment(SwingConstants.LEFT);
        labelTimeget.setVerticalAlignment(SwingConstants.CENTER);
        labelTimeget.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Style.lightGray));

        labelTimegetDynamic.setBounds(200,104,170,40);
        labelTimegetDynamic.setFont(Style.fontSemibold14);
        labelTimegetDynamic.setForeground(Style.gray);
        labelTimegetDynamic.setHorizontalAlignment(SwingConstants.RIGHT);
        labelTimegetDynamic.setVerticalAlignment(SwingConstants.CENTER);
        labelTimegetDynamic.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Style.lightGray));

        labelTimeaccept.setBounds(30,144,170,40);
        labelTimeaccept.setFont(Style.fontRegular14);
        labelTimeaccept.setForeground(Style.gray);
        labelTimeaccept.setHorizontalAlignment(SwingConstants.LEFT);
        labelTimeaccept.setVerticalAlignment(SwingConstants.CENTER);
        labelTimeaccept.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Style.lightGray));

        labelTimeacceptDynamic.setBounds(200,144,170,40);
        labelTimeacceptDynamic.setFont(Style.fontSemibold14);
        labelTimeacceptDynamic.setForeground(Style.gray);
        labelTimeacceptDynamic.setHorizontalAlignment(SwingConstants.RIGHT);
        labelTimeacceptDynamic.setVerticalAlignment(SwingConstants.CENTER);
        labelTimeacceptDynamic.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Style.lightGray));

        labelComment.setBounds(30,204,340,24);
        labelComment.setFont(Style.fontSemibold14);
        labelComment.setHorizontalAlignment(SwingConstants.LEFT);
        labelComment.setVerticalAlignment(SwingConstants.CENTER);
        labelComment.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Style.blue));

        labelCommentDynamic.setBounds(30,236,340,200);
        labelCommentDynamic.setFont(Style.fontRegular14);
        labelCommentDynamic.setForeground(Style.gray);
        labelCommentDynamic.setMinimumSize(new Dimension(0,0));
        labelCommentDynamic.setLineWrap(true);

        labelManage.setBounds(30,490,340,24);
        labelManage.setFont(Style.fontSemibold14);
        labelManage.setHorizontalAlignment(SwingConstants.LEFT);
        labelManage.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Style.blue));

        panelDetails.setBounds(1410,80,460,620);
        panelDetails.setOpaque(false);
        panelDetails.setLayout(null);
        panelDetails.add(labelDetails);
        panelDetails.add(labelID);
        panelDetails.add(labelIDDynamic);
        panelDetails.add(labelStatus);
        panelDetails.add(labelStatusDynamic);
        panelDetails.add(labelTimeget);
        panelDetails.add(labelTimegetDynamic);
        panelDetails.add(labelTimeaccept);
        panelDetails.add(labelTimeacceptDynamic);
        panelDetails.add(labelModby);
        panelDetails.add(labelModbyDynamic);
        panelDetails.add(labelComment);
        panelDetails.add(labelCommentDynamic);
        panelDetails.add(labelManage);
        panelDetails.add(btnStatusChange);
        panelDetails.add(btnDelete);
        panelDetails.add(btnAdd);

        // Przyciski
        btnAdd.setBounds(30,520,110,30);
        btnAdd.setFocusable(false);
        btnAdd.setFont(Style.fontRegular12);

        btnStatusChange.setBounds(145,520,110,30);
        btnStatusChange.setFocusable(false);
        btnStatusChange.setFont(Style.fontRegular12);

        btnDelete.setBounds(260,520,110,30);
        btnDelete.setText("Usuń");
        btnDelete.setFocusable(false);
        btnDelete.setFont(Style.fontRegular12);

        btnBack.setBounds(20,800,120,30);
        btnBack.setFocusable(false);
        btnBack.setFont(Style.fontRegular12);

        panelServices.setBounds(50,50,1820,840);
        panelServices.setOpaque(true);
        panelServices.setBackground(Style.white);
        panelServices.setLayout(null);
        panelServices.add(panelLine);
        panelServices.add(labelHeadline);
        panelServices.add(panelApplications);
        panelServices.add(panelDetails);
        panelServices.add(btnBack);

        // Dodanie AL
        btnAdd.addActionListener(this);
        btnStatusChange.addActionListener(this);
        btnDelete.addActionListener(this);

        // Dodanie elementów
        add(panelServices);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == btnStatusChange ){
            // Uruchomienie okna edycji
            if( PanelMain.panelLocation1.tableApplications.getSelectedRow() == -1 ) {
                JOptionPane.showMessageDialog(null, "Nie wybrano zgłoszenia", "Komunikat", JOptionPane.INFORMATION_MESSAGE);
            }
            DialogChangeStatus dialogChangeStatus = new DialogChangeStatus(String.valueOf(tableApplications.getModel().getValueAt(PanelMain.panelLocation1.tableApplications.getSelectedRow(), 0)),String.valueOf(tableApplications.getModel().getValueAt(PanelMain.panelLocation1.tableApplications.getSelectedRow(), 5)));
        }
        if( e.getSource() == btnAdd) {
            DialogAdd dialogAdd = new DialogAdd();
        }
        if( e.getSource() == btnDelete) {
            try {
                connection = DatabaseManager.getConnection();
                String choosenID = String.valueOf(tableApplications.getModel().getValueAt(PanelMain.panelLocation1.tableApplications.getSelectedRow(), 0));
                zapytanie = "DELETE [O&M].[dbo].[Applications_L1] WHERE [ID] = " + choosenID;
                st = connection.createStatement();
                rs = st.executeQuery(zapytanie);
            } catch (Exception g){
            }

            // Odświeżenie tabeli
            PanelMain.panelLocation1.modelApplications.setRowCount(0);
            DataReader.readDataLocation1();
        }
    }
}
