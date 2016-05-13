package org.varelma.oc.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.MethodUtils;

import atg.repository.RepositoryItem;

/**
 * 
 * Can be used to safely get properties from a bean, map, repositoryItem
 * 
 * Example: String merchantName = (String)BeanUtils.getNestedProperty(commerceItem,"auxiliaryData.catalogRef.merchant.merchantName"); 
 * String shippingMethod =(String)BeanUtils.getNestedProperty(merchantGroup, "commerceItems[0].shippingGroupRelationships[0].shippingGroup.shippingMethod"); this will not throw a NullPointerException in any of the elements in the
 * graph even if they are null.
 * 
 * @author jon pallas
 * 
 */
@SuppressWarnings("rawtypes")
public class BeanUtils {

	private static final Pattern PATH_PARTS = Pattern.compile("([^\\.]*).(.*)");
	private static final Pattern LIST_PARTS = Pattern.compile(".*\\[(.*)\\].*");

	public static String getNestedPropertyValue(Object o, String path) {
		Object object = getNestedProperty(o, path);
		if (object == null) {
			return "";
		}
		return object.toString();
	}

	public static Object getNestedProperty(Object o, String path) {
		if (o == null || path == null) {
			return null;
		}

		Matcher m = PATH_PARTS.matcher(path);
		boolean b1 = m.matches();
		String methodName = path;
		String endOfExpression = "";

		if (path.contains(".") && b1) {
			methodName = m.group(1);
			endOfExpression = m.group(2);
		}
		boolean containsPosition = methodNameContainsPosition(methodName);
		int elementNumber = -1;
		if (containsPosition) {
			elementNumber = elementNumber(methodName);
			methodName = methodRemovePosition(methodName);
		}
		Object newObject = executeMethod(o, methodName);

		if (newObject == null) {
			return null;
		}

		if (containsPosition) {
			newObject = getTheRightElement(newObject, elementNumber);
		}

		if (endOfExpression == null || endOfExpression.equals("")) {
			return newObject;
		}

		return getNestedProperty(newObject, endOfExpression);
	}

	private static Object executeMethod(Object o, String methodName) {
		Object newObject = null;
		try {
			if (o instanceof RepositoryItem) {
				RepositoryItem repositoryItem = (RepositoryItem) o;
				if (repositoryItem.getItemDescriptor().hasProperty(methodName)) {
					newObject = repositoryItem.getPropertyValue(methodName);
				}
			} else if (o instanceof Map) {
				Map map = (Map) o;
				newObject = map.get(methodName);
			} else {
				methodName = "get" + upperCaseFirstLetter(methodName);
				newObject = MethodUtils.invokeMethod(o, methodName, null);
			}
		} catch (Exception e) {
			// dont care
		}
		return newObject;
	}

	@SuppressWarnings("unchecked")
	private static Object getTheRightElement(Object o, int index) {
		try {
			List result = new ArrayList();
			if (o == null) {
				result = new ArrayList();
			} else if (
			// Primitive arrays
			o instanceof boolean[] || o instanceof byte[] || o instanceof char[] || o instanceof short[] || o instanceof int[] || o instanceof long[] || o instanceof float[] || o instanceof double[]) {
				result = convertArrayToList(o);
			} else if (o instanceof Object[]) {
				result = Arrays.asList((Object[]) o);
			} else if (o instanceof List) {
				result = (List) o;
			} else if (o instanceof Collection) {
				result.addAll((Collection) o);
			}
			if (result.size() >= index) {
				return result.get(index);
			}
		} catch (Exception e) {
			// dont care
		}
		return null;
	}

	private static List convertArrayToList(Object pArray) {
		if (pArray == null) {
			// Treat null as an empty list
			return new ArrayList();
		}
		int length = Array.getLength(pArray);
		if (length == 0) {
			// Empty array, so just return an empty list
			return new ArrayList();
		}
		Class wrapperType = Array.get(pArray, 0).getClass();
		Object[] newArray = (Object[]) Array.newInstance(wrapperType, length);
		for (int i = 0; i < length; i++) {
			newArray[i] = Array.get(pArray, i);
		}
		return Arrays.asList(newArray);
	}

	private static boolean methodNameContainsPosition(String methodName) {
		return methodName.contains("[");
	}

	private static String methodRemovePosition(String methodName) {
		if (!methodNameContainsPosition(methodName)) {
			return methodName;
		}
		int endIndex = methodName.indexOf('[');
		return methodName.substring(0, endIndex);
	}

	private static int elementNumber(String methodName) {
		int position = -1;
		Matcher m = LIST_PARTS.matcher(methodName);
		boolean b1 = m.matches();
		if (b1) {
			String pos = m.group(1);
			position = Integer.parseInt(pos);
		}
		return position;
	}

	private static String upperCaseFirstLetter(String s) {
		if (s == null || s.equals("")) {
			return "";
		}
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

}
