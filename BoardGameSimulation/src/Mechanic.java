import java.util.ArrayList;
import java.util.Scanner;

public class Mechanic {
	
	public static Scanner scanner = new Scanner(System.in);;
	
	public static boolean checkResultFor(int number, ArrayList<Dice> dices){
		
		int diceval;
		
		for (int i=0;i<dices.size();i++) {
			diceval = dices.get(i).lastResult;
			ArrayList<Dice> tempDices = new ArrayList<>(dices);
			tempDices.remove(i);
			 
			for (Dice td: tempDices) {
				if(diceval+td.lastResult==number) {
					System.out.println("A "+number+" was found");
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean hasWon(Player player, Board board) { 
		if(player.getHand().size() < 2) { // players need to not have many posessions when escaping.
			
			
			
		}
		
		return true;
	}
	
	public static void chooseFromCards(int cardCount, Deck deck, Player chooser, Player taker) {
		
		Hand drawnHand = chooser.drawXCardsToAHand(cardCount, deck);
		
		drawnHand.revealHand();
		
		Hand splitHand1 = new Hand();
		Hand splitHand2 = new Hand(drawnHand);

		//Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println(chooser.getName()+": Split these cards into two piles. Choose cards for first pile (e.g. 2,4): ");
		String chooser_choice = scanner.next(); // Scans the next token of the input as an int.
		
		String[] inputList = chooser_choice.split(",");

		for(int i=0; i<inputList.length; i++) {
			
			for(Card card : drawnHand.getCards()) {

				if(inputList[i].equals(card.getLabel())) {
					splitHand1.addCard(card);
					splitHand2.removeCardsWithLabel(card.getLabel());
					
					
				}
			}

		}
		
		System.out.println("---- Split 1 ----");
		splitHand1.revealHand();	
		System.out.println("---- Split 2 ----");
		splitHand2.revealHand();
		
		System.out.println(taker.getName()+": Select which pile you want. Enter 1 or 2: ");
		String taker_choice = scanner.next();
		
		if(taker_choice.equals("1")) {
			
			taker.addCardsToHand(splitHand1);
			
		} else if(taker_choice.equals("2")) {
			
			taker.addCardsToHand(splitHand2);

			
		} else {
			System.out.println("You entered an incorrect value");
		}
		
	}
	
	public static boolean isLegalChoice(String inputString, Hand sourceHand, Hand selectedHand, Hand unselectedHand, int legalCount) {
		
		String[] choice = inputString.split(",");
		boolean isLegal = false;
		
		if(choice.length==1 && choice[0].equals("X")) {
			isLegal = true;
		}
		
		int valid_count = 0;
		for(int i=0; i<choice.length; i++) {
			
			for(Card card : sourceHand.getCards()) {

				if(choice[i].equals(card.getLabel())) {
					
					selectedHand.addCard(new Card(card));
					unselectedHand.removeCardsWithLabel(card.getLabel());
					valid_count++;
				}
			}

		}
			
		if(legalCount==-1 && valid_count==choice.length) {
			//if there's not a restricted count on the cards, then we just need to ensure our choices are all valid.
			isLegal = true;
			
		} else if((legalCount>0) && (valid_count==legalCount)) {
			//otherwise if there is a legal count required, we need to ensure we select the right number of cards.
			isLegal = true;
					
		}

		return isLegal;
	
	}
	
	public static void Swapsies(Player initiator, ArrayList<Player> players) {
		
		//initiator splits own hand into two, unwanted and outstanding.
		Hand cardsUnwanted = new Hand();
		Hand cardsOutstanding = new Hand(initiator.getHand());
		
		System.out.println(initiator.getName()+": Select Unwanted Cards (e.g. 2,4 or X for none): ");
			
		while(!isLegalChoice(scanner.next(), initiator.getHand(), cardsUnwanted, cardsOutstanding,-1)) {
			
			System.out.println("Invalid Selection..");
			System.out.println(initiator.getName()+": Select Unwanted Cards (e.g. 2,4 or X for none): ");
			cardsUnwanted = new Hand();
			cardsOutstanding = new Hand(initiator.getHand());
		}
		
		System.out.println("---- Unwanted Cards ----");
		cardsUnwanted.revealHand();
		System.out.println("---- Remaining Cards ----");
		cardsOutstanding.revealHand();
		System.out.println("-------------------------");
		
		for(Player receiver : players) {
			//skip the initiator
			if(!(receiver.getName().equals(initiator.getName()))) {
				
				System.out.println(receiver.getName()+": Select which unwanted card(s) from "+initiator.getName()+" you want. e.g. 1,4 or X for none ");
				Hand receivedHand = new Hand();
				Hand unreceivedHand = new Hand(cardsUnwanted);

				while(!isLegalChoice(scanner.next(), cardsUnwanted, receivedHand, unreceivedHand,-1)) {
					System.out.println("Invalid Selection..");
					System.out.println(receiver.getName()+": Select which unwanted card(s) from "+initiator.getName()+" you want. e.g. 1,4 or X for none ");
					receivedHand = new Hand();
					unreceivedHand = new Hand(cardsUnwanted);
				}
				
				int receivedCardCount=receivedHand.size();
				if(receivedCardCount>0) {
					System.out.println(receiver.getName()+": Choose "+receivedCardCount+" card(s) to swap with "+initiator.getName());	
				}
				
				Hand returnedHand = new Hand();
				Hand unreturnedHand = new Hand(receiver.getHand());
				
				while(receivedCardCount>0 && !isLegalChoice(scanner.next(), receiver.getHand(), returnedHand, unreturnedHand,receivedCardCount) ) {
					System.out.println("Invalid Selection..");
					System.out.println(receiver.getName()+": Choose "+receivedCardCount+" card(s) to swap with "+initiator.getName());
					returnedHand = new Hand();
					unreturnedHand = new Hand(receiver.getHand());
				}
					
				
				for(Card unwantedCard : cardsUnwanted.getCards()) {
					initiator.getHand().removeCardsWithLabel(unwantedCard.getLabel());
				}
				
				for(Card receivedCard : receivedHand.getCards()) {
					cardsUnwanted.removeCardsWithLabel(receivedCard.getLabel());
					initiator.getHand().removeCardsWithLabel(receivedCard.getLabel());
					receiver.getHand().addCard(new Card(receivedCard));
				}
				
				for(Card returnedCard : returnedHand.getCards()) {
					initiator.getHand().addCard(new Card(returnedCard));
					receiver.getHand().removeCardsWithLabel(returnedCard.getLabel());
				}
				
				System.out.println(" -----"+receiver.getName()+" hand ----- ");
				receiver.revealHand();
				
				System.out.println(" ----"+initiator.getName()+" hand ---- ");
				initiator.revealHand();
				
				System.out.println("---- Remaining Unwanted Cards ----");
				cardsUnwanted.revealHand();
				System.out.println("-------------------------");
					
				if(cardsUnwanted.size()==0) {
					break;
				}
			
			}
		}
		
		//if reach here and there's unwanted cards, then add them back into initiators hand
		if(cardsUnwanted.size()>0) {
			
			for(Card unwantedCard : cardsUnwanted.getCards()) {
				initiator.getHand().addCard(unwantedCard);
			}
			
			System.out.println("No more players to trade with, remaining unwanted cards return to "+initiator.getName()+"'s hand ");
			initiator.revealHand();
		}
		
		
		
	}
	


}
