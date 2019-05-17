package com.hiynn.module.config;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * description DefaultCacheEventLogger
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年05月10日 17:52
 */
public class DefaultCacheEventLogger implements CacheEventListener<Object,Object> {

	/** logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultCacheEventLogger.class);

	/**
	 * description  onEvent 
	 * @author LouLvLin
	 * @date  2019/5/10  17:55
	 * @param event 1
	 * @return void
	 */
	@Override
	public void onEvent(CacheEvent<?, ?> event) {
		LOGGER.debug("default caching event {} {} {} {}",
				event.getType(),
				event.getKey(),
				event.getOldValue(),
				event.getNewValue());
	}
}


