package com.odcgroup.page.model.filter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;

import com.odcgroup.page.metamodel.PropertyType;
import com.odcgroup.page.metamodel.PropertyTypeConstants;
import com.odcgroup.page.model.Property;
import com.odcgroup.page.model.Widget;
import com.odcgroup.page.model.util.FilterUtils;
/**
 * Filter Class for the CaldateField Widget. 
 * @author snn
 *
 */
public class CaldateFieldPropertyFilter implements PropertyFilter {
    private String[] filterProperties={PropertyTypeConstants.PREVIEW_VALUE,
            PropertyTypeConstants.ACCESS_KEY ,
            PropertyTypeConstants.TAB_INDEX ,
            PropertyTypeConstants.EDITABLE_IS_BASED_ON,
            PropertyTypeConstants.MAXCHARACTERS_TYPE,
            PropertyTypeConstants.REQUIRED ,
            PropertyTypeConstants.HORIZONTAL_ALIGNMENT ,
            PropertyTypeConstants.VERTICAL_ALIGNMENT ,
            PropertyTypeConstants.PATTERN_TYPE,
            PropertyTypeConstants.CSS_CLASS,
            PropertyTypeConstants.TYPE,
            PropertyTypeConstants.WIDTH,
            PropertyTypeConstants.NILLABLE_TYPE,
            PropertyTypeConstants.FREE_DATE_TYPE,
            PropertyTypeConstants.WIDGET_GROUP
           

};
	
	public List<Property> filter(Widget widget) {
		Set<PropertyType> allTypes = new HashSet<PropertyType>();
		allTypes.addAll(widget.getType().getAllPropertyTypes().values());
		EList<Property> widgteProperties=widget.getProperties();
		Widget root=widget.getRootWidget();
		Property frgamntType=root.findProperty(PropertyTypeConstants.FRAGMENT_TYPE);
		if((frgamntType!=null&&frgamntType.getValue().equals("xtooltip"))){
			Property editable=widget.findProperty(PropertyTypeConstants.EDITABLE);
			//set the editable value to false and hide the property
			if(editable!=null){
				editable.setValue(false);
				allTypes.remove(editable.getType());
			}
			for(String property:Arrays.asList(filterProperties)){
			  FilterUtils.hideProperty(property, widget, allTypes);
			}
		  	
		}
		
		List<Property> filteredProperties = FilterUtils.filterProperties(widgteProperties, allTypes);
		return filteredProperties;
	}

}
