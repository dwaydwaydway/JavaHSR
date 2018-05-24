
public class NormalBooking extends Messenger {
	public enum station {
		Nangang, Taipei, Banqiao, Taoyuan, Hsinchu, Miaoli, 
		Taichung, Tainan, Changhua, Yunlin, Chiayi, Zuoying
	}
	public enum type {
		normal, child, elder, disable
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NormalBooking() {
		userID = "123";
		time = 2018;
		start = station.Taipei;
		end = station.Taipei;
		type = type.normal;
		quantity = 1;	
		getString = "123,2018,Taipei,Taipei,normal,1";
	}
	private String userID;
	private int time;
	private station start;
	private station end;
	private type type;
	private int quantity;
	
	
	
	
}
