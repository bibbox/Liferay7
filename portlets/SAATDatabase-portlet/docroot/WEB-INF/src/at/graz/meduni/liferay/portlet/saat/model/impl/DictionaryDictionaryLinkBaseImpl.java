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

package at.graz.meduni.liferay.portlet.saat.model.impl;

import aQute.bnd.annotation.ProviderType;

import at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink;
import at.graz.meduni.liferay.portlet.saat.service.DictionaryDictionaryLinkLocalServiceUtil;

/**
 * The extended model base implementation for the DictionaryDictionaryLink service. Represents a row in the &quot;saat_DictionaryDictionaryLink&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DictionaryDictionaryLinkImpl}.
 * </p>
 *
 * @author reihsr
 * @see DictionaryDictionaryLinkImpl
 * @see DictionaryDictionaryLink
 * @generated
 */
@ProviderType
public abstract class DictionaryDictionaryLinkBaseImpl
	extends DictionaryDictionaryLinkModelImpl
	implements DictionaryDictionaryLink {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dictionary dictionary link model instance should use the {@link DictionaryDictionaryLink} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			DictionaryDictionaryLinkLocalServiceUtil.addDictionaryDictionaryLink(this);
		}
		else {
			DictionaryDictionaryLinkLocalServiceUtil.updateDictionaryDictionaryLink(this);
		}
	}
}