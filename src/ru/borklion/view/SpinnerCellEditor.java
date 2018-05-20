package ru.borklion.view;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Spinner;

public class SpinnerCellEditor extends CellEditor{
	private static final int defaultStyle = SWT.NONE;
	protected Spinner spinner;
	private FocusAdapter focusListener;
	private KeyListener keyListener;
	public SpinnerCellEditor() {
		setStyle(defaultStyle);
	}
	public SpinnerCellEditor(Composite parent) {
		this(parent,defaultStyle);
	}
	public SpinnerCellEditor(Composite parent, int style) {
		super(parent,style);
	}
	@Override
	protected Control createControl(Composite parent) {
		spinner = new Spinner(parent, getStyle());
		spinner.setFont(parent.getFont());
		this.setMinimum(1);
		this.focusListener = new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				SpinnerCellEditor.this.focusLost();
			}
		};
		spinner.addFocusListener(focusListener);
		this.keyListener = new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.character == '\n') {
					SpinnerCellEditor.this.focusLost();
				}
				if (e.character == '\r') {
					SpinnerCellEditor.this.focusLost();
				}
			}
		};
		spinner.addKeyListener(keyListener);	
		return spinner;
	}
	@Override
	public void dispose() {
		if (focusListener!=null) spinner.removeFocusListener(focusListener);
		if (keyListener!=null)   spinner.removeKeyListener(keyListener);
		super.dispose();
	}
	@Override
	protected Object doGetValue() {
		return spinner.getSelection();
	}
	@Override
	protected void doSetFocus() {
		spinner.setFocus();
	}
	@Override
	public LayoutData getLayoutData() {
		LayoutData layoutData = super.getLayoutData();
		if ((spinner == null) || spinner.isDisposed()) {
			layoutData.minimumWidth = 60;
		} else {
			// make the comboBox 10 characters wide
			GC gc = new GC(spinner);
			layoutData.minimumWidth = (gc.getFontMetrics()
					.getAverageCharWidth() * 10) + 10;
			gc.dispose();
		}
		return layoutData;
	}
	@Override
	protected void doSetValue(Object value) {
		Assert.isTrue(spinner != null && (value instanceof Integer));
		spinner.setSelection(((Integer)value).intValue());		
	}
	void applyEditorValueAndDeactivate() {
		// must set the selection before getting value
		Object newValue = doGetValue();
		markDirty();
		boolean isValid = isCorrect(newValue);
		setValueValid(isValid);
		fireApplyEditorValue();
		deactivate();
	}
	@Override
	protected void focusLost() {
		if (isActivated()) {
			applyEditorValueAndDeactivate();
		}
	}
	public void setMaximum(int i) {
		if (spinner!=null) spinner.setMaximum(i);
	}
	public void setMinimum(int i) {
		if (spinner!=null) spinner.setMinimum(i);
	}
	public Spinner getSpinner() {
		return spinner;
	}
	protected int getDoubleClickTimeout() {
		return 0;
	}
	public void setIncrement(int inc) {
		if (spinner!=null) spinner.setIncrement(inc);
	}
	public void setBounds(Rectangle bnds) {
		if (spinner!=null) spinner.setBounds(bnds);
	}
	public void addKeyListener(KeyListener listener) {
		if (spinner!=null) spinner.addKeyListener(listener);
	}
	public void addSelectionListener(SelectionListener listener) {
		if (spinner!=null) spinner.addSelectionListener(listener);
	}
}
