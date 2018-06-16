package message;

public class Price {
	public static void main(String args[]) {
		int a;
		String i = "NANGANG" ,j = "TAIPEI";
		Price test = new Price();
		a = test.getPrice(i, j);
		
		int b = test.getPrice("ZUOYING", "NANGANG");
	
		System.out.println(a);
		System.out.println(b);
	
	}
	
	
	
	
	public int getPrice(String depart , String arrive) {
		
		int price = 0;
		if(depart.matches("NANGANG")) {
			if(arrive.matches("TAIPEI")) {
				price = 40;
			}
		
			if(arrive.matches("BANQIAO")) {
				price = 70;
			}
			if(arrive.matches("TAOYUAN")) {
				price = 200;
			}
			if(arrive.matches("HSINCHU")) {
				price = 330;
			}
			if(arrive.matches("MIAOLI")) {
				price = 480;
			}
			if(arrive.matches("TAICHUNG")) {
				price = 750;
			}
			if(arrive.matches("CHANGHUA")) {
				price = 870;
			}
			if(arrive.matches("YUNLIN")) {
				price = 970;
			}
			if(arrive.matches("CHIAYI")) {
				price = 1120;
			}
			if(arrive.matches("TAINAN")) {
				price = 1390;
			}
			if(arrive.matches("ZUOYING")) {
				price = 1530;
			}
		}	
		else if(depart.matches("TAIPEI")) 
		{
			if(arrive.matches("BANQIAO")) {
				price = 40;
			}
			if(arrive.matches("TAOYUAN")) {
				price = 160;
			}
			if(arrive.matches("HSINCHU")) {
				price = 290;
			}
			if(arrive.matches("MIAOLI")) {
				price = 430;
			}
			if(arrive.matches("TAICHUNG")) {
				price = 700;
			}
			if(arrive.matches("CHANGHUA")) {
				price = 820;
			}
			if(arrive.matches("YUNLIN")) {
				price = 930;
			}
			if(arrive.matches("CHIAYI")) {
				price = 1080;
			}
			if(arrive.matches("TAINAN")) {
				price = 1350;
			}
			if(arrive.matches("ZUOYING")) {
				price = 1490;
			}		
		}
		else if(depart.matches("BANQIAO")) 
		{
			if(arrive.matches("TAOYUAN")) {
				price = 130;
			}
			if(arrive.matches("HSINCHU")) {
				price = 260;
			}
			if(arrive.matches("MIAOLI")) {
				price = 400;
			}
			if(arrive.matches("TAICHUNG")) {
				price = 670;
			}
			if(arrive.matches("CHANGHUA")) {
				price = 790;
			}
			if(arrive.matches("YUNLIN")) {
				price = 900;
			}
			if(arrive.matches("CHIAYI")) {
				price = 1050;
			}
			if(arrive.matches("TAINAN")) {
				price = 1320;
			}
			if(arrive.matches("ZUOYING")) {
				price = 1450;
			}		
		}
		
		else if(depart.matches("TAOYUAN")) 
		{
			if(arrive.matches( "HSINCHU")) {
				price = 130;
			}
			if(arrive.matches("MIAOLI")) {
				price = 280;
			}
			if(arrive.matches("TAICHUNG")) {
				price =540;
			}
			if(arrive.matches("CHANGHUA")) {
				price = 670;
			}
			if(arrive.matches("YUNLIN")) {
				price = 780;
			}
			if(arrive.matches("CHIAYI")) {
				price = 920;
			}
			if(arrive.matches("TAINAN")) {
				price = 1190;
			}
			if(arrive.matches("ZUOYING")) {
				price = 1330;
			}		
		}
	
		else if(depart.matches("HSINCHU")) 
		{
			if(arrive.matches("MIAOLI")) {
				price = 140;
			}
			if(arrive.matches("TAICHUNG")) {
				price = 410;
			}
			if(arrive.matches("CHANGHUA")) {
				price = 540;
			}
			if(arrive.matches("YUNLIN")) {
				price = 640;
			}
			if(arrive.matches("CHIAYI")) {
				price = 790;
			}
			if(arrive.matches("TAINAN")) {
				price = 1060;
			}
			if(arrive.matches("ZUOYING")) {
				price = 1200;
			}		
		}
		
		else if(depart.matches("MIAOLI")) 
		{
			if(arrive.matches("TAICHUNG")) {
				price = 270;
			}
			if(arrive.matches("CHANGHUA")) {
				price = 390;
			}
			if(arrive.matches("YUNLIN")) {
				price = 500;
			}
			if(arrive.matches("CHIAYI")) {
				price = 640;
			}
			if(arrive.matches("TAINAN")) {
				price = 920;
			}
			if(arrive.matches("ZUOYING")) {
				price = 1060;
			}		
		}
		
		else if(depart.matches("TAICHUNG")) 
		{
			if(arrive.matches("CHANGHUA")) {
				price = 130;
			}
			if(arrive.matches("YUNLIN")) {
				price = 230;
			}
			if(arrive.matches("CHIAYI")) {
				price = 380;
			}
			if(arrive.matches("TAINAN")) {
				price = 650;
			}
			if(arrive.matches("ZUOYING")) {
				price = 790;
			}		
		}
		
		else if(depart.matches("CHANGHUA")) 
		{
			if(arrive.matches("YUNLIN")) {
				price = 110;
			}
			if(arrive.matches("CHIAYI")) {
				price = 250;
			}
			if(arrive.matches("TAINAN")) {
				price = 530;
			}
			if(arrive.matches("ZUOYING")) {
				price = 670;
			}		
		}
		
		else if(depart.matches("YUNLIN")) 
		{
			if(arrive.matches("CHIAYI")) {
				price = 150;
			}
			if(arrive.matches("TAINAN")) {
				price = 420;
			}
			if(arrive.matches("ZUOYING")) {
				price = 560;
			}		
		}
		
		else if(depart.matches("CHIAYI")) 
		{
			if(arrive.matches("TAINAN")) {
				price = 280;
			}
			if(arrive.matches("ZUOYING")) {
				price = 410;
			}		
		}
		
		else if(depart.matches("TAINAN")) 
		{
			if(arrive.matches("ZUOYING")) {
				price = 140;
			}		
		}
		
		if(price == 0) {
			price = getPrice(arrive, depart);
		}
		
		return price;
		
	}	
}
