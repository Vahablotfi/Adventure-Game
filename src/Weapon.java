public abstract class Weapon extends Item{

    protected int damagePoints;

    public Weapon(String shortName, String longName, int damagePoints) {
        super(shortName, longName);
        this.damagePoints = damagePoints;
    }


    abstract int getRemainingUse();

    abstract int getDamagePoints();

    abstract void useWeapon();
}
