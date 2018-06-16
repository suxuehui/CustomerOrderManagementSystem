package login;

import java.awt.EventQueue;
import com.sun.awt.AWTUtilities;

import javax.swing.JFrame;
import javax.swing.JPanel;
import main.MainFrame;
import recreate.JTextFieldHintListener;
import recreate.RButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Label;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.ImageIcon;

@SuppressWarnings("restriction")
public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel LoginPane;
	private JTextField UsrTf;
	private JPasswordField PwdTf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.setProperty("sun.java2d.noddraw", "true");//解决中文输入法白屏问题
					//org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.登陆窗体
	 */
	public LoginFrame() {	
		//BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;	
		//BeautyEyeLNFHelper.translucencyAtFrameInactive = false;
		setUndecorated(true);//无边框
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 450);
		setLocationRelativeTo(null);
		setFocusable(true);
		setResizable(false);
		LoginPane = new JPanel();
		LoginPane.setOpaque(false);
		LoginPane.setBackground(new Color(0, 255, 153));
		LoginPane.setBorder(null);
		setContentPane(LoginPane);//使当前窗体pane透明
		AWTUtilities.setWindowOpaque(this, false);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		LoginPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(408, 0, 366, 450);
		LoginPane.add(panel);
		panel.setLayout(null);
		
		JButton LogBtn = new RButton("\u767B \u5F55");
		LogBtn.setBounds(62, 314, 220, 31);
		panel.add(LogBtn);
		LogBtn.setActionCommand("\u767B \u5F55");
		LogBtn.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		LogBtn.setBackground(new Color(0, 153, 255));
		LogBtn.setForeground(Color.WHITE);
		LogBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String usr = UsrTf.getText();
				String pwd = new String(PwdTf.getPassword());
				if(usr.trim().length() == 0||pwd.trim().length() == 0) {
					Label templLabel = new Label("用户名密码不允许为空");
					//templLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
					JOptionPane.showMessageDialog(null, templLabel);
					return;
				}	
				try {
					if(!CheckLogin.exist(usr)) {
        				JOptionPane.showMessageDialog(null, "用户不存在", "错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
        			else if (!CheckLogin.CheckRole(usr,pwd)){
							//System.out.printf(usrStr +","+ pwdStr);
							JOptionPane.showMessageDialog(null, "用户名或密码错误","错误",JOptionPane.ERROR_MESSAGE);
							return;
						
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Object leve= CheckLogin.Checklevel(usr,pwd).get(0);
				String level=String.valueOf(leve);
				System.out.print(level);
				setVisible(false);
				new MainFrame(usr,level).setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			}
		});
		
		
		
		UsrTf = new JTextField();
		UsrTf.setBounds(37, 175, 245, 29);
		panel.add(UsrTf);
		UsrTf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == '\n')
					LogBtn.doClick();
			}
		});
		UsrTf.addFocusListener((new JTextFieldHintListener(UsrTf, "请输入用户名")));//提示输入监听器
		UsrTf.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		UsrTf.revalidate();
		UsrTf.setBorder(null);
		UsrTf.setColumns(10);
		
		PwdTf = new JPasswordField();
		PwdTf.setBounds(37, 224, 245, 31);
		panel.add(PwdTf);
		PwdTf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == '\n')
					LogBtn.doClick();
			}
		});
		PwdTf.setBackground(Color.WHITE);
		PwdTf.setBorder(null);
		//PwdTf.addFocusListener((new JTextFieldHintListener(PwdTf, "请输入用户密码")));
		PwdTf.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		ImageIcon bg = new ImageIcon(LoginFrame.class.getResource("bg.png"));
		Image img = bg.getImage();  
		img = img.getScaledInstance(366, 450, Image.SCALE_DEFAULT);  
		bg.setImage(img);
		
		JButton zxh = new JButton();
		zxh.setBackground(Color.WHITE);
		zxh.setBorder(null);
		ImageIcon s = new ImageIcon(LoginFrame.class.getResource("sm.png"));
		Image sm = s.getImage();  
		sm = sm.getScaledInstance(22, 22, Image.SCALE_DEFAULT);  
		s.setImage(sm);
		zxh.setIcon(s);
		zxh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		zxh.setBounds(294, 18, 22, 22);
		panel.add(zxh);
		
		JButton gb = new JButton("");
		gb.setBorder(null);
		gb.setBackground(Color.WHITE);
		ImageIcon e = new ImageIcon(LoginFrame.class.getResource("ex.png"));
		Image ex = e.getImage();  
		ex = ex.getScaledInstance(22, 22, Image.SCALE_DEFAULT);  
		e.setImage(ex);
		gb.setIcon(e);
		gb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		gb.setBounds(326, 18, 22, 22);
		panel.add(gb);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(bg);
		lblNewLabel_1.setBounds(0, 0, 366, 450);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon b = new ImageIcon(LoginFrame.class.getResource("blue.png"));
		Image im = b.getImage();  
		im = im.getScaledInstance(800, 368, Image.SCALE_DEFAULT);  
		b.setImage(im);
		lblNewLabel.setIcon(b);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(0, 153, 255));
		lblNewLabel.setBounds(0, 43, 800, 368);
		LoginPane.add(lblNewLabel);
		//setOpacity(0.0f);
	}
}
