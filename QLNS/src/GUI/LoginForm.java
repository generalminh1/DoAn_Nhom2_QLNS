package GUI;

import java.awt.*;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardEndHandler;

import BLL.UserBLL;
import DTO.UserDTO;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;

public class LoginForm extends JFrame{

	private JPanel contentPane;
	private final JPanel LoginPanel = new JPanel();
	private JTextField tfUsername;
	private JPasswordField pfPassword;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public LoginForm() {
		setType(Type.POPUP);
		setTitle("Qu\u1EA3n l\u00FD nh\u00E2n s\u1EF1");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 387);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		LoginPanel.setBackground(new Color(184,190,221));
		LoginPanel.setBounds(0, 0, 592, 355);
		contentPane.add(LoginPanel);
		LoginPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0110\u0103ng nh\u1EADp");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 25, 592, 50);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setForeground(new Color(240, 255, 255));
		LoginPanel.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("T\u00E0i kho\u1EA3n");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(53, 122, 93, 28);
		LoginPanel.add(lblUsername);
		
		tfUsername = new JTextField();
		tfUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					login();
			}
		});
		lblUsername.setLabelFor(tfUsername);
		tfUsername.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		tfUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfUsername.setBounds(179, 122, 348, 28);
		LoginPanel.add(tfUsername);
		tfUsername.setColumns(10);
		
		JLabel lblpassword = new JLabel("M\u1EADt kh\u1EA9u");
		lblpassword.setForeground(Color.WHITE);
		lblpassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblpassword.setBounds(53, 183, 93, 28);
		LoginPanel.add(lblpassword);
		
		pfPassword = new JPasswordField();
		pfPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					login();
				}
			}
		});
		lblpassword.setLabelFor(pfPassword);
		pfPassword.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		pfPassword.setBounds(179, 183, 348, 28);
		LoginPanel.add(pfPassword);
		
		JButton btnLogin = new JButton("\u0110\u0103ng nh\u1EADp");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		
		
		btnLogin.setBorderPainted(false);
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(186, 85, 211));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLogin.setBorder(new LineBorder(new Color(153, 50, 204), 5, true));
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setBounds(210, 257, 179, 38);
		LoginPanel.add(btnLogin);
	}
	public void login(){
		try {
			UserDTO userDTO = new UserDTO(tfUsername.getText(),pfPassword.getText());
			if (new UserBLL().userAuth(userDTO)) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							MainForm frame = new MainForm();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				setVisible(false);
			}
			else {
				JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu!");
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
}
