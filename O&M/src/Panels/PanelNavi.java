package Panels;

import Buttons.ButtonNavi;
import javax.swing.*;
import java.awt.*;
import System.Style;

public class PanelNavi extends JPanel {
    // ikonaUser - link
    java.net.URL imgUrlPolsl = getClass().getResource("/Images/politechnika_sl_logo_poziom_en_rgb_small_60.png");
    ImageIcon imgPolsl = new ImageIcon(imgUrlPolsl);

    java.net.URL imgUrlClock = getClass().getResource("/Images/time.png");
    ImageIcon imgClock = new ImageIcon(imgUrlClock);

    // Logo Polsl
    JLabel logoPolsl = new JLabel();

    // Menu
    ButtonNavi btnDashboard = new ButtonNavi("EKRAN STARTOWY", null);
    ButtonNavi btnEnergyPrices = new ButtonNavi("CENY ENERGII", null);
    ButtonNavi btnService = new ButtonNavi("ZGŁOSZENIA", null);
    ButtonNavi btnUsers = new ButtonNavi("UŻYTKOWNICY", null);
    JPanel panelMenu = new JPanel();

    public static JLabel time = new JLabel();

    // Zalogowany uzytkownik
    JLabel labelLogin = new JLabel("Użytkownik");
    public static JLabel labelLoginDynamic = new JLabel("Nieznany");
    JLabel labelUser = new JLabel("Użytkownik");
    public static JLabel labelUserDynamic = new JLabel("Nieznany");
    JLabel labelCompany = new JLabel("Firma");
    public static JLabel labelCompanyDynamic = new JLabel("Nieznany");
    JLabel labelRule = new JLabel("Uprawnienia");
    public static JLabel labelRuleDynamic = new JLabel("Nieznany");

    public PanelNavi(){
        setBounds(0, 0, 1920, 80);
        setBackground(Style.white);
        setOpaque(true);
        setLayout(null);

        // Logo POLSL
        logoPolsl.setBounds(10,10,206,60);
        logoPolsl.setIcon(imgPolsl);

        // Kontener z przyciskami
        panelMenu.setBounds(300,22,800,80);
        panelMenu.setLayout(new FlowLayout(FlowLayout.CENTER,40,10));
        panelMenu.setOpaque(false);

        // Wyświetlenie daty i godziny
        time.setBounds(1740,30,200,20);
        time.setFont(Style.fontRegular14);
        time.setForeground(Style.black);
        time.setHorizontalAlignment(SwingConstants.LEFT);
        time.setVerticalAlignment(SwingConstants.CENTER);
        time.setIcon(imgClock);

        // Zalogowany uzytkownik
        labelLogin.setBounds(250,20,200,20);
        labelLogin.setFont(Style.fontSemibold14);
        labelLogin.setForeground(Style.black);
        labelLogin.setHorizontalAlignment(SwingConstants.CENTER);
        labelLogin.setVerticalAlignment(SwingConstants.CENTER);

        labelLoginDynamic.setBounds(250,45,200,20);
        labelLoginDynamic.setFont(Style.fontRegular14);
        labelLoginDynamic.setForeground(Style.black);
        labelLoginDynamic.setHorizontalAlignment(SwingConstants.CENTER);
        labelLoginDynamic.setVerticalAlignment(SwingConstants.CENTER);

        labelCompany.setBounds(400,20,200,20);
        labelCompany.setFont(Style.fontSemibold14);
        labelCompany.setForeground(Style.black);
        labelCompany.setHorizontalAlignment(SwingConstants.CENTER);
        labelCompany.setVerticalAlignment(SwingConstants.CENTER);

        labelCompanyDynamic.setBounds(400,45,200,20);
        labelCompanyDynamic.setFont(Style.fontRegular14);
        labelCompanyDynamic.setForeground(Style.black);
        labelCompanyDynamic.setHorizontalAlignment(SwingConstants.CENTER);
        labelCompanyDynamic.setVerticalAlignment(SwingConstants.CENTER);

        labelRule.setBounds(550,20,200,20);
        labelRule.setFont(Style.fontSemibold14);
        labelRule.setForeground(Style.black);
        labelRule.setHorizontalAlignment(SwingConstants.CENTER);
        labelRule.setVerticalAlignment(SwingConstants.CENTER);

        labelRuleDynamic.setBounds(550,45,200,20);
        labelRuleDynamic.setFont(Style.fontRegular14);
        labelRuleDynamic.setForeground(Style.black);
        labelRuleDynamic.setHorizontalAlignment(SwingConstants.CENTER);
        labelRuleDynamic.setVerticalAlignment(SwingConstants.CENTER);

        // Dodanie elementów do panelu
        add(logoPolsl);
        add(panelMenu);
        add(time);
        add(labelLogin);
        add(labelLoginDynamic);
        add(labelCompany);
        add(labelCompanyDynamic);
        add(labelRule);
        add(labelRuleDynamic);
    }
}
