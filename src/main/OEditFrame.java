package main;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.OrdSQL;
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

public class OEditFrame extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField PidT;
	private JTextField OnotT;
	private JTextField OdatT;
	private JTextField OidT;
	private JTextField CidT;
	private JTextField OnumT;
	private JTextField OtotT;
	private JTextField OstaT;

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
	public OEditFrame(String item,String Oidt,String Pid,String Cid,String num,String tot,String sta,String dat,String not) {
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
			label = new JLabel("添加订单信息");
		else 
			label = new JLabel("修改订单信息");
			label.setForeground(Color.WHITE);
			label.setFont(new Font("微软雅黑", Font.BOLD, 20));
		label.setBounds(50, 29, 146, 28);
		panel.add(label);
		{
			JLabel label_1 = new JLabel("\u8BA2\u5355\u7F16\u53F7");
			label_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
			label_1.setBounds(47, 92, 64, 22);
			contentPanel.add(label_1);
		}
		{
			JLabel label_1 = new JLabel("\u5BA2\u6237\u7F16\u53F7");
			label_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
			label_1.setBounds(47, 129, 64, 22);
			contentPanel.add(label_1);
		}
		{
			JLabel label_1 = new JLabel("\u72B6\u6001");
			label_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
			label_1.setBounds(79, 203, 32, 22);
			contentPanel.add(label_1);
		}
		{
			JLabel label_1 = new JLabel("\u5546\u54C1\u7F16\u53F7");
			label_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
			label_1.setBounds(307, 92, 64, 22);
			contentPanel.add(label_1);
		}
		
		JLabel label_1 = new JLabel("\u5546\u54C1\u6570\u91CF");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_1.setBounds(47, 168, 64, 22);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("\u7A0E\u540E\u603B\u4EF7");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_2.setBounds(307, 168, 64, 22);
		contentPanel.add(label_2);
		
		JLabel label_3 = new JLabel("\u5907\u6CE8");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_3.setBounds(79, 243, 32, 22);
		contentPanel.add(label_3);
		
		JLabel label_4 = new JLabel("\u521B\u5EFA\u65F6\u95F4");
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_4.setBounds(307, 129, 64, 22);
		contentPanel.add(label_4);
		
		PidT = new JTextField();
		PidT.setColumns(10);
		PidT.setBounds(377, 94, 151, 21);
		contentPanel.add(PidT);
		
		OnotT = new JTextField();
		OnotT.setColumns(10);
		OnotT.setBounds(121, 245, 407, 54);
		contentPanel.add(OnotT);
		
		
		OdatT = new JTextField();
		OdatT.setColumns(10);
		OdatT.setBounds(377, 131, 151, 21);
		contentPanel.add(OdatT);
		
		OidT = new JTextField();
		OidT.setColumns(10);
		OidT.setBounds(121, 94, 151, 21);
		contentPanel.add(OidT);
		
		CidT = new JTextField();
		CidT.setColumns(10);
		CidT.setBounds(121, 131, 151, 21);
		contentPanel.add(CidT);
		
		OnumT = new JTextField();
		OnumT.setColumns(10);
		OnumT.setBounds(121, 170, 151, 21);
		contentPanel.add(OnumT);
		
		OtotT = new JTextField();
		OtotT.setColumns(10);
		OtotT.setBounds(377, 170, 151, 21);
		contentPanel.add(OtotT);
		
		OstaT = new JTextField();
		OstaT.setColumns(10);
		OstaT.setBounds(121, 205, 151, 21);
		contentPanel.add(OstaT);
		//显示文字
		if(item=="edi"){
			System.out.println("添加操作"); 
			OidT.setText(Oidt);
			PidT.setText(Pid);
			CidT.setText(Cid);
			OnumT.setText(num);
			OtotT.setText(tot);
			OstaT.setText(sta);
			OdatT.setText(dat);
			OnotT.setText(not);
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
						String Oid = OidT.getText();
	        			String Pid = PidT.getText();
	        			String Cid = CidT.getText();
	        			String num = OnumT.getText();
	        			String tot = OtotT.getText();
	        			String sta = OstaT.getText();
	        			String dat = OdatT.getText();
	        			String not = OnotT.getText();
						if(item.equals("add")) {
							Vector<?> j = OrdSQL.search("Oid", Oid);
							if (!j.isEmpty())
								JOptionPane.showMessageDialog(okButton, "订单编号已存在", "错误",JOptionPane.ERROR_MESSAGE);
	        				else if (Oid.trim().equals("")|num.trim().equals("")|tot.trim().equals("")|sta.trim().equals("")|dat.trim().equals(""))
		        				JOptionPane.showMessageDialog(okButton, "请输入完整的订单信息（商品编号、客户编号和备注可为空）", "错误",JOptionPane.ERROR_MESSAGE);
		        			else {
		        				System.out.println("执行订单信息添加操作"); 
		        				OrdSQL.edit("add",Oid,Pid,Cid,num,tot,sta,dat,not);
		        				dispose();
		        			}
						}
						else if(item.equals("edi")) {
							if (Oid.trim().equals("")|num.trim().equals("")|tot.trim().equals("")|sta.trim().equals("")|dat.trim().equals(""))
		        				JOptionPane.showMessageDialog(null, "请保留基本的客户信息（商品编号、客户编号和备注可为空）", "错误",JOptionPane.ERROR_MESSAGE);
							else if(!Oidt.equals(Oid))
		        				JOptionPane.showMessageDialog(null, "请勿改变订单编号", "错误",JOptionPane.ERROR_MESSAGE);
							else {
		          				//System.out.println(id+mai); 
		        				System.out.println("执行订单信息修改操作"); 
		        				OrdSQL.edit("edi",Oid,Pid,Cid,num,tot,sta,dat,not);
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
