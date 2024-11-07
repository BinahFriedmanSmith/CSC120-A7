import java.util.ArrayList;

public class House extends Building{

  ArrayList<String> residents;
  Boolean hasDining;

  public House() {
    this("<Address Unknown>"); // Call next biggest constructor
  }

  /* Overloaded constructor with address only */
  public House(String address) {
    this("<Name Unknown>", address); // Call next biggest constructor
  }

  /* Overloaded constructor with name, address */
  public House(String name, String address) {
    this(name, address, 1); // Call next biggest constructor
  }

  /* Overloaded constructor with name, address, nfloors */
  public House(String name, String address, int nFloors) {
    this(name, address, nFloors, false); // Call next biggest constructor
  }

  /* Overloaded constructor without hasElevator */
  public House(String name, String address, int nFloors, boolean hasDining) {
    this(name, address, nFloors, hasDining, false);
  }

  public House(String name, String address, int nFloors, boolean hasDining, boolean hasElevator) {
    super(name, address, nFloors, hasElevator);
    this.hasDining = hasDining;
    this.residents = new ArrayList<>();
    System.out.println("You have built a house: 🏠");
  }

  /**
   * returns whether the hose has a dining hall
   * @return true if there is a dining hall, false if not
   */
  public boolean hasDiningRoom() {
    return hasDining;
  }

  /**
   * Getter for number of current residents
   * @return number of current residents
   */
  public int nResidents(){
    return residents.size();
  }

  /**
   * adds a person to the arraylist of residents
   * @param name person to add
   */
  public void moveIn(String name){
    if (isResident(name)){     
      throw new RuntimeException(name + " is already a resident of " + this.getName());
    }
    else {
      residents.add(name);
    }
  }

  /**
   * removes a resident from the arraylist of residents
   * @param name name of the person to move out
   * @return the name of the person who moved out
   */
  public String moveOut(String name){
    if (isResident(name)){
      residents.remove(residents.indexOf(name));
      return name;
    }
    else {
      throw new RuntimeException("Cannot remove person who is not a resident");
    }
  } 

  /**
   * 
   * @param person
   * @return whether input person is a resident (in the instance's residents ArrayList)
   */
  public boolean isResident(String person){
    return residents.contains(person);
  }

  @Override
  public void showOptions() {
    super.showOptions();
    System.out.println(" + moveIn(student) \n + moveOut(student)");
}

  public static void main(String[] args) {
    House gillett = new House("Gillett House", "47 Elm street",5, true, true);
    System.out.println(gillett + " It is " + gillett.hasDiningRoom() + " that it has a dining room.");
    String binah = "Binah";
    System.out.println("checking if Binah is a resident: " + gillett.isResident(binah));
    System.out.println("attempting to move in Binah");
    gillett.moveIn(binah);
    System.out.println("checking if Binah is a resident: " + gillett.isResident(binah));
    System.out.println("attempting to move out Binah");
    gillett.moveOut(binah);
    System.out.println("checking if Binah is a resident: " + gillett.isResident(binah));
    System.out.println("attempting to move out Binah a second time");
    gillett.moveOut(binah);
    System.out.println("checking if Binah is a resident: " + gillett.isResident(binah));
  }
}