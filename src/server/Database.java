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
			System.out.println("Conned to database");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Conned not to database");
			e.printStackTrace();
		}
	}

	/////////////////////////////////////////////////////

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
					+ "  (33 - IFNULL(SUM(BusinessAisle), 0)) AS BusinessAisle " + " FROM " + "  booking "
					+ " WHERE " + " date = '" + msg.getDepartDay() + "' " + "  AND canceled = 0 GROUP BY " + " TrainNo "
					+ ") b " + "ON " + "  a.TrainNo = b.TrainNo " + "LEFT JOIN( " + "  SELECT " + "   e1.*, "
					+ "  e2.tickets " + " FROM " + "  ( " + "  SELECT " + "  p.TrainNo, "
					+ "  MIN(p.discount) AS early " + " FROM (" + "SELECT" + " m.TrainNo, "
					+ " m.discount AS discount," + " m.tickets - n.count AS tickets, " + " m.DAY " + " FROM "
					+ " earlyDiscount m, " + " ( " + " SELECT " + " COUNT(*) AS COUNT " + " FROM " + "  booking "
					+ "  WHERE " + " DATE = '" + msg.getDepartDay() + "' " + ") n " + " ) p" + " WHERE   p.DAY = '"
					+ msg.getDBDayofWeek() + "' AND p.tickets > 0 " + "    GROUP BY " + "  TrainNo " + "  ) e1 "
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
						rs.getString("BusinessWin"), rs.getString("BusinessAisle"), rs.getString("NormalWin"),
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
								+ "a.Carriage FROM " + seatType + " a WHERE a.Key = IFNULL((SELECT (" + seatMax[index]
								+ " - SUM(" + seatType + ")) FROM (SELECT * FROM booking) j WHERE j.DATE = '" + ticket.getDBDepartDate()
								+ "' AND j.TrainNo = '" + ticket.getCarID() + "')" + "    , " + seatMax[index] + "))"
								+ " ," + "(SELECT " + "a.Row FROM " + seatType + " a WHERE a.Key = IFNULL((SELECT ("
								+ seatMax[index] + " - SUM(" + seatType + ")) FROM (SELECT * FROM booking) k WHERE k.DATE = '"
								+ ticket.getDBDepartDate() + "' AND k.TrainNo = '" + ticket.getCarID() + "')" + "    , "
								+ seatMax[index] + "))" + ", " + "(SELECT " + "a.Side FROM " + seatType
								+ " a WHERE a.Key = IFNULL((SELECT (" + seatMax[index] + " - SUM(" + seatType
								+ ")) FROM (SELECT * FROM booking) l WHERE l.DATE = '" + ticket.getDBDepartDate() + "' AND l.TrainNo = '"
								+ ticket.getCarID() + "')" + "    , " + seatMax[index] + "))" + "," + quantity[0] + ","
								+ quantity[1] + "," + quantity[2] + "," + quantity[3] + "," + quantity[4]
								+ ", CASE WHEN(DATEDIFF('" + ticket.getDBDepartDate()
								+ "', CURDATE()) > 3) THEN (ADDDATE(CURDATE(), 3)) WHEN (DATEDIFF(CURDATE(), '"
								+ ticket.getDBDepartDate() + "') = 0) THEN ('" + ticket.getDBDepartDate()
								+ "') ELSE (ADDDATE(CURDATE(), 1)) END, " + ticket.getPrice().toString() + ", '"
								+ ticket.getDBDepartTime() + "', '" + ticket.getDBArriveTime() + "', "
								+ ticket.getEarlyDiscount() + " , " + ticket.getUniversityDisciont() + ", 0 )");
				int flag = pst.executeUpdate();

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
					+ " AND uid = '" + searchTransactionNumber.getUserID() + "' AND start = '"
					+ searchTransactionNumber.getDepart() + "' AND date = '" + searchTransactionNumber.getDepartDay()
					+ "' AND end = '" + searchTransactionNumber.getArrive() + "'"+ " AND canceled = 0");
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
						rs.getString("start"), rs.getString("end"), rs.getString("date") + ", " + rs.getString("depart_time"),
						rs.getString("date") + ", " + rs.getString("arrive_time"), rs.getString("ticketsType"), carriage,
						rs.getString("early_discount"), rs.getString("university_discount"), rs.getString("carriage"),
						rs.getString("side") + rs.getString("row"), rs.getString("price"));
				
				
				
			}
			return result;
		} catch (SQLException e) {
			System.out.println("findTransactionNumber error");
			e.printStackTrace();
			throw new Fail_Message("findTransactionNumber error", pst.toString());
		}
		finally {
			Close();
		}
	}

	public Object searchTicketByUserId(SearchOrder searchOrder) throws Fail_Message {
		try {
			pst = con.prepareStatement("SELECT * FROM `booking` WHERE code = " + searchOrder.getTransactionNumber() + " AND canceled = 0");
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
						rs.getString("start"), rs.getString("end"), rs.getString("date") + ", " + rs.getString("depart_time"),
						rs.getString("date") + ", " + rs.getString("arrive_time"), rs.getString("ticketsType"), carriage,
						rs.getString("early_discount"), rs.getString("university_discount"), rs.getString("carriage"),
						rs.getString("side") + rs.getString("row"), rs.getString("price"));
			}
			return result;
		} catch (SQLException e) {
			System.out.println("searchTicketByUserId error");
			e.printStackTrace();
			throw new Fail_Message("searchTicketByUserId error", pst.toString());
		}
		finally {
			Close();
		}
	}

	public Object cancelTicket(Ticket ticket) throws Fail_Message {
		try {
			pst = con.prepareStatement("UPDATE booking SET canceled = 1 WHERE uid = '" + ticket.getUserID()
					+ "' AND code = " + ticket.getTransactionNumber() + " AND date = '" + ticket.getDBDepartDate()
					+ "' AND start = '" + ticket.getDepart() + "' AND carriage = " + ticket.getCompartment()
					+ " AND side = '" + ticket.getLocation().charAt(0) + "' AND `row` = " + ticket.getLocation().substring(1));
			System.out.println(pst.toString());
			int flag = pst.executeUpdate();
			if(flag == 0)
				return new Fail_Message("cancelTicket error", pst.toString());
			else 
				return new Success_Message("ticket canceled");
		} catch (SQLException e) {
			System.out.println("cancelTicket error");
			e.printStackTrace();
			throw new Fail_Message("cancelTicket sql error", pst.toString());
		}
//		try {
//			pst = con.prepareStatement("UPDATE booking SET canceled = 1 WHERE uid = '" + ticket.getUserID()
//					+ "' AND code = " + ticket.getTransactionNumber() + " AND date = '" + ticket.getDBDepartDate()
//					+ "' AND start = '" + ticket.getDepart() + "' AND carriage = " + ticket.getCompartment()
//					+ " AND side = '" + ticket.getLocation().charAt(0) + "' AND `row` = " + ticket.getLocation().charAt(1));
//			int flag = pst.executeUpdate();
//			return new Success_Message("ticket canceled");
//		} catch (SQLException e) {
//			System.out.println("SQLException");
//			e.printStackTrace();
//			throw new Fail_Message();
//		}
		finally {
			Close();
		}
	}
	
	public void test(){
		try {
			System.out.println("in");
			pst = con.prepareStatement("SELECT * FROM NormalMid WHERE 'Key' = 138");
			System.out.println("start");
			rs = pst.executeQuery();
			System.out.println("end");
			System.out.println(rs);
			while (rs.next()) {
				System.out.println(rs);
			}
			
		} catch (SQLException e) {
			System.out.println("cancelTicket error");
			e.printStackTrace();
		}
		finally {
			Close();
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
		try {
			Object temp = db.insertBooking(new Order(), 132456);
		} catch (Fail_Message e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}