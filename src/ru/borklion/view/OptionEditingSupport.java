package ru.borklion.view;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;

import ru.borklion.dao.Trip;

public class OptionEditingSupport extends EditingSupport {

	private ComboBoxCellEditor cellEditor;
	
    public OptionEditingSupport(ColumnViewer viewer) {
        super(viewer);
        cellEditor = new ComboBoxCellEditor(((TableViewer)viewer).getTable(), new String[]{"Y", "N"});
    }

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		return cellEditor;
	}

	@Override
	protected Object getValue(Object element) {
		return 0;
	}

	@Override
	protected void setValue(Object element, Object value) {
	       if((element instanceof Trip) && (value instanceof Integer)) {
	            Integer choice = (Integer)value;
	            boolean option = (choice == 0? true:false);
	            ((Trip)element).setFlagReturnBase(option);
	            getViewer().update(element, null);
	        }		
	}
	
}
