package Buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import System.Style;

public class ButtonNavi extends JButton implements MouseListener{

    // Konstruktor
    public ButtonNavi(String napis, Icon ikona) {
        setBorder(null);
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusable(false);
        setText(napis);
        setIcon(ikona);
        setIconTextGap(10);
        setFont(Style.fontRegular14);
        setForeground(Style.black);
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        addMouseListener(this);
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
        setForeground(Style.blue);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setForeground(Style.black);
    }
}
