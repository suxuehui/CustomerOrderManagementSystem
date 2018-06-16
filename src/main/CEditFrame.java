package main;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.CliSQL;
import recreate.RButton;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;

public class CEditFrame extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField CidT;
	private JTextField CpeoT;
	private JTextField CmaiT;
	private JTextField CtelT;
	private JTextField CaddT;
	private JTextField CnamT;
	private JTextField CnotT;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		try {
			CEditFrame dialog = new CEditFrame();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CEditFrame(String item,String idt,String nam,String add,String peo, String tel, String mai, String not) {
		setUndecorated(true);//无边框
		setAlwaysOnTop(true);
		setSize(600,400);
		setLocationRelativeTo(null);
		setFocusable(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(0, 0, 600, 82);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel label;
		if(item.equals("add"))
			label = new JLabel("\u6DFB\u52A0\u5BA2\u6237\u4FE1\u606F");
		else 
			label = new JLabel("修改客户信息");
			label.setForeground(Color.WHITE);
		label.setFont(new Font("微软雅黑", Font.BOLD, 20));
		label.setBounds(50, 29, 282, 24);
		panel.add(label);
		{
			JLabel label_1 = new JLabel("\u5BA2\u6237\u7F16\u53F7");
			label_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
			label_1.setBounds(47, 92, 64, 22);
			contentPanel.add(label_1);
		}
		{
			JLabel label_1 = new JLabel("\u5BA2\u6237\u540D\u79F0");
			label_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
			label_1.setBounds(47, 129, 64, 22);
			contentPanel.add(label_1);
		}
		{
			JLabel label_1 = new JLabel("\u5730\u5740");
			label_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
			label_1.setBounds(79, 203, 32, 22);
			contentPanel.add(label_1);
		}
		{
			JLabel label_1 = new JLabel("\u8054\u7CFB\u4EBA");
			label_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
			label_1.setBounds(307, 92, 48, 22);
			contentPanel.add(label_1);
		}
		
		JLabel label_1 = new JLabel("\u7535\u8BDD");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_1.setBounds(79, 168, 32, 22);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("\u90AE\u7BB1");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_2.setBounds(323, 168, 32, 22);
		contentPanel.add(label_2);
		
		JLabel label_3 = new JLabel("\u5907\u6CE8");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_3.setBounds(79, 243, 32, 22);
		contentPanel.add(label_3);
		
		CidT = new JTextField();
		CidT.setBounds(121, 94, 151, 20);
		contentPanel.add(CidT);
		CidT.setColumns(10);
		
		CpeoT = new JTextField();
		CpeoT.setColumns(10);
		CpeoT.setBounds(365, 94, 151, 21);
		contentPanel.add(CpeoT);
		
		CmaiT = new JTextField();
		CmaiT.setColumns(10);
		CmaiT.setBounds(365, 170, 151, 21);
		contentPanel.add(CmaiT);
		
		CtelT = new JTextField();
		CtelT.setColumns(10);
		CtelT.setBounds(121, 170, 151, 21);
		contentPanel.add(CtelT);
		
		CaddT = new JTextField();
		CaddT.setColumns(10);
		CaddT.setBounds(121, 205, 395, 21);
		contentPanel.add(CaddT);
		
		CnamT = new JTextField();
		CnamT.setColumns(10);
		CnamT.setBounds(121, 131, 151, 21);
		contentPanel.add(CnamT);
		
		CnotT = new JTextField();
		CnotT.setColumns(10);
		CnotT.setBounds(121, 245, 395, 54);
		contentPanel.add(CnotT);
		//显示文字
		if(item=="edi"){
			System.out.println("添加操作"); 
			CidT.setText(idt);
			CpeoT.setText(peo);
			CmaiT.setText(mai);
			CtelT.setText(tel);
			CaddT.setText(add);
			CnamT.setText(nam);
			CnotT.setText(not);
		}
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 309, 600, 91);
			contentPanel.add(buttonPane);
			{
				JButton okButton = new RButton("\u4FDD\u5B58");
				okButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
				okButton.setBounds(146, 27, 80, 37);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//编辑区输入信息的获取
						String id = CidT.getText();
	        			String nam = CnamT.getText();
	        			String add = CaddT.getText();
	        			String peo = CpeoT.getText();
	        			String tel = CtelT.getText();
	        			String mai = CmaiT.getText();
	        			String not = CnotT.getText();
						if(item.equals("add")) {
							Vector<?> j = CliSQL.search("Cid", id);
							if (!j.isEmpty())
								JOptionPane.showMessageDialog(okButton, "客户编号已存在", "错误",JOptionPane.ERROR_MESSAGE);
	        				else if (id.trim().equals("")|nam.trim().equals("")|peo.trim().equals("")|tel.trim().equals("")) {
		        				JOptionPane.showMessageDialog(okButton, "请输入完整的客户信息（地址、邮箱和备注可为空）", "错误",JOptionPane.ERROR_MESSAGE);
		        				//JOptionPane.setAwaysOnTop(true);
		        			}
		        			else {
		        				System.out.println("执行客户信息添加操作"); 
		        				CliSQL.edit("add",id,nam,add,peo,tel,mai,not);
		        				dispose();
		        			}
						}
						else if(item.equals("edi")) {
							if (id.trim().equals("")|nam.trim().equals("")|peo.trim().equals("")|tel.trim().equals(""))
		        				JOptionPane.showMessageDialog(okButton, "请保留基本的客户信息（地址、邮箱和备注可为空）", "错误",JOptionPane.ERROR_MESSAGE);
		        			else if(!idt.equals(id)) {
		        				System.out.println(idt+" "+id);
		        				JOptionPane.showMessageDialog(okButton, "请勿改变客户编号", "错误",JOptionPane.ERROR_MESSAGE);
		        			}
		        			else {
		        				System.out.println(id+mai); 
		        				System.out.println("执行客户信息修改操作"); 
		        				CliSQL.edit("edi",id,nam,add,peo,tel,mai,not);
		        				dispose();
		        			}
						}
					}
				});
				buttonPane.setLayout(null);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new RButton("\u53D6\u6D88");
				cancelButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setBounds(372, 27, 80, 37);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		addWindowListener(new WindowAdapter() {
	          @Override
	          public void windowClosing(WindowEvent e)
	          {
	             System.exit(0);
	          }
		});
	}
	
}
