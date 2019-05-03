package com.utils;


/**
 * 使用ConsoleTables打印实体类表格时，实体类需实现本接口
 * 
 * @author 田义锋Spock
 * @date 2019年4月26日
 * @version v1.0
 */
public interface FieldHandler {

	/**
	 * 获取实体类各个属性转成字符串的数组
	 * 
	 * @return 字符串的数组
	 */
	String[] getFieldStringArr();

	/**
	 * 计算字符串输出时占用长度，该长度表示的是字串符在输出时占用的长度，一个汉字及汉文标点占两个单位，其他占一个单位
	 * 
	 * @param str 字符串
	 * @return 占用长度
	 */
	public static int calculStrSpace(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
			if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
					|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
					|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
					|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
					|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
					|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
				count += 2;
			} else {
				count += 1;
			}
		}
		return count;
	}
}
