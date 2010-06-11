/**
 * Copyright 2010 Tobias Sarnowski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * (c) 2010 Tobias Sarnowski
 * All rights reserved.
 */
package org.onsteroids.eve.api;

import com.eveonline.api.ApiService;
import com.eveonline.api.server.ServerStatusApi;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

/**
 * Guice bootstrapper and connector for everyone, not using Guice.
 *
 * @author Tobias Sarnowski
 */
public final class Api {
	private static final Logger LOG = LoggerFactory.getLogger(Api.class);

	private final Injector injector;

	private Api(Module... apiModules) {
		injector = Guice.createInjector(apiModules);
	}


	/**
	 * @return a ready to use api object
	 */
	public static Api createDefaultTranquilityApi() {
		return new Api(new DefaultTranquilityModule());
	}

    /**
     * @param infinispanConfiguration path to an infinispan configuration file
	 * @return a ready to use api object
	 */
    public static Api createDefaultTranquilityApi(URL infinispanConfiguration) {
		return new Api(new DefaultTranquilityModule(infinispanConfiguration));
	}

	/**
	 * Initializes the api guice injector and checks, if ServerStatusApi is available.
	 *
	 * @param apiModules guice modules to use
	 * @return an api object
	 * @throws ConfigurationException if you forgot to install a nessecary module
	 */
	public static Api createApi(Module... apiModules) {
		Api api = new Api(apiModules);
		api.get(ServerStatusApi.class);
		return api;
	}


	/**
	 * @param apiService the API service type to retrieve
	 * @param <T>
	 * @return the ready-to-use API service instance
	 * @throws ConfigurationException if requested ApiService is not available
	 */
	public <T extends ApiService> T get(Class<T> apiService) {
		return injector.getInstance(apiService);
	}

}
