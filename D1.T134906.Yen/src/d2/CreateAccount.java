package d2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.Label;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateAccount extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount frame = new CreateAccount();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreateAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 596);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel addAccountPane = new JPanel();
		addAccountPane.setBackground(Color.LIGHT_GRAY);
		contentPane.add(addAccountPane, "AddAccountPane");
		addAccountPane.setLayout(new BorderLayout(0, 0));
		
		JPanel accountInfoPane = new JPanel();
		accountInfoPane.setBackground(SystemColor.activeCaption);
		addAccountPane.add(accountInfoPane, BorderLayout.CENTER);
		accountInfoPane.setLayout(null);
		
		JLabel lblCreateYourAccount = new JLabel("Create Your Account");
		lblCreateYourAccount.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCreateYourAccount.setBounds(105, 11, 271, 23);
		accountInfoPane.add(lblCreateYourAccount);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFirstName.setBounds(27, 76, 65, 14);
		accountInfoPane.add(lblFirstName);
		
		textField = new JTextField();
		textField.setBounds(26, 101, 169, 20);
		accountInfoPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLastName.setBounds(225, 76, 77, 14);
		accountInfoPane.add(lblLastName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(225, 101, 173, 20);
		accountInfoPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblChooseYourUsername = new JLabel("Choose Your Username");
		lblChooseYourUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblChooseYourUsername.setBounds(26, 132, 169, 14);
		accountInfoPane.add(lblChooseYourUsername);
		
		textField_2 = new JTextField();
		textField_2.setBounds(26, 152, 372, 20);
		accountInfoPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCreateAPassword = new JLabel("Create A Password");
		lblCreateAPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCreateAPassword.setBounds(27, 183, 168, 14);
		accountInfoPane.add(lblCreateAPassword);
		
		JLabel lblConfirmYourPassword = new JLabel("Confirm Your Password");
		lblConfirmYourPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblConfirmYourPassword.setBounds(27, 239, 168, 14);
		accountInfoPane.add(lblConfirmYourPassword);
		
		JLabel lblBirthdayd = new JLabel("Birthday (d/m/y)");
		lblBirthdayd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBirthdayd.setBounds(27, 295, 168, 14);
		accountInfoPane.add(lblBirthdayd);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(27, 208, 371, 20);
		accountInfoPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(27, 264, 371, 20);
		accountInfoPane.add(passwordField_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(27, 320, 98, 20);
		accountInfoPane.add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "Septemper", "October", "November", "December", ""}));
		comboBox.setBounds(145, 320, 98, 20);
		accountInfoPane.add(comboBox);
		
		textField_4 = new JTextField();
		textField_4.setBounds(254, 320, 144, 20);
		accountInfoPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGender.setBounds(27, 351, 98, 14);
		accountInfoPane.add(lblGender);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnMale.setBounds(27, 372, 109, 23);
		rdbtnMale.setOpaque(false);
		accountInfoPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnFemale.setBounds(145, 372, 109, 23);
		rdbtnFemale.setOpaque(false);
		accountInfoPane.add(rdbtnFemale);
		
		JRadioButton rdbtnOther = new JRadioButton("Other");
		rdbtnOther.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnOther.setBounds(289, 372, 109, 23);
		rdbtnOther.setOpaque(false);
		accountInfoPane.add(rdbtnOther);
		
		JLabel lblMobilePhone = new JLabel("Mobile Phone");
		lblMobilePhone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMobilePhone.setBounds(27, 402, 152, 14);
		accountInfoPane.add(lblMobilePhone);
		
		textField_5 = new JTextField();
		textField_5.setBounds(27, 427, 371, 20);
		accountInfoPane.add(textField_5);
		textField_5.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("I agreed with The Tarms of Service");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxNewCheckBox.setBounds(27, 459, 241, 23);
		chckbxNewCheckBox.setOpaque(false);
		accountInfoPane.add(chckbxNewCheckBox);
		
		
		//penel chua nut next
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 503, 424, 50);
		accountInfoPane.add(buttonPane);
		buttonPane.setPreferredSize(new Dimension(100,50));
		buttonPane.setBackground(SystemColor.controlHighlight);
		
		JButton btnNext = new JButton("Next");
		
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonPane.add(btnNext);
		
		Panel panel = new Panel();
		contentPane.add(panel, "name_11093784980480");
		panel.setLayout(null);
		
		JLabel lblWelcome = new JLabel("WelCome");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWelcome.setBounds(184, 100, 134, 14);
		panel.add(lblWelcome);
		
		JLabel lblThanksForCreating = new JLabel("Thanks for creating an Account !");
		lblThanksForCreating.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThanksForCreating.setBounds(121, 397, 227, 14);
		panel.add(lblThanksForCreating);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(CreateAccount.class.getResource("/images/user.png")));
		lblNewLabel.setBounds(104, 142, 247, 239);
		panel.add(lblNewLabel);
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO: kiem tra thong tin hop le
				
				//TODO: luu thong tin vao co so du lieu
				
				//TODO: chuyen den man hinh thong bao thanh cong
				CardLayout cards = (CardLayout)contentPane.getLayout();
				cards.next(contentPane);
				//cards.previous(contentPane);
			}
		});
	}
}
