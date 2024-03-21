import java.util.ArrayList;

public class Enemy {
    private String name;
    private String description;
    private int enemyHealthPoints;
    private Weapon weapon;

    public Enemy(String name, String description, int enemyHealthPoint, Weapon weapon){
        this.name = name;
        this.description = description;
        this.enemyHealthPoints = enemyHealthPoint;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public int getEnemyHealthPoints() {
        return enemyHealthPoints;
    }

    public void setEnemyHealthPoints(int enemyHealthPoints) {
        this.enemyHealthPoints = enemyHealthPoints;
    }

    public Weapon getWeapon() {
        return weapon;
    }


}
