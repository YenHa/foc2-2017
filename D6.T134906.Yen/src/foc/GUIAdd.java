package foc;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.util.Vector;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIAdd extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private SQLiteDB salesDb ;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIAdd frame = new GUIAdd();
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
	public GUIAdd() {
		salesDb = new SQLiteDB();
		salesDb.getAllProducts();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 417, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD PRODUCT");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(174, 11, 126, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(59, 64, 46, 14);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(160, 61, 159, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCategoryid = new JLabel("Categoryid");
		lblCategoryid.setBounds(59, 103, 91, 14);
		contentPane.add(lblCategoryid);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				Category cat = (Category)comboBox.getSelectedItem();
				System.out.println(cat.getCategoryId()+"-"+cat.getCategoryName());
				
			}
		});
		Vector<Category> catList = salesDb.getAllCategories();
		comboBox.setModel(new DefaultComboBoxModel(catList));
		
		comboBox.setBounds(160, 100, 159, 20);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Price");
		lblNewLabel_1.setBounds(59, 148, 75, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("InStock");
		lblNewLabel_2.setBounds(59, 187, 75, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(160, 145, 159, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(160, 184, 159, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String productName = textField.getText();
				double unitPrice = Double.parseDouble(textField_1.getText());
				int unitInStock = Integer.parseInt(textField_2.getText());
				Category selectCat = (Category)comboBox.getSelectedItem();
				int catId = selectCat.getCategoryId();
				salesDb.insert(productName, catId, unitPrice, unitInStock);
				salesDb.getAllProducts();
			}
		});
		btnNewButton.setBounds(90, 243, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(245, 243, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
