public class RangedWeapon extends Weapon{

    private int ammunition;

    public RangedWeapon(String shortName, String longName, int ammunition) {
        super(shortName, longName);
        this.ammunition = ammunition;
    }


    @Override
    int getRemainingUse() {
        return ammunition;
    }

    @Override
    void useWeapon() {
        ammunition--;

    }
}
