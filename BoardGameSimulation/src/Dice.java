import java.util.Random;

public class Dice {
	
	int noSides;
	int lastResult;
	
	public Dice(int sides) {
		this.noSides = sides;
	}
	
	public int rollDice()
    { 
        int roll = 0;
        Random  r = new Random(); 

        roll = r.nextInt(this.noSides)+1;
        System.out.println("Roll is:  "+roll);
        this.lastResult = roll;
        return roll;  
    } 

}
