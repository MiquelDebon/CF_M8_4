public final class Hotel extends Edifici{

    //Constructors*************************************
    public Hotel(){}
    public Hotel(String name, int floors, int surface) {
        super(name, floors, surface);
    }

    //Methods ********************************************


    public int costSecurity(){ // PRICE 500€ plus
        //Attribute
        int resultCost = 0;
        final int SURFACESECURITY = 1000;
        int amountSecurity = (int)Math.ceil((double)this.getSurface() / SURFACESECURITY);
        final int PRICE = 1300 + 500;

        resultCost = amountSecurity * PRICE;

        return resultCost;
    }

    public void serviceNumbers(){
        //Attribute
        final int roomsXserver = 20;
        int rooms = this.getSurface() / 25; //each room has 25 m2
        int amountEmployee = rooms / roomsXserver;
        int salaryEmployee = 1000;
        int costEmployee = amountEmployee * salaryEmployee;

        System.out.printf("The amount of employees we need are %d, for %d rooms\n",amountEmployee, rooms );
        System.out.printf("The total cost of the employees is %d€, with a salary of %d€\n", costEmployee, salaryEmployee);
    }

    public String toString(){
        return String.format("🏨This Hotel named %s, has %d m2, %d floors. \nWith a Security cost of %d ",
                super.getName(), super.getSurface(), super.getFloors(), this.costSecurity());
    }

}
