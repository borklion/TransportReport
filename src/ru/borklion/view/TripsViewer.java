package ru.borklion.view;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

import ru.borklion.model.ReportContentProvider;
import ru.borklion.model.ReportLabelProvider;
import ru.borklion.model.TripsColumn;

public class TripsViewer extends TableViewer {

	public TripsViewer(Composite parent, int style) {
		super(parent, style);
		Table table = getTable();
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		table.setLayoutData(gridData);
		createColumns();
		setContentProvider(new ReportContentProvider());
		setLabelProvider(new ReportLabelProvider());
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
	}

	private void createColumns() {
		TableViewerColumn column;
		column = createTableViewerColumn(TripsColumn.COLUMN_DATETRIP_NAME, 100, TripsColumn.COLUMN_DATETRIP_INDEX);
		column = createTableViewerColumn(TripsColumn.COLUMN_IDREQUEST_NAME, 100, TripsColumn.COLUMN_IDREQUEST_INDEX);
		column = createTableViewerColumn(TripsColumn.COLUMN_ADDRESS_NAME, 100, TripsColumn.COLUMN_ADDRESS_INDEX);
		column = createTableViewerColumn(TripsColumn.COLUMN_TRANSPORTTYPE_NAME, 100, TripsColumn.COLUMN_TRANSPORTTYPE_INDEX);
		column = createTableViewerColumn(TripsColumn.COLUMN_NUMBEROFBUSSTOP_NAME, 100, TripsColumn.COLUMN_NUMBEROFBUSSTOP_INDEX);
		column = createTableViewerColumn(TripsColumn.COLUMN_FLAGRETURNBASE_NAME, 100, TripsColumn.COLUMN_FLAGRETURNBASE_INDEX);
		column = createTableViewerColumn(TripsColumn.COLUMN_TICKETS_NAME, 100, TripsColumn.COLUMN_TICKETS_INDEX);
		column.setEditingSupport(new OptionEditingSupport(this));
	}
    private TableViewerColumn createTableViewerColumn(String header, int width, int idx) 
    {
        TableViewerColumn column = new TableViewerColumn(this, SWT.LEFT, idx);
        column.getColumn().setText(header);
        column.getColumn().setWidth(width);
        column.getColumn().setResizable(true);
        column.getColumn().setMoveable(true);
        return column;
    }
}
