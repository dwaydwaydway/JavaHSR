package client;

import java.awt.BorderLayout;


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
		setBounds(100, 100, 550, 300);
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
		Booking.setBounds(0, 0, 538, 224);
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Station.values()));
		comboBox.setBounds(190, 3, 110, 20);
		Booking.add(comboBox);
		
		txtTo = new JTextField();
		txtTo.setText("to");
		txtTo.setEditable(false);
		txtTo.setColumns(10);
		txtTo.setBounds(305, 3, 20, 20);
		Booking.add(txtTo);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(Station.values()));
		comboBox_1.setBounds(330, 3, 110, 20);
		Booking.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(Carriage.values()));
		comboBox_2.setBounds(135, 26, 110, 20);
		Booking.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(Seat.values()));
		comboBox_3.setBounds(135, 49, 110, 20);
		Booking.add(comboBox_3);
		
		
		
		
		UtilDateModel model = new UtilDateModel();
		model.setSelected(true);
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setSize(150, 20);
		datePicker.setLocation(220, 72);
		Booking.add(datePicker);
		
		txtOutbound = new JTextField();
		txtOutbound.setText("Outbound");
		txtOutbound.setEditable(false);
		txtOutbound.setColumns(10);
		txtOutbound.setBounds(135, 72, 80, 20);
		Booking.add(txtOutbound);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(375, 72, 40, 20);
		Booking.add(spinner);
		
		textField = new JTextField();
		textField.setText(":");
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(420, 72, 10, 20);
		Booking.add(textField);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(435, 72, 40, 20);
		Booking.add(spinner_1);
		
		textField_1 = new JTextField();
		textField_1.setText("Passengers");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Dialog", Font.BOLD, 12));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setBounds(0, 118, 130, 20);
		Booking.add(textField_1);
		
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
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(375, 95, 40, 20);
		
		textField_2 = new JTextField();
		textField_2.setText(":");
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(420, 95, 10, 20);

		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(435, 95, 40, 20);

		
		
		
		
		
		
		JRadioButton rdbtnReturnTrip = new JRadioButton("Return Trip");
		rdbtnReturnTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnReturnTrip.isSelected()) {

					Booking.add(datePicker_return_trip);
					Booking.add(txtInbound);
					Booking.add(spinner_2);
					Booking.add(textField_2);
					Booking.add(spinner_3);
					Booking.repaint();
					Booking.revalidate();
				}
				else {
					Booking.remove(datePicker_return_trip);
					Booking.remove(txtInbound);
					Booking.remove(spinner_2);
					Booking.remove(textField_2);
					Booking.remove(spinner_3);
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
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBounds(190, 118, 40, 20);
		Booking.add(spinner_4);
		
		txtChild = new JTextField();
		txtChild.setText("Child");
		txtChild.setEditable(false);
		txtChild.setColumns(10);
		txtChild.setBounds(235, 118, 50, 20);
		Booking.add(txtChild);
		
		JSpinner spinner_5 = new JSpinner();
		spinner_5.setBounds(290, 118, 40, 20);
		Booking.add(spinner_5);
		
		txtElder = new JTextField();
		txtElder.setText("Elder");
		txtElder.setEditable(false);
		txtElder.setColumns(10);
		txtElder.setBounds(335, 118, 50, 20);
		Booking.add(txtElder);
		
		JSpinner spinner_6 = new JSpinner();
		spinner_6.setBounds(390, 118, 40, 20);
		Booking.add(spinner_6);
		
		txtDisable = new JTextField();
		txtDisable.setText("Disable");
		txtDisable.setEditable(false);
		txtDisable.setColumns(10);
		txtDisable.setBounds(135, 141, 50, 20);
		Booking.add(txtDisable);
		
		JSpinner spinner_7 = new JSpinner();
		spinner_7.setBounds(190, 141, 40, 20);
		Booking.add(spinner_7);
		
		txtStudent = new JTextField();
		txtStudent.setFont(new Font("Dialog", Font.PLAIN, 11));
		txtStudent.setText("Student");
		txtStudent.setEditable(false);
		txtStudent.setColumns(10);
		txtStudent.setBounds(235, 141, 50, 20);
		Booking.add(txtStudent);
		
		JSpinner spinner_8 = new JSpinner();
		spinner_8.setBounds(290, 141, 40, 20);
		Booking.add(spinner_8);
		
		JButton btnNewButton_3 = new JButton("Search Car");
		btnNewButton_3.setBounds(208, 187, 117, 25);
		Booking.add(btnNewButton_3);
		

		


		

		JPanel Booking_History = new JPanel();
		Booking_History.setBackground(Color.ORANGE);
		Booking_History.setBounds(0, 0, 538, 224);
		layeredPane.add(Booking_History);
		
		JPanel Search = new JPanel();
		Search.setBackground(Color.YELLOW);
		Search.setBounds(0, 0, 538, 224);
		layeredPane.add(Search);
		
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
