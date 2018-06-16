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
	 * Launch the application.��ʱ��Ϊ������
	 
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
	 * Create the frame.����������
	 */
	public MainFrame(String usr,String level) {
		String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (ClassNotFoundException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}		
		
		setUndecorated(true);//�ޱ߿�
		setVisible(true);
		setSize(1000,600);
		setLocationRelativeTo(null);
		setFocusable(true);
		//setResizable(false);
		MainPane = new JPanel();
		MainPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(MainPane);
		MainPane.setLayout(null);
				
		// ȡ�����ݿ�Ŀͻ���Ϣ��ĸ�������  
        Vector<?> CliRow = CliSQL.getRows(); 
        Vector<?> OrdRow = OrdSQL.getRows(); 
        Vector<?> InvRow = InvSQL.getRows(); 
        Vector<?> PrdRow = PrdSQL.getRows();  
        // ȡ�����ݿ�Ŀͻ���Ϣ��ı�ͷ����  
        Vector<Object> CliColumn = new Vector<Object>();
        CliColumn.add("�ͻ����");
        CliColumn.add("�ͻ�����");
        CliColumn.add("��ַ");
        CliColumn.add("��ϵ��");
        CliColumn.add("�绰");
        CliColumn.add("����");
        CliColumn.add("��ע");
        Vector<Object> OrdColumn = new Vector<Object>();
        OrdColumn.add("�������");
        OrdColumn.add("��Ʒ���");
        OrdColumn.add("�ͻ����");
        OrdColumn.add("����");
        OrdColumn.add("˰���ܼ�");
        OrdColumn.add("����״̬");
        OrdColumn.add("����ʱ��");
        OrdColumn.add("��ע");
        Vector<Object> InvColumn = new Vector<Object>();
        InvColumn.add("��Ʊ���");
        InvColumn.add("�������");
        InvColumn.add("�ͻ����");
        InvColumn.add("˰��");
        InvColumn.add("˰��");
        InvColumn.add("˰���ܼ�");
        InvColumn.add("��Ʊ��");
        InvColumn.add("��Ʊ����");
        InvColumn.add("��ע");
        Vector<Object> PrdColumn = new Vector<Object>();
        PrdColumn.add("��Ʒ���");
        PrdColumn.add("��Ʒ����");
        PrdColumn.add("��λ");
        PrdColumn.add("����");
        PrdColumn.add("����");
        PrdColumn.add("���");
        PrdColumn.add("����");
        PrdColumn.add("������");
        PrdColumn.add("��ע");
        
        DefaultTableModel CliTable = new DefaultTableModel(CliRow,CliColumn);
        DefaultTableModel OrdTable = new DefaultTableModel(OrdRow,OrdColumn);
        DefaultTableModel InvTable = new DefaultTableModel(InvRow,InvColumn);
        DefaultTableModel PrdTable = new DefaultTableModel(PrdRow,PrdColumn);
        DefaultTableModel StaTable = new DefaultTableModel();
		ImageIcon black = new ImageIcon(MainFrame.class.getResource("��ɫ����.png")); 
		
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
		WelLab.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		WelLab.setBounds(838, 17, 60, 20);
		panel.add(WelLab);
		
		String[] Clis = {"�ͻ����","�ͻ�����","��ϵ��"};
 		JComboBox SehCBox = new JComboBox(Clis);
 		SehCBox.setForeground(Color.BLACK);
 		SehCBox.setFont(new Font("΢���ź�", Font.PLAIN, 14));
 		SehCBox.setBackground(Color.WHITE);
 		SehCBox.setBorder(null);
		SehCBox.setBounds(143, 16, 84, 23);
		panel.add(SehCBox);
		//���������Ͻǵ�LOGOͼƬ

		SehT = new JTextField();
		SehT.addFocusListener((new JTextFieldHintListener(SehT, "�س�����������")));
		SehT.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		SehT.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		
		//������س�ȷ�ϼ�����
		
		SehT.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyChar() == '\n') {
					if(SehCBox.getItemAt(0)=="�ͻ����" ) {
						String Opt = (String)SehCBox.getSelectedItem();
						String Seh = SehT.getText();
						Vector<?> CliRow = CliSQL.search(Opt,Seh);
						if (CliRow.isEmpty())
							JOptionPane.showMessageDialog(null, "�����޽������������ؼ����Ƿ�����", "����",JOptionPane.ERROR_MESSAGE);
						CliTable.setDataVector(CliRow,CliColumn);//����������
	        			CliTable.fireTableStructureChanged();
					}else if(SehCBox.getItemAt(0)=="�������") {
						String Opt = (String)SehCBox.getSelectedItem();
						String Seh = SehT.getText();
						Vector<?> OrdRow = OrdSQL.search(Opt,Seh);
						if (OrdRow.isEmpty())
							JOptionPane.showMessageDialog(null, "�����޽������������ؼ����Ƿ�����", "����",JOptionPane.ERROR_MESSAGE);
						OrdTable.setDataVector(OrdRow,OrdColumn);//����������
	        			OrdTable.fireTableStructureChanged();
					}else if(SehCBox.getItemAt(0)=="��Ʊ���") {
						String Opt = (String)SehCBox.getSelectedItem();
						String Seh = SehT.getText();
						Vector<?> InvRow = InvSQL.search(Opt,Seh);
						if (InvRow.isEmpty())
							JOptionPane.showMessageDialog(null, "�����޽������������ؼ����Ƿ�����", "����",JOptionPane.ERROR_MESSAGE);
						InvTable.setDataVector(InvRow,InvColumn);//����������
	        			InvTable.fireTableStructureChanged();
					}else if(SehCBox.getItemAt(0)=="��Ʒ���") {
						String Opt = (String)SehCBox.getSelectedItem();
						String Seh = SehT.getText();						
						Vector<?> PrdRow = PrdSQL.search(Opt,Seh);
						if (PrdRow.isEmpty())
							JOptionPane.showMessageDialog(null, "�����޽������������ؼ����Ƿ�����", "����",JOptionPane.ERROR_MESSAGE);
						PrdTable.setDataVector(PrdRow,PrdColumn);//����������
	        			PrdTable.fireTableStructureChanged();//�ǵø�����������ť�ļ�����
					}
				}
			}
		});
		SehT.setBounds(237, 18, 169, 20);
		panel.add(SehT);
		SehT.setColumns(10);
		
		//�������ذ�ť
		
		JButton BkBtn = new JButton("\u8FD4\u56DE");
		BkBtn.setBorder(new LineBorder(new Color(0, 153, 255), 2, true));
		BkBtn.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		BkBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(SehCBox.getItemAt(0)=="�ͻ����" ) {
					CliTable.setDataVector(CliRow,CliColumn);//����������
        			CliTable.fireTableStructureChanged();
				}else if(SehCBox.getItemAt(0)=="�������") {
					OrdTable.setDataVector(OrdRow,OrdColumn);//����������
        			OrdTable.fireTableStructureChanged();
				}else if(SehCBox.getItemAt(0)=="��Ʊ���") {
					InvTable.setDataVector(InvRow,InvColumn);//����������
        			InvTable.fireTableStructureChanged();
				}else if(SehCBox.getItemAt(0)=="��Ʒ���") {
					PrdTable.setDataVector(PrdRow,PrdColumn);//����������
				}
			}
		});
		BkBtn.setBounds(427, 14, 61, 27);
		panel.add(BkBtn);
		
		JLabel Usr = new JLabel(usr);
		Usr.setFont(new Font("΢���ź�", Font.PLAIN, 15));
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
		InvBtn.setFont(new Font("΢���ź�", Font.PLAIN, 20));
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
		PrdBtn.setFont(new Font("΢���ź�", Font.PLAIN, 20));
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
		StaBtn.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		StaBtn.setBackground(new Color(0, 153, 255));
		ImageIcon S = new ImageIcon(MainFrame.class.getResource("S.png"));
		Image img5 = S.getImage();  
		img5 = img5.getScaledInstance(93, 93, Image.SCALE_DEFAULT);  
		S.setImage(img5);  
		StaBtn.setIcon(S);
		MenuPan.add(StaBtn);
		
				
		//�˳���ť�Լ���Ӧ������
		JButton ExiBtn = new JButton("");
		ExiBtn.setBorder(null);
		ExiBtn.setBounds(0, 455, 93, 91);
		ExiBtn.setBackground(new Color(0, 153, 255));
		ExiBtn.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		ExiBtn.setForeground(Color.WHITE);
		ImageIcon E = new ImageIcon(MainFrame.class.getResource("E.png"));
		Image img6 = E.getImage();  
		img6 = img6.getScaledInstance(93, 93, Image.SCALE_DEFAULT);  
		E.setImage(img6);  
		ExiBtn.setIcon(E);
		ExiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int res=JOptionPane.showConfirmDialog(null, "ȷ���˳�����ϵͳ��", "ȷ���˳�", JOptionPane.YES_NO_OPTION);
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
		//����ѡ����л�
		CliBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SehT.setVisible(true);
				SehCBox.setVisible(true);
				SehLab.setVisible(true);
				BkBtn.setVisible(true);
				SehCBox.removeAllItems();
				card.show(CardPan,"�ͻ�");
				SehCBox.addItem("�ͻ����");
				SehCBox.addItem("�ͻ�����");
				SehCBox.addItem("��ϵ��");
			}
		});
		OrdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SehT.setVisible(true);
				SehCBox.setVisible(true);
				SehLab.setVisible(true);
				BkBtn.setVisible(true);
				SehCBox.removeAllItems();
				card.show(CardPan,"����");  
				SehCBox.addItem("�������");
				SehCBox.addItem("��Ʒ���");
				SehCBox.addItem("�ͻ����");
				SehCBox.addItem("״̬");
				SehCBox.addItem("����ʱ��");
			}
		});
		InvBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SehT.setVisible(true);
				SehCBox.setVisible(true);
				SehLab.setVisible(true);
				BkBtn.setVisible(true);
				SehCBox.removeAllItems();
				card.show(CardPan,"��Ʊ"); 
				SehCBox.addItem("��Ʊ���");
				SehCBox.addItem("�������");
				SehCBox.addItem("�ͻ����");
				SehCBox.addItem("��Ʊ��");
				SehCBox.addItem("��Ʊ����");
			}
		});
		PrdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SehT.setVisible(true);
				SehCBox.setVisible(true);
				SehLab.setVisible(true);
				BkBtn.setVisible(true);
				SehCBox.removeAllItems();
				card.show(CardPan,"����");  
				SehCBox.addItem("��Ʒ���");
				SehCBox.addItem("����");
				SehCBox.addItem("���");
				SehCBox.addItem("����");
				SehCBox.addItem("������");
			}
		});
		StaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SehT.setVisible(false);
				SehCBox.setVisible(false);
				SehLab.setVisible(false);
				BkBtn.setVisible(false);
				SehCBox.setVisible(false);
				card.show(CardPan,"ͳ��");
			}
		});

		
		JPanel CliPan = new JPanel();
		CardPan.add(CliPan, "�ͻ�");
		CliPan.setLayout(null);
		
		//ɾ���ͻ���Ϣ
		
		JButton DCBtn = new JButton("\u5220\u9664\u5BA2\u6237");
		DCBtn.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		DCBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (level.equals("[����Ա]")) {
					int row = CliTab.getSelectedRow();
	        		if (row==-1)
	        			JOptionPane.showMessageDialog(null, "��ѡ����Ҫɾ���Ŀͻ�", "����",JOptionPane.ERROR_MESSAGE);
	            	else {
						Object Cid = CliTab.getValueAt(row, 0);
						String Cidd = (String)Cid;
	            		int res=JOptionPane.showConfirmDialog(null, "ȷ��ɾ��ѡ�пͻ���", "ȷ��ɾ��", JOptionPane.YES_NO_OPTION);
	    				if(res==JOptionPane.YES_OPTION) {
	    					System.out.println("ִ��ɾ������"); 
	    					CliSQL.del(Cidd);
	    					Vector<?> CliRow = CliSQL.getRows(); 
	    					CliTable.setDataVector(CliRow,CliColumn);//����������
	    					CliTable.fireTableStructureChanged();
	    				}
	    				else
	    					return; 
	        		}
				}
				else
					JOptionPane.showMessageDialog(null, "����Ȩ����Ϣ�����޸�", "����",JOptionPane.ERROR_MESSAGE);	
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
		
		//��ӿͻ���Ϣ
		
		JButton ACBtn = new JButton("\u6DFB\u52A0\u5BA2\u6237");
		ACBtn.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		ACBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (level.equals("[����Ա]")) {
					CEditFrame a = new CEditFrame("add",null, null, null, null, null, null, null);
					a.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
					DarkLab.setVisible(true);
					a.setVisible(true);
					DarkLab.setVisible(false);
				}
				else
					JOptionPane.showMessageDialog(null, "����Ȩ����Ϣ�����޸�", "����",JOptionPane.ERROR_MESSAGE);	
			}
		});
		ACBtn.setBounds(664, 28, 96, 27);
		CliPan.add(ACBtn);
		
		//�޸Ŀͻ���Ϣ
		
		JButton ECBtn = new JButton("\u7F16\u8F91\u5BA2\u6237");
		ECBtn.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		ECBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = CliTab.getSelectedRow();
				if (level.equals("[����Ա]")) {
					if (row==-1)
	        			JOptionPane.showMessageDialog(null, "��ѡ����Ҫ�༭�Ŀͻ�", "����",JOptionPane.ERROR_MESSAGE);
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
					JOptionPane.showMessageDialog(null, "����Ȩ����Ϣ�����޸�", "����",JOptionPane.ERROR_MESSAGE);	
			}
		});
		ECBtn.setBounds(556, 28, 98, 27);
		CliPan.add(ECBtn);
		
		JLabel CliLab = new JLabel("         \u5BA2\u6237\u4FE1\u606F");
		CliLab.setFont(new Font("΢���ź�", Font.PLAIN, 20));
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
			 * ��������༭
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column)
		    {
		               return false;}
		    };
		CliTab.setBorder(null);
		CliTab.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		CliTab.setBackground(Color.WHITE);
		CliSPan.setViewportView(CliTab);
		
		JPanel OrdPan = new JPanel();
		CardPan.add(OrdPan, "����");
		OrdPan.setLayout(null);
		
		//������Ӱ�ť
		
		JButton AOBtn = new JButton("\u6DFB\u52A0\u8BA2\u5355");
		AOBtn.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		AOBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (level.equals("[����Ա]")) {
					OEditFrame a = new OEditFrame("add",null, null, null, null, null, null, null, null);
					a.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
					DarkLab.setVisible(true);
					a.setVisible(true);
					DarkLab.setVisible(false);
				}
				else
					JOptionPane.showMessageDialog(null, "����Ȩ����Ϣ�����޸�", "����",JOptionPane.ERROR_MESSAGE);	
			}
		});
		AOBtn.setBounds(678, 28, 93, 27);
		OrdPan.add(AOBtn);
		
		//����ɾ����ť
		
		JButton DOBtn = new JButton("\u5220\u9664\u8BA2\u5355");
		DOBtn.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		DOBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (level.equals("[����Ա]")) {
					int row = OrdTab.getSelectedRow();
	        		if (row==-1)
	        			JOptionPane.showMessageDialog(null, "��ѡ����Ҫɾ���Ķ���", "����",JOptionPane.ERROR_MESSAGE);
	            	else {
	            		int res=JOptionPane.showConfirmDialog(null, "ȷ��ɾ��ѡ�ж�����", "ȷ��ɾ��", JOptionPane.YES_NO_OPTION);
	    				if(res==JOptionPane.YES_OPTION) {
							Object Oid = OrdTab.getValueAt(row, 0);
							String Oidd = (String)Oid;
	    					System.out.println("ִ��ɾ������"); 
	            			OrdSQL.del(Oidd);
	            			Vector<?> OrdRow = OrdSQL.getRows(); 
	            	    	OrdTable.setDataVector(OrdRow,OrdColumn);//����������
	            			OrdTable.fireTableStructureChanged();
	    				}
	    				else
	    					return;
	        			
	        		}
				}
				else
					JOptionPane.showMessageDialog(null, "����Ȩ����Ϣ�����޸�", "����",JOptionPane.ERROR_MESSAGE);	
			}
		});
		DOBtn.setBounds(779, 28, 95, 27);
		OrdPan.add(DOBtn);
		
		//�����޸İ�ť
		
		JButton EOBtn = new JButton("\u7F16\u8F91\u8BA2\u5355");
		EOBtn.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		EOBtn.setBackground(new Color(240, 240, 240));
		EOBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (level.equals("[����Ա]")) {
					int row = OrdTab.getSelectedRow();
					if (row==-1)
	        			JOptionPane.showMessageDialog(null, "��ѡ����Ҫ�༭�Ķ���", "����",JOptionPane.ERROR_MESSAGE);
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
					JOptionPane.showMessageDialog(null, "����Ȩ����Ϣ�����޸�", "����",JOptionPane.ERROR_MESSAGE);	
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
		OrdLab.setFont(new Font("΢���ź�", Font.PLAIN, 20));
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
			 * ��������༭
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column)
		    {
		               return false;}
		    };
		OrdSPan.setViewportView(OrdTab);
		
		JPanel InvPan = new JPanel();
		CardPan.add(InvPan, "��Ʊ");
		InvPan.setLayout(null);
		
		//��ӷ�Ʊ��ť
		
		JButton AIBtn = new JButton("\u6DFB\u52A0\u53D1\u7968");
		AIBtn.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		AIBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (level.equals("[����Ա]")) {
					IEditFrame a = new IEditFrame("add",null, null, null, null, null, null, null, null, null);
					a.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
					DarkLab.setVisible(true);
					a.setVisible(true);
					DarkLab.setVisible(false);
				}
				else
					JOptionPane.showMessageDialog(null, "����Ȩ����Ϣ�����޸�", "����",JOptionPane.ERROR_MESSAGE);	
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
		
		//��Ʊɾ������
		
		JButton DIBtn = new JButton("\u5220\u9664\u53D1\u7968");
		DIBtn.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		DIBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (level.equals("[����Ա]")) {
					int row = InvTab.getSelectedRow();
	        		if (row==-1)
	        			JOptionPane.showMessageDialog(null, "��ѡ����Ҫɾ���ķ�Ʊ", "����",JOptionPane.ERROR_MESSAGE);
	            	else {
						Object Iid = InvTab.getValueAt(row, 0);
						String Iidd = (String)Iid;
	            		int res=JOptionPane.showConfirmDialog(null, "ȷ��ɾ��ѡ�з�Ʊ��", "ȷ��ɾ��", JOptionPane.YES_NO_OPTION);
	    				if(res==JOptionPane.YES_OPTION) {
	    					System.out.println("ִ�з�Ʊɾ������"); 
	    					InvSQL.del(Iidd);
	    					Vector<?> InvRow = InvSQL.getRows(); 
	    					InvTable.setDataVector(InvRow,InvColumn);//����������
	    					InvTable.fireTableStructureChanged();
	    				}
	    				else
	    					return;
	        		}
				}
				else
					JOptionPane.showMessageDialog(null, "����Ȩ����Ϣ�����޸�", "����",JOptionPane.ERROR_MESSAGE);	
			}
		});
		DIBtn.setBounds(778, 28, 93, 27);
		InvPan.add(DIBtn);
		
		//�༭��Ʊ��Ϣ
		
		JButton EIBtn = new JButton("\u7F16\u8F91\u53D1\u7968");
		EIBtn.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		EIBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (level.equals("[����Ա]")) {
					int row = InvTab.getSelectedRow();
					if (row==-1)
	        			JOptionPane.showMessageDialog(null, "��ѡ����Ҫ�༭�ķ�Ʊ", "����",JOptionPane.ERROR_MESSAGE);
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
					JOptionPane.showMessageDialog(null, "����Ȩ����Ϣ�����޸�", "����",JOptionPane.ERROR_MESSAGE);	
			}
		});
		EIBtn.setBounds(572, 28, 93, 27);
		InvPan.add(EIBtn);
		
		JLabel label_1 = new JLabel("         \u53D1\u7968\u4FE1\u606F");
		label_1.setFont(new Font("΢���ź�", Font.PLAIN, 20));
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
		CardPan.add(PrdPan, "����");
		PrdPan.setLayout(null);
		
		//�����Ʒ
		
		JButton APBtn = new JButton("\u6DFB\u52A0\u5546\u54C1");
		APBtn.setFont(new Font("����", Font.PLAIN, 14));
		APBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (level.equals("[����Ա]")) {
					PEditFrame a = new PEditFrame("add",null, null, null, null, null, null, null, null, null);
					a.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
					DarkLab.setVisible(true);
					a.setVisible(true);
					DarkLab.setVisible(false);
				}
				else
					JOptionPane.showMessageDialog(null, "����Ȩ����Ϣ�����޸�", "����",JOptionPane.ERROR_MESSAGE);	
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
		DPBtn.setFont(new Font("����", Font.PLAIN, 14));
		DPBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (level.equals("[����Ա]")) {
					int row = PrdTab.getSelectedRow();
	        		if (row==-1)
	        			JOptionPane.showMessageDialog(null, "��ѡ����Ҫɾ������Ʒ", "����",JOptionPane.ERROR_MESSAGE);
	            	else {
						Object Pid = PrdTab.getValueAt(row, 0);
						String Pidd = (String)Pid;
	            		int res=JOptionPane.showConfirmDialog(null, "ȷ��ɾ��ѡ����Ʒ��", "ȷ��ɾ��", JOptionPane.YES_NO_OPTION);
	    				if(res==JOptionPane.YES_OPTION) {
	    					System.out.println("ִ��ɾ������"); 
	    					PrdSQL.del(Pidd);
	    					Vector<?> PrdRow = PrdSQL.getRows(); 
	    					PrdTable.setDataVector(PrdRow,PrdColumn);//����������
	    					PrdTable.fireTableStructureChanged();
	    				}
	    				else
	    					return;
	        		}
				}
				else
					JOptionPane.showMessageDialog(null, "����Ȩ����Ϣ�����޸�", "����",JOptionPane.ERROR_MESSAGE);	
			}
		});
		DPBtn.setBounds(778, 33, 93, 25);
		PrdPan.add(DPBtn);
		
		//��Ʒ��Ϣ�༭
		
		JButton EPBtn = new JButton("\u7F16\u8F91\u5546\u54C1");
		EPBtn.setFont(new Font("����", Font.PLAIN, 14));
		EPBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (level.equals("[����Ա]")) {
					int row = PrdTab.getSelectedRow();
					if (row==-1)
	        			JOptionPane.showMessageDialog(null, "��ѡ����Ҫ�༭����Ʒ", "����",JOptionPane.ERROR_MESSAGE);
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
					JOptionPane.showMessageDialog(null, "����Ȩ����Ϣ�����޸�", "����",JOptionPane.ERROR_MESSAGE);	
			}
		});
		EPBtn.setBounds(575, 33, 93, 25);
		PrdPan.add(EPBtn);
		
		JLabel label_2 = new JLabel("         \u5546\u54C1\u4FE1\u606F");
		label_2.setFont(new Font("΢���ź�", Font.PLAIN, 20));
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
		CardPan.add(StaPan, "ͳ��");
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
		label.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		label.setOpaque(true);
		label.setForeground(Color.BLACK);
		label.setBackground(Color.WHITE);
		label.setBounds(20, 122, 868, 45);
		StaPan.add(label);
		
		JLabel label_3 = new JLabel("         \u8BA2\u5355\u67E5\u8BE2");
		label_3.setFont(new Font("΢���ź�", Font.PLAIN, 20));
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
		SSehT.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		SSehT.setColumns(10);
		SSehT.setBounds(213, 10, 200, 25);
		SehPan.add(SSehT);
		
		JButton SSehBtn = new JButton("\u641C\u7D22");
		SSehBtn.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		SSehBtn.setBounds(423, 9, 70, 27);
		SehPan.add(SSehBtn);
		
		String[] Opt= {"�ͻ�","��Ʒ"};
		JComboBox<Object> Opt1CBox = new JComboBox<Object>(Opt);
		Opt1CBox.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		Opt1CBox.setBounds(35, 10, 58, 25);
		SehPan.add(Opt1CBox);
		
		String[] Opt2= {"�ͻ����","�ͻ�����","��ϵ��"};
		JComboBox<String> Opt2Box = new JComboBox(Opt2);
		Opt2Box.setFont(new Font("΢���ź�", Font.PLAIN, 14));
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
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		
		JLabel OrdN = new JLabel("            ");
		OrdN.setBounds(128, 6, 60, 22);
		ConPan.add(OrdN);
		OrdN.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1 = new JLabel("\u603B\u4EF7");
		lblNewLabel_1.setBounds(366, 6, 32, 22);
		ConPan.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		
		JLabel TotN = new JLabel("             ");
		TotN.setBounds(416, 6, 65, 22);
		ConPan.add(TotN);
		TotN.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		
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
		 * ��������༭
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
				if (Opt1CBox.getSelectedItem()=="�ͻ�") {
					Opt2Box.removeAllItems();
					Opt2Box.addItem("�ͻ����");
					Opt2Box.addItem("�ͻ�����");
					Opt2Box.addItem("��ϵ��");
				}
				else if(Opt1CBox.getSelectedItem()=="��Ʒ"){
					Opt2Box.removeAllItems();
					Opt2Box.addItem("��Ʒ���");
					Opt2Box.addItem("����");
					Opt2Box.addItem("���");
					Opt2Box.addItem("����");
					Opt2Box.addItem("������");
				}
			}
		});

		SSehBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n = (String) Opt2Box.getSelectedItem();
				String Seh = SSehT.getText();
				switch(n){
				case "�ͻ����":
					Vector<?> StaRow1 = OrdSQL.search("Cli","Cid",Seh);
					StaTable.setDataVector(StaRow1,OrdColumn);//����������
        			StaTable.fireTableStructureChanged();
        			String n1 = OrdSQL.count("Cid",Seh).get(0).toString();//SQL�������ص�����ת�����ַ���
        			String num1 = n1.substring(1,n1.length()-1);//ȥ���ַ���ǰ��ķ�����
        			String t1 = OrdSQL.total("Cid",Seh).get(0).toString();//SQL�������ص�����ת�����ַ���
        			String tot1 = t1.substring(1,t1.length()-1);//ȥ���ַ���ǰ��ķ�����
        			OrdN.setText(num1);
        			TotN.setText(tot1);
        			break;
				case "�ͻ�����":
					Vector<?> StaRow2 = OrdSQL.search("Cli","Cnam",Seh);
					StaTable.setDataVector(StaRow2,OrdColumn);//����������
        			StaTable.fireTableStructureChanged();
        			String n2 = OrdSQL.count("Cid",Seh).get(0).toString();//SQL�������ص�����ת�����ַ���
        			String num2 = n2.substring(1,n2.length()-1);//ȥ���ַ���ǰ��ķ�����
        			String t2 = OrdSQL.total("Cid",Seh).get(0).toString();//SQL�������ص�����ת�����ַ���
        			String tot2 = t2.substring(1,t2.length()-1);//ȥ���ַ���ǰ��ķ�����
        			OrdN.setText(num2);
        			TotN.setText(tot2);
        			break;
				case "��ϵ��":
					Vector<?> StaRow3 = OrdSQL.search("Cli","Cpeo",Seh);
					StaTable.setDataVector(StaRow3,OrdColumn);//����������
        			StaTable.fireTableStructureChanged();
        			String n3 = OrdSQL.count("Cid",Seh).get(0).toString();//SQL�������ص�����ת�����ַ���
        			String num3 = n3.substring(1,n3.length()-1);//ȥ���ַ���ǰ��ķ�����
        			String t3 = OrdSQL.total("Cid",Seh).get(0).toString();//SQL�������ص�����ת�����ַ���
        			String tot3 = t3.substring(1,t3.length()-1);//ȥ���ַ���ǰ��ķ�����
        			OrdN.setText(num3);
        			TotN.setText(tot3);
        			break;
				case "��Ʒ���":
					Vector<?> StaRow4 = OrdSQL.search("Prd","Pid",Seh);
					StaTable.setDataVector(StaRow4,OrdColumn);//����������
        			StaTable.fireTableStructureChanged();
        			String n4 = OrdSQL.count("Cid",Seh).get(0).toString();//SQL�������ص�����ת�����ַ���
        			String num4 = n4.substring(1,n4.length()-1);//ȥ���ַ���ǰ��ķ�����
        			String t4 = OrdSQL.total("Cid",Seh).get(0).toString();//SQL�������ص�����ת�����ַ���
        			String tot4 = t4.substring(1,t4.length()-1);//ȥ���ַ���ǰ��ķ�����
        			OrdN.setText(num4);
        			TotN.setText(tot4);
        			break;
				case "����":
					Vector<?> StaRow5 = OrdSQL.search("Prd","Pnam",Seh);
					StaTable.setDataVector(StaRow5,OrdColumn);//����������
        			StaTable.fireTableStructureChanged();
        			String n5 = OrdSQL.count("Cid",Seh).get(0).toString();//SQL�������ص�����ת�����ַ���
        			String num5 = n5.substring(1,n5.length()-1);//ȥ���ַ���ǰ��ķ�����
        			String t5 = OrdSQL.total("Cid",Seh).get(0).toString();//SQL�������ص�����ת�����ַ���
        			String tot5 = t5.substring(1,t5.length()-1);//ȥ���ַ���ǰ��ķ�����
        			OrdN.setText(num5);
        			TotN.setText(tot5);
        			break;
				case "���":
					Vector<?> StaRow6 = OrdSQL.search("Prd","Ptyp",Seh);
					StaTable.setDataVector(StaRow6,OrdColumn);//����������
        			StaTable.fireTableStructureChanged();
        			String n6 = OrdSQL.count("Cid",Seh).get(0).toString();//SQL�������ص�����ת�����ַ���
        			String num6 = n6.substring(1,n6.length()-1);//ȥ���ַ���ǰ��ķ�����
        			String t6 = OrdSQL.total("Cid",Seh).get(0).toString();//SQL�������ص�����ת�����ַ���
        			String tot6 = t6.substring(1,t6.length()-1);//ȥ���ַ���ǰ��ķ�����
        			OrdN.setText(num6);
        			TotN.setText(tot6);
        			break;
				case "����":
					Vector<?> StaRow7 = OrdSQL.search("Prd","Pbir",Seh);
					StaTable.setDataVector(StaRow7,OrdColumn);//����������
        			StaTable.fireTableStructureChanged();
        			String n7 = OrdSQL.count("Cid",Seh).get(0).toString();//SQL�������ص�����ת�����ַ���
        			String num7 = n7.substring(1,n7.length()-1);//ȥ���ַ���ǰ��ķ�����
        			String t7 = OrdSQL.total("Cid",Seh).get(0).toString();//SQL�������ص�����ת�����ַ���
        			String tot7 = t7.substring(1,t7.length()-1);//ȥ���ַ���ǰ��ķ�����
        			OrdN.setText(num7);
        			TotN.setText(tot7);
        			break;
				case "������":
					Vector<?> StaRow8 = OrdSQL.search("Prd","Ppro",Seh);
					StaTable.setDataVector(StaRow8,OrdColumn);//����������
        			StaTable.fireTableStructureChanged();
        			String n8 = OrdSQL.count("Cid",Seh).get(0).toString();//SQL�������ص�����ת�����ַ���
        			String num8 = n8.substring(1,n8.length()-1);//ȥ���ַ���ǰ��ķ�����
        			String t8 = OrdSQL.total("Cid",Seh).get(0).toString();//SQL�������ص�����ת�����ַ���
        			String tot8 = t8.substring(1,t8.length()-1);//ȥ���ַ���ǰ��ķ�����
        			OrdN.setText(num8);
        			TotN.setText(tot8);
        			break;
				}
			}
		});
		
		//���ڼ������������ÿ�θ���֮�󶼶Ա������ˢ����ʾ
		addWindowListener(new WindowAdapter(){
				public void windowActivated(WindowEvent e){
					System.out.println("�۽�");
					Vector<?> CliRow = CliSQL.getRows(); 
					Vector<?> OrdRow = OrdSQL.getRows(); 
					Vector<?> InvRow = InvSQL.getRows(); 
					Vector<?> PrdRow = PrdSQL.getRows(); 
        			CliTable.setDataVector(CliRow,CliColumn);//����������
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
		com.setIcon(ico); // TODO �Զ����ɵķ������
	}
}
