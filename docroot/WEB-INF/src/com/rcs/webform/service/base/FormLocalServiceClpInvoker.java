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

package com.rcs.webform.service.base;

import com.rcs.webform.service.FormLocalServiceUtil;

import java.util.Arrays;

/**
 * @author ryusuf
 * @generated
 */
public class FormLocalServiceClpInvoker {
	public FormLocalServiceClpInvoker() {
		_methodName0 = "addForm";

		_methodParameterTypes0 = new String[] { "com.rcs.webform.model.Form" };

		_methodName1 = "createForm";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteForm";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteForm";

		_methodParameterTypes3 = new String[] { "com.rcs.webform.model.Form" };

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchForm";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getForm";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getForms";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getFormsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateForm";

		_methodParameterTypes15 = new String[] { "com.rcs.webform.model.Form" };

		_methodName48 = "getBeanIdentifier";

		_methodParameterTypes48 = new String[] {  };

		_methodName49 = "setBeanIdentifier";

		_methodParameterTypes49 = new String[] { "java.lang.String" };

		_methodName54 = "add";

		_methodParameterTypes54 = new String[] {
				"java.lang.Long", "com.liferay.portal.service.ServiceContext",
				"java.lang.String", "java.lang.String", "boolean",
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName55 = "save";

		_methodParameterTypes55 = new String[] {
				"java.lang.Long", "com.liferay.portal.service.ServiceContext",
				"java.util.Map", "java.util.Map", "boolean", "java.util.Map",
				"java.lang.String", "java.util.Map"
			};

		_methodName56 = "save";

		_methodParameterTypes56 = new String[] {
				"java.lang.Long", "com.liferay.portal.service.ServiceContext",
				"java.lang.String", "java.lang.String", "java.util.Map",
				"java.util.Map", "boolean", "java.util.Map", "java.lang.String",
				"java.util.Map", "java.lang.String", "java.lang.String"
			};

		_methodName57 = "getFormByFormId";

		_methodParameterTypes57 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return FormLocalServiceUtil.addForm((com.rcs.webform.model.Form)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return FormLocalServiceUtil.createForm(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return FormLocalServiceUtil.deleteForm(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return FormLocalServiceUtil.deleteForm((com.rcs.webform.model.Form)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return FormLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return FormLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return FormLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return FormLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return FormLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return FormLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return FormLocalServiceUtil.fetchForm(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return FormLocalServiceUtil.getForm(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return FormLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return FormLocalServiceUtil.getForms(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return FormLocalServiceUtil.getFormsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return FormLocalServiceUtil.updateForm((com.rcs.webform.model.Form)arguments[0]);
		}

		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return FormLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			FormLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return FormLocalServiceUtil.add((java.lang.Long)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1],
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Boolean)arguments[4]).booleanValue(),
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				(java.lang.String)arguments[7]);
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			return FormLocalServiceUtil.save((java.lang.Long)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[2],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[3],
				((Boolean)arguments[4]).booleanValue(),
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[5],
				(java.lang.String)arguments[6],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[7]);
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return FormLocalServiceUtil.save((java.lang.Long)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1],
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[4],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[5],
				((Boolean)arguments[6]).booleanValue(),
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[7],
				(java.lang.String)arguments[8],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[9],
				(java.lang.String)arguments[10], (java.lang.String)arguments[11]);
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			return FormLocalServiceUtil.getFormByFormId(((Long)arguments[0]).longValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName55;
	private String[] _methodParameterTypes55;
	private String _methodName56;
	private String[] _methodParameterTypes56;
	private String _methodName57;
	private String[] _methodParameterTypes57;
}