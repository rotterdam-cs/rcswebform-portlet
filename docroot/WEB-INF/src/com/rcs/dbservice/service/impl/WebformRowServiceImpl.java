/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rcs.dbservice.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.rcs.dbservice.model.WebformTable;
import com.rcs.dbservice.service.base.WebformRowServiceBaseImpl;

/**
 * The implementation of the webform row remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rcs.dbservice.service.WebformRowService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author rikad.ramadhan@rotterdam-cs.com
 * @see com.rcs.dbservice.service.base.WebformRowServiceBaseImpl
 * @see com.rcs.dbservice.service.WebformRowServiceUtil
 */
public class WebformRowServiceImpl extends WebformRowServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rcs.dbservice.service.WebformRowServiceUtil} to access the webform row remote service.
	 */
	
	public int getRowsCount(String tableName) throws SystemException, PortalException{
		int countResult = 0;
		
		WebformTable table = webformTablePersistence.fetchByWebformName(tableName);
		
		if(table!=null){
			countResult = webformRowPersistence.countByWebformTableId(table.getWebformTableId());
		}
		
		return countResult;
	}
}