import java.util.Scanner;

public class Edifici {
    private String name;
    private int floors;
    private int surface;

    //CONSTRUCTOR  ******************************************
    public Edifici(){}

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

    //SETTER ******************************************

    public void setName(String name){
        this.name = name;
    }

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

    public int costSecurity(){
        //Attribute
        int resultCost = 0;
        final int SURFACESECURITY = 1000;  //Hospital and Hotel
        int amountSecurity = (int)Math.ceil((double)this.getSurface() / SURFACESECURITY);
        final int PRICE = 1300;

        resultCost = amountSecurity * PRICE;

        return resultCost;
    }

}
