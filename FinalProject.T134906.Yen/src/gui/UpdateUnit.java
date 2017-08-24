package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import da.BrandDA;
import da.CategoryDA;
import da.ProductDA;
import da.UnitOfMeasureDA;
import dataobject.Brand;
import dataobject.Category;
import dataobject.Product;
import dataobject.UnitOfMeasure;

public class UpdateUnit extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtDescription;
	
	//private ProductDA productDA;
	private UnitOfMeasureDA unitDA;
	//private BrandDA brandDA;
	//private UnitOfMeasureDA unitDA;
	
	private JButton btnUpdate;
	private JButton btnCancel;

	public int unitID = 1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateUnit frame = new UpdateUnit(1);
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param selectedProductID 
	 */
	public UpdateUnit(int cid) {
		unitID = cid;
		//productDA = new ProductDA();
		unitDA = new UnitOfMeasureDA();
		//brandDA = new BrandDA();
		//unitDA = new UnitOfMeasureDA();
		
		initGUI();
		
		
		UnitOfMeasure c = unitDA.getUnitOfMeasure(unitID);
		txtName.setText(c.getName());
		//txtDescription.setText(c.getCategoryDescription());
		
		
	}

	private void initGUI() {
		setResizable(false);
		setTitle("Update UnitOfMeasure - Yen Ha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 339, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("UnitOfMeasure Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(26, 105, 102, 20);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(138, 107, 173, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		
		
		JLabel lblAddProduct = new JLabel("Update UnitOfMeasure");
		lblAddProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddProduct.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddProduct.setBounds(56, 27, 230, 30);
		contentPane.add(lblAddProduct);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(56, 241, 89, 23);
		contentPane.add(btnUpdate);
		btnUpdate.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(180, 241, 89, 23);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(this);
		//Vector<Category> catList = catDA.getAllCategories();
		//Vector<UnitOfMeasure>unitList = unitDA.getUnitOfMeasure();
		//Vector<Brand> brandList = brandDA.getBrands();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnUpdate){
			updateUnit();
			
			unitDA.getUnitOfMeasure();
			JOptionPane.showMessageDialog(this,"updated completed");
			
			UnitList frame1 = new UnitList();
			frame1.setVisible(true);
		}else if(e.getSource() == btnCancel){
			UpdateUnit.this.dispose();
		}
		
	}

	

	private void updateUnit() {
		String unitName = txtName.getText();
		
		
		unitDA.update(unitName, unitID);
	}
}
