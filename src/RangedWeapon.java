public class RangedWeapon extends Weapon{

    private int ammunition;

    public RangedWeapon(String shortName, String longName, int ammunition, int damagePoints) {
        super(shortName, longName, damagePoints);
        this.ammunition = ammunition;
    }

    @Override
    int getRemainingUse() {
        return ammunition;
    }

    @Override
    int getDamagePoints() {
        return damagePoints;
    }

    @Override
    void useWeapon() {
        ammunition--;

    }
}
