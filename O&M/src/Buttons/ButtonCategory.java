package Buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import System.Style;

public class ButtonCategory extends JButton implements MouseListener {

    // Deklaracja napisów
    public JLabel labelNewServices = new JLabel("0");
    JLabel labelCity = new JLabel();
    JLabel labelCountry = new JLabel();
    JLabel labelPowerInstalled = new JLabel();
    JLabel labelAmountPV = new JLabel();

    // Konstruktor
    public ButtonCategory(int x, int y, String city, String country, String power, String amountPV){
        setBounds(x,y,230,230);
        setBorder(null);
        setLayout(null);
        setOpaque(true);
        setFocusable(false);
        setContentAreaFilled(true);
        setBackground(new Color(255, 255, 255));
        addMouseListener(this);

        labelNewServices.setBounds(170,8,50,40);
        labelNewServices.setFont(Style.fontSemibold34);
        labelNewServices.setForeground(Style.blue);
        labelNewServices.setHorizontalAlignment(SwingConstants.RIGHT);

        labelCity.setBounds(10,203,155,20);
        labelCity.setFont(Style.fontSemibold16);
        labelCity.setForeground(new Color(30, 30, 30, 255));
        labelCity.setHorizontalAlignment(SwingConstants.LEFT);
        labelCity.setText(city);

        labelCountry.setBounds(10,110,210,20);
        labelCountry.setFont(Style.fontRegular13);
        labelCountry.setForeground(Style.black);
        labelCountry.setHorizontalAlignment(SwingConstants.LEFT);
        labelCountry.setText(country);

        labelPowerInstalled.setBounds(10,140,210,20);
        labelPowerInstalled.setFont(Style.fontRegular13);
        labelPowerInstalled.setForeground(Style.black);
        labelPowerInstalled.setHorizontalAlignment(SwingConstants.LEFT);
        labelPowerInstalled.setText(power);

        labelAmountPV.setBounds(10,170,200,20);
        labelAmountPV.setFont(Style.fontRegular13);
        labelAmountPV.setForeground(Style.black);
        labelAmountPV.setHorizontalAlignment(SwingConstants.LEFT);
        labelAmountPV.setText(amountPV);

        add(labelNewServices);
        add(labelCity);
        add(labelCountry);
        add(labelPowerInstalled);
        add(labelAmountPV);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setBackground(Style.blue);
        labelCity.setForeground(Style.white);
        labelNewServices.setForeground(Style.white);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setBackground(Style.white);
        labelCity.setForeground(Style.darkGray);
        labelNewServices.setForeground(Style.blue);
    }
}
