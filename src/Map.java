
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


    public Map() {
        room1 = new Room("Room 1", "The room is brightly lit with red and black stains covering the walls. Two doors");
        room2 = new Room("Room 2", "You're in a dark corridor with a very distinct floor pattern. Two doors");
        room3 = new Room("Room 3", "The room is dark with puddles on the floor. A pipe is leaking. Two doors");
        room4 = new Room("Room 4", "This is a very small room. There's a noise from the eastern wall. Two doors");
        room5 = new Room("Room 5", "'Treasure room'. One door");
        room6 = new Room("Room 6", "There's not much to see in here. Two doors");
        room7 = new Room("Room 7", "This room has a bed placed in the center. Two doors");
        room8 = new Room("Room 8", "This room is very big. Three doors");
        room9 = new Room("Room 9", "It's quite cold in here. The floor is slippery. Two doors");

        // Connect Rooms:
        room1.setNorth(null);
        room1.setEast(room2);
        room1.setSouth(room4);
        room1.setWest(null);

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

        // Add items to rooms
        room1.addItem(new Item("Book", "A dusty old book with strange symbols."));
        room1.addItem(new Item("Snake", "A glistnening green cobra, with teeth like daggers"));
        room1.addItem(new Item("Shield", "A wide gold shield with special capabilites"));
        room1.addFood(new Food("Apple", "A pink apple with a strange glow to it", 10));
        room1.addItem(new RangedWeapon("Bow", "Sharp and poisened bow", 10, 10));
        room1.addItem(new MeleeWeapon("Butter Knife", "Dull butter knife", 10));


        room2.addItem(new Item("Candle", "A partially burned candle emitting a faint light."));
        room2.addItem(new Item("Scroll", "An old scroll with magical inscriptions."));
        room2.addItem(new Item("Lantern", "A small lantern that lights up dark places."));
        room2.addFood(new Food("Sweetroll", "A pastry with icing on the top", 15));
        room2.addItem(new MeleeWeapon("Sword", "Gold useless sword", 10));

        room3.addItem(new Item("Key", "A rusty key that may unlock something."));
        room3.addItem(new Item("Sword", "A rusty old sword."));
        room3.addFood(new Food("Skooma", "A potion in a purple bottle with a pipe on top", -10));
        room3.addItem(new RangedWeapon("Crossbow", "A powerful crossbow", 10, 5));

        room4.addItem(new Item("Potion", "A mysterious potion with a swirling liquid."));
        room4.addItem(new Item("Shield", "A wooden shield."));
        room4.addFood(new Food("Milk", "A fresh jug of milk", 5));
        room4.addItem(new MeleeWeapon("Dagger", "A small, sharp dagger.", 10));
        room4.addEnemy(new Enemy("Falmer", "A small blind elf", 20,new MeleeWeapon("Dagger", "silver dagger",5)));

        room5.addItem(new Item("Treasure Chest", "A locked chest promising untold riches."));
        room5.addItem(new Item("Ring", "A golden ring with a sparkling gemstone."));
        room5.addFood(new Food("Wine", "An old looking wine bottle with spiced wine", -5));
        room5.addItem(new RangedWeapon("Magic Staff", "A staff imbued with powerful magic", 10, 3));

        room6.addItem(new Item("Map", "A tattered map with cryptic markings."));
        room6.addItem(new Item("Coin", "A shiny silver coin."));
        room6.addFood(new Food("Stew", "A bowl of venison stew. Smells great", 20));
        room6.addItem(new RangedWeapon("Magic Bow", "A bow that shoots magical arrows", 10, 8));

        room7.addItem(new Item("Bedroll", "A makeshift bedroll for a weary traveler."));
        room7.addItem(new Item("Chest", "A wooden chest with a lock."));
        room7.addItem(new Item("Pouch", "A small pouch for carrying items."));


        room8.addItem(new Item("Crystal Ball", "A crystal ball with an eerie glow."));
        room8.addItem(new Item("Magic Wand", "A wand of arcane power."));
        room8.addItem(new MeleeWeapon("Axe", "A heavy axe for chopping wood or enemies.", 10));

        room9.addItem(new Item("Ice Shard", "A sharp, frigid shard of ice."));
        room9.addItem(new Item("Fire Shard", "A sharp, flaming shard of fire."));
        room9.addItem(new MeleeWeapon("Spear", "A long, sharp spear.", 10));

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

