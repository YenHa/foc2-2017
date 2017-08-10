import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 
 */

/**
 * @author Yen Ha
 *
 */
public class MyTextEditor extends JFrame {
	JMenuBar mnbBar;
	JMenu mnuFile, mnuFormat;
	JMenuItem mniOpen, mniExit, mniChangeBgColor, mniChangeFontColor;
	JTextArea txaContent;
	JScrollPane scrPane;

	public MyTextEditor() {
		setTitle("Text Editor");
		setPreferredSize(new Dimension(600, 500));
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		// Goi phuong thuc tao menu
		initializeMenu();
		// Van ban hien thi trong textarea
		txaContent = new JTextArea();
		scrPane = new JScrollPane(txaContent);
		getContentPane().add(scrPane);

		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == mniOpen) {
					openFile();
				} else if (e.getSource() == mniExit) {
					closeApplication();
				} else if (e.getSource() == mniChangeBgColor) {
					changeBGColor();
				} else if (e.getSource() == mniChangeFontColor) {
					changFontColor();
				}

			}
		};
		// Them lang nghe su kien cho cac menu item
		mniOpen.addActionListener(action);
		mniExit.addActionListener(action);
		mniChangeBgColor.addActionListener(action);
		mniChangeFontColor.addActionListener(action);
		// Xu ly su kien dong ung dung
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				closeApplication();
			}
		});

	}

	public void initializeMenu() {
		mnbBar = new JMenuBar();
		mnuFile = new JMenu("File");
		mnuFormat = new JMenu("Format");
		mniOpen = new JMenuItem("Open");
		mniExit = new JMenuItem("Exit");
		mniChangeBgColor = new JMenuItem("Change BG color");
		mniChangeFontColor = new JMenuItem("Change font color");
		// Them menu item vao menu File
		mnuFile.add(mniOpen);
		mnuFile.addSeparator();
		mnuFile.add(mniExit);
		// Them menu item vao menu format
		mnuFormat.add(mniChangeBgColor);
		mnuFormat.add(mniChangeFontColor);
		// Them menu File va menu Format vao MenuBar
		mnbBar.add(mnuFile);
		mnbBar.add(mnuFormat);
		// Thiet lap MenuBar thanh menu chinh cua Frame
		setJMenuBar(mnbBar);

	}

	public void openFile() {
		JFileChooser fchOpenFile = new JFileChooser();
		int result = fchOpenFile.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			try {
				Scanner scn = new Scanner(fchOpenFile.getSelectedFile());
				while (scn.hasNextLine()) {
					txaContent.append(scn.nextLine() + "\n");
				}
				scn.close();
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Selected file is not found");
			}
		}
	}

	public void changeBGColor() {
		Color newColor = JColorChooser.showDialog(this, "Choose new background color", txaContent.getBackground());
		txaContent.setBackground(newColor);
	}

	public void changFontColor() {
		Color newColor = JColorChooser.showDialog(this, "Choose new background color", txaContent.getForeground());
		txaContent.setForeground(newColor);
	}

	public void closeApplication() {
		int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program ?", "Confirm",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (result == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyTextEditor f = new MyTextEditor();
		f.setVisible(true);

	}

}
