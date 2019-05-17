package com.hiynn.module.exception;

import com.hiynn.module.entity.ResponseResult;
import com.hiynn.module.util.ResponseCodeEnum;
import com.hiynn.module.util.ResponseResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * description GlobalExceptionHandler
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年05月08日 16:59
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	/** logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * description  处理未知异常
	 * @author LouLvLin
	 * @date  2019/5/9  9:10
	 * @param e 1
	 * @return com.hiynn.module.entity.ResponseResult
	 */
	@ExceptionHandler({Exception.class})
	public ResponseResult globalExceptionHandler(Exception e) {
		LOGGER.error(e.getMessage(), e);
		return ResponseResultUtil.error(ResponseCodeEnum.FAIL);
	}
	
	/**
	 * description  处理业务异常 
	 * @author LouLvLin
	 * @date  2019/5/8  17:08
	 * @param e 1
	 * @return com.hiynn.module.entity.ResponseResult
	 */
	@ExceptionHandler({BaseException.class})
	public ResponseResult businessExceptionHandler(BaseException e) {
		LOGGER.error(e.getMessage(),e);
		return ResponseResultUtil.error(e.getCode(), e.getMessage());
	}
}


