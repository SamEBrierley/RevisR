import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Main 
{

	private JFrame loginFrame, fpFrame, stuHomeFrame, parHomeFrame, teaHomeFrame, reviseFrame, mockTestFrame, mainframe, topicsFrame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton loginButton, fpButton, reviseButton, homeworkButton, button, topicsButton, mockTestButton, resultsButton, createAccountButton, createAssignmentButton;
	private JButton quickTestButton, halfTestButton, fullTestButton;
	private Font font1 = new Font("MS PMincho", Font.BOLD, 32);
	private Font font2 = new Font("MS PMincho", Font.BOLD, 60);
	private Image img3 = new ImageIcon(this.getClass().getResource("/giffy.gif")).getImage();	

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					System.out.println("STARTING REVISR");
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
		loginFrame.setResizable(false);
		loginFrame.setVisible(true);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		JLabel label_1 = new JLabel(new ImageIcon(img));
		loginFrame.setContentPane(label_1);
		loginFrame.setLayout(null);
        
		textField = new JTextField();
		textField.setBounds(1400, 500, 450, 70);
		textField.setFont(font1);
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
				fpButton.setEnabled(false);
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
				stuHomeFrame.setVisible(false);
				reviseFrame();
			}
		});
		stuHomeFrame.getContentPane().add(reviseButton);
		
		homeworkButton = makeBtn("HOMEWORK", 760, 550, 350, 70);
		homeworkButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//ADD CODE HERE
			}
		});
		stuHomeFrame.getContentPane().add(homeworkButton);
		
		resultsButton = makeBtn("RESULTS", 760, 700, 350, 70);
		resultsButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//ADD CODE HERE
			}
		});
		stuHomeFrame.getContentPane().add(resultsButton);
	}
	
	public void runParent() 
	{
		parHomeFrame = initBackground("Welcome Back!", 730, 200);
		resultsButton = makeBtn("RESULTS", 760, 550, 350, 70);
		resultsButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//ADD CODE HERE
			}
		});
		parHomeFrame.getContentPane().add(resultsButton);
	}

	public void runTeacher() 
	{
		teaHomeFrame = initBackground("Welcome Back!",730, 200);
		
		createAssignmentButton = makeBtn("CREATE ASSIGNMENTS", 760, 400, 410, 70);
		createAssignmentButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//ADD CODE HERE
			}
		});
		teaHomeFrame.getContentPane().add(createAssignmentButton);
		
		resultsButton = makeBtn("RESULTS", 760, 550, 410, 70);
		resultsButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//ADD CODE HERE
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
		return reviseFrame;
	}
	public JFrame topicsFrame()
	{
		topicsFrame = initBackground("Select topics.",500, 200);
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
	
	public JFrame initBackground(String text, int x, int y)
	{
		mainframe = new JFrame();  
		JLabel label_1 = new JLabel(new ImageIcon(img3));
		mainframe.setContentPane(label_1);
		mainframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.setResizable(true);
		mainframe.setVisible(true);
		mainframe.setLayout(null);
		mainframe.setTitle("RevisR");
		JLabel welcome = new JLabel();
		welcome.setBounds(x, y, 1200, 150);
		welcome.setFont(font2);
		welcome.setBackground(Color.black);
		welcome.setForeground(Color.white);
		welcome.setText(text);
		mainframe.getContentPane().add(welcome);
		return mainframe;
	}

}
