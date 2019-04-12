import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Main 
{

	private JFrame loginFrame, fpFrame, stuHomeFrame, parHomeFrame, teaHomeFrame, reviseFrame;
	private JFrame mockTestFrame, mainframe, topicsFrame, homeworkFrame, resultsFrame;
	private JFrame createHomeworkFrame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton loginButton, fpButton, reviseButton, homeworkButton, button, topicsButton, mockTestButton, resultsButton, createAccountButton, createAssignmentButton;
	private JButton quickTestButton, halfTestButton, fullTestButton, backButton;
	private Font font1 = new Font("MS PMincho", Font.BOLD, 32);
	private Font font2 = new Font("MS PMincho", Font.BOLD, 60);
	private Font font3 = new Font("MS PMincho", Font.BOLD, 25);
	private Font tableFont = new Font("MS PMincho", Font.BOLD, 25);

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Main window = new Main();
					window.loginFrame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public Main() 
	{
		initialize();
	}

	
	
	
	private void initialize() 
	{
		Image img = new ImageIcon(this.getClass().getResource("/Login_Screen.png")).getImage();
		loginFrame = new JFrame();
		loginFrame.setResizable(true);
		loginFrame.setVisible(true);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		JLabel label_1 = new JLabel(new ImageIcon(img));
		loginFrame.setContentPane(label_1);
		loginFrame.setLayout(null);
        
		textField = new JTextField();
		textField.setBounds(1400, 500, 450, 70);
		textField.setFont(font1);
		textField.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (textField.getText().length() >= 7) // limit to 3 characters
	                e.consume();
	        }
	    });
		loginFrame.getContentPane().add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(1400, 720, 450, 70);
		passwordField.setFont(font1);
		loginFrame.getContentPane().add(passwordField);
		
		loginButton = makeBtn("Login", 1460, 840, 350, 70);
		loginButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String username = textField.getText();
				validateUser(username, "pas");
			}
		});
		loginFrame.getContentPane().add(loginButton);
		
		fpButton = makeBtn("Forgotten Password", 1460, 940, 350, 70);
		fpButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ForgotPassword();
			}
		});
		loginFrame.getContentPane().add(fpButton);

	}
	
	public void ForgotPassword()
	{
		Image img2 = new ImageIcon(this.getClass().getResource("/fpScreen.png")).getImage();	
		fpFrame = new JFrame();  
		fpFrame.setSize(1300,1000);
		JLabel label_1 = new JLabel(new ImageIcon(img2));
		fpFrame.setContentPane(label_1);
		fpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fpFrame.setResizable(false);
		fpFrame.setVisible(true);
		fpFrame.setTitle("Forgotten Password");
	}
	
	public void validateUser(String username, String password) {
		
		//include database validation
		if(username.contains("Stu")) 
		{		
			runStudent();
			loginFrame.setVisible(false);
		}
		else if(username.contains("Par")) 
		{
			runParent();
			loginFrame.setVisible(false);
		}
		else if(username.contains("Tea"))
		{
			runTeacher();
			loginFrame.setVisible(false);
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "Please enter a valid Username and Password");
		}
		
	}
	
	public void runStudent() 
	{
		stuHomeFrame = initBackground("Welcome Back!", 730, 200);
		reviseButton = makeBtn("REVISE", 760, 400, 350, 70);
		reviseButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				reviseFrame();
				stuHomeFrame.setVisible(false);	
			}
		});
		stuHomeFrame.getContentPane().add(reviseButton);
		
		homeworkButton = makeBtn("HOMEWORK", 760, 550, 350, 70);
		homeworkButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				stuHomeFrame.setVisible(false);
				homeworkFrame();
			}
		});
		stuHomeFrame.getContentPane().add(homeworkButton);
		
		resultsButton = makeBtn("RESULTS", 760, 700, 350, 70);
		resultsButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				stuHomeFrame.setVisible(false);
				resultsFrame(1);
			}
		});
		stuHomeFrame.getContentPane().add(resultsButton);
		
		backButton = makeBtn("<< BACK", 20, 900, 350, 70);
		backButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				initialize();
				stuHomeFrame.setVisible(false);
			}
		});
		stuHomeFrame.getContentPane().add(backButton);
	}
	
	public void runParent() 
	{
		parHomeFrame = initBackground("Welcome Back!", 730, 200);
		resultsButton = makeBtn("RESULTS", 760, 550, 350, 70);
		resultsButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				parHomeFrame.setVisible(false);
				resultsFrame(2);
			}
		});
		parHomeFrame.getContentPane().add(resultsButton);
		backButton = makeBtn("<< BACK", 20, 900, 350, 70);
		backButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				initialize();
				parHomeFrame.setVisible(false);
			}
		});
		parHomeFrame.getContentPane().add(backButton);
	}

	public void runTeacher() 
	{
		teaHomeFrame = initBackground("Welcome Back!",730, 200);
		
		createAssignmentButton = makeBtn("CREATE ASSIGNMENTS", 760, 400, 410, 70);
		createAssignmentButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				teaHomeFrame.setVisible(false);
				createHomeworkFrame();
			}
		});
		teaHomeFrame.getContentPane().add(createAssignmentButton);
		
		resultsButton = makeBtn("RESULTS", 760, 550, 410, 70);
		resultsButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				teaHomeFrame.setVisible(false);
				resultsFrame(3);
			}
		});
		teaHomeFrame.getContentPane().add(resultsButton);
		
		createAccountButton = makeBtn("CREATE ACCOUNTS", 760, 700, 410, 70);
		createAccountButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//ADD CODE HERE
			}
		});
		teaHomeFrame.getContentPane().add(createAccountButton);
		
		backButton = makeBtn("<< BACK", 20, 900, 350, 70);
		backButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				initialize();
				teaHomeFrame.setVisible(false);
			}
		});
		teaHomeFrame.getContentPane().add(backButton);
	}	
	
	public JFrame createHomeworkFrame()
	{
		createHomeworkFrame = initBackground("<html>Create an assignment.<center></html>", 200, 50);
		//Please fill this two list with data from database, below are only datas for testing purpose
		String[] topics = {"Algebra", "Trigonometry", "Calculas", "Matrices"};
		String[] classes = {"2A", "2B", "2C", "3C", "4C"};
		JCheckBox[] topicsCheckBox = new JCheckBox[topics.length];
		JCheckBox[] classesCheckBox = new JCheckBox[classes.length];
		ArrayList<String> topicSelected = new ArrayList<String>();
		ArrayList<String> classSelected = new ArrayList<String>();
		
		
		JLabel topicLabel = makeLbl("<html>What topics would you like to Revise?</html>", 250, 100, 350, 300);
		JLabel numberLabel = makeLbl("<html>How many questions would you like?(less than 20)", 1000, 100, 350, 300);
		JLabel classLabel = makeLbl("<html>Which class do you want to complete the paper?</html>", 1000, 250, 350, 300);

		JScrollPane selectTopic = makeCB(topics, topicSelected, 250, 300, 350, 500);
		JScrollPane selectClass = makeCB(classes, classSelected, 1000, 450, 100, 150);
		
		JTextField tf = new JTextField();
		tf.setBounds(1000, 300, 100, 40);
		tf.setFont(font3);
				
		JButton generate = makeBtn("Generate Question", 1250, 750, 350, 70);
		generate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int noOfQuestions = Integer.parseInt(tf.getText());
				//Add code to create an assignment
				//noOfQuestions, topicsSelected and classesSelcted saved the data you need to create an assignment
			}
		});
		
		
		createHomeworkFrame.getContentPane().add(teaBackButton(createHomeworkFrame));
		createHomeworkFrame.getContentPane().add(classLabel);
		createHomeworkFrame.getContentPane().add(topicLabel);
		createHomeworkFrame.getContentPane().add(numberLabel);
		createHomeworkFrame.getContentPane().add(selectTopic);
		createHomeworkFrame.getContentPane().add(tf);
		createHomeworkFrame.getContentPane().add(selectClass);
		createHomeworkFrame.getContentPane().add(generate);
		return createHomeworkFrame;
	}
	

	public JFrame reviseFrame()
	{
		reviseFrame = initBackground("<html><center>Please select the type of revision you want to do.</html>", 350, 200);
		
		topicsButton = makeBtn("Select Topics", 760, 550, 350, 70);
		topicsButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				topicsFrame();
				reviseFrame.setVisible(false);
			}
		});
		reviseFrame.getContentPane().add(topicsButton);
		
		mockTestButton = makeBtn("Generate Mock Test", 760, 400, 350, 70);
		mockTestButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				mockTestFrame();
				reviseFrame.setVisible(false);
			}
		});
		reviseFrame.getContentPane().add(mockTestButton);
		
		reviseFrame.getContentPane().add(stuBackButton(reviseFrame));
		return reviseFrame;
	}
	public JFrame homeworkFrame()
	{
		homeworkFrame = initBackground("<html><center>Please select the homework you want to complete.</html>", 350, 200);	
		homeworkFrame.getContentPane().add(stuBackButton(homeworkFrame));
		return homeworkFrame;
	}
	public JFrame resultsFrame(int screen)
	{
		resultsFrame = initBackground("<html><center>Your previous results are displayed below.</html>", 350, 200);	
		JScrollPane results;
		String[][] data;
		String[] column;
		/* 
		 * Add data from the database to and the column names of it to 'data' and 'column' in order to display it it table form 
		 * Example is shown in the teacher's frame, uncomment the code below to show table in teacher's result frame
		 */
		if (screen == 1)
		{
			resultsFrame.getContentPane().add(stuBackButton(resultsFrame));
			results = makeTable(data, column, 500, 400, 900, 500);
			resultsFrame.getContentPane().add(results);
		}
		if (screen == 2)
		{
			resultsFrame.getContentPane().add(parBackButton(resultsFrame));
			results = makeTable(data, column, 500, 400, 900, 500);
			resultsFrame.getContentPane().add(results);
		}
		if (screen == 3)
		{
			resultsFrame.getContentPane().add(teaBackButton(resultsFrame));
			
			/*String[][] data = {
					{"Jason Blake", "25/02/19", "20/60"}
			};
			String[] column = {"Name", "Submitted", "Mark"};*/
			results = makeTable(data, column, 500, 400, 900, 500);
			resultsFrame.getContentPane().add(results);
		}
		return resultsFrame;
	}
	public JScrollPane makeTable(String[][] data, String[] column, int x, int y, int l, int w)
	{
		JTable table = new JTable(data, column);
		table.setFont(tableFont);
		table.getTableHeader().setFont(font1);
		table.setRowHeight(30);
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(x, y, l, w);
		return sp;
	}
	public JFrame topicsFrame()
	{
		topicsFrame = initBackground("Select topics.",500, 200);
		topicsFrame.getContentPane().add(stuReviseBackButton(topicsFrame));

		return topicsFrame;
	}
	public JFrame mockTestFrame()
	{
		mockTestFrame = initBackground("Select type of test you want to do.",500, 200);
		quickTestButton = makeBtn("QUICK TEST", 760, 400, 410, 70);
		quickTestButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//ADD CODE HERE
			}
		});
		mockTestFrame.getContentPane().add(quickTestButton);
		
		halfTestButton = makeBtn("HALF TEST", 760, 550, 410, 70);
		halfTestButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//ADD CODE HERE
			}
		});
		mockTestFrame.getContentPane().add(halfTestButton);
		
		fullTestButton = makeBtn("FULL TEST", 760, 700, 410, 70);
		fullTestButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//ADD CODE HERE
			}
		});
		mockTestFrame.getContentPane().add(fullTestButton);
		mockTestFrame.getContentPane().add(stuReviseBackButton(mockTestFrame));
		return mockTestFrame;
	}
	
	public JButton makeBtn(String text, int x, int y, int l, int w)
	{
		button = new JButton();
		button.setBounds(x, y, l, w); //standard l and w is 350 and 70
		button.setFont(font1);
		button.setText(text);
		return button;
	}
	public JLabel makeLbl(String txt, int x, int y, int l, int w)
	{
		JLabel label = new JLabel(txt);
		label.setBounds(x, y, l, w);
		label.setFont(font3);
		label.setForeground(Color.white);
		return label;
	}
	
	public JScrollPane makeCB(String[] checkboxTitle, ArrayList<String> checkedItem, int x, int y, int l, int w)
	{
		JPanel panel = new JPanel();
		JScrollPane sp = new JScrollPane(panel);
		panel.setOpaque(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		for(int i = 0; i < checkboxTitle.length; i ++) {
			final String checkboxLbl = checkboxTitle[i];
			JCheckBox checkbox = new JCheckBox(checkboxLbl);
			checkbox.setFont(font3);
			checkbox.setHorizontalTextPosition(SwingConstants.LEFT);
			checkbox.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange() == 1) {
						checkedItem.add(checkboxLbl);
					}else {
						checkedItem.remove(checkboxLbl);
					}
				}
			});
			panel.add(checkbox);
		}
		sp.setBounds(x, y, l, w);
		return sp;
	}

	public JFrame initBackground(String text, int x, int y)
	{
		mainframe = new JFrame();  
		Image img3 = new ImageIcon(this.getClass().getResource(getImage())).getImage();	
		JLabel label_1 = new JLabel(new ImageIcon(img3));
		mainframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.setResizable(true);
		mainframe.setVisible(true);
		mainframe.setContentPane(label_1);
		mainframe.setTitle("RevisR");
		mainframe.setLayout(null);
		JLabel welcome = new JLabel();
		welcome.setBounds(x, y, 1200, 150);
		welcome.setFont(font2);
		welcome.setBackground(Color.black);
		welcome.setForeground(Color.white);
		welcome.setText(text);
		mainframe.getContentPane().add(welcome);
		return mainframe;
	}
	public String getImage()
	{
		int random = (int )(Math.random() * 2 + 1);
		String image;
		if (random == 1)
		{
			image = "/giffy.gif";
		}
		else
		{
			image = "/pencils.gif";
		}
		return 	image;
	}

	public JButton stuBackButton(JFrame current)
	{
		backButton = makeBtn("<< BACK", 20, 900, 350, 70);
		backButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				runStudent();
				current.setVisible(false);
			}
		});
		return backButton;
	}
	public JButton stuReviseBackButton(JFrame current)
	{
		backButton = makeBtn("<< BACK", 20, 900, 350, 70);
		backButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				reviseFrame();
				current.setVisible(false);
			}
		});
		return backButton;
	}
	
	public JButton teaBackButton(JFrame current)
	{
		backButton = makeBtn("<< BACK", 20, 900, 350, 70);
		backButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				runTeacher();
				current.setVisible(false);
			}
		});
		return backButton;
	}
	public JButton parBackButton(JFrame current)
	{
		backButton = makeBtn("<< BACK", 20, 900, 350, 70);
		backButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				runParent();
				current.setVisible(false);
			}
		});
		return backButton;
	}
}
