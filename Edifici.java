import java.util.Scanner;

public abstract class Edifici {
    private String name;
    private int floors;
    private int surface;

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

    //SETTER ******************************************

    protected void setName(String name){
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

    public abstract int costSecurity();

}
