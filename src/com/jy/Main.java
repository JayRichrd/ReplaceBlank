package com.jy;

public class Main {

	public static void main(String[] args) {
		// 定义输入
		char[] string = new char[50];
		string[0] = 'W';
		string[1] = 'e';
		string[2] = ' ';
		string[3] = 'a';
		string[4] = 'r';
		string[5] = 'e';
		string[6] = ' ';
		string[7] = 'h';
		string[8] = 'a';
		string[9] = 'p';
		string[10] = 'p';
		string[11] = 'y';
		string[12] = '.';
		string[13] = '\0';
		// 替换空格
		replaceBlank(string, 50);
		System.out.println(string);
	}

	/**
	 * 替换字符串数组中的空格
	 * 
	 * @param string
	 *            输入字符串的引用
	 * @param capacity
	 *            字符串数组的容量
	 */
	private static void replaceBlank(char[] string, int capacity) {
		// 鲁棒性检查
		if (string == null || capacity <= 0)
			return;

		// 原始字符串的长度
		int originalLength = 0;
		// 字符串中的空格数
		int numberOfBlank = 0;

		// 遍历获取原始字符串的长度和当中的空格数
		int i = 0;
		while (string[i] != '\0') {
			originalLength++;
			if (string[i] == ' ')
				numberOfBlank++;
			i++;
		}

		// 将空格替换成%20后新的字符串的长度
		int newLength = originalLength + numberOfBlank * 2;
		if (newLength > capacity) // 不能操作字符数组的容量
			return;

		// 原始数组遍历的位置
		int indexOfOriginal = originalLength;
		// 新数组遍历的位置
		int indexOfNew = newLength;

		// 从后往前遍历并将空格替换成%20
		while (indexOfOriginal >= 0 && indexOfNew > indexOfOriginal) {
			// 遇到空格就替换成%20
			if (string[indexOfOriginal] == ' ') {
				string[indexOfNew--] = '%';
				string[indexOfNew--] = '2';
				string[indexOfNew--] = '0';
			} else { // 否则就直接复制
				string[indexOfNew--] = string[indexOfOriginal];
			}
			indexOfOriginal--;
		}
	}

}
