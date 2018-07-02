package server;

import message.*;
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
 * @author Lu (B05602022)
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

	/////////////////////////////////////////////////////

	/**
	 * This is the constructor of the class, it sets up the connection to the
	 * database.
	 */
	public Database() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/javahsr?useUnicode=true&useSSL=false",
					"dwaydwaydway", "dwaydwaydway");
			System.out.println("Conned to database");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Conned not to database");
			e.printStackTrace();
		}
	}

	/////////////////////////////////////////////////////

	/**
	 * This function selects a list of train based on the conditions provided by a
	 * SearchCar object, than return a Available object which contains a list of
	 * train that meets the requirement.
	 * 
	 * @param msg
	 *            This is the SearchCar object which provides the conditions.
	 * @return Available A list of train available
	 * @throws Fail_Message
	 */
	public Available selectCar(SearchCar msg) throws Fail_Message {
		try {
			pst = con.prepareStatement("SELECT " + " a.TrainNo, " + "    a." + msg.getDepart() + ", " + "  a."
					+ msg.getArrive() + ", " + " IFNULL(b.NormalWin, 262) NormalWin, "
					+ " IFNULL(b.NormalMid, 137) NormalMid, " + " IFNULL(b.NormalAisle, 265) NormalAisle, "
					+ " IFNULL(b.BusinessWin, 33) BusinessWin, " + " IFNULL(b.BusinessAisle, 33) BusinessAisle, "
					+ " c.early, " + " c.tickets, " + "  d." + msg.getDBDayofWeek() + " AS college " + "FROM " + " ( "
					+ "  SELECT " + " * " + " FROM " + "  timeTable t " + "    WHERE " + " t." + msg.getDBDayofWeek()
					+ "  = 1 AND TIMEDIFF(t." + msg.getArrive() + ", t." + msg.getDepart() + ") > 0 AND t."
					+ msg.getDepart() + " < '" + msg.getTime() + "' AND t." + msg.getArrive() + " IS NOT NULL " + ") a "
					+ "LEFT JOIN( " + " SELECT " + " TrainNo, " + "  (262 - IFNULL(SUM(NormalWin), 0)) AS NormalWin, "
					+ " (137 - IFNULL(SUM(NormalMid), 0)) AS NormalMid, "
					+ " (265 - IFNULL(SUM(NormalAisle), 0)) AS NormalAisle, "
					+ " (33 - IFNULL(SUM(BusinessWin), 0)) AS BusinessWin, "
					+ " (33 - IFNULL(SUM(BusinessAisle), 0)) AS BusinessAisle " + " FROM " + "  booking " + " WHERE "
					+ " date = '" + msg.getDepartDay() + "' " + "  AND canceled = 0 GROUP BY " + " TrainNo " + ") b "
					+ "ON " + "  a.TrainNo = b.TrainNo " + "LEFT JOIN( " + "  SELECT " + "   e1.*, " + "  e2.tickets "
					+ " FROM " + "  ( " + "  SELECT " + " p.TrainNo, " + "  MIN(p.discount) AS early " + " FROM ("
					+ "SELECT" + " m.TrainNo, " + " m.discount AS discount," + " m.tickets - n.count AS tickets, "
					+ " m.DAY " + " FROM " + " earlyDiscount m, " + " ( " + " SELECT " + " COUNT(*) AS COUNT "
					+ " FROM " + "  booking " + "  WHERE " + " DATE = '" + msg.getDepartDay() + "' " + ") n " + " ) p"
					+ " WHERE   p.DAY = '" + msg.getDBDayofWeek() + "' AND p.tickets > 0 " + "    GROUP BY "
					+ "  TrainNo " + "  ) e1 " + "LEFT JOIN earlyDiscount e2 ON "
					+ "   e1.TrainNo = e2.TrainNo AND e1.early = e2.discount AND e2.Day = '" + msg.getDBDayofWeek()
					+ "' " + ") c " + "ON " + "  a.TrainNo = c.TrainNo " + "LEFT JOIN( " + "   SELECT " + "   TrainNo, "
					+ " " + msg.getDBDayofWeek() + " " + "   FROM " + "  universityDiscount " + ") d " + "ON "
					+ "   a.TrainNO = d.TrainNo;");
			System.out.print(pst.toString());
			rs = pst.executeQuery();
			Available result = new Available();
			while (rs.next()) {
				String early;
				if (msg.getCarriage().equals("STANDARD")) {
					early = rs.getString("early");
				} else {
					early = "1";
				}
				if (rs.getInt(msg.getSeatType().toString()) - msg.getTotal() > 0) {
					result.addCar(rs.getString("TrainNo"), msg.getDepart().toString(), msg.getArrive().toString(),
							rs.getString(msg.getDepart().toString()), rs.getString(msg.getArrive().toString()),
							rs.getString("BusinessWin"), rs.getString("BusinessAisle"), rs.getString("NormalWin"),
							rs.getString("NormalMid"), rs.getString("NormalAisle"), early, rs.getString("college"));
				}
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

	/**
	 * THis function helps insert a list of tickets to the database, than return the
	 * tickets that has been booked successfully.
	 * 
	 * @param order
	 *            This is the list of tickets that is ready to be update to
	 *            database.
	 * @param code
	 *            This is the order number.
	 * @return OrderResult This contains a list of tickets that has been booked
	 *         successfully
	 * @throws Fail_Message
	 */
	public OrderResult insertBooking(Order order, int code) throws Fail_Message {
		for (Ticket ticket : order.getOrderTicketList()) {
			System.out.print("a ticket start");
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
								+ "a.Carriage FROM " + seatType + " a WHERE a.Key = (SELECT (" + seatMax[index]
								+ " - IFNULL(SUM(" + seatType + "), " + (seatMax[index] - 1)
								+ " )) FROM (SELECT * FROM booking) j WHERE j.DATE = '" + ticket.getDBDepartDate()
								+ "' AND j.TrainNo = '" + ticket.getCarID() + "')" + ")" + " ," + "(SELECT "
								+ "a.Row FROM " + seatType + " a WHERE a.Key = (SELECT (" + seatMax[index]
								+ " - IFNULL(SUM(" + seatType + "),  " + (seatMax[index] - 1)
								+ ")) FROM (SELECT * FROM booking) k WHERE k.DATE = '" + ticket.getDBDepartDate()
								+ "' AND k.TrainNo = '" + ticket.getCarID() + "')" + ")" + ", " + "(SELECT "
								+ "a.Side FROM " + seatType + " a WHERE a.Key = (SELECT (" + seatMax[index]
								+ " - IFNULL(SUM(" + seatType + ")," + (seatMax[index] - 1)
								+ ")) FROM (SELECT * FROM booking) l WHERE l.DATE = '" + ticket.getDBDepartDate()
								+ "' AND l.TrainNo = '" + ticket.getCarID() + "')" + ")" + "," + quantity[0] + ","
								+ quantity[1] + "," + quantity[2] + "," + quantity[3] + "," + quantity[4]
								+ ", CASE WHEN(DATEDIFF('" + ticket.getDBDepartDate()
								+ "', CURDATE()) > 3) THEN (ADDDATE(CURDATE(), 3)) WHEN (DATEDIFF(CURDATE(), '"
								+ ticket.getDBDepartDate() + "') = 0) THEN ('" + ticket.getDBDepartDate()
								+ "') ELSE (ADDDATE(CURDATE(), 1)) END, " + ticket.getPrice().toString() + ", '"
								+ ticket.getDBDepartTime() + "', '" + ticket.getDBArriveTime() + "', "
								+ ticket.getEarlyDiscount() + " , " + ticket.getUniversityDisciont() + ", 0 )");
				int flag = pst.executeUpdate();
				
				if (flag == 0) {
					System.out.print("a ticket finish");
				}
			} catch (SQLException e) {
				if (e.getClass().equals(new SQLIntegrityConstraintViolationException().getClass())) {
					System.out.println("one ticket fail");
				} else {
					System.out.println("insert booking error");
					e.printStackTrace();
					throw new Fail_Message("insert booking error", pst.toString());
				}

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

	/**
	 * This function finds the TransactionNumber based on some given conditions.
	 * 
	 * @param searchTransactionNumber
	 *            This contains some condition.
	 * @return OrderResult This contains a list of tickets.
	 * @throws Fail_Message
	 */
	public Object findTransactionNumber(SearchTransactionNumber searchTransactionNumber) throws Fail_Message {
		try {
			pst = con.prepareStatement("SELECT * FROM `booking` WHERE TrainNo = " + searchTransactionNumber.getCarID()
					+ " AND uid = '" + searchTransactionNumber.getUserID() + "' AND start = '"
					+ searchTransactionNumber.getDepart() + "' AND date = '" + searchTransactionNumber.getDepartDay()
					+ "' AND end = '" + searchTransactionNumber.getArrive() + "'" + " AND canceled = 0");
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
						rs.getString("start"), rs.getString("end"),
						rs.getString("date") + ", " + rs.getString("depart_time"),
						rs.getString("date") + ", " + rs.getString("arrive_time"), rs.getString("ticketsType"),
						carriage, rs.getString("early_discount"), rs.getString("university_discount"),
						rs.getString("carriage"), rs.getString("side") + rs.getString("row"), rs.getString("price"));
			}
			return result;
		} catch (SQLException e) {
			System.out.println("findTransactionNumber error");
			e.printStackTrace();
			throw new Fail_Message("findTransactionNumber error", pst.toString());
		} finally {
			Close();
		}
	}

	/**
	 * This function helps finding the detail of an order based on a given
	 * transactionNumber.
	 * 
	 * @param searchOrder
	 *            This provides the transactionNumber.
	 * @return OrderResult
	 * @throws Fail_Message
	 */
	public Object searchTicketByUserId(SearchOrder searchOrder) throws Fail_Message {
		try {
			pst = con.prepareStatement(
					"SELECT * FROM `booking` WHERE code = " + searchOrder.getTransactionNumber() + " AND canceled = 0");
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
						rs.getString("start"), rs.getString("end"),
						rs.getString("date") + ", " + rs.getString("depart_time"),
						rs.getString("date") + ", " + rs.getString("arrive_time"), rs.getString("ticketsType"),
						carriage, rs.getString("early_discount"), rs.getString("university_discount"),
						rs.getString("carriage"), rs.getString("side") + rs.getString("row"), rs.getString("price"));
			}
			return result;
		} catch (SQLException e) {
			System.out.println("searchTicketByUserId error");
			e.printStackTrace();
			throw new Fail_Message("searchTicketByUserId error", pst.toString());
		} finally {
			Close();
		}
	}

	/**
	 * This function helps find a list of train in a specified day.
	 * 
	 * @param msg
	 *            This contains some needed information.
	 * @return DailyResult This contains a list of train.
	 * @throws Fail_Message
	 */
	public DailyResult searchDaily(SearchDaily msg) throws Fail_Message {
		try {
			pst = con.prepareStatement("SELECT * FROM `timeTable` WHERE " + msg.getDepart_dayofweek() + " = 1");
			rs = pst.executeQuery();
			DailyResult result = new DailyResult();
			while (rs.next()) {

				result.add(rs.getString("TrainNo"), msg.getDepartDay(), rs.getString("Nangang"), rs.getString("Taipei"),
						rs.getString("Banciao"), rs.getString("Taoyuan"), rs.getString("Hsinchu"),
						rs.getString("Miaoli"), rs.getString("Taichung"), rs.getString("Changhua"),
						rs.getString("Yunlin"), rs.getString("Chiayi"), rs.getString("Tainan"),
						rs.getString("Zuoying"));
			}
			return result;
		} catch (SQLException e) {
			System.out.println("searchTicketByUserId error");
			e.printStackTrace();
			throw new Fail_Message("searchTicketByUserId error", pst.toString());
		} finally {
			Close();
		}
	}

	/**
	 * This function helps cancel a ticket.
	 * 
	 * @param ticket
	 *            This is the ticket that is yet to be canceled
	 * @return A Success_Message
	 * @throws Fail_Message
	 */
	public Object cancelTicket(Ticket ticket) throws Fail_Message {
		try {
			pst = con.prepareStatement("UPDATE booking SET canceled = 1 WHERE uid = '" + ticket.getUserID()
					+ "' AND code = " + ticket.getTransactionNumber() + " AND date = '" + ticket.getDBDepartDate()
					+ "' AND start = '" + ticket.getDepart() + "' AND carriage = " + ticket.getCompartment()
					+ " AND side = '" + ticket.getLocation().charAt(0) + "' AND `row` = "
					+ ticket.getLocation().substring(1));
			System.out.println(pst.toString());
			int flag = pst.executeUpdate();
			if (flag == 0)
				return new Fail_Message("cancelTicket error", pst.toString());
			else
				return new Success_Message("ticket canceled");
		} catch (SQLException e) {
			System.out.println("cancelTicket error");
			e.printStackTrace();
			throw new Fail_Message("cancelTicket sql error", pst.toString());
		}

		finally {
			Close();
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * This functions close the connection to the database
	 */
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

	}
}