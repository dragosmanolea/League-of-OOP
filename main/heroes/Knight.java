package main.heroes;

public class Knight extends Player {
//    public final String name;
    private int bonusHpPerLevel = 80;
    private double initialHp = 900;
    public Knight(int x, int y) {
        this.hp = initialHp;
        this.x = x;
        this.y = y;
        this.name = "K";
        this.overtimeRounds = 0;
    }

    @Override
    public double isAttackedBy(Player player, char landType) {
        double firstDamage = player.attack(this, landType);
//        System.out.println(player.getLevel());
//        System.out.println(player.getName());
//        System.out.println("Tipul pamantului: " + landType);
//        System.out.println("____________");
        firstDamage = Math.round(firstDamage);
        return firstDamage;
    }

    @Override
    public double attack(Knight knight, char landType) {
        double damage;
        damage = Constants.execute + Constants.executeBonus * knight.getLevel();
        double hpLimit;
        double teoreticMaxHp = knight.getHp() + Constants.knightHp + Constants.knightHpPerLevel * knight.getLevel();
        double maxProcent = 0.01f * knight.getLevel();
        if (maxProcent > 0.4f) {
            maxProcent = 0.4f;
        }
        hpLimit = Constants.procentHp * teoreticMaxHp + maxProcent;
        if (knight.getHp() < hpLimit) {
            damage = knight.getHp();
            return damage;
        }
        damage *= Constants.executeKnight;
        double slam;
        knight.canMove = false;
        knight.overtimeDamage = 0;
        knight.overtimeRounds = 1;
        slam = Constants.slam + Constants.slamBonus * knight.getLevel();
        slam *= Constants.slamKnight;
        damage += slam;
        if (landType == 'L') {
            damage *= 1.15;
        }
        return damage;
    }

    @Override
    public double attack(Pyromancer pyromancer, char landType) {
        double damage;
        damage = Constants.execute + Constants.executeBonus * pyromancer.getLevel();
        double hpLimit;
        double teoreticMaxHp = pyromancer.getHp() + Constants.knightHp + Constants.knightHpPerLevel * pyromancer.getLevel();
        double maxProcent = 0.01f * pyromancer.getLevel();
        if (maxProcent > 0.4f) {
            maxProcent = 0.4f;
        }
        hpLimit = Constants.procentHp * teoreticMaxHp + maxProcent;
        if (pyromancer.getHp() < hpLimit) {
            damage = pyromancer.getHp();
            return damage;
        }
        damage *= Constants.executePyromancer;
        double slam;
        pyromancer.canMove = false;
        pyromancer.overtimeDamage = 0;
        pyromancer.overtimeRounds = 1;
        slam = Constants.slam + Constants.slamBonus * pyromancer.getLevel();
        slam *= Constants.slamPyromancer;
        damage += slam;
        if (landType == 'L') {
            damage *= 1.15;
        }
        return damage;
    }

    @Override
    public double attack(Rogue rogue, char landType) {
        double damage;
        damage = Constants.execute + Constants.executeBonus * rogue.getLevel();
        double hpLimit;
        double teoreticMaxHp = rogue.getHp() + Constants.knightHp + Constants.knightHpPerLevel * rogue.getLevel();
        double maxProcent = 0.01f * rogue.getLevel();
        if (maxProcent > 0.4f) {
            maxProcent = 0.4f;
        }
        hpLimit = Constants.procentHp * teoreticMaxHp + maxProcent;

        if (rogue.getHp() < hpLimit) {
            damage = rogue.getHp();
            return damage;
        }

        damage *= Constants.executeRogue;
        double slam;
        rogue.canMove = false;
        rogue.overtimeDamage = 0;
        rogue.overtimeRounds = 1;
        slam = Constants.slam + Constants.slamBonus * rogue.getLevel();
        slam *= Constants.slamRogue;
        damage += slam;
        damage = Math.round(damage);
        if (landType == 'L') {
            damage *= 1.15;
        }
        return damage;
    }

    @Override
    public double attack(Wizard wizard, char landType) {
        double damage;
        damage = Constants.execute + Constants.executeBonus * wizard.getLevel();
        double hpLimit;
        double teoreticMaxHp = wizard.getHp() + Constants.knightHp + Constants.knightHpPerLevel * wizard.getLevel();
        double maxProcent = 0.01f * wizard.getLevel();
        if (maxProcent > 0.4f) {
            maxProcent = 0.4f;
        }
        hpLimit = Constants.procentHp * teoreticMaxHp + maxProcent;
        if (wizard.getHp() < hpLimit) {
            damage = wizard.getHp();
            return damage;
        }
        damage *= Constants.executeWizard;
        double slam;
        wizard.canMove = false;
        wizard.overtimeDamage = 0;
        wizard.overtimeRounds = 1;
        slam = Constants.slam + Constants.slamBonus * wizard.getLevel();
        slam *= Constants.slamWizard;
        damage += slam;
        if (landType == 'L') {
            damage *= 1.15;
        }
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
