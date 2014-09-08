package org.eclipse.wb.swing;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;

import java.awt.*;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

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

import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleConstants.ParagraphConstants;
import javax.swing.text.StyledDocument;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.io.*;
import java.net.*;

import org.apache.commons.io.*;
//import JudgeApplication.

class tableData
{
	public int category;
	public String Password;
	public String teamName;
	public int successful;
	public int[] score = new int[7];
	public int[] attempt = new int[7];
	public int[] totalAttempt = new int[7];
	public int time;
	public boolean loggedIn;

	tableData()
	{
		category=1;
		teamName="test";
		Password="";
		for(int i=0;i<7;i++)
		{
			score[i]=0;
			attempt[i]=0;
			totalAttempt[i]=0;
		}
		successful=0;
		time=0;
		loggedIn=false;
		
	}
	
	tableData(tableData temp)
	{
		category=temp.category;
		teamName=temp.teamName;
		Password="";
		for(int i=0;i<7;i++)
		{
			score[i]=temp.score[i];
			attempt[i]=temp.attempt[i];
		}
		successful=temp.successful;
		time=temp.time;
		loggedIn=temp.loggedIn;
	}
	
	@Override
	public String toString(){
		String str = "";
		
		str = String.valueOf(category) + " " + "-" + " " + teamName + " " + String.valueOf(successful) + " " ;
		for(int i=0;i<7;i++)
		{
			str = str + String.valueOf(score[i]) + " " + String.valueOf(attempt[i]) + " " + String.valueOf(totalAttempt[i]) + " ";
		}
		
		str= str + String.valueOf(time) + " " + String.valueOf(loggedIn);
		
		return str;
	}
	
	public tableData(String str)
	{
		String token[] = str.split(" ");

		int cnt=0;
		
		category = Integer.parseInt(token[cnt++]);
		Password = token[cnt++];
		teamName = token[cnt++];
		successful = Integer.parseInt(token[cnt++]);
		
		for(int i=0;i<7;i++)
		{
			score[i] = Integer.parseInt(token[cnt++]);
			attempt[i] = Integer.parseInt(token[cnt++]);
			totalAttempt[i] = Integer.parseInt(token[cnt++]);
		}
		
		time = Integer.parseInt(token[cnt++]);
		loggedIn = Boolean.getBoolean(token[cnt++]);
	}
};

public class ServerGUI {
	
	
	final static int MAX_TIME = 3600*3;
	final static String PATH = "E:" + File.separator + "Bytes2014" + File.separator + "Submissions";
	final static String INPUTPATH = "E:\\Bytes2014\\Inputs\\";
	final static String OUTPUTPATH = "E:\\Bytes2014\\Outputs\\";
	final static String TEAMNAME = "Team Name";
	final static String CATEGORY = "Category";
	final static String TIME = "Time";
	final static String PROBLEMA = "Problem A";
	final static String PROBLEMB = "Problem B";
	final static String PROBLEMC = "Problem C";
	final static String PROBLEMD = "Problem D";
	final static String PROBLEME = "Problem E";
	final static String PROBLEMF = "Problem F";
	final static String PROBLEMG = "Problem G";
	final static String DONE = "Successful Submission";
	
	final static String PROBLEMS = "PROBLEMS";
	final static String CREATELOGIN = "CREATELOGIN";
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
	private JLabel lblCreateLogin;
	private JLabel lblLeaderBoard;
	private JTextPane Rules;
	private JTextPane Problems;
	private JTextField UserID;
	private JScrollPane PaneRules;
	private JScrollPane PaneProblems;
	private JScrollPane PaneLeaderBoard;
	private JPanel PanelLogin;
	private JLabel lblPassword;
	private JLabel lblTeamName;	
	private JLabel lblLogin;
	private JLabel lblNote1;
	private JLabel lblNote2;
	private JLabel lblImg;
	private	JPanel lblPanelImg;
	private JButton btnLoginSubmit;
	private JPasswordField Password;
	private JFileChooser Input;
	private JMenuBar menuBar;
	private JMenu file;
	private JMenuItem edit;
	private JTable table;
	private JTextField IPServer;
	private JTextField addTime;
	private static JTextField PortServerSubmit;	
	private static JTextField PortServerProblem;
	private JTextArea txtrProblemName;
	private JTextArea txtrProblemDescription;
	private JTextArea txtrInputFormat;
	private JTextArea txtrOutputFormat;
	private JTextArea txtrSampleInput;
	private JTextArea txtrSampleOutput;
	private JTextArea txtrConstraintsDescription;
	private JButton btnSaveData;
	private JTextArea txtrRules;
	private JButton btnSaveRules;
	private JButton btnSaveLeaderBoard;
	private JButton btnCreateLogin; 
	private JPanel panel_1 ;
	private JPanel panel;
	private JTable tableCreateLogin;
	private JScrollPane PaneCreateLogin;
	private JButton btnSave;
	
	private static Vector<tableData> board = new Vector<tableData>();
	private static String[] ProbDesc;
	private static String[] InputFormat;
	private static String[] OutputFormat;
	private static String[] SampleInput;
	private static String[] SampleOutput;
	private static String[] Constraints;
	private static String[] ProbName;
	private static String RulesStr;
	private static int selectedProblem;
	private static int Time;
	private static boolean isStarted;
	private JButton button;
	private static JLabel lblTimeRemaining;
	private static int TotTime;
	/**
	 * @wbp.nonvisual location=112,399
	 */
	

	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						ServerGUI window = new ServerGUI();
						window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}	
		});
	}


	protected static Object reduceTime() {

		if(isStarted)
		{
			Time--;
			int min=Time/60;
			int sec=Time%60;
			
			if(Time>60)
				lblTimeRemaining.setText("Time Remaining: "+ String.valueOf(min) + "min " +  String.valueOf(sec) + "sec");
			else
				lblTimeRemaining.setText("Time Remaining: "+ String.valueOf(Time) + "sec");

		}
		

		try {
			
		    Thread.sleep(1000);

		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}	
	    
		return reduceTime();
	    
	}


	/**
	 * @throws IOException 
	 * @throws NumberFormatException 
	 * @wbp.parser.entryPoint
	 */
	static void giveProblemSet() throws NumberFormatException, IOException {
		ServerSocket skt1= new ServerSocket(Integer.parseInt(PortServerProblem.getText()));		
		
		while(true)
		{
			try{
				
				System.out.print(PortServerProblem.getText());
				System.out.print(PortServerProblem.getText());
				Socket server = skt1.accept();
	            DataInputStream in = new DataInputStream(server.getInputStream());
	            
	            String msg = in.readUTF();
	            System.out.println(msg);
	            
	            DataOutputStream out =  new DataOutputStream(server.getOutputStream());

	            if(isStarted==true && msg.charAt(0)=='P' && msg.length() >=3 && Time>0)
	            {
	            	if((int)(msg.charAt(1)-'A')>=0 && (int)(msg.charAt(1)-'A')<=7 )
	            	{
	            	
	            		if((msg.charAt(2)-'0')==1)
	            		{
	            			out.writeUTF(ProbName[(int)(msg.charAt(1)-'A')]);
	            			out.writeInt(Time);
	            			server.close();
	            			continue;
	            		}
	            		
	            		else if((msg.charAt(2)-'0')==2)
	            		{
	            			out.writeUTF(ProbDesc[(int)(msg.charAt(1)-'A')]);
	            			out.writeInt(Time);
	            			server.close();
	            			continue;
	            		}
	            		
	            		else if((msg.charAt(2)-'0')==3)
	            		{
	            			out.writeUTF(InputFormat[(int)(msg.charAt(1)-'A')]);
	            			out.writeInt(Time);
	            			server.close();
	            			continue;
	            		}
	            		
	            		if((msg.charAt(2)-'0')==4)
	            		{
	            			out.writeUTF(OutputFormat[(int)(msg.charAt(1)-'A')]);
	            			out.writeInt(Time);
	            			server.close();
	            			continue;
	            		}
	            		
	            		else if((msg.charAt(2)-'0')==5)
	            		{
	            			out.writeUTF(SampleInput[(int)(msg.charAt(1)-'A')]);
	            			out.writeInt(Time);
	            			server.close();
	            			continue;
	            		}
	            		
	            		else if((msg.charAt(2)-'0')==6)
	            		{
	            			out.writeUTF(SampleOutput[(int)(msg.charAt(1)-'A')]);
	            			out.writeInt(Time);
	            			server.close();
	            			continue;
	            		}
	            		
	            		else if((msg.charAt(2)-'0')==7)
	            		{
	            			out.writeUTF(Constraints[(int)(msg.charAt(1)-'A')]);
	            			out.writeInt(Time);
	            			server.close();
	            			continue;
	            		}
	            		else
	            		{
	            			out.writeUTF("NULL, Error code #0x9001");
	            			out.writeInt(Time);
	            			server.close();
	            			continue;
		            		
	            		}
	            	}
	            	else
	            	{
            			out.writeUTF("NULL, Error code #0x9000");
            			out.writeInt(Time);
            			server.close();
            			continue;
	            		
	            	}
	            }
	            
	            else if(msg.charAt(0)=='P')
	            {
        			out.writeUTF("NULL, Contest not started!");
        			out.writeInt(Time);
        			server.close();
        			continue;
	            }
	            
	            if(msg.charAt(0)=='R')
	            {
        			out.writeUTF(RulesStr);
        			out.writeInt(Time);
        			server.close();
        			continue;
	            }

	            if(msg.charAt(0)=='B')
	            {
	            	out.writeUTF(String.valueOf(board.size()));
	            	
	            	System.out.println(String.valueOf(board.size()));
    	            
	            	for(int i=0;i<board.size();i++)
	            	{
	    	            out.writeUTF(board.elementAt(i).toString());
	            	}
        			out.writeInt(Time);
	            	server.close();
            		continue;
	            }
	            
	            if(msg.charAt(0)=='L')
	            {
		            String User = in.readUTF();
		            String Pwd = in.readUTF();
		            int flag=0;
		            
	            	for(int i=0;i<board.size();i++)
	            	{
	            		if(board.elementAt(i).teamName.equals(User) && board.elementAt(i).Password.equals(Pwd))
	            		{
	            			out.writeUTF("Successful Login!");
	            			out.writeBoolean(true);
	                		server.close();
	                		flag=1;
	                		break;
	            		}
	            	}
	            	
	            	if(flag==1)
	            		continue;
	            	
        			out.writeUTF("Login credentials do not match. Try again!");	            	
        			out.writeBoolean(false);;
        			server.close();
	            }
	            
	         }catch(IOException e)
	         {
	            e.printStackTrace();
	            break;
	         }
		}
	}
		
		/**
		 * @wbp.parser.entryPoint
		 */
		static void acceptSolutions() {

		while(isStarted==false)
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		
		
		
		ServerSocket submitSolution;
		try {
			submitSolution = new ServerSocket(Integer.parseInt(PortServerSubmit.getText()));
			while(Time>0 && isStarted==true)
			{
				Socket socket = submitSolution.accept();
				try{  
					
					DataInputStream dis = new DataInputStream(socket.getInputStream());
					DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

					String str=(String)dis.readUTF();  
					System.out.println("message= " + str);  

					final int code;
					
					if(str.length()>=2)
						if(str.charAt(0)=='S')
						{
							code = (Integer) (str.charAt(1)-'A');
							
							String teamName = dis.readUTF();
							System.out.println("teamName= " + teamName);  							
							int ind=0;
							for(;ind<board.size();ind++)
							{
								if(board.elementAt(ind).teamName.equals(teamName))
									break;
							}								
							
							final int ind_cpy = ind;
							
						    board.elementAt(ind).totalAttempt[code]=board.elementAt(ind).totalAttempt[code]+1;
							
							System.out.println(String.valueOf(ind) + ":" + String.valueOf(board.size()));  							
						    String path = PATH + teamName + "\\Problem " + String.valueOf(((char)(code+'A')));
						    final String path1 = path + "\\Code" + String.valueOf(board.elementAt(ind).totalAttempt[code]);
						    final String inputPath1 = INPUTPATH + "\\Problem " + String.valueOf(((char)(code+'A'))) ;
						    String outputPath1 = OUTPUTPATH + "\\Problem " + String.valueOf(((char)(code+'A'))) ;

						    
						    File transferPath = new File(path);
						    File transferFile = new File(path1 + ".cpp");
						    File inputPath = new File(inputPath1);
						    File outputPath = new File(outputPath1);
						    File outputFile = new File(outputPath1 + "\\Output.cpp");

						    
						    transferPath.mkdirs();
						    transferFile.createNewFile(); 
						    
						    inputPath.mkdirs();
						    outputPath.mkdirs();
						    
						    FileOutputStream fos = new FileOutputStream(transferFile);
							int res = IOUtils.copy(dis, fos);
						    fos.close();
						
							System.out.println("Data Written! ");
						    System.out.println("Data Flushed! ");
						  
						    if(ind==board.size())
							{
						    	//TODO add data
						    	socket.close();
						    	
								continue;
							}
 
						    System.out.println("Done");
						    
						    dos.close();
							socket.close();
						    
							Process process = Runtime.getRuntime().exec( "cmd /c cd C:"+ File.separator + "MinGW" + File.separator + "bin && g++ " + "-o " + path1 + ".exe " + path1 + ".cpp");
							InputStream stderr = process.getInputStream();
						    InputStreamReader isr = new InputStreamReader(stderr);
						    BufferedReader br = new BufferedReader(isr);
						    String line = "";

						    while ((line = br.readLine()) != null) {
						    
						    	//dos.writeUTF("Compilation Error");
						    	//dos.writeInt(Time);						    	
						    	board.elementAt(ind).attempt[code]++;
						    
						    	//Compilation Error
						    	
						    	continue;
						    }
						    
						    process.waitFor();

						    class Task implements Callable<String>{
						        @Override
						        public String call() throws Exception {

//						        	ProcessBuilder pb = new ProcessBuilder("\"" + path1 + ".exe\" < \"" + inputPath1 + "Input.cpp\" > \"" + path1 + ".txt\"");
//						    		pb.redirectErrorStream(true);

//						    		Process process = pb.start();

						        	Process process = Runtime.getRuntime().exec( "cmd /c cd C:"+ File.separator + "MinGW" + File.separator + "bin && \"" + path1 + ".exe\" < \"" + inputPath1 + "\\Input.txt\" > \"" + path1 + ".txt\"");
						        	
						        	InputStream stderr = process.getInputStream();
						    	    InputStreamReader isr = new InputStreamReader(stderr);
						    	    BufferedReader br = new BufferedReader(isr);
						    	    String line = "";

						    	    while ((line = br.readLine()) != null) {
						    	    	board.elementAt(ind_cpy).attempt[code]++;

						    	    	//Runtime error
						    	    }
						    	    return "";
						        }
						    }
					        
						    
						    ExecutorService executor = Executors.newSingleThreadExecutor();
					        Future<String> future = executor.submit(new Task());

					        try {
					            System.out.println("Started..");
					            System.out.println(future.get(505, TimeUnit.MILLISECONDS));
					            System.out.println("Finished!");
					        } catch (TimeoutException e) {
					            System.out.println("Terminated!");
				    	    	
					            board.elementAt(ind).attempt[code]++;
				    	    	board.elementAt(ind).totalAttempt[code]++;
				    	    	
				    	    	//TLE
					        }

					        executor.shutdownNow();
					        
					        if(CompareFile("\"" + path1 + ".txt\"","\"" + outputPath1 + "\\Output.cpp \""))
					        {
					        	if(board.elementAt(ind).score[code]==0)
					        	{
					        		board.elementAt(ind).score[code]=TotTime-Time + 1200 * board.elementAt(ind).attempt[code];
					        		board.elementAt(ind).successful++;
					        		board.elementAt(ind).time+=board.elementAt(ind).score[code];
					        		
					        		//Accepted
					        	}
					        	
					        	else
					        	{
					    	    	board.elementAt(ind).attempt[code]++;
					        		//WA
					        	}
					        }
						    continue;
						}
				}catch(Exception e){
				e.printStackTrace();
			}  
			
		}  
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
	}

	private static boolean CompareFile(String string, String string2) {
			// TODO Auto-generated method stub
			return false;
		}


	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public ServerGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setMinimumSize(new Dimension(1000,500));
		//frame.setPreferredSize(new Dimension(500,1000));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		JPanel lblPanelImg;
		lblPanelImg = new JPanel();
		FlowLayout flowLayout = (FlowLayout) lblPanelImg.getLayout();
		flowLayout.setVgap(0);
		lblPanelImg.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblPanelImg.setAlignmentY(Component.TOP_ALIGNMENT);
		lblPanelImg.setMinimumSize(new Dimension(100, 170));
		lblPanelImg.setMaximumSize(new Dimension(32767, 170));
		lblPanelImg.setPreferredSize(new Dimension(200, 170));
		lblPanelImg.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(lblPanelImg, BorderLayout.NORTH);
		
//		JLabel lblImg;		
		lblImg = new JLabel();
		lblImg.setAlignmentY(Component.TOP_ALIGNMENT);
		lblPanelImg.add(lblImg);
		lblPanelImg.setSize(new Dimension(lblPanelImg.getSize()));
		lblImg.setOpaque(true);
		lblImg.setIcon(lblImgMain);
		
//		JPanel PanelDisplay;
		PanelDisplay = new JPanel();
		frame.getContentPane().add(PanelDisplay, BorderLayout.CENTER);
		PanelDisplay.setLayout(new CardLayout(0, 0));
		
//		JScrollPane PaneProblems;
		PaneProblems = new JScrollPane();
		PaneProblems.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		PaneProblems.setOpaque(true);
		PanelDisplay.add(PaneProblems, PROBLEMS);
		
//		JTextPane Problems;
		Problems = new JTextPane();
		Problems.setEditable(false);
		Problems.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 15));
		PaneProblems.setViewportView(Problems);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(600, 10));
		panel.setMinimumSize(new Dimension(300, 10));
		PaneProblems.setRowHeaderView(panel);
		panel.setLayout(null);
		
		txtrProblemName = new JTextArea();
		txtrProblemName.setText("Problem Name");
		txtrProblemName.setBounds(10, 0, 580, 22);
		panel.add(txtrProblemName);
		
		txtrInputFormat = new JTextArea();
		txtrInputFormat.setWrapStyleWord(true);
		txtrInputFormat.setText("Input Format");
		txtrInputFormat.setBounds(10, 130, 580, 74);
		panel.add(txtrInputFormat);
		
		txtrProblemDescription = new JTextArea();
		txtrProblemDescription.setText("Problem Description");
		txtrProblemDescription.setBounds(10, 21, 580, 108);
		panel.add(txtrProblemDescription);
		
		txtrOutputFormat = new JTextArea();
		txtrOutputFormat.setText("Output Format");
		txtrOutputFormat.setBounds(10, 201, 580, 74);
		panel.add(txtrOutputFormat);
		
		txtrSampleInput = new JTextArea();
		txtrSampleInput.setText("Sample Input");
		txtrSampleInput.setBounds(10, 274, 580, 74);
		panel.add(txtrSampleInput);
		
		txtrSampleOutput = new JTextArea();
		txtrSampleOutput.setText("Sample Output");
		txtrSampleOutput.setBounds(10, 346, 580, 74);
		panel.add(txtrSampleOutput);
		
		txtrConstraintsDescription = new JTextArea();
		txtrConstraintsDescription.setText("Constraints Descriptiom");
		txtrConstraintsDescription.setBounds(10, 418, 580, 64);
		panel.add(txtrConstraintsDescription);
		
		btnSaveData = new JButton("Save Data");
		btnSaveData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveChanges();
			}
		});
		btnSaveData.setBounds(241, 479, 89, 22);
		panel.add(btnSaveData);
		
//		JScrollPane PaneRules;
		PaneRules = new JScrollPane();
		PanelDisplay.add(PaneRules, RULES);
		
//		JTextPane Rules;
		Rules = new JTextPane();
		Rules.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 15));
		Rules.setEditable(false);
		PaneRules.setViewportView(Rules);
		
		panel_1 = new JPanel();
		panel_1.setMinimumSize(new Dimension(600, 10));
		panel_1.setPreferredSize(new Dimension(600, 10));
		PaneRules.setRowHeaderView(panel_1);
		panel_1.setLayout(null);
		
		txtrRules = new JTextArea();
		txtrRules.setBounds(10, 5, 580, 445);
		txtrRules.setText("");
		panel_1.add(txtrRules);
		
		btnSaveRules = new JButton("Save ");
		btnSaveRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RulesStr = txtrRules.getText(); 
			}
		});
		btnSaveRules.setBounds(109, 478, 89, 23);
		panel_1.add(btnSaveRules);
		
		button = new JButton("Start Contest");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isStarted = true;
				button.setText("Started Contest!");
			}
		});
		button.setBounds(259, 478, 125, 23);
		panel_1.add(button);
		
//		JScrollPane PaneLeaderBoard;
		PaneLeaderBoard = new JScrollPane();
		PaneLeaderBoard.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		PaneLeaderBoard.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 15));
		PanelDisplay.add(PaneLeaderBoard, LEADERBOARD);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setBorder(new EmptyBorder(25, 25, 25, 15));
		PaneLeaderBoard.setViewportView(table);
		
		btnSaveLeaderBoard = new JButton("Save");
		btnSaveLeaderBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveLeaderBoard();
			}
		});
		PaneLeaderBoard.setRowHeaderView(btnSaveLeaderBoard);
		
		PaneCreateLogin = new JScrollPane();
		PaneCreateLogin.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		PaneCreateLogin.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 15));
		PanelDisplay.add(PaneCreateLogin, CREATELOGIN);
		
		tableCreateLogin = new JTable();
		tableCreateLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableCreateLogin.setBorder(new EmptyBorder(25, 25, 25, 15));
		PaneCreateLogin.setViewportView(tableCreateLogin);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveCreateLogin();
			}
		});
		
		PaneCreateLogin.setRowHeaderView(btnSave);
		
//		String[] items = {PROBLEMA,PROBLEMB,PROBLEMC,PROBLEMD,PROBLEME,PROBLEMF,PROBLEMG};
		
//		JFileChooser Input;
		Input = new JFileChooser();
		Input.setBounds(288, 65, 582, 397);
		
//		JPanel PanelLogin;
		PanelLogin = new JPanel();
		PanelDisplay.add(PanelLogin, LOGIN);
		PanelLogin.setLayout(null);
		
//		JLabel lblLogin;
		lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblLogin.setBounds(10, 32, 1192, 41);
		PanelLogin.add(lblLogin);
		
//		JLabel lblTeamName;
		lblTeamName = new JLabel("Team Name");
		lblTeamName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTeamName.setBounds(464, 222, 73, 53);
		PanelLogin.add(lblTeamName);
		
//		JLabel lblPassword;
		lblPassword = new JLabel("Password");
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
		
//		JButton btnLoginSubmit
		btnLoginSubmit = new JButton("Submit");
		btnLoginSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getLoginDetails();
			}
		});
		btnLoginSubmit.setBounds(522, 357, 89, 23);
		PanelLogin.add(btnLoginSubmit);
	
//		JLabel lblNote1;
		lblNote1 = new JLabel("Note: If you forget password, contact admins for support.");
		lblNote1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNote1.setBounds(411, 405, 385, 27);
		PanelLogin.add(lblNote1);
		
//		JLabel lblNote2;
		lblNote2 = new JLabel("The Login Team Name and Password should be recieved from Admins and you should only login when you are asked to do so.");
		lblNote2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNote2.setBounds(182, 176, 810, 14);
		PanelLogin.add(lblNote2);
		
		btnCreateLogin = new JButton("Create Login!");
		btnCreateLogin.setBounds(693, 357, 103, 23);
		PanelLogin.add(btnCreateLogin);

//		JPanel Panel; 
		Panel = new JPanel();
		Panel.setBackground(new Color(255, 250, 205));
		Panel.setMaximumSize(new Dimension(150, 0));
		Panel.setPreferredSize(new Dimension(150, 0));
		Panel.setMinimumSize(new Dimension(100, 100));
		Panel.setBorder(BorderFactory.createLineBorder(new Color(0,0,0),2));
		Panel.setAlignmentY(20);
		Panel.setLayout(new BoxLayout(Panel, BoxLayout.Y_AXIS));
		frame.getContentPane().add(Panel, BorderLayout.WEST);
		
//		JLabel lblProbA;
		lblProbA = new JLabel("Problem A");
		lblProbA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedProblem=0;
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

//		JLabel lblProbB;
		lblProbB = new JLabel("Problem B");
		lblProbB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedProblem=1;
				ShowProblem('B');
			}
		});
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
		
//		JLabel lblProbC;
		lblProbC = new JLabel("Problem C");
		lblProbC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedProblem=2;
				ShowProblem('C');
			}
		});
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
		
//		JLabel lblProbD;
		lblProbD = new JLabel("Problem D");
		lblProbD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedProblem=3;
				ShowProblem('D');
			}
		});
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
		
//		JLabel lblProbE;
		lblProbE = new JLabel("Problem E");
		lblProbE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedProblem=4;
				ShowProblem('E');
			}
		});
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
		
//		JLabel lblProbF;
		lblProbF = new JLabel("Problem F");
		lblProbF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedProblem=5;
				ShowProblem('F');
			}
		});
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
		
//		JLabel lblProbG;
		lblProbG = new JLabel("Problem G");
		lblProbG.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedProblem=6;
				ShowProblem('G');
			}
		});
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

//		JLabel lblRules		
		lblRules = new JLabel("Rules");
		lblRules.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRules.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showRules();
			}
		});
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
	
//		JLabel lblSubmit;
		lblCreateLogin = new JLabel("Create Login");
		lblCreateLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createLoginClicked();
			}
		});
		
		lblCreateLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCreateLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblCreateLogin.setForeground(new Color(0,0,255));
		lblCreateLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateLogin.setMinimumSize(new Dimension(100, 100));
		lblCreateLogin.setMaximumSize(new Dimension(150, 50));
		lblCreateLogin.setBorder(null);
		lblCreateLogin.setSize(new Dimension(50, 70));
		lblCreateLogin.setPreferredSize(new Dimension(150, 0));
		lblCreateLogin.setLocation(new Point(10, 10));		
		Panel.add(lblCreateLogin);
		
//		JLabel lblLeaderboard;
		lblLeaderBoard = new JLabel("LeaderBoard");
		lblLeaderBoard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showLeaderBoard();
			}
		});
		lblLeaderBoard.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLeaderBoard.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblLeaderBoard.setForeground(new Color(0,0,255));
		lblLeaderBoard.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeaderBoard.setMinimumSize(new Dimension(100, 100));
		lblLeaderBoard.setMaximumSize(new Dimension(150, 50));
		lblLeaderBoard.setBorder(null);
		lblLeaderBoard.setSize(new Dimension(50, 70));
		lblLeaderBoard.setPreferredSize(new Dimension(150, 0));
		lblLeaderBoard.setLocation(new Point(10, 10));		
		Panel.add(lblLeaderBoard);

//		JMenuBar menuBar;
		
		menuBar = new JMenuBar();
		
//		JMenu file;
		file=new JMenu("File");
		file.setIcon(null);
		file.setMnemonic(KeyEvent.VK_F);
		menuBar.add(file);
		
//		JMenuItem close;
		addTime = new JTextField("0");
		edit = new JMenuItem("Configeration");
		edit.addActionListener(new ActionListener(){
	        
			public void actionPerformed(ActionEvent e)
	        {
				Object[] message = {
						"IP Address: " , IPServer,
						"Port Number Submit"  , PortServerSubmit,
						"Port Number Problem"  , PortServerProblem,
						"Add Contest Time", addTime
				};
				
				JOptionPane.showConfirmDialog(null, message, "Configeration", JOptionPane.OK_CANCEL_OPTION);
				try{
				Time=Time+Integer.parseInt(addTime.getText());
				TotTime= TotTime + Integer.parseInt(addTime.getText());
				}catch(Exception e1){
					e1.printStackTrace();
				}
	        }
		});
		file.add(edit);

		frame.setJMenuBar(menuBar);

		lblTimeRemaining = new JLabel("Time Remaining: ");
		menuBar.add(lblTimeRemaining);
		
		IPServer = new JTextField();
		IPServer.setText("127.0.0.1");
		PortServerSubmit = new JTextField();
		PortServerSubmit.setText("5000");
		PortServerProblem = new JTextField();	
		PortServerProblem.setText("6000");
		
		ProbName = new String[7];
		ProbDesc = new String[7];
		InputFormat = new String[7];
		OutputFormat = new String[7];
		SampleInput = new String[7];
		SampleOutput = new String[7];
		Constraints = new String[7];
		RulesStr = new String();

		for(int i=0;i<7;i++)
		{
			ProbName[i] = " ";
			ProbDesc[i] = " ";
			InputFormat[i] = " ";
			OutputFormat[i] = " ";
			SampleInput[i] = " ";
			SampleOutput[i] = " ";
			Constraints[i] = " ";
			RulesStr = " ";
		}
		
		Time = new Integer(MAX_TIME);
		TotTime = new Integer(MAX_TIME);

		Thread startTime= new Thread(new Runnable() {
			public void run() {
				try {
	 					reduceTime();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		startTime.start();

		Thread startSubmit= new Thread(new Runnable() {
			public void run() {
				try {
	 				acceptSolutions();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		startSubmit.start();
		
		Thread startProblems= new Thread(new Runnable() {
			public void run() {
				try {
	 				giveProblemSet();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		startProblems.start();
		
		displayLogin();
	}	
	/**
	 * @wbp.parser.entryPoint
	 */

	/**
	 * @wbp.parser.entryPoint
	 */
	protected void ShowProblem(char c) {
		
		Problems.setText("");
		StyledDocument question = (StyledDocument) Problems.getDocument();
		
		Style style1 = question.addStyle("Style1", null);
		StyleConstants.setBold(style1, true);
		StyleConstants.setFontSize(style1, 18);
		StyleConstants.setUnderline(style1, true);
		StyleConstants.setSpaceAbove(style1, 30);
		StyleConstants.setFontFamily(style1, Font.SANS_SERIF);
	
		Style style2 = question.addStyle("Style2", null);
		StyleConstants.setBold(style2, true);
		StyleConstants.setFontSize(style2, 14);
		StyleConstants.setUnderline(style2, true);
		StyleConstants.setSpaceAbove(style2, 30);
		StyleConstants.setFontFamily(style2, Font.SANS_SERIF);
	
		Style style3 = question.addStyle("Style3", null);
		StyleConstants.setBold(style3, false);
		StyleConstants.setFontSize(style3, 12);
		StyleConstants.setUnderline(style3, false);
		StyleConstants.setSpaceAbove(style3, 30);
		StyleConstants.setFontFamily(style3, Font.SANS_SERIF);
	
		// Add Problem Name in question set		
		
		try {
			question.insertString(0, "Problem "+ c + ": " + getProblemName(c) +"\n", style1);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		// Add Problem Description in question set
		
		try {
			question.insertString(question.getLength()+1, "\n" + getProblemDesc(c) +"\n\n", style3);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	
		// Add Input format in question set
		
		try {
			question.insertString(question.getLength()+1, "Input Format\n", style2);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		// Add Input format Description
		
		try {
			question.insertString(question.getLength()+1, getInputFormat(c) +"\n\n", style3);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		// Add Output format in question set
		
		try {
			question.insertString(question.getLength()+1, "Output Format\n", style2);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		// Add Output format Description in problem set
		
		try {
			question.insertString(question.getLength()+1, getOutputFormat(c) +"\n\n", style3);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		// Add Sample Input in problem set
		
		try {
			question.insertString(question.getLength()+1, "\nSample Input\n", style2);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	
		// Add Sample Input Description in problem set
		
		try {
			question.insertString(question.getLength()+1, getSampleInput(c) +"\n", style3);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}		
	
		// Add Sample Output in problem set
		
		try {
			question.insertString(question.getLength()+1, "Sample Output\n", style2);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		// Add Sample Output Description in problem set
		
		try {
			question.insertString(question.getLength()+1, getSampleOutput(c) +"\n", style3);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		// Add Constraints
		
		try {
			question.insertString(question.getLength()+1, "Constraints\n", style2);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		// Add Constraints Description in question set
		
		try {
			question.insertString(question.getLength()+1, getConstraints(c) +"\n", style3);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		CardLayout cl = (CardLayout) PanelDisplay.getLayout();
		cl.show(PanelDisplay, PROBLEMS);
				
	}

	protected void saveChanges() {
		
		ProbName[selectedProblem] = txtrProblemName.getText();
		ProbDesc[selectedProblem] = txtrProblemDescription.getText();
		InputFormat[selectedProblem] = txtrInputFormat.getText();
		OutputFormat[selectedProblem] = txtrOutputFormat.getText();
		SampleInput[selectedProblem] = txtrSampleInput.getText();
		SampleOutput[selectedProblem] = txtrSampleOutput.getText();
		Constraints[selectedProblem] = txtrConstraintsDescription.getText();
	}

	protected void showLeaderBoard() {

		String[] columns = {TEAMNAME,CATEGORY,PROBLEMA,PROBLEMB,PROBLEMC,PROBLEMD,PROBLEME,PROBLEMF,PROBLEMG,DONE,TIME};
//		String[] columns1 = {TEAMNAME,CATEGORY,PROBLEMA,PROBLEMB,PROBLEMC,PROBLEMD,PROBLEME,PROBLEMF,PROBLEMG,DONE,TIME};

		String[][] data = getLeaderData();

		DefaultTableModel model = new DefaultTableModel(data,columns);
		table.setModel(model);
		
		CardLayout cl = (CardLayout) PanelDisplay.getLayout();
		cl.show(PanelDisplay,LEADERBOARD);
	}

	private String[][] getLeaderData() {
		
		String[][] str = new String[board.size()][11];
		
		for(int i=0;i<board.size();i++)
		{
			str[i][0] = board.elementAt(i).teamName;
			str[i][1] = String.valueOf(board.elementAt(i).category);
			
			for(int j=0;j<7;j++)
			{
				str[i][2+j] = String.valueOf(board.elementAt(i).score[j]) + "\n   (" + String.valueOf(board.elementAt(i).attempt[j]) + ")";
			}
			
			str[i][9] = String.valueOf(board.elementAt(i).successful);
			str[i][10] = String.valueOf(board.elementAt(i).time);
		}
		
		return str;
	}
	
	protected void saveLeaderBoard() {
			try
			{
				for(int i=0;i<table.getRowCount();i++)
				{
					board.elementAt(i).teamName = (String) table.getValueAt(i, 0);
					board.elementAt(i).category = Integer.parseInt((String) table.getValueAt(i, 1));
					
					for(int j=0;j<7;j++)
					{
			
						String str1 = (String) table.getValueAt(i, 2+j);
	//					System.out.println(str1+"END");
						
						int ind;
						
						for(ind=0;ind<str1.length();ind++)
						{
							if(str1.charAt(ind)> '9' || str1.charAt(ind) <'0')
								break;
						}
	
						board.elementAt(i).score[j] = Integer.parseInt(str1.substring(0, ind));
	
						for(;ind<str1.length();ind++)
						{
							if(str1.charAt(ind)<= '9' && str1.charAt(ind) >='0')
								break;
						}
						
						board.elementAt(i).attempt[j] = Integer.parseInt(str1.substring(ind,str1.length()-1));
						//str[i][2+j] = String.valueOf(board.elementAt(i).score[j]) + "\n   (" + String.valueOf(board.elementAt(i).attempt[j]) + ")";
	
					}
	
					board.elementAt(i).successful = Integer.parseInt((String) table.getValueAt(i, 9));
					board.elementAt(i).time = Integer.parseInt((String) table.getValueAt(i, 10));
	
				}
			
			}catch(Exception e){
				e.printStackTrace();
			}
		}

	protected void getLoginDetails() {
		
		if(checkValidLogin(UserID.getText(),Password.getPassword()))
		{
			lblProbA.setVisible(true);
			lblProbB.setVisible(true);
			lblProbC.setVisible(true);
			lblProbD.setVisible(true);
			lblProbE.setVisible(true);
			lblProbF.setVisible(true);
			lblProbG.setVisible(true);
			lblLeaderBoard.setVisible(true);
			lblCreateLogin.setVisible(true);
			lblRules.setVisible(true);
			
			showRules();
		}
		else
		{
			JOptionPane.showMessageDialog(PanelLogin, "UserName or Password did not match!","Error!",JOptionPane.WARNING_MESSAGE);
		}
	}

	private boolean checkValidLogin(String text, char[] password2) {

		if(text.equals("") && java.util.Arrays.equals(password2, "".toCharArray()))
			return true;
		else
			return false;	
	}

	private void displayLogin() {
		lblProbA.setVisible(false);
		lblProbB.setVisible(false);
		lblProbC.setVisible(false);
		lblProbD.setVisible(false);
		lblProbE.setVisible(false);
		lblProbF.setVisible(false);
		lblProbG.setVisible(false);
		lblLeaderBoard.setVisible(false);
		lblCreateLogin.setVisible(false);
		lblRules.setVisible(false);
		
		CardLayout cl = (CardLayout)PanelDisplay.getLayout();
		cl.show(PanelDisplay, LOGIN);		
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	protected void createLoginClicked() {
		try
		{
			String[] columns = {TEAMNAME,"PASSWORD",CATEGORY};

		String[][] data = getCreateLoginData();

		DefaultTableModel model = new DefaultTableModel(data,columns);
		tableCreateLogin.setModel(model);		

		CardLayout cl = (CardLayout) PanelDisplay.getLayout();
		cl.show(PanelDisplay, CREATELOGIN);
		
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}

	private String[][] getCreateLoginData() {
		try
		{
			if(board.size()==0)
			{
				tableData row = new tableData();
				row.Password = "";
				row.teamName = "";
				row.category = 2;
				
				board.addElement(row);
				board.addElement(new tableData());
				board.addElement(new tableData());
				board.addElement(new tableData());
				board.addElement(new tableData());
				board.addElement(new tableData());
				board.addElement(new tableData());
				board.addElement(new tableData());
				board.addElement(new tableData());
				board.addElement(new tableData());
				board.addElement(new tableData());
				board.addElement(new tableData());
				board.addElement(new tableData());
				board.addElement(new tableData());
				board.addElement(new tableData());
				board.addElement(new tableData());
				board.addElement(new tableData());
				board.addElement(new tableData());
				board.addElement(new tableData());
				board.addElement(new tableData());
				board.addElement(new tableData());

				
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}	
		
		String[][] str = new String[board.size()][3];
		try
		{
			for(int i=0;i<board.size();i++)
			{
				str[i][0] = board.elementAt(i).teamName;
				str[i][1] = board.elementAt(i).Password;
				str[i][2] = String.valueOf(board.elementAt(i).category);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return str;
	}

	protected void saveCreateLogin() {
		try
		{
			for(int i=0;i<table.getRowCount();i++)
			{
				board.elementAt(i).teamName = (String) tableCreateLogin.getValueAt(i, 0);
				board.elementAt(i).Password = (String) tableCreateLogin.getValueAt(i, 1);
				board.elementAt(i).category = Integer.parseInt((String) tableCreateLogin.getValueAt(i, 2));			
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private String getRuleStr() {
		return RulesStr;
	}

	protected void showRules()
	{
		Rules.setText("");
		StyledDocument question = (StyledDocument) Rules.getDocument();
		
		Style style1 = question.addStyle("Style1", null);
		StyleConstants.setBold(style1, true);
		StyleConstants.setFontSize(style1, 18);
		StyleConstants.setUnderline(style1, true);
		StyleConstants.setSpaceAbove(style1, 30);
		StyleConstants.setFontFamily(style1, Font.SANS_SERIF);
	
		Style style2 = question.addStyle("Style2", null);
		StyleConstants.setBold(style2, true);
		StyleConstants.setFontSize(style2, 14);
		StyleConstants.setUnderline(style2, true);
		StyleConstants.setSpaceAbove(style2, 30);
		StyleConstants.setFontFamily(style2, Font.SANS_SERIF);
	
		Style style3 = question.addStyle("Style3", null);
		StyleConstants.setBold(style3, false);
		StyleConstants.setFontSize(style3, 12);
		StyleConstants.setUnderline(style3, false);
		StyleConstants.setSpaceAbove(style3, 30);
		StyleConstants.setFontFamily(style3, Font.SANS_SERIF);
	
		// Add Rules in question set
		
		try {
			question.insertString(0, "General Rules\n\n", style1);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		// Add Rules Description in question set
		
		try {
			question.insertString(question.getLength()+1, "\n" + getRuleStr() +"\n\n", style3);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}	
	
		CardLayout cl = (CardLayout) PanelDisplay.getLayout();
		cl.show(PanelDisplay, RULES);
	
	}

	static String getProblemName(char c)
	{
		return ProbName[c-'A'] ;
	}

	static String getProblemDesc(char c)
	{
		return ProbDesc[c-'A'];
	}
	
	static String getInputFormat(char c)
	{
		return InputFormat[c-'A'];
	}

	static String getOutputFormat(char c)
	{
		return OutputFormat[c-'A'];
	}

	static String getSampleInput(char c)
	{
		return SampleInput[c-'A'] ;
	}

	static String getSampleOutput(char c)
	{
		return SampleOutput[c-'A'] ;
	}

	static String getConstraints(char c)
	{
		return Constraints[c-'A'];
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

