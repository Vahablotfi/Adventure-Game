public class Adventure {
    private Map gameMap;
    private Player gamePlayer;

    public Adventure(){
        Room room1 = new Room("Room 1", "The room is brightly lit with red and black stains covering the walls. Two doors");
        Room room2 = new Room("Room 2", "You're in a dark corridor with a very distinct floor pattern. Two doors.");
        Room room3 = new Room("Room 3", "The room is dark with puddles on the floor. A pipe is leaking. Two doors");
        Room room4 = new Room("Room 4", "This is a very small room. There's a noise from the eastern wall. Two doors");
        Room room5 = new Room("Room 5", "'Treasure room'. One door");
        Room room6 = new Room("Room 6", "There's not much to see in here. Two doors");
        Room room7 = new Room("Room 7", "This room has a bed placed in the center. Two doors");
        Room room8 = new Room("Room 8", "This room is very big. Three doors");
        Room room9 = new Room("Room 9", "It's quite cold in here. The floor is slippery. Two doors");
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

         gameMap = new Map();
         gamePlayer = new Player(gameMap.getRoom1());
    }

    public Map getGameMap() {
        return gameMap;
    }

    public Player getGamePlayer() {
        return gamePlayer;
    }

    public void setGameMap(Map gameMap) {
        this.gameMap = gameMap;
    }

    public void setGamePlayer(Player gamePlayer) {
        this.gamePlayer = gamePlayer;
    }
}
