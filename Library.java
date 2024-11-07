
import java.util.Hashtable;

public class Library extends Building {

    private Hashtable<String, Boolean> collection;

    public Library() {
      this("<Address Unknown>"); // Call next biggest constructor
    }
  
    /* Overloaded constructor with address only */
    public Library(String address) {
      this("<Name Unknown>", address); // Call next biggest constructor
    }
  
    /* Overloaded constructor with name, address */
    public Library(String name, String address) {
      this(name, address, 1); // Call next biggest constructor
    }

    public Library(String name, String address, int nFloors) {
      this(name, address, nFloors, true);
    }

    public Library(String name, String address, int nFloors, boolean hasElevator) {
      super(name, address, nFloors, hasElevator); 
      collection = new Hashtable<>();
      System.out.println("You have built a library: 📖");
    }
    
    /**
     * adds a book to the collection
     * @param title book to add
     */
    public void addTitle(String title){
      collection.put(title, true);
    }

    /**
     * removes a book from the collection
     * @param title title of book to remove
     * @return title of removed book
     */
    public String removeTitle(String title){
      if (this.containsTitle(title)){
        if (isAvailable(title)){
          collection.remove(title);
          return title;
        }
        else {
          throw new RuntimeException("Cannot remove book which is checked out");
        }
      }
      else {
        throw new RuntimeException("Cannot remove book which is not in collection");
      }
    }

    /**
     * checks out a book (sets the associated value to false)
     * @param title book to check out
     */
    public void checkOut(String title){
      if (this.containsTitle(title)){
        if (isAvailable(title)){
          collection.put(title, false);
          System.out.println("Checked out " + title);
        }
        else {
          throw new RuntimeException("Cannot check out book which is already checked out");
        }
      }
      else {
        throw new RuntimeException("Cannot check out book which is not in collection");
      }
    }

    /**
     * returns a book (sets the associated value to true)
     * @param title book to return
     */
    public void returnBook(String title){
      if (this.containsTitle(title)){
        if (!isAvailable(title)){
          collection.put(title, true);
          System.out.println("Returned " + title);
        }
        else {
          throw new RuntimeException("Cannot return book which is already at location");
        }
      }
      else {
        throw new RuntimeException("Cannot return book which is not in collection");
      }
    }

    /**
     * returns true if the title appears as a key in the Libary's collection, false otherwise
     * @param title book to check
     * @return true if the title appears as a key in the Libary's collection, false otherwise
     */
    public boolean containsTitle(String title){
      return collection.containsKey(title);
    } 

    /**
     * returns true if the title is currently available, false otherwise
     * @param title book to check availiability
     * @return  true if the title is currently available, false otherwise
     */
    public boolean isAvailable(String title){
      if (this.containsTitle(title)){
        return collection.get(title);
      }
      else {
        return false;
      }
    } 

    /**
     * prints out the entire collection in an easy-to-read way (including checkout status)
     */
    public void printCollection(){
      collection.forEach(
        (k, v) -> System.out.println(k + " \n\tAvaliable? " + v));
    } 

    @Override
    public void showOptions() {
      super.showOptions();
      System.out.println(" + printCollection() \n + checkOut(book) \n + returnBook(book) \n + addTitle(book) \n + removeTitle(book) \n + isAvaliable(book)");
  }

    public static void main(String[] args) {
      Library neilson = new Library("Neilson Library", "7 Neilson Drive", 4, true);
      System.out.println(neilson);
      System.out.println("adding books to collection...");
      neilson.addTitle("Fables: Legends in exile");
      neilson.addTitle("Galactus");
      neilson.addTitle("Soldier's Heart");
      neilson.addTitle("Can't We Talk About Something More Pleasant?");
      System.out.println("checking out a book...");
      neilson.checkOut("Soldier's Heart");
      System.out.println("printing collection...");
      neilson.printCollection();
    }
  
  }