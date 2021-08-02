public class rooms {
    private String name;
    private int ID;


    public rooms(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                '}';
    }
}
