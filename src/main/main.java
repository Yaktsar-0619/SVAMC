package main;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.net.*;
import java.io.*;
import java.beans.*;
public class main {
   protected static class mainframe extends JFrame{
	 protected static int mao;
	 protected static List results1;
	 protected static String[] sresult;
     protected static void frame() {
    	 //以下是窗体本身相关构造代码
        JFrame frmSvamc;
        JTextField textField;
    	mainframe window = new mainframe();
    	frmSvamc = new JFrame();
 		frmSvamc.setResizable(false);
 		frmSvamc.setTitle("SVAMC_深圳义工在线任务抓取器");
 		frmSvamc.setBounds(100, 100, 227, 187);
 		frmSvamc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		frmSvamc.getContentPane().setLayout(null);
 		//以下是窗体内标题/文字的构造代码
 		JLabel lblSvamc = new JLabel("SVAMC_深圳义工在线任务抓取器");
 		lblSvamc.setBounds(0, 0, 196, 15);
 		frmSvamc.getContentPane().add(lblSvamc);
 		
 		JLabel label = new JLabel("义工编号锚点：");
 		label.setBounds(10, 39, 103, 15);
 		frmSvamc.getContentPane().add(label);
 		//以下是锚点输入框的代码
 		textField = new JTextField();
 		textField.setHorizontalAlignment(SwingConstants.CENTER);
 		textField.setText("1318910");
 		textField.setBounds(108, 39, 110, 15);
 		frmSvamc.getContentPane().add(textField);
 		textField.setColumns(10);
 		textField.setEnabled(true);
 		//窗体内注释构造代码
 		JLabel label_1 = new JLabel("是否限制组别：");
 		label_1.setBounds(10, 64, 103, 15);
 		frmSvamc.getContentPane().add(label_1);
 		//单选框代码
 		JRadioButton radioButton = new JRadioButton("是");
 		radioButton.setBounds(108, 60, 47, 23);
 		frmSvamc.getContentPane().add(radioButton);
 		
 		JRadioButton radioButton_1 = new JRadioButton("否");
 		radioButton_1.setBounds(170, 60, 48, 23);
 		radioButton_1.setSelected(true);
 		frmSvamc.getContentPane().add(radioButton_1);
 		
 		ButtonGroup gp1 = new ButtonGroup();
 		gp1.add(radioButton);
 		gp1.add(radioButton_1);
 		//按钮相关代码
 		JButton button = new JButton("提交查询");
 		button.setBounds(62, 99, 93, 23);
 		frmSvamc.getContentPane().add(button);
 		
 		JButton button_1 = new JButton("关于程序");
 		button_1.setBounds(131, 138, 93, 23);
 		button_1.setEnabled(true);
 		frmSvamc.getContentPane().add(button_1);
        
 		frmSvamc.setVisible(true);
 		//以下是事件监听
 			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					aboutframe();
				}
 			});
 			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					boolean islocal = radioButton.isSelected();
					int [] resultlist = new int[200000];
					try {
					resultlist = kawashironitoriproject.main.find(islocal,Integer.parseInt(textField.getText()));
					for(int i=0;i <= resultlist.length;i++ ) {
					JOptionPane.showMessageDialog(null,resultlist[i],"Info", JOptionPane.INFORMATION_MESSAGE);
					if(resultlist[i] == 0) {
						break;
					}
					}
					//以下负责结果输出
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(null,"错误：你输入了一个无效值","Error", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
				}
 			});
    }
    	protected static void aboutframe() {
    	JDialog jd1 = new JDialog();
    	JPanel contentPanel = new JPanel();
    	jd1.setTitle("SVAMC_深圳义工在线任务抓取器");
 		jd1.setBounds(100, 100, 450, 300);
 		jd1.getContentPane().setLayout(new BorderLayout());
 		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
 		jd1.getContentPane().add(contentPanel, BorderLayout.CENTER);
 		contentPanel.setLayout(null);
 		
 		JLabel lblAbout = new JLabel("About(关于程序)");
 		lblAbout.setBounds(0, 0, 95, 15);
 		contentPanel.add(lblAbout);
 		
 		Component horizontalStrut = Box.createHorizontalStrut(20);
 		horizontalStrut.setBounds(20, 96, 247, -52);
 		contentPanel.add(horizontalStrut);
 		
 		JInternalFrame internalFrame = new JInternalFrame("关于程序");
 		internalFrame.setBounds(0, 25, 434, 236);
 		contentPanel.add(internalFrame);
 		internalFrame.getContentPane().setLayout(null);
 		
 		JLabel lblsvamc = new JLabel("程序名：SVAMC_深圳义工在线任务抓取器");
 		lblsvamc.setBounds(10, 28, 250, 15);
 		internalFrame.getContentPane().add(lblsvamc);
 		
 		JLabel lblmcgithub = new JLabel("开发者：Sino0619/github;1500373874@qq.com;(2人)");
 		lblmcgithub.setBounds(10, 45, 250, 15);
 		internalFrame.getContentPane().add(lblmcgithub);
 		
 		JLabel lblvalpha = new JLabel("版本号：V.alpha");
 		lblvalpha.setBounds(10, 60, 140, 15);
 		internalFrame.getContentPane().add(lblvalpha);
 		
 		JLabel lblfilesmcbkru = new JLabel("邮 箱：files233mc44@bk.ru;1500373874@qq.com");
 		lblfilesmcbkru.setBounds(10, 76, 250, 15);
 		internalFrame.getContentPane().add(lblfilesmcbkru);
 		
 		JLabel label_1 = new JLabel("事实证明，不是所有人都很闲");
 		label_1.setBounds(10, 181, 210, 15);
 		internalFrame.getContentPane().add(label_1);
 		
 		JLabel lblkawashironitori = new JLabel("项目代号：河城荷取（KawashiroNitori）");
 		lblkawashironitori.setBounds(10, 93, 250, 15);
 		internalFrame.getContentPane().add(lblkawashironitori);
 		internalFrame.setVisible(true);
 		jd1.setVisible(true);
 		
    	 }
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null,"本程序使用“Apache-2.0”开源协议合法分发，您使用本程序即默认您认真阅读并同意协议条款。","注意：", JOptionPane.WARNING_MESSAGE);
		JOptionPane.showMessageDialog(null,"协议内容：http://choosealicense.online/licenses/apache-2.0/","协议内容：", JOptionPane.WARNING_MESSAGE);
		mainframe.frame();
		boolean[] result = kawashironitoriproject.main.pinging();
		if(result[0] = false) {
			System.out.println(result[0]);
			JOptionPane.showMessageDialog(null,"警告：网络状况不佳，可能影响抓取","Warning", JOptionPane.WARNING_MESSAGE);
		}
	}

}
