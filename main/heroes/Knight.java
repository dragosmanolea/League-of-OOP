package main.heroes;

public class Knight extends Player {
//    public final String name;
    private int bonusHpPerLevel = 80;
    private float initialHp = 900;
    public Knight(int x, int y) {
        this.hp = Constants.KNIGHT_HP;
        this.x = x;
        this.y = y;
        this.name = "K";
        this.overtimeRounds = 0;
    }

    @Override
    public float isAttackedBy(Player player, char landType) {
        float firstDamage = player.attack(this, landType);
        firstDamage = Math.round(firstDamage);
        return firstDamage;
    }

    @Override
    public float attack(Knight knight, char landType) {
        float damage;
        damage = Constants.EXECUTE + Constants.EXECUTE_BONUS * knight.getLevel();
        float hpLimit;
        float teoreticMaxHp = knight.getHp() + Constants.KNIGHT_HP + Constants.KNIGHT_HP_PER_LEVEL * knight.getLevel();
        float maxProcent = 0.01f * knight.getLevel();
        if (maxProcent > 0.4f) {
            maxProcent = 0.4f;
        }
        hpLimit = Constants.PROCENT_HP * teoreticMaxHp + maxProcent;
        if (knight.getHp() < hpLimit) {
            damage = knight.getHp();
            return damage;
        }
        damage *= Constants.EXECUTE_KNIGHT;
        float slam;
        knight.canMove = false;
        knight.overtimeDamage = 0;
        knight.overtimeRounds = 1;
        slam = Constants.SLAM + Constants.SLAM_BONUS * knight.getLevel();
        slam *= Constants.SLAM_KNIGHT;
        damage += slam;
        if (landType == 'L') {
            damage *= 1.15;
        }
        return damage;
    }

    @Override
    public float attack(Pyromancer pyromancer, char landType) {
        float damage;
        damage = Constants.EXECUTE + Constants.EXECUTE_BONUS * pyromancer.getLevel();
        float hpLimit;
        float teoreticMaxHp = pyromancer.getHp() + Constants.KNIGHT_HP + Constants.KNIGHT_HP_PER_LEVEL * pyromancer.getLevel();
        float maxProcent = 0.01f * pyromancer.getLevel();
        if (maxProcent > 0.4f) {
            maxProcent = 0.4f;
        }
        hpLimit = Constants.PROCENT_HP * teoreticMaxHp + maxProcent;
        if (pyromancer.getHp() < hpLimit) {
            damage = pyromancer.getHp();
            return damage;
        }
        damage *= Constants.EXECUTE_PYROMANCER;
        float slam;
        pyromancer.canMove = false;
        pyromancer.overtimeDamage = 0;
        pyromancer.overtimeRounds = 1;
        slam = Constants.SLAM + Constants.SLAM_BONUS * pyromancer.getLevel();
        slam *= Constants.SLAM_PYROMANCER;
        damage += slam;
        if (landType == 'L') {
            damage *= 1.15;
        }
        return damage;
    }

    @Override
    public float attack(Rogue rogue, char landType) {
        float damage;
        damage = Constants.EXECUTE + Constants.EXECUTE_BONUS * rogue.getLevel();
        float hpLimit;
        float teoreticMaxHp = rogue.getHp() + Constants.KNIGHT_HP + Constants.KNIGHT_HP_PER_LEVEL * rogue.getLevel();
        float maxProcent = 0.01f * rogue.getLevel();
        if (maxProcent > 0.4f) {
            maxProcent = 0.4f;
        }
        hpLimit = Constants.PROCENT_HP * teoreticMaxHp + maxProcent;

        if (rogue.getHp() < hpLimit) {
            damage = rogue.getHp();
            return damage;
        }

        damage *= Constants.EXECUTE_ROGUE;
        float slam;
        rogue.canMove = false;
        rogue.overtimeDamage = 0;
        rogue.overtimeRounds = 1;
        slam = Constants.SLAM + Constants.SLAM_BONUS * rogue.getLevel();
        slam *= Constants.SLAM_ROGUE;
        damage += slam;
        damage = Math.round(damage);
        if (landType == 'L') {
            damage *= 1.15;
        }
        return damage;
    }

    @Override
    public float attack(Wizard wizard, char landType) {
        float damage;
        damage = Constants.EXECUTE + Constants.EXECUTE_BONUS * wizard.getLevel();
        float hpLimit;
        float teoreticMaxHp = wizard.getHp() + Constants.KNIGHT_HP + Constants.KNIGHT_HP_PER_LEVEL * wizard.getLevel();
        float maxProcent = 0.01f * wizard.getLevel();
        if (maxProcent > 0.4f) {
            maxProcent = 0.4f;
        }
        hpLimit = Constants.PROCENT_HP * teoreticMaxHp + maxProcent;
        if (wizard.getHp() < hpLimit) {
            damage = wizard.getHp();
            return damage;
        }
        damage *= Constants.EXECUTE_WIZARD;
        float slam;
        wizard.canMove = false;
        wizard.overtimeDamage = 0;
        wizard.overtimeRounds = 1;
        slam = Constants.SLAM + Constants.SLAM_BONUS * wizard.getLevel();
        slam *= Constants.SLAM_WIZARD;
//        System.out.println("Damage knight-wizard:" + damage * 1.15f + ":" + slam * 1.15f);
        damage += slam;
        if (landType == 'L') {
            damage *= 1.15f;
        }
//        System.out.println("Damage knight-wizard:" + damage);
        return damage;
    }

    @Override
    public String toString() {
        return name + " " + x + " " + y;
    }


    public void addXp(Player loser) {
        this.xp = xp + Math.max(0, 200 - (this.level - loser.level) * 40);
        if (this.xp > (250 + level * 50)) {
            level++;
            this.hp = 900 + 80 * level;
        }
    }
}
