
public class BoardGameSimulation {
	
	// ---- MORE SOCIAL INTERACTION GAME ------
	//game could simulate a newbie entering a prison.
	//the newbie has an objective to forfill.
	//other players may or may not know what the player is in for, and also may or may not know their objective.
	//can exchange cards with each other to influence their opinion.
	//one player is an officer and if catches anyone doing anything wins alone.
	
	
	// ---- MORE BOARD GAME GAME -----
	//each player wants to escape
	//players have a protagnoist and can build a collection of pawns - worker plaement
	// protagonistc is respect amongst inmates and or officers.
	// events trigger based on location deck
	// simulation ROUTINE by having set days for the library perhaps. 
	// Calendar might be different at the start to simulate different polices of a prison
	// moving a protagonist means you draw from a deck of social interactions.. dave say shey. some are sinister.
	// 
	
	// -- God father type ----
	// Relationship / Interactions.
	// God Father / Snitch / Right-hand man / Son / Wife / Girlfriend
	//     Rock 
	// Paper Scissors
	
	//Destructive Associations
	//    Father
	//  Son   Snitch
	
	//   GF  Wife
	//    RH man
	
	//Constructive Associations
	
	//    RH Man
	// GF   Father
	
	
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
