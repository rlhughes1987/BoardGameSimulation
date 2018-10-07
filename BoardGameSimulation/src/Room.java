import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Room {
	
	LIBRARY, FIELD, VISITATION, CANTEEN, HALLS, CELL;
	
	private static final List<Room> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();

	  public static Room randomRoom()  {
	    return VALUES.get(RANDOM.nextInt(SIZE));
	  }
		
}
