public final class Cinema extends Edifici {
    //Constructors *************************************
    public Cinema(){};

    public Cinema(String name, int floors, int surface) {
        super(name, floors, surface);
    }


    //Methods *******************************************
    public int costSecurity(){ //SurfaceSecurity 3000m2
        //Attribute
        int resultCost = 0;
        final int SURFACESECURITY = 3000;
        int amountSecurity = (int)Math.ceil((double)super.getSurface() / SURFACESECURITY);
        final int PRICE = 1300;

        resultCost = amountSecurity * PRICE;

        return resultCost;
    }

    public void projectFilm(int amountPeople, int ticketPrice){
        //Attribute
        final int maxCapacity = 30;
        int recaptacion = 0;


        if(amountPeople <= maxCapacity){
            recaptacion = amountPeople * ticketPrice;
            System.out.printf("💰We got %d€. %d tickets were sold with a price of %d€\n", recaptacion, amountPeople, ticketPrice);
        }else{
            recaptacion = maxCapacity * ticketPrice;
            System.out.println("❌We have sold out all the tickets");
            System.out.printf("💰We got %d€. %d tickets were sold with a price of %d€\n", recaptacion, maxCapacity, ticketPrice);

        }
    }

    public String toString() {
        return "🎬Building " + super.getClass() +
                ", Name: " + super.getName() +
                ", floors " + super.getFloors() +
                ", surface " + super.getSurface() ;
    }
}
