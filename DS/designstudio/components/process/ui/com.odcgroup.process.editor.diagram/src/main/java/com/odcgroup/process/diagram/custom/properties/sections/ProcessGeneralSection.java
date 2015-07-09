package com.odcgroup.process.diagram.custom.properties.sections;

import com.odcgroup.process.model.ProcessPackage;
import com.odcgroup.workbench.editors.properties.section.AbstractPropertiesSection;
import com.odcgroup.workbench.editors.properties.widgets.SimpleGroupWidget;
import com.odcgroup.workbench.editors.properties.widgets.SimpleTextWidget;

public class ProcessGeneralSection extends AbstractPropertiesSection {	

	
	/* (non-Javadoc)
	 * @see com.odcgroup.workbench.editors.properties.section.AbstractPropertiesSection#configureProperties()
	 */
	protected void configureProperties() {
		
		setUseThreeFourthLayout(true);
		SimpleGroupWidget group = new SimpleGroupWidget(null);
		
		SimpleTextWidget pageflowName = new SimpleTextWidget(ProcessPackage.eINSTANCE.getProcess_DisplayName(),
				"Display Name");
		pageflowName.setFillHorizontal(true);
		group.addPropertyFeature(pageflowName);
		
		SimpleTextWidget pageflowDesc = new SimpleTextWidget(ProcessPackage.eINSTANCE.getProcess_Comment(),
				"Comment");
		pageflowDesc.setMultiline(true);
		group.addPropertyFeature(pageflowDesc);
		
		this.addPropertyFeature(group);	
			
	}

}
