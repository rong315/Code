QuestionPattern

1.代码功能：对用户提问问句进行提问模式分类，共分为12类，以提高后端检索知识库的效率和速度。

2.代码结构：
+---src
-----com.njupt---->包
------PatternMarches.java--->操作问句提问模式分类的主类
--------------->readTxtFile(String filePath)：根据文件路径名，逐行读取keywords文件，将内容用ArrayList进行保存
--------------->main：具体实现读入用户问句，进行提问模式判别，输出问句类型	
+---lib
------keywords----->提问关键词正则表达式表
-------------------1-keywords_what.txt----------->what问句类型关键词正则表达式
-------------------2-keywords_how.txt------------>how问句类型关键词正则表达式
-------------------3-keywords_where.txt---------->where问句类型关键词正则表达式
-------------------4-keywords_when.txt----------->when问句类型关键词正则表达式
-------------------5-keywords_why.txt------------>why问句类型关键词正则表达式
-------------------6-keywords_which.txt---------->which问句类型关键词正则表达式
-------------------7-keywords_yes_no.txt--------->正反问句类型关键词正则表达式
-------------------8-keywords_selection.txt------>选择问句类型关键词正则表达式
-------------------9-keywords_estimate.txt------->评价问句类型关键词正则表达式
-------------------10-keywords_compare.txt------->比较问句类型关键词正则表达式
-------------------11-keywords_ask.txt----------->咨询问句类型关键词正则表达式
-----stopwords------------>提问词停用正则表达式表
-------------------1-keywords_what.txt----------->what问句类型提问词正则表达式
-------------------2-keywords_how.txt------------>how问句类型提问词正则表达式
-------------------3-keywords_where.txt---------->where问句类型提问词正则表达式
-------------------4-keywords_when.txt----------->when问句类型提问词正则表达式
-------------------5-keywords_why.txt------------>why问句类型提问词正则表达式
-------------------6-keywords_which.txt---------->which问句类型提问词正则表达式
-------------------7-keywords_yes_no.txt--------->正反问句类型提问词正则表达式
-------------------8-keywords_selection.txt------>选择问句类型提问词正则表达式
-------------------9-keywords_estimate.txt------->评价问句类型提问词正则表达式
-------------------10-keywords_compare.txt------->比较问句类型提问词正则表达式
-------------------11-keywords_ask.txt----------->咨询问句类型提问词正则表达式

3.输入：控制台输入（String类型）用户提问

4.输出：控制台输出类别（String类型），list结构存储，分别存储提问类型、去提问词后问句。
