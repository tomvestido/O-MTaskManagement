package Refresh;

import Panels.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RefreshValues implements Runnable {

    @Override
    public void run()  {

        while(true) {

            // Panel Nawigacyjny
            // Odświeżanie daty i godziny
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            PanelNavi.time.setText(dtf.format(now));

            // Pobieranie danych z tabeli po wybraniu
            if (PanelMain.panelLocation1.tableApplications.getSelectedRow() > -1) {
                PanelMain.panelLocation1.labelIDDynamic.setText(String.valueOf(PanelMain.panelLocation1.modelApplications.getValueAt(PanelMain.panelLocation1.tableApplications.getSelectedRow(), 0)));
                PanelMain.panelLocation1.labelStatusDynamic.setText(String.valueOf(PanelMain.panelLocation1.tableApplications.getModel().getValueAt(PanelMain.panelLocation1.tableApplications.getSelectedRow(), 1)));
                PanelMain.panelLocation1.labelTimegetDynamic.setText(String.valueOf(PanelMain.panelLocation1.tableApplications.getModel().getValueAt(PanelMain.panelLocation1.tableApplications.getSelectedRow(), 2)));
                PanelMain.panelLocation1.labelTimeacceptDynamic.setText(String.valueOf(PanelMain.panelLocation1.tableApplications.getModel().getValueAt(PanelMain.panelLocation1.tableApplications.getSelectedRow(), 3)));
                PanelMain.panelLocation1.labelCommentDynamic.setText(String.valueOf(PanelMain.panelLocation1.tableApplications.getModel().getValueAt(PanelMain.panelLocation1.tableApplications.getSelectedRow(), 5)));
            }

            try {
                // usypiamy wątek na 100 milisekund
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
