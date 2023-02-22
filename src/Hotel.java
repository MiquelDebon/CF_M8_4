public final class Hotel extends Edifici{

    //Constructors*************************************
    public Hotel(String name, int floors, int surface) {
        super(name, floors, surface);
    }

    //Methods ********************************************


    public String costSecurity(){ // PRICE 500€ plus
        //Attribute
        int resultCost = 0;
        final int SURFACESECURITY = 1000;
        int amountSecurity = (int)Math.ceil((double)this.getSurface() / SURFACESECURITY);
        final int PRICE = 1300 + 500; //500 Danger plus

        resultCost = amountSecurity * PRICE;

        return "Cost of security is " + resultCost +"€";
    }

    public String serviceNumbers(){
        //Attribute
        String output = "";
        final int ROOMS_X_SERVER = 20;
        int rooms = this.getSurface() / 25; //each room has 25 m2
        int amountEmployee = (int)Math.ceil((double)rooms / ROOMS_X_SERVER);
        final int SALARY_EMPLOYEE = 1000;
        int costEmployee = amountEmployee * SALARY_EMPLOYEE;

        output = String.format("The amount of employees we need are %d, for %d rooms\n",amountEmployee, rooms );
        output += String.format("The total cost of the employees is %d€, with a salary of %d€\n", costEmployee, SALARY_EMPLOYEE);
        return output;
    }

    public String toString(){
        return String.format("🏨This Hotel named %s, has %d m2, %d floors. %s ",
                super.getName(), super.getSurface(), super.getFloors(), this.costSecurity());
    }

}
