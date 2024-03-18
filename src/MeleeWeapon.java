public class MeleeWeapon extends Weapon{


    public MeleeWeapon(String shortName, String longName) {
        super(shortName, longName);
    }

    @Override
    void useWeapon() {
     // don't need to do anything
    }
    @Override
    int getRemainingUse() {
        return -1;
    }

}
