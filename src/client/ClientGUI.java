package client;

import java.awt.BorderLayout;




import java.util.*;
import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import message.*;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import message.*;

import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.FormSpecs;
//import com.jgoodies.forms.layout.RowSpec;
import javax.swing.BoxLayout;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.SystemColor;
import javax.swing.SpinnerNumberModel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;




public class ClientGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtItinerary;
	private JTextField txtClass;
	private JTextField txtSeatPreference;
	private JTextField txtDatetime;
	private JTextField txtFrom;
	private JTextField txtTo;
	private JTextField txtOutbound;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtInbound;
	private JTextField textField_2;
	private JTextField txtNormal;
	private JTextField txtChild;
	private JTextField txtElder;
	private JTextField txtDisable;
	private JTextField txtStudent;
	private JTextField txtCarid;
	private JTextField txtDepartTime;
	private JTextField txtArriveTime;
	

	
	private OrderResult order_result;  //for read, which will be clean after readed;
	private LinkedList<Ticket> cancel_order;  //for canceling the ticket
	private Available info1;
	private Available info2;
	private DailyResult info_SearchDaily;
	
	private JTextField txtSeatwindow;
	private JTextField txtSeataisle;
	private JTextField txtSeatnone;
	private JTextField txtEarlybird;
	private JTextField txtPleaseInputThe;
	private JTextField textinputCarID;
	private JTextField txtUserid;
	private JTextField userID_input;
	private JTextField textField_4;
	private JTextField txtPrice;
	private JTextField txtCarid_1;
	private JTextField txtDepartStation;
	private JTextField txtDepartTime_1;
	private JTextField txtArriveStation;
	private JTextField txtArriveTime_1;
	private JTextField txtPassenterType;
	private JTextField txtCarriage;
	private JTextField txtEarlyDiscount;
	private JTextField txtCarnoLocated;
	private JTextField txtDepartStation_1;
	private JTextField txtArriveStation_1;
	private JTextField txtCarriage_1;
	private JTextField txtUniversityDiscount;
	private JTextField txtPleaseInputThe_1;
	private JTextField textinputUserID;
	private JTextField TransactionNum_input;
	private JTextField txtTransactionNumber;
	private JButton SearchTransacationNum;
	private JTextField txtCarid_2;
	private JTextField textField_3;
	private JTextField bytn_UserID_input;
	private JTextField bytn_CarID_input;
	private JButton bytn_btn_Search;
	private JPanel printout_SO;
	private JPanel printout_SOTN;

	private JPanel Available_Holder;

	private JTextField txtCarid_3;
	private JTextField txtNangang;
	private JTextField txtTaipei;
	private JTextField txtBanqiao;
	private JTextField txtTaoyuan;
	private JTextField txtHsinchu;
	private JTextField txtMiaoli;
	private JTextField txtTaichung;
	private JTextField txtChanghua;
	private JTextField txtYunlin;
	private JTextField txtChiayi;
	private JTextField txtTainan_1;
	private JTextField txtZuoying;
	private JTextField txtPleaseInputThe_2;
	private JTextField textField_5;
	private JButton btnNewButton_4;


	private String temp_memory_userID;
	private String temp_memory_transaction_number;
	private JTextField txtYyyymmdd;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientGUI frame = new ClientGUI();
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
	public ClientGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1750, 1544);
		this.setTitle("HSR Ticket System");
		this.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setVisible(true);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(10);
		contentPane.add(panel, BorderLayout.NORTH);
		
		
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);	
		
			
				
		Available_Holder = new JPanel();
		Available_Holder.setBounds(0, 0, 1624, 1014);
		
		layeredPane.add(Available_Holder);
		Available_Holder.setLayout(null);
		
						
						
						
						
						
						
						
						txtCarid = new JTextField();
						txtCarid.setBackground(Color.PINK);
						txtCarid.setForeground(Color.BLACK);
						txtCarid.setFont(new Font("Arial", Font.PLAIN, 15));
						txtCarid.setEditable(false);
						txtCarid.setText("CarID");
						txtCarid.setBounds(0, 60, 150, 20);
						Available_Holder.add(txtCarid);
						txtCarid.setColumns(10);
						
						txtDepartTime = new JTextField();
						txtDepartTime.setBackground(Color.PINK);
						txtDepartTime.setFont(new Font("Arial", Font.PLAIN, 15));
						txtDepartTime.setText("Depart Time");
						txtDepartTime.setEditable(false);
						txtDepartTime.setColumns(10);
						txtDepartTime.setBounds(150, 60, 150, 20);
						Available_Holder.add(txtDepartTime);
						
						txtArriveTime = new JTextField();
						txtArriveTime.setBackground(Color.PINK);
						txtArriveTime.setFont(new Font("Arial", Font.PLAIN, 15));
						txtArriveTime.setEditable(false);
						txtArriveTime.setText("Arrive Time");
						txtArriveTime.setBounds(450, 60, 150, 20);
						Available_Holder.add(txtArriveTime);
						txtArriveTime.setColumns(10);
						
						txtSeatwindow = new JTextField();
						txtSeatwindow.setEditable(false);
						txtSeatwindow.setBackground(Color.PINK);
						txtSeatwindow.setFont(new Font("Arial", Font.PLAIN, 15));
						txtSeatwindow.setText("Seat_Window");
						txtSeatwindow.setBounds(900, 60, 150, 20);
						Available_Holder.add(txtSeatwindow);
						txtSeatwindow.setColumns(10);
						
						txtSeataisle = new JTextField();
						txtSeataisle.setEditable(false);
						txtSeataisle.setFont(new Font("Arial", Font.PLAIN, 15));
						txtSeataisle.setBackground(Color.PINK);
						txtSeataisle.setText("Seat_Aisle");
						txtSeataisle.setBounds(1050, 60, 150, 20);
						Available_Holder.add(txtSeataisle);
						txtSeataisle.setColumns(10);
						
						txtSeatnone = new JTextField();
						txtSeatnone.setEditable(false);
						txtSeatnone.setFont(new Font("Arial", Font.PLAIN, 15));
						txtSeatnone.setBackground(Color.PINK);
						txtSeatnone.setText("Seat_None");
						txtSeatnone.setBounds(1200, 60, 150, 20);
						Available_Holder.add(txtSeatnone);
						txtSeatnone.setColumns(10);
						
						txtEarlybird = new JTextField();
						txtEarlybird.setEditable(false);
						txtEarlybird.setFont(new Font("Arial", Font.PLAIN, 15));
						txtEarlybird.setBackground(Color.PINK);
						txtEarlybird.setText("EarlyBird");
						txtEarlybird.setBounds(1350, 60, 150, 20);
						Available_Holder.add(txtEarlybird);
						txtEarlybird.setColumns(10);
						
						txtDepartStation_1 = new JTextField();
						txtDepartStation_1.setText("Depart Station");
						txtDepartStation_1.setFont(new Font("Arial", Font.PLAIN, 15));
						txtDepartStation_1.setEditable(false);
						txtDepartStation_1.setColumns(10);
						txtDepartStation_1.setBackground(Color.PINK);
						txtDepartStation_1.setBounds(300, 60, 150, 20);
						Available_Holder.add(txtDepartStation_1);
						
						txtArriveStation_1 = new JTextField();
						txtArriveStation_1.setText("Arrive Station");
						txtArriveStation_1.setFont(new Font("Arial", Font.PLAIN, 15));
						txtArriveStation_1.setEditable(false);
						txtArriveStation_1.setColumns(10);
						txtArriveStation_1.setBackground(Color.PINK);
						txtArriveStation_1.setBounds(600, 60, 150, 20);
						Available_Holder.add(txtArriveStation_1);
						
						txtCarriage_1 = new JTextField();
						txtCarriage_1.setText("Carriage");
						txtCarriage_1.setFont(new Font("Arial", Font.PLAIN, 15));
						txtCarriage_1.setEditable(false);
						txtCarriage_1.setColumns(10);
						txtCarriage_1.setBackground(Color.PINK);
						txtCarriage_1.setBounds(750, 60, 150, 20);
						Available_Holder.add(txtCarriage_1);
						
						txtUniversityDiscount = new JTextField();
						txtUniversityDiscount.setText("University Discount");
						txtUniversityDiscount.setFont(new Font("Arial", Font.PLAIN, 11));
						txtUniversityDiscount.setEditable(false);
						txtUniversityDiscount.setColumns(10);
						txtUniversityDiscount.setBackground(Color.PINK);
						txtUniversityDiscount.setBounds(1500, 60, 150, 20);
						Available_Holder.add(txtUniversityDiscount);
						
						
						txtPleaseInputThe = new JTextField();
						txtPleaseInputThe.setEditable(false);
						txtPleaseInputThe.setFont(new Font("Arial", Font.PLAIN, 16));
						txtPleaseInputThe.setBackground(new Color(221, 160, 221));
						txtPleaseInputThe.setText("Please input the CarID you want :  ");
						txtPleaseInputThe.setBounds(10, 3, 255, 20);
						Available_Holder.add(txtPleaseInputThe);
						txtPleaseInputThe.setColumns(10);
						
						textinputCarID = new JTextField();
						textinputCarID.setBounds(275, 3, 96, 20);
						Available_Holder.add(textinputCarID);
						textinputCarID.setColumns(10);
						
						txtPleaseInputThe_1 = new JTextField();
						txtPleaseInputThe_1.setText("Please input the UserID of yours :");
						txtPleaseInputThe_1.setFont(new Font("Arial", Font.PLAIN, 16));
						txtPleaseInputThe_1.setEditable(false);
						txtPleaseInputThe_1.setColumns(10);
						txtPleaseInputThe_1.setBackground(new Color(221, 160, 221));
						txtPleaseInputThe_1.setBounds(10, 30, 255, 20);
						Available_Holder.add(txtPleaseInputThe_1);
						
						textinputUserID = new JTextField();
						textinputUserID.setColumns(10);
						textinputUserID.setBounds(275, 30, 96, 20);
						Available_Holder.add(textinputUserID);
				

		JScrollPane result = new JScrollPane();
		result.setBackground(Color.YELLOW);
		result.setBounds(0, 0, 1000, 1000);
		layeredPane.add(result);
		result.setLayout(null);
		
		
		
				JPanel Search = new JPanel();
				Search.setBackground(Color.GRAY);
				Search.setBounds(0, 0, 1000, 1000);
				layeredPane.add(Search);
				Search.setLayout(null);
				
				txtCarid_3 = new JTextField();
				txtCarid_3.setHorizontalAlignment(SwingConstants.CENTER);
				txtCarid_3.setEditable(false);
				txtCarid_3.setBackground(Color.LIGHT_GRAY);
				txtCarid_3.setFont(new Font("Arial", Font.BOLD, 15));
				txtCarid_3.setText("CarID");
				txtCarid_3.setBounds(0, 0, 70, 30);
				Search.add(txtCarid_3);
				txtCarid_3.setColumns(10);
				
				txtNangang = new JTextField();
				txtNangang.setHorizontalAlignment(SwingConstants.CENTER);
				txtNangang.setEditable(false);
				txtNangang.setBackground(Color.LIGHT_GRAY);
				txtNangang.setFont(new Font("Arial", Font.BOLD, 15));
				txtNangang.setText("Nangang");
				txtNangang.setBounds(70, 0, 70, 30);
				Search.add(txtNangang);
				txtNangang.setColumns(10);
				
				txtTaipei = new JTextField();
				txtTaipei.setHorizontalAlignment(SwingConstants.CENTER);
				txtTaipei.setEditable(false);
				txtTaipei.setFont(new Font("Arial", Font.BOLD, 15));
				txtTaipei.setText("Taipei");
				txtTaipei.setBackground(Color.LIGHT_GRAY);
				txtTaipei.setBounds(140, 0, 70, 30);
				Search.add(txtTaipei);
				txtTaipei.setColumns(10);
				
				txtBanqiao = new JTextField();
				txtBanqiao.setHorizontalAlignment(SwingConstants.CENTER);
				txtBanqiao.setEditable(false);
				txtBanqiao.setBackground(Color.LIGHT_GRAY);
				txtBanqiao.setFont(new Font("Arial", Font.BOLD, 15));
				txtBanqiao.setText("Banqiao");
				txtBanqiao.setBounds(210, 0, 70, 30);
				Search.add(txtBanqiao);
				txtBanqiao.setColumns(10);
				
				txtTaoyuan = new JTextField();
				txtTaoyuan.setHorizontalAlignment(SwingConstants.CENTER);
				txtTaoyuan.setEditable(false);
				txtTaoyuan.setBackground(Color.LIGHT_GRAY);
				txtTaoyuan.setFont(new Font("Arial", Font.BOLD, 15));
				txtTaoyuan.setText("Taoyuan");
				txtTaoyuan.setBounds(280, 0, 70, 30);
				Search.add(txtTaoyuan);
				txtTaoyuan.setColumns(10);
				
				txtHsinchu = new JTextField();
				txtHsinchu.setHorizontalAlignment(SwingConstants.CENTER);
				txtHsinchu.setEditable(false);
				txtHsinchu.setBackground(Color.LIGHT_GRAY);
				txtHsinchu.setForeground(Color.BLACK);
				txtHsinchu.setFont(new Font("Arial", Font.BOLD, 15));
				txtHsinchu.setText("Hsinchu");
				txtHsinchu.setBounds(350, 0, 70, 30);
				Search.add(txtHsinchu);
				txtHsinchu.setColumns(10);
				
				txtMiaoli = new JTextField();
				txtMiaoli.setHorizontalAlignment(SwingConstants.CENTER);
				txtMiaoli.setEditable(false);
				txtMiaoli.setFont(new Font("Arial", Font.BOLD, 15));
				txtMiaoli.setBackground(Color.LIGHT_GRAY);
				txtMiaoli.setText("Miaoli");
				txtMiaoli.setBounds(420, 0, 70, 30);
				Search.add(txtMiaoli);
				txtMiaoli.setColumns(10);
				
				txtTaichung = new JTextField();
				txtTaichung.setHorizontalAlignment(SwingConstants.CENTER);
				txtTaichung.setEditable(false);
				txtTaichung.setBackground(Color.LIGHT_GRAY);
				txtTaichung.setFont(new Font("Arial", Font.BOLD, 15));
				txtTaichung.setText("Taichung");
				txtTaichung.setBounds(490, 0, 70, 30);
				Search.add(txtTaichung);
				txtTaichung.setColumns(10);
				
				txtChanghua = new JTextField();
				txtChanghua.setHorizontalAlignment(SwingConstants.CENTER);
				txtChanghua.setEditable(false);
				txtChanghua.setBackground(Color.LIGHT_GRAY);
				txtChanghua.setFont(new Font("Arial", Font.BOLD, 15));
				txtChanghua.setText("Changhua");
				txtChanghua.setBounds(560, 0, 80, 30);
				Search.add(txtChanghua);
				txtChanghua.setColumns(10);
				
				txtYunlin = new JTextField();
				txtYunlin.setHorizontalAlignment(SwingConstants.CENTER);
				txtYunlin.setEditable(false);
				txtYunlin.setFont(new Font("Arial", Font.BOLD, 15));
				txtYunlin.setBackground(Color.LIGHT_GRAY);
				txtYunlin.setText("Yunlin");
				txtYunlin.setBounds(640, 0, 70, 30);
				Search.add(txtYunlin);
				txtYunlin.setColumns(10);
				
				txtChiayi = new JTextField();
				txtChiayi.setHorizontalAlignment(SwingConstants.CENTER);
				txtChiayi.setEditable(false);
				txtChiayi.setBackground(Color.LIGHT_GRAY);
				txtChiayi.setFont(new Font("Arial", Font.BOLD, 15));
				txtChiayi.setText("Chiayi");
				txtChiayi.setBounds(710, 0, 70, 30);
				Search.add(txtChiayi);
				txtChiayi.setColumns(10);
				
				txtTainan_1 = new JTextField();
				txtTainan_1.setHorizontalAlignment(SwingConstants.CENTER);
				txtTainan_1.setEditable(false);
				txtTainan_1.setBackground(Color.LIGHT_GRAY);
				txtTainan_1.setFont(new Font("Arial", Font.BOLD, 15));
				txtTainan_1.setText("Tainan");
				txtTainan_1.setBounds(780, 0, 70, 30);
				Search.add(txtTainan_1);
				txtTainan_1.setColumns(10);
				
				txtZuoying = new JTextField();
				txtZuoying.setHorizontalAlignment(SwingConstants.CENTER);
				txtZuoying.setFont(new Font("Arial", Font.BOLD, 15));
				txtZuoying.setBackground(Color.LIGHT_GRAY);
				txtZuoying.setText("Zuoying");
				txtZuoying.setBounds(850, 0, 70, 30);
				Search.add(txtZuoying);
				txtZuoying.setColumns(10);
				
				txtPleaseInputThe_2 = new JTextField();
				txtPleaseInputThe_2.setBackground(Color.PINK);
				txtPleaseInputThe_2.setFont(new Font("Arial", Font.BOLD, 18));
				txtPleaseInputThe_2.setText("Please input the date");
				txtPleaseInputThe_2.setBounds(0, 30, 200, 30);
				Search.add(txtPleaseInputThe_2);
				txtPleaseInputThe_2.setColumns(10);
				
				textField_5 = new JTextField();
				textField_5.setBounds(200, 31, 150, 30);
				Search.add(textField_5);
				textField_5.setColumns(10);
/**
 * The following is the action event of button "Confirm". As we push it, it will 
 * send a message of SearchDaily to Server, and then print out the information.				
 */
				btnNewButton_4 = new JButton("Confirm");
				btnNewButton_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						SearchDaily searchDailyMessage = new SearchDaily();
						
						searchDailyMessage.setDepartDay(textField_5.getText());
						
						if(userID_input.getText().equals("")) {
							//do nothing at following function
							System.out.println("Please input the date.");
						}
						
						try {
							Scanner sc = new Scanner(System.in);
							Socket cs = new Socket("127.0.0.1", 3588); 
							ObjectOutputStream os = new ObjectOutputStream(cs.getOutputStream());
							ObjectInputStream is = new ObjectInputStream(cs.getInputStream());
							
							os.writeObject(searchDailyMessage);
							os.flush();
							Object msg = (Object) is.readObject();
							if (msg == null)
								System.out.println("null");
							if (msg.getClass() == new Available().getClass()) {
								System.out.println("success");
							}
							
							info_SearchDaily = (DailyResult)msg;
							
							int QuantityOfDailyCar = info_SearchDaily.TicketList.size();
							
							if(QuantityOfDailyCar == 0) {
								System.out.println("No car was found.");
							}							
		
							

							//Search.removeAll();
							Search.repaint();
							Search.revalidate();
							Search.setVisible(true);
/**
 * We use a loop to generate the info of all the car in one particular day.
 * Use index i and k to make the TextField.
 */
							for(int i=0 ; i<QuantityOfDailyCar ; i++)
							{
								JTextField temp[] = new JTextField[13];
								for(int k=0; k<13 ; k++)
								{
									/**
									 * Create the TextField
									 */
									JTextField temp1 = new JTextField();
									temp1.setBackground(Color.LIGHT_GRAY);
									temp1.setForeground(Color.BLACK);
									temp1.setFont(new Font("Arial", Font.PLAIN, 12));
									temp1.setEditable(false);
									
									switch(k) {
										case 0:
											temp1.setText(info_SearchDaily.TicketList.get(i).getCarID());
											break;
										case 1:
											temp1.setText(info_SearchDaily.TicketList.get(i).getDepart_timeOfNANGANG());
											break;
										case 2:
											temp1.setText(info_SearchDaily.TicketList.get(i).getDepart_timeOfTAIPEI());
											break;
										case 3:
											temp1.setText(info_SearchDaily.TicketList.get(i).getDepart_timeOfBANCIAO());
											break;
										case 4:
											temp1.setText(info_SearchDaily.TicketList.get(i).getDepart_timeOfTAOYUAN());
											break;
										case 5:
											temp1.setText(info_SearchDaily.TicketList.get(i).getDepart_timeOfHSINCHU());
											break;
										case 6:
											temp1.setText(info_SearchDaily.TicketList.get(i).getDepart_timeOfMIAOLI());
											break;
										case 7:
											temp1.setText(info_SearchDaily.TicketList.get(i).getDepart_timeOfTAICHUNG());
											break;
										case 8:
											temp1.setText(info_SearchDaily.TicketList.get(i).getDepart_timeOfCHANGHUA());
											break;
										case 9:
											temp1.setText(info_SearchDaily.TicketList.get(i).getDepart_timeOfYUNLIN());
											break;
										case 10:
											temp1.setText(info_SearchDaily.TicketList.get(i).getDepart_timeOfCHIAYI());
											break;
										case 11:
											temp1.setText(info_SearchDaily.TicketList.get(i).getDepart_timeOfTAINAN());
											break;
										case 12:
											temp1.setText(info_SearchDaily.TicketList.get(i).getDepart_timeOfZUOYING());
											break;
									}	
										temp1.setBounds(0+70*k, 60+20*i, 70, 30);
										temp1.setColumns(10);
										Search.add(temp1);									

								}

							}
							
							os.close();
							is.close();
							cs.close();
						}catch (UnknownHostException e1) {
							e1.printStackTrace();
							System.out.println("connection error");
						} catch (IOException e1) {
							e1.printStackTrace();
							System.out.println("IO error");
						} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
							System.out.println("Class Not Found error");
						}				
						
					}
				});
				btnNewButton_4.setForeground(new Color(0, 0, 0));
				btnNewButton_4.setBackground(new Color(255, 222, 173));
				btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 18));
				btnNewButton_4.setBounds(360, 30, 120, 30);
				Search.add(btnNewButton_4);
				
				txtYyyymmdd = new JTextField();
				txtYyyymmdd.setHorizontalAlignment(SwingConstants.CENTER);
				txtYyyymmdd.setFont(new Font("Arial", Font.BOLD, 20));
				txtYyyymmdd.setEditable(false);
				txtYyyymmdd.setText("yyyy-mm-dd");
				txtYyyymmdd.setBackground(Color.LIGHT_GRAY);
				txtYyyymmdd.setBounds(200, 60, 150, 30);
				Search.add(txtYyyymmdd);
				txtYyyymmdd.setColumns(10);
				
			
				
				
				
				

				JPanel Available = new JPanel();
				Available.setBackground(Color.LIGHT_GRAY);
				Available.setBounds(0, 0, 1624, 3014);
				//layeredPane.add(Available);
				Available.setLayout(null);
				

				
				JPanel SearchOrder_byTN = new JPanel();
				SearchOrder_byTN.setBackground(Color.GREEN);
				SearchOrder_byTN.setBounds(0, 0, 1624, 458);
				layeredPane.add(SearchOrder_byTN);
				SearchOrder_byTN.setLayout(null);
		
		
		JPanel SearchOrder = new JPanel();
		SearchOrder.setBackground(Color.YELLOW);
		SearchOrder.setBounds(0, 0, 1624, 458);
		layeredPane.add(SearchOrder);
		SearchOrder.setLayout(null);
		

		
		
		printout_SO = new JPanel();
		printout_SO.setBackground(Color.YELLOW);
		printout_SO.setBounds(0, 40, 1624, 418);
		SearchOrder.add(printout_SO);
		printout_SO.setLayout(null);
		
		
		
		
		
		txtUserid = new JTextField();
		txtUserid.setHorizontalAlignment(SwingConstants.CENTER);
		txtUserid.setEditable(false);
		txtUserid.setText("UserID");
		txtUserid.setBounds(10, 10, 100, 20);
		SearchOrder.add(txtUserid);
		txtUserid.setColumns(10);
		
		userID_input = new JTextField();
		userID_input.setBounds(120, 10, 200, 20);
		SearchOrder.add(userID_input);
		userID_input.setColumns(10);
		
		
		TransactionNum_input = new JTextField();
		TransactionNum_input.setColumns(10);
		TransactionNum_input.setBounds(440, 10, 200, 20);
		SearchOrder.add(TransactionNum_input);
		
		
		JPanel Booking = new JPanel();
		Booking.setBackground(SystemColor.window);
		Booking.setBounds(0, 0, 1324, 458);
		layeredPane.add(Booking);
		Booking.setLayout(null);
		
/**
 * The following is the action of the button "Search"		
 */
		JButton btnSearchOrder = new JButton("Search");
		btnSearchOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SearchOrder SearchOrderMessage = new SearchOrder();
				
				SearchOrderMessage.setUserID(userID_input.getText());
				SearchOrderMessage.setTransactionNumber(TransactionNum_input.getText());
				
				if(userID_input.getText().equals("")) {
					//do nothing at following function
					System.out.println("Please input your userID");

				}
				
				else if(TransactionNum_input.getText().equals("")) {
					//do nothing at following function
					System.out.println("Please input your Transaction Number");
				}
				
				
				else {
					try {
						Scanner sc = new Scanner(System.in);
						Socket cs = new Socket("127.0.0.1", 3588); 
						ObjectOutputStream os = new ObjectOutputStream(cs.getOutputStream());
						ObjectInputStream is = new ObjectInputStream(cs.getInputStream());
						
						os.writeObject(SearchOrderMessage);
						os.flush();
						Object msg = (Object) is.readObject();
						
						if (msg == null)
							System.out.println("null");
						
						if (msg.getClass() == new OrderResult().getClass()) {
							System.out.println("successfully get the OrderResult");
							
							//order_result is the local memory pointer to catch the information of msg
							order_result = (OrderResult) msg;

							if(order_result.getOrderResult().isEmpty()) {
								System.out.println("Result 404 not find");
							}
							
							
							
							else {
							/**
							 * Creating the headline
							 */
								
							cancel_order = (LinkedList<Ticket>) order_result.getOrderResult().clone();
							
							textField_4 = new JTextField();
							textField_4.setText("Transaction NO.");
							textField_4.setHorizontalAlignment(SwingConstants.CENTER);
							textField_4.setEditable(false);
							textField_4.setColumns(10);
							textField_4.setBounds(10, 0, 100, 20);
							printout_SO.add(textField_4);
							
							
							
							textField_4 = new JTextField();
							textField_4.setText("UserID");
							textField_4.setHorizontalAlignment(SwingConstants.CENTER);
							textField_4.setEditable(false);
							textField_4.setColumns(10);
							textField_4.setBounds(110, 0, 100, 20);
							printout_SO.add(textField_4);
							
							txtCarid_1 = new JTextField();
							txtCarid_1.setText("CarID");
							txtCarid_1.setHorizontalAlignment(SwingConstants.CENTER);
							txtCarid_1.setEditable(false);
							txtCarid_1.setColumns(10);
							txtCarid_1.setBounds(210, 0, 100, 20);
							printout_SO.add(txtCarid_1);
							
							txtDepartStation = new JTextField();
							txtDepartStation.setText("Depart Station");
							txtDepartStation.setHorizontalAlignment(SwingConstants.CENTER);
							txtDepartStation.setEditable(false);
							txtDepartStation.setColumns(10);
							txtDepartStation.setBounds(310, 0, 100, 20);
							printout_SO.add(txtDepartStation);
							
							txtDepartTime_1 = new JTextField();
							txtDepartTime_1.setText("Depart Time");
							txtDepartTime_1.setHorizontalAlignment(SwingConstants.CENTER);
							txtDepartTime_1.setEditable(false);
							txtDepartTime_1.setColumns(10);
							txtDepartTime_1.setBounds(410, 0, 150, 20);
							printout_SO.add(txtDepartTime_1);
							
							txtArriveStation = new JTextField();
							txtArriveStation.setText("Arrive Station");
							txtArriveStation.setHorizontalAlignment(SwingConstants.CENTER);
							txtArriveStation.setEditable(false);
							txtArriveStation.setColumns(10);
							txtArriveStation.setBounds(560, 0, 100, 20);
							printout_SO.add(txtArriveStation);
							
							txtArriveTime_1 = new JTextField();
							txtArriveTime_1.setText("Arrive Time");
							txtArriveTime_1.setHorizontalAlignment(SwingConstants.CENTER);
							txtArriveTime_1.setEditable(false);
							txtArriveTime_1.setColumns(10);
							txtArriveTime_1.setBounds(660, 0, 150, 20);
							printout_SO.add(txtArriveTime_1);
							
							txtPassenterType = new JTextField();
							txtPassenterType.setText("Passenger Type");
							txtPassenterType.setHorizontalAlignment(SwingConstants.CENTER);
							txtPassenterType.setEditable(false);
							txtPassenterType.setColumns(10);
							txtPassenterType.setBounds(810, 0, 100, 20);
							printout_SO.add(txtPassenterType);
							
							txtCarriage = new JTextField();
							txtCarriage.setText("Carriage");
							txtCarriage.setHorizontalAlignment(SwingConstants.CENTER);
							txtCarriage.setEditable(false);
							txtCarriage.setColumns(10);
							txtCarriage.setBounds(910, 0, 100, 20);
							printout_SO.add(txtCarriage);
							
							txtEarlyDiscount = new JTextField();
							txtEarlyDiscount.setText("Early Discount");
							txtEarlyDiscount.setHorizontalAlignment(SwingConstants.CENTER);
							txtEarlyDiscount.setEditable(false);
							txtEarlyDiscount.setColumns(10);
							txtEarlyDiscount.setBounds(1010, 0, 100, 20);
							printout_SO.add(txtEarlyDiscount);
							
							txtCarnoLocated = new JTextField();
							txtCarnoLocated.setText("CarNO.  Located");
							txtCarnoLocated.setHorizontalAlignment(SwingConstants.CENTER);
							txtCarnoLocated.setEditable(false);
							txtCarnoLocated.setColumns(10);
							txtCarnoLocated.setBounds(1110, 0, 100, 20);
							printout_SO.add(txtCarnoLocated);
							

							txtPrice = new JTextField();
							txtPrice.setText("Price");
							txtPrice.setHorizontalAlignment(SwingConstants.CENTER);
							txtPrice.setEditable(false);
							txtPrice.setColumns(10);
							txtPrice.setBounds(1210, 0, 100, 20);
							printout_SO.add(txtPrice);
							
							
							/*
							 * create the table of tickets
							 */
							
							int i = 0;
							
							while(!order_result.getOrderResult().isEmpty()) {
							
								Ticket ticket = order_result.getOrderResult().pollFirst();

									JTextField temp = new JTextField();
									temp.setText(ticket.getTransactionNumber());
									temp.setHorizontalAlignment(SwingConstants.CENTER);
									temp.setEditable(false);
									temp.setColumns(10);
									temp.setBounds(10, 20 + i * 20, 100, 20);
									printout_SO.add(temp);

									temp = new JTextField();
									temp.setText(ticket.getUserID());
									temp.setHorizontalAlignment(SwingConstants.CENTER);
									temp.setEditable(false);
									temp.setColumns(10);
									temp.setBounds(110, 20 + i*20, 100, 20);
									printout_SO.add(temp);
									
									
									temp = new JTextField();
									temp.setText(ticket.getCarID());
									temp.setHorizontalAlignment(SwingConstants.CENTER);
									temp.setEditable(false);
									temp.setColumns(10);
									temp.setBounds(210, 20 + i*20, 100, 20);
									printout_SO.add(temp);
									
									
									temp = new JTextField();
									temp.setText(ticket.getDepart());
									temp.setHorizontalAlignment(SwingConstants.CENTER);
									temp.setEditable(false);
									temp.setColumns(10);
									temp.setBounds(310, 20 + i*20, 100, 20);
									printout_SO.add(temp);
									
									
									temp = new JTextField();
									temp.setText(ticket.getDepartTime());
									temp.setHorizontalAlignment(SwingConstants.CENTER);
									temp.setEditable(false);
									temp.setColumns(10);
									temp.setBounds(410, 20 + i*20, 150, 20);
									printout_SO.add(temp);
									
									
									temp = new JTextField();
									temp.setText(ticket.getArrive());
									temp.setHorizontalAlignment(SwingConstants.CENTER);
									temp.setEditable(false);
									temp.setColumns(10);
									temp.setBounds(560, 20 + i*20, 100, 20);
									printout_SO.add(temp);
									
									
									temp = new JTextField();
									temp.setText(ticket.getArriveTime());
									temp.setHorizontalAlignment(SwingConstants.CENTER);
									temp.setEditable(false);
									temp.setColumns(10);
									temp.setBounds(660, 20 + i*20, 150, 20);
									printout_SO.add(temp);
									
									
									temp = new JTextField();
									temp.setText(ticket.getPassengerType());
									temp.setHorizontalAlignment(SwingConstants.CENTER);
									temp.setEditable(false);
									temp.setColumns(10);
									temp.setBounds(810, 20 + i*20, 100, 20);
									printout_SO.add(temp);
									
									
									temp = new JTextField();
									temp.setText(ticket.getCarriage());
									temp.setHorizontalAlignment(SwingConstants.CENTER);
									temp.setEditable(false);
									temp.setColumns(10);
									temp.setBounds(910, 20 + i*20, 100, 20);
									printout_SO.add(temp);
									
									
									temp = new JTextField();
									temp.setText(ticket.getEarlyDiscount());
									temp.setHorizontalAlignment(SwingConstants.CENTER);
									temp.setEditable(false);
									temp.setColumns(10);
									temp.setBounds(1010, 20 + i*20, 100, 20);
									printout_SO.add(temp);
									
									
									temp = new JTextField();
									temp.setText("CarNO. " + ticket.getCompartment() + " " + ticket.getLocation());
									temp.setHorizontalAlignment(SwingConstants.CENTER);
									temp.setEditable(false);
									temp.setColumns(10);
									temp.setBounds(1110, 20 + i*20, 100, 20);
									printout_SO.add(temp);
									
									
									temp = new JTextField();
									temp.setText(ticket.getPrice());
									temp.setHorizontalAlignment(SwingConstants.CENTER);
									temp.setEditable(false);
									temp.setColumns(10);
									temp.setBounds(1210, 20 + i*20, 100, 20);
									printout_SO.add(temp);
									
									
									
									
									JButton_with_number btnCancel = new JButton_with_number("Cancel", i);
									
									btnCancel.jbutton.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											
											try {
												Scanner sc = new Scanner(System.in);
												Socket cs = new Socket("127.0.0.1", 3588); 
												ObjectOutputStream os = new ObjectOutputStream(cs.getOutputStream());
												ObjectInputStream is = new ObjectInputStream(cs.getInputStream());

												
												//target the ticket that will be cancel
												Ticket cancel_ticketMessage = cancel_order.get(btnCancel.index);
												System.out.println(cancel_ticketMessage.toString());
												
												//send to sever
												os.writeObject(cancel_ticketMessage);
												os.flush();
												
												Object msg = (Object) is.readObject();
												if (msg == null)
													System.out.println("null");
												
												
												//if the server send back a OrderResult for confirm ----> success
												
												if (msg.getClass() == new Success_Message().getClass()) {
													System.out.println("success return after canceling the ticket");
													printout_SO.removeAll();
													btnSearchOrder.doClick();
												}
												else if (msg.getClass() == new OrderResult().getClass()) {
													
												}
//														else if(msg.getClass() == new Status().getClass()) {
//															
//														}
												else if(msg.getClass() == new AlterResult().getClass()) {
													
												}
												else
													System.out.println("can't read result from canceling the ticket");
												os.close();
												is.close();
												cs.close();
												
												
											} catch (UnknownHostException e_2) {
												e_2.printStackTrace();
												System.out.println("connection error");
											} catch (IOException e_2) {
												e_2.printStackTrace();
												System.out.println("IO error");
											} catch (ClassNotFoundException e_2) {
												e_2.printStackTrace();
												System.out.println("Class Not Found error");
											}
											

										}
									});
									btnCancel.jbutton.setBounds(1310, 20 + i*20, 100, 20);
									btnCancel.jbutton.setHorizontalAlignment(SwingConstants.LEFT);
									printout_SO.add(btnCancel.jbutton);
									
									
									
									
									
									i++;
									
							}
						}
							

							printout_SO.repaint();
							printout_SO.revalidate();
							
						}
						else
							System.out.println("can't read result1");
						os.close();
						is.close();
						cs.close();
					} catch (UnknownHostException e) {
						e.printStackTrace();
						System.out.println("connection error");
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("IO error");
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
						System.out.println("Class Not Found error");
					}
					
				}
				
				
				
				
			}
		});
		btnSearchOrder.setBounds(650, 10, 80, 20);
		SearchOrder.add(btnSearchOrder);
		
		txtTransactionNumber = new JTextField();
		txtTransactionNumber.setFont(new Font("·L³n¥¿¶ÂÅé", Font.PLAIN, 12));
		txtTransactionNumber.setText("Transaction NO.");
		txtTransactionNumber.setHorizontalAlignment(SwingConstants.CENTER);
		txtTransactionNumber.setEditable(false);
		txtTransactionNumber.setColumns(10);
		txtTransactionNumber.setBounds(330, 11, 100, 20);
		SearchOrder.add(txtTransactionNumber);
		
		SearchTransacationNum = new JButton("Forget Transaction Number?");
		SearchTransacationNum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//removing panels
				layeredPane.removeAll();
				layeredPane.repaint();
				layeredPane.revalidate();

				layeredPane.setVisible(true);
				//adding panel-SearchOrder_byTN
				layeredPane.add(SearchOrder_byTN);
				layeredPane.repaint();
				layeredPane.revalidate();
				layeredPane.setVisible(true);
			}
		});
		SearchTransacationNum.setBounds(1010, 10, 200, 20);
		SearchOrder.add(SearchTransacationNum);
		
		
	/**
	 * As we push "Booking", it will change to the booking pane	
	 */
		
		JButton btnNewButton = new JButton("Booking");
		btnNewButton.setForeground(new Color(51, 51, 51));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//removing panels
				layeredPane.removeAll();
				layeredPane.repaint();
				layeredPane.revalidate();

				
				//adding panel-booking
				layeredPane.add(Booking);
				layeredPane.repaint();
				layeredPane.revalidate();
				layeredPane.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 12));
		panel.add(btnNewButton);
		
		
		
		/**
		 *  As we push "Booking History", it will change to the SearchOrder pane	
		 */
				
		JButton btnBookingHistory= new JButton("Booking History");
		btnBookingHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//removing panels
				layeredPane.removeAll();
				layeredPane.repaint();
				layeredPane.revalidate();
				layeredPane.setVisible(true);
				
				//adding panel-booking history
				layeredPane.add(SearchOrder);
				layeredPane.repaint();
				layeredPane.revalidate();
				layeredPane.setVisible(true);
			}
		});
		btnBookingHistory.setFont(new Font("Dialog", Font.BOLD, 12));
		panel.add(btnBookingHistory);
		/**
		 *  As we push "Search", it will change to the Search pane	
		 */
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//removing panels
				layeredPane.removeAll();
				layeredPane.repaint();
				layeredPane.revalidate();
				layeredPane.setVisible(true);				
				//adding panel-Search
				layeredPane.add(Search);
				layeredPane.repaint();
				layeredPane.revalidate();
				layeredPane.setVisible(true);
			}
		});
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(btnNewButton_2);
				
				

				
				JScrollPane visual = new JScrollPane(Available,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				//visual.setViewportView(Available);
				visual.setBounds(0, 72, 1624, 1014);
				visual.setSize(1624, 614);
//				visual.setVisible(true);
//				visual.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				
				

				
				printout_SOTN = new JPanel();
				printout_SOTN.setBackground(Color.GREEN);
				printout_SOTN.setBounds(0, 60, 1624, 424);
				SearchOrder_byTN.add(printout_SOTN);
				printout_SOTN.setLayout(null);
				
				txtItinerary = new JTextField();
				txtItinerary.setBackground(Color.LIGHT_GRAY);
				txtItinerary.setFont(new Font("Dialog", Font.BOLD, 12));
				txtItinerary.setHorizontalAlignment(SwingConstants.CENTER);
				txtItinerary.setEditable(false);
				txtItinerary.setText("Itinerary");
				txtItinerary.setBounds(0, 0, 130, 20);
				SearchOrder_byTN.add(txtItinerary);
				txtItinerary.setColumns(10);
				

				
				txtDatetime = new JTextField();
				txtDatetime.setText("Date");
				txtDatetime.setHorizontalAlignment(SwingConstants.CENTER);
				txtDatetime.setFont(new Font("Dialog", Font.BOLD, 12));
				txtDatetime.setEditable(false);
				txtDatetime.setColumns(10);
				txtDatetime.setBackground(Color.LIGHT_GRAY);
				txtDatetime.setBounds(0, 20, 130, 20);
				SearchOrder_byTN.add(txtDatetime);
				
				txtFrom = new JTextField();
				txtFrom.setEditable(false);
				txtFrom.setText("From");
				txtFrom.setBounds(135, 0, 50, 20);
				SearchOrder_byTN.add(txtFrom);
				txtFrom.setColumns(10);
				
				JComboBox comdepartStation = new JComboBox();
				comdepartStation.setModel(new DefaultComboBoxModel(Station.values()));
				comdepartStation.setBounds(190, 0, 110, 20);
				SearchOrder_byTN.add(comdepartStation);
				
				txtTo = new JTextField();
				txtTo.setText("to");
				txtTo.setEditable(false);
				txtTo.setColumns(10);
				txtTo.setBounds(305, 0, 20, 20);
				SearchOrder_byTN.add(txtTo);
				
				
				JComboBox comarriveStation = new JComboBox();
				comarriveStation.setModel(new DefaultComboBoxModel(Station.values()));
				comarriveStation.setBounds(330, 0, 110, 20);
				SearchOrder_byTN.add(comarriveStation);
				
				UtilDateModel model = new UtilDateModel();
				model.setSelected(true);
				Properties p = new Properties();
				p.put("text.today", "Today");
				p.put("text.month", "Month");
				p.put("text.year", "Year");
				JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
				
				JDatePickerImpl departDay = new JDatePickerImpl(datePanel, new DateLabelFormatter());
				departDay.setDoubleClickAction(true);
				departDay.setButtonFocusable(true);
				departDay.setSize(150, 20);
				departDay.setLocation(135, 20);
				SearchOrder_byTN.add(departDay);
				
				txtCarid_2 = new JTextField();
				txtCarid_2.setText("UserID");
				txtCarid_2.setHorizontalAlignment(SwingConstants.CENTER);
				txtCarid_2.setFont(new Font("Dialog", Font.BOLD, 12));
				txtCarid_2.setEditable(false);
				txtCarid_2.setColumns(10);
				txtCarid_2.setBackground(Color.LIGHT_GRAY);
				txtCarid_2.setBounds(455, 0, 130, 20);
				SearchOrder_byTN.add(txtCarid_2);
				
				textField_3 = new JTextField();
				textField_3.setText("CarID");
				textField_3.setHorizontalAlignment(SwingConstants.CENTER);
				textField_3.setFont(new Font("Dialog", Font.BOLD, 12));
				textField_3.setEditable(false);
				textField_3.setColumns(10);
				textField_3.setBackground(Color.LIGHT_GRAY);
				textField_3.setBounds(455, 20, 130, 20);
				SearchOrder_byTN.add(textField_3);
				
				bytn_UserID_input = new JTextField();
				bytn_UserID_input.setHorizontalAlignment(SwingConstants.CENTER);
				bytn_UserID_input.setFont(new Font("Dialog", Font.BOLD, 12));
				bytn_UserID_input.setColumns(10);
				bytn_UserID_input.setBackground(Color.WHITE);
				bytn_UserID_input.setBounds(590, 0, 200, 20);
				SearchOrder_byTN.add(bytn_UserID_input);
				
				bytn_CarID_input = new JTextField();
				bytn_CarID_input.setHorizontalAlignment(SwingConstants.CENTER);
				bytn_CarID_input.setFont(new Font("Dialog", Font.BOLD, 12));
				bytn_CarID_input.setColumns(10);
				bytn_CarID_input.setBackground(Color.WHITE);
				bytn_CarID_input.setBounds(590, 20, 200, 20);
				SearchOrder_byTN.add(bytn_CarID_input);
				
				bytn_btn_Search = new JButton("Search");
				bytn_btn_Search.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						SearchTransactionNumber SearchOrderMessage_bytn = new SearchTransactionNumber();
						
						SearchOrderMessage_bytn.setUserID(bytn_UserID_input.getText());
						SearchOrderMessage_bytn.setCarID(bytn_CarID_input.getText());
						SearchOrderMessage_bytn.setDepart(comdepartStation.getSelectedItem().toString());
						SearchOrderMessage_bytn.setArrive(comarriveStation.getSelectedItem().toString());
						SearchOrderMessage_bytn.setDepartDay(departDay.getJFormattedTextField().getText().toString());
						
						if(bytn_UserID_input.getText().equals("")) {
							//do nothing at following function
							System.out.println("Please input your userID");

						}
						
						else if(bytn_CarID_input.getText().equals("")) {
							//do nothing at following function
							System.out.println("Please input CarID");
						}
						
						
						else {
							try {
								Scanner sc = new Scanner(System.in);
								Socket cs = new Socket("127.0.0.1", 3588); 
								ObjectOutputStream os = new ObjectOutputStream(cs.getOutputStream());
								ObjectInputStream is = new ObjectInputStream(cs.getInputStream());
								
								os.writeObject(SearchOrderMessage_bytn);
								os.flush();
								Object msg = (Object) is.readObject();
								
								if (msg == null)
									System.out.println("null");
								
								if (msg.getClass() == new OrderResult().getClass()) {
									System.out.println("successfully get the OrderResult_by transaction number");
									
									//order_result is the local memory pointer to catch the information of msg
									order_result = (OrderResult) msg;

									if(order_result.getOrderResult().isEmpty()) {
										System.out.println("Result 404 not find");
									}
									
									
									
									else {
									/**
									 * Creating the headline
									 */
										
									cancel_order = (LinkedList<Ticket>) order_result.getOrderResult().clone();
									
									textField_4 = new JTextField();
									textField_4.setText("Transaction NO.");
									textField_4.setHorizontalAlignment(SwingConstants.CENTER);
									textField_4.setEditable(false);
									textField_4.setColumns(10);
									textField_4.setBounds(10, 0, 100, 20);
									printout_SOTN.add(textField_4);
									
									
									
									textField_4 = new JTextField();
									textField_4.setText("UserID");
									textField_4.setHorizontalAlignment(SwingConstants.CENTER);
									textField_4.setEditable(false);
									textField_4.setColumns(10);
									textField_4.setBounds(110, 0, 100, 20);
									printout_SOTN.add(textField_4);
									
									txtCarid_1 = new JTextField();
									txtCarid_1.setText("CarID");
									txtCarid_1.setHorizontalAlignment(SwingConstants.CENTER);
									txtCarid_1.setEditable(false);
									txtCarid_1.setColumns(10);
									txtCarid_1.setBounds(210, 0, 100, 20);
									printout_SOTN.add(txtCarid_1);
									
									txtDepartStation = new JTextField();
									txtDepartStation.setText("Depart Station");
									txtDepartStation.setHorizontalAlignment(SwingConstants.CENTER);
									txtDepartStation.setEditable(false);
									txtDepartStation.setColumns(10);
									txtDepartStation.setBounds(310, 0, 100, 20);
									printout_SOTN.add(txtDepartStation);
									
									txtDepartTime_1 = new JTextField();
									txtDepartTime_1.setText("Depart Time");
									txtDepartTime_1.setHorizontalAlignment(SwingConstants.CENTER);
									txtDepartTime_1.setEditable(false);
									txtDepartTime_1.setColumns(10);
									txtDepartTime_1.setBounds(410, 0, 150, 20);
									printout_SOTN.add(txtDepartTime_1);
									
									txtArriveStation = new JTextField();
									txtArriveStation.setText("Arrive Station");
									txtArriveStation.setHorizontalAlignment(SwingConstants.CENTER);
									txtArriveStation.setEditable(false);
									txtArriveStation.setColumns(10);
									txtArriveStation.setBounds(560, 0, 100, 20);
									printout_SOTN.add(txtArriveStation);
									
									txtArriveTime_1 = new JTextField();
									txtArriveTime_1.setText("Arrive Time");
									txtArriveTime_1.setHorizontalAlignment(SwingConstants.CENTER);
									txtArriveTime_1.setEditable(false);
									txtArriveTime_1.setColumns(10);
									txtArriveTime_1.setBounds(660, 0, 150, 20);
									printout_SOTN.add(txtArriveTime_1);
									
									txtPassenterType = new JTextField();
									txtPassenterType.setText("Passenger Type");
									txtPassenterType.setHorizontalAlignment(SwingConstants.CENTER);
									txtPassenterType.setEditable(false);
									txtPassenterType.setColumns(10);
									txtPassenterType.setBounds(810, 0, 100, 20);
									printout_SOTN.add(txtPassenterType);
									
									txtCarriage = new JTextField();
									txtCarriage.setText("Carriage");
									txtCarriage.setHorizontalAlignment(SwingConstants.CENTER);
									txtCarriage.setEditable(false);
									txtCarriage.setColumns(10);
									txtCarriage.setBounds(910, 0, 100, 20);
									printout_SOTN.add(txtCarriage);
									
									txtEarlyDiscount = new JTextField();
									txtEarlyDiscount.setText("Early Discount");
									txtEarlyDiscount.setHorizontalAlignment(SwingConstants.CENTER);
									txtEarlyDiscount.setEditable(false);
									txtEarlyDiscount.setColumns(10);
									txtEarlyDiscount.setBounds(1010, 0, 100, 20);
									printout_SOTN.add(txtEarlyDiscount);
									
									txtCarnoLocated = new JTextField();
									txtCarnoLocated.setText("CarNO.  Located");
									txtCarnoLocated.setHorizontalAlignment(SwingConstants.CENTER);
									txtCarnoLocated.setEditable(false);
									txtCarnoLocated.setColumns(10);
									txtCarnoLocated.setBounds(1110, 0, 100, 20);
									printout_SOTN.add(txtCarnoLocated);
									

									txtPrice = new JTextField();
									txtPrice.setText("Price");
									txtPrice.setHorizontalAlignment(SwingConstants.CENTER);
									txtPrice.setEditable(false);
									txtPrice.setColumns(10);
									txtPrice.setBounds(1210, 0, 100, 20);
									printout_SOTN.add(txtPrice);
									
									
									/*
									 * create the table of tickets
									 */
									
									int i = 0;
									
									while(!order_result.getOrderResult().isEmpty()) {
									
										Ticket ticket = order_result.getOrderResult().pollFirst();

											JTextField temp = new JTextField();
											temp.setText(ticket.getTransactionNumber());
											temp.setHorizontalAlignment(SwingConstants.CENTER);
											temp.setEditable(false);
											temp.setColumns(10);
											temp.setBounds(10, 20 + i * 20, 100, 20);
											printout_SOTN.add(temp);

											temp = new JTextField();
											temp.setText(ticket.getUserID());
											temp.setHorizontalAlignment(SwingConstants.CENTER);
											temp.setEditable(false);
											temp.setColumns(10);
											temp.setBounds(110, 20 + i*20, 100, 20);
											printout_SOTN.add(temp);
											
											
											temp = new JTextField();
											temp.setText(ticket.getCarID());
											temp.setHorizontalAlignment(SwingConstants.CENTER);
											temp.setEditable(false);
											temp.setColumns(10);
											temp.setBounds(210, 20 + i*20, 100, 20);
											printout_SOTN.add(temp);
											
											
											temp = new JTextField();
											temp.setText(ticket.getDepart());
											temp.setHorizontalAlignment(SwingConstants.CENTER);
											temp.setEditable(false);
											temp.setColumns(10);
											temp.setBounds(310, 20 + i*20, 100, 20);
											printout_SOTN.add(temp);
											
											
											temp = new JTextField();
											temp.setText(ticket.getDepartTime());
											temp.setHorizontalAlignment(SwingConstants.CENTER);
											temp.setEditable(false);
											temp.setColumns(10);
											temp.setBounds(410, 20 + i*20, 150, 20);
											printout_SOTN.add(temp);
											
											
											temp = new JTextField();
											temp.setText(ticket.getArrive());
											temp.setHorizontalAlignment(SwingConstants.CENTER);
											temp.setEditable(false);
											temp.setColumns(10);
											temp.setBounds(560, 20 + i*20, 100, 20);
											printout_SOTN.add(temp);
											
											
											temp = new JTextField();
											temp.setText(ticket.getArriveTime());
											temp.setHorizontalAlignment(SwingConstants.CENTER);
											temp.setEditable(false);
											temp.setColumns(10);
											temp.setBounds(660, 20 + i*20, 150, 20);
											printout_SOTN.add(temp);
											
											
											temp = new JTextField();
											temp.setText(ticket.getPassengerType());
											temp.setHorizontalAlignment(SwingConstants.CENTER);
											temp.setEditable(false);
											temp.setColumns(10);
											temp.setBounds(810, 20 + i*20, 100, 20);
											printout_SOTN.add(temp);
											
											
											temp = new JTextField();
											temp.setText(ticket.getCarriage());
											temp.setHorizontalAlignment(SwingConstants.CENTER);
											temp.setEditable(false);
											temp.setColumns(10);
											temp.setBounds(910, 20 + i*20, 100, 20);
											printout_SOTN.add(temp);
											
											
											temp = new JTextField();
											temp.setText(ticket.getEarlyDiscount());
											temp.setHorizontalAlignment(SwingConstants.CENTER);
											temp.setEditable(false);
											temp.setColumns(10);
											temp.setBounds(1010, 20 + i*20, 100, 20);
											printout_SOTN.add(temp);
											
											
											temp = new JTextField();
											temp.setText("CarNO. " + ticket.getCompartment() + " " + ticket.getLocation());
											temp.setHorizontalAlignment(SwingConstants.CENTER);
											temp.setEditable(false);
											temp.setColumns(10);
											temp.setBounds(1110, 20 + i*20, 100, 20);
											printout_SOTN.add(temp);
											
											
											temp = new JTextField();
											temp.setText(ticket.getPrice());
											temp.setHorizontalAlignment(SwingConstants.CENTER);
											temp.setEditable(false);
											temp.setColumns(10);
											temp.setBounds(1210, 20 + i*20, 100, 20);
											printout_SOTN.add(temp);
											
											
											
											
											JButton_with_number btnCancel = new JButton_with_number("Cancel", i);
											
											btnCancel.jbutton.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													
													try {
														Scanner sc = new Scanner(System.in);
														Socket cs = new Socket("127.0.0.1", 3588); 
														ObjectOutputStream os = new ObjectOutputStream(cs.getOutputStream());
														ObjectInputStream is = new ObjectInputStream(cs.getInputStream());

														
														//target the ticket that will be cancel
														Ticket cancel_ticketMessage = cancel_order.get(btnCancel.index);
														
														System.out.println(cancel_ticketMessage.toString());
														//send to server
														os.writeObject(cancel_ticketMessage);
														os.flush();
														
														Object msg = (Object) is.readObject();
														if (msg == null)
															System.out.println("null");
														
														
														//if the server send back a OrderResult for confirm ----> success
														
														if (msg.getClass() == new Success_Message().getClass()) {
															System.out.println("success return after canceling the ticket ( in bytn mode)");
															printout_SOTN.removeAll();
															bytn_btn_Search.doClick();
														}
														else if (msg.getClass() == new OrderResult().getClass()) {
															
														}
//														else if(msg.getClass() == new Status().getClass()) {
//															
//														}
														else if(msg.getClass() == new AlterResult().getClass()) {
															
														}
														else
															System.out.println("can't read result from canceling the ticket");
														os.close();
														is.close();
														cs.close();
														
														
													} catch (UnknownHostException e_2) {
														e_2.printStackTrace();
														System.out.println("connection error");
													} catch (IOException e_2) {
														e_2.printStackTrace();
														System.out.println("IO error");
													} catch (ClassNotFoundException e_2) {
														e_2.printStackTrace();
														System.out.println("Class Not Found error");
													}
													

												}
											});
											btnCancel.jbutton.setBounds(1310, 20 + i*20, 100, 20);
											btnCancel.jbutton.setHorizontalAlignment(SwingConstants.LEFT);
											printout_SOTN.add(btnCancel.jbutton);
											
											
											
											
											
											i++;
											
									}
								}
									

									printout_SOTN.repaint();
									printout_SOTN.revalidate();
									
								}
								else
									System.out.println("can't read result1");
								os.close();
								is.close();
								cs.close();
							} catch (UnknownHostException e1) {
								e1.printStackTrace();
								System.out.println("connection error");
							} catch (IOException e1) {
								e1.printStackTrace();
								System.out.println("IO error");
							} catch (ClassNotFoundException e1) {
								e1.printStackTrace();
								System.out.println("Class Not Found error");
							}
							
						}
						
					}
				});
				bytn_btn_Search.setBounds(818, 3, 80, 20);
				SearchOrder_byTN.add(bytn_btn_Search);
		

		
		

		/**
		 * setting searchorder_bytn pane
		 */


		
		/**
		 * setting over
		 */		
		
		
		txtItinerary = new JTextField();
		txtItinerary.setBackground(Color.LIGHT_GRAY);
		txtItinerary.setFont(new Font("Dialog", Font.BOLD, 12));
		txtItinerary.setHorizontalAlignment(SwingConstants.CENTER);
		txtItinerary.setEditable(false);
		txtItinerary.setText("Itinerary");
		txtItinerary.setBounds(0, 3, 130, 20);
		Booking.add(txtItinerary);
		txtItinerary.setColumns(10);
		
		txtClass = new JTextField();
		txtClass.setBackground(Color.LIGHT_GRAY);
		txtClass.setText("Class");
		txtClass.setHorizontalAlignment(SwingConstants.CENTER);
		txtClass.setFont(new Font("Dialog", Font.BOLD, 12));
		txtClass.setEditable(false);
		txtClass.setColumns(10);
		txtClass.setBounds(0, 26, 130, 20);
		Booking.add(txtClass);
		
		txtSeatPreference = new JTextField();
		txtSeatPreference.setBackground(Color.LIGHT_GRAY);
		txtSeatPreference.setText("Seat Preference");
		txtSeatPreference.setHorizontalAlignment(SwingConstants.CENTER);
		txtSeatPreference.setFont(new Font("Dialog", Font.BOLD, 12));
		txtSeatPreference.setEditable(false);
		txtSeatPreference.setColumns(10);
		txtSeatPreference.setBounds(0, 49, 130, 20);
		Booking.add(txtSeatPreference);
		
		txtDatetime = new JTextField();
		txtDatetime.setText("Date/Time");
		txtDatetime.setHorizontalAlignment(SwingConstants.CENTER);
		txtDatetime.setFont(new Font("Dialog", Font.BOLD, 12));
		txtDatetime.setEditable(false);
		txtDatetime.setColumns(10);
		txtDatetime.setBackground(Color.LIGHT_GRAY);
		txtDatetime.setBounds(0, 72, 130, 20);
		Booking.add(txtDatetime);
		
		txtFrom = new JTextField();
		txtFrom.setEditable(false);
		txtFrom.setText("From");
		txtFrom.setBounds(135, 3, 50, 20);
		Booking.add(txtFrom);
		txtFrom.setColumns(10);
		
		JComboBox comdepartStation1 = new JComboBox();
		comdepartStation1.setModel(new DefaultComboBoxModel(Station.values()));
		comdepartStation1.setBounds(190, 3, 110, 20);
		Booking.add(comdepartStation1);
		
		txtTo = new JTextField();
		txtTo.setText("to");
		txtTo.setEditable(false);
		txtTo.setColumns(10);
		txtTo.setBounds(305, 3, 20, 20);
		Booking.add(txtTo);
		
		
		
		
		JComboBox comarriveStation1 = new JComboBox();
		comarriveStation1.setModel(new DefaultComboBoxModel(Station.values()));
		comarriveStation1.setBounds(330, 3, 110, 20);
		Booking.add(comarriveStation1);
		
		JComboBox comCarriage = new JComboBox();
		comCarriage.setModel(new DefaultComboBoxModel(Carriage.values()));
		comCarriage.setBounds(135, 26, 110, 20);
		Booking.add(comCarriage);
		
		
		//return option

		UtilDateModel model_return = new UtilDateModel();
		model_return.setSelected(true);
		Properties d = new Properties();
		d.put("text.today", "Today");
		d.put("text.month", "Month");
		d.put("text.year", "Year");
		JDatePanelImpl datePanel_return = new JDatePanelImpl(model_return, d);
		JDatePickerImpl datePicker_return_trip = new JDatePickerImpl(datePanel_return, new DateLabelFormatter());
		datePicker_return_trip.setSize(150, 20);
		datePicker_return_trip.setLocation(220, 95);
		

		txtInbound = new JTextField();
		txtInbound.setText("Inbound");
		txtInbound.setEditable(false);
		txtInbound.setColumns(10);
		txtInbound.setBounds(135, 95, 80, 20);
		
		
		JSpinner departHour_re = new JSpinner();
		departHour_re.setBounds(375, 95, 40, 20);
		
		textField_2 = new JTextField();
		textField_2.setText(":");
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(420, 95, 10, 20);

		
		JSpinner departMinute_re = new JSpinner();
		departMinute_re.setBounds(435, 95, 40, 20);
		//return option end
		
		
		UtilDateModel model1 = new UtilDateModel();
		model1.setSelected(true);
		Properties p1 = new Properties();
		p1.put("text.today", "Today");
		p1.put("text.month", "Month");
		p1.put("text.year", "Year");
		JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, p1);
		
		
		
		JComboBox comSeat = new JComboBox();
		comSeat.setModel(new DefaultComboBoxModel(Seat.values()));
		comSeat.setBounds(135, 49, 110, 20);
		Booking.add(comSeat);
		JDatePickerImpl departDay1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
		departDay1.setDoubleClickAction(true);
		departDay1.setButtonFocusable(true);
		departDay1.setSize(150, 20);
		departDay1.setLocation(220, 72);
		Booking.add(departDay1);
		
		txtOutbound = new JTextField();
		txtOutbound.setText("Outbound");
		txtOutbound.setEditable(false);
		txtOutbound.setColumns(10);
		txtOutbound.setBounds(135, 72, 80, 20);
		Booking.add(txtOutbound);
		
		JSpinner departHour = new JSpinner();
		departHour.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		departHour.setBounds(375, 72, 40, 20);
		Booking.add(departHour);
		
		textField = new JTextField();
		textField.setText(":");
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(420, 72, 10, 20);
		Booking.add(textField);
		
		JSpinner departMinute = new JSpinner();
		departMinute.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		departMinute.setBounds(435, 72, 40, 20);
		Booking.add(departMinute);
		
		textField_1 = new JTextField();
		textField_1.setText("Passengers");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Dialog", Font.BOLD, 12));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setBounds(0, 118, 130, 20);
		Booking.add(textField_1);
		
		
		
		

		
		
		JRadioButton rdbtnReturnTrip = new JRadioButton("Return Trip");
		rdbtnReturnTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnReturnTrip.isSelected()) {

					Booking.add(datePicker_return_trip);
					Booking.add(txtInbound);
					Booking.add(departHour_re);
					Booking.add(textField_2);
					Booking.add(departMinute_re);
					Booking.repaint();
					Booking.revalidate();
				}
				else {
					Booking.remove(datePicker_return_trip);
					Booking.remove(txtInbound);
					Booking.remove(departHour_re);
					Booking.remove(textField_2);
					Booking.remove(departMinute_re);
					Booking.repaint();
					Booking.revalidate();

				}
			}
		});
		rdbtnReturnTrip.setBounds(0, 95, 130, 20);
		Booking.add(rdbtnReturnTrip);
		
		txtNormal = new JTextField();
		txtNormal.setText("Normal");
		txtNormal.setEditable(false);
		txtNormal.setColumns(10);
		txtNormal.setBounds(135, 118, 50, 20);
		Booking.add(txtNormal);
		
		JSpinner normalTicket = new JSpinner();
		normalTicket.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		normalTicket.setBounds(190, 118, 40, 20);
		Booking.add(normalTicket);
		
		txtChild = new JTextField();
		txtChild.setText("Child");
		txtChild.setEditable(false);
		txtChild.setColumns(10);
		txtChild.setBounds(235, 118, 50, 20);
		Booking.add(txtChild);
		
		JSpinner childTicket = new JSpinner();
		childTicket.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		childTicket.setBounds(290, 118, 40, 20);
		Booking.add(childTicket);
		
		txtElder = new JTextField();
		txtElder.setText("Elder");
		txtElder.setEditable(false);
		txtElder.setColumns(10);
		txtElder.setBounds(335, 118, 50, 20);
		Booking.add(txtElder);
		
		JSpinner elderTicket = new JSpinner();
		elderTicket.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		elderTicket.setBounds(390, 118, 40, 20);
		Booking.add(elderTicket);
		
		txtDisable = new JTextField();
		txtDisable.setText("Disable");
		txtDisable.setEditable(false);
		txtDisable.setColumns(10);
		txtDisable.setBounds(135, 141, 50, 20);
		Booking.add(txtDisable);
		
		JSpinner disableTicket = new JSpinner();
		disableTicket.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		disableTicket.setBounds(190, 141, 40, 20);
		Booking.add(disableTicket);
		
		txtStudent = new JTextField();
		txtStudent.setFont(new Font("Dialog", Font.PLAIN, 11));
		txtStudent.setText("Student");
		txtStudent.setEditable(false);
		txtStudent.setColumns(10);
		txtStudent.setBounds(235, 141, 50, 20);
		Booking.add(txtStudent);
		
		JSpinner studentTicket = new JSpinner();
		studentTicket.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		studentTicket.setBounds(290, 141, 40, 20);
		Booking.add(studentTicket);
		
		
/**
 * As we push the button "Search Car"		
 */
		
		JButton btnNewButton_3 = new JButton("Search Car");
		btnNewButton_3.setBounds(360, 260, 117, 25);
		Booking.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean vail = true;

				SearchCar SearchCarMessage = new SearchCar();
				/**
				 * Set the information of the conditions that user wants
				 */
				SearchCarMessage.setDepart(comdepartStation1.getSelectedItem().toString());
				SearchCarMessage.setArrive(comarriveStation1.getSelectedItem().toString());
				SearchCarMessage.setSeat(comSeat.getSelectedItem().toString());
				SearchCarMessage.setCarriage(comCarriage.getSelectedItem().toString());
				SearchCarMessage.quantity[0] = (int) normalTicket.getValue();
			    SearchCarMessage.quantity[1] = (int) childTicket.getValue(); 
				SearchCarMessage.quantity[2] = (int) elderTicket.getValue();
				SearchCarMessage.quantity[3] = (int) disableTicket.getValue();
				SearchCarMessage.quantity[4] = (int) studentTicket.getValue();
				SearchCarMessage.setHour((int)departHour.getValue());
				SearchCarMessage.setMinute((int)departMinute.getValue());
				SearchCarMessage.setDepartDay(departDay1.getJFormattedTextField().getText().toString());
				
				//We have to remember the date, be cause the database will only return time without day

				
				//System.out.println(SearchCarMessage.toString());
				
				if(SearchCarMessage.getTotal()==0) {
					//do nothing at f0llowing function
					System.out.println("The quantity of tickets must not be zero");
					vail = false;
				}
				
				if(SearchCarMessage.getDepart().equals(SearchCarMessage.getArrive())) {
					//do nothing at following function
					System.out.println("The Depart Station can not be Arrive Station");
					vail = false;
				}
				
				if(SearchCarMessage.getHour() < 0 || SearchCarMessage.getHour()>=24  || SearchCarMessage.getMinute() >= 60 || SearchCarMessage.getMinute() < 0) {
					//do nothing at following function
					System.out.println("Invaild time setting");
					vail = false;
				}

				if((int)departHour_re.getValue() < 0 || (int)departHour_re.getValue()>=24  || (int)departMinute_re.getValue() >= 60 || (int)departMinute_re.getValue() < 0) {
					//do nothing at following function
					System.out.println("Invaild time setting");
					vail = false;
				}
				
				Date now = new Date();
				if(SearchCarMessage.getDepartDate_temp().before(now)) {
					System.out.println("You can't order the ticket in the pass.");
					vail = false;
				}
				
				
				//if no return trip order ---> send the SearchCar Message to server
				if(!rdbtnReturnTrip.isSelected() && vail) {
					try {
						Scanner sc = new Scanner(System.in);
						Socket cs = new Socket("127.0.0.1", 3588); 
						ObjectOutputStream os = new ObjectOutputStream(cs.getOutputStream());
						ObjectInputStream is = new ObjectInputStream(cs.getInputStream());
						
						os.writeObject(SearchCarMessage);
						os.flush();
						Object msg = (Object) is.readObject();
						if (msg == null)
							System.out.println("null");
						if (msg.getClass() == new Available().getClass()) {
							System.out.println("success_without return trip");
							
							info1 = (Available) msg;
							int quantity_of_available = info1.carList.size();
							
							
//							System.out.println(""+ quantity_of_available);
//							System.out.println(info1.carList.get(0).getDepart());
							
							if(quantity_of_available == 0) {
								System.out.println("No car was found.");
							}
							else {
								
								
								Available.removeAll();
								Available.repaint();
								Available.revalidate();
								Available.setVisible(true);
								
								
							for(int i=0 ; i<quantity_of_available ; i++)
							{
//								JTextField temp[] = new JTextField[11];
								for(int k=0 ; k<11 ; k++)
								{	
									JTextField temp = new JTextField();
									temp.setBackground(Color.LIGHT_GRAY);
									temp.setForeground(Color.BLACK);
									temp.setFont(new Font("Arial", Font.PLAIN, 12));
									temp.setEditable(false);
									
									switch(k) {
										case 0:
											temp.setText(info1.carList.get(i).getCarID());
											break;
										case 1:
											temp.setText(SearchCarMessage.getDepartDay() + "," + info1.carList.get(i).getDepartTime());
											break;
										case 2:
											temp.setText(info1.carList.get(i).getDepart());
											break;
										case 3:
											temp.setText(SearchCarMessage.getDepartDay() + "," + info1.carList.get(i).getArriveTime());
											break;
										case 4:	
											temp.setText(info1.carList.get(i).getArrive());
											break;
										case 5:
											temp.setText(SearchCarMessage.getCarriage());
											break;
										case 6:
											if(SearchCarMessage.getCarriage().equals("STANDARD")) {
											temp.setText(info1.carList.get(i).getRemained_Window_Standard_Seat());
											}
											else {
												temp.setText(info1.carList.get(i).getRemained_Window_Business_Seat());
											}
											break;
										case 7:
											if(SearchCarMessage.getCarriage().equals("STANDARD")) {
											temp.setText(info1.carList.get(i).getRemained_Aisle_Standard_Seat());
											}
											else {
												temp.setText(info1.carList.get(i).getRemained_Aisle_Business_Seat());
											}
											break;
										case 8:
											if(SearchCarMessage.getCarriage().equals("STANDARD")) {
											temp.setText(info1.carList.get(i).getRemained_None_Standard_Seat());
											}
											break;
										case 9:
											temp.setText(info1.carList.get(i).getEarly_Discount());
											break;
										case 10:
											temp.setText(info1.carList.get(i).getUniversity_Discount());
											break;
											
									}
									temp.setBounds(0+150*k, 20+20*i, 150, 20);
									temp.setColumns(10);
									Available.add(temp);
									
								}
							}
		/*
		 * As we push the button "Confirm"											
		 */
							JButton btnConfirm = new JButton("Confirm");
							btnConfirm.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									
									if(textinputUserID.getText().equals("")) {		
										System.out.println("Please input your userID");
									}
									else {
									
									String selected_carID = textinputCarID.getText();	
									String user_ID = textinputUserID.getText();
									temp_memory_userID = user_ID;
									
									Order selected_car = new Order(info1 , selected_carID , user_ID, SearchCarMessage);
									
									if(selected_car.getSelected_car() == null) {
										System.out.println("Please input carID again.");
									}
									else {
									try {
										Scanner sc = new Scanner(System.in);
										Socket cs = new Socket("127.0.0.1", 3588); 
										ObjectOutputStream os = new ObjectOutputStream(cs.getOutputStream());
										ObjectInputStream is = new ObjectInputStream(cs.getInputStream());
										/*
										 * send to the server
										 */
										os.writeObject(selected_car);
										os.flush();
										Object msg = (Object) is.readObject();
										if (msg == null)
											System.out.println("null");
										if (msg.getClass() == new OrderResult().getClass()) {
											System.out.println("Successful Order without return trip");
											
											OrderResult temp_result = (OrderResult)msg;
											temp_memory_transaction_number = temp_result.getOrderResult().get(0).getTransactionNumber();
											System.out.println(temp_memory_transaction_number);
											
											userID_input.setText(temp_memory_userID);
											TransactionNum_input.setText(temp_memory_transaction_number);
											btnBookingHistory.doClick();
											btnSearchOrder.doClick();
											
											
										}
										else
											System.out.println("can't read result1");
											
										os.close();
										is.close();
										cs.close();
									} catch (UnknownHostException e) {
										e.printStackTrace();
										System.out.println("connection error");
									} catch (IOException e) {
										e.printStackTrace();
										System.out.println("IO error");
									} catch (ClassNotFoundException e) {
										e.printStackTrace();
										System.out.println("Class Not Found error");
									}	
								}					
								}
							}
							});
							btnConfirm.setFont(new Font("Arial", Font.PLAIN, 16));
							btnConfirm.setBackground(new Color(238, 232, 170));
							btnConfirm.setBounds(445, 20, 89, 31);
							Available_Holder.add(btnConfirm);		
									
							//switch pane
							Available_Holder.add(visual,BorderLayout.CENTER);
							Available_Holder.setVisible(true);
							Available_Holder.repaint();
							Available_Holder.revalidate();
							
							layeredPane.removeAll();
							layeredPane.repaint();
							layeredPane.revalidate();
							layeredPane.setVisible(true);
							
							layeredPane.add(Available_Holder);
							layeredPane.repaint();
							layeredPane.revalidate();
							layeredPane.setVisible(true);
						}
						}
						else
							System.out.println("can't read result1");
						os.close();
						is.close();
						cs.close();
					} catch (UnknownHostException e) {
						e.printStackTrace();
						System.out.println("connection error");
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("IO error");
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
						System.out.println("Class Not Found error");
					}
					
				}
				
				
				
					
				// if return trip is ordered
				else if(rdbtnReturnTrip.isSelected() && vail) {
					
					try {
						Scanner sc = new Scanner(System.in);
						Socket cs = new Socket("127.0.0.1", 3588); 
						ObjectOutputStream os = new ObjectOutputStream(cs.getOutputStream());
						ObjectInputStream is = new ObjectInputStream(cs.getInputStream());
						
						os.writeObject(SearchCarMessage);
						os.flush();
						Object msg = (Object) is.readObject();
						if (msg == null)
							System.out.println("null");
						
						
						//After getting the info of departure
						if (msg.getClass() == new Available().getClass()) {
							System.out.println("Success of Departure trip, waiting for retirn trip searchcar success");
									
							info1 = (Available) msg;

							
							
							//change some parameter of SearchCarMessage
							SearchCarMessage.setArrive(comdepartStation1.getSelectedItem().toString());
							SearchCarMessage.setDepart(comarriveStation1.getSelectedItem().toString());
							SearchCarMessage.setHour((int)departHour_re.getValue());
							SearchCarMessage.setMinute((int)departMinute_re.getValue());
							SearchCarMessage.setDepartDay(datePicker_return_trip.getJFormattedTextField().getText().toString());
							System.out.println(SearchCarMessage.toString());
												
					//send again
							
							try {
								sc = new Scanner(System.in);
								cs = new Socket("127.0.0.1", 3588); 
								os = new ObjectOutputStream(cs.getOutputStream());
								is = new ObjectInputStream(cs.getInputStream());
							
								os.writeObject(SearchCarMessage);
								os.flush();
							
								msg = (Object) is.readObject();

								if (msg == null)
									System.out.println("null");
							
							// if the first arraylist is back, send another searchcar
								if (msg.getClass() == new Available().getClass()) {
									System.out.println("success2, got the return trip_available");					
								}
								else
									System.out.println("can't read result after searchcar");
								os.close();
								is.close();
								cs.close();
															
							} catch (UnknownHostException e) {
								e.printStackTrace();
								System.out.println("connection error");
							} catch (IOException e) {
								e.printStackTrace();
								System.out.println("IO error");
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
								System.out.println("Class Not Found error");
							}
							
						info2 = (Available) msg;
				/**
				 * This part is departure		
				 */
							int quantity_of_available = info1.carList.size();
							
							//clean the pane
							Available.removeAll();
							Available.repaint();
							Available.revalidate();
							Available.setVisible(true);
							
							for(int i=0 ; i<quantity_of_available ; i++)
							{
								//JTextField temp[] = new JTextField[11];
								for(int k=0 ; k<11 ; k++)
								{	
									
									JTextField temp = new JTextField();
									temp.setBackground(Color.LIGHT_GRAY);
									temp.setForeground(Color.BLACK);
									temp.setFont(new Font("Arial", Font.PLAIN, 15));
									temp.setEditable(false);
									
									switch(k) {
										case 0:
											temp.setText(info1.carList.get(i).getCarID());
											break;
										case 1:
											temp.setText(SearchCarMessage.getDepartDay() + "," + info1.carList.get(i).getDepartTime());
											break;
										case 2:
											temp.setText(info1.carList.get(i).getDepart());
											break;
										case 3:
											temp.setText(SearchCarMessage.getDepartDay() + "," + info1.carList.get(i).getArriveTime());
											break;
										case 4:	
											temp.setText(info1.carList.get(i).getArrive());
											break;
										case 5:
											temp.setText(SearchCarMessage.getCarriage());
											break;
										case 6:
											if(SearchCarMessage.getCarriage().equals("STANDARD")) {
											temp.setText(info1.carList.get(i).getRemained_Window_Standard_Seat());
											}
											else {
												temp.setText(info1.carList.get(i).getRemained_Window_Business_Seat());
											}
											break;
										case 7:
											if(SearchCarMessage.getCarriage().equals("STANDARD")) {
											temp.setText(info1.carList.get(i).getRemained_Aisle_Standard_Seat());
											}
											else {
												temp.setText(info1.carList.get(i).getRemained_Aisle_Business_Seat());
											}
											break;
										case 8:
											if(SearchCarMessage.getCarriage().equals("STANDARD")) {
											temp.setText(info1.carList.get(i).getRemained_None_Standard_Seat());
											}
											break;
										case 9:
											temp.setText(info1.carList.get(i).getEarly_Discount());
											break;
										case 10:
											temp.setText(info1.carList.get(i).getUniversity_Discount());
											break;
											
									}
									temp.setBounds(0+150*k, 20+20*i, 100, 20);
									Available.add(temp);
									temp.setColumns(10);
									
								}
							}
							
							System.out.println("Please choose the car you want. ");
							
							JButton btnConfirm1 = new JButton("Confirm");
							btnConfirm1.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									
			/*						if(userID_input.getText().equals("")) {		
										System.out.println("Please input your userID");
									}
			*/						
			//						else {
									
									String selected_carID1 = textinputCarID.getText();	
									String user_ID1 = textinputUserID.getText();
									Order selected_car1 = new Order(info1 , selected_carID1 , user_ID1, SearchCarMessage);
									
									/**
									 * change from here
									 */
									

									
									
									/**
									 * This part is return
									 */
									int quantity_of_available = info2.carList.size();
									
									//clean the pane
									Available.removeAll();
									Available.repaint();
									Available.revalidate();
									Available.setVisible(true);
									//remove button confirm1
									Available_Holder.remove(btnConfirm1);
									
									
									for(int i=0 ; i < quantity_of_available ; i++)
									{
										for(int k=0 ; k<11 ; k++)
										{	
											JTextField temp = new JTextField();
											temp.setBackground(Color.LIGHT_GRAY);
											temp.setForeground(Color.BLACK);
											temp.setFont(new Font("Arial", Font.PLAIN, 15));
											temp.setEditable(false);
											
											switch(k) {
												case 0:
													temp.setText(info2.carList.get(i).getCarID());
													break;
												case 1:
													temp.setText(SearchCarMessage.getDepartDay() + "," + info2.carList.get(i).getDepartTime());
													break;
												case 2:
													temp.setText(info2.carList.get(i).getDepart());
													break;
												case 3:
													temp.setText(SearchCarMessage.getDepartDay() + "," + info2.carList.get(i).getArriveTime());
													break;
												case 4:	
													temp.setText(info2.carList.get(i).getArrive());
													break;
												case 5:
													temp.setText(SearchCarMessage.getCarriage());
													break;
												case 6:
													if(SearchCarMessage.getCarriage().equals("STANDARD")) {
													temp.setText(info1.carList.get(i).getRemained_Window_Standard_Seat());
													}
													else {
														temp.setText(info1.carList.get(i).getRemained_Window_Business_Seat());
													}
													break;
												case 7:
													if(SearchCarMessage.getCarriage().equals("STANDARD")) {
													temp.setText(info1.carList.get(i).getRemained_Aisle_Standard_Seat());
													}
													else {
														temp.setText(info1.carList.get(i).getRemained_Aisle_Business_Seat());
													}
													break;
												case 8:
													if(SearchCarMessage.getCarriage().equals("STANDARD")) {
													temp.setText(info1.carList.get(i).getRemained_None_Standard_Seat());
													}
													break;
												case 9:
													temp.setText(info2.carList.get(i).getEarly_Discount());
													break;
												case 10:
													temp.setText(info2.carList.get(i).getUniversity_Discount());
													break;
													
											}
											temp.setBounds(0+150*k, 20+20*i, 100, 20);
											Available.add(temp);
											temp.setColumns(10);				
										}
									}
									/**
									 * This button is used to return the car_info of return.
									 */
									JButton btnConfirm2 = new JButton("Confirm");
									btnConfirm2.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
											
											if(textinputUserID.getText().equals("")) {		
												System.out.println("Please input your userID");
											}
											
											String selected_carID = textinputCarID.getText();	
											String user_ID = textinputUserID.getText();
											Order selected_car_return = new Order(info2 , selected_carID , user_ID, SearchCarMessage);
											
											//sending order1 -->depart
											try {
												Scanner sc = new Scanner(System.in);
												Socket cs = new Socket("127.0.0.1", 3588); 
												ObjectOutputStream os = new ObjectOutputStream(cs.getOutputStream());
												ObjectInputStream is = new ObjectInputStream(cs.getInputStream());
												
												os.writeObject(selected_car1);
												os.flush();
												Object msg = (Object) is.readObject();
												if (msg == null)
													System.out.println("null");
												if (msg.getClass() == new OrderResult().getClass()) {
													System.out.println("Successful Order the depart one with return trip");
													
												}
												else
													System.out.println("can't read result1");
													
												os.close();
												is.close();
												cs.close();
											} catch (UnknownHostException e) {
												e.printStackTrace();
												System.out.println("connection error");
											} catch (IOException e) {
												e.printStackTrace();
												System.out.println("IO error");
											} catch (ClassNotFoundException e) {
												e.printStackTrace();
												System.out.println("Class Not Found error");
											}
											
											//sending order2 -->return
											try {
												Scanner sc = new Scanner(System.in);
												Socket cs = new Socket("127.0.0.1", 3588); 
												ObjectOutputStream os = new ObjectOutputStream(cs.getOutputStream());
												ObjectInputStream is = new ObjectInputStream(cs.getInputStream());
												
												os.writeObject(selected_car_return);
												os.flush();
												Object msg = (Object) is.readObject();
												if (msg == null)
													System.out.println("null");
												if (msg.getClass() == new OrderResult().getClass()) {
													System.out.println("Successful Order the return trip");
													
													OrderResult temp_result = (OrderResult)msg;
													temp_memory_transaction_number = temp_result.getOrderResult().get(0).getTransactionNumber();
													userID_input.setText(temp_memory_userID);
													TransactionNum_input.setText(temp_memory_transaction_number);
													btnBookingHistory.doClick();
													btnSearchOrder.doClick();
												}
												else
													System.out.println("can't read result1");
													
												os.close();
												is.close();
												cs.close();
											} catch (UnknownHostException e) {
												e.printStackTrace();
												System.out.println("connection error");
											} catch (IOException e) {
												e.printStackTrace();
												System.out.println("IO error");
											} catch (ClassNotFoundException e) {
												e.printStackTrace();
												System.out.println("Class Not Found error");
											}	
																	
										}
									});
									btnConfirm2.setFont(new Font("Arial", Font.PLAIN, 16));
									btnConfirm2.setBackground(new Color(238, 232, 170));
									btnConfirm2.setBounds(445, 20, 89, 31);
									Available_Holder.add(btnConfirm2);
									Available_Holder.repaint();
									Available_Holder.revalidate();
									Available_Holder.setVisible(true);
									
									Available.repaint();
									Available.revalidate();
									Available.setVisible(true);

									
									layeredPane.removeAll();
									layeredPane.repaint();
									layeredPane.revalidate();
									layeredPane.setVisible(true);
									
									layeredPane.add(Available_Holder);
									layeredPane.repaint();
									layeredPane.revalidate();
									layeredPane.setVisible(true);
			//					}
								}
							});
							btnConfirm1.setFont(new Font("Arial", Font.PLAIN, 16));
							btnConfirm1.setBackground(new Color(238, 232, 170));
							btnConfirm1.setBounds(445, 20, 89, 31);
							Available_Holder.add(btnConfirm1);		
							
							//switch pane
							Available_Holder.add(visual);
							Available_Holder.repaint();
							Available_Holder.revalidate();
							Available_Holder.setVisible(true);
							
							layeredPane.removeAll();
							layeredPane.repaint();
							layeredPane.revalidate();
							layeredPane.setVisible(true);
							
							layeredPane.add(Available_Holder);
							layeredPane.repaint();
							layeredPane.revalidate();
							layeredPane.setVisible(true);

							
						}

						else
							System.out.println("can't read result1");
						os.close();
						is.close();
						cs.close();
					} catch (UnknownHostException e) {
						e.printStackTrace();
						System.out.println("connection error");
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("IO error");
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
						System.out.println("Class Not Found error");
					}
					
				}
	
			}
		});
		
		

		
		/**
		 * on the Booking History pane
		 * as we push the button "Search"
		 * 
		 * we send a message . SearchOrder to the server
		 */
		
		

		
		
	
		
		

		
		
		
		/**
		 * As we push the button "Booking"
		 */
		


				
				/**
				 * As we push the button, "Search Car"
				 */


	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
