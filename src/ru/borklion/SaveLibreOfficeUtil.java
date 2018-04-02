package ru.borklion;

import com.sun.star.beans.PropertyValue;
import com.sun.star.comp.helper.Bootstrap;
import com.sun.star.comp.helper.BootstrapException;
import com.sun.star.container.XIndexAccess;
import com.sun.star.frame.XComponentLoader;
import com.sun.star.lang.IndexOutOfBoundsException;
import com.sun.star.lang.XComponent;
import com.sun.star.lang.XMultiComponentFactory;
import com.sun.star.sheet.XSpreadsheet;
import com.sun.star.sheet.XSpreadsheetDocument;
import com.sun.star.sheet.XSpreadsheets;
import com.sun.star.table.XCell;
import com.sun.star.uno.Exception;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.uno.XComponentContext;

public class SaveLibreOfficeUtil {
    public static void SaveReport() throws InterruptedException, com.sun.star.io.IOException {
        XComponentContext xLocalContext = null;
        try {
            xLocalContext = Bootstrap.bootstrap();
        } catch (BootstrapException ex) {
            System.err.println("ERROR: Could not bootstrap default office");
            ex.printStackTrace();
            System.exit(2);
        }
        if (xLocalContext == null) {
            System.err.println("ERROR: Could not bootstrap default Office. . Please provide right way to soffice by '--office' option");
            System.exit(2);
        }
        XSpreadsheetDocument myDoc = openCalc(xLocalContext);
        XSpreadsheet xSheet = null;
        try {
            XSpreadsheets xSheets = myDoc.getSheets();
            XIndexAccess oIndexSheets = UnoRuntime.queryInterface(XIndexAccess.class, xSheets);
            xSheet = UnoRuntime.queryInterface(XSpreadsheet.class, oIndexSheets.getByIndex(0));
        } catch (Exception e) {
            System.out.println("Couldn't get Sheet " + e);
            e.printStackTrace(System.err);
        }
        insertIntoCell(1, 0, "JAN", xSheet, "");
        insertIntoCell(2, 0, "FEB", xSheet, "");
        insertIntoCell(3, 0, "MAR", xSheet, "");
        insertIntoCell(4, 0, "APR", xSheet, "");
        insertIntoCell(5, 0, "MAI", xSheet, "");
        insertIntoCell(6, 0, "JUN", xSheet, "");
        insertIntoCell(7, 0, "JUL", xSheet, "");
        insertIntoCell(8, 0, "AUG", xSheet, "");
        insertIntoCell(9, 0, "SEP", xSheet, "");
        insertIntoCell(10, 0, "OCT", xSheet, "");
        insertIntoCell(11, 0, "NOV", xSheet, "");
        insertIntoCell(12, 0, "DEC", xSheet, "");
        insertIntoCell(13, 0, "SUM", xSheet, "");
    }

    public static XSpreadsheetDocument openCalc(XComponentContext xContext) {
        XMultiComponentFactory xMCF = null;
        XComponentLoader xCLoader;
        XSpreadsheetDocument xSpreadSheetDoc = null;
        XComponent xComp = null;
        try {
            // get the servie manager rom the office
            xMCF = xContext.getServiceManager();
            // create a new instance of the desktop
            Object oDesktop = xMCF.createInstanceWithContext("com.sun.star.frame.Desktop", xContext);
            // query the desktop object for the XComponentLoader
            xCLoader = UnoRuntime.queryInterface(XComponentLoader.class, oDesktop);
            PropertyValue[] szEmptyArgs = new PropertyValue[0];
            String strDoc = "private:factory/scalc";
            xComp = xCLoader.loadComponentFromURL(strDoc, "_blank", 0, szEmptyArgs);
            xSpreadSheetDoc = UnoRuntime.queryInterface(XSpreadsheetDocument.class, xComp);
        } catch (Exception e) {
            System.err.println(" Exception " + e);
            e.printStackTrace(System.err);
        }
        return xSpreadSheetDoc;
    }

    public static void insertIntoCell(int CellX, int CellY, String theValue, XSpreadsheet TT1, String flag) {
        XCell xCell = null;
        try {
            xCell = TT1.getCellByPosition(CellX, CellY);
        } catch (IndexOutOfBoundsException ex) {
            System.err.println("Could not get Cell");
            ex.printStackTrace(System.err);
        }
        if (flag.equals("V")) {
            xCell.setValue((new Float(theValue)).floatValue());
        } else {
            xCell.setFormula(theValue);
        }
    }
    
}
