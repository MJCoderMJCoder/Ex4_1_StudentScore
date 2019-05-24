package com.studenscore;
/**
 * JOptionPane(�����������ֱ�׼��ģʽ�Ի���)�Ĳ��ֹ��ܣ�
 * ConfirmDialog��ȷ�϶Ի���
 * InputDialog:�ı�����Ի���
 * MessageDialog����Ϣ��ʾ�Ի���
 * OptionDialog���ۺ�����3�й��ܵĶԻ���
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

/**
 * ������벢�������ѧ����ƽ���ɼ�����óɼ���
 * @author zhifengfei
 */
public class StudentScore {
	
	public static void main(String[] args) throws IOException {
		int k, count = 5;		//countΪѧ���ĸ���
		double score [] = new double[count];	//ѧ���ĳɼ���������������
		double doubleSum = 0.0, doubleAver = 0.0, maxScore = 0.0;	//ѧ�����ܳɼ���ƽ���ɼ�����߳ɼ�
		boolean contiGo = true;
		String str;
		
		/*System.in��InputStream�������ֽ�����BufferedReader�����ַ������� */
		//InputStreamReader���ֽ���ͨ���ַ�������������ʹ��ָ������Ĭ�ϣ����ַ�����ȡ�ֽڲ��������Ϊ�ַ�
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		for(k = 0; k < count; k++) {
			while(contiGo) {
				System.out.print("�������" + (k + 1) + "��ѧ���ĳɼ���");
				
				/*��ȡһ���ı��У��������С��س���ֱ�Ӹ��Ż�����Ϊĳ������ֹ������ѵ�����ĩβ���򷵻�null*/
				str = buf.readLine();
				try {	//�����������ֵ���ݻ����������0
					score [k] = Double.parseDouble(str);
					if(0 > score[k] || 100 < score[k]) {
						JOptionPane.showMessageDialog(null, "����������ɼ�", "���棺�ɼ��������", 
								JOptionPane.QUESTION_MESSAGE);
					} else 
						break;	//break�������ǿ����ֹѭ������ִ�У�����ѭ����breakֻ���������ڲ�
				} catch (Exception ne) {
					JOptionPane.showMessageDialog(null, "����������ɼ�", "��ʾ��Ϣ", 
							JOptionPane.QUESTION_MESSAGE);
				}
			}
			doubleSum += score[k];
			if(score[k] > maxScore) maxScore = score[k];
		}
		doubleAver = doubleSum / count;		//ƽ���ɼ�����2ΪС��
		System.out.println("��" + count + "��ͬѧ��ƽ���ɼ��ǣ�" + doubleAver);
		System.out.println("��" + count + "��ͬѧ����óɼ��ǣ�" + maxScore);
	}

}