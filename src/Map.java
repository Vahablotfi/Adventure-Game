import java.util.ArrayList;

public class Map {
    private Room room1;
    private Room room2;
    private Room room3;
    private Room room4;
    private Room room5;
    private Room room6;
    private Room room7;
    private Room room8;
    private Room room9;


    public Map(){
         room1 = new Room("Room 1", "The room is brightly lit with red and black stains covering the walls. Two doors");
         room2 = new Room("Room 2", "You're in a dark corridor with a very distinct floor pattern. Two doors");
         room3 = new Room("Room 3", "The room is dark with puddles on the floor. A pipe is leaking. Two doors");
         room4 = new Room("Room 4", "This is a very small room. There's a noise from the eastern wall. Two doors");
         room5 = new Room("Room 5", "'Treasure room'. One door");
         room6 = new Room("Room 6", "There's not much to see in here. Two doors");
         room7 = new Room("Room 7", "This room has a bed placed in the center. Two doors");
         room8 = new Room("Room 8", "This room is very big. Three doors");
         room9 = new Room("Room 9", "It's quite cold in here. The floor is slippery. Two doors");

        // connect rooms
        room1.setNorth(null);
        room1.setEast(room2);
        room1.setSouth(room4);
        room1.setWest(null);
        room1.addItem(new Item("lamp","bronze lamp"));

        room2.setNorth(null);
        room2.setEast(room3);
        room2.setWest(room1);
        room2.setSouth(null);

        room3.setNorth(null);
        room3.setEast(null);
        room3.setWest(room2);
        room3.setSouth(room6);

        room4.setNorth(room1);
        room4.setWest(null);
        room4.setEast(null);
        room4.setSouth(room7);

        room5.setNorth(null);
        room5.setEast(null);
        room5.setWest(null);
        room5.setSouth(room8);

        room6.setNorth(room3);
        room6.setEast(null);
        room6.setWest(null);
        room6.setSouth(room9);

        room7.setNorth(room4);
        room7.setEast(room8);
        room7.setWest(null);
        room7.setSouth(null);

        room8.setNorth(room5);
        room8.setWest(room7);
        room8.setEast(room9);
        room8.setSouth(null);

        room9.setNorth(room6);
        room9.setEast(null);
        room9.setWest(room8);
        room9.setSouth(null);

    }




    public Room getRoom1() {
        return room1;
    }

    public Room getRoom2() {
        return room2;
    }

    public Room getRoom3() {
        return room3;
    }

    public Room getRoom4() {
        return room4;
    }

    public Room getRoom5() {
        return room5;
    }

    public Room getRoom6() {
        return room6;
    }

    public Room getRoom7() {
        return room7;
    }

    public Room getRoom8() {
        return room8;
    }

    public Room getRoom9() {
        return room9;
    }

    public void setRoom1(Room room1) {
        this.room1 = room1;
    }

    public void setRoom2(Room room2) {
        this.room2 = room2;
    }

    public void setRoom3(Room room3) {
        this.room3 = room3;
    }

    public void setRoom4(Room room4) {
        this.room4 = room4;
    }

    public void setRoom5(Room room5) {
        this.room5 = room5;
    }

    public void setRoom6(Room room6) {
        this.room6 = room6;
    }

    public void setRoom7(Room room7) {
        this.room7 = room7;
    }

    public void setRoom8(Room room8) {
        this.room8 = room8;
    }

    public void setRoom9(Room room9) {
        this.room9 = room9;
    }

}

