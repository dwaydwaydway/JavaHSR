package server;

import message.*;
import java.util.Random;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

/**
 * This class helps the server to access and alter the database
 * 
 * @author Lu
 * @version 1.0
 * @since 2018-06-07
 *
 */
public class Database {
	private static Connection con = null;
	private static Statement stat = null;
	private static ResultSet rs = null;
	private static PreparedStatement pst = null;
	private static final int[] seatMax = { 262, 137, 265, 33, 33 };

	/////////////////////////////////////////////////////

	private String insertBooking = "INSERT INTO `booking`(`code`, `uid`, `date`, `ticketsType`, `ticketsCount`, `start`, `end`, `carriage`, `row`, `side`, `payDeadline`, `payment`) \r\n"
			+ "VALUES (?,?,?,?,?,?,?,\r\n" + "(SELECT `Carriage` FROM ? n WHERE n.Key IN \r\n"
			+ "	(SELECT ? FROM seatIndex WHERE TrainNo = ? AND Day = ?)),\r\n"
			+ "(SELECT `Row` FROM ? n WHERE n.Key IN \r\n"
			+ "	(SELECT NormalWin FROM seatIndex WHERE TrainNo = ? AND Day = ?)),\r\n"
			+ "(SELECT `Side` FROM ? n WHERE n.Key IN \r\n"
			+ "	(SELECT NormalWin FROM seatIndex WHERE TrainNo = ? AND Day = ?)),\r\n" + "?, ?);";

	private String insertEearlyDiscount = "INSERT INTO `earlyDiscount`" + "(`TrainNo`, `Day`, `discount`, `tickets`) "
			+ "VALUES (?,?,?,?)";

	private String insertSeatIndex = "INSERT INTO `seatIndex`(`TrainNo`, `BusinessWin`, `BusinessAle`, `NormalWin`, `NormalMid`, `NormalAle`, `Disable`, `Day`) VALUES (?,?,?,?,?,?,?,?)";

	private String insertStation = "INSERT INTO `station`(`StationID`, `Zh_tw`, `En`, `StationAddress`) "
			+ "VALUES (?,?,?,?)";

	private String insertTimeTable = "INSERT INTO `timeTable`(`TrainNo`, `Direction`, "
			+ "`StartingStationName`, `EndingStationName`, `Nangang`, `Taipei`, `Banciao`, "
			+ "`Taoyuan`, `Hsinchu`, `Miaoli`, `Taichung`, `Changhua`, `Yunlin`, `Chiayi`, "
			+ "`Tainan`, `Zuoying`, `Monday`, `Tuesday`, `Wednesday`, `Thursday`, `Friday`, "
			+ "`Saturday`, `Sunday`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	private String insertUniversityDiscount = "INSERT INTO `universityDiscount`(`TrainNo`, "
			+ "`Monday`, `Tuesday`, `Wednesday`, `Thursday`, `Friday`, `Saturday`, `Sunday`) "
			+ "VALUES (?,?,?,?,?,?,?,?)";

	private String insertNormalWin = "INSERT INTO `NormalWin`(`Carriage`, `Row`, `Side`) VALUES (?, ?, ?)";

	private String insertNormalMid = "INSERT INTO `NormalMid`(`Carriage`, `Row`, `Side`) VALUES (?, ?, ?)";

	private String insertNormalAisle = "INSERT INTO `NormalAisle`(`Carriage`, `Row`, `Side`) VALUES (?, ?, ?)";

	private String insertBusinessWin = "INSERT INTO `BusinessWin`(`Carriage`, `Row`, `Side`) VALUES (?, ?, ?)";

	private String insertBusinessAisle = "INSERT INTO `BusinessAisle`(`Carriage`, `Row`, `Side`) VALUES (?, ?, ?)";

	private String insertDisable = "INSERT INTO `Disable`(`Carriage`, `Row`, `Side`) VALUES (?, ?, ?)";

	/////////////////////////////////////////////////////

	private String selectSQL = "select * from User ";

	/**
	 * This is the constructor of the class, it sets up the connection to the
	 * database.
	 */
	public Database() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/javahsr?useUnicode=true&useSSL=false",
					"dwaydwaydway", "dwaydwaydway");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/////////////////////////////////////////////////////

	public void insertNormalWin(String Carriage, String Row, String Side) {
		try {
			pst = con.prepareStatement(insertNormalWin);
			pst.setString(1, Carriage);
			pst.setString(2, Row);
			pst.setString(3, Side);
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
		} finally {
			Close();
		}
	}

	public void insertNormalMid(String Carriage, String Row, String Side) {
		try {
			pst = con.prepareStatement(insertNormalMid);
			pst.setString(1, Carriage);
			pst.setString(2, Row);
			pst.setString(3, Side);
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
		} finally {
			Close();
		}
	}

	public void insertNormalAisle(String Carriage, String Row, String Side) {
		try {
			pst = con.prepareStatement(insertNormalAisle);
			pst.setString(1, Carriage);
			pst.setString(2, Row);
			pst.setString(3, Side);
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
		} finally {
			Close();
		}
	}

	public void insertBusinessWin(String Carriage, String Row, String Side) {
		try {
			pst = con.prepareStatement(insertBusinessWin);
			pst.setString(1, Carriage);
			pst.setString(2, Row);
			pst.setString(3, Side);
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
		} finally {
			Close();
		}
	}

	public void insertDisable(String Carriage, String Row, String Side) {
		try {
			pst = con.prepareStatement(insertDisable);
			pst.setString(1, Carriage);
			pst.setString(2, Row);
			pst.setString(3, Side);
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
		} finally {
			Close();
		}
	}

	public void insertBusinessAisle(String Carriage, String Row, String Side) {
		try {
			pst = con.prepareStatement(insertBusinessAisle);
			pst.setString(1, Carriage);
			pst.setString(2, Row);
			pst.setString(3, Side);
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
		} finally {
			Close();
		}
	}

	public void insertSeatIndex(String TrainNo, String BusinessWin, String BusinessAle, String NormalWin,
			String NormalMid, String NormalAle, String Disable, String Day) {
		try {
			pst = con.prepareStatement(insertSeatIndex);
			pst.setString(1, TrainNo);
			pst.setString(2, BusinessWin);
			pst.setString(3, BusinessAle);
			pst.setString(4, NormalWin);
			pst.setString(5, NormalMid);
			pst.setString(6, NormalAle);
			pst.setString(7, Disable);
			pst.setString(8, Day);
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
		} finally {
			Close();
		}
	}

	/**
	 * This function inserts a set of data to the booking table
	 * 
	 * @param code
	 *            The code of the order
	 * @param uid
	 *            The user id of the user
	 * @param date
	 *            The date of the boarding day, in the of "year-month-day"
	 * @param ticketsType
	 *            The ticket type of the tickets
	 * @param ticketsCount
	 *            The quantity of the tickets
	 * @param start
	 *            The starting station of the ride
	 * @param end
	 *            The ending station of the ride
	 * @param seatType
	 *            An upper-case letter ranging A to E representing different seat
	 *            types
	 * @param payDeadline
	 *            The deadline of the payment in the form of "year-month-day"
	 * @param payment
	 *            The price of the order
	 */
	public static void insertBooking(String code, String uid, String date, String ticketsType, String ticketsCount,
			String start, String end, String seatType, String row, String payDeadline, String payment) {
		try {
			// pst = con.prepareStatement(insertBooking);
			pst.setString(1, code);
			pst.setString(2, uid);
			pst.setString(3, date);
			pst.setString(4, ticketsType);
			pst.setString(5, ticketsCount);
			pst.setString(6, start);
			pst.setString(7, end);
			pst.setString(8, seatType);
			pst.setString(9, row);
			pst.setString(10, payDeadline);
			pst.setString(11, payment);
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
		} finally {
			Close();
		}
	}

	/**
	 * This function inserts a set of data to the earlyDiscount table
	 * 
	 * @param TrainNo
	 *            The train number
	 * @param Day
	 *            The day of the discount
	 * @param discount
	 *            The discount rate
	 * @param tickets
	 *            The quantity of the tickets left
	 */
	public void insertEearlyDiscount(String TrainNo, String Day, String discount, String tickets) {
		try {
			pst = con.prepareStatement(insertEearlyDiscount);
			pst.setString(1, TrainNo);
			pst.setString(2, Day);
			pst.setString(3, discount);
			if (tickets == null) {
				pst.setNull(4, java.sql.Types.INTEGER);
			} else {
				pst.setString(4, tickets);
			}
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
		} finally {
			Close();
		}
	}

	/**
	 * This function inserts a set of data to the station table
	 * 
	 * @param StationID
	 *            The station id
	 * @param Zh_tw
	 *            The Chinese name of the station, in utf-8 encoding
	 * @param En
	 *            The English name of the station
	 * @param StationAddress
	 *            The address of the station in Chinese, in utf-8 encoding
	 */
	public void insertStation(String StationID, String Zh_tw, String En, String StationAddress) {
		try {
			pst = con.prepareStatement(insertStation);
			pst.setString(1, StationID);
			pst.setString(2, Zh_tw);
			pst.setString(3, En);
			pst.setString(4, StationAddress);
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
		} finally {
			Close();
		}
	}

	/**
	 * This function inserts a set of data to the universityDiscount table
	 * 
	 * @param TrainNo
	 *            The train number
	 * @param Monday
	 *            The discount rate on this day
	 * @param Tuesday
	 *            The discount rate on this day
	 * @param Wednesday
	 *            The discount rate on this day
	 * @param Thursday
	 *            The discount rate on this day
	 * @param Friday
	 *            The discount rate on this day
	 * @param Saturday
	 *            The discount rate on this day
	 * @param Sunday
	 *            The discount rate on this day
	 */

	public void insertUniversityDiscount(String TrainNo, String Monday, String Tuesday, String Wednesday,
			String Thursday, String Friday, String Saturday, String Sunday) {
		try {
			pst = con.prepareStatement(insertUniversityDiscount);
			pst.setString(1, TrainNo);
			pst.setString(2, Monday);
			pst.setString(3, Tuesday);
			pst.setString(4, Wednesday);
			pst.setString(5, Thursday);
			pst.setString(6, Friday);
			pst.setString(7, Saturday);
			pst.setString(8, Sunday);
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
		} finally {
			Close();
		}
	}

	/**
	 * 
	 * @param TrainNo
	 *            The train number
	 * @param Direction
	 *            The direction of the ride, 0 for heading south and 1 for heading
	 *            north
	 * @param StartingStationName
	 *            The name of the starting station in English
	 * @param EndingStationName
	 *            The name of the ending station in English
	 * @param Nangang
	 *            The departing time of the ride at this station, in the form of
	 *            "hour:minute"
	 * @param Taipei
	 *            The departing time of the ride at this station, in the form of
	 *            "hour:minute"
	 * @param Banciao
	 *            The departing time of the ride at this station, in the form of
	 *            "hour:minute"
	 * @param Taoyuan
	 *            The departing time of the ride at this station, in the form of
	 *            "hour:minute"
	 * @param Hsinchu
	 *            The departing time of the ride at this station, in the form of
	 *            "hour:minute"
	 * @param Miaoli
	 *            The departing time of the ride at this station, in the form of
	 *            "hour:minute"
	 * @param Taichung
	 *            The departing time of the ride at this station, in the form of
	 *            "hour:minute"
	 * @param Changhua
	 *            The departing time of the ride at this station, in the form of
	 *            "hour:minute"
	 * @param Yunlin
	 *            The departing time of the ride at this station, in the form of
	 *            "hour:minute"
	 * @param Chiayi
	 *            The departing time of the ride at this station, in the form of
	 *            "hour:minute"
	 * @param Tainan
	 *            The departing time of the ride at this station, in the form of
	 *            "hour:minute"
	 * @param Zuoying
	 *            The departing time of the ride at this station, in the form of
	 *            "hour:minute"
	 * @param Monday
	 *            An integer indicating whether this train is on servers on this
	 *            day, 1 for yes and 0 for no
	 * @param Tuesday
	 *            An integer indicating whether this train is on servers on this
	 *            day, 1 for yes and 0 for no
	 * @param Wednesday
	 *            An integer indicating whether this train is on servers on this
	 *            day, 1 for yes and 0 for no
	 * @param Thursday
	 *            An integer indicating whether this train is on servers on this
	 *            day, 1 for yes and 0 for no
	 * @param Friday
	 *            An integer indicating whether this train is on servers on this
	 *            day, 1 for yes and 0 for no
	 * @param Saturday
	 *            An integer indicating whether this train is on servers on this
	 *            day, 1 for yes and 0 for no
	 * @param Sunday
	 *            An integer indicating whether this train is on servers on this
	 *            day, 1 for yes and 0 for no
	 */
	public void insertTimeTable(String TrainNo, String Direction, String StartingStationName, String EndingStationName,
			String Nangang, String Taipei, String Banciao, String Taoyuan, String Hsinchu, String Miaoli,
			String Taichung, String Changhua, String Yunlin, String Chiayi, String Tainan, String Zuoying,
			String Monday, String Tuesday, String Wednesday, String Thursday, String Friday, String Saturday,
			String Sunday) {
		try {
			pst = con.prepareStatement(insertTimeTable);
			String temp[] = new String[23];
			temp[0] = TrainNo;
			temp[1] = Direction;
			temp[2] = StartingStationName;
			temp[3] = EndingStationName;
			temp[4] = Nangang;
			temp[5] = Taipei;
			temp[6] = Banciao;
			temp[7] = Taoyuan;
			temp[8] = Hsinchu;
			temp[9] = Miaoli;
			temp[10] = Taichung;
			temp[11] = Changhua;
			temp[12] = Yunlin;
			temp[13] = Chiayi;
			temp[14] = Tainan;
			temp[15] = Zuoying;
			temp[16] = Monday;
			temp[17] = Tuesday;
			temp[18] = Wednesday;
			temp[19] = Thursday;
			temp[20] = Friday;
			temp[21] = Saturday;
			temp[22] = Sunday;

			for (int i = 0; i < 23; i++) {
				if (temp[i] == null)
					pst.setNull((i + 1), java.sql.Types.TIME);
				else
					pst.setString((i + 1), temp[i]);
			}

			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
		} finally {
			Close();
		}
	}

	public Available selectCar(SearchCar msg) throws Fail_Message {
		try {
			pst = con.prepareStatement("SELECT " + "    a.TrainNo, " + "    a." + msg.getDepart() + ", " + "  a."
					+ msg.getArrive() + ", " + "    IFNULL(b.NormalWin, 262) NormalWin, "
					+ "  IFNULL(b.NormalMid, 137) NormalMid, " + "    IFNULL(b.NormalAisle, 265) NormalAisle, "
					+ "  IFNULL(b.BusinessWin, 33) BusinessWin, " + "  IFNULL(b.BusinessAisle, 33) BusinessAisle, "
					+ "    c.early, " + "    c.tickets, " + "  d." + msg.getDBDayofWeek() + " AS college " + "FROM "
					+ "    ( " + "    SELECT " + "   * " + "    FROM\r\n" + "        timeTable t " + "    WHERE "
					+ "        t." + msg.getDBDayofWeek() + "  = 1 AND t.Direction = " + msg.getDirection() + " AND t."
					+ msg.getDepart() + " < '" + msg.getTime() + "' AND t." + msg.getArrive() + " IS NOT NULL " + ") a "
					+ "LEFT JOIN( " + " SELECT " + " TrainNo, " + "  (262 - IFNULL(SUM(NormalWin), 0)) AS NormalWin, "
					+ "  (137 - IFNULL(SUM(NormalMid), 0)) AS NormalMid, "
					+ "  (265 - IFNULL(SUM(NormalAisle), 0)) AS NormalAisle, "
					+ "  (33 - IFNULL(SUM(BusinessWin), 0)) AS BusinessWin, "
					+ "  (33 - IFNULL(SUM(BusinessAisle), 0)) AS BusinessAisle " + "   FROM\r\n" + "  booking "
					+ " WHERE " + " date = '" + msg.getDepartDay() + "' " + "  AND canceled = 0 GROUP BY " + " TrainNo "
					+ ") b " + "ON " + "  a.TrainNo = b.TrainNo " + "LEFT JOIN( " + "  SELECT " + "   e1.*, "
					+ "  e2.tickets " + "   FROM " + "  ( " + "  SELECT " + "  p.TrainNo, "
					+ "  MIN(p.discount) AS early " + " FROM (" + "SELECT" + " m.TrainNo, "
					+ " m.discount - n.count AS discount," + " m.tickets,m" + " m.DAY " + " FROM "
					+ " earlyDiscount m, " + " ( " + " SELECT " + " COUNT(*) AS COUNT " + " FROM " + "  booking "
					+ "  WHERE " + " DATE = " + msg.getDepartDay() + " " + ") n " + " ) p" + "   DAY = '"
					+ msg.getDBDayofWeek() + "' AND tickets > 0 " + "    GROUP BY " + "  TrainNo " + "  ) e1 "
					+ "LEFT JOIN earlyDiscount e2 ON " + "   e1.TrainNo = e2.TrainNo AND e1.early = e2.discount AND e2.Day = '" + msg.getDBDayofWeek()
					+ "' " + ") c " + "ON " + "  a.TrainNo = c.TrainNo " + "LEFT JOIN( " + "   SELECT " + "   TrainNo, "
					+ " " + msg.getDBDayofWeek() + " " + "   FROM " + "  universityDiscount " + ") d " + "ON "
					+ "   a.TrainNO = d.TrainNo;");
			System.out.print(pst.toString());
			rs = pst.executeQuery();
			Available result = new Available();
			while (rs.next()) {

				result.addCar(rs.getString("TrainNo"), msg.getDepart().toString(), msg.getArrive().toString(),
						rs.getString(msg.getDepart().toString()), rs.getString(msg.getArrive().toString()),
						rs.getString("BusinessWin"), rs.getString("BusinessAle"), rs.getString("NormalWin"),
						rs.getString("NormalMid"), rs.getString("NormalAisle"), rs.getString("early"),
						rs.getString("college"));
			}
			return result;
		} catch (SQLException e) {
			System.out.println("select car error");
			e.printStackTrace();
			throw new Fail_Message("select car error", pst.toString());
		} finally {
			Close();
		}
	}

	public Object insertBooking(Order order, int code) throws Fail_Message {
		for (Ticket ticket : order.getOrderTicketList()) {
			String Class = ticket.getCarriage();
			String Side = ticket.getLocation();
			int[] quantity = { 0, 0, 0, 0, 0 };
			int index = 0;
			switch (Class) {
			case "STANDARD":
				Class = "Normal";
				break;
			case "BUSINESS":
				Class = "Business";
				index += 3;
				break;
			}
			switch (Side) {
			case "WINDOW":
				Side = "Win";
				break;
			case "NONE":
				Side = "Mid";
				index += 1;
				break;
			case "AISLE":
				Side = "Aisle";
				index += 2;
				break;
			}
			String seatType = Class + Side;
			quantity[index] = 1;
			try {
				pst = con.prepareStatement(
						"INSERT INTO `booking`(`code`, `uid`, `date`, `TrainNo`, `ticketsType`, `start`, `end`, `carriage`, `row`, `side`, `NormalWin`, `NormalMid`, `NormalAisle`, `BusinessWin`, `BusinessAisle`, `payDeadline`, `price`, `depart_time`, `arrive_time`, `early_discount`, `university_discount`, `canceled`) "
								+ "VALUES (" + code + ", '" + ticket.getUserID() + "','" + ticket.getDBDepartDate()
								+ "','" + ticket.getCarID() + "', '" + ticket.getPassengerType() + "','"
								+ ticket.getDepart() + "', '" + ticket.getArrive() + "', " + "(SELECT "
								+ "a.Carriage, FROM " + seatType + " a WHERE a.Key = FNULL((SELECT (" + seatMax[index]
								+ " - SUM(" + seatType + ")) FROM booking WHERE DATE = '" + ticket.getDBDepartDate()
								+ "' AND TrainNo = '" + ticket.getCarID() + "')" + "    , " + seatMax[index] + "))"
								+ " ," + "(SELECT " + "a.Row, FROM " + seatType + " a WHERE a.Key = FNULL((SELECT ("
								+ seatMax[index] + " - SUM(" + seatType + ")) FROM booking WHERE DATE = '"
								+ ticket.getDBDepartDate() + "' AND TrainNo = '" + ticket.getCarID() + "')" + "    , "
								+ seatMax[index] + "))" + ", " + "(SELECT " + "a.Side, FROM " + seatType
								+ " a WHERE a.Key = FNULL((SELECT (" + seatMax[index] + " - SUM(" + seatType
								+ ")) FROM booking WHERE DATE = '" + ticket.getDBDepartDate() + "' AND TrainNo = '"
								+ ticket.getCarID() + "')" + "    , " + seatMax[index] + "))" + "," + quantity[0] + ","
								+ quantity[1] + "," + quantity[2] + "," + quantity[3] + "," + quantity[4]
								+ ", CASE WHEN(DATEDIFF(" + ticket.getDBDepartDate()
								+ ", CURDATE()) > 3) THEN (DATE_ADD(CURDATE(), 3)) WHEN (DATEDIFF(CURDATE(), "
								+ ticket.getDBDepartDate() + ") = 0) THEN (" + ticket.getDBDepartDate()
								+ ") ELSE (DATE_ADD(CURDATE(), 1))," + ticket.getPrice() + ", '"
								+ ticket.getDBDepartTime() + "', '" + ticket.getDBArriveTime() + "', "
								+ ticket.getEarlyDiscount() + " , " + ticket.getUniversityDisciont() + ", 0 )");
				rs = pst.executeQuery();

			} catch (SQLException e) {
				System.out.println("insert booking error");
				e.printStackTrace();
				throw new Fail_Message("insert booking error", pst.toString());
			}
		}

		try {
			pst = con.prepareStatement("SELECT * FROM `booking` WHERE code = " + code);
			rs = pst.executeQuery();
			OrderResult result = new OrderResult();
			while (rs.next()) {
				int flag = rs.getInt("BusinessWin") + rs.getInt("BusinessAisle");
				String carriage;
				if (flag > 0)
					carriage = "BUSINESS";
				else
					carriage = "STANDARD";
				result.addTicket(rs.getString("code"), rs.getString("TrainNo"), rs.getString("uid"),
						rs.getString("start"), rs.getString("end"), rs.getString("depart_time"),
						rs.getString("depart_time"), rs.getString("ticketsType"), carriage,
						rs.getString("early_discount"), rs.getString("university_discount"), rs.getString("carriage"),
						rs.getString("side") + rs.getString("row"), rs.getString("price"));
			}
			return result;
		} catch (SQLException e) {
			System.out.println("insert booking 2 error");
			e.printStackTrace();
			throw new Fail_Message("insert booking 2 error", pst.toString());
		} finally {
			Close();
		}
	}

	public Object findTransactionNumber(SearchTransactionNumber searchTransactionNumber) throws Fail_Message {
		try {
			pst = con.prepareStatement("SELECT * FROM `booking` WHERE TrainNo = " + searchTransactionNumber.getCarID()
					+ " AND uid = " + searchTransactionNumber.getUserID() + " AND start = "
					+ searchTransactionNumber.getDepart() + " AND date = " + searchTransactionNumber.getDepartDay()
					+ " AND end = " + searchTransactionNumber.getArrive());
			rs = pst.executeQuery();
			OrderResult result = new OrderResult();
			while (rs.next()) {
				int flag = rs.getInt("BusinessWin") + rs.getInt("BusinessAisle");
				String carriage;
				if (flag > 0)
					carriage = "BUSINESS";
				else
					carriage = "STANDARD";
				result.addTicket(rs.getString("code"), rs.getString("TrainNo"), rs.getString("uid"),
						rs.getString("start"), rs.getString("end"), rs.getString("depart_time"),
						rs.getString("depart_time"), rs.getString("ticketsType"), carriage,
						rs.getString("early_discount"), rs.getString("university_discount"), rs.getString("carriage"),
						rs.getString("side") + rs.getString("row"), rs.getString("price"));
			}
			return result;
		} catch (SQLException e) {
			System.out.println("findTransactionNumber error");
			e.printStackTrace();
			throw new Fail_Message("findTransactionNumber error", pst.toString());
		}
	}

	public Object searchTicketByUserId(SearchOrder searchOrder) throws Fail_Message {
		try {
			pst = con.prepareStatement("SELECT * FROM `booking` WHERE code = " + searchOrder.getTransactionNumber());
			rs = pst.executeQuery();
			OrderResult result = new OrderResult();
			while (rs.next()) {
				int flag = rs.getInt("BusinessWin") + rs.getInt("BusinessAisle");
				String carriage;
				if (flag > 0)
					carriage = "BUSINESS";
				else
					carriage = "STANDARD";
				result.addTicket(rs.getString("code"), rs.getString("TrainNo"), rs.getString("uid"),
						rs.getString("start"), rs.getString("end"), rs.getString("depart_time"),
						rs.getString("depart_time"), rs.getString("ticketsType"), carriage,
						rs.getString("early_discount"), rs.getString("university_discount"), rs.getString("carriage"),
						rs.getString("side") + rs.getString("row"), rs.getString("price"));
			}
			return result;
		} catch (SQLException e) {
			System.out.println("searchTicketByUserId error");
			e.printStackTrace();
			throw new Fail_Message("searchTicketByUserId error", pst.toString());
		}
	}

	public Object cancelTicket(Ticket ticket) throws Fail_Message {
		try {
			pst = con.prepareStatement("UPDATE booking SET canceled = 1 WHERE uid = " + ticket.getUserID()
					+ " AND code = " + ticket.getTransactionNumber() + " AND date = " + ticket.getDBDepartDate()
					+ " AND start = " + ticket.getDepart() + " AND carriage = " + ticket.getCompartment()
					+ " AND side = " + ticket.getLocation().charAt(1) + " AND row = " + ticket.getLocation().charAt(0));
			rs = pst.executeQuery();
			// return new Success_Message("ticket canceled");
		} catch (SQLException e) {
			System.out.println("cancelTicket error");
			e.printStackTrace();
			throw new Fail_Message("cancelTicket error", pst.toString());
		}
		try {
			pst = con.prepareStatement("UPDATE booking SET canceled = 1 WHERE uid = " + ticket.getUserID()
					+ " AND code = " + ticket.getTransactionNumber() + " AND date = " + ticket.getDBDepartDate()
					+ " AND start = " + ticket.getDepart() + " AND carriage = " + ticket.getCompartment()
					+ " AND side = " + ticket.getLocation().charAt(1) + " AND row = " + ticket.getLocation().charAt(0));
			rs = pst.executeQuery();
			return new Success_Message("ticket canceled");
		} catch (SQLException e) {
			System.out.println("SQLException");
			e.printStackTrace();
			throw new Fail_Message();
		}

	}

	////////////////////////////////////////////////////////////////////////////////////

	private static void Close() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stat != null) {
				stat.close();
				stat = null;
			}
			if (pst != null) {
				pst.close();
				pst = null;
			}
		} catch (SQLException e) {
			System.out.println("Close Exception :" + e.toString());
		}
	}

	public static void main(String[] args) throws ClassNotFoundException {
		Database db = new Database();
		// db.selectCar(new SearchCar());
	}
}