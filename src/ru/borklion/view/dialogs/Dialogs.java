package ru.borklion.view.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class Dialogs {
	private Dialogs() {}
	
	public static int showError(Shell shell, String title, String message) {
		MessageBox dialog = new MessageBox(shell, SWT.ERROR);
		dialog.setText(title);
		dialog.setMessage(message);
		int result = dialog.open();
		return result;
	}
}
