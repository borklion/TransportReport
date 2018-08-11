package ru.borklion.view;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;

import ru.borklion.controllers.TransportReportController;
import ru.borklion.model.TransportReport;
import ru.borklion.view.dialogs.LogonWizard;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.graphics.Point;
import org.eclipse.jface.action.Action;

public class TransportReportEditor extends ApplicationWindow {

	// private Shell shell;
	private Composite composite;
	private Action actionLogon;
	private TripsComposite tripsComposite;
	private TicketsStackComposite ticketsStackComposite;
	private TransportReportController controller;

	public TransportReportEditor(Shell shell, TransportReportController controller) {
		super(shell);
		this.controller = controller;
		createActions();
		addToolBar(SWT.FLAT | SWT.WRAP);
		addMenuBar();
		addStatusLine();
	}

	// public void open() {
	// createContents();
	// }
	@Override
	protected Control createContents(Composite parent) {
		composite = new Composite(parent, SWT.NONE);
		return composite;
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
		{
			actionLogon = new Action("Войти") {
				public void run() {
					WizardDialog dialogLogonWizard = new WizardDialog(getShell(), new LogonWizard(controller));
					tripsComposite = new TripsComposite(composite, SWT.NONE);
					tripsComposite.setEnabled(false);
					tripsComposite.setBounds(180, 10, 700, 300);
					tripsComposite.addImportButtonListener(controller.AddClickTripsImportButton());

					ticketsStackComposite = new TicketsStackComposite(composite, SWT.NONE);
					ticketsStackComposite.setEnabled(false);
					ticketsStackComposite.setSize(150, 350);
//					ticketsStackComposite.addAddButtonListener(controller.AddClickTicketsStackAddButton());
//					ticketsStackComposite.addDeleteButtonListener(controller.AddClickTicketsStackDeleteButton());
					dialogLogonWizard.create();
					dialogLogonWizard.open();
//					getShell().addKeyListener(controller.addPressedEnter());
				}
			};
		}
	}

	/**
	 * Create the menu manager.
	 * 
	 * @return the menu manager
	 */
	@Override
	protected MenuManager createMenuManager() {
		MenuManager menuManager = new MenuManager("menu");
		return menuManager;
	}

	/**
	 * Create the toolbar manager.
	 * 
	 * @return the toolbar manager
	 */
	@Override
	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolBarManager = new ToolBarManager(style);
		toolBarManager.add(actionLogon);
		toolBarManager.update(true);
		return toolBarManager;
	}

	/**
	 * Create the status line manager.
	 * 
	 * @return the status line manager
	 */
	@Override
	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();
		return statusLineManager;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Редактор траспортного отчета");
	}

	/**
	 * Return the initial size of the window.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(1000, 400);
	}

	public Composite getComposite() {
		return composite;
	}
	public void TripsRefresh() {
		tripsComposite.getTripsViewer().refresh();
	}
	public void setTripsModel(TransportReport model) {
		tripsComposite.setModel(model);
	}
	public int getTicketsStackSelectionIndex() {
		return ticketsStackComposite.getSelectionIndex();
	}
	public void enabledViewers() {
		tripsComposite.setEnabled(true);
		ticketsStackComposite.setEnabled(true);
	}
	
}
