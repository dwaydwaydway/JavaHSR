package message;

/**
 * 
 * This class helps to calculate the price of a business seat.
 *
 */
public class Price_of_Business {

	public static void main(String args[]) {
		int a;
		String i = "NANGANG", j = "TAIPEI";
		Price_of_Business test = new Price_of_Business();
		a = test.getPrice(i, j);

		int b = test.getPrice("ZUOYING", "NANGANG");

		System.out.println(a);
		System.out.println(b);

	}

	/**
	 * THe getter of the price calculator
	 * 
	 * @param depart
	 *            The depart station
	 * @param arrive
	 *            The arrive station
	 * @return int price
	 */
	public int getPrice(String depart, String arrive) {
		int price = 0;
		if (depart.equals("NANGANG")) {
			if (arrive.equals("TAIPEI")) {
				price = 230;
			}
			if (arrive.equals("BANCIAO")) {
				price = 275;
			}
			if (arrive.equals("TAOYUAN")) {
				price = 450;
			}
			if (arrive.equals("HSINCHU")) {
				price = 630;
			}
			if (arrive.equals("MIAOLI")) {
				price = 825;
			}
			if (arrive.equals("TAICHUNG")) {
				price = 1195;
			}
			if (arrive.equals("CHANGHUA")) {
				price = 1355;
			}
			if (arrive.equals("YUNLIN")) {
				price = 1490;
			}
			if (arrive.equals("CHIAYI")) {
				price = 1690;
			}
			if (arrive.equals("TAINAN")) {
				price = 2060;
			}
			if (arrive.equals("ZUOYING")) {
				price = 2250;
			}
		} else if (depart.equals("TAIPEI")) {
			if (arrive.equals("BANCIAO")) {
				price = 230;
			}
			if (arrive.equals("TAOYUAN")) {
				price = 395;
			}
			if (arrive.equals("HSINCHU")) {
				price = 575;
			}
			if (arrive.equals("MIAOLI")) {
				price = 765;
			}
			if (arrive.equals("TAICHUNG")) {
				price = 1125;
			}
			if (arrive.equals("CHANGHUA")) {
				price = 1285;
			}
			if (arrive.equals("YUNLIN")) {
				price = 1440;
			}
			if (arrive.equals("CHIAYI")) {
				price = 1635;
			}
			if (arrive.equals("TAINAN")) {
				price = 2005;
			}
			if (arrive.equals("ZUOYING")) {
				price = 2195;
			}
		} else if (depart.equals("BANCIAO")) {
			if (arrive.equals("TAOYUAN")) {
				price = 360;
			}
			if (arrive.equals("HSINCHU")) {
				price = 530;
			}
			if (arrive.equals("MIAOLI")) {
				price = 720;
			}
			if (arrive.equals("TAICHUNG")) {
				price = 1085;
			}
			if (arrive.equals("CHANGHUA")) {
				price = 1250;
			}
			if (arrive.equals("YUNLIN")) {
				price = 1395;
			}
			if (arrive.equals("CHIAYI")) {
				price = 1600;
			}
			if (arrive.equals("TAINAN")) {
				price = 1960;
			}
			if (arrive.equals("ZUOYING")) {
				price = 2150;
			}
		}

		else if (depart.equals("TAOYUAN")) {
			if (arrive.equals("HSINCHU")) {
				price = 360;
			}
			if (arrive.equals("MIAOLI")) {
				price = 555;
			}
			if (arrive.equals("TAICHUNG")) {
				price = 905;
			}
			if (arrive.equals("CHANGHUA")) {
				price = 1085;
			}
			if (arrive.equals("YUNLIN")) {
				price = 1230;
			}
			if (arrive.equals("CHIAYI")) {
				price = 1420;
			}
			if (arrive.equals("TAINAN")) {
				price = 1790;
			}
			if (arrive.equals("ZUOYING")) {
				price = 1980;
			}
		}

		else if (depart.equals("HSINCHU")) {
			if (arrive.equals("MIAOLI")) {
				price = 365;
			}
			if (arrive.equals("TAICHUNG")) {
				price = 735;
			}
			if (arrive.equals("CHANGHUA")) {
				price = 905;
			}
			if (arrive.equals("YUNLIN")) {
				price = 1040;
			}
			if (arrive.equals("CHIAYI")) {
				price = 1420;
			}
			if (arrive.equals("TAINAN")) {
				price = 1610;
			}
			if (arrive.equals("ZUOYING")) {
				price = 1800;
			}
		}

		else if (depart.equals("MIAOLI")) {
			if (arrive.equals("TAICHUNG")) {
				price = 545;
			}
			if (arrive.equals("CHANGHUA")) {
				price = 710;
			}
			if (arrive.equals("YUNLIN")) {
				price = 855;
			}
			if (arrive.equals("CHIAYI")) {
				price = 1040;
			}
			if (arrive.equals("TAINAN")) {
				price = 1420;
			}
			if (arrive.equals("ZUOYING")) {
				price = 1610;
			}
		}

		else if (depart.equals("TAICHUNG")) {
			if (arrive.equals("CHANGHUA")) {
				price = 360;
			}
			if (arrive.equals("YUNLIN")) {
				price = 495;
			}
			if (arrive.equals("CHIAYI")) {
				price = 690;
			}
			if (arrive.equals("TAINAN")) {
				price = 1060;
			}
			if (arrive.equals("ZUOYING")) {
				price = 1250;
			}
		}

		else if (depart.equals("CHANGHUA")) {
			if (arrive.equals("YUNLIN")) {
				price = 330;
			}
			if (arrive.equals("CHIAYI")) {
				price = 520;
			}
			if (arrive.equals("TAINAN")) {
				price = 900;
			}
			if (arrive.equals("ZUOYING")) {
				price = 1085;
			}
		}

		else if (depart.equals("YUNLIN")) {
			if (arrive.equals("CHIAYI")) {
				price = 385;
			}
			if (arrive.equals("TAINAN")) {
				price = 745;
			}
			if (arrive.equals("ZUOYING")) {
				price = 935;
			}
		}

		else if (depart.equals("CHIAYI")) {
			if (arrive.equals("TAINAN")) {
				price = 555;
			}
			if (arrive.equals("ZUOYING")) {
				price = 735;
			}
		}

		else if (depart.equals("TAINAN")) {
			if (arrive.equals("ZUOYING")) {
				price = 365;
			}
		}

		if (price == 0) {
			price = getPrice(arrive, depart);
		}

		return price;

	}

}
