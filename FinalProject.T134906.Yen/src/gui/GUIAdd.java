package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import da.BrandDA;
import da.CategoryDA;
import da.ProductDA;
import da.SQLiteDB;
import da.UnitOfMeasureDA;
import dataobject.Brand;
import dataobject.Category;
import dataobject.UnitOfMeasure;

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

public class GUIAdd extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtName;
	private SQLiteDB foc2warehouse ;
	private JTextField txtPrice;
	private JTextField txtPCode;
	private JLabel lable;
	private ProductDA productDA;
	private CategoryDA catDA;
	private BrandDA brandDA;
	private UnitOfMeasureDA unitOfMeasureDA;
	private JButton btnAdd;
	private JComboBox cboUOMeasure;
	private JComboBox comboBox_2;
	private JComboBox cboCategory;
	private JButton btnCancel;
	

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
		productDA = new ProductDA();
		catDA = new CategoryDA();
		brandDA= new BrandDA();
		unitOfMeasureDA = new UnitOfMeasureDA();
		foc2warehouse = new SQLiteDB();
		foc2warehouse.getAllProducts();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 417, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(34, 108, 46, 14);
		contentPane.add(lblName);
		
		
		
		
		
		txtName = new JTextField();
		txtName.setBounds(160, 105, 208, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblCategoryid = new JLabel("Category");
		lblCategoryid.setBounds(34, 145, 91, 14);
		contentPane.add(lblCategoryid);
		
		cboCategory = new JComboBox();
		cboCategory.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				Category cat = (Category)cboCategory.getSelectedItem();
				System.out.println(cat.getCategoryId()+"-"+cat.getCategoryName());
				
			}
		});
		Vector<Category> catList = foc2warehouse.getAllCategories();
		cboCategory.setModel(new DefaultComboBoxModel(catList));
		
		cboCategory.setBounds(160, 142, 208, 20);
		contentPane.add(cboCategory);
		
		JLabel lblNewLabel_1 = new JLabel("Product Code");
		lblNewLabel_1.setBounds(34, 68, 91, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Unit Price");
		lblNewLabel_2.setBounds(34, 240, 75, 14);
		contentPane.add(lblNewLabel_2);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(160, 237, 208, 20);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		txtPCode = new JTextField();
		txtPCode.setBounds(160, 65, 208, 20);
		contentPane.add(txtPCode);
		txtPCode.setColumns(10);
		
		
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(255, 296, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel labela = new JLabel("Unit Of Measure");
		labela.setBounds(34, 178, 91, 14);
		contentPane.add(labela);
		
		cboUOMeasure = new JComboBox();
		cboUOMeasure.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				UnitOfMeasure unit = (UnitOfMeasure)cboUOMeasure.getSelectedItem();
				System.out.println(unit.getId()+"-"+unit.getName());
			}
			
		});
		Vector<UnitOfMeasure> unitofmeasureList = foc2warehouse.getAllUnitOfMeasures();
		cboUOMeasure.setModel(new DefaultComboBoxModel(unitofmeasureList));
		
		
		
		cboUOMeasure.setBounds(160, 175, 208, 20);
		contentPane.add(cboUOMeasure);
		
		JLabel cboBrand;
		lable = new JLabel("Brand");
		lable.setBounds(34, 214, 46, 14);
		contentPane.add(lable);


		
		comboBox_2 = new JComboBox();
		comboBox_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Brand Bra = (Brand)comboBox_2.getSelectedItem();
			}
		});
		Vector<Brand> BratList = foc2warehouse.getAllBrands();
		comboBox_2.setModel(new DefaultComboBoxModel(BratList));
		
		comboBox_2.setBounds(160, 206, 208, 20);
		contentPane.add(comboBox_2);
		
		JLabel lblAddProduct = new JLabel("ADD PRODUCT");
		lblAddProduct.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAddProduct.setBounds(146, 11, 156, 36);
		contentPane.add(lblAddProduct);
		
		btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnAdd.setBounds(92, 296, 89, 23);
		contentPane.add(btnAdd);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnAdd ){
			addProduct();
		}else if(e.getSource() == btnCancel){
			GUIAdd.this .dispose();
		}
	}

	private void addProduct() {
		String productCode = txtPCode.getText();
		String productName = txtName.getText();
		double unitPrice = Double.parseDouble(txtPrice.getText());
		//int unitInStock = Integer.parseInt(txtPCode.getText());
		Category selectCat = (Category)cboCategory.getSelectedItem();
		int catId = selectCat.getCategoryId();
		UnitOfMeasure selectUnit = (UnitOfMeasure)cboUOMeasure.getSelectedItem();
		int unitId = selectUnit.getId();
		Brand selectBra = (Brand)comboBox_2.getSelectedItem();
		int braId = selectBra.getId();
//	salesDb.insert(productName, catId, unitPrice, unitInStock);
		foc2warehouse.getAllProducts();
	}
}
