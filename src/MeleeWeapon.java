public class MeleeWeapon extends Weapon{

    public MeleeWeapon(String shortName, String longName, int damagePoints) {
        super(shortName, longName, damagePoints);
    }

    @Override
    void useWeapon() {
     // don't need to do anything
    }
    @Override
    int getRemainingUse() {
        return -1;
    }

    int getDamagePoints() {
        return damagePoints;
    }

}
