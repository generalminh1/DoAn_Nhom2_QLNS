package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.UserBLL;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChangePW extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JPasswordField pfPass;
	private JPasswordField pfNewPass;
	private JPasswordField pfNewPass1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ChangePW() {
		setTitle("\u0110\u1ED9i m\u1EADt kh\u1EA9u");
		setBounds(100, 100, 423, 262);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(240, 230, 239));
		panel.setBounds(0, 0, 407, 223);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPass = new JLabel("M\u1EADt kh\u1EA9u hi\u1EC7n t\u1EA1i");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPass.setBounds(10, 42, 116, 14);
		panel.add(lblPass);
		
		JLabel lblNewPass = new JLabel("M\u1EADt kh\u1EA9u m\u1EDBi");
		lblNewPass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewPass.setBounds(10, 67, 116, 14);
		panel.add(lblNewPass);
		
		JLabel lblNewPass1 = new JLabel("Nh\u1EADp l\u1EA1i m\u1EADt kh\u1EA9u");
		lblNewPass1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewPass1.setBounds(10, 92, 116, 14);
		panel.add(lblNewPass1);
		
		pfPass = new JPasswordField();
		pfPass.setBounds(136, 40, 261, 20);
		panel.add(pfPass);
		
		pfNewPass = new JPasswordField();
		pfNewPass.setBounds(136, 65, 261, 20);
		panel.add(pfNewPass);
		
		pfNewPass1 = new JPasswordField();
		pfNewPass1.setBounds(136, 90, 261, 20);
		panel.add(pfNewPass1);
		
		JButton btnChangepw = new JButton("\u0110\u1ED5i m\u1EADt kh\u1EA9u");
		btnChangepw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (new UserBLL().changePassword(pfPass.getText(), pfNewPass.getText(), pfNewPass1.getText())) {
					JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công", "Thông báo!",1);
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Sai thông tin");
				}
			}
		});
		btnChangepw.setBounds(148, 142, 95, 23);
		panel.add(btnChangepw);
	}
}
