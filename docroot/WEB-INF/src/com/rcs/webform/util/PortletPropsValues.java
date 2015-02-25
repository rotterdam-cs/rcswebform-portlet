

package com.rcs.webform.util;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.util.portlet.PortletProps;


public class PortletPropsValues {

	public static final String CSV_SEPARATOR = GetterUtil.getString(
		PortletProps.get(PortletPropsKeys.CSV_SEPARATOR));

	public static final boolean DATA_FILE_PATH_CHANGEABLE =
		GetterUtil.getBoolean(
			PortletProps.get(PortletPropsKeys.DATA_FILE_PATH_CHANGEABLE));

	public static final String DATA_ROOT_DIR = GetterUtil.getString(
		PortletProps.get(PortletPropsKeys.DATA_ROOT_DIR));

	public static final String EMAIL_FROM_ADDRESS = GetterUtil.getString(
		PortletProps.get(PortletPropsKeys.EMAIL_FROM_ADDRESS));

	public static final String EMAIL_FROM_NAME = GetterUtil.getString(
		PortletProps.get(PortletPropsKeys.EMAIL_FROM_NAME));

	public static final boolean VALIDATION_SCRIPT_ENABLED =
		GetterUtil.getBoolean(
			PortletProps.get(PortletPropsKeys.VALIDATION_SCRIPT_ENABLED));

}