import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class M8Ex4_MiquelDebon {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Edifici> buildingList = new ArrayList<Edifici>();
    static final String stringAnErrorHasOccur = "❌️ An error has occurred";
    static final String stringWriteValidValue = "❌ Select a valid value/option";
    static final String stringNoBuildingYet = "❌ We don't have building yet!";
    static final String stringNoBuildingWithThisName = "❌We don't have any building with this name";


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
                    System.out.println(stringAnErrorHasOccur);
            }
        }while(!exitGame);


    }

    //🟠Methods *********************************************

    //Menu Metohd
    public static byte menu(){
        boolean rightInt = false;
        int selectedOption = 0;
        final byte MINIMO = 0;
        final byte MAXIMO = 3;

        System.out.println("_____________________🏛️ Main menu 🏛️___________________ ");
        System.out.println("      1. Create new building     3. Show buildings  ");
        System.out.println("      2. Delete building         0. Exit the program ");

        do{
            System.out.print("✏️Write your option(1-4): ");
            selectedOption = inputOutputInt();

            if(selectedOption < MINIMO || selectedOption > MAXIMO){
                System.out.println(stringWriteValidValue);
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
        boolean rightSelection = false;
        Hospital hospital;
        Hotel hotel;
        Cinema cinema;

        System.out.println("☑️Option 1 - Create building");
        System.out.println("You can create these buildings:");
        System.out.println("    1.Hospital    2.Hotel     3.Cinema ");

        do{
            System.out.print("✏️Which building do you want to create (1-4)? ");
            elecction = inputOutputInt();
            if(elecction > 0 && elecction < 4){
                rightSelection = true;
            }else{
                System.out.println(stringWriteValidValue);
            }
        }while(!rightSelection);


        switch (elecction){
            case 1: //Hospital
                System.out.println("☑️Create a Hospital");
                hospital = (Hospital) questionsToCreateBuilding(elecction);
                buildingList.add(hospital);
                System.out.println("Summary : " + stringSummaryBuilding());
                System.out.printf("✅We have correctly created a Hospital   🏛️%d nº Buildings \n", buildingList.size());
                break;

            case 2: //Hotel
                System.out.println("☑️Create a Hotel");
                hotel = (Hotel) questionsToCreateBuilding(elecction);
                buildingList.add(hotel);
                System.out.println("Summary : " + stringSummaryBuilding());
                System.out.printf("✅We have correctly created a Hotel      🏛️%d nº Buildings \n", buildingList.size());
                break;

            case 3: //Cinema
                System.out.println("☑️Create a Cinema");
                cinema = (Cinema) questionsToCreateBuilding(elecction);
                buildingList.add(cinema);
                System.out.println("Summary : " + stringSummaryBuilding());
                System.out.printf("✅We have correctly created a Cinema     🏛️%d nº Buildings \n", buildingList.size());
                break;

            default:
                System.out.println(stringAnErrorHasOccur);
                break;
        }
        System.out.println();
    }

    //Method 2 - Delete a building
    public static void deleteBuilding(){
        //Attributes
        String name = "";
        Edifici edifici;
        String type = "";
        boolean existBuilding = false;
        int index = -1;
        int originalArrayLength = buildingList.size();
        int lastArrayLength = 0;

        System.out.println("☑️Option 2 - Delete a Building");
        if(buildingList.size() > 0){
            System.out.println("We currently have these buildings: ");
            for(Edifici edifici1:buildingList){
                System.out.printf("  '%s'\n", edifici1.getName());
            }
            do{
                System.out.print("✏️Which building do you want to delete? ");
                name = scan.nextLine();
                index = findIndexBuilding(name);
                existBuilding = (index != -1) ? true : false;
                if(!existBuilding){
                    System.out.println(stringNoBuildingWithThisName);
                }
            }while(!existBuilding);

            edifici = buildingList.get(index);
            type = edifici.getClass().toString();
            buildingList.remove(index);
            lastArrayLength = buildingList.size();

            if(lastArrayLength == (originalArrayLength-1)){
                System.out.println("Summary : " + stringSummaryBuilding());
                System.out.printf("The %s '%s' has been remove\n",type, name);
                System.out.printf("✅ We have correctly delete a building  🏛️%d nº Buildings \n", buildingList.size());
            }else{
                System.out.println(stringAnErrorHasOccur);
            }
        }else{
            System.out.println(stringNoBuildingYet);
        }

        System.out.println();

    }


    //Option 3 - View buildings
    public static void showBuildings(){
        System.out.println("☑️Option 3 - View buildings ");
        for(Edifici edifici : buildingList){
            System.out.println("    " + edifici);
        }
        System.out.println("Summary : " + stringSummaryBuilding());
        System.out.println("✅ We have correctly printed a list of buildings");
        System.out.println();
    }



    //⏩Other support Methos  *******************************************

    static int findIndexBuilding(String queriedName){
        Edifici edifici;
        boolean existBuilding = false;
        int index = -1;
        int i = 0;

        while(!existBuilding && (i < buildingList.size())){
            edifici = buildingList.get(i);
            if(queriedName.equalsIgnoreCase(edifici.getName())){
                existBuilding = true;
                index = i;
            }
            i++;
        }
        return index;
    }


    static String stringSummaryBuilding(){
        int amountCinema = 0;
        int amountHotel = 0;
        int amountHospital = 0;

        Cinema cinema = new Cinema();
        Hotel hotel = new Hotel();
        Hospital hospital = new Hospital();

        for(Edifici edifici : buildingList){
            amountCinema = (edifici.getClass().equals(cinema.getClass())) ? ++amountCinema : amountCinema;
            amountHotel = (edifici.getClass().equals(hotel.getClass())) ? ++amountHotel : amountHotel;
            amountHospital = (edifici.getClass().equals(hospital.getClass())) ? ++amountHospital : amountHospital;
        }

        return String.format("🎥 nº%d - 🏨 nº%d  -  🏥 mº%d ", amountCinema, amountHotel, amountHospital);
    }

    static int inputOutputInt() {
        int numero = 0;
        boolean correcto = false;

        do {
            try {
                numero = scan.nextInt();
                correcto = true;
            } catch (InputMismatchException ex) {
                System.out.print("❌ Select a valid value ✏️: ");
            }
            scan.nextLine();
        } while (!correcto);
        return numero;
    }


    public static Edifici questionsToCreateBuilding(int election){
        //Attribute
        Hospital hospital;
        Hotel hotel;
        Cinema cinema;

        int floors = 0, surface =0, numberOfPatients = 0;
        String name = "";

        System.out.print("✏️Building name: ");
        name = scan.nextLine();
        System.out.print("✏️How many floors? ");
        floors = inputOutputInt();
        System.out.print("✏️How many m2? ");
        surface = inputOutputInt();

        switch (election){
            case 1:
                System.out.print("✏️How many patients has the Hospital? ");
                numberOfPatients = inputOutputInt();
                return hospital = new Hospital(name, floors, surface, numberOfPatients);
            case 2:
                return hotel = new Hotel(name, floors, surface);
            case 3:
                return cinema = new Cinema(name, floors, surface);
        }
        return null;
    }


}


