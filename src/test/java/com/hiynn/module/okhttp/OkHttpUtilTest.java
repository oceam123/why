package com.hiynn.module.okhttp;

import com.hiynn.module.util.ConstansUtil;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
public class OkHttpUtilTest {
	/** logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(OkHttpUtilTest.class);

	@Test
	public void getSyncTest() {
		String result = OkHttpUtil.getSync("http://BBC:8080");
		LOGGER.info("getSyncTest:{}", result);
		Assert.assertThat(result, Matchers.equalTo(""));
	}

	@Test
	public void postSyncTest() {
		Map<String,Object> params = new LinkedHashMap<>();
		params.put("id", 3);
		params.put("name", "lilei");
		String result = OkHttpUtil.postSync("http://BBC:8080", ConstansUtil.COMM_GSON.toJson(params));
		LOGGER.info("postSyncTest:{}", result);
		Assert.assertThat(result, Matchers.equalTo(""));
	}
}