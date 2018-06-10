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
import java.util.Scanner;
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
import java.util.Date;
import java.util.Properties;
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
	
	private Available info1;
	private Available info2;

	
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
		setBounds(100, 100, 850, 400);
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
		
		JComboBox comSeat = new JComboBox();
		comSeat.setModel(new DefaultComboBoxModel(Seat.values()));
		comSeat.setBounds(135, 49, 110, 20);
		Booking.add(comSeat);
		JDatePanelImpl datePanel;
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
							
							//switch pane
							layeredPane.removeAll();
	//						layeredPane.repaint();
		//					layeredPane.revalidate();
							
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
								System.out.println("success_2");}
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
		
		
		
		btnNewButton_3.setBounds(360, 260, 117, 25);
		Booking.add(btnNewButton_3);
		
		
		
		JPanel Available = new JPanel();
		Available.setBackground(Color.LIGHT_GRAY);
		Available.setBounds(0, 0, 824, 314);
		layeredPane.add(Available);
		Available.setLayout(null);
		
		txtCarid = new JTextField();
		txtCarid.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCarid.setEditable(false);
		txtCarid.setText("CarID");
		txtCarid.setBounds(0, 0, 100, 20);
		Available.add(txtCarid);
		txtCarid.setColumns(10);
		
		txtDepartTime = new JTextField();
		txtDepartTime.setFont(new Font("Arial", Font.PLAIN, 15));
		txtDepartTime.setText("Depart Time");
		txtDepartTime.setEditable(false);
		txtDepartTime.setColumns(10);
		txtDepartTime.setBounds(100, 0, 100, 20);
		Available.add(txtDepartTime);
		
		txtArriveTime = new JTextField();
		txtArriveTime.setFont(new Font("Arial", Font.PLAIN, 15));
		txtArriveTime.setEditable(false);
		txtArriveTime.setText("Arrive Time");
		txtArriveTime.setBounds(200, 0, 136, 20);
		Available.add(txtArriveTime);
		txtArriveTime.setColumns(10);
		
		JPanel Search = new JPanel();
		Search.setBackground(Color.YELLOW);
		Search.setBounds(0, 0, 824, 314);
		layeredPane.add(Search);
		
		JPanel SearchResult = new JPanel();
		SearchResult.setBackground(Color.GREEN);
		SearchResult.setBounds(0, 0, 824, 314);
		layeredPane.add(SearchResult);
		
		
		UtilDateModel model = new UtilDateModel();
		model.setSelected(true);
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		
		
		JPanel Booking_History = new JPanel();
		Booking_History.setBackground(Color.ORANGE);
		Booking_History.setBounds(0, 0, 824, 314);
		layeredPane.add(Booking_History);
		
		JPanel BookingHistoryResult = new JPanel();
		BookingHistoryResult.setBackground(Color.BLUE);
		BookingHistoryResult.setBounds(0, 0, 824, 314);
		layeredPane.add(BookingHistoryResult);
		

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
				layeredPane.add(Booking_History);
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
}
