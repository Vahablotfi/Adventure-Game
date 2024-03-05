public class Adventure {
    private Room currentRoom;

    public Adventure(){
        Room room1 = new Room("Room 1", "room with no distinct features, except two doors");
        Room room2 = new Room("Room 2", "Room with two doors");
        Room room3 = new Room("Room 3", "room with no distinct features, except two doors");
        Room room4 = new Room("Room 4", "room with no distinct features, except two doors");
        Room room5 = new Room("Room 5", "room with no distinct features, except one door");
        Room room6 = new Room("Room 6", "room with no distinct features, except two doors");
        Room room7 = new Room("Room 7", "room with no distinct features, except two doors");
        Room room8 = new Room("Room 8", "room with no distinct features, except three doors");
        Room room9 = new Room("Room 9", "room with no distinct features, except two doors");
        //connect rooms
        room1.setNorth(null);
        room1.setSouth(room4);
        room1.setEast(room2);
        room1.setWest(null);

        room2.setNorth(null);
        room2.setSouth(null);
        room2.setEast(room3);
        room2.setWest(room1);


        room3.setNorth(null);
        room3.setSouth(room6);
        room3.setEast(null);
        room3.setWest(room2);


        room4.setNorth(room1);
        room4.setSouth(room7);
        room4.setEast(null);
        room4.setWest(null);


        room5.setNorth(null);
        room5.setSouth(room8);
        room5.setEast(null);
        room5.setWest(null);


        room6.setNorth(room3);
        room6.setSouth(room9);
        room6.setEast(null);
        room6.setWest(null);


        room7.setNorth(room4);
        room7.setSouth(null);
        room7.setEast(room8);
        room7.setWest(null);


        room8.setNorth(room5);
        room8.setSouth(null);
        room8.setEast(room9);
        room8.setWest(room7);


        room9.setNorth(room6);
        room9.setSouth(null);
        room9.setEast(null);
        room9.setWest(room8);

        setCurrentRoom(room1);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
