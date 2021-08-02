public class smartPlugs {
    private int roomID;
    private int attachedDevice;
    private int ID;
    private boolean status;


                // CONSTRUCTOR //
    public smartPlugs(int roomID, int attachedDevice, int ID, boolean status) {
        this.roomID = roomID;
        this.attachedDevice = attachedDevice;
        this.ID = ID;
        this.status = status;
    }

                // GET FUNCTIONS //
    public int getRoomID() {
        return roomID;
    }

    public int getAttachedDevice() {
        return attachedDevice;
    }

    public int getID() {
        return ID;
    }


                // SET FUNCTIONS //
    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public void setAttachedDevice(int attachedDevice) {
        this.attachedDevice = attachedDevice;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


                // STATUS SWITCHES //
    public void switchOff(){
        setStatus(false);
    }

    public void switchOn(){
        setStatus(true);
    }

    public void toggle(){
        setStatus(!getStatus());
    }


                // DISPLAY PLUGS //
    public String displayPlugs(int idIndex) {
        String s = "";
        s += " |ID:" + ID + " |status: " + convertStatus(status) + '|' + "room: ";

        return s;
    }
    private String convertStatus(boolean status){
        if(status){ return "on";}

        return "off";
    }

    @Override
    public String toString() {
        return " |ID:" + ID + " |status: " + convertStatus(status) + '|' + "room: ";
    }


}
