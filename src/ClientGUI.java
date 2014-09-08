import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;

import java.awt.*;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;
import javax.swing.*;

import java.awt.event.KeyEvent;

import javax.swing.GroupLayout.Alignment;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClientGUI {
	
	final static String PROBLEMS = "PROBLEMS";
	final static String SUBMIT = "SUBMIT";
	final static String LEADERBOARD = "LEADERBOARD";
	final static String RULES = "RULES";
	final static String LOGIN = "LOGIN";

	private JFrame frame;
	/**
	 * @wbp.nonvisual location=239,139
	 */
	private final ImageIcon lblImgMain = new ImageIcon("C:\\Users\\Abhinav\\Downloads\\troaka.jpg");
	private JPanel Panel;
	private JPanel PanelDisplay;
	private JLabel lblProbA;
	private JLabel lblProbB;
	private JLabel lblProbC;
	private JLabel lblProbD;
	private JLabel lblProbE;
	private JLabel lblProbF;
	private JLabel lblProbG;
	private JLabel lblRules;
	private JLabel lblSubmit;
	private JLabel lblLeaderBoard;
	private JTextField Rules;
	private JTextField Problems;
	private JTextField UserID;
	private JScrollPane PaneRules;
	private JScrollPane PaneProblems;
	private JScrollPane PaneLeaderBoard;
	private JPanel PanelSubmit;
	private JPanel PanelLogin;
	private JLabel lblSubmitPane;
	private JLabel lblPassword;
	private JLabel lblTeamName;	
	private JLabel lblLogin;
	private JLabel lblNote1;
	private JLabel lblNote2;
	private JButton btnLoginSubmit;
	private JPasswordField Password;
	private JFileChooser Input;
	/**
	 * @wbp.nonvisual location=112,399
	 */
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientGUI window = new ClientGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClientGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setMinimumSize(new Dimension(1000,500));
		//frame.setPreferredSize(new Dimension(500,1000));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel lblPanelImg = new JPanel();
		FlowLayout flowLayout = (FlowLayout) lblPanelImg.getLayout();
		flowLayout.setVgap(0);
		lblPanelImg.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblPanelImg.setAlignmentY(Component.TOP_ALIGNMENT);
		lblPanelImg.setMinimumSize(new Dimension(100, 170));
		lblPanelImg.setMaximumSize(new Dimension(32767, 170));
		lblPanelImg.setPreferredSize(new Dimension(200, 170));
		lblPanelImg.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(lblPanelImg, BorderLayout.NORTH);
		
		JLabel lblImg = new JLabel();
		lblImg.setAlignmentY(Component.TOP_ALIGNMENT);
		lblPanelImg.add(lblImg);
		lblPanelImg.setSize(new Dimension(lblPanelImg.getSize()));
		lblImg.setOpaque(true);
		lblImg.setIcon(lblImgMain);
		
		JPanel PanelDisplay = new JPanel();
		frame.getContentPane().add(PanelDisplay, BorderLayout.CENTER);
		PanelDisplay.setLayout(new CardLayout(0, 0));
		
		JScrollPane PaneRules = new JScrollPane();
		PanelDisplay.add(PaneRules, RULES);
		
		JTextPane Rules = new JTextPane();
		PaneRules.setViewportView(Rules);
		
		JScrollPane PaneProblems = new JScrollPane();
		PaneProblems.setOpaque(true);
		PanelDisplay.add(PaneProblems, PROBLEMS);
		
		JTextPane Problems = new JTextPane();
		Problems.setEditable(false);
		PaneProblems.setViewportView(Problems);
		
		JScrollPane PaneLeaderBoard = new JScrollPane();
		PanelDisplay.add(PaneLeaderBoard, LEADERBOARD);
		
		JPanel PanelSubmit = new JPanel();
		PanelSubmit.setLayout(null);
		PanelDisplay.add(PanelSubmit, SUBMIT);
		
		JLabel lblSubmitPane = new JLabel("Submit");
		lblSubmitPane.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubmitPane.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSubmitPane.setBounds(10, 32, 1192, 41);
		PanelSubmit.add(lblSubmitPane);
		
		JFileChooser Input = new JFileChooser();
		Input.setBounds(323, 66, 582, 397);
		PanelSubmit.add(Input);
		
		JPanel PanelLogin = new JPanel();
		PanelDisplay.add(PanelLogin, LOGIN);
		PanelLogin.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblLogin.setBounds(10, 32, 1192, 41);
		PanelLogin.add(lblLogin);
		
		JLabel lblTeamName = new JLabel("Team Name");
		lblTeamName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTeamName.setBounds(464, 222, 73, 53);
		PanelLogin.add(lblTeamName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(464, 279, 73, 34);
		PanelLogin.add(lblPassword);
		
		UserID = new JTextField();
		UserID.setBounds(587, 235, 125, 27);
		PanelLogin.add(UserID);
		UserID.setColumns(10);
		
		Password = new JPasswordField();
		Password.setBounds(587, 284, 125, 27);
		PanelLogin.add(Password);
		
		JButton btnLoginSubmit = new JButton("Submit");
		btnLoginSubmit.setBounds(522, 357, 89, 23);
		PanelLogin.add(btnLoginSubmit);
		
		JLabel lblNote1 = new JLabel("Note: If you forget password, contact admins for support.");
		lblNote1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNote1.setBounds(411, 405, 385, 27);
		PanelLogin.add(lblNote1);
		
		JLabel lblNote2 = new JLabel("The Login Team Name and Password should be recieved from Admins and you should only login when you are asked to do so.");
		lblNote2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNote2.setBounds(182, 176, 810, 14);
		PanelLogin.add(lblNote2);
		
		JPanel Panel = new JPanel();
		Panel.setBackground(new Color(255, 250, 205));
		Panel.setMaximumSize(new Dimension(150, 0));
		Panel.setPreferredSize(new Dimension(150, 0));
		Panel.setMinimumSize(new Dimension(100, 100));
		Panel.setBorder(BorderFactory.createLineBorder(new Color(0,0,0),2));
		Panel.setAlignmentY(20);
		Panel.setLayout(new BoxLayout(Panel, BoxLayout.Y_AXIS));
		frame.getContentPane().add(Panel, BorderLayout.WEST);
		
		JLabel lblProbA;
		lblProbA = new JLabel("Problem A");
		lblProbA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowProblem('A');
			}
		});
		lblProbA.setBackground(Color.WHITE);
		lblProbA.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProbA.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblProbA.setForeground(new Color(0,0,255));
		lblProbA.setHorizontalAlignment(SwingConstants.CENTER);
		lblProbA.setMinimumSize(new Dimension(100, 100));
		lblProbA.setMaximumSize(new Dimension(150, 50));
		lblProbA.setBorder(null);
		lblProbA.setSize(new Dimension(50, 70));
		lblProbA.setPreferredSize(new Dimension(150, 0));
		lblProbA.setLocation(new Point(10, 10));		
		Panel.add(lblProbA);

		JLabel lblProbB;
		lblProbB = new JLabel("Problem B");
		lblProbB.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProbB.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblProbB.setForeground(new Color(0,0,255));
		lblProbB.setHorizontalAlignment(SwingConstants.CENTER);
		lblProbB.setMinimumSize(new Dimension(100, 100));
		lblProbB.setMaximumSize(new Dimension(150, 50));
		lblProbB.setBorder(null);
		lblProbB.setSize(new Dimension(50, 70));
		lblProbB.setPreferredSize(new Dimension(150, 0));
		lblProbB.setLocation(new Point(10, 10));		
		Panel.add(lblProbB);
		
		JLabel lblProbC;
		lblProbC = new JLabel("Problem C");
		lblProbC.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProbC.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblProbC.setForeground(new Color(0,0,255));
		lblProbC.setHorizontalAlignment(SwingConstants.CENTER);
		lblProbC.setMinimumSize(new Dimension(100, 100));
		lblProbC.setMaximumSize(new Dimension(150, 50));
		lblProbC.setBorder(null);
		lblProbC.setSize(new Dimension(50, 70));
		lblProbC.setPreferredSize(new Dimension(150, 0));
		lblProbC.setLocation(new Point(10, 10));		
		Panel.add(lblProbC);
		
		JLabel lblProbD;
		lblProbD = new JLabel("Problem D");
		lblProbD.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProbD.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblProbD.setForeground(new Color(0,0,255));
		lblProbD.setHorizontalAlignment(SwingConstants.CENTER);
		lblProbD.setMinimumSize(new Dimension(100, 100));
		lblProbD.setMaximumSize(new Dimension(150, 50));
		lblProbD.setBorder(null);
		lblProbD.setSize(new Dimension(50, 70));
		lblProbD.setPreferredSize(new Dimension(150, 0));
		lblProbD.setLocation(new Point(10, 10));		
		Panel.add(lblProbD);
		
		JLabel lblProbE;
		lblProbE = new JLabel("Problem E");
		lblProbE.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProbE.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblProbE.setForeground(new Color(0,0,255));
		lblProbE.setHorizontalAlignment(SwingConstants.CENTER);
		lblProbE.setMinimumSize(new Dimension(100, 100));
		lblProbE.setMaximumSize(new Dimension(150, 50));
		lblProbE.setBorder(null);
		lblProbE.setSize(new Dimension(50, 70));
		lblProbE.setPreferredSize(new Dimension(150, 0));
		lblProbE.setLocation(new Point(10, 10));		
		Panel.add(lblProbE);
		
		JLabel lblProbF;
		lblProbF = new JLabel("Problem F");
		lblProbF.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProbF.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblProbF.setForeground(new Color(0,0,255));
		lblProbF.setHorizontalAlignment(SwingConstants.CENTER);
		lblProbF.setMinimumSize(new Dimension(100, 100));
		lblProbF.setMaximumSize(new Dimension(150, 50));
		lblProbF.setBorder(null);
		lblProbF.setSize(new Dimension(50, 70));
		lblProbF.setPreferredSize(new Dimension(150, 0));
		lblProbF.setLocation(new Point(10, 10));		
		Panel.add(lblProbF);
		
		JLabel lblProbG;
		lblProbG = new JLabel("Problem G");
		lblProbG.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProbG.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblProbG.setForeground(new Color(0,0,255));
		lblProbG.setHorizontalAlignment(SwingConstants.CENTER);
		lblProbG.setMinimumSize(new Dimension(100, 100));
		lblProbG.setMaximumSize(new Dimension(150, 50));
		lblProbG.setBorder(null);
		lblProbG.setSize(new Dimension(50, 70));
		lblProbG.setPreferredSize(new Dimension(150, 0));
		lblProbG.setLocation(new Point(10, 10));		
		Panel.add(lblProbG);

		JLabel lblSubmit;
		
		JLabel lblRules = new JLabel("Rules");
		lblRules.setSize(new Dimension(50, 70));
		lblRules.setPreferredSize(new Dimension(150, 0));
		lblRules.setMinimumSize(new Dimension(100, 100));
		lblRules.setMaximumSize(new Dimension(150, 50));
		lblRules.setLocation(new Point(10, 10));
		lblRules.setHorizontalAlignment(SwingConstants.CENTER);
		lblRules.setForeground(Color.BLUE);
		lblRules.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRules.setBorder(null);
		Panel.add(lblRules);
		lblSubmit = new JLabel("Submit");
		lblSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSubmit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblSubmit.setForeground(new Color(0,0,255));
		lblSubmit.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubmit.setMinimumSize(new Dimension(100, 100));
		lblSubmit.setMaximumSize(new Dimension(150, 50));
		lblSubmit.setBorder(null);
		lblSubmit.setSize(new Dimension(50, 70));
		lblSubmit.setPreferredSize(new Dimension(150, 0));
		lblSubmit.setLocation(new Point(10, 10));		
		Panel.add(lblSubmit);
		
		JLabel lblLeaderboard;
		lblLeaderboard = new JLabel("LeaderBoard");
		lblLeaderboard.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLeaderboard.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblLeaderboard.setForeground(new Color(0,0,255));
		lblLeaderboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeaderboard.setMinimumSize(new Dimension(100, 100));
		lblLeaderboard.setMaximumSize(new Dimension(150, 50));
		lblLeaderboard.setBorder(null);
		lblLeaderboard.setSize(new Dimension(50, 70));
		lblLeaderboard.setPreferredSize(new Dimension(150, 0));
		lblLeaderboard.setLocation(new Point(10, 10));		
		Panel.add(lblLeaderboard);

		JMenuBar menuBar = new JMenuBar();
		
		JMenu file=new JMenu("File");
		file.setIcon(null);
		file.setMnemonic(KeyEvent.VK_F);
		menuBar.add(file);
		
		JMenu edit=new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		menuBar.add(edit);
		
		JMenuItem close = new JMenuItem("Close");
		file.add(close);

		JMenuItem settings = new JMenuItem("Configeration");
		edit.add(settings);
		
		JMenu credits=new JMenu("Credits");
		credits.setMnemonic(KeyEvent.VK_C);
		menuBar.add(credits);
		frame.setJMenuBar(menuBar);
		
	}

	protected void ShowProblem(char c) {
		
		CardLayout cl = (CardLayout) PanelDisplay.getLayout();
		cl.show(PanelDisplay, PROBLEMS);
		
		
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
