
public class BoardGameSimulation {
	
	
	private Setup setup;
	
	public BoardGameSimulation(Setup setup) {
		this.setSetup(setup);
	}
	
	
	public void start() {
		
		//Cycle through phases.
		this.setup.getPlayer(0).drawCard(4, this.setup.getDeck());
		this.setup.getPlayer(0).revealHand();
		System.out.println("----------");
		
		this.setup.getPlayer(1).drawCard(4, this.setup.getDeck());
		this.setup.getPlayer(1).revealHand();
		System.out.println("----------");
		
		this.setup.getPlayer(2).drawCard(4, this.setup.getDeck());
		this.setup.getPlayer(2).revealHand();

		//System.out.println("--- Starting Game - "+this.setup.getPlayer(0).getName()+" looks at 5 Cards ---");
		//Mechanic.chooseFromCards(5, this.setup.getDeck(), this.setup.getPlayer(0), this.setup.getPlayer(1));
		
		System.out.println("----------");
		
		//this.setup.getPlayer(1).revealHand();
		
		Mechanic.Swapsies(this.setup.getPlayer(1),this.setup.getPlayers());
		
		System.out.println("----------");
		
		
	}
	
	// ---- Getters and Setters ----

	public Setup getSetup() {
		return setup;
	}

	public void setSetup(Setup setup) {
		this.setup = setup;
	}

	
	
	public static void main(String args[]) {
		Setup setup = new Setup();
		
		BoardGameSimulation bgs = new BoardGameSimulation(setup);
		
		bgs.start();
	}
	
	

}
