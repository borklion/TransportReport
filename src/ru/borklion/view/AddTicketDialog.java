package ru.borklion.gui;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class AddTicketDialog extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public AddTicketDialog(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setSize(200, 130);
		shell.setText(getText());
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(10, 10, 59, 14);
		label.setText("Серия");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(10, 30, 59, 14);
		label_1.setText("Номер");
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(10, 50, 59, 14);
		label_2.setText("Цена");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(75, 10, 115, 19);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(75, 30, 115, 19);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(75, 50, 115, 19);
		
		Button btnOk = new Button(shell, SWT.NONE);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (text.getText() != null || text_1.getText() != null || text_2.getText() != null) {
					result = Boolean.TRUE;
					shell.close();
				}
			}
		});
		btnOk.setBounds(53, 75, 94, 28);
		btnOk.setText("OK");

	}
	public String getText( ) {
		return this.text.getText();
	}
	public String getText_1( ) {
		return this.text_1.getText();
	}
	public String getText_2( ) {
		return this.text_2.getText();
	}
}
