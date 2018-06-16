package main;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.PrdSQL;
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

public class PEditFrame extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField PidT;
	private JTextField PnamT;
	private JTextField PtypT;
	private JTextField PnumT;
	private JTextField PbirT;
	private JTextField PuniT;
	private JTextField PnotT;
	private JTextField PpriT;
	private JTextField PproT;

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
	public PEditFrame(String item,String idt,String nam,String uni,String pri, String num, String typ, String bir,String pro, String not) {
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
		
		JLabel label1;
		if(item.equals("add"))
			label1 = new JLabel("添加商品信息");
		else 
			label1 = new JLabel("修改商品信息");
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("微软雅黑", Font.BOLD, 20));
		label1.setBounds(50, 27, 146, 28);
		panel.add(label1);

		{
			JLabel label_1 = new JLabel("\u5546\u54C1\u7F16\u53F7");
			label_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
			label_1.setBounds(47, 92, 64, 22);
			contentPanel.add(label_1);
		}
		{
			JLabel label_1 = new JLabel("\u5355\u4F4D");
			label_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
			label_1.setBounds(79, 129, 32, 22);
			contentPanel.add(label_1);
		}
		{
			JLabel label_1 = new JLabel("\u4EA7\u5730");
			label_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
			label_1.setBounds(79, 203, 32, 22);
			contentPanel.add(label_1);
		}
		{
			JLabel label_1 = new JLabel("\u5546\u54C1\u540D\u79F0");
			label_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
			label_1.setBounds(291, 92, 64, 22);
			contentPanel.add(label_1);
		}
		
		JLabel label_1 = new JLabel("\u5269\u4F59\u6570\u91CF");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_1.setBounds(47, 168, 64, 22);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("\u7C7B\u522B");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_2.setBounds(323, 168, 32, 22);
		contentPanel.add(label_2);
		
		JLabel label_3 = new JLabel("\u5907\u6CE8");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_3.setBounds(79, 243, 32, 22);
		contentPanel.add(label_3);
		
		JLabel label_4 = new JLabel("\u5355\u4EF7");
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_4.setBounds(323, 129, 32, 22);
		contentPanel.add(label_4);
		
		JLabel label_5 = new JLabel("\u5236\u9020\u5546");
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_5.setBounds(307, 202, 48, 22);
		contentPanel.add(label_5);
		
		PidT = new JTextField();
		PidT.setBounds(121, 94, 151, 20);
		contentPanel.add(PidT);
		PidT.setColumns(10);
		
		PnamT = new JTextField();
		PnamT.setColumns(10);
		PnamT.setBounds(365, 94, 151, 21);
		contentPanel.add(PnamT);
		
		PtypT = new JTextField();
		PtypT.setColumns(10);
		PtypT.setBounds(365, 170, 151, 21);
		contentPanel.add(PtypT);
		
		PnumT = new JTextField();
		PnumT.setColumns(10);
		PnumT.setBounds(121, 170, 151, 21);
		contentPanel.add(PnumT);
		
		PbirT = new JTextField();
		PbirT.setColumns(10);
		PbirT.setBounds(121, 205, 151, 21);
		contentPanel.add(PbirT);
		
		PuniT = new JTextField();
		PuniT.setColumns(10);
		PuniT.setBounds(121, 131, 151, 21);
		contentPanel.add(PuniT);
		
		PnotT = new JTextField();
		PnotT.setColumns(10);
		PnotT.setBounds(121, 245, 395, 54);
		contentPanel.add(PnotT);
				
		PpriT = new JTextField();
		PpriT.setColumns(10);
		PpriT.setBounds(365, 131, 151, 21);
		contentPanel.add(PpriT);
		
		PproT = new JTextField();
		PproT.setColumns(10);
		PproT.setBounds(365, 204, 151, 21);
		contentPanel.add(PproT);
		//显示文字
		if(item=="edi"){
			System.out.println("添加操作"); 
			PidT.setText(idt);
			PnamT.setText(nam);
			PtypT.setText(typ);
			PnumT.setText(num);
			PbirT.setText(bir);
			PuniT.setText(uni);
			PnotT.setText(not);
			PproT.setText(pro);
			PpriT.setText(pri);
		}
		
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 309, 600, 91);
			contentPanel.add(buttonPane);
			{
				JButton okButton = new RButton("\u4FDD\u5B58");
				okButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
				okButton.setBounds(144, 27, 80, 37);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//编辑区输入信息的获取
						String id = PidT.getText();
	        			String uni = PuniT.getText();
	        			String bir = PbirT.getText();
	        			String nam = PnamT.getText();
	        			String num = PnumT.getText();
	        			String typ = PtypT.getText();
	        			String not = PnotT.getText();
	        			String pri = PpriT.getText();
	        			String pro = PproT.getText();
						if(item.equals("add")) {
							Vector<?> j = PrdSQL.search("Pid", id);
							if (!j.isEmpty())
								JOptionPane.showMessageDialog(okButton, "商品编号已存在", "错误",JOptionPane.ERROR_MESSAGE);
	        				else if (id.trim().equals("")|pri.trim().equals("")|num.trim().equals("")) {
								JOptionPane.showMessageDialog(okButton, "请输入必填的商品信息（商品编号、单价和剩余数量）", "错误",JOptionPane.ERROR_MESSAGE);
								//JOptionPane.setAwaysOnTop(true);
							}
							else {
								System.out.println("执行商品信息添加操作"); 
								PrdSQL.edit("add",id,nam,uni,pri,num,typ,bir,pro,not);
								dispose();
							}
						}
						else if(item.equals("edi")) {
							if (id.trim().equals("")|pri.trim().equals("")|num.trim().equals(""))
		        				JOptionPane.showMessageDialog(okButton, "请保留基本的商品信息（商品编号、单价和剩余数量）", "错误",JOptionPane.ERROR_MESSAGE);
		        			else if(!idt.equals(id))
		        				JOptionPane.showMessageDialog(okButton, "请勿改变商品编号", "错误",JOptionPane.ERROR_MESSAGE);
		        			else {
		        				System.out.println("执行商品信息修改操作"); 
		        				PrdSQL.edit("edi",id,nam,uni,pri,num,typ,bir,pro,not);
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
				cancelButton.setBounds(368, 27, 86, 37);
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
