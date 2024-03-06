public class Player {

    private Room currentRoom;

    public Player(Room currentRoom){
        this.currentRoom = currentRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public String look(){
        String roomInfo = currentRoom.getName()+currentRoom.getDescription();
        return roomInfo;
    }

    public boolean moveAround(String direction ) {

        switch (direction) {
            case "go north":
            case "n":
            case "north":
                if (currentRoom.getNorth() != null) {
                    setCurrentRoom(currentRoom.getNorth());
                    return true;
                } else {
                    return false;
                }
            case "go south":
            case "s":
            case "south":
                if (currentRoom.getSouth() != null) {
                    setCurrentRoom(currentRoom.getSouth());
                    return true;
                } else {
                    return false;
                }
            case "go east":
            case "e":
            case "east":
                if (currentRoom.getEast() != null) {
                    setCurrentRoom(currentRoom.getEast());
                    return true;
                } else {
                    return false;
                }
            case "go west":
            case "w":
            case "west":
                if (currentRoom.getWest() != null) {
                    setCurrentRoom(currentRoom.getWest());
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }

    }
}
