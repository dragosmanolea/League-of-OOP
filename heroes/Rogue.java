package heroes;

public class Rogue extends Player {
//    public final String name;
    private int bonusHpPerLevel = 40;
    private int backstab;
    private double initialHp = 600;
    public Rogue(int x, int y) {
        this.hp = initialHp;
        this.x = x;
        this.y = y;
        this.name = "R";
        this.backstab = 0;
    }

    @Override
    public double isAttackedBy(Player player, char landType) {
        double damage = player.attack(this, landType);
        damage = Math.round(damage);
        return damage;
    }

    @Override
    public double attack(Knight knight, char landType) {
        double damage = 200 + 20 * knight.getLevel();
        // backstab
        backstab++;
        if (backstab % 3 == 0) {
            damage *= 1.5;
        }
        damage /= 0.1f;
        // paralysis
        double paralysisDamage;
        knight.canMove = false;
        knight.overtimeDamage = 40 + 10 * knight.getLevel();
        knight.overtimeDamage -= 0.20f * knight.overtimeDamage;
        knight.overtimeRounds = 3;
        if (landType == 'W') {
            knight.overtimeRounds = 6;
        }
        if (landType == 'W') {
            damage *= 1.15f;
        }
        paralysisDamage = 40 + 10 * knight.getLevel();
        paralysisDamage *= 1.25f;
        damage += paralysisDamage;
        return damage;
    }

    @Override
    public double attack(Pyromancer pyromancer, char landType) {
        double damage = 200 + 20 * pyromancer.getLevel();
        // backstab
        backstab++;
        if (backstab % 3 == 0) {
            damage *= 1.5;
        }
        damage += damage * 0.25f;
        // paralysis
        double paralysisDamage;
        pyromancer.canMove = false;
        pyromancer.overtimeDamage = 40 + 10 * pyromancer.getLevel();
        pyromancer.overtimeDamage *= 1.20;
        pyromancer.overtimeRounds = 3;
        if (landType == 'W') {
            pyromancer.overtimeRounds = 6;
        }
        if (landType == 'W') {
            damage *= 1.15f;
        }
        paralysisDamage = 40 + 10 * pyromancer.getLevel();
        paralysisDamage *= 1.25f;
        damage += paralysisDamage;
        return damage;
    }

    @Override
    public double attack(Rogue rogue, char landType) {
        double damage = 200 + 20 * rogue.getLevel();
        // backstab
        backstab++;
        if (backstab % 3 == 0) {
            damage *= 1.5;
        }
        damage += damage * 0.20f;
        // paralysis
        double paralysisDamage;
        rogue.canMove = false;
        rogue.overtimeDamage = 40 + 10 * rogue.getLevel();
        rogue.overtimeDamage *= 1.20;
        rogue.overtimeRounds = 3;
        if (landType == 'W') {
            rogue.overtimeRounds = 6;
        }
        if (landType == 'W') {
            damage *= 1.15f;
        }
        paralysisDamage = 40 + 10 * rogue.getLevel();
        paralysisDamage -= 0.10f * paralysisDamage;
        damage += paralysisDamage;
        return damage;
    }

    @Override
    public double attack(Wizard wizard, char landType) {
        double damage = 200 + 20 * wizard.getLevel();
        // backstab
        backstab++;
        if (backstab % 3 == 0) {
            damage *= 1.5;
        }
        damage += damage * 0.25f;
        // paralysis
        double paralysisDamage;
        wizard.canMove = false;
        wizard.overtimeDamage = 40 + 10 * wizard.getLevel();
        wizard.overtimeDamage *= 1.25;
        wizard.overtimeRounds = 3;
        if (landType == 'W') {
            wizard.overtimeRounds = 6;
        }
        if (landType == 'W') {
            damage *= 1.15f;
        }
        paralysisDamage = 40 + 10 * wizard.getLevel();
        paralysisDamage *= 1.25f;
        damage += paralysisDamage;
        return damage;
    }


    @Override
    public String toString() {
        return name + " " + x + " " + y;
    }

    public void addXp(Player loser) {
//        System.out.println("adaug xp");
        this.xp = xp + Math.max(0, 200 - (this.level - loser.level) * 40);
        if (this.xp > (250 + level * 50)) {
            level++;
            this.hp = initialHp + bonusHpPerLevel * level;
        }
    }
}
