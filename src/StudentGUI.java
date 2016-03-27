import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class StudentGUI {

	private JFrame frame;
	private JTextField txtstudentNumber;
	private JTextField txtstudentName;
	private JTextField txtsubjectMark1;
	private JTextField txtsubjectGrade1;
	private JTextField txtsubjectMark2;
	private JTextField txtsubjectGrade2;
	private JTextField txtsubjectMark3;
	private JTextField txtsubjectGrade3;
	private JTextField txtsubjectMark4;
	private JTextField txtsubjectGrade4;
	private JTextField txtsubjectMark5;
	private JTextField txtsubjectGrade5;
	private JTextField txtoverallMark;
	private JTextField txtoverallGrade;
	private static Grade ActiveStudentGrade = new Grade();
	private static ArrayList<Grade> StudentGrades = new ArrayList<Grade>();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentGUI window = new StudentGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	private boolean verifyMarks() {
		int studentNumber;
		String studentName;
		float subjectMark1;
		float subjectMark2;
		float subjectMark3;
		float subjectMark4;
		float subjectMark5;

		try {
			studentNumber = Integer.parseInt(txtstudentNumber.getText());
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(null, "Invalid Student Used", "Invalid Student Number",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		try {
			studentName = txtstudentName.getText();
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(null, "Invalid Student Name", "Invalid Student Name",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		try {
			subjectMark1 = Float.parseFloat(txtsubjectMark1.getText());
			if (subjectMark1 > 100 || subjectMark1 < 0) {
				JOptionPane.showMessageDialog(null,
						"Please enter a mark of between 0 and 100 for the student's 'Java' course.",
						"Invalid Mark Entered", JOptionPane.ERROR_MESSAGE);
				txtsubjectMark1.setText("");
				txtsubjectMark1.requestFocus();
				return false;
			}
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(null, "Invalid Subject 1 Mark Entered", "Invalid Mark Entered",
					JOptionPane.ERROR_MESSAGE);
			txtsubjectMark1.setText("");
			txtsubjectMark1.requestFocus();
			return false;
		}
		try {
			subjectMark2 = Float.parseFloat(txtsubjectMark2.getText());
			if (subjectMark2 > 100 || subjectMark2 < 0) {
				JOptionPane.showMessageDialog(null,
						"Please enter a mark of between 0 and 100 for the student's 'C++' course.",
						"Invalid Mark Entered", JOptionPane.ERROR_MESSAGE);
				txtsubjectMark2.setText("");
				txtsubjectMark2.requestFocus();
				return false;
			}
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(null, "Invalid Subject 2 Mark Entered", "Invalid Mark Entered",
					JOptionPane.ERROR_MESSAGE);
			txtsubjectMark2.setText("");
			txtsubjectMark2.requestFocus();
			return false;
		}
		try {
			subjectMark3 = Float.parseFloat(txtsubjectMark3.getText());
			if (subjectMark3 > 100 || subjectMark3 < 0) {
				JOptionPane.showMessageDialog(null,
						"Please enter a mark of between 0 and 100 for the student's 'PHP' course.",
						"Invalid Mark Entered", JOptionPane.ERROR_MESSAGE);
				txtsubjectMark3.setText("");
				txtsubjectMark3.requestFocus();
				return false;
			}
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(null, "Invalid Subject 3 Mark Entered", "Invalid Mark Entered",
					JOptionPane.ERROR_MESSAGE);
			txtsubjectMark3.setText("");
			txtsubjectMark3.requestFocus();
			return false;
		}
		try {
			subjectMark4 = Float.parseFloat(txtsubjectMark4.getText());
			if (subjectMark4 > 100 || subjectMark4 < 0) {
				JOptionPane.showMessageDialog(null,
						"Please enter a mark of between 0 and 100 for the student's 'C#' course.",
						"Invalid Mark Entered", JOptionPane.ERROR_MESSAGE);
				txtsubjectMark4.setText("");
				txtsubjectMark4.requestFocus();
				return false;
			}
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(null, "Invalid Subject 4 Mark Entered", "Invalid Mark Entered",
					JOptionPane.ERROR_MESSAGE);
			txtsubjectMark4.setText("");
			txtsubjectMark4.requestFocus();
			return false;
		}
		try {
			subjectMark5 = Float.parseFloat(txtsubjectMark5.getText());
			if (subjectMark5 > 100 || subjectMark5 < 0) {
				JOptionPane.showMessageDialog(null,
						"Please enter a mark of between 0 and 100 for the student's 'Python' course.",
						"Invalid Mark Entered", JOptionPane.ERROR_MESSAGE);
				txtsubjectMark5.setText("");
				txtsubjectMark5.requestFocus();
				return false;
			}
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(null, "Invalid Subject 5 Mark Entered", "Invalid Mark Entered",
					JOptionPane.ERROR_MESSAGE);
			txtsubjectMark5.setText("");
			txtsubjectMark5.requestFocus();
			return false;
		}

		ActiveStudentGrade = new Grade();
		ActiveStudentGrade.setStudentNumber(studentNumber);
		ActiveStudentGrade.setStudentName(studentName);
		ActiveStudentGrade.setSubjectMark1(subjectMark1);
		ActiveStudentGrade.setSubjectMark2(subjectMark2);
		ActiveStudentGrade.setSubjectMark3(subjectMark3);
		ActiveStudentGrade.setSubjectMark4(subjectMark4);
		ActiveStudentGrade.setSubjectMark5(subjectMark5);

		ActiveStudentGrade.calculateGrade();

		txtsubjectGrade1.setText(ActiveStudentGrade.getSubjectGrade1());
		txtsubjectGrade2.setText(ActiveStudentGrade.getSubjectGrade2());
		txtsubjectGrade3.setText(ActiveStudentGrade.getSubjectGrade3());
		txtsubjectGrade4.setText(ActiveStudentGrade.getSubjectGrade4());
		txtsubjectGrade5.setText(ActiveStudentGrade.getSubjectGrade5());

		txtoverallMark.setText(String.format("%-6.2f", ActiveStudentGrade.getOverallMark()));

		txtoverallGrade.setText(ActiveStudentGrade.getOverallGrade());

		return true;

	}

	/**
	 * Create the application.
	 */
	public StudentGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 448, 374);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("IBAT Student Calculater Assignment");

		JLabel lblstudentNumber = new JLabel("Student Number");
		lblstudentNumber.setBounds(50, 38, 112, 14);
		frame.getContentPane().add(lblstudentNumber);

		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setBounds(50, 63, 85, 14);
		frame.getContentPane().add(lblStudentName);
		
		frame.setLocationRelativeTo(null);

		txtstudentNumber = new JTextField();
		txtstudentNumber.setToolTipText("The Student will be saved with the current Student Number");
		txtstudentNumber.setText("2160000");
		txtstudentNumber.setEditable(false);
		txtstudentNumber.setBounds(165, 35, 86, 20);
		frame.getContentPane().add(txtstudentNumber);
		txtstudentNumber.setColumns(10);

		txtstudentName = new JTextField();
		txtstudentName.setToolTipText("Enter Student's Name Here");
		txtstudentName.setBounds(165, 60, 146, 20);
		frame.getContentPane().add(txtstudentName);
		txtstudentName.setColumns(10);

		JLabel lblmarkHeading = new JLabel("Mark");
		lblmarkHeading.setBounds(165, 100, 46, 14);
		frame.getContentPane().add(lblmarkHeading);

		JLabel lblgradeHeading = new JLabel("Grade");
		lblgradeHeading.setBounds(221, 100, 46, 14);
		frame.getContentPane().add(lblgradeHeading);

		JLabel lbljava = new JLabel("Java");
		lbljava.setBounds(50, 128, 46, 14);
		frame.getContentPane().add(lbljava);
		

		txtsubjectMark1 = new JTextField();
		txtsubjectMark1.setToolTipText("Enter Student's " + Grade.subjectTitle1 + " Mark Here");
		txtsubjectMark1.setBounds(165, 125, 46, 20);
		frame.getContentPane().add(txtsubjectMark1);
		txtsubjectMark1.setColumns(10);

		txtsubjectGrade1 = new JTextField();
		txtsubjectGrade1.setEditable(false);
		txtsubjectGrade1.setBounds(221, 125, 46, 20);
		frame.getContentPane().add(txtsubjectGrade1);
		txtsubjectGrade1.setColumns(10);

		JLabel lblcPlusPlus = new JLabel("C++");
		lblcPlusPlus.setBounds(50, 153, 46, 14);
		frame.getContentPane().add(lblcPlusPlus);

		JLabel lblphp = new JLabel("PHP");
		lblphp.setBounds(50, 178, 46, 14);
		frame.getContentPane().add(lblphp);

		JLabel lblcSharp = new JLabel("C#");
		lblcSharp.setBounds(50, 203, 46, 14);
		frame.getContentPane().add(lblcSharp);

		JLabel lblpython = new JLabel("Python");
		lblpython.setBounds(50, 228, 46, 14);
		frame.getContentPane().add(lblpython);

		txtsubjectMark2 = new JTextField();
		txtsubjectMark2.setToolTipText("Enter Student's " + Grade.subjectTitle2 + " Mark Here");
		txtsubjectMark2.setBounds(165, 150, 46, 20);
		frame.getContentPane().add(txtsubjectMark2);
		txtsubjectMark2.setColumns(10);

		txtsubjectGrade2 = new JTextField();
		txtsubjectGrade2.setEditable(false);
		txtsubjectGrade2.setBounds(221, 150, 46, 20);
		frame.getContentPane().add(txtsubjectGrade2);
		txtsubjectGrade2.setColumns(10);

		txtsubjectMark3 = new JTextField();
		txtsubjectMark3.setToolTipText("Enter Student's " + Grade.subjectTitle3 + " Mark Here");
		txtsubjectMark3.setBounds(165, 175, 46, 20);
		frame.getContentPane().add(txtsubjectMark3);
		txtsubjectMark3.setColumns(10);

		txtsubjectGrade3 = new JTextField();
		txtsubjectGrade3.setEditable(false);
		txtsubjectGrade3.setBounds(221, 175, 46, 20);
		frame.getContentPane().add(txtsubjectGrade3);
		txtsubjectGrade3.setColumns(10);

		txtsubjectMark4 = new JTextField();
		txtsubjectMark4.setToolTipText("Enter Student's " + Grade.subjectTitle4 + " Mark Here");
		txtsubjectMark4.setBounds(165, 200, 46, 20);
		frame.getContentPane().add(txtsubjectMark4);
		txtsubjectMark4.setColumns(10);

		txtsubjectGrade4 = new JTextField();
		txtsubjectGrade4.setEditable(false);
		txtsubjectGrade4.setBounds(221, 200, 46, 20);
		frame.getContentPane().add(txtsubjectGrade4);
		txtsubjectGrade4.setColumns(10);

		txtsubjectMark5 = new JTextField();
		txtsubjectMark5.setToolTipText("Enter Student's " + Grade.subjectTitle5 + " Mark Here");
		txtsubjectMark5.setBounds(165, 225, 46, 20);
		frame.getContentPane().add(txtsubjectMark5);
		txtsubjectMark5.setColumns(10);

		txtsubjectGrade5 = new JTextField();
		txtsubjectGrade5.setEditable(false);
		txtsubjectGrade5.setBounds(221, 225, 46, 20);
		frame.getContentPane().add(txtsubjectGrade5);
		txtsubjectGrade5.setColumns(10);

		JLabel lbloverallMark = new JLabel("Overall Mark");
		lbloverallMark.setBounds(50, 269, 85, 14);
		frame.getContentPane().add(lbloverallMark);

		JLabel lbloverallGrade = new JLabel("Overall Grade");
		lbloverallGrade.setBounds(50, 294, 85, 14);
		frame.getContentPane().add(lbloverallGrade);

		JButton btnnewStudent = new JButton("New Student");
		btnnewStudent.setToolTipText("Clear fields and create a new student.");
		btnnewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int studentNumber = ActiveStudentGrade.getNewStudentNumber();
				txtstudentNumber.setText(String.format("%d", studentNumber));

				txtstudentName.setText("");

				txtoverallGrade.setText("");
				txtoverallMark.setText("");

				txtsubjectGrade1.setText("");
				txtsubjectGrade2.setText("");
				txtsubjectGrade3.setText("");
				txtsubjectGrade4.setText("");
				txtsubjectGrade5.setText("");

				txtsubjectMark1.setText("");
				txtsubjectMark2.setText("");
				txtsubjectMark3.setText("");
				txtsubjectMark4.setText("");
				txtsubjectMark5.setText("");

			}
		});
		btnnewStudent.setBounds(301, 110, 112, 23);
		frame.getContentPane().add(btnnewStudent);

		JButton btnsaveStudent = new JButton("Save Student");
		btnsaveStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (verifyMarks() == false)
					return;

				StudentGrades.add(ActiveStudentGrade);

				btnnewStudent.doClick();
			}
		});
		btnsaveStudent.setToolTipText("Save current student.");
		btnsaveStudent.setBounds(301, 144, 112, 23);
		frame.getContentPane().add(btnsaveStudent);

		JButton btncalculate = new JButton("Calculate");
		btncalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (verifyMarks() == false)
					return;
			}
		});
		btncalculate.setToolTipText("Calculate grades.");
		btncalculate.setBounds(301, 203, 112, 23);
		frame.getContentPane().add(btncalculate);

		JButton btnshowallGrades = new JButton("Show All");
		btnshowallGrades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Grade myStudentGrades = new Grade();

				StringBuilder recordStudentGrade = new StringBuilder();
				;

				for (int i = 0; i < StudentGrades.size(); i++) {

					myStudentGrades = StudentGrades.get(i);

					recordStudentGrade.append("######################################").append("\n\n")
							.append("Student Number: ").append(myStudentGrades.getStudentNumber()).append("\n")
							.append("Student Name: ").append("\t").append(myStudentGrades.getStudentName()).append("\n")
							.append("------------------------------------------").append("\n")
							.append(myStudentGrades.subjectTitle1).append("\t\t\t\t\t\t  ")
							.append(String.format("%.0f", myStudentGrades.getSubjectMark1())).append("\t")
							.append(myStudentGrades.getSubjectGrade1()).append("\n")
							.append(myStudentGrades.subjectTitle2).append("\t\t\t\t\t    ")
							.append(String.format("%.0f", myStudentGrades.getSubjectMark2())).append("\t")
							.append(myStudentGrades.getSubjectGrade2()).append("\n")
							.append(myStudentGrades.subjectTitle3).append("\t\t\t\t\t    ")
							.append(String.format("%.0f", myStudentGrades.getSubjectMark3())).append("\t")
							.append(myStudentGrades.getSubjectGrade3()).append("\n")
							.append(myStudentGrades.subjectTitle4).append("\t\t\t\t\t       ")
							.append(String.format("%.0f", myStudentGrades.getSubjectMark4())).append("\t")
							.append(myStudentGrades.getSubjectGrade4()).append("\n")
							.append(myStudentGrades.subjectTitle5).append("\t\t\t\t\t")
							.append(String.format("%.0f", myStudentGrades.getSubjectMark5())).append("\t")
							.append(myStudentGrades.getSubjectGrade5()).append("\n")
							.append("------------------------------------------").append("\n")
							.append("Overall Mark:\t  ").append(String.format("%.2f", myStudentGrades.getOverallMark()))
							.append("\n").append("Overall Grade:\t").append(myStudentGrades.getOverallGrade())
							.append("\n").append("------------------------------------------").append("\n\n");
				}

				JFrame frame = new JFrame("Show All Grades");
				JTextPane textPane = new JTextPane();
				textPane.setEditable(false);
				Font font = new Font("SansSerif", 3, 20);
				textPane.setFont(font);

				JScrollPane scroll = new JScrollPane(textPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
						JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				
				frame.setSize(600, 600);
				frame.getContentPane().add(scroll);
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				
				
				StyledDocument doc = textPane.getStyledDocument();

				SimpleAttributeSet center = new SimpleAttributeSet();
				StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
				doc.setParagraphAttributes(0, doc.getLength(), center, false);

				try {

					doc.insertString(doc.getLength(), recordStudentGrade.toString(), null);
				} catch (Exception e1) {
					System.out.println(e1);
				}

			}
		});
		btnshowallGrades.setToolTipText("Opens new window and displays all saved student information.");
		btnshowallGrades.setBounds(301, 236, 112, 23);
		frame.getContentPane().add(btnshowallGrades);

		txtoverallMark = new JTextField();
		txtoverallMark.setEditable(false);
		txtoverallMark.setBounds(165, 266, 46, 20);
		frame.getContentPane().add(txtoverallMark);
		txtoverallMark.setColumns(10);

		txtoverallGrade = new JTextField();
		txtoverallGrade.setEditable(false);
		txtoverallGrade.setBounds(165, 291, 86, 20);
		frame.getContentPane().add(txtoverallGrade);
		txtoverallGrade.setColumns(10);

		JLabel lblGavinHanna = new JLabel("Gavin Hanna - IBAT Student Number:");
		lblGavinHanna.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblGavinHanna.setBounds(66, 10, 245, 14);
		frame.getContentPane().add(lblGavinHanna);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText("2161407");
		textField.setBounds(309, 9, 54, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

	}
}