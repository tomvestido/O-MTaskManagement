package Panels;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import System.Style;

public class PanelMain extends JPanel implements ActionListener {

    PanelNavi panelNavi = new PanelNavi();
    public static PanelServices panelServices = new PanelServices();
    public static PanelLocation1 panelLocation1 = new PanelLocation1();

    // Konstruktor
    public PanelMain()   {
        setBounds(0, 0, 1920, 1040);
        setBackground(Style.white);
        setOpaque(true);
        setLayout(null);
        setVisible(true);

        panelServices.btnLocation_1.addActionListener(this);
        panelLocation1.btnBack.addActionListener(this);

        // Dodanie AL do elementów MENU
        panelNavi.btnEnergyPrices.addActionListener(this);
        panelNavi.btnUsers.addActionListener(this);
        panelNavi.btnService.addActionListener(this);

        // Parametry startowe
        panelNavi.setVisible(true);
        panelServices.setVisible(true);

        add(panelServices);
        add(panelNavi);
        add(panelLocation1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == panelNavi.btnService){
            panelServices.setVisible(true);
            panelLocation1.setVisible(false);
        }
        if( e.getSource() == panelServices.btnLocation_1 ){
            panelServices.setVisible(false);
            panelLocation1.setVisible(true);
        }
        if( e.getSource() == panelLocation1.btnBack ){
            panelServices.setVisible(true);
            panelLocation1.setVisible(false);
        }
    }
}
