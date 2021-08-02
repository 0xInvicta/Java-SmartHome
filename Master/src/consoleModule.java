import java.util.Scanner;

public class consoleModule {

                        // POPULATE //
    public void populate(smartHome home, int rooms, int plugs){
        home.createAttachedDevices(); // Initiates AttachedDevices Obj {only ran once}
        for(int i = 1; i <= rooms; i++){
            String roomName = getString("Please provide a name for room number " + (i) + " : ");
            home.addRoom(roomName, (i));
        }

        for(int ID = 1; ID <= plugs; ID++) {
            print("Enter plug information below \n");
            print(home.displayRooms());

            int roomID = getInt("Select the room for this plug (integer only):");

            print("Available devices list options: \n");
            print(home.displayAttachedDevices());

            int deviceNr = getInt("please select the device to attach to the smart plug (integer only)");

            home.addPlug(roomID, deviceNr, (ID), false);
        }
    }
                    // DISPLAY DASHBOARD //
    public void displayDashboard(smartHome home){
        print("\n" + String.format("%40s","--- DASHBOARD ---"));
        int roomSize = home.getRoomSize();
        for(int i = 0; i < roomSize; i++){
            print("Room: " + (i+1));

            print(home.displayPlugData(i));

        }
        pageBreak();
    }

                            // MENU //
    public void menuOptions(smartHome home) {

        print(String.format("%40s","--- MENU OPTIONS ---"));
        print(String.format("%45s", "---please select option: ---\n"));
        print("1 - House level options");  // CASE 1
        print("2 - Room level options");  // CASE 2
        print("3 - Plug level options"); // CASE 3
        print("4 - System options");    // CASE 4

        int optionLevel = getInt(">>");

        switch (optionLevel) {
            case 1:
                print("HOUSE LEVEL OPTIONS: ");
                print("1 - Switch all plugs off\n" +
                      "2 - Switch all plugs on");

                int houseChoice = getInt("Select an option: ");

                switch (houseChoice) {
                    case 1 -> home.switchOff();
                    case 2 -> home.switchOn();
                }
                break;
            case 2:
                print(home.displayRooms());

                int roomChoice= getInt("Please select room (Integer only)");

                print(home.displayPlugData(roomChoice-1));

                int roomLevelOption = getInt("ROOM LEVEL OPTIONS \n" +
                                                 "1 - Switch all plugs off in room \n" +
                                                 "2 - Switch all plugs on in room \n" +
                                                 "3 - Select a plug in the room and toggle its on/off status");
                switch(roomLevelOption) {
                    case 1:
                        home.switchOffRoom(roomChoice);

                        break;
                    case 2:
                        home.switchOnRoom(roomChoice);

                        break;
                    case 3:
                        print(home.displayPlugData(roomChoice-1));
                        int plugChoice = getInt("Select a SmartPlugs ID in this room (Integer only): ");

                        home.toggleSwitch(roomChoice, plugChoice);

                        break;
                }
                    break;
            case 3:
                print(home.displayAllPlugData());

                int plugIDChoice = getInt("Please Select Plug ID (Integer only)");

                print("PLUG LEVEL OPTIONS: \n" +
                        "1 - Switch plug off\n" +
                        "2 - Switch plug on\n" +
                        "3 - Change attached device\n" +
                        "4 - Move plug to different room\n");

                int plugLevelChoice = getInt("Select an Option");

                switch(plugLevelChoice){
                    case 1:
                        home.switchPlugOff(plugIDChoice);

                        break;

                    case 2:
                        home.switchPlugOn(plugIDChoice);

                        break;

                    case 3:
                        print(home.displayAttachedDevices());
                        int deviceChoice = getInt("Enter device to attach to smart plug (Integer only)");

                        home.changeDevice(plugIDChoice, deviceChoice);

                        break;

                    case 4:
                        print(home.displayRooms());
                        int newRoom = getInt("Please select room for device from list (Integer only)");

                        home.changeRoom(plugIDChoice, newRoom);

                        break;
                }

                break;
            case 4:
                print("SYSTEM OPTIONS\n" +
                        "1 - Add smart plugs\n" +
                        "2 - Add attached device\n" +
                        "3 - Add room");

                int systemOption = getInt("Select an Option");

                switch(systemOption){
                    case 1:
                            print("Enter plug information below \n");
                            print(home.displayRooms());

                            int roomID = getInt("Select the room for this plug (Integer only):");

                            print("Available devices list options: \n");
                            print(home.displayAttachedDevices());

                            int deviceNum = getInt("please select the device to attach to the smart plug (Integer only)");

                            home.addNewPlug(roomID, deviceNum);

                        break;

                    case 2:
                        print("Enter Attached device information \n");
                        String newDeviceName = getString("Please enter device name: ");

                        home.addNewDevice(newDeviceName);

                        print(home.displayAttachedDevices());

                        break;

                    case 3:
                        print("Enter room information below \n");
                        String newRoomName = getString("Please provide a name for the new room: ");

                        home.addNewRoom(newRoomName);

                        break;
                }
                break;
            default:
                print("please enter a valid option");
        }
    }


            // TO PAUSE WHILE LOOP //
    public void pressEnter(){
        Scanner in = new Scanner(System.in);
        print("Press enter to continue");
        in.nextLine();
        pageBreak();
    }


            // CONSOLE HELPER FUNCTIONS //
    public String getString(String prompt){
        Scanner in = new Scanner(System.in);

        String s;

        print(prompt);

        try {
            s = in.next();
        } catch (Exception e){
            print("ERROR - Invalid input");
            return getString(prompt);
        }
        return s;
    }

    public int getInt(String prompt){
        Scanner in = new Scanner(System.in);

        int i;

        print(prompt);

        try {
            i = in.nextInt();
        } catch (Exception e){
            print("ERROR - Invalid input");
            return getInt(prompt);
        }
        return i;
    }

                // PRINTING //
    public void print(String message){ System.out.println(message);}
    public void pageBreak(){print("__________________________________________________________________");}
}
