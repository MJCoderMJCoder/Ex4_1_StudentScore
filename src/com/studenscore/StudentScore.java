package com.studenscore;
/**
 * JOptionPane(用来弹出各种标准的模式对话框)的部分功能：
 * ConfirmDialog：确认对话框
 * InputDialog:文本输入对话框
 * MessageDialog：信息显示对话框
 * OptionDialog：综合上述3中功能的对话框
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

/**
 * 逐个输入并计算五个学生的平均成绩和最好成绩。
 * @author zhifengfei
 */
public class StudentScore {
	
	public static void main(String[] args) throws IOException {
		int k, count = 5;		//count为学生的个数
		double score [] = new double[count];	//学生的成绩数组声明并创建
		double doubleSum = 0.0, doubleAver = 0.0, maxScore = 0.0;	//学生的总成绩、平均成绩、最高成绩
		boolean contiGo = true;
		String str;
		
		/*System.in是InputStream流，是字节流，BufferedReader还是字符缓冲流 */
		//InputStreamReader是字节流通向字符流的桥梁，它使用指定（或默认）的字符集读取字节并将其解码为字符
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		for(k = 0; k < count; k++) {
			while(contiGo) {
				System.out.print("请输入第" + (k + 1) + "个学生的成绩：");
				
				/*读取一个文本行，遇到换行、回车后直接跟着换行认为某行已终止。如果已到达流末尾，则返回null*/
				str = buf.readLine();
				try {	//处理输入非数值数据或输入的数是0
					score [k] = Double.parseDouble(str);
					if(0 > score[k] || 100 < score[k]) {
						JOptionPane.showMessageDialog(null, "请重新输入成绩", "警告：成绩输入错误", 
								JOptionPane.QUESTION_MESSAGE);
					} else 
						break;	//break语句用来强行终止循环语句的执行，结束循环。break只是跳出所在层
				} catch (Exception ne) {
					JOptionPane.showMessageDialog(null, "请重新输入成绩", "提示信息", 
							JOptionPane.QUESTION_MESSAGE);
				}
			}
			doubleSum += score[k];
			if(score[k] > maxScore) maxScore = score[k];
		}
		doubleAver = doubleSum / count;		//平均成绩保留2为小数
		System.out.println("这" + count + "个同学的平均成绩是：" + doubleAver);
		System.out.println("这" + count + "个同学的最好成绩是：" + maxScore);
	}

}
