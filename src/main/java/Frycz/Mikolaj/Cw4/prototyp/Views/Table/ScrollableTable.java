package Frycz.Mikolaj.Cw4.prototyp.Views.Table;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.AbstractTableModel;

/**
 * Custom scrollable table class.
 */
public class ScrollableTable extends JScrollPane {

    /**
     * If true, debug data will be printed, if false, not.
     */
    private boolean DEBUG = true;

    private JTable table;
    
    /**
     * Scrollable table constructor
     */
    public ScrollableTable() {
        
        table = new JTable(new MyTableModel());
        table.setPreferredScrollableViewportSize(new Dimension(1600, 900)); // Set preferred size
        table.setFillsViewportHeight(true); // Optional: fill the viewport height

        setViewportView(table);
    }
    
    /**
     * Custom table model inner class.
     * Used to set custom methods and parameters to the table class.
     */
    public class MyTableModel extends AbstractTableModel {
        
        private String[] columnNames = {"Denominations:",
                                        "Change to return:",
                                        "Change in cash:"};
        
        private Object[][] data = {
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")},
            {new String(""),new String(""), new String("")}

        };
        
        private static final long serialVersionUID = 1L;

        /**
         * Column count getter.
         * @return Column count (integer)
         */
        public int getColumnCount() {
            return columnNames.length;
        }
	
        /**
         * Row count getter.
         * @return Row count (integer)
         */
        public int getRowCount() {
            return data.length;
        }

	/**
         * Column name getter.
         * @param col Column
         * @return Column name.
         */
        public String getColumnName(int col) {
            return columnNames[col];
        }

	/**
         * Get value from a specific table cell.
         * @param row Row index
         * @param col Column index
         * @return Value from chosen cell.
         */
        public Object getValueAt(int row, int col) {
            return data[row][col];
        }
        
        /**
         * Specify which cells are editable and which are not.
         * @param row Row index
         * @param col Column index
         * @return Boolean (true if editable, false if not)
         */
        public boolean isCellEditable(int row, int col) {
            //uwaga - adres komorki jest staly, niezaleznie
            //od aktualnego polozenia na ekranie
            if (col < 2) {
                return true;
            } else {
                return false;
            }
        }
        
        /**
         * Set value at a specific table cell.
         * @param value Value to set
         * @param row Row index
         * @param col Column index
         */
        public void setValueAt(Object value, int row, int col) {
            if (DEBUG) {
                System.out.println("Setting value at " + row + "," + col
                                   + " to " + value
                                   + " (an instance of "
                                   + value.getClass() + ")");
            }
            
			//wlasciwa aktualizacja
            data[row][col] = value;
            //wywolanie metody generujacej zdarzenie informujace
            //o zmianie zawartosci komorki
            fireTableDataChanged();

            if (DEBUG) {
                System.out.println("New value of data:");
                printDebugData();
            }
        }
        
        /**
         * Method used to print debug data informing about table operations.
         */
        private void printDebugData() {
            int numRows = getRowCount();
            int numCols = getColumnCount();

            for (int i=0; i < numRows; i++) {
                System.out.print("    row " + i + ":");
                for (int j=0; j < numCols; j++) {
                    System.out.print("  " + data[i][j]);
                }
                System.out.println();
            }
            System.out.println("--------------------------");
        }
        
        
    }
    
    /**
     * Table getter.
     * @return JTable object
     */
    public JTable getTable() {
        return table;
    }
    
    /**
     * Set model to the table.
     * @param model Model to set.
     */
    public void setModel(MyTableModel model) {
        table.setModel(model);
    }
}
