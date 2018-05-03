package ru.borklion.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;

public class MainWindow {
	
	private Shell shell;
	private Composite composite;
	private Button button;

	public MainWindow(Shell shell) {
		this.shell = shell;
	}
	
	public void open() {
		createContents();
	}

	/**
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shell.setSize(1000, 400);
		shell.setText("Transport Report Util");
		shell.setLayout(new FormLayout());
		
		Label labelMain = new Label(shell, SWT.NONE);
		FormData fd_labelMain = new FormData();
		fd_labelMain.right = new FormAttachment(100, -10);
		labelMain.setLayoutData(fd_labelMain);
		labelMain.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 12, SWT.NORMAL));
		
		button = new Button(shell, SWT.NONE);
		fd_labelMain.top = new FormAttachment(button, 6, SWT.TOP);
		fd_labelMain.left = new FormAttachment(button, 6);
		FormData fd_button = new FormData();
		fd_button.top = new FormAttachment(0, 10);
		fd_button.left = new FormAttachment(0, 10);
		fd_button.right = new FormAttachment(100, -610);
		button.setLayoutData(fd_button);
		button.setText("Войти");
		
		composite = new Composite(shell, SWT.NONE);
		composite.setVisible(false);
		StackLayout layout = new StackLayout();
		composite.setLayout(layout);
		FormData fd_composite = new FormData();
		fd_composite.top = new FormAttachment(labelMain, 6);
		fd_composite.bottom = new FormAttachment(100);
		fd_composite.right = new FormAttachment(0, 1000);
		fd_composite.left = new FormAttachment(0);
		composite.setLayoutData(fd_composite);
	}
	public Button getButtonLogon() {
		return button;
	}
	public Composite getComposite() {
		return composite;
	}
}
