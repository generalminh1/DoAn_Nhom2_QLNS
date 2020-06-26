package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

import BLL.DepartmentBLL;
import BLL.PersonnelBLL;
import BLL.PositionBLL;
import BLL.SalaryBLL;
import DTO.DepartmentDTO;
import DTO.PersonnelDTO;
import DTO.PositionDTO;
import DTO.SalaryDTO;
import DTO.UserDTO;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Table;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;

public class MainForm extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfFolk;
	private JTextField tfHomeTown;
	private JTextField textField;
	private JTable table;
	private JTextField textField_id;
	private JTextField textField_CMND;
	private JTextField textField_Search;
	private JTextField txtPB_name;
	private JTextField txtCV_name;
	private JTable table_PB;
	private JTextField textField_ID_PB;
	private JTextField textField_ID_CV;
	private JTable table_CV;
	private JTextField txtBL_money;
	private JTextField textField_ID_BL;
	private JTable table_BL;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public MainForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainForm.class.getResource("/Icons/icons8_management_125px.png")));
		setResizable(false);
		setVisible(true);
		setTitle("Qu\u1EA3n l\u00FD nh\u00E2n s\u1EF1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 786);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//***********TẠO PANEL CHỨA CÁC NÚT DẪN TỚI CÁC PANEL KHÁC (FUNCTION PANEL)***********
		JPanel FunctionPanel = new JPanel();
		FunctionPanel.setBorder(null);
		FunctionPanel.setBackground(new Color(184,190,221));
		FunctionPanel.setBounds(0, 0, 332, 765);
		contentPane.add(FunctionPanel);
		FunctionPanel.setLayout(null);
		
		JLabel lblQLNS = new JLabel("Nh\u00E2n s\u1EF1");
		JLabel lblQLCV = new JLabel("Chức vụ");
		JLabel lblQLPB = new JLabel("Phòng ban");
		JLabel lblQLBL = new JLabel("Bậc lương");
		lblQLNS.setBackground(new Color(135, 206, 235));
		lblQLNS.setOpaque(true);
		lblQLNS.setBorder(new EmptyBorder(0, 20, 0, 0));
		lblQLNS.setForeground(new Color(255, 255, 255));
		lblQLNS.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblQLNS.setIconTextGap(20);
		lblQLNS.setIcon(new ImageIcon(MainForm.class.getResource("/Icons/icons8_businessman_32px_1.png")));
		lblQLNS.setBounds(0, 238, 332, 60);
		FunctionPanel.add(lblQLNS);
		

		JLabel lblLogout = new JLabel("Đăng xuất");
		lblLogout.setHorizontalTextPosition(SwingConstants.LEFT);
		lblLogout.setIconTextGap(10);
		lblLogout.setIcon(new ImageIcon(MainForm.class.getResource("/Icons/icons8_exit_25px.png")));
		lblLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							LoginForm frame = new LoginForm();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		lblLogout.setForeground(Color.WHITE);
		lblLogout.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLogout.setBounds(198, 722, 124, 20);
		FunctionPanel.add(lblLogout);
		
		JLabel lblChangepw = new JLabel("Đổi mật khẩu");
		lblChangepw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ChangePW frame = new ChangePW();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		lblChangepw.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblChangepw.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblChangepw.setForeground(SystemColor.textHighlight);
		lblChangepw.setBounds(248, 697, 74, 14);
		FunctionPanel.add(lblChangepw);
		
		JLabel lblUser = new JLabel(UserDTO.getUsername());
		lblUser.setIcon(new ImageIcon(MainForm.class.getResource("/Icons/icons8_customer_32px_1.png")));
		lblUser.setBounds(10, 163, 95, 27);
		FunctionPanel.add(lblUser);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(MainForm.class.getResource("/Icons/icons8_management_125px.png")));
		label.setBounds(10, 11, 312, 141);
		FunctionPanel.add(label);
		
		//*********TẠO PANEL QUẢN LÍ NHÂN SỰ***********************
		JPanel QLNSPanel = new JPanel();
		QLNSPanel.setBackground(new Color(240,230,239));
		QLNSPanel.setBorder(null);
		QLNSPanel.setBounds(332, 0, 862, 757);
		contentPane.add(QLNSPanel);
		QLNSPanel.setLayout(null);
		
		JPanel lblInfo = new JPanel();
		lblInfo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblInfo.setBorder(new TitledBorder(new LineBorder(new Color(232, 217, 231), 3), "Qu\u1EA3n l\u00FD nh\u00E2n s\u1EF1", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblInfo.setName("");
		lblInfo.setToolTipText("");
		lblInfo.setBackground(new Color(240,230,239));
		lblInfo.setBounds(12, 13, 838, 316);
		QLNSPanel.add(lblInfo);
		lblInfo.setLayout(null);
		
		JLabel lblName = new JLabel("H\u1ECD t\u00EAn");
		lblName.setBounds(12, 33, 56, 16);
		lblInfo.add(lblName);
		
		tfName = new JTextField();
		tfName.setBounds(80, 30, 214, 22);
		lblInfo.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblBirthday = new JLabel("Ng\u00E0y sinh");
		lblBirthday.setBounds(318, 33, 56, 16);
		lblInfo.add(lblBirthday);
		
		JLabel lblNewLabel = new JLabel("D\u00E2n t\u1ED9c");
		lblNewLabel.setBounds(594, 33, 44, 16);
		lblInfo.add(lblNewLabel);
		
		tfFolk = new JTextField();
		tfFolk.setBounds(650, 30, 176, 22);
		lblInfo.add(tfFolk);
		tfFolk.setColumns(10);
		
		JLabel lblHomeTown = new JLabel("Qu\u00EA qu\u00E1n");
		lblHomeTown.setBounds(12, 68, 56, 16);
		lblInfo.add(lblHomeTown);
		
		JLabel lblGender = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblGender.setBounds(318, 68, 56, 16);
		lblInfo.add(lblGender);
		
		tfHomeTown = new JTextField();
		tfHomeTown.setBounds(80, 65, 214, 22);
		lblInfo.add(tfHomeTown);
		tfHomeTown.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBorder(null);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nam", "N\u1EEF"}));
		comboBox.setBounds(386, 65, 77, 22);
		lblInfo.add(comboBox);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd-MM-yyyy");
		dateChooser.setBounds(386, 33, 156, 22);
		lblInfo.add(dateChooser);
		
		JLabel lblPhone = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblPhone.setBounds(572, 68, 66, 16);
		lblInfo.add(lblPhone);
		
		textField = new JTextField();
		textField.setBounds(650, 65, 176, 22);
		lblInfo.add(textField);
		textField.setColumns(10);
		
		JLabel lblDpm = new JLabel("Ph\u00F2ng ban");
		lblDpm.setBounds(12, 105, 66, 16);
		lblInfo.add(lblDpm);
		
		JComboBox comboBox_1 = new JComboBox();
		for(String s: loadAllDepartmentCombobox()) {
			comboBox_1.addItem(s);
		}
		comboBox_1.setBounds(80, 102, 105, 22);
		lblInfo.add(comboBox_1);
		
		JLabel lblPosition = new JLabel("Ch\u1EE9c v\u1EE5");
		lblPosition.setBounds(211, 105, 56, 16);
		lblInfo.add(lblPosition);
		
		JComboBox comboBox_1_1 = new JComboBox();
		for(String s: loadAllPositionCombobox()) {
			comboBox_1_1.addItem(s);
		}
		comboBox_1_1.setBounds(265, 102, 105, 22);
		lblInfo.add(comboBox_1_1);
		
		JLabel lblTrnhHc = new JLabel("Tr\u00ECnh \u0111\u1ED9 h\u1ECDc v\u1EA5n");
		lblTrnhHc.setBounds(415, 105, 99, 16);
		lblInfo.add(lblTrnhHc);
		
		JComboBox comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"THPT", "DH", "CD"}));
		comboBox_1_1_1.setBounds(523, 102, 105, 22);
		lblInfo.add(comboBox_1_1_1);
		
		JLabel lblBcLng = new JLabel("B\u1EADc l\u01B0\u01A1ng");
		lblBcLng.setBounds(650, 105, 66, 16);
		lblInfo.add(lblBcLng);
		
		JComboBox comboBox_1_1_1_1 = new JComboBox();
		for(String s:loadAllSalaryCombobox()) {
			comboBox_1_1_1_1.addItem(s);
		}
		comboBox_1_1_1_1.setBounds(721, 102, 105, 22);
		lblInfo.add(comboBox_1_1_1_1);
		
		JButton btnAddStaff = new JButton("Th\u00EAm");
		btnAddStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonnelDTO personDTO = new PersonnelDTO();
				personDTO.setHoten(tfName.getText());
				SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy",Locale.getDefault());
				String d= sdf.format(dateChooser.getDate());
				personDTO.setNgaySinh(d);
				personDTO.setQueQuan(tfHomeTown.getText());
				personDTO.setGioiTinh(comboBox.getSelectedItem().toString());
				personDTO.setDanToc(tfFolk.getText());
				personDTO.setSDT(textField.getText());
				personDTO.setMaPB(comboBox_1.getSelectedItem().toString());
				personDTO.setMaCV(comboBox_1_1.getSelectedItem().toString());
				personDTO.setMaTDHV(comboBox_1_1_1.getSelectedItem().toString());
				personDTO.setBacLuong(comboBox_1_1_1_1.getSelectedItem().toString());
				if(textField_CMND.getText().trim().isEmpty()){
					JOptionPane.showMessageDialog(null,"Vui lòng nhập số căn cước!", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}else {personDTO.setCMND(textField_CMND.getText());}
				PersonnelBLL personBLL = new PersonnelBLL();
				try {
					if(!personBLL.checkLegitCMND(personDTO)) {
						JOptionPane.showMessageDialog(null,"Số căn cước không hợp lệ!", "Thông báo",
								 JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					if(!personBLL.checkLegitNumber(personDTO)) {
						JOptionPane.showMessageDialog(null,"Số điện thoại không hợp lệ!", "Thông báo",
								 JOptionPane.ERROR_MESSAGE);
						return;
					}
					 int result = personBLL.insertPersonnel(personDTO);
					 
					 if (result ==1) {
					 JOptionPane.showMessageDialog(null,
					 "Thêm dữ liệu thành công!", "Thông báo",
					 JOptionPane.INFORMATION_MESSAGE);
					 loadAllPersonnel();
					 }
					 if(result==0) {
						 JOptionPane.showMessageDialog(null,
						 "Số căn cước đã tồn tại!", "Lỗi",
						 JOptionPane.INFORMATION_MESSAGE); 
						 return;
					 }
					 //loadAllPersonnel();
					 } catch (Exception ex) {
						 ex.printStackTrace();
					 }
			}
		});
		btnAddStaff.setBounds(10, 210, 97, 25);
		lblInfo.add(btnAddStaff);
		
		JButton btnUpdateStaff = new JButton("C\u1EADp nh\u1EADt");
		btnUpdateStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonnelDTO personDTO = new PersonnelDTO();
				personDTO.setMaNV(textField_id.getText());
				personDTO.setHoten(tfName.getText());
				SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy",Locale.getDefault());
				String d= sdf.format(dateChooser.getDate());
				personDTO.setNgaySinh(d);
				personDTO.setQueQuan(tfHomeTown.getText());
				personDTO.setGioiTinh(comboBox.getSelectedItem().toString());
				personDTO.setDanToc(tfFolk.getText());
				personDTO.setSDT(textField.getText());
				personDTO.setMaPB(comboBox_1.getSelectedItem().toString());
				personDTO.setMaCV(comboBox_1_1.getSelectedItem().toString());
				personDTO.setMaTDHV(comboBox_1_1_1.getSelectedItem().toString());
				personDTO.setBacLuong(comboBox_1_1_1_1.getSelectedItem().toString());
				personDTO.setCMND(textField_CMND.getText());
				PersonnelBLL personBLL = new PersonnelBLL();
				try {
					if(!personBLL.checkLegitNumber(personDTO)) {
						JOptionPane.showMessageDialog(null,"Số điện thoại không hợp lệ!", "Thông báo",
								 JOptionPane.ERROR_MESSAGE);
						return;
					}
					 int result = personBLL.updatePersonnel(personDTO);
					 if (result != 0) {
						 JOptionPane.showMessageDialog(null,
						 "Cập nhật thành công!", "Thông báo",
						 JOptionPane.INFORMATION_MESSAGE);
					 }
					 loadAllPersonnel();
				 } catch (Exception ex) {
					 ex.printStackTrace();
				 }
			}
		});
		btnUpdateStaff.setBounds(120, 210, 97, 25);
		lblInfo.add(btnUpdateStaff);
		
		JButton btnNewButton = new JButton("X\u00F3a");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonnelDTO personDTO= new PersonnelDTO();
				 personDTO.setMaNV(textField_id.getText());
				 PersonnelBLL personBLL= new PersonnelBLL();
				 int choice = JOptionPane.showConfirmDialog(null,
				 "Bạn có chắc chắn xóa dữ liệu!", "Xác nhận",
				 JOptionPane.YES_NO_OPTION);
				 if (choice == JOptionPane.YES_OPTION) {
				 try {
				 @SuppressWarnings("unused")
				 int result = personBLL.deletePersonnel(personDTO);
				 loadAllPersonnel();
				 } catch (Exception ex) {
					 ex.printStackTrace();
				 }
				 }
			}
		});
		btnNewButton.setBounds(227, 210, 97, 25);
		lblInfo.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Xuất Excel");
		btnNewButton_1.setActionCommand("Xuất Excel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  tableToExcel();
			}
		});
		btnNewButton_1.setBounds(334, 210, 97, 25);
		lblInfo.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Nhập Excel");
		btnNewButton_2.setBounds(445, 210, 97, 25);
		lblInfo.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				excelToTable();
			}
		});
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfName.setText("");
				tfFolk.setText("");;
				tfHomeTown.setText("");
				textField.setText("");
				dateChooser.setDate(null);
				textField_id.setText("");
				textField_CMND.setText("");
			}
		});
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnClear.setBounds(555, 211, 89, 23);
		lblInfo.add(btnClear);
		
		textField_id = new JTextField();
		textField_id.setEditable(false);
		textField_id.setBounds(56, 167, 86, 20);
		lblInfo.add(textField_id);
		textField_id.setColumns(10);
		
		JButton btnHinTtC = new JButton("Hiện tất cả nhân sự");
		btnHinTtC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadAllPersonnel();
			}
		});
		btnHinTtC.setBounds(10, 282, 145, 23);
		lblInfo.add(btnHinTtC);
		
		JLabel lblCMND = new JLabel("Số căn cước");
		lblCMND.setBounds(12, 138, 77, 16);
		lblInfo.add(lblCMND);
		
		textField_CMND = new JTextField();
		textField_CMND.setBounds(90, 135, 204, 20);
		lblInfo.add(textField_CMND);
		textField_CMND.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240,230,239));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(232, 217, 231), 3), "Danh s\u00E1ch nh\u00E2n s\u1EF1", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.setBounds(12, 340, 838, 410);
		QLNSPanel.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel model = table.getSelectionModel();
		table.addMouseListener(new MouseAdapter() {
		// Lấy thông tin dòng dữ liệu được chọn hiển thị lên component
		public void mouseClicked(MouseEvent arg0) {
		int row = table.getSelectedRow();
		if (row != 0 && row !=-1) {
			 if(table.getValueAt(row, 0).toString()!=null)
				 textField_id.setText(table.getValueAt(row, 0).toString());
		tfName.setText(table.getValueAt(row, 1).toString());
		try {
			java.util.Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse(table.getValueAt(row, 2).toString());
			dateChooser.setDate(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tfHomeTown.setText(table.getValueAt(row, 3).toString());
		comboBox.setSelectedItem(table.getValueAt(row, 4));
		tfFolk.setText(table.getValueAt(row, 5).toString());
		textField.setText(table.getValueAt(row, 6).toString());
		comboBox_1.setSelectedItem(table.getValueAt(row, 7));
		comboBox_1_1.setSelectedItem(table.getValueAt(row, 8));
		comboBox_1_1_1.setSelectedItem(table.getValueAt(row, 9));
		comboBox_1_1_1_1.setSelectedItem(table.getValueAt(row, 10));
		textField_CMND.setText(table.getValueAt(row, 11).toString());
		}
		}
		});
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 21, 814, 365);
		panel.add(scrollPane);
		table.setBounds(10, 21, 814, 365);
		//panel.add(table);
		
		
		JLabel lblSearch = new JLabel("");
		lblSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textField_Search.getText().trim().equals("")){
					return;
				}
				 //tạo control DefaultTableModel để hiển thị danh sách user
				 String[] header = { "Mã NV","Họ tên","Ngày sinh","Quê quán","Giới tính","Dân tộc","SĐT","Phòng ban","Chức vụ","TDHV","Bậc lương","CMND" };
				 DefaultTableModel dtm = new DefaultTableModel(header, 0);
				 table.setModel(dtm);
				 //lấy danh sách UserDTO (gọi hàm getAllUsers() trong UserBUS)
				 ArrayList<PersonnelDTO> arr = new ArrayList<PersonnelDTO>();
				 PersonnelBLL personBLL = new PersonnelBLL();
				 arr = personBLL.getPersonByKey(textField_Search.getText());
				 //Duyệt mảng userDTO vừa lấy được: arr
				 PersonnelDTO personDTO = new PersonnelDTO();
				 for (int i = 0; i < arr.size(); i++) {
					 personDTO = arr.get(i);
					 String MaNV = personDTO.getMaNV();
					 String HoTen = personDTO.getHoten();
					 String NgaySinh= personDTO.getNgaySinh();
					 String QueQuan=personDTO.getQueQuan();
					 String GioiTinh=personDTO.getGioiTinh();
					 String DanToc=personDTO.getDanToc();
					 String SoDienThoai=personDTO.getSDT();
					 String PhongBan= personDTO.getMaPB();
					 String ChucVu= personDTO.getMaCV();
					 String DTHV= personDTO.getMaTDHV();
					 String MucLuong= personDTO.getBacLuong();
					 String CMND=personDTO.getCMND();
					 //tạo row để add vào control DefaultTableModel
					 Object[] row = {MaNV,HoTen,NgaySinh,QueQuan,GioiTinh,DanToc,SoDienThoai,PhongBan,ChucVu,DTHV,MucLuong,CMND};
					 dtm.addRow(row);
				 }
			}
		});
		lblSearch.setIcon(new ImageIcon(MainForm.class.getResource("/Icons/icons8_search_25px.png")));
		lblSearch.setBounds(780, 282, 25, 23);
		lblInfo.add(lblSearch);
		
		textField_Search = new JTextField();
		textField_Search.setBounds(594, 283, 176, 20);
		lblInfo.add(textField_Search);
		textField_Search.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mã NV");
		lblNewLabel_1.setBounds(12, 170, 37, 14);
		lblInfo.add(lblNewLabel_1);
		loadAllPersonnel();
		//**********TẠO PANEL QUẢN LÍ PHÒNG BAN****************
		
		JPanel panel_QLPB = new JPanel();
		panel_QLPB.setBackground(new Color(240,230,239));
		panel_QLPB.setBorder(null);
		panel_QLPB.setBounds(332, 0, 862, 757);
		contentPane.add(panel_QLPB);
		panel_QLPB.setLayout(null);
		
		JPanel panel_InfoQLPB = new JPanel();
		panel_InfoQLPB.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_InfoQLPB.setBorder(new TitledBorder(new LineBorder(new Color(232, 217, 231), 3), "Qu\u1EA3n l\u00FD ph\u00F2ng ban", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_InfoQLPB.setName("");
		panel_InfoQLPB.setToolTipText("");
		panel_InfoQLPB.setBackground(new Color(240,230,239));
		panel_InfoQLPB.setBounds(12, 13, 838, 316);
		panel_QLPB.add(panel_InfoQLPB);
		panel_InfoQLPB.setLayout(null);
		
		txtPB_name = new JTextField();
		txtPB_name.setHorizontalAlignment(SwingConstants.CENTER);
		txtPB_name.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPB_name.setBounds(10, 136, 208, 40);
		panel_InfoQLPB.add(txtPB_name);
		txtPB_name.setColumns(10);
		
		JLabel lblAddPB = new JLabel("Thêm tên Phòng Ban");
		lblAddPB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAddPB.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddPB.setBounds(40, 102, 139, 23);
		panel_InfoQLPB.add(lblAddPB);
		
		JButton btnAddPB = new JButton("Thêm");
		btnAddPB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepartmentDTO departmentDTO = new DepartmentDTO();
				departmentDTO.setTenPB(txtPB_name.getText());
				DepartmentBLL departmentBLL = new DepartmentBLL();
				try {
					int result = departmentBLL.insertDepartment(departmentDTO,txtPB_name.getText());
					if(result!=0) {
						JOptionPane.showMessageDialog(null,"Thêm dữ liệu thành công!", "Thông báo",
								JOptionPane.INFORMATION_MESSAGE);
						loadAllDepartment();
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnAddPB.setBounds(264, 103, 89, 23);
		panel_InfoQLPB.add(btnAddPB);
		
		JButton btnUpdatePB = new JButton("Cập nhật");
		btnUpdatePB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepartmentDTO departmentDTO = new DepartmentDTO();
				departmentDTO.setMaPB(textField_ID_PB.getText());
				departmentDTO.setTenPB(txtPB_name.getText());
				DepartmentBLL departmentBLL = new DepartmentBLL();
				try {
					int result = departmentBLL.updateDepartment(departmentDTO);
					if(result!=0) {
						JOptionPane.showMessageDialog(null,
							"Cập nhật dữ liệu thành công!", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
						loadAllDepartment();
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnUpdatePB.setBounds(264, 145, 89, 23);
		panel_InfoQLPB.add(btnUpdatePB);
		
		JButton btnDeletePB = new JButton("Xóa");
		btnDeletePB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepartmentDTO departmentDTO = new DepartmentDTO();
				departmentDTO.setMaPB(textField_ID_PB.getText());
				DepartmentBLL departmentBLL= new DepartmentBLL();
				 int choice = JOptionPane.showConfirmDialog(null,
				 "Bạn có chắc chắn xóa dữ liệu!", "Xác nhận",
				 JOptionPane.YES_NO_OPTION);
				 if (choice == JOptionPane.YES_OPTION) {
				 try {
					 departmentBLL.deleteDepartment(departmentDTO);
				 loadAllDepartment();
				 } catch (Exception ex) {
					 ex.printStackTrace();
				 }
				 }
			}
		});
		btnDeletePB.setBounds(264, 190, 89, 23);
		panel_InfoQLPB.add(btnDeletePB);
		
		textField_ID_PB = new JTextField();
		textField_ID_PB.setEditable(false);
		textField_ID_PB.setBounds(10, 206, 108, 23);
		panel_InfoQLPB.add(textField_ID_PB);
		textField_ID_PB.setColumns(10);
		
		JPanel panel_PB = new JPanel();
		panel_PB.setBackground(new Color(240,230,239));
		panel_PB.setBorder(new TitledBorder(new LineBorder(new Color(232, 217, 231), 3), "Danh s\u00E1ch ph\u00F2ng ban", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_PB.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_PB.setBounds(12, 342, 838, 410);
		panel_QLPB.add(panel_PB);
		panel_PB.setLayout(null);
		
		table_PB = new JTable();
		table_PB.setBackground(Color.WHITE);
		table_PB.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		table_PB.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel model1 = table_PB.getSelectionModel();
		table_PB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int row = table_PB.getSelectedRow();
				 if (row !=-1 && row != 0) {
					 textField_ID_PB.setText(table_PB.getValueAt(row, 0).toString());
					 txtPB_name.setText(table_PB.getValueAt(row, 1).toString());
				 }
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane(table_PB);
		scrollPane_1.setBounds(12, 32, 814, 365);
		panel_PB.add(scrollPane_1);
		table_PB.setBounds(12, 32, 814, 365);
		//panel_PB.add(table_PB);
		
		//************TẠO PANEL QUẢN LÝ CHỨC VỤ***************************
		JPanel panel_QLCV = new JPanel();
		panel_QLCV.setBackground(new Color(240,230,239));
		panel_QLCV.setBorder(null);
		panel_QLCV.setBounds(332, 0, 862, 757);
		contentPane.add(panel_QLCV);
		panel_QLCV.setLayout(null);
		
		JPanel panel_InfoQLCV = new JPanel();
		panel_InfoQLCV.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_InfoQLCV.setBorder(new TitledBorder(new LineBorder(new Color(232, 217, 231), 3), "Qu\u1EA3n l\u00FD ch\u1EE9c v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_InfoQLCV.setName("");
		panel_InfoQLCV.setToolTipText("");
		panel_InfoQLCV.setBackground(new Color(240,230,239));
		panel_InfoQLCV.setBounds(12, 13, 838, 316);
		panel_QLCV.add(panel_InfoQLCV);
		panel_InfoQLCV.setLayout(null);
		
		txtCV_name = new JTextField();
		txtCV_name.setHorizontalAlignment(SwingConstants.CENTER);
		txtCV_name.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCV_name.setBounds(10, 136, 208, 40);
		panel_InfoQLCV.add(txtCV_name);
		txtCV_name.setColumns(10);
		
		JLabel lblAddCV = new JLabel("Thêm tên Chức Vụ");
		lblAddCV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAddCV.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddCV.setBounds(40, 102, 139, 23);
		panel_InfoQLCV.add(lblAddCV);
		
		textField_ID_CV = new JTextField();
		textField_ID_CV.setEditable(false);
		textField_ID_CV.setBounds(10, 206, 108, 23);
		panel_InfoQLCV.add(textField_ID_CV);
		textField_ID_CV.setColumns(10);
		
		JButton btnAddCV = new JButton("Thêm");
		btnAddCV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddCV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PositionDTO posDTO= new PositionDTO();
				posDTO.setTenCV(txtCV_name.getText());
				PositionBLL posBLL= new PositionBLL();
				try {
					int result = posBLL.insertPosition(posDTO,txtCV_name.getText());
					if(result!=0) {
						JOptionPane.showMessageDialog(null,"Thêm dữ liệu thành công!", "Thông báo",
								JOptionPane.INFORMATION_MESSAGE);
						loadAllPosition();
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnAddCV.setBounds(264, 103, 89, 23);
		panel_InfoQLCV.add(btnAddCV);
		
		JButton btnUpdateCV = new JButton("Cập nhật");
		btnUpdateCV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PositionDTO posDTO= new PositionDTO();
				posDTO.setMaCV(textField_ID_CV.getText());
				posDTO.setTenCV(txtCV_name.getText());
				PositionBLL posBLL= new PositionBLL();
				try {
					int result = posBLL.updatePosition(posDTO);
					if(result!=0) {
						JOptionPane.showMessageDialog(null,
							"Cập nhật dữ liệu thành công!", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
						loadAllPosition();
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnUpdateCV.setBounds(264, 145, 89, 23);
		panel_InfoQLCV.add(btnUpdateCV);
		
		JButton btnDeleteCV = new JButton("Xóa");
		btnDeleteCV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PositionDTO posDTO = new PositionDTO();
				posDTO.setMaCV(textField_ID_CV.getText());
				PositionBLL posBLL= new PositionBLL();
				 int choice = JOptionPane.showConfirmDialog(null,
				 "Bạn có chắc chắn xóa dữ liệu!", "Xác nhận",
				 JOptionPane.YES_NO_OPTION);
				 if (choice == JOptionPane.YES_OPTION) {
				 try {
					 posBLL.deletePosition(posDTO);
					 loadAllPosition();
				 } catch (Exception ex) {
					 ex.printStackTrace();
				 }
				 }
			}
		});
		btnDeleteCV.setBounds(264, 190, 89, 23);
		panel_InfoQLCV.add(btnDeleteCV);
		
		JPanel panel_CV = new JPanel();
		panel_CV.setBackground(new Color(240,230,239));
		panel_CV.setBorder(new TitledBorder(new LineBorder(new Color(232, 217, 231), 3), "Danh s\u00E1ch ch\u1EE9c v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_CV.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_CV.setBounds(12, 342, 838, 410);
		panel_QLCV.add(panel_CV);
		panel_CV.setLayout(null);
		
		table_CV = new JTable();
		table_CV.setBackground(Color.WHITE);
		table_CV.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		table_CV.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel model2 = table_CV.getSelectionModel();
		table_CV.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int row = table_CV.getSelectedRow();
				 if (row !=-1 && row != 0) {
					 textField_ID_CV.setText(table_CV.getValueAt(row, 0).toString());
					 txtCV_name.setText(table_CV.getValueAt(row, 1).toString());
				 }
			}
		});
		
		JScrollPane scrollPane_2 = new JScrollPane(table_CV);
		scrollPane_2.setBounds(12, 32, 814, 365);
		panel_CV.add(scrollPane_2);
		table_CV.setBounds(12, 32, 814, 365);
		//panel_CV.add(table_CV);
		
		//**********TẠO PANEL QUẢN LÝ BẬC LƯƠNG**************
		JPanel panel_QLBL = new JPanel();
		panel_QLBL.setBackground(new Color(240,230,239));
		panel_QLBL.setBorder(null);
		panel_QLBL.setBounds(332, 0, 862, 757);
		contentPane.add(panel_QLBL);
		panel_QLBL.setLayout(null);
		
		JPanel panel_InfoQLBL = new JPanel();
		panel_InfoQLBL.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_InfoQLBL.setBorder(new TitledBorder(new LineBorder(new Color(232, 217, 231), 3), "Qu\u1EA3n l\u00FD b\u00E2c l\u01B0\u01A1ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_InfoQLBL.setName("");
		panel_InfoQLBL.setToolTipText("");
		panel_InfoQLBL.setBackground(new Color(240,230,239));
		panel_InfoQLBL.setBounds(12, 13, 838, 316);
		panel_InfoQLBL.setLayout(null);
		panel_QLBL.add(panel_InfoQLBL);
		
		txtBL_money = new JTextField();
		txtBL_money.setHorizontalAlignment(SwingConstants.CENTER);
		txtBL_money.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtBL_money.setBounds(10, 136, 208, 40);
		panel_InfoQLBL.add(txtBL_money);
		txtBL_money.setColumns(10);
		
		JLabel lblAddBL = new JLabel("Thêm bậc lương");
		lblAddBL.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAddBL.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddBL.setBounds(40, 102, 139, 23);
		panel_InfoQLBL.add(lblAddBL);
		
		textField_ID_BL = new JTextField();
		textField_ID_BL.setEditable(false);
		textField_ID_BL.setBounds(10, 206, 108, 23);
		panel_InfoQLBL.add(textField_ID_BL);
		textField_ID_BL.setColumns(10);
		
		JButton btnAddBL = new JButton("Thêm");
		btnAddBL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SalaryDTO salaryDTO= new SalaryDTO();
				salaryDTO.setSoTien(Float.parseFloat(txtBL_money.getText().toString()));
				SalaryBLL salaryBLL= new SalaryBLL();
				try {
					int result = salaryBLL.insertPosition(salaryDTO);
					if(result!=0) {
						JOptionPane.showMessageDialog(null,"Thêm dữ liệu thành công!", "Thông báo",
								JOptionPane.INFORMATION_MESSAGE);
						loadAllSalary();
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnAddBL.setBounds(264, 103, 89, 23);
		panel_InfoQLBL.add(btnAddBL);
		
		JButton btnUpdateBL = new JButton("Cập nhật");
		btnUpdateBL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SalaryDTO salaryDTO = new SalaryDTO();
				salaryDTO.setMaBL(textField_ID_BL.getText());
				salaryDTO.setSoTien(Float.parseFloat(txtBL_money.getText().toString()));
				SalaryBLL salaryBLL= new SalaryBLL();
				try {
					int result = salaryBLL.updateSalary(salaryDTO);
					if(result!=0) {
						JOptionPane.showMessageDialog(null,
							"Cập nhật dữ liệu thành công!", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
						loadAllSalary();
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnUpdateBL.setBounds(264, 145, 89, 23);
		panel_InfoQLBL.add(btnUpdateBL);
		
		JButton btnDeleteBL = new JButton("Xóa");
		btnDeleteBL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SalaryDTO salaryDTO= new SalaryDTO();
				salaryDTO.setMaBL(textField_ID_BL.getText());
				SalaryBLL salaryBLL= new SalaryBLL();
				 int choice = JOptionPane.showConfirmDialog(null,
				 "Bạn có chắc chắn xóa dữ liệu!", "Xác nhận",
				 JOptionPane.YES_NO_OPTION);
				 if (choice == JOptionPane.YES_OPTION) {
				 try {
					 salaryBLL.deleteSalary(salaryDTO);
					 loadAllSalary();
				 } catch (Exception ex) {
					 ex.printStackTrace();
				 }
				 }
			}
		});
		btnDeleteBL.setBounds(264, 190, 89, 23);
		panel_InfoQLBL.add(btnDeleteBL);
		
		JPanel panel_BL = new JPanel();
		panel_BL.setBackground(new Color(240,230,239));
		panel_BL.setBorder(new TitledBorder(new LineBorder(new Color(232, 217, 231), 3), "Danh s\u00E1ch b\u1EADc l\u01B0\u01A1ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_BL.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_BL.setBounds(12, 342, 838, 410);
		panel_BL.setLayout(null);
		panel_QLBL.add(panel_BL);
		
		table_BL = new JTable();
		table_BL.setBackground(Color.WHITE);
		table_BL.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		table_BL.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel model3 = table_BL.getSelectionModel();
		table_BL.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int row = table_BL.getSelectedRow();
				 if (row !=-1 && row != 0) {
					 textField_ID_BL.setText(table_BL.getValueAt(row, 0).toString());
					 txtBL_money.setText(table_BL.getValueAt(row, 1).toString());
				 }
			}
		});
		
		JScrollPane scrollPane_3 = new JScrollPane(table_BL);
		scrollPane_3.setBounds(12, 32, 814, 365);
		panel_BL.add(scrollPane_3);
		table_BL.setBounds(12, 32, 814, 365);
		//panel_BL.add(table_BL);
		
		
		
		//**********CÀI SỰ KIỆN CHO CÁC LABEL FUNCTION BÊN TRÁI************
		lblQLNS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblQLNS.setBackground(new Color(135, 206, 235));
				lblQLCV.setBackground(new Color(184, 190, 221));
				lblQLPB.setBackground(new Color(184, 190, 221));
				lblQLBL.setBackground(new Color(184, 190, 221));
				QLNSPanel.setVisible(true);
				panel_QLPB.setVisible(false);
				panel_QLCV.setVisible(false);
				panel_QLBL.setVisible(false);
				comboBox_1.removeAllItems();
				for(String s: loadAllDepartmentCombobox()) {
					comboBox_1.addItem(s);
				}
				comboBox_1_1.removeAllItems();
				for(String s: loadAllPositionCombobox()) {
					comboBox_1_1.addItem(s);
				}
				comboBox_1_1_1_1.removeAllItems();
				for(String s: loadAllSalaryCombobox()) {
					comboBox_1_1_1_1.addItem(s);
				}
			}
		});
		
		lblQLPB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblQLPB.setBackground(new Color(135, 206, 235));
				lblQLNS.setBackground(new Color(184, 190, 221));
				lblQLCV.setBackground(new Color(184, 190, 221));
				lblQLBL.setBackground(new Color(184, 190, 221));
				panel_QLPB.setVisible(true);
				QLNSPanel.setVisible(false);
				panel_QLCV.setVisible(false);
				panel_QLBL.setVisible(false);
				loadAllDepartment();
			}
		});
		lblQLPB.setIcon(new ImageIcon(MainForm.class.getResource("/Icons/icons8_team_32px.png")));
		lblQLPB.setOpaque(true);
		lblQLPB.setIconTextGap(20);
		lblQLPB.setForeground(Color.WHITE);
		lblQLPB.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblQLPB.setBorder(new EmptyBorder(0, 20, 0, 0));
		lblQLPB.setBackground(new Color(184, 190, 221));
		lblQLPB.setBounds(0, 300, 332, 60);
		FunctionPanel.add(lblQLPB);
		
		lblQLCV.setIcon(new ImageIcon(MainForm.class.getResource("/Icons/icons8_private_pv2_32px.png")));
		lblQLCV.setOpaque(true);
		lblQLCV.setIconTextGap(20);
		lblQLCV.setForeground(Color.WHITE);
		lblQLCV.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblQLCV.setBorder(new EmptyBorder(0, 20, 0, 0));
		lblQLCV.setBackground(new Color(184, 190, 221));
		lblQLCV.setBounds(0, 360, 332, 60);
		FunctionPanel.add(lblQLCV);
		lblQLCV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblQLCV.setBackground(new Color(135, 206, 235));
				lblQLNS.setBackground(new Color(184, 190, 221));
				lblQLPB.setBackground(new Color(184, 190, 221));
				lblQLBL.setBackground(new Color(184, 190, 221));
				panel_QLCV.setVisible(true);
				QLNSPanel.setVisible(false);
				panel_QLPB.setVisible(false);
				panel_QLBL.setVisible(false);
				loadAllPosition();
			}
		});
		
		lblQLBL.setIcon(new ImageIcon(MainForm.class.getResource("/Icons/icons8_money_32px.png")));
		lblQLBL.setOpaque(true);
		lblQLBL.setIconTextGap(20);
		lblQLBL.setForeground(Color.WHITE);
		lblQLBL.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblQLBL.setBorder(new EmptyBorder(0, 20, 0, 0));
		lblQLBL.setBackground(new Color(184, 190, 221));
		lblQLBL.setBounds(0, 431, 332, 60);
		FunctionPanel.add(lblQLBL);
		
		
		lblQLBL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblQLBL.setBackground(new Color(135, 206, 235));
				lblQLNS.setBackground(new Color(184, 190, 221));
				lblQLPB.setBackground(new Color(184, 190, 221));
				lblQLCV.setBackground(new Color(184, 190, 221));
				panel_QLBL.setVisible(true);
				panel_QLCV.setVisible(false);
				QLNSPanel.setVisible(false);
				panel_QLPB.setVisible(false);
				loadAllSalary();
			}
		});
	}
	
	
	public void loadAllPersonnel() {
		 //tạo control DefaultTableModel để hiển thị danh sách user
	 String[] header = { "Mã NV","Họ tên","Ngày sinh","Quê quán","Giới tính","Dân tộc","SĐT","Phòng ban","Chức vụ","TDHV","Bậc lương","CMND" };
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 table.setModel(dtm);
	 //lấy danh sách DTO (gọi hàm getAll... trong BLL)
	 ArrayList<PersonnelDTO> arr = new ArrayList<PersonnelDTO>();
	 PersonnelBLL personBLL = new PersonnelBLL();
	 arr = personBLL.getAllPersonnel();
	 //Duyệt mảng DTO vừa lấy được: arr
	 PersonnelDTO personDTO = new PersonnelDTO();
	 for (int i = 0; i < arr.size(); i++) {
		 personDTO = arr.get(i);
		 
		 String MaNV = personDTO.getMaNV();
		 String HoTen = personDTO.getHoten();
		 String NgaySinh= personDTO.getNgaySinh();
		 String QueQuan=personDTO.getQueQuan();
		 String GioiTinh=personDTO.getGioiTinh();
		 String DanToc=personDTO.getDanToc();
		 String SoDienThoai=personDTO.getSDT();
		 String PhongBan= personDTO.getMaPB();
		 String ChucVu= personDTO.getMaCV();
		 String DTHV= personDTO.getMaTDHV();
		 String MucLuong= personDTO.getBacLuong();
		 String CMND=personDTO.getCMND();
		 //tạo row để add vào control DefaultTableModel
		 Object[] row = {MaNV,HoTen,NgaySinh,QueQuan,GioiTinh,DanToc,SoDienThoai,PhongBan,ChucVu,DTHV,MucLuong,CMND};
		 dtm.addRow(row);
	 }
	 }
	//load file excel vào jtable, tham khảo trên mạng
	public void excelToTable() {
				File excelFile;
		        FileInputStream excelFIS = null;
		        BufferedInputStream excelBIS = null;
		        XSSFWorkbook excelImportToJTable = null;
		        String defaultCurrentDirectoryPath = "C:\\Users\\Authentic\\Desktop";
		        JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
		        excelFileChooser.setDialogTitle("Select Excel File");
		        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
		        excelFileChooser.setFileFilter(fnef);
		        int excelChooser = excelFileChooser.showOpenDialog(null);
		        if (excelChooser == JFileChooser.APPROVE_OPTION) {
		            try {
		            	DefaultTableModel model=(DefaultTableModel) table.getModel();
		            	int rowCount = model.getRowCount();
		            	for (int i = rowCount - 1; i >0; i--) {
		            	    model.removeRow(i);
		            	}
		                excelFile = excelFileChooser.getSelectedFile();
		                excelFIS = new FileInputStream(excelFile);
		                excelBIS = new BufferedInputStream(excelFIS);
		                excelImportToJTable = new XSSFWorkbook(excelBIS);
		                XSSFSheet excelSheet = excelImportToJTable.getSheetAt(0);
		 
		                for (int row = 1;row<=excelSheet.getLastRowNum(); row++) {
		                    XSSFRow excelRow = excelSheet.getRow(row);		 
		                    XSSFCell MaNV = excelRow.getCell(0);
		                    XSSFCell HoTen = excelRow.getCell(1);
		                    XSSFCell NgaySinh= excelRow.getCell(2);
		                    XSSFCell QueQuan=excelRow.getCell(3);
		                    XSSFCell GioiTinh=excelRow.getCell(4);
		                    XSSFCell DanToc=excelRow.getCell(5);
		                    XSSFCell SoDienThoai=excelRow.getCell(6);
		                    XSSFCell PhongBan= excelRow.getCell(7);
		                    XSSFCell ChucVu= excelRow.getCell(8);
		           			XSSFCell DTHV= excelRow.getCell(9);
		           			XSSFCell MucLuong= excelRow.getCell(10);
		           			XSSFCell CMND=excelRow.getCell(11);		                    
		                    model.addRow(new Object[]{MaNV,HoTen,NgaySinh,QueQuan,GioiTinh,DanToc,SoDienThoai,PhongBan,
		                    		ChucVu,DTHV,MucLuong,CMND});
		                }
		                JOptionPane.showMessageDialog(null, "Nhập file thành công!.....");
		            } catch (IOException iOException) {
		                JOptionPane.showMessageDialog(null, iOException.getMessage());
		            } finally {
		                try {
		                    if (excelFIS != null) {
		                        excelFIS.close();
		                    }
		                    if (excelBIS != null) {
		                        excelBIS.close();
		                    }
		                    if (excelImportToJTable != null) {
		                        excelImportToJTable.close();
		                    }
		                } catch (IOException iOException) {
		                    JOptionPane.showMessageDialog(null, iOException.getMessage());
		                }
		            }
		        }
	}
	//load jtable vào excel, tham khảo trên mạng
	public void tableToExcel() {
		FileOutputStream out = null;
		JFileChooser chooser = new JFileChooser();
		int i = chooser.showSaveDialog(chooser);
		 if (i == JFileChooser.APPROVE_OPTION) {
		  File file = chooser.getSelectedFile();	
		  TableModel model = table.getModel();
		  Workbook workbook = new XSSFWorkbook();
		  Sheet sheet = workbook.createSheet("Nhân sự");
		  Row row;
		  Cell cell;
		  // Lấy dữ liệu từ từng dòng
		  for (int r = 0; r < model.getRowCount(); r++) {
		   row = sheet.createRow(r);
		   for (int c = 0; c < model.getColumnCount(); c++) {
		    cell = row.createCell(c);// ô
		    Object value = model.getValueAt(r, c);
		    if (value instanceof String) {
		     cell.setCellValue((String)value);
		    } else if (value instanceof Double) {
		     cell.setCellValue((Double)value);
		    }
		   }
		  }
		try {
			if(file.exists()) {
				JOptionPane.showMessageDialog(null, "Tên file đã tồn tại!");
				return;
			}
			out = new FileOutputStream(file+".xlsx");
			JOptionPane.showMessageDialog(null, "Lưu file thành công!");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  try {
			workbook.write(out);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  try {
			out.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  try {
			workbook.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 }
	}
	public void loadAllDepartment() {
		 //tạo control DefaultTableModel để hiển thị danh sách user
	 String[] header = { "Mã phòng ban","Tên phòng ban" };
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 table_PB.setModel(dtm);
	 //lấy danh sách DTO (gọi hàm getAll... trong BLL)
	 ArrayList<DepartmentDTO> arr = new ArrayList<DepartmentDTO>();
	 DepartmentBLL departmentBLL = new DepartmentBLL();
	 arr = departmentBLL.getAllDepartment();
	 
	 //Duyệt mảng DTO vừa lấy được: arr
	 DepartmentDTO departmentDTO = new DepartmentDTO();
	 for (int i = 0; i < arr.size(); i++) {
		 departmentDTO = arr.get(i);
		 String MaPB = departmentDTO.getMaPB();
		 String TenPB = departmentDTO.getTenPB();
		 //tạo row để add vào control DefaultTableModel
		 Object[] row = {MaPB,TenPB};
		 dtm.addRow(row);
	 }
	 }
	public ArrayList<String> loadAllDepartmentCombobox() {
		DepartmentBLL departmentBLL= new DepartmentBLL();
		return departmentBLL.getAllDepartmentID(); 
	}
	public void loadAllPosition() {
		String[] header = { "Mã chức vụ","Tên chức vụ" };
		 DefaultTableModel dtm = new DefaultTableModel(header, 0);
		 table_CV.setModel(dtm);
		 //lấy danh sách DTO (gọi hàm getAll... trong BLL)
		 ArrayList<PositionDTO> arr = new ArrayList<PositionDTO>();
		 PositionBLL posBLL= new PositionBLL();
		 arr = posBLL.getAllPosition();
		 
		 //Duyệt mảng DTO vừa lấy được: arr
		 PositionDTO posDTO= new PositionDTO();
		 for (int i = 0; i < arr.size(); i++) {
			 posDTO = arr.get(i);
			 String MaCV = posDTO.getMaCV();
			 String TenCV = posDTO.getTenCV();
			 //tạo row để add vào control DefaultTableModel
			 Object[] row = {MaCV,TenCV};
			 dtm.addRow(row);
		 }
	}
	public ArrayList<String> loadAllPositionCombobox() {
		PositionBLL posBLL= new PositionBLL();
		return posBLL.getAllPositionID();
	}
	public void loadAllSalary() {
		String[] header = { "Mã bậc lương","Số tiền" };
		 DefaultTableModel dtm = new DefaultTableModel(header, 0);
		 table_BL.setModel(dtm);
		 //lấy danh sách DTO (gọi hàm getAll trong BLL)
		 ArrayList<SalaryDTO> arr = new ArrayList<SalaryDTO>();
		 SalaryBLL salaryBLL= new SalaryBLL();
		 arr = salaryBLL.getAllSalary();
		 
		 //Duyệt mảng DTO vừa lấy được: arr
		 SalaryDTO salaryDTO= new SalaryDTO();
		 for (int i = 0; i < arr.size(); i++) {
			 salaryDTO = arr.get(i);
			 String MaBL = salaryDTO.getMaBL();
			 float SoTien = salaryDTO.getSoTien();
			 //tạo row để add vào control DefaultTableModel
			 Object[] row = {MaBL,SoTien};
			 dtm.addRow(row);
		 }
	}
	public ArrayList<String> loadAllSalaryCombobox() {
		SalaryBLL salaryBLL= new SalaryBLL();
		return salaryBLL.getAllSalaryID();
	}
}
