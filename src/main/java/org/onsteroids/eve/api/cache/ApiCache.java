package org.onsteroids.eve.api.cache;

import com.eveonline.api.ApiKey;
import com.eveonline.api.ApiResult;

import java.net.URI;
import java.util.Map;

/**
 * @author Tobias Sarnowski
 */
public interface ApiCache {

	/**
	 * @param apiResult the api result to cache
	 */
	void putApiResult(ApiResult apiResult);

	/**
	 * @param serverUri the api server uri
	 * @param xmlPath the xml path
	 * @param <T> an api result type
	 * @return the cached api result or null if apiresult not cached
	 */
	<T extends ApiResult> T getApiResult(Class<T> resultType, URI serverUri, String xmlPath);

	/**
	 * @param serverUri the api server uri
	 * @param xmlPath the xml path
	 * @param parameters the used parameters (can be null)
	 * @param <T> an api result type
	 * @return the cached api result or null if apiresult not cached
	 */
	<T extends ApiResult> T getApiResult(Class<T> resultType, URI serverUri, String xmlPath, Map<String,String> parameters);

	/**
	 * @param serverUri the api server uri
	 * @param xmlPath the xml path
	 * @param key the used api key (can be null)
	 * @param <T> an api result type
	 * @return the cached api result or null if apiresult not cached
	 */
	<T extends ApiResult> T getApiResult(Class<T> resultType, URI serverUri, String xmlPath, ApiKey key);

	/**
	 * @param serverUri the api server uri
	 * @param xmlPath the xml path
	 * @param key the used api key (can be null)
	 * @param parameters the used parameters (can be null)
	 * @param <T> an api result type
	 * @return the cached api result or null if apiresult not cached
	 */
	<T extends ApiResult> T getApiResult(Class<T> resultType, URI serverUri, String xmlPath, ApiKey key, Map<String,String> parameters);

}