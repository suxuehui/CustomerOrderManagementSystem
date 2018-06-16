package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.sun.awt.AWTUtilities;

import dao.CliSQL;
import dao.InvSQL;
import dao.OrdSQL;
import dao.PrdSQL;
import recreate.JTextFieldHintListener;
import recreate.RButton;

import java.awt.CardLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	 
	private static final long serialVersionUID = 1L;
	private JPanel MainPane;
	private JTable CliTab;
	private JTable InvTab;
	private JTable PrdTab;
	private JTable OrdTab;
	private JTextField SehT;
	private JTextField SSehT;
	private JTable StaTab;
	
	/**
	 * Launch the application.临时作为主函数
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame("1");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.创建主窗口
	 */
	public MainFrame(String usr,String level) {
		String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (ClassNotFoundException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}		
		
		setUndecorated(true);//无边框
		setVisible(true);
		setSize(1000,600);
		setLocationRelativeTo(null);
		setFocusable(true);
		//setResizable(false);
		MainPane = new JPanel();
		MainPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(MainPane);
		MainPane.setLayout(null);
				
		// 取得数据库的客户信息表的各行数据  
        Vector<?> CliRow = CliSQL.getRows(); 
        Vector<?> OrdRow = OrdSQL.getRows(); 
        Vector<?> InvRow = InvSQL.getRows(); 
        Vector<?> PrdRow = PrdSQL.getRows();  
        // 取得数据库的客户信息表的表头数据  
        Vector<Object> CliColumn = new Vector<Object>();
        CliColumn.add("客户编号");
        CliColumn.add("客户名称");
        CliColumn.add("地址");
        CliColumn.add("联系人");
        CliColumn.add("电话");
        CliColumn.add("邮箱");
        CliColumn.add("备注");
        Vector<Object> OrdColumn = new Vector<Object>();
        OrdColumn.add("订单编号");
        OrdColumn.add("商品编号");
        OrdColumn.add("客户编号");
        OrdColumn.add("数量");
        OrdColumn.add("税后总价");
        OrdColumn.add("订单状态");
        OrdColumn.add("创建时间");
        OrdColumn.add("备注");
        Vector<Object> InvColumn = new Vector<Object>();
        InvColumn.add("发票编号");
        InvColumn.add("订单编号");
        InvColumn.add("客户编号");
        InvColumn.add("税率");
        InvColumn.add("税额");
        InvColumn.add("税后总价");
        InvColumn.add("开票人");
        InvColumn.add("开票日期");
        InvColumn.add("备注");
        Vector<Object> PrdColumn = new Vector<Object>();
        PrdColumn.add("商品编号");
        PrdColumn.add("商品名称");
        PrdColumn.add("单位");
        PrdColumn.add("单价");
        PrdColumn.add("数量");
        PrdColumn.add("类别");
        PrdColumn.add("产地");
        PrdColumn.add("制造商");
        PrdColumn.add("备注");
        
        DefaultTableModel CliTable = new DefaultTableModel(CliRow,CliColumn);
        DefaultTableModel OrdTable = new DefaultTableModel(OrdRow,OrdColumn);
        DefaultTableModel InvTable = new DefaultTableModel(InvRow,InvColumn);
        DefaultTableModel PrdTable = new DefaultTableModel(PrdRow,PrdColumn);
        DefaultTableModel StaTable = new DefaultTableModel();
		ImageIcon black = new ImageIcon(MainFrame.class.getResource("黑色遮罩.png")); 
		
		JLabel DarkLab = new JLabel("");
		DarkLab.setBounds(0, 0, 1000, 600);
		MainPane.add(DarkLab);
		DarkLab.setIcon(black);
		DarkLab.setBackground(Color.LIGHT_GRAY);
		DarkLab.setVisible(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1000, 54);
		MainPane.add(panel);
		panel.setLayout(null);
		
		ImageIcon ico =new ImageIcon(MainFrame.class.getResource("title.png")); 
		ico.setImage(ico.getImage().getScaledInstance(94, 54,Image.SCALE_DEFAULT));
		JLabel LogoLab = new JLabel();
		LogoLab.setBounds(0, 0, 93, 54);
		LogoLab.setIcon(ico);
		panel.add(LogoLab);
		
		JLabel WelLab = new JLabel("\u6B22\u8FCE\u4F60\uFF0C");
		WelLab.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		WelLab.setBounds(838, 17, 60, 20);
		panel.add(WelLab);
		
		String[] Clis = {"客户编号","客户名称","联系人"};
 		JComboBox SehCBox = new JComboBox(Clis);
 		SehCBox.setForeground(Color.BLACK);
 		SehCBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
 		SehCBox.setBackground(Color.WHITE);
 		SehCBox.setBorder(null);
		SehCBox.setBounds(143, 16, 84, 23);
		panel.add(SehCBox);
		//主界面左上角的LOGO图片

		SehT = new JTextField();
		SehT.addFocusListener((new JTextFieldHintListener(SehT, "回车键进行搜索")));
		SehT.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		SehT.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		
		//搜索框回车确认监听器
		
		SehT.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() == '\n') {
					if(SehCBox.getItemAt(0)=="客户编号" ) {
						String Opt = (String)SehCBox.getSelectedItem();
						String Seh = SehT.getText();
						Vector<?> CliRow = CliSQL.search(Opt,Seh);
						if (CliRow.isEmpty())
							JOptionPane.showMessageDialog(null, "搜索无结果，请检查输入关键字是否有误", "错误",JOptionPane.ERROR_MESSAGE);
						CliTable.setDataVector(CliRow,CliColumn);//设置新内容
	        			CliTable.fireTableStructureChanged();
					}else if(SehCBox.getItemAt(0)=="订单编号") {
						String Opt = (String)SehCBox.getSelectedItem();
						String Seh = SehT.getText();
						Vector<?> OrdRow = OrdSQL.search(Opt,Seh);
						if (OrdRow.isEmpty())
							JOptionPane.showMessageDialog(null, "搜索无结果，请检查输入关键字是否有误", "错误",JOptionPane.ERROR_MESSAGE);
						OrdTable.setDataVector(OrdRow,OrdColumn);//设置新内容
	        			OrdTable.fireTableStructureChanged();
					}else if(SehCBox.getItemAt(0)=="发票编号") {
						String Opt = (String)SehCBox.getSelectedItem();
						String Seh = SehT.getText();
						Vector<?> InvRow = InvSQL.search(Opt,Seh);
						if (InvRow.isEmpty())
							JOptionPane.showMessageDialog(null, "搜索无结果，请检查输入关键字是否有误", "错误",JOptionPane.ERROR_MESSAGE);
						InvTable.setDataVector(InvRow,InvColumn);//设置新内容
	        			InvTable.fireTableStructureChanged();
					}else if(SehCBox.getItemAt(0)=="商品编号") {
						String Opt = (String)SehCBox.getSelectedItem();
						String Seh = SehT.getText();						
						Vector<?> PrdRow = PrdSQL.search(Opt,Seh);
						if (PrdRow.isEmpty())
							JOptionPane.showMessageDialog(null, "搜索无结果，请检查输入关键字是否有误", "错误",JOptionPane.ERROR_MESSAGE);
						PrdTable.setDataVector(PrdRow,PrdColumn);//设置新内容
	        			PrdTable.fireTableStructureChanged();//记得改下面搜索按钮的监听器
					}
				}
			}
		});
		SehT.setBounds(237, 18, 169, 20);
		panel.add(SehT);
		SehT.setColumns(10);
		
		//搜索返回按钮
		
		JButton BkBtn = new JButton("\u8FD4\u56DE");
		BkBtn.setBorder(new LineBorder(new Color(0, 153, 255), 2, true));
		BkBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		BkBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(SehCBox.getItemAt(0)=="客户编号" ) {
					CliTable.setDataVector(CliRow,CliColumn);//设置新内容
        			CliTable.fireTableStructureChanged();
				}else if(SehCBox.getItemAt(0)=="订单编号") {
					OrdTable.setDataVector(OrdRow,OrdColumn);//设置新内容
        			OrdTable.fireTableStructureChanged();
				}else if(SehCBox.getItemAt(0)=="发票编号") {
					InvTable.setDataVector(InvRow,InvColumn);//设置新内容
        			InvTable.fireTableStructureChanged();
				}else if(SehCBox.getItemAt(0)=="商品编号") {
					PrdTable.setDataVector(PrdRow,PrdColumn);//设置新内容
				}
			}
		});
		BkBtn.setBounds(427, 14, 61, 27);
		panel.add(BkBtn);
		
		JLabel Usr = new JLabel(usr);
		Usr.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Usr.setBounds(897, 17, 83, 20);
		panel.add(Usr);
		
		JLabel SehLab = new JLabel("");
		ImageIcon s = new ImageIcon(MainFrame.class.getResource("sb.png"));
		Image sh = s.getImage();  
		sh = sh.getScaledInstance(25, 25, Image.SCALE_DEFAULT);  
		s.setImage(sh);  
		SehLab.setIcon(s);
		SehLab.setBounds(108, 14, 25, 25);
		panel.add(SehLab);
		
		JPanel MenuPan = new JPanel();
		MenuPan.setBorder(null);
		MenuPan.setForeground(Color.WHITE);
		MenuPan.setBackground(new Color(0, 153, 255));
		MenuPan.setBounds(0, 54, 93, 546);
		MainPane.add(MenuPan);
		
		JButton CliBtn = new JButton();
		CliBtn.setForeground(Color.WHITE);
		CliBtn.setBorder(null);
		CliBtn.setBounds(0, 0, 93, 91);
		MenuPan.setLayout(null);
		ImageIcon C = new ImageIcon(MainFrame.class.getResource("C.png"));
		C.setImage(C.getImage().getScaledInstance(93, 93, Image.SCALE_DEFAULT));  
		CliBtn.setIcon(C);
		MenuPan.add(CliBtn);
		
		JButton OrdBtn = new JButton();
		OrdBtn.setBorder(null);
		OrdBtn.setBounds(0, 91, 93, 91);
		OrdBtn.setBackground(new Color(0, 153, 255));
		OrdBtn.setForeground(Color.WHITE);
		ImageIcon O = new ImageIcon(MainFrame.class.getResource("O.png"));
		Image img2 = O.getImage();  
		img2 = img2.getScaledInstance(93, 93, Image.SCALE_DEFAULT);  
		O.setImage(img2);  
		OrdBtn.setIcon(O);
		MenuPan.add(OrdBtn);
		
		JButton InvBtn = new JButton("");
		InvBtn.setBorder(null);
		InvBtn.setBounds(0, 182, 93, 91);
		InvBtn.setBackground(new Color(0, 153, 255));
		InvBtn.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		InvBtn.setForeground(Color.WHITE);
		ImageIcon I = new ImageIcon(MainFrame.class.getResource("I.png"));
		Image img3 = I.getImage();  
		img3 = img3.getScaledInstance(93, 93, Image.SCALE_DEFAULT);  
		I.setImage(img3);  
		InvBtn.setIcon(I);
		MenuPan.add(InvBtn);
		
		JButton PrdBtn = new JButton("");
		PrdBtn.setBorder(null);
		PrdBtn.setBounds(0, 273, 93, 91);
		PrdBtn.setBackground(new Color(0, 153, 255));
		PrdBtn.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		PrdBtn.setForeground(Color.WHITE);
		ImageIcon P = new ImageIcon(MainFrame.class.getResource("P.png"));
		Image img4 = P.getImage();  
		img4 = img4.getScaledInstance(93, 93, Image.SCALE_DEFAULT);  
		P.setImage(img4);  
		PrdBtn.setIcon(P);
		MenuPan.add(PrdBtn);
		
		JButton StaBtn = new JButton("");
		StaBtn.setBorder(null);
		StaBtn.setBounds(0, 364, 93, 91);
		StaBtn.setForeground(Color.WHITE);
		StaBtn.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		StaBtn.setBackground(new Color(0, 153, 255));
		ImageIcon S = new ImageIcon(MainFrame.class.getResource("S.png"));
		Image img5 = S.getImage();  
		img5 = img5.getScaledInstance(93, 93, Image.SCALE_DEFAULT);  
		S.setImage(img5);  
		StaBtn.setIcon(S);
		MenuPan.add(StaBtn);
		
				
		//退出按钮以及对应监听器
		JButton ExiBtn = new JButton("");
		ExiBtn.setBorder(null);
		ExiBtn.setBounds(0, 455, 93, 91);
		ExiBtn.setBackground(new Color(0, 153, 255));
		ExiBtn.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		ExiBtn.setForeground(Color.WHITE);
		ImageIcon E = new ImageIcon(MainFrame.class.getResource("E.png"));
		Image img6 = E.getImage();  
		img6 = img6.getScaledInstance(93, 93, Image.SCALE_DEFAULT);  
		E.setImage(img6);  
		ExiBtn.setIcon(E);
		ExiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int res=JOptionPane.showConfirmDialog(null, "确认退出管理系统？", "确认退出", JOptionPane.YES_NO_OPTION);
				if(res==JOptionPane.YES_OPTION)
					System.exit(0);
				else
					return; 
			}
		});
		MenuPan.add(ExiBtn);
		
		JPanel CardPan = new JPanel();
		CardPan.setBounds(94, 54, 907, 545);
		MainPane.add(CardPan);
		CardLayout card= new CardLayout();
		CardPan.setLayout(card);
		//查找选项的切换
		CliBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SehT.setVisible(true);
				SehCBox.setVisible(true);
				SehLab.setVisible(true);
				BkBtn.setVisible(true);
				SehCBox.removeAllItems();
				card.show(CardPan,"客户");
				SehCBox.addItem("客户编号");
				SehCBox.addItem("客户名称");
				SehCBox.addItem("联系人");
			}
		});
		OrdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SehT.setVisible(true);
				SehCBox.setVisible(true);
				SehLab.setVisible(true);
				BkBtn.setVisible(true);
				SehCBox.removeAllItems();
				card.show(CardPan,"订单");  
				SehCBox.addItem("订单编号");
				SehCBox.addItem("商品编号");
				SehCBox.addItem("客户编号");
				SehCBox.addItem("状态");
				SehCBox.addItem("创建时间");
			}
		});
		InvBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SehT.setVisible(true);
				SehCBox.setVisible(true);
				SehLab.setVisible(true);
				BkBtn.setVisible(true);
				SehCBox.removeAllItems();
				card.show(CardPan,"发票"); 
				SehCBox.addItem("发票编号");
				SehCBox.addItem("订单编号");
				SehCBox.addItem("客户编号");
				SehCBox.addItem("开票人");
				SehCBox.addItem("开票日期");
			}
		});
		PrdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SehT.setVisible(true);
				SehCBox.setVisible(true);
				SehLab.setVisible(true);
				BkBtn.setVisible(true);
				SehCBox.removeAllItems();
				card.show(CardPan,"货物");  
				SehCBox.addItem("商品编号");
				SehCBox.addItem("名称");
				SehCBox.addItem("类别");
				SehCBox.addItem("产地");
				SehCBox.addItem("制造商");
			}
		});
		StaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SehT.setVisible(false);
				SehCBox.setVisible(false);
				SehLab.setVisible(false);
				BkBtn.setVisible(false);
				SehCBox.setVisible(false);
				card.show(CardPan,"统计");
			}
		});

		
		JPanel CliPan = new JPanel();
		CardPan.add(CliPan, "客户");
		CliPan.setLayout(null);
		
		//删除客户信息
		
		JButton DCBtn = new JButton("\u5220\u9664\u5BA2\u6237");
		DCBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		DCBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (level.equals("[管理员]")) {
					int row = CliTab.getSelectedRow();
	        		if (row==-1)
	        			JOptionPane.showMessageDialog(null, "请选中需要删除的客户", "错误",JOptionPane.ERROR_MESSAGE);
	            	else {
						Object Cid = CliTab.getValueAt(row, 0);
						String Cidd = (String)Cid;
	            		int res=JOptionPane.showConfirmDialog(null, "确认删除选中客户？", "确认删除", JOptionPane.YES_NO_OPTION);
	    				if(res==JOptionPane.YES_OPTION) {
	    					System.out.println("执行删除操作"); 
	    					CliSQL.del(Cidd);
	    					Vector<?> CliRow = CliSQL.getRows(); 
	    					CliTable.setDataVector(CliRow,CliColumn);//设置新内容
	    					CliTable.fireTableStructureChanged();
	    				}
	    				else
	    					return; 
	        		}
				}
				else
					JOptionPane.showMessageDialog(null, "您无权对信息进行修改", "错误",JOptionPane.ERROR_MESSAGE);	
			}
		});
		
		JLabel label_5 = new JLabel("");
		ImageIcon ci = new ImageIcon(MainFrame.class.getResource("c1.png"));
		ci.setImage(ci.getImage().getScaledInstance(22,22, Image.SCALE_DEFAULT));  
		label_5.setIcon(ci);
		label_5.setBounds(43, 33, 22, 22);
		CliPan.add(label_5);
		DCBtn.setBounds(771, 28, 98, 27);
		CliPan.add(DCBtn);
		
		//添加客户信息
		
		JButton ACBtn = new JButton("\u6DFB\u52A0\u5BA2\u6237");
		ACBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		ACBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (level.equals("[管理员]")) {
					CEditFrame a = new CEditFrame("add",null, null, null, null, null, null, null);
					a.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
					DarkLab.setVisible(true);
					a.setVisible(true);
					DarkLab.setVisible(false);
				}
				else
					JOptionPane.showMessageDialog(null, "您无权对信息进行修改", "错误",JOptionPane.ERROR_MESSAGE);	
			}
		});
		ACBtn.setBounds(664, 28, 96, 27);
		CliPan.add(ACBtn);
		
		//修改客户信息
		
		JButton ECBtn = new JButton("\u7F16\u8F91\u5BA2\u6237");
		ECBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		ECBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = CliTab.getSelectedRow();
				if (level.equals("[管理员]")) {
					if (row==-1)
	        			JOptionPane.showMessageDialog(null, "请选中需要编辑的客户", "错误",JOptionPane.ERROR_MESSAGE);
					else{
						String id = CliTab.getValueAt(row, 0).toString();
						String nam = CliTab.getValueAt(row, 1).toString();
						String add = CliTab.getValueAt(row, 2).toString();
						String peo = CliTab.getValueAt(row, 3).toString();
						String tel = CliTab.getValueAt(row, 4).toString();
						String mai = CliTab.getValueAt(row, 5).toString();
	    			
						Object no = CliTab.getValueAt(row, 6);
						String not;
						if(no!=null)
							not = no.toString();
						else
							not = null;
						CEditFrame a = new CEditFrame("edi",id,nam,add,peo,tel,mai,not);
						a.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
						DarkLab.setVisible(true);
						a.setVisible(true);
						DarkLab.setVisible(false);
					}
				}
				else
					JOptionPane.showMessageDialog(null, "您无权对信息进行修改", "错误",JOptionPane.ERROR_MESSAGE);	
			}
		});
		ECBtn.setBounds(556, 28, 98, 27);
		CliPan.add(ECBtn);
		
		JLabel CliLab = new JLabel("         \u5BA2\u6237\u4FE1\u606F");
		CliLab.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		CliLab.setForeground(Color.BLACK);
		CliLab.setBackground(Color.WHITE);
		CliLab.setBounds(20, 20, 868, 45);
		CliLab.setOpaque(true);
		CliPan.add(CliLab);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(20, 64, 868, 461);
		CliPan.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane CliSPan = new JScrollPane();
		CliSPan.setBounds(-1, 0, 872, 463);
		panel_2.add(CliSPan);
		CliSPan.setOpaque(false);
		CliSPan.getViewport().setOpaque(false);  
		CliSPan.setBorder(null);
		CliSPan.setBackground(Color.WHITE);
		
		CliTab = new JTable(CliTable){
		    /**
			 * 表格不允许被编辑
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column)
		    {
		               return false;}
		    };
		CliTab.setBorder(null);
		CliTab.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		CliTab.setBackground(Color.WHITE);
		CliSPan.setViewportView(CliTab);
		
		JPanel OrdPan = new JPanel();
		CardPan.add(OrdPan, "订单");
		OrdPan.setLayout(null);
		
		//订单添加按钮
		
		JButton AOBtn = new JButton("\u6DFB\u52A0\u8BA2\u5355");
		AOBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		AOBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (level.equals("[管理员]")) {
					OEditFrame a = new OEditFrame("add",null, null, null, null, null, null, null, null);
					a.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
					DarkLab.setVisible(true);
					a.setVisible(true);
					DarkLab.setVisible(false);
				}
				else
					JOptionPane.showMessageDialog(null, "您无权对信息进行修改", "错误",JOptionPane.ERROR_MESSAGE);	
			}
		});
		AOBtn.setBounds(678, 28, 93, 27);
		OrdPan.add(AOBtn);
		
		//订单删除按钮
		
		JButton DOBtn = new JButton("\u5220\u9664\u8BA2\u5355");
		DOBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		DOBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (level.equals("[管理员]")) {
					int row = OrdTab.getSelectedRow();
	        		if (row==-1)
	        			JOptionPane.showMessageDialog(null, "请选中需要删除的订单", "错误",JOptionPane.ERROR_MESSAGE);
	            	else {
	            		int res=JOptionPane.showConfirmDialog(null, "确认删除选中订单？", "确认删除", JOptionPane.YES_NO_OPTION);
	    				if(res==JOptionPane.YES_OPTION) {
							Object Oid = OrdTab.getValueAt(row, 0);
							String Oidd = (String)Oid;
	    					System.out.println("执行删除操作"); 
	            			OrdSQL.del(Oidd);
	            			Vector<?> OrdRow = OrdSQL.getRows(); 
	            	    	OrdTable.setDataVector(OrdRow,OrdColumn);//设置新内容
	            			OrdTable.fireTableStructureChanged();
	    				}
	    				else
	    					return;
	        			
	        		}
				}
				else
					JOptionPane.showMessageDialog(null, "您无权对信息进行修改", "错误",JOptionPane.ERROR_MESSAGE);	
			}
		});
		DOBtn.setBounds(779, 28, 95, 27);
		OrdPan.add(DOBtn);
		
		//订单修改按钮
		
		JButton EOBtn = new JButton("\u7F16\u8F91\u8BA2\u5355");
		EOBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		EOBtn.setBackground(new Color(240, 240, 240));
		EOBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (level.equals("[管理员]")) {
					int row = OrdTab.getSelectedRow();
					if (row==-1)
	        			JOptionPane.showMessageDialog(null, "请选中需要编辑的订单", "错误",JOptionPane.ERROR_MESSAGE);
					else{
						String Oid = OrdTab.getValueAt(row, 0).toString();
						String Pid = OrdTab.getValueAt(row, 1).toString();
						String Cid = OrdTab.getValueAt(row, 2).toString();
	    				String num = OrdTab.getValueAt(row, 3).toString();
	    				String tot = OrdTab.getValueAt(row, 4).toString();
	    				String sta = OrdTab.getValueAt(row, 5).toString();
	    				String dat = OrdTab.getValueAt(row, 6).toString();
	    				Object no = OrdTab.getValueAt(row, 7);
	    				String not;
	    				if (no!=null)
	    					not = no.toString();
	    				else
		    				not = null;
						OEditFrame a = new OEditFrame("edi",Oid,Pid,Cid,num,tot,sta,dat,not);
						a.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
						DarkLab.setVisible(true);
						a.setVisible(true);
						DarkLab.setVisible(false);
					}
				}
				else
					JOptionPane.showMessageDialog(null, "您无权对信息进行修改", "错误",JOptionPane.ERROR_MESSAGE);	
			}
		});
		EOBtn.setBounds(575, 28, 93, 27);
		OrdPan.add(EOBtn);
		
		JLabel label_6 = new JLabel("");
		ImageIcon oi = new ImageIcon(MainFrame.class.getResource("o1.png"));
		oi.setImage(oi.getImage().getScaledInstance(22,22, Image.SCALE_DEFAULT));  
		label_6.setIcon(oi);
		label_6.setBounds(43, 33, 22, 22);
		OrdPan.add(label_6);
		
		JLabel OrdLab = new JLabel("         \u8BA2\u5355\u4FE1\u606F");
		OrdLab.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		OrdLab.setOpaque(true);
		OrdLab.setForeground(Color.BLACK);
		OrdLab.setBackground(Color.WHITE);
		OrdLab.setBounds(20, 20, 867, 45);
		OrdPan.add(OrdLab);
		
		JPanel OPan = new JPanel();
		OPan.setBackground(Color.WHITE);
		OPan.setBounds(20, 64, 868, 461);
		OrdPan.add(OPan);
		OPan.setLayout(null);
		
		JScrollPane OrdSPan = new JScrollPane();
		OrdSPan.setBounds(-1, 0, 872, 463);
		OPan.add(OrdSPan);
		OrdSPan.setOpaque(false);
		OrdSPan.getViewport().setOpaque(false);  
		OrdSPan.setBackground(Color.WHITE);
		
		OrdTab = new JTable(OrdTable){
		    /**
			 * 表格不允许被编辑
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column)
		    {
		               return false;}
		    };
		OrdSPan.setViewportView(OrdTab);
		
		JPanel InvPan = new JPanel();
		CardPan.add(InvPan, "发票");
		InvPan.setLayout(null);
		
		//添加发票按钮
		
		JButton AIBtn = new JButton("\u6DFB\u52A0\u53D1\u7968");
		AIBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		AIBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (level.equals("[管理员]")) {
					IEditFrame a = new IEditFrame("add",null, null, null, null, null, null, null, null, null);
					a.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
					DarkLab.setVisible(true);
					a.setVisible(true);
					DarkLab.setVisible(false);
				}
				else
					JOptionPane.showMessageDialog(null, "您无权对信息进行修改", "错误",JOptionPane.ERROR_MESSAGE);	
			}
		});
		
		JLabel Iicon = new JLabel();
		ImageIcon Ii = new ImageIcon(MainFrame.class.getResource("i1.png"));
		Ii.setImage(Ii.getImage().getScaledInstance(22,22, Image.SCALE_DEFAULT));  
		Iicon.setIcon(Ii);
		Iicon.setBounds(43, 33, 22, 22);
		InvPan.add(Iicon);
		AIBtn.setBounds(675, 28, 93, 27);
		InvPan.add(AIBtn);
		
		//发票删除操作
		
		JButton DIBtn = new JButton("\u5220\u9664\u53D1\u7968");
		DIBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		DIBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (level.equals("[管理员]")) {
					int row = InvTab.getSelectedRow();
	        		if (row==-1)
	        			JOptionPane.showMessageDialog(null, "请选中需要删除的发票", "错误",JOptionPane.ERROR_MESSAGE);
	            	else {
						Object Iid = InvTab.getValueAt(row, 0);
						String Iidd = (String)Iid;
	            		int res=JOptionPane.showConfirmDialog(null, "确认删除选中发票？", "确认删除", JOptionPane.YES_NO_OPTION);
	    				if(res==JOptionPane.YES_OPTION) {
	    					System.out.println("执行发票删除操作"); 
	    					InvSQL.del(Iidd);
	    					Vector<?> InvRow = InvSQL.getRows(); 
	    					InvTable.setDataVector(InvRow,InvColumn);//设置新内容
	    					InvTable.fireTableStructureChanged();
	    				}
	    				else
	    					return;
	        		}
				}
				else
					JOptionPane.showMessageDialog(null, "您无权对信息进行修改", "错误",JOptionPane.ERROR_MESSAGE);	
			}
		});
		DIBtn.setBounds(778, 28, 93, 27);
		InvPan.add(DIBtn);
		
		//编辑发票信息
		
		JButton EIBtn = new JButton("\u7F16\u8F91\u53D1\u7968");
		EIBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		EIBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (level.equals("[管理员]")) {
					int row = InvTab.getSelectedRow();
					if (row==-1)
	        			JOptionPane.showMessageDialog(null, "请选中需要编辑的发票", "错误",JOptionPane.ERROR_MESSAGE);
					else{
						String Iid = InvTab.getValueAt(row, 0).toString();
						String Oid = InvTab.getValueAt(row, 1).toString();
						String Cid = InvTab.getValueAt(row, 2).toString();
						String Iper = InvTab.getValueAt(row, 3).toString();
						String Ipri = InvTab.getValueAt(row, 4).toString();
		    			String Otot = InvTab.getValueAt(row, 5).toString();
		    			String Ipeo = InvTab.getValueAt(row, 6).toString();
		    			String Idat = InvTab.getValueAt(row, 7).toString();
		    			Object no = InvTab.getValueAt(row, 8);
		    			String Inot;
						if (no!=null)
		    				Inot = no.toString();
		    			else
		    				Inot = null;
						//System.out.println(getname);
						IEditFrame a = new IEditFrame("edi",Iid,Oid,Cid,Iper,Ipri,Otot,Ipeo,Idat,Inot);
						a.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
						DarkLab.setVisible(true);
						a.setVisible(true);
						DarkLab.setVisible(false);
					}
				}
				else
					JOptionPane.showMessageDialog(null, "您无权对信息进行修改", "错误",JOptionPane.ERROR_MESSAGE);	
			}
		});
		EIBtn.setBounds(572, 28, 93, 27);
		InvPan.add(EIBtn);
		
		JLabel label_1 = new JLabel("         \u53D1\u7968\u4FE1\u606F");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		label_1.setOpaque(true);
		label_1.setForeground(Color.BLACK);
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(20, 20, 868, 45);
		InvPan.add(label_1);
		
		JPanel IPan = new JPanel();
		IPan.setBackground(Color.WHITE);
		IPan.setBounds(20, 64, 868, 461);
		InvPan.add(IPan);
		IPan.setLayout(null);
		
		JScrollPane InvSPan = new JScrollPane();
		InvSPan.setBounds(-1, 0, 872, 463);
		IPan.add(InvSPan);
		InvSPan.setOpaque(false);
		InvSPan.getViewport().setOpaque(false); 
		
		InvTab = new JTable(InvTable);
		InvSPan.setViewportView(InvTab);
		
		
		JPanel PrdPan = new JPanel();
		CardPan.add(PrdPan, "货物");
		PrdPan.setLayout(null);
		
		//添加商品
		
		JButton APBtn = new JButton("\u6DFB\u52A0\u5546\u54C1");
		APBtn.setFont(new Font("宋体", Font.PLAIN, 14));
		APBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (level.equals("[管理员]")) {
					PEditFrame a = new PEditFrame("add",null, null, null, null, null, null, null, null, null);
					a.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
					DarkLab.setVisible(true);
					a.setVisible(true);
					DarkLab.setVisible(false);
				}
				else
					JOptionPane.showMessageDialog(null, "您无权对信息进行修改", "错误",JOptionPane.ERROR_MESSAGE);	
			}
		});
		
		JLabel Picon = new JLabel();
		ImageIcon pi = new ImageIcon(MainFrame.class.getResource("p1.png"));
		pi.setImage(pi.getImage().getScaledInstance(22,22, Image.SCALE_DEFAULT));  		
		Picon.setIcon(pi);
		Picon.setBounds(43, 33, 22, 22);
		PrdPan.add(Picon);
		APBtn.setBounds(675, 33, 93, 25);
		PrdPan.add(APBtn);
		
		JButton DPBtn = new JButton("\u5220\u9664\u5546\u54C1");
		DPBtn.setFont(new Font("宋体", Font.PLAIN, 14));
		DPBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (level.equals("[管理员]")) {
					int row = PrdTab.getSelectedRow();
	        		if (row==-1)
	        			JOptionPane.showMessageDialog(null, "请选中需要删除的商品", "错误",JOptionPane.ERROR_MESSAGE);
	            	else {
						Object Pid = PrdTab.getValueAt(row, 0);
						String Pidd = (String)Pid;
	            		int res=JOptionPane.showConfirmDialog(null, "确认删除选中商品？", "确认删除", JOptionPane.YES_NO_OPTION);
	    				if(res==JOptionPane.YES_OPTION) {
	    					System.out.println("执行删除操作"); 
	    					PrdSQL.del(Pidd);
	    					Vector<?> PrdRow = PrdSQL.getRows(); 
	    					PrdTable.setDataVector(PrdRow,PrdColumn);//设置新内容
	    					PrdTable.fireTableStructureChanged();
	    				}
	    				else
	    					return;
	        		}
				}
				else
					JOptionPane.showMessageDialog(null, "您无权对信息进行修改", "错误",JOptionPane.ERROR_MESSAGE);	
			}
		});
		DPBtn.setBounds(778, 33, 93, 25);
		PrdPan.add(DPBtn);
		
		//商品信息编辑
		
		JButton EPBtn = new JButton("\u7F16\u8F91\u5546\u54C1");
		EPBtn.setFont(new Font("宋体", Font.PLAIN, 14));
		EPBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (level.equals("[管理员]")) {
					int row = PrdTab.getSelectedRow();
					if (row==-1)
	        			JOptionPane.showMessageDialog(null, "请选中需要编辑的商品", "错误",JOptionPane.ERROR_MESSAGE);
					else{
						String id = PrdTab.getValueAt(row, 0).toString();
		    			String pri = PrdTab.getValueAt(row, 3).toString();
		    			String num = PrdTab.getValueAt(row, 4).toString();
		    			
		    			Object na = PrdTab.getValueAt(row, 1);
		    			Object un = PrdTab.getValueAt(row, 2);
		    			Object ty = PrdTab.getValueAt(row, 5);
		    			Object bi = PrdTab.getValueAt(row, 6);
		    			Object pr = PrdTab.getValueAt(row, 7);
		    			Object no = PrdTab.getValueAt(row, 8);
		    			String nam,uni,typ,bir,pro,not;
						if (na!=null)
		    				nam = na.toString();
		    			else 
		    				nam = null;
						if (un!=null)
		    				uni = un.toString();
		    			else 
		    				uni = null;
						if (ty!=null)
		    				typ = ty.toString();
		    			else 
		    				typ = null;
						if (bi!=null)
		    				bir = bi.toString();
		    			else 
		    				bir = null;
						if (pr!=null)
		    				pro = pr.toString();
		    			else 
		    				pro = null;
						if (no!=null)
		    				not = no.toString();
		    			else 
		    				not = null;
						//System.out.println(getname);
						PEditFrame a = new PEditFrame("edi",id,nam,uni,pri,num,typ,bir,pro,not);
						a.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
						DarkLab.setVisible(true);
						a.setVisible(true);
						DarkLab.setVisible(false);
					}
				}
				else
					JOptionPane.showMessageDialog(null, "您无权对信息进行修改", "错误",JOptionPane.ERROR_MESSAGE);	
			}
		});
		EPBtn.setBounds(575, 33, 93, 25);
		PrdPan.add(EPBtn);
		
		JLabel label_2 = new JLabel("         \u5546\u54C1\u4FE1\u606F");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		label_2.setOpaque(true);
		label_2.setForeground(Color.BLACK);
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(20, 20, 868, 45);
		PrdPan.add(label_2);
		
		JPanel PPan = new JPanel();
		PPan.setBackground(Color.WHITE);
		PPan.setBounds(20, 64, 868, 461);
		PrdPan.add(PPan);
		PPan.setLayout(null);
		
		JScrollPane PrdSPan = new JScrollPane();
		PrdSPan.setBounds(-1, 0, 872, 463);
		PPan.add(PrdSPan);
		PrdSPan.setOpaque(false);
		PrdSPan.getViewport().setOpaque(false);  
		
		PrdTab = new JTable(PrdTable);
		PrdSPan.setViewportView(PrdTab);
		
		JPanel StaPan = new JPanel();
		CardPan.add(StaPan, "统计");
		StaPan.setLayout(null);
		
		JLabel Iico = new JLabel("");
		ImageIcon si = new ImageIcon(MainFrame.class.getResource("i1.png"));
		si.setImage(si.getImage().getScaledInstance(22,22, Image.SCALE_DEFAULT));  
		Iico.setIcon(si);
		Iico.setBounds(43, 33, 22, 22);
		StaPan.add(Iico);
		
		JLabel Sico = new JLabel("");
		ImageIcon sci = new ImageIcon(MainFrame.class.getResource("sc1.png"));
		sci.setImage(sci.getImage().getScaledInstance(22,22, Image.SCALE_DEFAULT));  
		Sico.setIcon(sci);
		Sico.setBounds(43, 133, 22, 22);
		StaPan.add(Sico);
		
		JLabel label = new JLabel("         \u67E5\u8BE2\u7ED3\u679C");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		label.setOpaque(true);
		label.setForeground(Color.BLACK);
		label.setBackground(Color.WHITE);
		label.setBounds(20, 122, 868, 45);
		StaPan.add(label);
		
		JLabel label_3 = new JLabel("         \u8BA2\u5355\u67E5\u8BE2");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		label_3.setOpaque(true);
		label_3.setForeground(Color.BLACK);
		label_3.setBackground(Color.WHITE);
		label_3.setBounds(20, 21, 868, 45);
		StaPan.add(label_3);
		
		JPanel SehPan = new JPanel();
		SehPan.setBackground(Color.WHITE);
		SehPan.setBounds(20, 67, 868, 45);
		StaPan.add(SehPan);
		SehPan.setLayout(null);
		
		SSehT = new JTextField();
		SSehT.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		SSehT.setColumns(10);
		SSehT.setBounds(213, 10, 200, 25);
		SehPan.add(SSehT);
		
		JButton SSehBtn = new JButton("\u641C\u7D22");
		SSehBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		SSehBtn.setBounds(423, 9, 70, 27);
		SehPan.add(SSehBtn);
		
		String[] Opt= {"客户","商品"};
		JComboBox<Object> Opt1CBox = new JComboBox<Object>(Opt);
		Opt1CBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		Opt1CBox.setBounds(35, 10, 58, 25);
		SehPan.add(Opt1CBox);
		
		String[] Opt2= {"客户编号","客户名称","联系人"};
		JComboBox<String> Opt2Box = new JComboBox(Opt2);
		Opt2Box.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		Opt2Box.setBounds(114, 10, 86, 25);
		SehPan.add(Opt2Box);
		
		JPanel ConPan = new JPanel();
		ConPan.setBackground(Color.WHITE);
		ConPan.setBounds(20, 491, 868, 34);
		StaPan.add(ConPan);
		ConPan.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BA2\u5355\u603B\u6570");
		lblNewLabel.setBounds(38, 6, 64, 22);
		ConPan.add(lblNewLabel);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		JLabel OrdN = new JLabel("            ");
		OrdN.setBounds(128, 6, 60, 22);
		ConPan.add(OrdN);
		OrdN.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1 = new JLabel("\u603B\u4EF7");
		lblNewLabel_1.setBounds(366, 6, 32, 22);
		ConPan.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		JLabel TotN = new JLabel("             ");
		TotN.setBounds(416, 6, 65, 22);
		ConPan.add(TotN);
		TotN.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		JPanel SPan = new JPanel();
		SPan.setBackground(Color.WHITE);
		SPan.setBounds(20, 165, 868, 326);
		StaPan.add(SPan);
		SPan.setLayout(null);
		
		JScrollPane StaSPan = new JScrollPane();
		StaSPan.setBounds(-1, 0, 872, 328);
		SPan.add(StaSPan);
		StaSPan.setOpaque(false);
		StaSPan.getViewport().setOpaque(false);  
		
		StaTab = new JTable(StaTable) {
		/**
		 * 表格不允许被编辑
		 */
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column)
        {
                   return false;}
        };
		StaSPan.setViewportView(StaTab);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(43, 140, 22, 22);
		StaPan.add(label_4);
		
		Opt1CBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (Opt1CBox.getSelectedItem()=="客户") {
					Opt2Box.removeAllItems();
					Opt2Box.addItem("客户编号");
					Opt2Box.addItem("客户名称");
					Opt2Box.addItem("联系人");
				}
				else if(Opt1CBox.getSelectedItem()=="商品"){
					Opt2Box.removeAllItems();
					Opt2Box.addItem("商品编号");
					Opt2Box.addItem("名称");
					Opt2Box.addItem("类别");
					Opt2Box.addItem("产地");
					Opt2Box.addItem("制造商");
				}
			}
		});

		SSehBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n = (String) Opt2Box.getSelectedItem();
				String Seh = SSehT.getText();
				switch(n){
				case "客户编号":
					Vector<?> StaRow1 = OrdSQL.search("Cli","Cid",Seh);
					StaTable.setDataVector(StaRow1,OrdColumn);//设置新内容
        			StaTable.fireTableStructureChanged();
        			String n1 = OrdSQL.count("Cid",Seh).get(0).toString();//SQL方法返回的向量转换成字符型
        			String num1 = n1.substring(1,n1.length()-1);//去掉字符串前后的方括号
        			String t1 = OrdSQL.total("Cid",Seh).get(0).toString();//SQL方法返回的向量转换成字符型
        			String tot1 = t1.substring(1,t1.length()-1);//去掉字符串前后的方括号
        			OrdN.setText(num1);
        			TotN.setText(tot1);
        			break;
				case "客户名称":
					Vector<?> StaRow2 = OrdSQL.search("Cli","Cnam",Seh);
					StaTable.setDataVector(StaRow2,OrdColumn);//设置新内容
        			StaTable.fireTableStructureChanged();
        			String n2 = OrdSQL.count("Cid",Seh).get(0).toString();//SQL方法返回的向量转换成字符型
        			String num2 = n2.substring(1,n2.length()-1);//去掉字符串前后的方括号
        			String t2 = OrdSQL.total("Cid",Seh).get(0).toString();//SQL方法返回的向量转换成字符型
        			String tot2 = t2.substring(1,t2.length()-1);//去掉字符串前后的方括号
        			OrdN.setText(num2);
        			TotN.setText(tot2);
        			break;
				case "联系人":
					Vector<?> StaRow3 = OrdSQL.search("Cli","Cpeo",Seh);
					StaTable.setDataVector(StaRow3,OrdColumn);//设置新内容
        			StaTable.fireTableStructureChanged();
        			String n3 = OrdSQL.count("Cid",Seh).get(0).toString();//SQL方法返回的向量转换成字符型
        			String num3 = n3.substring(1,n3.length()-1);//去掉字符串前后的方括号
        			String t3 = OrdSQL.total("Cid",Seh).get(0).toString();//SQL方法返回的向量转换成字符型
        			String tot3 = t3.substring(1,t3.length()-1);//去掉字符串前后的方括号
        			OrdN.setText(num3);
        			TotN.setText(tot3);
        			break;
				case "商品编号":
					Vector<?> StaRow4 = OrdSQL.search("Prd","Pid",Seh);
					StaTable.setDataVector(StaRow4,OrdColumn);//设置新内容
        			StaTable.fireTableStructureChanged();
        			String n4 = OrdSQL.count("Cid",Seh).get(0).toString();//SQL方法返回的向量转换成字符型
        			String num4 = n4.substring(1,n4.length()-1);//去掉字符串前后的方括号
        			String t4 = OrdSQL.total("Cid",Seh).get(0).toString();//SQL方法返回的向量转换成字符型
        			String tot4 = t4.substring(1,t4.length()-1);//去掉字符串前后的方括号
        			OrdN.setText(num4);
        			TotN.setText(tot4);
        			break;
				case "名称":
					Vector<?> StaRow5 = OrdSQL.search("Prd","Pnam",Seh);
					StaTable.setDataVector(StaRow5,OrdColumn);//设置新内容
        			StaTable.fireTableStructureChanged();
        			String n5 = OrdSQL.count("Cid",Seh).get(0).toString();//SQL方法返回的向量转换成字符型
        			String num5 = n5.substring(1,n5.length()-1);//去掉字符串前后的方括号
        			String t5 = OrdSQL.total("Cid",Seh).get(0).toString();//SQL方法返回的向量转换成字符型
        			String tot5 = t5.substring(1,t5.length()-1);//去掉字符串前后的方括号
        			OrdN.setText(num5);
        			TotN.setText(tot5);
        			break;
				case "类别":
					Vector<?> StaRow6 = OrdSQL.search("Prd","Ptyp",Seh);
					StaTable.setDataVector(StaRow6,OrdColumn);//设置新内容
        			StaTable.fireTableStructureChanged();
        			String n6 = OrdSQL.count("Cid",Seh).get(0).toString();//SQL方法返回的向量转换成字符型
        			String num6 = n6.substring(1,n6.length()-1);//去掉字符串前后的方括号
        			String t6 = OrdSQL.total("Cid",Seh).get(0).toString();//SQL方法返回的向量转换成字符型
        			String tot6 = t6.substring(1,t6.length()-1);//去掉字符串前后的方括号
        			OrdN.setText(num6);
        			TotN.setText(tot6);
        			break;
				case "产地":
					Vector<?> StaRow7 = OrdSQL.search("Prd","Pbir",Seh);
					StaTable.setDataVector(StaRow7,OrdColumn);//设置新内容
        			StaTable.fireTableStructureChanged();
        			String n7 = OrdSQL.count("Cid",Seh).get(0).toString();//SQL方法返回的向量转换成字符型
        			String num7 = n7.substring(1,n7.length()-1);//去掉字符串前后的方括号
        			String t7 = OrdSQL.total("Cid",Seh).get(0).toString();//SQL方法返回的向量转换成字符型
        			String tot7 = t7.substring(1,t7.length()-1);//去掉字符串前后的方括号
        			OrdN.setText(num7);
        			TotN.setText(tot7);
        			break;
				case "制造商":
					Vector<?> StaRow8 = OrdSQL.search("Prd","Ppro",Seh);
					StaTable.setDataVector(StaRow8,OrdColumn);//设置新内容
        			StaTable.fireTableStructureChanged();
        			String n8 = OrdSQL.count("Cid",Seh).get(0).toString();//SQL方法返回的向量转换成字符型
        			String num8 = n8.substring(1,n8.length()-1);//去掉字符串前后的方括号
        			String t8 = OrdSQL.total("Cid",Seh).get(0).toString();//SQL方法返回的向量转换成字符型
        			String tot8 = t8.substring(1,t8.length()-1);//去掉字符串前后的方括号
        			OrdN.setText(num8);
        			TotN.setText(tot8);
        			break;
				}
			}
		});
		
		//窗口激活监听器：在每次更改之后都对表个进行刷新显示
		addWindowListener(new WindowAdapter(){
				public void windowActivated(WindowEvent e){
					System.out.println("聚焦");
					Vector<?> CliRow = CliSQL.getRows(); 
					Vector<?> OrdRow = OrdSQL.getRows(); 
					Vector<?> InvRow = InvSQL.getRows(); 
					Vector<?> PrdRow = PrdSQL.getRows(); 
        			CliTable.setDataVector(CliRow,CliColumn);//设置新内容
        			OrdTable.setDataVector(OrdRow,OrdColumn);
        			InvTable.setDataVector(InvRow,InvColumn);
        			PrdTable.setDataVector(PrdRow,PrdColumn);
        			CliTable.fireTableStructureChanged();
        			OrdTable.fireTableStructureChanged();
        			InvTable.fireTableStructureChanged();
        			PrdTable.fireTableStructureChanged();
        			
        			
			    }
		});
		
	}
	
	/*
	 * 
	 * */
	public void setIcon(String file, JButton com) {
		ImageIcon ico=new ImageIcon(file);  
		Image temp=ico.getImage().getScaledInstance(com.getWidth(),com.getHeight(),ico.getImage().SCALE_DEFAULT);  
		ico=new ImageIcon(temp);  
		com.setIcon(ico); // TODO 自动生成的方法存根
	}
}
