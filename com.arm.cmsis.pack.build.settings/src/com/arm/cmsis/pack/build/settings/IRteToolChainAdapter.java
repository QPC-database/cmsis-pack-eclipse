/*******************************************************************************
* Copyright (c) 2015 ARM Ltd. and others
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* ARM Ltd and ARM Germany GmbH - Initial API and implementation
*******************************************************************************/

package com.arm.cmsis.pack.build.settings;

import org.eclipse.cdt.managedbuilder.core.IConfiguration;
import org.eclipse.core.runtime.IAdaptable;

import com.arm.cmsis.pack.build.IBuildSettings;
import com.arm.cmsis.pack.generic.IAttributes;


/**
 * Interface that sets IConfiguration build options according to IBuildSettings.
 * It extends IAdapdable interface to allow even more flexibility.  
 */
public interface IRteToolChainAdapter extends IAdaptable {

	/**
	 * Sets toolchain build options for given IConfiguration according to supplied IRteBuildSettings
	 * @param configuration destination IConfiguration to set options to
	 * @param buildSettings source IBuildSettings
	 */
	void setToolChainOptions(IConfiguration configuration,  IBuildSettings buildSettings);


	/**
	 * Sets initial toolchain build options for given IConfiguration according to supplied IRteBuildSettings.<br>
	 * This function is called when device settings are changed (e.g. when new project is created)
	 * @param configuration destination IConfiguration to set options to
	 * @param buildSettings source IBuildSettings
	 */
	void setInitialToolChainOptions(IConfiguration configuration,  IBuildSettings buildSettings);


	/**
	 * Returns Linker script generator associated with the adapter
	 * @return ILinkerScriptGenerator or null if no generator is available
	 */
	ILinkerScriptGenerator getLinkerScriptGenerator();
	
	
	/**
	 * Returns RTE options extracted from toolchain settings such as Tcompiler, Toptions, Dfpu, Dendian.
	 * The returning options must not be null to take any effect.  
	 * @param configuration IConfiguration with build settings
	 * @return IAttributes containing RTE options   
	 */
	default IAttributes getRteOptions(IConfiguration configuration) { return null;}

}
