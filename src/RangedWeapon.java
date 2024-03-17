public class RangedWeapon extends Weapon{
    private int remainingUses;
    public RangedWeapon(String shortName, String longName, int remainingUses) {
        super(shortName, longName);
        this.remainingUses = remainingUses;
    }

    public int getRemainingUses() {
        return remainingUses;
    }

}
