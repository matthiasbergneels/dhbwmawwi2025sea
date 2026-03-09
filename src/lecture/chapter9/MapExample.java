package lecture.chapter9;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {

  public static void main(String[] args) {
    Map<Integer, String> cities  = new HashMap<Integer, String>();

    cities.put(Integer.valueOf(69190), "Walldorf");
    cities.put(47051, "Duisburg");
    cities.put(12359, "Köln");
    cities.put(68161, "Mannheim");
    cities.put(21614, "Buxtehude");

    System.out.println(cities.get(69190));

    System.out.println("Anzahl Städte: " +  cities.size());

    cities.remove(69190);


    cities.put(12359, "Neu Köln");

    Set<Integer> keySet = cities.keySet();
    for(int plzKey : keySet) {
      System.out.println(plzKey + " - "  + cities.get(plzKey) );
    }

    Collection<String> values = cities.values();
    for(String city : values) {
      System.out.println(city);
    }

    System.out.println(cities);

  }
}
