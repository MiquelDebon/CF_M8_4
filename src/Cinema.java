public final class Cinema extends Edifici {
    //Constructors *************************************
    public Cinema(String name, int floors, int surface) {
        super(name, floors, surface);
    }


    //Methods *******************************************
    public String costSecurity(){ //SurfaceSecurity 3000m2
        //Attribute
        int resultCost = 0;
        final int SURFACESECURITY = 3000;
        int amountSecurity = (int)Math.ceil((double)super.getSurface() / SURFACESECURITY);
        final int PRICE = 1300;

        resultCost = amountSecurity * PRICE;

        return "Cost of security is " + resultCost +"€";
    }

    public String projectFilm(int amountPeople, int ticketPrice){
        String output = "";
        final int maxCapacity = 30;
        int recaptacion = 0;


        if(amountPeople <= maxCapacity){
            recaptacion = amountPeople * ticketPrice;
            output = String.format("💰We got %d€. %d tickets were sold with a price of %d€\n", recaptacion, amountPeople, ticketPrice);
        }else{
            recaptacion = maxCapacity * ticketPrice;
            output = String.format("⚠️We have sold out all the tickets");
            output += String.format("💰We got %d€. %d tickets were sold with a price of %d€\n", recaptacion, maxCapacity, ticketPrice);
        }
        return output;
    }

    public String toString() {
        return "🎬 This Cinema" +
                ", Name: " + super.getName() +
                ", floors " + super.getFloors() +
                ", surface " + super.getSurface() +"m2" ;
    }
}
