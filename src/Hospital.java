import java.util.Scanner;

public final class Hospital extends Edifici {
    //Attribute
    private int numberofPatients;
    static Scanner scan = new Scanner(System.in);



    //Constructor **********************************
    public Hospital(){}
    public Hospital(String name, int floors, int surface, int numberofPatients) {
        super(name, floors, surface);
        this.numberofPatients = numberofPatients;
    }



    //GETTER Methods **********************************
    public int getNumberofPatients(){
        return numberofPatients;
    }

    //SETTEr Methods **********************************
    public void setNumberofPatients(int numberofPatients){
        this.numberofPatients = numberofPatients;
    }


    //LOGIC Methods  ****************************************

    public void feedPatients(){
        //Attribute
        int timesperDay = 3;
        int portion = 0;

        portion = this.numberofPatients * timesperDay;

        System.out.printf("%d portions are being given\n", portion);
    }


    public String toString() {
        return "🏥Building " + super.getClass() +
                ", named: " + super.getName() +
                ", has " + super.getFloors() +
                " floors with " + super.getSurface()  +
                " quare meteres and " + this.getNumberofPatients() + " number of patients." +
                " The Hospital has a cost of " + this.costSecurity() ;
    }

}
