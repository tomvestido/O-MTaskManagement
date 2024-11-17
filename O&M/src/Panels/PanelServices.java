package Panels;

import Buttons.ButtonCategory;
import javax.swing.*;
import System.Style;

public class PanelServices extends JPanel {

    // Menu wyboru farmy
    JPanel panelMenus = new JPanel();
    public ButtonCategory btnLocation_1 = new ButtonCategory(0,0,"Komorów I/II", "Lokalizacja: Polska", "Moc zainstalowana: 0,986 MW", "Ilość paneli: 3080 sztuk");
    public ButtonCategory btnLocation_2 = new ButtonCategory(240,0,"Dębica", "Lokalizacja: Polska", "Moc zainstalowana: 0,962 MW", "Ilość paneli: 3435 sztuk");
    public ButtonCategory btnLocation_3 = new ButtonCategory(480,0,"Goszcz", "Lokalizacja: Polska", "Moc zainstalowana: 0,986 MW", "Ilość paneli: 3520 sztuk");
    public ButtonCategory btnLocation_4 = new ButtonCategory(720,0,"Szczuczyn II", "Lokalizacja: Polska", "Moc zainstalowana: 0,986 MW", "Ilość paneli: 3520 sztuk");
    public ButtonCategory btnLocation_5 = new ButtonCategory(0,240,"Zacisze I", "Lokalizacja: Polska", "Moc zainstalowana: 0,845 MW", "Ilość paneli: 3017 sztuk");
    public ButtonCategory btnLocation_6 = new ButtonCategory(240,240,"Zacisze II", "Lokalizacja: Polska", "Moc zainstalowana: 0,728 MW", "Ilość paneli: 2600 sztuk");
    public ButtonCategory btnLocation_7 = new ButtonCategory(480,240,"Peritz", "Lokalizacja: Niemcy", "Moc zainstalowana: 1,2 MW", "Ilość paneli: 10000 sztuk");
    public ButtonCategory btnLocation_8 = new ButtonCategory(720,240,"Gummersbach", "Lokalizacja: Niemcy", "Moc zainstalowana: 0,35 MW", "Ilość paneli: 1458 sztuk");

    // Konstruktor
    public PanelServices(){
        setBounds(0, 80, 1920, 960);
        setBackground(Style.whiteBlue);
        setOpaque(true);
        setLayout(null);
        setVisible(false);

        // Menu wyboru farmy
        panelMenus.setBounds(485,245,950,470);
        panelMenus.setOpaque(false);
        panelMenus.setLayout(null);
        panelMenus.add(btnLocation_1);
        panelMenus.add(btnLocation_2);
        panelMenus.add(btnLocation_3);
        panelMenus.add(btnLocation_4);
        panelMenus.add(btnLocation_5);
        panelMenus.add(btnLocation_6);
        panelMenus.add(btnLocation_7);
        panelMenus.add(btnLocation_8);

        add(panelMenus);
    }
}
