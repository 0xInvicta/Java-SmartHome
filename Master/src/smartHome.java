public class smartHome {
    private smartPlugs[] smartPlugs;
    private rooms[] rooms;
    private attachedDevices[] deviceList;
    private int plugIndex;
    private int roomIndex;

                // CONSTRUCTOR //
    public smartHome(int plugSize, int roomSize) {
        this.smartPlugs = new smartPlugs[plugSize];
        this.rooms = new rooms[roomSize];
    }

    // Creates Device Object Array Needed Later For Adding Additional Devices
    public void createAttachedDevices() {
        this.deviceList = new attachedDevices[5];
        String[] originalDevices = {"Lamp", "TV", "Computer", "Charger", "Heater"};
        for(int i = 0; i < getDeviceSize(); i++){
            attachedDevices object = new attachedDevices(originalDevices[i], (i+1));
            deviceList[i] = object;
        }
    }
                 // GET FUNCTIONS //
    public int getDeviceSize(){
        return deviceList.length;
    }

    public int getSize() {
        return smartPlugs.length;
    }

    public int getRoomSize() {
        return rooms.length;
    }


                 // ADD FUNCTION //
    public void addPlug(int roomID, int attachedDevice, int ID, boolean status) {
        smartPlugs object = new smartPlugs(roomID, attachedDevice, ID, status);
        smartPlugs[plugIndex] = object;
        plugIndex++;
    }

    public void addRoom(String name, int ID) {
        rooms roomsObj = new rooms(name, ID);
        rooms[roomIndex] = roomsObj;
        roomIndex++;
    }

    public void addNewDevice(String name, int ID, int index){
        attachedDevices object = new attachedDevices(name, ID);
        deviceList[index] = object;
    }


                // DISPLAY FUNCTIONS //
    public String displayRooms() {
        String s = "";
        for (int j = 0; j < getRoomSize(); j++) {
            s += rooms[j].getID() + " - " + rooms[j].getName() + " | ";
        }
        return "ROOMS AVAILABLE: " + s + "\n";
    }

    public String displayAttachedDevices() {
        String s = "";
        for(int i = 0; i < getDeviceSize(); i++){
            s += (i + 1) + " - " + deviceList[i].getName() + "\n";
        }
        return s;
    }

    public String displayPlugData(int roomIdIndex) {
        String s = "";
        for (smartPlugs object : smartPlugs) {
            if (object.getRoomID() - 1 == roomIdIndex) {
                s +=  String.format("Smart Plug Attached to: %-10s", deviceList[object.getAttachedDevice()-1].getName() ) + object.displayPlugs(roomIdIndex) + rooms[roomIdIndex].getName() + "\n";
            }
        }
        return s;
    }

    public String displayAllPlugData() {
        String s = "";
        for (smartPlugs object : smartPlugs) {
            s += String.format("Smart Plug Attached to: %-10s", deviceList[object.getAttachedDevice()-1].getName()) + object.toString() + rooms[object.getRoomID()-1].getName() + "\n";
        }
        return s;
    }

                // SWITCHES FOR ROOMS AND PLUGS //
    public void switchOff() { //MASTER OFF
        for (smartPlugs object : smartPlugs) {
            object.switchOff();
        }
    }

    public void switchOn() { //MASTER ON
        for (smartPlugs object : smartPlugs) {
            object.switchOn();
        }
    }

    public void switchOffRoom(int roomChoice) {
        for (smartPlugs object : smartPlugs) {
            if (object.getRoomID() == roomChoice) {
                object.switchOff();
            }
        }
    }

    public void switchOnRoom(int roomChoice) {
        for (smartPlugs object : smartPlugs) {
            if (object.getRoomID() == roomChoice) {
                object.switchOn();
            }
        }
    }

    public void toggleSwitch(int roomChoice, int plugChoice) {
        for (smartPlugs object : smartPlugs) {
            if (object.getRoomID() == roomChoice && object.getID() == plugChoice) {
                object.toggle();
            }
        }
    }

    public void switchPlugOn(int plugID) {
        for (smartPlugs object : smartPlugs) {
            if (object.getID() == plugID) {
                object.switchOn();
            }
        }
    }

    public void switchPlugOff(int plugID) {
        for (smartPlugs object : smartPlugs) {
            if (object.getID() == plugID) {
                object.switchOff();
            }
        }
    }
                //MOVING DEVICES //
    public void changeDevice(int plugID, int deviceID) { //Change Attached Device
        for (smartPlugs object : smartPlugs) {
            if (object.getID() == plugID) {
                object.setAttachedDevice(deviceID);
            }
        }
    }

    public void changeRoom(int plugID, int newRoom) { //Move Plug To Different Room
        for (smartPlugs object : smartPlugs) {
            if (object.getID() == plugID) {
                object.setRoomID(newRoom);
            }
        }
    }

    //______________________________________________________________________________//
                                // SYSTEM LEVEL //
    public smartPlugs[] addNewPlug(int roomID, int deviceNum) {
        int n = getSize() + 1;

        smartPlugs[] newArray = new smartPlugs[n];

        for (int i = 0; i < getSize(); i++) {
            newArray[i] = smartPlugs[i];
        }
        this.smartPlugs = newArray;
        addPlug(roomID, deviceNum, getSize(), false);
        return this.smartPlugs = newArray;
    }

    public rooms[] addNewRoom(String roomName) {
        int n = rooms.length + 1;

        rooms[] newArray = new rooms[n];

        for (int i = 0; i < getRoomSize(); i++) {
            newArray[i] = rooms[i];
        }
        this.rooms = newArray;
        addRoom(roomName, rooms.length);
        return this.rooms = newArray;

    }

    public attachedDevices[] addNewDevice(String deviceName) {
        int n = getDeviceSize() + 1;

        attachedDevices[] newArray = new attachedDevices[n];

        for (int i = 0; i < getDeviceSize() ; i++) {
            newArray[i] = deviceList[i];
        }
        this.deviceList = newArray;
        addNewDevice(deviceName, (n-1), n-1);
        return this.deviceList = newArray;
        }
    }

