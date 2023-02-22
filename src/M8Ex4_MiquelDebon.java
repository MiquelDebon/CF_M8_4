import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class M8Ex4_MiquelDebon {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Edifici> buildingList = new ArrayList<Edifici>();
    static final String STRING_AN_ERROR_HAS_OCCUR = "❌️ An error has occurred";
    static final String STRING_WRITE_VALID_VALUE = "❌ Select a valid value/option";
    static final String STRING_NO_BUILDING_YET = "❌ We don't have building yet!";
    static final String STRING_NO_BUILDING_WITH_THIS_NAME = "❌We don't have any building with this name";


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
                case 4:
                    showOneBuilding();
                    break;
                default:
                    System.out.println(STRING_AN_ERROR_HAS_OCCUR);
            }
        }while(!exitGame);


    }

    //🟠Methods *********************************************

    //Menu Metohd
    public static byte menu(){
        boolean rightInt = false;
        int selectedOption = 0;
        final byte MINIMO = 0;
        final byte MAXIMO = 4;

        System.out.println("_____________________🏛️ Main menu 🏛️___________________ ");
        System.out.println("      1. Create new building     3. Show buildings  ");
        System.out.println("      2. Delete building         4. Show info One building ");
        System.out.println("                                 0. Exit the program ");

        do{
            System.out.print("✏️Write your option(0-4): ");
            selectedOption = inputOutputInt();

            if(selectedOption < MINIMO || selectedOption > MAXIMO){
                System.out.println(STRING_WRITE_VALID_VALUE);
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
        Hospital hospital = null;
        Hotel hotel = null ;
        Cinema cinema = null;

        System.out.println("☑️Option 1 - Create building");
        System.out.println("You can create these buildings:");
        System.out.println("    1.Hospital    2.Hotel     3.Cinema ");

        do{ //Ask while user doesn't write an exiting building
            System.out.print("✏️Which building do you want to create (1-4)? ");
            elecction = inputOutputInt();
            if(elecction > 0 && elecction < 4){
                rightSelection = true;
            }else{
                System.out.println(STRING_WRITE_VALID_VALUE);
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
                System.out.println(STRING_AN_ERROR_HAS_OCCUR);
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
                name = scanner.nextLine();
                index = findIndexBuilding(name);
                existBuilding = (index != -1) ? true : false;
                if(!existBuilding){
                    System.out.println(STRING_NO_BUILDING_WITH_THIS_NAME);
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
                System.out.println(STRING_AN_ERROR_HAS_OCCUR);
            }
        }else{
            System.out.println(STRING_NO_BUILDING_YET);
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


    static void showOneBuilding(){
        Edifici quereidEdifici;
        String output = "";
        String queriedName = "";
        int indexqueriedBuilding = -1;
        boolean buildingExist = false;

        System.out.println("☑️Option 4 - View one buildings ");
        for(Edifici edifici : buildingList){
            output += String.format("  '%s'", edifici.getName());
        }
        System.out.println(output);

        do{
            System.out.print("white the building name ✏️: ");
            queriedName = scanner.nextLine();

            indexqueriedBuilding = findIndexBuilding(queriedName);
            buildingExist  = (indexqueriedBuilding != -1) ? true : false;
            if(!buildingExist){
                System.out.println(STRING_NO_BUILDING_WITH_THIS_NAME);
            }
        }while(!buildingExist);

        quereidEdifici = buildingList.get(indexqueriedBuilding);

        System.out.println(quereidEdifici);//General method

        //TODO: duda si es correcto usar "instanceof"
        if(quereidEdifici instanceof Hospital){
            System.out.println(((Hospital)(quereidEdifici)).feedPatients());
        }else if(quereidEdifici instanceof Hotel){
            System.out.println(((Hotel) quereidEdifici).serviceNumbers());
        }else{
            System.out.println(((Cinema) quereidEdifici).costSecurity());
            System.out.println(((Cinema) quereidEdifici).projectFilm(20, 15));
        }

        System.out.println("✅ We have correctly printed the information of buildings " + quereidEdifici.getName());
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

        Cinema cinema = null;
        Hotel hotel = null;
        Hospital hospital = null;

        for(Edifici edifici : buildingList){

            //TODO: duda si es correcto usar "instanceof"
            if (edifici instanceof Cinema) {
                ++amountCinema;
            }else if(edifici instanceof Hotel){
                ++amountHotel;
            }else{
                ++amountHospital;
            }
            //Option2
//            amountHotel =  edifici instanceof Hotel ? ++amountHotel : amountHotel;
//            amountHospital = edifici instanceof Hospital ? ++amountHospital : amountHospital;
            //Option 3
//            amountCinema = (edifici.getClass().equals(cinema.getClass())) ? ++amountCinema : amountCinema;
//            amountHotel = (edifici.getClass().equals(hotel.getClass())) ? ++amountHotel : amountHotel;
//            amountHospital = (edifici.getClass().equals(hospital.getClass())) ? ++amountHospital : amountHospital;
        }

        return String.format(" 🏥 nº%d - 🏨 nº%d - 🎥 mº%d ", amountHospital, amountHotel, amountCinema);
    }

    public static Edifici questionsToCreateBuilding(int election){
        Edifici edifici = null;
        String nom = "";
        int numPlantes;
        int surface;
        int enfermos = 0;


        System.out.print("Name  ✏️: ");
        nom = scanner.nextLine();
        System.out.print("Floors  ✏️: ");
        numPlantes = inputOutputInt();
        System.out.print("Square meters  ✏️: ");
        surface = inputOutputInt();

        switch (election){
            case 1:
                System.out.print("Enfermos ✏️: ");
                enfermos = inputOutputInt();
                edifici = new Hospital(nom, numPlantes, surface, enfermos);
                break;
            case 3:
                edifici = new Cinema(nom, numPlantes, surface);
                break;
            case 2:
                edifici= new Hotel(nom, numPlantes, surface);
                break;
        }
        return edifici;
    }


    static int inputOutputInt() {
        int numero = 0;
        boolean correcto = false;

        do {
            try {
                numero = scanner.nextInt();
                correcto = true;
            } catch (InputMismatchException ex) {
                System.out.print("❌ Select a valid value ✏️: ");
            }
            scanner.nextLine();
        } while (!correcto);
        return numero;
    }


}


