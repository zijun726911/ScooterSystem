package com.utils;


import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 打印表格类，可以以表格的形式打印String数组。
 * 如果输出内容包含中文则仅在部分字体下有效，其他字体下排版会相对混乱，推荐使用YaHeiConsolasHybrid字体。
 * 本类所有方法都是protected，不可外部使用，推荐使用ConsoleTables类的静态方法打印内容
 * 
 * @author 田义锋Spock
 * @date 2019年4月26日
 * @version v1.0
 */
public class ConsoleTable {

	/**
	 * 表格标题
	 */
	private String[] title;

	/**
	 * 表格内容集合
	 */
	private List<String[]> list;

	/**
	 * 表格列数
	 */
	private Integer columns;

	/**
	 * 表格每列最大宽度
	 */
	private Integer[] fieldMaxLengthArr;

	/**
	 * 是否自动编号
	 */
	private boolean autoNum;

	/**
	 * 当前编号
	 */
	private Integer currentNum;

	/**
	 * protected构造函数
	 * 
	 * @param list    表格内容集合
	 * @param title   表格标题
	 * @param columns 表格列数
	 * @param autoNum 是否自动编号
	 */
	public ConsoleTable(List<String[]> list, String[] title, Integer columns, boolean autoNum) {
		this.list = list;
		this.title = title;
		this.autoNum = autoNum;
		this.columns = columns;
		this.currentNum = 1;
		init();
	}

	/**
	 * 初始化
	 */
	private void init() {
		fieldMaxLengthArr = new Integer[columns];
		for (int i = 0; i < columns; i++) {
			fieldMaxLengthArr[i] = 0;
			for (int j = 0; j < list.size(); j++) {
				int fieldLength = FieldHandler.calculStrSpace(list.get(j)[i]);
				fieldMaxLengthArr[i] = fieldLength > fieldMaxLengthArr[i] ? fieldLength : fieldMaxLengthArr[i];
			}
			if (title != null) {
				int titleLength = FieldHandler.calculStrSpace(title[i]);
				fieldMaxLengthArr[i] = titleLength > fieldMaxLengthArr[i] ? titleLength : fieldMaxLengthArr[i];
			}
			fieldMaxLengthArr[i] += 4;
		}
		if (autoNum) {
			fieldMaxLengthArr = Arrays.copyOf(fieldMaxLengthArr, fieldMaxLengthArr.length + 1);
			for (int i = fieldMaxLengthArr.length - 1; i > 0; i--) {
				fieldMaxLengthArr[i] = fieldMaxLengthArr[i - 1];
			}
			fieldMaxLengthArr[0] = 8;
			columns += 1;
		}
	}

	/**
	 * 打印表格
	 * @throws IOException 
	 */
	public  void print(BufferedWriter bw) throws IOException {
		
		if (title != null) {
			
			bw.write(""+getTitleLine());bw.newLine();
			bw.write(""+getTitleString());bw.newLine();
		}
		bw.write(""+getTitleLine());bw.newLine();
		list.forEach(strArr -> {
			try {
				bw.write(""+getRowString(strArr));bw.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		bw.write(""+getTitleLine());bw.newLine();
		currentNum = 1;
	}

	/**
	 * 获取表头横线
	 * 
	 * @return 表头横线字符串
	 */
	protected StringBuilder getTitleLine() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < columns; i++) {
			int maxLength = this.fieldMaxLengthArr[i];
			str.append("+");
			for (int j = 0; j < maxLength; j++) {
				str.append("-");
			}
		}
		str.append("+");
		return str;
	}

	/**
	 * 获取表格标题
	 * 
	 * @return 表格标题字符串
	 */
	protected StringBuilder getTitleString() {
		if (title == null) {
			return null;
		}
		if (autoNum) {
			title = Arrays.copyOf(title, title.length + 1);
			for (int i = title.length - 1; i > 0; i--) {
				title[i] = title[i - 1];
			}
			title[0] = "序号";
		}
		StringBuilder str = new StringBuilder("|");
		for (int i = 0; i < columns; i++) {
			int maxLength = this.fieldMaxLengthArr[i];
			int length = FieldHandler.calculStrSpace(title[i]);
			for (int j = 0; j < maxLength; j++) {
				if (j < (maxLength - length) / 2) {
					str.append((char) 32);
				} else if (j == (maxLength - length) / 2) {
					str.append(title[i]);
				} else if (j >= (maxLength + length) / 2) {
					str.append((char) 32);
				}
			}
			str.append("|");
		}
		return str;
	}

	/**
	 * 根据一个String数组生成表格一行的内容
	 * 
	 * @param strArr 行数组
	 * @return 表格一行内容的字符串
	 */
	protected StringBuilder getRowString(String[] strArr) {
		int[] fieldLengthArr = new int[strArr.length];
		for (int i = 0; i < strArr.length; i++) {
			fieldLengthArr[i] = FieldHandler.calculStrSpace(strArr[i]);
		}
		if (autoNum) {
			strArr = Arrays.copyOf(strArr, strArr.length + 1);
			fieldLengthArr = Arrays.copyOf(fieldLengthArr, fieldLengthArr.length + 1);
			for (int i = columns - 1; i > 0; i--) {
				strArr[i] = strArr[i - 1];
				fieldLengthArr[i] = fieldLengthArr[i - 1];
			}
			strArr[0] = String.valueOf(this.currentNum);
			fieldLengthArr[0] = FieldHandler.calculStrSpace(String.valueOf(this.currentNum));
			currentNum++;
		}
		StringBuilder str = new StringBuilder("|");
		for (int i = 0; i < columns; i++) {
			int maxLength = this.fieldMaxLengthArr[i];
			int length = fieldLengthArr[i];
			for (int j = 0; j < maxLength; j++) {
				if (j < (maxLength - length) / 2) {
					str.append((char) 32);
				} else if (j == (maxLength - length) / 2) {
					str.append(strArr[i]);
				} else if (j >= (maxLength + length) / 2) {
					str.append((char) 32);
				}
			}
			str.append("|");
		}
		return str;
	}

}
