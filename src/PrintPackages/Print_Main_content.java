package PrintPackages;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Sides;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.print.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.MessageFormat;
import java.util.Arrays;
//

public class Print_Main_content {
    public DefaultTableModel modelMarksheet;
    private int option;

    public Print_Main_content(DefaultTableModel model, int option) {
        modelMarksheet=model;
        System.out.println("this is print_main_content option is :"+option);
        // option 1 is gui frame with print dialog, option 2 is no gui frame only print dialog,3 means no gui frame no print dialog total silent print

        if (option == 1) {
            // This is for frame and dialog
            print_with_Full_Dialog();
        } else if (option == 2) {
            //this is for only print default dialog
            print_with_only_dialog();
        } else if (option == 3) {
            // this print silently with out gui frame or dialog
             print_with_no_GuI();


        }
        else if(option==4){
            print_tableTopdf();
        }
    }

    // This is for frame and dialog
    public void print_with_Full_Dialog() {
        new PrintLibrary(modelMarksheet, option).setVisible(true);
    }

    //this is for only print default dialog
    public void print_with_only_dialog() {
        JTable table = GetTable();
        PrinterJob job = PrinterJob.getPrinterJob();
        MessageFormat[] header = new MessageFormat[13];
        header[0] = new MessageFormat("");
        header[1] = new MessageFormat(" ");
        header[2] = new MessageFormat("                            Noble Secondary English Boarding School");
        header[3] = new MessageFormat(" ");
        header[4] = new MessageFormat("                                             Janakpur Dham-12");
        header[5] = new MessageFormat(" ");
        header[6] = new MessageFormat("                                    Second Terminal Examination");
        header[7] = new MessageFormat(" ");
        header[8] = new MessageFormat("");
        header[9] = new MessageFormat("Class: X");
        header[10] = new MessageFormat("                                                                             GRADE-SHEET");
        header[11] = new MessageFormat(" ");
        header[12] = new MessageFormat("The marks secured by sd Roll No :- 3 has passed annual examination of 2078 B.S are given below.");

        MessageFormat[] footer = new MessageFormat[8];
        footer[0] = new MessageFormat(" __________________                                                                                   ________________");
        footer[1] = new MessageFormat("");
        footer[2] = new MessageFormat("        Prepared By                                                                                       Principal");
        footer[3] = new MessageFormat("");
        footer[4] = new MessageFormat("");
        footer[5] = new MessageFormat("");
        footer[6] = new MessageFormat("");
        footer[7] = new MessageFormat("Date of Issue_______________");
        //boolean complete=

        job.setPrintable(new MyTablePrintable(table, JTable.PrintMode.FIT_WIDTH, header, footer));

        if (job.printDialog()) {
            try {
                job.print();
                /* show a success message */
                JOptionPane.showMessageDialog(new JFrame(),
                        "Printing Complete",
                        "Printing Result",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (PrinterException pe) {
                /* Printing failed, report to the user */
                JOptionPane.showMessageDialog(new JFrame(),
                        "Printing Failed: " + pe.getMessage(),
                        "Printing Result",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            /* show a message indicating that printing was cancelled */
            JOptionPane.showMessageDialog(new JFrame(),
                    "Printing Cancelled",
                    "Printing Result",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // this print silently with out gui frame or dialog
    public void print_with_no_GuI() {
        PrinterJob job = PrinterJob.getPrinterJob();
        MessageFormat[] header = new MessageFormat[13];
        header[0] = new MessageFormat("");
        header[1] = new MessageFormat(" ");
        header[2] = new MessageFormat("                            Noble Secondary English Boarding School");
        header[3] = new MessageFormat(" ");
        header[4] = new MessageFormat("                                             Janakpur Dham-12");
        header[5] = new MessageFormat(" ");
        header[6] = new MessageFormat("                                    Second Terminal Examination");
        header[7] = new MessageFormat(" ");
        header[8] = new MessageFormat("");
        header[9] = new MessageFormat("Class: X");
        header[10] = new MessageFormat("                                                                             GRADE-SHEET");
        header[11] = new MessageFormat(" ");
        header[12] = new MessageFormat("The marks secured by sd Roll No :- 3 has passed annual examination of 2078 B.S are given below.");

        MessageFormat[] footer = new MessageFormat[8];
        footer[0] = new MessageFormat(" __________________                                                                                   ________________");
        footer[1] = new MessageFormat("");
        footer[2] = new MessageFormat("        Prepared By                                                                                       Principal");
        footer[3] = new MessageFormat("");
        footer[4] = new MessageFormat("");
        footer[5] = new MessageFormat("");
        footer[6] = new MessageFormat("");
        footer[7] = new MessageFormat("Date of Issue_______________");
        //boolean complete=
        JTable table = GetTable();
        job.setPrintable(new MyTablePrintable(table, JTable.PrintMode.FIT_WIDTH, header, footer));

            try {
                job.print();
                /* show a success message */
                JOptionPane.showMessageDialog(new JFrame(),
                        "Printing Complete",
                        "Printing Result",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (PrinterException pe) {
                /* Printing failed, report to the user */
                JOptionPane.showMessageDialog(new JFrame(),
                        "Printing Failed: " + pe.getMessage(),
                        "Printing Result",
                        JOptionPane.ERROR_MESSAGE);
            }
    }

    public JTable GetTable() {
        JTable gradesTable = new JTable(modelMarksheet);//createTable(new GradesModel());
        gradesTable.setFillsViewportHeight(true);
        Font font1 = new Font("Arial", Font.PLAIN, 28);
        gradesTable.setFont(font1);
        gradesTable.setBounds(10, 5, 1120, 550);
        gradesTable.setForeground(Color.black);
        gradesTable.setRowHeight(80);
        //gradesTable.setBackground(Color.cyan);

        //setting table header font */
        JTableHeader tableHeader = gradesTable.getTableHeader();
        tableHeader.setFont(font1);
        tableHeader.setForeground(Color.BLACK);
        //tableHeader.setBackground(new Color(13,91,31));
        tableHeader.setPreferredSize(new Dimension(100, 100));
        /* hide horizontal line */
        gradesTable.setShowHorizontalLines(false);
        gradesTable.setGridColor(Color.orange);

        /* Set a custom renderer on the "Passed" column */
        //gradesTable.getColumn("Passed").setCellRenderer(createPassedColumnRenderer());

        /* put all Value on center oj column*/
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        int numberofcols = gradesTable.getColumnCount();
        for (int x = 0; x < numberofcols; x++) {
            gradesTable.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
        }
        return gradesTable;
    }
    private void print_tableTopdf() {
        try {
            JTable table = GetTable();
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("marksheet.pdf"));
            doc.open();
            com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLD, BaseColor.RED);
            com.itextpdf.text.Font font1 = FontFactory.getFont(FontFactory.TIMES_ITALIC, 14, Font.PLAIN, BaseColor.BLACK);

            doc.add(new Paragraph("                          Noble Secondary English Boarding School", font));
            doc.add(new Paragraph("                                            Janakpur Dham-12", font));
            doc.add(new Paragraph("                             Second Terminal Examination", font));
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("Class-IX", font1));
            doc.add(new Paragraph("                                                                 Grade-Sheet", font1));
            doc.add(new Paragraph("The marks secured by sd Roll No :- 3 has passed annual examination of 2078 B.S are given below.", font1));
            doc.add(new Paragraph("______________________________________________________________________________"));
            doc.add(new Paragraph("\n"));

            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
            pdfTable.setWidthPercentage(90);
            PdfPCell cell;
            //adding table headers
            for (int i = 0; i < table.getColumnCount(); i++) {
                pdfTable.addCell(table.getColumnName(i));
            }
            //extracting data from the JTable and inserting it to PdfPTable
            for (int rows = 0; rows < table.getRowCount() - 1; rows++) {
                for (int cols = 0; cols < table.getColumnCount(); cols++) {
                    cell = new PdfPCell();
                    cell.setFixedHeight(34);// Control the fixed height of each cell
                    String cellValue = table.getModel().getValueAt(rows, cols).toString();
                    cell.addElement(new Paragraph(cellValue));
                    pdfTable.addCell(cell);
                    // pdfTable.addCell(table.getModel().getValueAt(rows, cols).toString());

                }
            }
            doc.add(pdfTable);
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("              __________________                                                                      ________________"));
            doc.add(new Paragraph("              Prepared By                                                                                             Principal"));
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("              Date of Issue_______________"));
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("______________________________________________________________________________"));


            doc.close();

            //https://stackoverflow.com/questions/29755305/itext-direct-printing

            DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PAGEABLE;
            PrintRequestAttributeSet patts = new HashPrintRequestAttributeSet();
            patts.add(Sides.DUPLEX);
            PrintService[] ps = PrintServiceLookup.lookupPrintServices(flavor, patts);
            if (ps.length == 0) {
               throw new IllegalStateException("No Printer found");
            }
            System.out.println("Available printers: " + Arrays.asList(ps));

            PrintService myService = null;
            for (PrintService printService : ps) {
                if (printService.getName().equals("Your printer name")) {
                    myService = printService;
                    break;
                }
            }

            if (myService == null) {
                throw new IllegalStateException("Printer not found");
            }

            FileInputStream fis = new FileInputStream("marksheet.pdf");
            Doc pdfDoc = new SimpleDoc(fis, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
            DocPrintJob printJob = myService.createPrintJob();
            printJob.print(pdfDoc, new HashPrintRequestAttributeSet());
            fis.close();

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
