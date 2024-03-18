public abstract class Weapon extends Item{



    public Weapon(String shortName, String longName) {
        super(shortName, longName);
    }


    abstract int getRemainingUse();


    abstract void useWeapon();
}
