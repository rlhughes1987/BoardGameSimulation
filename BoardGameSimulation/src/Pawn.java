
public class Pawn {
	
	private Room room;

	public Pawn() {
		
		this.setRoom(Room.randomRoom()); //pawns start in random rooms
		
		
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

}
