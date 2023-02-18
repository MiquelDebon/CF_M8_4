import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class M8Ex4_MiquelDebon {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Edifici> buildingList = new ArrayList<Edifici>();
    public static void main(String[] args) {

        boolean exitGame = false;

        do{
            switch (menu()){
                case 0:
                    System.out.println("👋Good bye, I hope you had fun!");
                    exitGame = true;
                    break;
                case 1:
                    createBuilding();
                    break;
                case 2:
                    deleteBuilding();
                    break;
                case 3:
                    showBuildings();
                    break;
                default:
                    System.out.println("An error occur");
            }
        }while(!exitGame);


    }

    //🟠Methods *********************************************

    //Menu Metohd
    public static byte menu(){
        boolean rightInt = false;
        int selectedOption = 0;
        final byte MINIMO = 0;
        final byte MAXIMO = 6;

        System.out.println("__________________🏛️ Main menu 🏛️________________ ");
        System.out.println("   1. Create new building     3. Show buildings  ");
        System.out.println("   2. Delete building         0. Exit the program ");

        do{
            System.out.print("✏️Write your option(1-4): ");
            selectedOption = inputOutputInt();

            if(selectedOption < MINIMO || selectedOption > MAXIMO){
                System.out.println("❌ Select a valid option");
            }else{
                rightInt = true;
            }
        }while(!rightInt);
        System.out.println();
        return (byte)selectedOption;
    }

    //Method Option 1 - Create building
    static void createBuilding(){
        //Attribute
        int elecction = 0;
        boolean exit = false;
        boolean rightSelection = false;
        Hospital hospital;
        Hotel hotel;
        Cinema cinema;
        String name = "";
        int floors = 0;
        int surface = 0;
        int patients = 0;

        System.out.println("☑️Option 1 - Create building");
        System.out.println("You can create these buildings:");
        System.out.println("    1.Hospital    2.Hotel     3.Cinema  0.Main-Menu");

        do{
            System.out.print("✏️Which building do you want to create (1-4)? ");
            elecction = scan.nextInt();
            if(elecction > 0 && elecction < 4){
                rightSelection = true;
            }else if(elecction == 0){
                System.out.println("✅Going back Main-Menu \n");
                rightSelection =true;
                exit = true;
            }else{
                System.out.println("❌Please choose a right option");
            }
        }while(!rightSelection);

        while(!exit){
            switch (elecction){
                case 1: //Hospital
                    System.out.println("☑️Create a Hospital");

                    hospital = (Hospital) questionsToCreatBuilding(elecction);
                    buildingList.add(hospital);

                    System.out.println(String.format("✅We have correctly created a Hospital      🏛️%d nº Buildings \n", buildingList.size()));
                    exit = true;
                    break;

                case 2: //Hotel
                    System.out.println("☑️Create a Hotel");

                    hotel = (Hotel)questionsToCreatBuilding(elecction);
                    buildingList.add(hotel);

                    System.out.println(String.format("✅We have correctly created a Hotel      🏛️%d nº Buildings\n", buildingList.size()));
                    exit = true;
                    break;

                case 3: //Cinema
                    System.out.println("☑️Create a Cinema");

                    cinema = (Cinema) questionsToCreatBuilding(elecction);
                    buildingList.add(cinema);

                    System.out.println(String.format("✅We have correctly created a Cinema   🏛️%d nº Buildings\n ", buildingList.size()));
                    exit = true;
                    break;

                default:
                    exit = true;
                    System.out.println("⚠️An error has ocuure");
                    break;
            }
        }
    }

    //Method 2 - Delete a building
    public static void deleteBuilding(){
        //Attributes
        String name = "";
        Edifici edifici;
        int originalArrayLength = buildingList.size();
        int lastArrayLength = 0;

        System.out.println("☑️Option 2 - Delete a Building");
        System.out.println("We currently have these buildings: ");
        for(Edifici edifici1:buildingList){
            System.out.printf("  '%s'", edifici1.getName());
        }
        System.out.print("\n✏️Which building do you want to delete? ");
        name = scan.nextLine();
        for(int i=0; i<buildingList.size(); i++){
            edifici = buildingList.get(i);
            if(edifici.getName().equalsIgnoreCase(name)){
                buildingList.remove(i);
            }
            lastArrayLength = buildingList.size();
        }
        if(lastArrayLength == (originalArrayLength-1)){
            System.out.println(String.format("✅ We have correctly delete a building  🏛️%d nº Buildings \n", buildingList.size()));
        }else{
            System.out.println("❌An error has occurs\n");
        }
    }


    //Option 3 - View buildings
    public static void showBuildings(){
        System.out.println("☑️Option 3 - View buildings ");
        for(Edifici edifici : buildingList){
            System.out.println(edifici);
        }
        System.out.println("✅ We have correctly printed a list of buildings");
        System.out.println();
    }



    //⏩Other support Methos  *******************************************
    public static int inputOutputInt() {
        int numero = 0;
        boolean correcto = false;

        do {
            try {
                numero = scan.nextInt();
                correcto = true;
            } catch (InputMismatchException ex) {
                System.out.println("❌ Select a valid option");
            }
            scan.nextLine();
        } while (!correcto);
        return numero;
    }


    public static Edifici questionsToCreatBuilding(int election){
        //Attribute
        Hospital hospital;
        Hotel hotel;
        Cinema cinema;

        int floors = 0, surface =0, numberOfPatients = 0;
        String name = "";

        System.out.print("✏️Building name: ");
        scan.nextLine();
        name = scan.nextLine();
        System.out.print("✏️How many floors? ");
        floors = scan.nextInt();
        System.out.print("✏️How many m2? ");
        surface = scan.nextInt();

        switch (election){
            case 1:
                System.out.print("✏️How many patients has the Hospital? ");
                numberOfPatients = scan.nextInt();
                return hospital = new Hospital(name, floors, surface, numberOfPatients);
            case 2:
                return hotel = new Hotel(name, floors, surface);
            case 3:
                return cinema = new Cinema(name, floors, surface);
        }
        return null;
    }

}


