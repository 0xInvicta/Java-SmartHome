public class attachedDevices {
    private String name;
    private int ID;


    public attachedDevices(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "AttachedDevices{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                '}';
    }
}
