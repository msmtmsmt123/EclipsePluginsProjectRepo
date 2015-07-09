/*
* generated by Xtext
*/
package com.odcgroup.service.model.ui.outline;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;

import com.odcgroup.mdf.metamodel.MdfEntity;
import com.odcgroup.service.model.component.Argument;
import com.odcgroup.service.model.component.Attribute;
import com.odcgroup.service.model.component.Component;
import com.odcgroup.service.model.component.Constant;
import com.odcgroup.service.model.component.Content;
import com.odcgroup.service.model.component.Interface;
import com.odcgroup.service.model.component.Method;
import com.odcgroup.service.model.component.Property;
import com.odcgroup.service.model.component.ReadWrite;
import com.odcgroup.service.model.component.Table;

/**
 * customization of the default outline structure
 *
 */
public class ComponentOutlineTreeProvider extends DefaultOutlineTreeProvider {

	@Override
	protected boolean _isLeaf(EObject modelElement) {
		return false;
	}

	@Override
	protected void _createChildren(IOutlineNode parentNode, EObject modelElement) {
		for (EObject childElement : modelElement.eContents()) {
			if (childElement instanceof Content) {
				Content content = (Content) childElement;
				if (isMethod(content)) {
					Method method = content.getMethod().get(0);
					createNode(parentNode, method);
				} else if (isTable(content)) {
					Table table = content.getTable().get(0);
					createNode(parentNode, table);
				} else if (isProperty(content)) {
					Property prop = content.getProperty().get(0);
					createNode(parentNode, prop);
				} else if (isConstant(content)) {
					Constant cnst = content.getConstant().get(0);
					createNode(parentNode, cnst);
				} else if (isInterface(content)) {
					createNode(parentNode, content.getInterface());
				}
			} else if (childElement instanceof Argument
					|| childElement instanceof Attribute) {
				createNode(parentNode, childElement);
			}
		}
	}

	@Override
	protected Object _text(Object element) {
		StringBuilder prefixBuilder = new StringBuilder();
		StringBuilder suffixBuilder = new StringBuilder();
		String elementText = "";
		if (element instanceof Component) {
			Component component = (Component) element;
			elementText = component.getName();
		} else if (element instanceof Method) {
			Method method = (Method) element;
			elementText = method.getName();
			String type = method.getType();
			if (!StringUtils.isBlank(type)) {
				suffixBuilder.append(" ["+method.getType()+"]");
			}
		} else if (element instanceof Argument) {
			Argument arg = (Argument) element;
			elementText = arg.getName();
			MdfEntity type = arg.getType();
			if (type != null && type.getQualifiedName() != null) {
				suffixBuilder.append(" ["+type.getQualifiedName().toString()+"]");
				suffixBuilder.append(" "+arg.getMultiplicity().getName());
			}
		} else if (element instanceof Table) {
			Table table = (Table) element;
			elementText = table.getTableName();
			String type = table.getType();
			if (!StringUtils.isBlank(type)) {
				suffixBuilder.append(" ["+table.getType()+"]");
			}
		} else if (element instanceof Attribute) {
			Attribute attr = (Attribute) element;
			elementText = attr.getAttrName();
			String jbcName = attr.getJBCName();
			if (!StringUtils.isBlank(jbcName)) {
				suffixBuilder.append(" ["+ jbcName +"]");
			}
			suffixBuilder.append(" = "+attr.getValue());
		} else if (element instanceof Property) {
			Property prop = (Property) element;
			elementText = prop.getPropertyName();
			if (ReadWrite.READONLY.equals(prop.getReadOnly())) {
				suffixBuilder.append(" R ");
			} else {
				suffixBuilder.append(" RW ");
			}
			if (!StringUtils.isBlank(prop.getType1()) && !StringUtils.isBlank(prop.getType2())) {
				suffixBuilder.append(" ["+prop.getType1()+" -> "+prop.getType2()+"]");
			}
		} else if (element instanceof Constant) {
			Constant cnst = (Constant) element;
			elementText = cnst.getConstantName();
			String jbcName = cnst.getJBCName();
			if (!StringUtils.isBlank(jbcName)) {
				suffixBuilder.append(" ["+jbcName+"]");
			}
			suffixBuilder.append(" = "+cnst.getValue());
		} else if (element instanceof Interface) {
			Interface intf = (Interface) element;
			elementText = intf.getName();
		}
		prefixBuilder.append(elementText + suffixBuilder.toString());
		String result = prefixBuilder.toString();
		return result;
	}

	private boolean isMethod(Content content) {
		if (content.getMethod() != null && !content.getMethod().isEmpty()) {
			return true;
		}
		return false;
	}

	private boolean isTable(Content content) {
		if (content.getTable() != null && !content.getTable().isEmpty()) {
			return true;
		}
		return false;
	}

	private boolean isProperty(Content content) {
		if (content.getProperty() != null && !content.getProperty().isEmpty()) {
			return true;
		}
		return false;
	}

	private boolean isConstant(Content content) {
		if (content.getConstant() != null && !content.getConstant().isEmpty()) {
			return true;
		}
		return false;
	}
	
	private boolean isInterface(Content content) {
		if (content.getInterface() != null) {
			return true;
		}
		return false;
	}

}
