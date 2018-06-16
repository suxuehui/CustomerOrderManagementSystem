package main;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.InvSQL;
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

public class IEditFrame extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField IidT;
	private JTextField OidT;
	private JTextField IpriT;
	private JTextField IperT;
	private JTextField OtotT;
	private JTextField CidT;
	private JTextField InotT;
	private JTextField IpeoT;
	private JTextField IdatT;

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
	public IEditFrame(String item,String Iidt,String Oid,String Cid,String Iper, String Ipri, String Otot, String Ipeo, String Idat,String Inot) {
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
			label = new JLabel("添加发票信息");
		else 
			label = new JLabel("修改发票信息");
			label.setForeground(Color.WHITE);
			label.setFont(new Font("微软雅黑", Font.BOLD, 20));
		label.setBounds(50, 29, 142, 28);
		panel.add(label);
		{
			JLabel label_1 = new JLabel("\u53D1\u7968\u7F16\u53F7");
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
			JLabel label_1 = new JLabel("\u7A0E\u540E\u603B\u4EF7");
			label_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
			label_1.setBounds(291, 161, 64, 22);
			contentPanel.add(label_1);
		}
		{
			JLabel label_1 = new JLabel("\u8BA2\u5355\u7F16\u53F7");
			label_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
			label_1.setBounds(291, 92, 64, 22);
			contentPanel.add(label_1);
		}
		
		JLabel label_1 = new JLabel("\u7A0E\u7387");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_1.setBounds(323, 129, 32, 22);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("\u7A0E\u989D");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_2.setBounds(79, 161, 32, 22);
		contentPanel.add(label_2);
		
		JLabel label_3 = new JLabel("\u5907\u6CE8");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_3.setBounds(79, 232, 32, 22);
		contentPanel.add(label_3);
		
		IidT = new JTextField();
		IidT.setBounds(121, 94, 151, 20);
		contentPanel.add(IidT);
		IidT.setColumns(10);
		
		OidT = new JTextField();
		OidT.setColumns(10);
		OidT.setBounds(365, 94, 151, 21);
		contentPanel.add(OidT);
		
		IpriT = new JTextField();
		IpriT.setColumns(10);
		IpriT.setBounds(121, 163, 151, 21);
		contentPanel.add(IpriT);
		
		IperT = new JTextField();
		IperT.setColumns(10);
		IperT.setBounds(365, 131, 151, 21);
		contentPanel.add(IperT);
		
		OtotT = new JTextField();
		OtotT.setColumns(10);
		OtotT.setBounds(365, 161, 151, 21);
		contentPanel.add(OtotT);
		
		CidT = new JTextField();
		CidT.setColumns(10);
		CidT.setBounds(121, 131, 151, 21);
		contentPanel.add(CidT);
		
		InotT = new JTextField();
		InotT.setColumns(10);
		InotT.setBounds(121, 234, 395, 54);
		contentPanel.add(InotT);
		
		IpeoT = new JTextField();
		IpeoT.setColumns(10);
		IpeoT.setBounds(121, 195, 151, 21);
		contentPanel.add(IpeoT);
		
		IdatT = new JTextField();
		IdatT.setColumns(10);
		IdatT.setBounds(365, 193, 151, 21);
		contentPanel.add(IdatT);
		//显示文字
		if(item=="edi"){
			System.out.println("添加操作"); 
			IidT.setText(Iidt);
			OidT.setText(Oid);
			IpriT.setText(Ipri);
			IperT.setText(Iper);
			OtotT.setText(Otot);
			IpeoT.setText(Ipeo);
			IdatT.setText(Idat);
			CidT.setText(Cid);
			InotT.setText(Inot);
		}
		contentPanel.setLayout(null);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 309, 600, 91);
			contentPanel.add(buttonPane);
			{
				JButton okButton = new RButton("\u4FDD\u5B58");
				okButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
				okButton.setBounds(145, 27, 82, 37);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//编辑区输入信息的获取
						String Iid = IidT.getText();
	        			String Cid = CidT.getText();
	        			String Otot = OtotT.getText();
	        			String Oid = OidT.getText();
	        			String Iper = IperT.getText();
	        			String Ipri = IpriT.getText();
	        			String Inot = InotT.getText();
	        			String Ipeo = IpeoT.getText();
	        			String Idat = IdatT.getText();
						if(item.equals("add")) {
							Vector<?> j = InvSQL.search("Iid", Iid);
							if (!j.isEmpty())
								JOptionPane.showMessageDialog(okButton, "发票编号已存在", "错误",JOptionPane.ERROR_MESSAGE);
	        				else if (Iid.trim().equals("")|Cid.trim().equals("")|Oid.trim().equals("")|Iper.trim().equals("")|Ipri.trim().equals("")|Otot.trim().equals("")|Ipeo.trim().equals("")|Idat.trim().equals("")) {
		        				JOptionPane.showMessageDialog(okButton, "请输入完整的发票信息", "错误",JOptionPane.ERROR_MESSAGE);
		        				//JOptionPane.setAwaysOnTop(true);
		        			}
		        			else {
		        				System.out.println("执行发票信息添加操作"); 
		        				InvSQL.edit("add",Iid,Oid,Cid,Iper,Ipri,Otot,Ipeo,Idat,Inot);
		        				dispose();
		        			}
						}
						else if(item.equals("edi")) {
							if (Iid.trim().equals("")|Cid.trim().equals("")|Oid.trim().equals("")|Iper.trim().equals("")|Ipri.trim().equals("")|Otot.trim().equals("")|Ipeo.trim().equals("")|Idat.trim().equals(""))
		        				JOptionPane.showMessageDialog(okButton, "请保持发票信息完整", "错误",JOptionPane.ERROR_MESSAGE);
		        			else if(!Iidt.equals(Iid))
		        				JOptionPane.showMessageDialog(okButton, "请勿改变发票编号", "错误",JOptionPane.ERROR_MESSAGE);
		        			else {
		        				System.out.println("执行发票信息修改操作"); 
		        				InvSQL.edit("edi",Iid,Oid,Cid,Iper,Ipri,Otot,Ipeo,Idat,Inot);
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
				cancelButton.setBounds(372, 27, 82, 37);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JLabel label_4 = new JLabel("\u5F00\u7968\u4EBA");
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_4.setBounds(63, 193, 48, 22);
		contentPanel.add(label_4);
		
		JLabel label_5 = new JLabel("\u5F00\u7968\u65E5\u671F");
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_5.setBounds(291, 193, 64, 22);
		contentPanel.add(label_5);
		
		addWindowListener(new WindowAdapter() {
	          @Override
	          public void windowClosing(WindowEvent e)
	          {
	             System.exit(0);
	          }
		});
	}
}
