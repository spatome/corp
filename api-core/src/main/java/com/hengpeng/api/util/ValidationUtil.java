/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: ValidationUtils.java 
 * @Prject: api-core
 * @Package: com.hengpeng.api.util 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年8月6日 下午8:42:57 
 * @version: V1.0   
 */
package com.hengpeng.api.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;

import org.apache.commons.collections.CollectionUtils;

/**
 * @ClassName: ValidationUtils
 * @Description: hibernate校验工具类
 * @author: zhangwei
 * @date: 2017年8月6日 下午8:42:57
 */
public class ValidationUtil {

	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	public static <T> ValidationResult validateEntity(T obj) {
		ValidationResult result = new ValidationResult();

		Set<ConstraintViolation<T>> set = validator.validate(obj, Default.class);

		if (CollectionUtils.isNotEmpty(set)) {
			result.setHasErrors(true);
			Map<String, String> errorMsg = new HashMap<String, String>();
			for (ConstraintViolation<T> cv : set) {
				errorMsg.put(cv.getPropertyPath().toString(), cv.getMessage());
			}
			result.setErrorMsg(errorMsg);
		}

		return result;
	}

	public static <T> ValidationResult validateProperty(T obj, String propertyName) {
		ValidationResult result = new ValidationResult();

		Set<ConstraintViolation<T>> set = validator.validateProperty(obj, propertyName, Default.class);

		if (CollectionUtils.isNotEmpty(set)) {
			result.setHasErrors(true);
			Map<String, String> errorMsg = new HashMap<String, String>();
			for (ConstraintViolation<T> cv : set) {
				errorMsg.put(propertyName, cv.getMessage());
			}
			result.setErrorMsg(errorMsg);
		}

		return result;
	}

	public static class ValidationResult implements Serializable {
		private static final long serialVersionUID = 1L;

		private boolean hasErrors;

		private Map<String, String> errorMsg;

		public boolean isHasErrors() {
			return hasErrors;
		}

		public void setHasErrors(boolean hasErrors) {
			this.hasErrors = hasErrors;
		}

		public Map<String, String> getErrorMsg() {
			return errorMsg;
		}

		public void setErrorMsg(Map<String, String> errorMsg) {
			this.errorMsg = errorMsg;
		}

		@Override
		public String toString() {
			return "ValidationResult [hasErrors=" + hasErrors + ", errorMsg=" + errorMsg + "]";
		}
	}
}
