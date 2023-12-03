package com.walter.rabbitmq.consumer.utils;

import org.apache.commons.text.StringEscapeUtils;

public class JsonEscapeUtil {
	public static String unescape(String messageBody) {
		return StringEscapeUtils.unescapeJson(messageBody).replaceAll("^\"|\"$", "");
	}
}
