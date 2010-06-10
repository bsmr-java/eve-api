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

package org.onsteroids.eve.api.provider.eve;

import com.eveonline.api.eve.AllianceList;
import com.eveonline.api.eve.AllianceListApi;
import com.eveonline.api.exceptions.ApiException;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.onsteroids.eve.api.cache.ApiCache;
import org.onsteroids.eve.api.connector.ApiConnection;
import org.onsteroids.eve.api.provider.AbstractApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Tobias Sarnowski
 */
@Singleton
public class AllianceListApiImpl extends AbstractApiService implements AllianceListApi {
    private static final Logger LOG = LoggerFactory.getLogger(AllianceListApiImpl.class);

    @Inject
    public AllianceListApiImpl(ApiConnection apiConnection, ApiCache apiCache) {
        super(apiConnection, apiCache);
    }

    @Override
    public AllianceList getAllianceList() throws ApiException {
        return call(AllianceListImpl.class, AllianceListApi.XMLPATH);
    }
}