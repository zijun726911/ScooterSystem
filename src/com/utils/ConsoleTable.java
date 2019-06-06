package com.utils;

/**
 * 
 * Print a beautiful table in  user usage E-mail
 * */
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class ConsoleTable {

	private String[] title;

	
	private List<String[]> list;

	
	private Integer columns;

	
	private Integer[] fieldMaxLengthArr;

	
	private boolean autoNum;

	
	private Integer currentNum;

	
	public ConsoleTable(List<String[]> list, String[] title, Integer columns, boolean autoNum) {
		this.list = list;
		this.title = title;
		this.autoNum = autoNum;
		this.columns = columns;
		this.currentNum = 1;
		init();
	}

	
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
