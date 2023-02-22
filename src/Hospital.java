import java.util.Scanner;

public final class Hospital extends Edifici {
    //Attribute
    private int numberOfPatients;
    static Scanner scan = new Scanner(System.in);



    //Constructor **********************************
    public Hospital(String name, int floors, int surface, int numberofPatients) {
        super(name, floors, surface);
        this.numberOfPatients = numberofPatients;
    }



    //GETTER Methods **********************************
    public int getNumberOfPatients(){
        return numberOfPatients;
    }

    //SETTEr Methods **********************************
    public void setNumberOfPatients(int numberOfPatients){
        this.numberOfPatients = numberOfPatients;
    }


    //LOGIC Methods  ****************************************

    public String feedPatients(){
        //Attribute
        int timesperDay = 3;
        int portion = 0;

        portion = this.numberOfPatients * timesperDay;

        return String.format("%d portions are being given\n", portion);
    }


    public String toString() {
        return "🏥Building " + super.getClass() +
                ", named: " + super.getName() +
                ", has " + super.getFloors() +
                " floors with " + super.getSurface()  +
                " quare meteres and " + this.getNumberOfPatients() + " number of patients." +
                " The Hospital has a cost of " + this.costSecurity() ;
    }

}
