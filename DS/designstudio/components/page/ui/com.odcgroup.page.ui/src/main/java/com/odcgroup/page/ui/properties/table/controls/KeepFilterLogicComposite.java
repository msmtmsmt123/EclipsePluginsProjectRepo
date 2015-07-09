package com.odcgroup.page.ui.properties.table.controls;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.odcgroup.page.metamodel.DataValue;
import com.odcgroup.page.model.util.TableHelper;
import com.odcgroup.page.model.widgets.table.ITable;
import com.odcgroup.page.ui.command.table.UpdateTableKeepFilterLogicCommand;

/**
 * TODO: Document me!
 *
 * @author pkk
 *
 */
public class KeepFilterLogicComposite implements SpecialControl<ITable> {
	/** */
	private ITable input;
	/** */
	private DataTypeCombo logicCombo;
	/** */
	private CommandStack commandStack;

	/**
	 * @param parent
	 */
	public KeepFilterLogicComposite(Composite parent) {
		createControls(parent);
	}
	
	/**
	 * @param parent
	 */
	protected void createControls(Composite parent) {
		Composite body = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout(2, false);
		body.setLayout(gridLayout);	
		body.setBackground(parent.getBackground());
		new Label(body, SWT.NONE).setText("Multiple Keep Filter logic");
		logicCombo = new DataTypeCombo(body, TableHelper.getTableUtilities().getKeepFilterLogics(), true);
		logicCombo.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				DataValue data = logicCombo.getSelectedValue();
				Command command = new UpdateTableKeepFilterLogicCommand(input, data.getValue());
				commandStack.execute(command);
			}
		});
	}

	/**
	 * (non-Javadoc)
	 * @see com.odcgroup.page.ui.properties.table.controls.SpecialControl#setInput(java.lang.Object)
	 */
	@Override
	public void setInput(ITable input) {
		this.input = input;
		logicCombo.select(input.getKeepFilterLogic().getValue());
	}	
	
	/**
	 * @param commandStack
	 */
	public void setCommandStack(CommandStack commandStack) {
		this.commandStack = commandStack;
	}

	/**
	 * (non-Javadoc)
	 * @see com.odcgroup.page.ui.properties.table.controls.SpecialControl#setEnabled(boolean)
	 */
	public void setEnabled(boolean enabled) {
		logicCombo.setEnabled(enabled);		
	}

}
