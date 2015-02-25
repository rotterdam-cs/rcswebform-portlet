package com.rcs.webform.util;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.portlet.PortletProps;

public class GeneralUtil {
	
	public static Log log = LogFactoryUtil.getLog(GeneralUtil.class);
	
	public static final String DATA_FILE_PATH_CHANGEABLE ="data.file.path.changeable";
	public static final String DATA_ROOT_DIR = "data.root.dir";
	
	public static String getNewDatabaseTableName(String portletResources) throws SystemException{
		
		log.info("###--- Creating New Database Table Name ---###");
		
		String databaseTableName = null;
		
		long webformCounter = CounterLocalServiceUtil.increment(ConfigurationModel.class.getName());
		
		databaseTableName = portletResources+StringPool.UNDERLINE+webformCounter;
		
		log.info("webformCounter : "+webformCounter);
		log.info("Database Table Name : "+databaseTableName);
		
		return databaseTableName;
	}
	
	public static String getFileName(ThemeDisplay themeDisplay, String portletResources){
		StringBuilder fileName = new StringBuilder();
		
		fileName.append(GetterUtil.getString(PortletProps.get(DATA_ROOT_DIR)));
		fileName.append(StringPool.FORWARD_SLASH);
		fileName.append(themeDisplay.getScopeGroupId());
		fileName.append(StringPool.FORWARD_SLASH);
		fileName.append(themeDisplay.getPlid());
		fileName.append(StringPool.FORWARD_SLASH);
		fileName.append(portletResources);
		fileName.append(".csv");
		
		return fileName.toString();
	}
}
