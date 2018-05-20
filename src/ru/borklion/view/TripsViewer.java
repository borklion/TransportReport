package ru.borklion.view;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import ru.borklion.model.ReportContentProvider;
import ru.borklion.model.ReportLabelProvider;
import ru.borklion.model.TripsColumn;

public class TripsViewer extends TableViewer {
	private Table table;

	public TripsViewer(Composite parent, int style) {
		super(parent, style);
		table = getTable();
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		table.setLayoutData(gridData);
		createColumns();
		setContentProvider(new ReportContentProvider());
		setLabelProvider(new ReportLabelProvider());
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		CellEditor[] editors = new CellEditor[6];
		editors[0] = new TextCellEditor(table);
		editors[1] = new TextCellEditor(table);
		editors[2] = new TextCellEditor(table);
		editors[3] = new TextCellEditor(table);
//		TextCellEditor textEditor = new TextCellEditor(table);
//		((Text) textEditor.getControl()).addVerifyListener(new VerifyListener() {
//			public void verifyText(VerifyEvent e) {
//				e.doit = "0123456789".indexOf(e.text) >= 0;
//			}
//		});
		editors[4] = new SpinnerCellEditor(table);
		editors[5] = new CheckboxCellEditor(table);
		setColumnProperties(TripsColumn.PROPS);
		setCellModifier(new TripsCellModifer(this));
		setCellEditors(editors);
	}

	private void createColumns() {
		createTableViewerColumn(TripsColumn.DATETRIP, 100, SWT.LEFT);
		createTableViewerColumn(TripsColumn.IDREQUEST, 100, SWT.LEFT);
		createTableViewerColumn(TripsColumn.ADDRESS, 100, SWT.LEFT);
		createTableViewerColumn(TripsColumn.TRANSPORTTYPE, 100, SWT.CENTER);
		createTableViewerColumn(TripsColumn.NUMBEROFBUSSTOP, 100, SWT.CENTER);
		createTableViewerColumn(TripsColumn.FLAGRETURNBASE, 100, SWT.CENTER);
		createTableViewerColumn(TripsColumn.TICKETS, 100, SWT.LEFT);
	}

	private TableColumn createTableViewerColumn(String header, int width, int style) {
		TableColumn column = new TableColumn(table, style);
		column.setText(header);
		column.setWidth(width);
		column.setResizable(true);
		column.setMoveable(true);
		return column;
	}
}
