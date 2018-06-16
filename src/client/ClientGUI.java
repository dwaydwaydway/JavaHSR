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
	
	private JTextField txtSeatwindow;
	private JTextField txtSeataisle;
	private JTextField txtSeatnone;
	private JTextField txtEarlybird;
	private JTextField txtPleaseInputThe;
	private JTextField textField_3;
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
		setBounds(100, 100, 1204, 544);
		this.setTitle("HSR Ticket System");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(10);
		contentPane.add(panel, BorderLayout.NORTH);
		
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		
		JPanel Available = new JPanel();
		Available.setBackground(Color.LIGHT_GRAY);
		Available.setBounds(0, 0, 972, 437);
		layeredPane.add(Available);
		Available.setLayout(null);
		
		txtCarid = new JTextField();
		txtCarid.setBackground(Color.PINK);
		txtCarid.setForeground(Color.BLACK);
		txtCarid.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCarid.setEditable(false);
		txtCarid.setText("CarID");
		txtCarid.setBounds(0, 0, 100, 20);
		Available.add(txtCarid);
		txtCarid.setColumns(10);
		
		txtDepartTime = new JTextField();
		txtDepartTime.setBackground(Color.PINK);
		txtDepartTime.setFont(new Font("Arial", Font.PLAIN, 15));
		txtDepartTime.setText("Depart Time");
		txtDepartTime.setEditable(false);
		txtDepartTime.setColumns(10);
		txtDepartTime.setBounds(100, 0, 100, 20);
		Available.add(txtDepartTime);
		
		txtArriveTime = new JTextField();
		txtArriveTime.setBackground(Color.PINK);
		txtArriveTime.setFont(new Font("Arial", Font.PLAIN, 15));
		txtArriveTime.setEditable(false);
		txtArriveTime.setText("Arrive Time");
		txtArriveTime.setBounds(200, 0, 100, 20);
		Available.add(txtArriveTime);
		txtArriveTime.setColumns(10);
		
		txtSeatwindow = new JTextField();
		txtSeatwindow.setEditable(false);
		txtSeatwindow.setBackground(Color.PINK);
		txtSeatwindow.setFont(new Font("Arial", Font.PLAIN, 15));
		txtSeatwindow.setText("Seat_Window");
		txtSeatwindow.setBounds(300, 0, 100, 20);
		Available.add(txtSeatwindow);
		txtSeatwindow.setColumns(10);
		
		txtSeataisle = new JTextField();
		txtSeataisle.setEditable(false);
		txtSeataisle.setFont(new Font("Arial", Font.PLAIN, 15));
		txtSeataisle.setBackground(Color.PINK);
		txtSeataisle.setText("Seat_Aisle");
		txtSeataisle.setBounds(400, 0, 100, 20);
		Available.add(txtSeataisle);
		txtSeataisle.setColumns(10);
		
		txtSeatnone = new JTextField();
		txtSeatnone.setEditable(false);
		txtSeatnone.setFont(new Font("Arial", Font.PLAIN, 15));
		txtSeatnone.setBackground(Color.PINK);
		txtSeatnone.setText("Seat_None");
		txtSeatnone.setBounds(500, 0, 100, 20);
		Available.add(txtSeatnone);
		txtSeatnone.setColumns(10);
		
		txtEarlybird = new JTextField();
		txtEarlybird.setEditable(false);
		txtEarlybird.setFont(new Font("Arial", Font.PLAIN, 15));
		txtEarlybird.setBackground(Color.PINK);
		txtEarlybird.setText("EarlyBird");
		txtEarlybird.setBounds(600, 0, 100, 20);
		Available.add(txtEarlybird);
		txtEarlybird.setColumns(10);
		
		txtPleaseInputThe = new JTextField();
		txtPleaseInputThe.setEditable(false);
		txtPleaseInputThe.setFont(new Font("Arial", Font.PLAIN, 16));
		txtPleaseInputThe.setBackground(new Color(221, 160, 221));
		txtPleaseInputThe.setText("Please input the CarID you want :  ");
		txtPleaseInputThe.setBounds(0, 312, 250, 20);
		Available.add(txtPleaseInputThe);
		txtPleaseInputThe.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(250, 312, 100, 20);
		Available.add(textField_3);
		textField_3.setColumns(10);
		
		

		
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Order selected_car = new Order();
				
			/*  SearchCarMessage.setDepart(comdepartStation.getSelectedItem().toString());
				SearchCarMessage.setArrive(comarriveStation.getSelectedItem().toString());
				SearchCarMessage.setSeat(comSeat.getSelectedItem().toString());
				SearchCarMessage.setCarriage(comCarriage.getSelectedItem().toString());
				SearchCarMessage.quantity[0] = (int) normalTicket.getValue();
			    SearchCarMessage.quantity[1] = (int) childTicket.getValue(); 
				SearchCarMessage.quantity[2] = (int) elderTicket.getValue();
				SearchCarMessage.quantity[3] = (int) disableTicket.getValue();
				SearchCarMessage.quantity[4] = (int) studentTicket.getValue();
				SearchCarMessage.setHour((int)departHour.getValue());
				SearchCarMessage.setMinute((int)departMinute.getValue());
				SearchCarMessage.setDepartDay(departDay.getJFormattedTextField().getText().toString());
*/	
				
				
				
			}
		});
		btnConfirm.setFont(new Font("Arial", Font.PLAIN, 16));
		btnConfirm.setBackground(new Color(238, 232, 170));
		btnConfirm.setBounds(445, 312, 89, 31);
		Available.add(btnConfirm);
		
		
		
		
		
		JPanel Booking = new JPanel();
		Booking.setBackground(SystemColor.window);
		Booking.setBounds(0, 0, 824, 314);
		layeredPane.add(Booking);
		Booking.setLayout(null);
		
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
		
		JComboBox comdepartStation = new JComboBox();
		comdepartStation.setModel(new DefaultComboBoxModel(Station.values()));
		comdepartStation.setBounds(190, 3, 110, 20);
		Booking.add(comdepartStation);
		
		txtTo = new JTextField();
		txtTo.setText("to");
		txtTo.setEditable(false);
		txtTo.setColumns(10);
		txtTo.setBounds(305, 3, 20, 20);
		Booking.add(txtTo);
		
		
		
		
		JComboBox comarriveStation = new JComboBox();
		comarriveStation.setModel(new DefaultComboBoxModel(Station.values()));
		comarriveStation.setBounds(330, 3, 110, 20);
		Booking.add(comarriveStation);
		
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
		
		
		UtilDateModel model = new UtilDateModel();
		model.setSelected(true);
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		
		
		
		JComboBox comSeat = new JComboBox();
		comSeat.setModel(new DefaultComboBoxModel(Seat.values()));
		comSeat.setBounds(135, 49, 110, 20);
		Booking.add(comSeat);
		JDatePickerImpl departDay = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		departDay.setDoubleClickAction(true);
		departDay.setButtonFocusable(true);
		departDay.setSize(150, 20);
		departDay.setLocation(220, 72);
		Booking.add(departDay);
		
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
		
		
		
		
		JButton btnNewButton_3 = new JButton("Search Car");
		btnNewButton_3.setBounds(360, 260, 117, 25);
		Booking.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean vail = true;

				SearchCar SearchCarMessage = new SearchCar();
				
				SearchCarMessage.setDepart(comdepartStation.getSelectedItem().toString());
				SearchCarMessage.setArrive(comarriveStation.getSelectedItem().toString());
				SearchCarMessage.setSeat(comSeat.getSelectedItem().toString());
				SearchCarMessage.setCarriage(comCarriage.getSelectedItem().toString());
				SearchCarMessage.quantity[0] = (int) normalTicket.getValue();
			    SearchCarMessage.quantity[1] = (int) childTicket.getValue(); 
				SearchCarMessage.quantity[2] = (int) elderTicket.getValue();
				SearchCarMessage.quantity[3] = (int) disableTicket.getValue();
				SearchCarMessage.quantity[4] = (int) studentTicket.getValue();
				SearchCarMessage.setHour((int)departHour.getValue());
				SearchCarMessage.setMinute((int)departMinute.getValue());
				SearchCarMessage.setDepartDay(departDay.getJFormattedTextField().getText().toString());
				
				System.out.println(SearchCarMessage.toString());
				
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
							
							Available info1 = (Available) msg;
							int quantity_of_available = info1.carList.size();
							
							for(int i=0 ; i<quantity_of_available ; i++)
							{
								JTextField temp[] = new JTextField[7];
								for(int k=0 ; k<7 ; k++)
								{			
									temp[k].setBackground(Color.LIGHT_GRAY);
									temp[k].setForeground(Color.BLACK);
									temp[k].setFont(new Font("Arial", Font.PLAIN, 15));
									temp[k].setEditable(false);
									temp[k].setText(info1.carList.get(i).getCarID());
									temp[k].setBounds(0+100*k, 20+20*i, 100, 20);
									Available.add(temp[k]);
									temp[k].setColumns(10);		
								}
							}
															
									
									
							//switch pane
							layeredPane.removeAll();
							layeredPane.repaint();
							layeredPane.revalidate();
							
							layeredPane.add(Available);
							layeredPane.repaint();
							layeredPane.revalidate();
							
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
						
						// if the first arraylist is back, send another searchcar
						if (msg.getClass() == new Available().getClass()) {
							System.out.println("success_1");
							
							//change some parameter of searchcarmessage
							SearchCarMessage.setArrive(comdepartStation.getSelectedItem().toString());
							SearchCarMessage.setDepart(comarriveStation.getSelectedItem().toString());
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
								System.out.println("success_2");
								
								Available info1 = (Available) msg;
								int quantity_of_available = info1.carList.size();
								
								for(int i=0 ; i<quantity_of_available ; i++)
								{
									JTextField temp[] = new JTextField[7];
									for(int k=0 ; k<7 ; k++)
									{			
										temp[k].setBackground(Color.LIGHT_GRAY);
										temp[k].setForeground(Color.BLACK);
										temp[k].setFont(new Font("Arial", Font.PLAIN, 15));
										temp[k].setEditable(false);
										temp[k].setText(info1.carList.get(i).getCarID());
										temp[k].setBounds(0+100*k, 20+20*i, 100, 20);
										Available.add(temp[k]);
										temp[k].setColumns(10);		
									}
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
							
							
						
							
							//switch pane
							layeredPane.removeAll();
							layeredPane.add(Available);
							layeredPane.repaint();
							layeredPane.revalidate();
							
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
		
		

		
		JPanel Search = new JPanel();
		Search.setBackground(Color.ORANGE);
		Search.setBounds(0, 0, 824, 314);
		layeredPane.add(Search);
		
		JPanel SearchResult = new JPanel();
		SearchResult.setBackground(Color.GREEN);
		SearchResult.setBounds(0, 0, 824, 314);
		layeredPane.add(SearchResult);
		
		
		

		JPanel SearchOrder = new JPanel();
		SearchOrder.setBackground(Color.YELLOW);
		SearchOrder.setBounds(0, 0, 1178, 437);
		layeredPane.add(SearchOrder);
		SearchOrder.setLayout(null);
		
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
		
		/**
		 * on the Booking History pane
		 * as we push the button "Search"
		 * 
		 * we send a message . SearchOrder to the server
		 */
		
		
		JButton btnSearchOrder = new JButton("Search");
		btnSearchOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SearchOrder SearchOrderMessage = new SearchOrder();
				
				SearchOrderMessage.setUserID(userID_input.getText());
				
				if(userID_input.getText().equals("")) {
					//do nothing at following function
					System.out.println("Please input your userID");

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
							textField_4.setText("UserID");
							textField_4.setHorizontalAlignment(SwingConstants.CENTER);
							textField_4.setEditable(false);
							textField_4.setColumns(10);
							textField_4.setBounds(10, 40, 100, 20);
							SearchOrder.add(textField_4);
							
							txtCarid_1 = new JTextField();
							txtCarid_1.setText("CarID");
							txtCarid_1.setHorizontalAlignment(SwingConstants.CENTER);
							txtCarid_1.setEditable(false);
							txtCarid_1.setColumns(10);
							txtCarid_1.setBounds(110, 40, 100, 20);
							SearchOrder.add(txtCarid_1);
							
							txtDepartStation = new JTextField();
							txtDepartStation.setText("Depart Station");
							txtDepartStation.setHorizontalAlignment(SwingConstants.CENTER);
							txtDepartStation.setEditable(false);
							txtDepartStation.setColumns(10);
							txtDepartStation.setBounds(210, 40, 100, 20);
							SearchOrder.add(txtDepartStation);
							
							txtDepartTime_1 = new JTextField();
							txtDepartTime_1.setText("Depart Time");
							txtDepartTime_1.setHorizontalAlignment(SwingConstants.CENTER);
							txtDepartTime_1.setEditable(false);
							txtDepartTime_1.setColumns(10);
							txtDepartTime_1.setBounds(310, 40, 100, 20);
							SearchOrder.add(txtDepartTime_1);
							
							txtArriveStation = new JTextField();
							txtArriveStation.setText("Arrive Station");
							txtArriveStation.setHorizontalAlignment(SwingConstants.CENTER);
							txtArriveStation.setEditable(false);
							txtArriveStation.setColumns(10);
							txtArriveStation.setBounds(410, 40, 100, 20);
							SearchOrder.add(txtArriveStation);
							
							txtArriveTime_1 = new JTextField();
							txtArriveTime_1.setText("Arrive Time");
							txtArriveTime_1.setHorizontalAlignment(SwingConstants.CENTER);
							txtArriveTime_1.setEditable(false);
							txtArriveTime_1.setColumns(10);
							txtArriveTime_1.setBounds(510, 40, 100, 20);
							SearchOrder.add(txtArriveTime_1);
							
							txtPassenterType = new JTextField();
							txtPassenterType.setText("Passenger Type");
							txtPassenterType.setHorizontalAlignment(SwingConstants.CENTER);
							txtPassenterType.setEditable(false);
							txtPassenterType.setColumns(10);
							txtPassenterType.setBounds(610, 40, 100, 20);
							SearchOrder.add(txtPassenterType);
							
							txtCarriage = new JTextField();
							txtCarriage.setText("Carriage");
							txtCarriage.setHorizontalAlignment(SwingConstants.CENTER);
							txtCarriage.setEditable(false);
							txtCarriage.setColumns(10);
							txtCarriage.setBounds(710, 40, 100, 20);
							SearchOrder.add(txtCarriage);
							
							txtEarlyDiscount = new JTextField();
							txtEarlyDiscount.setText("Early Discount");
							txtEarlyDiscount.setHorizontalAlignment(SwingConstants.CENTER);
							txtEarlyDiscount.setEditable(false);
							txtEarlyDiscount.setColumns(10);
							txtEarlyDiscount.setBounds(810, 40, 100, 20);
							SearchOrder.add(txtEarlyDiscount);
							
							txtCarnoLocated = new JTextField();
							txtCarnoLocated.setText("CarNO.  Located");
							txtCarnoLocated.setHorizontalAlignment(SwingConstants.CENTER);
							txtCarnoLocated.setEditable(false);
							txtCarnoLocated.setColumns(10);
							txtCarnoLocated.setBounds(910, 40, 100, 20);
							SearchOrder.add(txtCarnoLocated);
							

							txtPrice = new JTextField();
							txtPrice.setText("Price");
							txtPrice.setHorizontalAlignment(SwingConstants.CENTER);
							txtPrice.setEditable(false);
							txtPrice.setColumns(10);
							txtPrice.setBounds(1010, 40, 100, 20);
							SearchOrder.add(txtPrice);
							
							
							/*
							 * create the table of tickets
							 */
							
							int i = 0;
							
							while(!order_result.getOrderResult().isEmpty()) {
							
								Ticket ticket = order_result.getOrderResult().pollFirst();

									
									JTextField temp = new JTextField();
									temp.setText(ticket.getUserID());
									temp.setHorizontalAlignment(SwingConstants.CENTER);
									temp.setEditable(false);
									temp.setColumns(10);
									temp.setBounds(10, 60 + i*20, 100, 20);
									SearchOrder.add(temp);
									
									
									temp = new JTextField();
									temp.setText(ticket.getCarID());
									temp.setHorizontalAlignment(SwingConstants.CENTER);
									temp.setEditable(false);
									temp.setColumns(10);
									temp.setBounds(110, 60 + i*20, 100, 20);
									SearchOrder.add(temp);
									
									
									temp = new JTextField();
									temp.setText(ticket.getDepart());
									temp.setHorizontalAlignment(SwingConstants.CENTER);
									temp.setEditable(false);
									temp.setColumns(10);
									temp.setBounds(210, 60 + i*20, 100, 20);
									SearchOrder.add(temp);
									
									
									temp = new JTextField();
									temp.setText(ticket.getDepartTime());
									temp.setHorizontalAlignment(SwingConstants.CENTER);
									temp.setEditable(false);
									temp.setColumns(10);
									temp.setBounds(310, 60 + i*20, 100, 20);
									SearchOrder.add(temp);
									
									
									temp = new JTextField();
									temp.setText(ticket.getArrive());
									temp.setHorizontalAlignment(SwingConstants.CENTER);
									temp.setEditable(false);
									temp.setColumns(10);
									temp.setBounds(410, 60 + i*20, 100, 20);
									SearchOrder.add(temp);
									
									
									temp = new JTextField();
									temp.setText(ticket.getArriveTime());
									temp.setHorizontalAlignment(SwingConstants.CENTER);
									temp.setEditable(false);
									temp.setColumns(10);
									temp.setBounds(510, 60 + i*20, 100, 20);
									SearchOrder.add(temp);
									
									
									temp = new JTextField();
									temp.setText(ticket.getPassengerType());
									temp.setHorizontalAlignment(SwingConstants.CENTER);
									temp.setEditable(false);
									temp.setColumns(10);
									temp.setBounds(610, 60 + i*20, 100, 20);
									SearchOrder.add(temp);
									
									
									temp = new JTextField();
									temp.setText(ticket.getCarriage());
									temp.setHorizontalAlignment(SwingConstants.CENTER);
									temp.setEditable(false);
									temp.setColumns(10);
									temp.setBounds(710, 60 + i*20, 100, 20);
									SearchOrder.add(temp);
									
									
									temp = new JTextField();
									temp.setText(ticket.getEarlyDiscount());
									temp.setHorizontalAlignment(SwingConstants.CENTER);
									temp.setEditable(false);
									temp.setColumns(10);
									temp.setBounds(810, 60 + i*20, 100, 20);
									SearchOrder.add(temp);
									
									
									temp = new JTextField();
									temp.setText("CarNO. " + ticket.getCompartment() + " " + ticket.getLocation());
									temp.setHorizontalAlignment(SwingConstants.CENTER);
									temp.setEditable(false);
									temp.setColumns(10);
									temp.setBounds(910, 60 + i*20, 100, 20);
									SearchOrder.add(temp);
									
									
									temp = new JTextField();
									temp.setText(ticket.getPrice());
									temp.setHorizontalAlignment(SwingConstants.CENTER);
									temp.setEditable(false);
									temp.setColumns(10);
									temp.setBounds(1010, 60 + i*20, 100, 20);
									SearchOrder.add(temp);
									
									
									
									
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
												
												//send to sever
												os.writeObject(cancel_ticketMessage);
												os.flush();
												
												Object msg = (Object) is.readObject();
												if (msg == null)
													System.out.println("null");
												
												
												//if the server send back a OrderResult for confirm ----> success
												
												if (msg.getClass() == new Ticket().getClass()) {
													System.out.println("success return after canceling the ticket");
													
													btnSearchOrder.doClick();
												}
												else if (msg.getClass() == new OrderResult().getClass()) {
													
												}
												else if(msg.getClass() == new Status().getClass()) {
													
												}
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
									btnCancel.jbutton.setBounds(1110, 60 + i*20, 100, 20);
									btnCancel.jbutton.setHorizontalAlignment(SwingConstants.LEFT);
									SearchOrder.add(btnCancel.jbutton);
									
									
									
									
									
									i++;
									
							}
						}
							

							SearchOrder.repaint();
							SearchOrder.revalidate();
							
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
		btnSearchOrder.setBounds(330, 10, 80, 20);
		SearchOrder.add(btnSearchOrder);
		
		

		
		
	
		
		

		
		
		
		/**
		 * As we push the button "Booking"
		 */
		


				
				/**
				 * As we push the button, "Search Car"
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
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 12));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Booking History");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//removing panels
				layeredPane.removeAll();
				layeredPane.repaint();
				layeredPane.revalidate();
				
				//adding panel-booking history
				layeredPane.add(SearchOrder);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 12));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//removing panels
				layeredPane.removeAll();
				layeredPane.repaint();
				layeredPane.revalidate();
				
				//adding panel-Search
				layeredPane.add(Search);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(btnNewButton_2);
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
