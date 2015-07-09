package com.odcgroup.pageflow.editor.diagram.custom.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPage;

import com.odcgroup.pageflow.editor.diagram.custom.request.ChangeTransitionLabelDisplayRequest;
import com.odcgroup.pageflow.editor.diagram.part.Messages;
import com.odcgroup.pageflow.editor.diagram.part.PageflowDiagramEditorPlugin;

public class ActionLabelDisplayAction extends DiagramAction {

	public ActionLabelDisplayAction(IWorkbenchPage workbenchPage) {
		super(workbenchPage);
	}

	@Override
	public void init() {
		super.init();
		setId(Messages.ActionLabelDisplayToolBarId);
		setText(Messages.ActionLabelDisplayText);
		setToolTipText(Messages.ActionLabelDisplayText);
		setImageDescriptor(getImageDescriptor("icons/cust16/Transition.gif"));
		setDisabledImageDescriptor(getImageDescriptor("icons/cust16/Transition.gif"));
	}

	@Override
	protected Request createTargetRequest() {
		return new ChangeTransitionLabelDisplayRequest();
	}

	@Override
	protected boolean isSelectionListener() {
		return true;
	}

	/**
	 * @param imageName
	 * @return
	 */
	protected static ImageDescriptor getImageDescriptor(String imageName) {
		return PageflowDiagramEditorPlugin.findImageDescriptor(imageName);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#createOperationSet()
	 */
	protected List createOperationSet() {
		List selection = getSelectedObjects();
		if (selection.isEmpty() || !(selection.get(0) instanceof EditPart)) {
			return Collections.EMPTY_LIST;
		} 		
		

		List<DiagramEditPart> targetedEPs = new ArrayList<DiagramEditPart>();
		if (selection.get(0) instanceof DiagramEditPart) {
			DiagramEditPart selectedEP = (DiagramEditPart)selection.get(0);
	    	targetedEPs.add(selectedEP);
		}		
		return targetedEPs.isEmpty() ? Collections.EMPTY_LIST : targetedEPs;
	}

}
