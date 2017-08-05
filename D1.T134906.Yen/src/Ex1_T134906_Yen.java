
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class Ex1_T134906_Yen extends JFrame {
	JLabel lblUsername;
	JTextField jtf;
	private JPasswordField txtPassword;
	
	
	//Hàm dựng
	public Ex1_T134906_Yen(){
		getContentPane().setLayout(null);
		//setSize(300, 400);
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setLocation(30, 50);
		lblUsername.setSize(80, 25);
		getContentPane().add(lblUsername);
		JTextField jtf = new JTextField("");
		jtf.setLocation(30, 90);
		jtf.setSize(150, 25);
		getContentPane().add(jtf);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(30, 133, 80, 14);
		getContentPane().add(lblPassword);
		
		JCheckBox chckbxRememberMe = new JCheckBox("Remember Me");
		chckbxRememberMe.setBounds(30, 196, 124, 23);
		getContentPane().add(chckbxRememberMe);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userName = jtf.getText();
				char[] passArray = txtPassword.getPassword();
				String password = new String(passArray);
				if (userName.equals("admin")&& password.equals("root")){
					// JOptionPane.showMessageDialog(Ex1_T134906_Yen.this, "Hello"+userName);
					MainWindow mainGUI = new MainWindow ();
					mainGUI.setVisible(true);
					Ex1_T134906_Yen.this.setVisible(false);
				}else{
					JOptionPane.showMessageDialog(Ex1_T134906_Yen.this, "Fail :(");
				}
				
			}
		});
		btnLogin.setBounds(91, 226, 89, 23);
		getContentPane().add(btnLogin);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLogin.setBounds(105, 11, 65, 14);
		getContentPane().add(lblLogin);
		setLocationRelativeTo(null);
		
		txtPassword = new JPasswordField();
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				txtPassword.setBackground(new Color(153, 255,100));
			}
		});
		txtPassword.setBounds(30, 158, 150, 20);
		getContentPane().add(txtPassword);
	}
	

	public static void main(String[] arg ){
		Ex1_T134906_Yen gui = new Ex1_T134906_Yen();
		gui.setVisible(true);
		gui.setDefaultCloseOperation(
			JFrame.EXIT_ON_CLOSE);
		gui.setSize(400, 300);
	}
}