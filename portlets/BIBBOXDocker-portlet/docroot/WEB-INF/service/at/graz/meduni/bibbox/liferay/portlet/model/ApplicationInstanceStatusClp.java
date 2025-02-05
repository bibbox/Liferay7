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

package at.graz.meduni.bibbox.liferay.portlet.model;

import aQute.bnd.annotation.ProviderType;

import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceStatusLocalServiceUtil;
import at.graz.meduni.bibbox.liferay.portlet.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @generated
 */
@ProviderType
public class ApplicationInstanceStatusClp extends BaseModelImpl<ApplicationInstanceStatus>
	implements ApplicationInstanceStatus {
	public ApplicationInstanceStatusClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ApplicationInstanceStatus.class;
	}

	@Override
	public String getModelClassName() {
		return ApplicationInstanceStatus.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _applicationInstanceStatusId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setApplicationInstanceStatusId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _applicationInstanceStatusId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("applicationInstanceStatusId",
			getApplicationInstanceStatusId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("applicationInstanceId", getApplicationInstanceId());
		attributes.put("status", getStatus());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long applicationInstanceStatusId = (Long)attributes.get(
				"applicationInstanceStatusId");

		if (applicationInstanceStatusId != null) {
			setApplicationInstanceStatusId(applicationInstanceStatusId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long applicationInstanceId = (Long)attributes.get(
				"applicationInstanceId");

		if (applicationInstanceId != null) {
			setApplicationInstanceId(applicationInstanceId);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public long getApplicationInstanceStatusId() {
		return _applicationInstanceStatusId;
	}

	@Override
	public void setApplicationInstanceStatusId(long applicationInstanceStatusId) {
		_applicationInstanceStatusId = applicationInstanceStatusId;

		if (_applicationInstanceStatusRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicationInstanceStatusId",
						long.class);

				method.invoke(_applicationInstanceStatusRemoteModel,
					applicationInstanceStatusId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_applicationInstanceStatusRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_applicationInstanceStatusRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_applicationInstanceStatusRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_applicationInstanceStatusRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_applicationInstanceStatusRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_applicationInstanceStatusRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_applicationInstanceStatusRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_applicationInstanceStatusRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_applicationInstanceStatusRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_applicationInstanceStatusRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_applicationInstanceStatusRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_applicationInstanceStatusRemoteModel,
					modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getApplicationInstanceId() {
		return _applicationInstanceId;
	}

	@Override
	public void setApplicationInstanceId(long applicationInstanceId) {
		_applicationInstanceId = applicationInstanceId;

		if (_applicationInstanceStatusRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicationInstanceId",
						long.class);

				method.invoke(_applicationInstanceStatusRemoteModel,
					applicationInstanceId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus() {
		return _status;
	}

	@Override
	public void setStatus(String status) {
		_status = status;

		if (_applicationInstanceStatusRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_applicationInstanceStatusRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getApplicationInstanceStatusRemoteModel() {
		return _applicationInstanceStatusRemoteModel;
	}

	public void setApplicationInstanceStatusRemoteModel(
		BaseModel<?> applicationInstanceStatusRemoteModel) {
		_applicationInstanceStatusRemoteModel = applicationInstanceStatusRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _applicationInstanceStatusRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_applicationInstanceStatusRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			ApplicationInstanceStatusLocalServiceUtil.addApplicationInstanceStatus(this);
		}
		else {
			ApplicationInstanceStatusLocalServiceUtil.updateApplicationInstanceStatus(this);
		}
	}

	@Override
	public ApplicationInstanceStatus toEscapedModel() {
		return (ApplicationInstanceStatus)ProxyUtil.newProxyInstance(ApplicationInstanceStatus.class.getClassLoader(),
			new Class[] { ApplicationInstanceStatus.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ApplicationInstanceStatusClp clone = new ApplicationInstanceStatusClp();

		clone.setApplicationInstanceStatusId(getApplicationInstanceStatusId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setApplicationInstanceId(getApplicationInstanceId());
		clone.setStatus(getStatus());

		return clone;
	}

	@Override
	public int compareTo(ApplicationInstanceStatus applicationInstanceStatus) {
		int value = 0;

		if (getApplicationInstanceId() < applicationInstanceStatus.getApplicationInstanceId()) {
			value = -1;
		}
		else if (getApplicationInstanceId() > applicationInstanceStatus.getApplicationInstanceId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ApplicationInstanceStatusClp)) {
			return false;
		}

		ApplicationInstanceStatusClp applicationInstanceStatus = (ApplicationInstanceStatusClp)obj;

		long primaryKey = applicationInstanceStatus.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{applicationInstanceStatusId=");
		sb.append(getApplicationInstanceStatusId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", applicationInstanceId=");
		sb.append(getApplicationInstanceId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceStatus");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>applicationInstanceStatusId</column-name><column-value><![CDATA[");
		sb.append(getApplicationInstanceStatusId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicationInstanceId</column-name><column-value><![CDATA[");
		sb.append(getApplicationInstanceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _applicationInstanceStatusId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _applicationInstanceId;
	private String _status;
	private BaseModel<?> _applicationInstanceStatusRemoteModel;
	private Class<?> _clpSerializerClass = ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}