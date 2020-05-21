package FactoryBoll;


public class Game {
	public Boll getGame(String bolltype) {
		if(bolltype == null) {
			return null;
		}
		else if(bolltype.equalsIgnoreCase("Cricket")) {
			return new Cricket();
		}
		else if(bolltype.equalsIgnoreCase("Footboll")) {
			return new Footboll();
		}
		else if(bolltype.equalsIgnoreCase("Basketball")) {
			return new Basketball();
		}
		return null;
	}
}

