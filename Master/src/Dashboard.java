public class Dashboard {

    public static void main(String[] args) {


        consoleModule console = new consoleModule();
        console.print("Welcome . . . \n");
        int numRooms = console.getInt("How many rooms are there in this property?");
        int numPlugs = console.getInt("How many plugs do you want to place in this property?");
        smartHome home = new smartHome(numPlugs, numRooms);

        console.populate(home, numRooms, numPlugs);
        console.pageBreak();

        // MENU //
        while (true) {
            console.displayDashboard(home);
            console.menuOptions(home);
            console.pressEnter();
        }
    }
}
