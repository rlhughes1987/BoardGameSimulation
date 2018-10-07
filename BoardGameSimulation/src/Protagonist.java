import java.util.ArrayList;

public class Protagonist {
	
	private ArrayList<Equipment> equipment;
	private String name;
	private Room room;
	private int respectInmates;
	private int respectOfficers;
	
	public Protagonist(String name) {
		this.setName(name);
		this.setEquipment(new ArrayList<Equipment>());
	}
	
	
	public ArrayList<Equipment> getEquipment() {
		return equipment;
	}
	public void setEquipment(ArrayList<Equipment> equipment) {
		this.equipment = equipment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public Room getRoom() {
		return room;
	}


	public void setRoom(Room room) {
		this.room = room;
	}


	public int getRespectInmates() {
		return respectInmates;
	}


	public void setRespectInmates(int respectInmates) {
		this.respectInmates = respectInmates;
	}


	public int getRespectOfficers() {
		return respectOfficers;
	}


	public void setRespectOfficers(int respectOfficers) {
		this.respectOfficers = respectOfficers;
	}

}
