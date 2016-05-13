package org.varelma.oc.util;

import atg.nucleus.Nucleus;
import atg.servlet.DynamoHttpServletRequest;
import atg.servlet.ServletUtil;

public class ComponentResolver {

	/**
	 * 
	 * @param componentName
	 *            The component to find
	 * @return The component (if found); null otherwise
	 * @author jon pallas
	 *  
	 */
	private static Object getGlobalBaseComponent(String componentName) {
		Nucleus nucleus = Nucleus.getGlobalNucleus();
		if (nucleus != null) {
			Object o = nucleus.resolveName(componentName);
			return o;
		}
		return null;
	}

	private static Object getBaseComponent(String componentName) {
		DynamoHttpServletRequest dynamoRequest = ServletUtil.getCurrentRequest();
		if (dynamoRequest == null) {
			return getGlobalBaseComponent(componentName);
		}
		return dynamoRequest.resolveName(componentName);
	}

	public static Object getComponent(String componentName) {
		if (componentName == null) {
			return null;
		}
		if (!componentName.contains(".")) {
			return getBaseComponent(componentName);
		}
		Object component = getBaseComponent(componentName.substring(0, componentName.indexOf('.')));
		Object result = BeanUtils.getNestedProperty(component, componentName.substring(componentName.indexOf('.') + 1, componentName.length()));
		return result;
	}

}
