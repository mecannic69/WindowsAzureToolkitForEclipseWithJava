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
package com.microsoftopentechnologies.windowsazure.tools.wasdkjava.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "com.microsoftopentechnologies.windowsazure.tools.wasdkjava.ui"; //$NON-NLS-1$

    // The shared instance
    private static Activator plugin;
    private static BundleContext bundleContext;
    public static boolean dplyState;

    /**
     * The constructor
     */
    public Activator() {
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance
     *
     * @return the shared instance
     */
    public static Activator getDefault() {
        return plugin;
    }

    public static BundleContext getBundleContext() {
        return bundleContext;
    }

    /**
     * Logs a message and exception.
     *
     * @param message
     * @param excp : exception.
     */
    public void log(String message, Exception excp) {
        getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, message, excp));
    }
    
    /**
     * Save the Deployment Assembly check box state
     * which will be used in case of immediate edit.
     * @param state
     */
    public static void setDeploymentAssemblyState(boolean state) {
    	dplyState = state;
    }

    /**
     * Returns Deployment Assembly check box state
     * which will be used in case of immediate edit.
     * @return
     */
    public static boolean geteploymentAssemblyState() {
    	return dplyState;
    }
}
