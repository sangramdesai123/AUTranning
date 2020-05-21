package FactoryBoll;



public class Factorygame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
		Boll g1= game.getGame("Cricket");
		g1.size();
		
		Boll g2= game.getGame("Footboll");
		g2.size();
		
		Boll g3= game.getGame("Basketball");
		g3.size();
		
	}

}
