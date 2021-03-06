/**
* Copyright 2015 Microsoft Open Technologies, Inc.
*
* Licensed under the Apache License, Version 2.0 (the "License");
*  you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*	 http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
*  distributed under the License is distributed on an "AS IS" BASIS,
*  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*  See the License for the specific language governing permissions and
*  limitations under the License.
*/
package com.microsoftopentechnologies.azurecommons.deploy.model;

import java.util.Date;

import com.interopbridges.tools.windowsazure.WindowsAzurePackageType;
import com.microsoft.windowsazure.Configuration;
import com.microsoft.windowsazure.management.compute.models.HostedServiceListResponse.HostedService;
import com.microsoftopentechnologies.azuremanagementutil.model.KeyName;
import com.microsoftopentechnologies.azuremanagementutil.model.StorageService;

public class DeployDescriptor {

	private final String deploymentId;
	private final Date startTime;
	private final String cspkgFile;
	private final String cscfgFile;
	private final String deployState;
	private final String subscriptionId;
	private final StorageService storageAcount;
	private final KeyName accessKey;
	private final HostedService hostedService;
	private final RemoteDesktopDescriptor remoteDesktopDescriptor;
	private final WindowsAzurePackageType deployMode;
    private final String mngUrl;
	private final String unpublish;
	private final CertificateUploadList certList;
	private final boolean displayHttpsLink;
    private final Configuration configuration;

	public DeployDescriptor(WindowsAzurePackageType deployMode,
			String subscriptionId, StorageService storageAcount,
			KeyName accessKey, HostedService hostedService, String cspkgFile,
			String cscfgFile, String deployState,
			RemoteDesktopDescriptor remoteDesktopDescriptor, String mngUrl,
			String unpublish,
			CertificateUploadList certList, boolean displayHttpsLink, Configuration configuration) {
		this.deployMode = deployMode;
		this.startTime = new Date();
		this.deploymentId = String.format("%s - %s",
				hostedService.getServiceName(), deployState);
		this.subscriptionId = subscriptionId;
		this.storageAcount = storageAcount;
		this.accessKey = accessKey;
		this.hostedService = hostedService;
		this.remoteDesktopDescriptor = remoteDesktopDescriptor;
		this.cspkgFile = cspkgFile;
		this.cscfgFile = cscfgFile;
		this.deployState = deployState;
        this.mngUrl = mngUrl;
		this.unpublish = unpublish;
		this.certList = certList;
		this.displayHttpsLink=displayHttpsLink;
        this.configuration = configuration;
	}

	public WindowsAzurePackageType getDeployMode() {
		return deployMode;
	}

	/**
	 * @return the deploymentId
	 */
	public String getDeploymentId() {
		return deploymentId;
	}

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	public String getSubscriptionId() {
		return subscriptionId;
	}

	public StorageService getStorageAccount() {
		return storageAcount;
	}

	public String getStorageKey() {
		if (accessKey == KeyName.Primary) {
			return storageAcount.getPrimaryKey();
		}
		return storageAcount.getSecondaryKey();
	}

	public HostedService getHostedService() {
		return hostedService;
	}

	public String getCspkgFile() {
		return cspkgFile;
	}

	public String getCscfgFile() {
		return cscfgFile;
	}

	public String getDeployState() {
		return deployState;
	}

	/**
	 * @return the storageAcountDescriptor
	 */
	public StorageService getStorageAcountDescriptor() {
		return storageAcount;
	}

	/**
	 * @return the remoteDesktopDescriptor
	 */
	public RemoteDesktopDescriptor getRemoteDesktopDescriptor() {
		return remoteDesktopDescriptor;
	}

	/**
	 * @return the enableRemoteDesktop
	 */
	public boolean isEnableRemoteDesktop() {
		return remoteDesktopDescriptor.isEnabled();
	}

	public boolean isStartRdpOnDeploy() {
		return remoteDesktopDescriptor.isStartRemoteRDP();
	}

    public String getMngUrl() {
        return mngUrl;
    }

    public String getUnpublish() {
		return unpublish;
	}

	public CertificateUploadList getCertList() {
		return certList;
	}
	
	public boolean getDisplayHttpsLink() {
		return displayHttpsLink;
	}

    public Configuration getConfiguration() {
        return configuration;
    }
}