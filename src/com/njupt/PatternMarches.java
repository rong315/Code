package com.njupt;

/*
 * 功能：对原有提问模式分类进行修改，将原有4类细分为12类
 * 标记：1-what类型；2-how类型；3-where类型；4-when类型；5-why类型；6-which问句；7-是非问句；8-选择问句；9-评价问句；10-比较问句；11-咨询问句；12-其他类型（主要是陈述句）
 * 其中：1-1：介绍核心部分；1-2：how many；1-3：how many_time
 * 	   2-1:如何开通方面；2-2：如何取消方面
 * 	   6-1:which(人);-2:which(非人)
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMarches {

	public static void main(String[] args) {
		// 读取分类判断规则的正则表达式
		List<String> keywords_what = readTxtFile("lib/keywords/1-keywords_what.txt");
		List<String> keywords_how = readTxtFile("lib/keywords/2-keywords_how.txt");
		List<String> keywords_where = readTxtFile("lib/keywords/3-keywords_where.txt");
		List<String> keywords_when = readTxtFile("lib/keywords/4-keywords_when.txt");
		List<String> keywords_why = readTxtFile("lib/keywords/5-keywords_why.txt");
		List<String> keywords_which = readTxtFile("lib/keywords/6-keywords_which.txt");
		List<String> keywords_yes_no = readTxtFile("lib/keywords/7-keywords_yes_no.txt");
		List<String> keywords_selection = readTxtFile("lib/keywords/8-keywords_selection.txt");
		List<String> keywords_estimate = readTxtFile("lib/keywords/9-keywords_estimate.txt");
		List<String> keywords_compare = readTxtFile("lib/keywords/10-keywords_compare.txt");
		List<String> keywords_ask = readTxtFile("lib/keywords/11-keywords_ask.txt");

		List<String> stopwords_what = readTxtFile("lib/stopwords/1-stopwords_what.txt");
		List<String> stopwords_how = readTxtFile("lib/stopwords/2-stopwords_how.txt");
		List<String> stopwords_where = readTxtFile("lib/stopwords/3-stopwords_where.txt");
		List<String> stopwords_when = readTxtFile("lib/stopwords/4-stopwords_when.txt");
		List<String> stopwords_why = readTxtFile("lib/stopwords/5-stopwords_why.txt");
		List<String> stopwords_which = readTxtFile("lib/stopwords/6-stopwords_which.txt");
		List<String> stopwords_yes_no = readTxtFile("lib/stopwords/7-stopwords_yes_no.txt");
		List<String> stopwords_selection = readTxtFile("lib/stopwords/8-stopwords_selection.txt");
		List<String> stopwords_estimate = readTxtFile("lib/stopwords/9-stopwords_estimate.txt");
		List<String> stopwords_compare = readTxtFile("lib/stopwords/10-stopwords_compare.txt");
		List<String> stopwords_ask = readTxtFile("lib/stopwords/11-stopwords_ask.txt");

		// 从控制台输入问句，进行查询
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String read = null;
		System.out.println("请输入需要判断的问句：");
		try {
			read = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int temp = 0;
		String type = null;

		// 输出结果：type结果保存在list中，便于后续读取
		List<String> result = new ArrayList<>();

		// 对输入的问句进行判断
		// 1.what问句
		for (int i = 0; i < keywords_what.size(); i++) {
			Pattern p1 = Pattern.compile(keywords_what.get(i));
			Matcher m1 = p1.matcher(read);
			if (i < 2 && m1.find()) {
				type = "1-1";
				result.add(type);
				// System.out.println("类型：1-1");
				String str = read.replaceAll(stopwords_what.get(i), "");
				result.add(str);
				break;
			} else if (i < 7 && m1.find()) {
				type = "1-2";
				result.add(type);
				// System.out.println("类型：1-2");
				String str = read.replaceAll(stopwords_what.get(i), "");
				result.add(str);
				break;
			} else if (i < 10 && m1.find()) {
				type = "1-3";
				result.add(type);
				// System.out.println("类型：1-3");
				String str = read.replaceAll(stopwords_what.get(i), "");
				result.add(str);
				break;
			} else if (i < 12 && m1.find()) {
				type = "1-4";
				result.add(type);
				// System.out.println("类型：1-4");
				String str = read.replaceAll(stopwords_what.get(i), "");
				result.add(str);
				break;
			} else if (i <= keywords_what.size() - 1 && m1.find()) {
				type = "1";
				result.add(type);
				// System.out.println("类型：1");
				String str = read.replaceAll(stopwords_what.get(i), "");
				result.add(str);
				break;
			} else if (i == keywords_what.size() - 1) {
				temp++;
			}

		}

		// 2.how问句
		for (int i = 0; i < keywords_how.size(); i++) {
			Pattern p2 = Pattern.compile(keywords_how.get(i));
			Matcher m2 = p2.matcher(read);
			if (i < 4 && m2.find()) {
				type = "2-1";
				result.add(type);
				// System.out.println("类型：2-1");
				String str = read.replaceAll(stopwords_how.get(i), "");
				result.add(str);
				break;
			} else if (i < 8 && m2.find()) {
				type = "2-2";
				result.add(type);
				// System.out.println("类型：2-2");
				String str = read.replaceAll(stopwords_how.get(i), "");
				result.add(str);
				break;
			} else if (i <= keywords_how.size() - 1 && m2.find()) {
				type = "2";
				result.add(type);
				// System.out.println("类型：2");
				String str = read.replaceAll(stopwords_how.get(i), "");
				result.add(str);
				break;
			} else if (i == keywords_how.size() - 1) {
				temp++;
			}
		}

		// 3.where问句
		for (int i = 0; i < keywords_where.size(); i++) {
			Pattern p3 = Pattern.compile(keywords_where.get(i));
			Matcher m3 = p3.matcher(read);
			if (m3.find()) {
				type = "3";
				result.add(type);
				// System.out.println("类型：3");
				String str = read.replaceAll(stopwords_where.get(i), "");
				result.add(str);
				break;
			} else if (i == keywords_where.size() - 1) {
				temp++;
			}
		}

		// 4.when问句
		for (int i = 0; i < keywords_when.size(); i++) {
			Pattern p4 = Pattern.compile(keywords_when.get(i));
			Matcher m4 = p4.matcher(read);
			if (m4.find()) {
				type = "4";
				result.add(type);
				// System.out.println("类型：4");
				String str = read.replaceAll(stopwords_when.get(i), "");
				result.add(str);
				break;
			} else if (i == keywords_when.size() - 1) {
				temp++;
			}
		}

		// 5.why问句
		for (int i = 0; i < keywords_why.size(); i++) {
			Pattern p5 = Pattern.compile(keywords_why.get(i));
			Matcher m5 = p5.matcher(read);
			if (m5.find()) {
				type = "5";
				result.add(type);
				// System.out.println("类型：5");
				String str = read.replaceAll(stopwords_why.get(i), "");
				result.add(str);
				break;
			} else if (i == keywords_why.size() - 1) {
				temp++;
			}
		}

		// 6.which问句
		// 6-1：关于人 ；6-2：非人
		for (int i = 0; i < keywords_which.size(); i++) {

			Pattern p10 = Pattern.compile(keywords_which.get(i));
			Matcher m10 = p10.matcher(read);
			if (i <= 3 && m10.find()) {
				type = "6-1";
				result.add(type);
				// System.out.println("类型：6-1");
				String str = read.replaceAll(stopwords_which.get(i), "");
				result.add(str);
				break;
			} else if (i > 3 && i <= keywords_which.size() - 1 && m10.find()) {
				type = "6-2";
				result.add(type);
				// System.out.println("类型：6-2");
				String str = read.replaceAll(stopwords_which.get(i), "");
				result.add(str);
				break;
			}

			else if (i == keywords_which.size() - 1) {
				temp++;
			}
		}

		// 7.是非问句
		for (int i = 0; i < keywords_yes_no.size(); i++) {
			Pattern p7 = Pattern.compile(keywords_yes_no.get(i));
			Matcher m7 = p7.matcher(read);
			if (m7.find()) {
				type = "7";
				result.add(type);
				// System.out.println("类型：7");
				String str = read.replaceAll(stopwords_yes_no.get(i), "");
				result.add(str);
				break;
			} else if (i == keywords_yes_no.size() - 1) {
				temp++;
			}
		}

		// 8.选择问句
		for (int i = 0; i < keywords_selection.size(); i++) {
			Pattern p6 = Pattern.compile(keywords_selection.get(i));
			Matcher m6 = p6.matcher(read);
			if (m6.find()) {
				type = "8";
				result.add(type);
				// System.out.println("类型：8");
				String str = read.replaceAll(stopwords_selection.get(i), "");
				result.add(str);
				break;
			} else if (i == keywords_selection.size() - 1) {
				temp++;
			}
		}

		// 9.评价问句
		for (int i = 0; i < keywords_estimate.size(); i++) {
			Pattern p9 = Pattern.compile(keywords_estimate.get(i));
			Matcher m9 = p9.matcher(read);
			if (m9.find()) {
				type = "9";
				result.add(type);
				// System.out.println("类型：9");
				String str = read.replaceAll(stopwords_estimate.get(i), "");
				result.add(str);
				break;
			} else if (i == keywords_estimate.size() - 1) {
				temp++;
			}
		}

		// 10.比较问句
		for (int i = 0; i < keywords_compare.size(); i++) {
			Pattern p8 = Pattern.compile(keywords_compare.get(i));
			Matcher m8 = p8.matcher(read);
			if (m8.find()) {
				type = "10";
				result.add(type);
				// System.out.println("类型：10");
				String str = read.replaceAll(stopwords_compare.get(i), "");
				result.add(str);
				break;
			} else if (i == keywords_compare.size() - 1) {
				temp++;
			}
		}

		// 11.咨询问句
		for (int i = 0; i < keywords_ask.size(); i++) {
			Pattern p9 = Pattern.compile(keywords_ask.get(i));
			Matcher m9 = p9.matcher(read);
			if (m9.find()) {
				// System.out.println(m.group());
				type = "11";
				result.add(type);
				// System.out.println("类型：11");
				String str = read.replaceAll(stopwords_ask.get(i), "");
				result.add(str);
				break;
			} else if (i == keywords_ask.size() - 1) {
				temp++;
			}
		}

		// 12.一般问句（主陈述句）
		// System.out.println(temp);
		if (temp == 11)

		{
			// 其他问句（陈述句）
			type = "12";
			result.add(type);
			result.add(read);
			// System.out.println("类型：12");
		}

		// 输出结果Type类别
		// System.out.println();
		for (String res : result) {
			System.out.println(res);
		}
	}

	// 方法：根据文件路径名，逐行读取txt文件，将内容用ArrayList进行保存
	public static ArrayList<String> readTxtFile(String filePath) {
		ArrayList<String> number = new ArrayList<String>();
		File file = new File(filePath);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String str = null;
			while ((str = br.readLine()) != null) {
				number.add(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return number;
	}

}
