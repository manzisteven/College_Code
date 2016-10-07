import java.util.HashMap;

import Creatures.Creature;


public class test {

	public static void main(String[] args) {
    HashMap<String, Integer> trackBirdsMovement = new HashMap<String, Integer>();
    trackBirdsMovement.put("M", 0);
    Integer a =  trackBirdsMovement.get("M");
    Integer b = a+2;
    trackBirdsMovement.put("S", b);
    Integer d =  trackBirdsMovement.get("S");
    System.out.print(d);
	}

}
