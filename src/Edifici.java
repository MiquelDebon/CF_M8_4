import java.util.Scanner;

public class Edifici {
    private final String name;
    private final int floors;
    private final int surface;

    //CONSTRUCTOR  ******************************************
    public Edifici(String name, int floors, int surface){
        this.name = name;
        this.floors = floors;
        this.surface = surface;
    }

    //GETTER ******************************************
    public String getName(){
        return  this.name;
    }
    public int getFloors() {
        return this.floors;
    }
    public int getSurface() {
        return this.surface;
    }

    @Override
    public String toString() {
        return "Building " + this.getClass() +
                ", Name: " + this.name +
                ", floors " + this.floors +
                ", surface " + this.surface ;
    }

    //SETTER - no shan de poder modifica diu l'anunciat ******************************************

    //Methods ****************************************

    public float costCleaningMonth() {
        //Atribute
        float resultTime = 0;
        final int SPEED = 5; //minute/5m2
        final float PLUSFLOOR = 0.5f;
        final int PRICE = 1; //€/minute
        final int DAYSMOTH = 30;
        int surfaceBuilding  = this.getSurface();
        int floorsBuilding = this.getFloors();

        resultTime = (((float)(surfaceBuilding / SPEED) * PRICE) + (floorsBuilding * PLUSFLOOR)) * DAYSMOTH;

        return resultTime;
    }

    public String costSecurity(){
        //Attribute
        int resultCost = 0;
        final int SURFACESECURITY = 1000;  //Hospital and Hotel
        int amountSecurity = (int)Math.ceil((double)this.getSurface() / SURFACESECURITY);
        final int PRICE = 1300;

        resultCost = amountSecurity * PRICE;

        return "Cost of security is " + resultCost +"€";
    }

}
