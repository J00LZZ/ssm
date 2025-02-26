package nl.uu.cs.ssmui;

import nl.uu.cs.ssm.*;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

public class StatusTableModel extends AbstractTableModel
        implements MemoryCellListener {
    private static final long serialVersionUID = 1L;

    private static final int C_PC = 0;
    private static final int C_SP = 1;
    private static final int C_MP = 2;
    private static final int C_R3 = 3;
    private static final int C_R4 = 4;
    private static final int C_R5 = 5;
    private static final int C_R6 = 6;
    private static final int C_R7 = 7;
    private static final int C_SR = 8;

    //private static final String[] columnNames = { "PC", "SP", "MP", "RR", "SR" } ;

    private MachineState machineState;
    private Registers registers;

    public StatusTableModel(MachineState mst) {
        machineState = mst;
        reset();
    }

    public void reset() {
        if (registers != null)
            registers.removeMemoryCellListener(this);
    	/*
        if ( memory != null )
        	memory.removeMemoryCellListener( this ) ;
		*/
        registers = machineState.getRegisters();
        registers.addMemoryCellListener(this);
        /*
        memory = machineState.getMemory() ;
        memory.addMemoryCellListener( this ) ;
        */
        fireTableChanged(new TableModelEvent(this));
        //fireTableStructureChanged() ;
    }

    public int getColumnCount() {
        return Registers.getNrRegs() + 1;
    }

    public int getRowCount() {
        return 1;
    }

    public boolean isCellEditable(int row, int column) {
        return column != C_SR;
    }

    public Object getValueAt(int row, int column) {
        Object res;
        if (column == C_SR) {
            res = machineState.getSRAsString();
        } else {
            int reg = column;
            res = Utils.asHex(registers.getReg(reg));
        }
        return res;
    }

    public void setValueAt(Object aValue, int row, int column) {
        String strValue;

        if (aValue instanceof String)
            strValue = (String) aValue;
        else
            strValue = aValue.toString();

        if (column != C_SR) {
            int reg = column;
            registers.setReg(reg, Utils.fromHex(strValue));
        }
    }

    public String getColumnName(int column) {
        return column == C_SR ? "SR" : Registers.getRegNAliasName(column);
    }

    public Class<?> getColumnClass(int column) {
        return SSMRunner.tableModelColumnClass;
    }

    public void cellChanged(MemoryCellEvent e) {
        fireTableCellUpdated(0, e.cellIndex);
    }

}
