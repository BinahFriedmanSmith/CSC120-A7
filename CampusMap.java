import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        Library neilson = new Library("Neilson Library", "7 Neilson Drive Northampton, MA 01063", 4, true);
        House gillett = new House("Gillett House", "47 Elm street Northampton, MA 01063",5, true, true);
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Hillyer Hall", "22 Elm street Northampton, MA 01063", 4));
        myMap.addBuilding(gillett);
        myMap.addBuilding(new House("Northrop House", "49 Elm street Northampton, MA 01063",5, true, true));
        myMap.addBuilding(neilson);
        myMap.addBuilding(new House("Lamont House","17 Prospect street Northampton, MA 01063",3 ));
        myMap.addBuilding(new House());
        myMap.addBuilding(new Cafe("Compass Cafe", "7 Neilson Drive Northampton, MA 01063"));
        myMap.addBuilding(new Library());
        System.out.println(myMap);


        neilson.addTitle("Fables: Legends in exile");
        neilson.addTitle("Galactus");
        neilson.addTitle("Soldier's Heart");
        neilson.addTitle("Can't We Talk About Something More Pleasant?");

        String binah = "Binah";
        System.out.println("entering gillett");
        gillett.enter();
        gillett.showOptions();
        System.out.println("checking if Binah is a resident of Gillett: " + gillett.isResident(binah));
        System.out.println("attempting to move in Binah");
        gillett.moveIn(binah);
        System.out.println("checking if Binah is a resident: " + gillett.isResident(binah));
        System.out.println("heading to my room");
        gillett.goToFloor(3);
        System.out.println("heading down again (i take the stairs)");
        gillett.goDown();
        gillett.goDown();
        gillett.exit();
        System.out.println("off to the library. I have books to read for class.");
        neilson.enter();
        neilson.showOptions();
        neilson.checkOut("Can't We Talk About Something More Pleasant?");
        System.out.println("reading it... \nok done");
        neilson.returnBook("Can't We Talk About Something More Pleasant?");
        System.out.println("ok im done with college forever. attempting to move out Binah");
        gillett.moveOut(binah);
        System.out.println("checking if Binah is a resident: " + gillett.isResident(binah));
        System.out.println("attempting to move out Binah a second time. just to make sure");
        gillett.moveOut(binah);
        System.out.println("checking if Binah is a resident: " + gillett.isResident(binah));
    }
    
}
