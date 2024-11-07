
public class Cafe extends Building{

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory
    
    /* Default constructor */
    public Cafe() {
        this("<Address Unknown>"); // Call next biggest constructor
    }

    /* Overloaded constructor with address only */
    public Cafe(String address) {
        this("<Name Unknown>", address); // Call next biggest constructor
    }

    /* Overloaded constructor with name, address */
    public Cafe(String name, String address) {
        this(name, address, 1); // Call next biggest constructor
    }

    /* Overloaded constructor with name, address, nfloors */
    public Cafe(String name, String address, int nFloors) {
        this(name, address, nFloors, 0,0,0,0); // Call full constructor with hard-coded beginning stock (if you cant be bothered to ask you get NOTHING)
    }

    public Cafe(String name, String address, int nFloors, int coffee, int sugar, int cream, int cups) {
        super(name, address, nFloors); 
        System.out.println("You have built a cafe: ☕");
        nCoffeeOunces = coffee;
        nSugarPackets = sugar;
        nCreams = cream;
        nCups = cups;
    }

    @Override
    public void goToFloor(int floorNum)
    {
       throw new RuntimeException("No customers allowed on the other floors.");
    }


    /* Default small black coffee */
    public void sellCoffee()
    {
        this.sellCoffee(6);
    }

    /* Overloaded method with size only */
    public void sellCoffee(int size)
    {
        this.sellCoffee(size, 0,0);
    }

    /**
     * removes ingredients for a requested coffee from the inventory
     * @param size ounces of coffee in the order
     * @param nSugarPackets # of packets of sugar in the order
     * @param nCreams # of creams in the order
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (activeFloor == -1){
            throw new RuntimeException("Cannot order coffee when not in buiding. \n..Unless you have GrubHub or something but that's not allowed here :p");
        }
        if (size > nCoffeeOunces){
            restock(size+100, 0,0,0);
        }
        if (nSugarPackets > this.nSugarPackets){
            restock(0, nSugarPackets + 10,0,0);
        }
        if (nCreams > this.nCreams){
            restock(0, 0,nSugarPackets + 10,0);
        }
        if (1 > this.nCups){
            restock(0, 0, 0,10);
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
    }
    
    /**
     * increases inventory levels by input amounts
     * @param nCoffeeOunces oz coffee to buy
     * @param nSugarPackets packets sugar to buy
     * @param nCreams creams to buy
     * @param nCups # cups to buy
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups)
    {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    @Override
    public void showOptions() {
        super.showOptions();
        System.out.println(" + sellCoffee(oz, # sugar packets, # creams)");
    }



    public static void main(String[] args) {
        Cafe compass = new Cafe("Compass Cafe", "7 Neilson Drive", 1, 150, 50, 50, 50);
        compass.sellCoffee(1, 1, 70);
        compass.showOptions();
    }
    
}
