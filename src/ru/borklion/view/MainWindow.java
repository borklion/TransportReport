package ru.borklion.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import ru.borklion.controllers.TransportReportController;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;

public class MainWindow {

	protected Shell shell;

	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(700, 400);
		shell.setText("Transport Report Util");
		shell.setLayout(new FormLayout());
		
		Label labelMain = new Label(shell, SWT.NONE);
		FormData fd_labelMain = new FormData();
		fd_labelMain.right = new FormAttachment(100, -10);
		labelMain.setLayoutData(fd_labelMain);
		labelMain.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 12, SWT.NORMAL));
		
		Button button = new Button(shell, SWT.NONE);
		fd_labelMain.top = new FormAttachment(button, 6, SWT.TOP);
		fd_labelMain.left = new FormAttachment(button, 6);
		FormData fd_button = new FormData();
		fd_button.top = new FormAttachment(0, 10);
		fd_button.left = new FormAttachment(0, 10);
		fd_button.right = new FormAttachment(100, -610);
		button.setLayoutData(fd_button);
		button.setText("Войти");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setVisible(false);
		StackLayout layout = new StackLayout();
		composite.setLayout(layout);
		FormData fd_composite = new FormData();
		fd_composite.top = new FormAttachment(labelMain, 6);
		fd_composite.bottom = new FormAttachment(100);
		fd_composite.right = new FormAttachment(0, 700);
		fd_composite.left = new FormAttachment(0);
		composite.setLayoutData(fd_composite);

		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TransportReportController.Logon(composite);
				composite.setVisible(true);
			}
		});
		
	}
}
