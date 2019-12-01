package main.heroes;

public class Pyromancer extends Player {
//    public final String name;
    private int bonusDamagePerLevel = 50;
    private int currentRound;
    public Pyromancer(int x, int y) {
        this.hp = Constants.PYROMANCER_HP;
        this.x = x;
        this.y = y;
        this.name = "P";
        currentRound = 0;
        this.overtimeRounds = 0;
    }


    @Override
    public float isAttackedBy(Player player, char landType) {
        float damage = player.attack(this, landType);
        damage = Math.round(damage);
        return damage;
    }
    @Override
    public float attack(Knight knight, char landType) {
        float damage;
        damage = Constants.FIREBLAST + knight.getLevel() * Constants.FIREBLAST_BONUS;
        damage *= Constants.FIREBLAST_KNIGHT;
        float igniteDamage;
        igniteDamage = Constants.IGNITE + knight.getLevel() * Constants.IGNITE_BONUS;
        knight.overtimeRounds = 2;
        knight.overtimeDamage = Constants.IGNITE_OVERTIME + (Constants.IGNITE_OVERTIME_BONUS * knight.getLevel());
        knight.overtimeDamage *= Constants.IGNITE_KNIGHT;
        Math.round(knight.overtimeDamage);
        igniteDamage *= Constants.IGNITE_KNIGHT;
        damage += igniteDamage;
        if (landType == 'V') {
            damage *= 1.25f;
        }
//        System.out.println("Damage dat de pyromancer pe knight:" + damage);
        return damage;
    }

    @Override
    public float attack(Pyromancer pyromancer, char landType) {
        float damage;
        damage = Constants.FIREBLAST + pyromancer.getLevel() * Constants.FIREBLAST_BONUS;
        damage *= Constants.FIREBLAST_PYROMANCER;
        float igniteDamage;
        igniteDamage = Constants.IGNITE + pyromancer.getLevel() * Constants.IGNITE_BONUS;
        pyromancer.overtimeRounds = 2;
        pyromancer.overtimeDamage = Constants.IGNITE_OVERTIME + (Constants.IGNITE_OVERTIME_BONUS * pyromancer.getLevel());
        pyromancer.overtimeDamage *= Constants.IGNITE_PYROMANCER;
        Math.round(pyromancer.overtimeDamage);

        igniteDamage *= Constants.IGNITE_PYROMANCER;
        damage += igniteDamage;
        if (landType == 'V') {
            damage *= 1.25f;
        }
        return damage;
    }

    @Override
    public float attack(Rogue rogue, char landType) {
        float damage;
        damage = Constants.FIREBLAST + rogue.getLevel() * Constants.FIREBLAST_BONUS;
        damage *= Constants.FIREBLAST_ROGUE;
        float igniteDamage;
        igniteDamage = Constants.IGNITE + rogue.getLevel() * Constants.IGNITE_BONUS;
        rogue.overtimeRounds = 2;
        rogue.overtimeDamage = Constants.IGNITE_OVERTIME + (Constants.IGNITE_OVERTIME_BONUS * rogue.getLevel());
        rogue.overtimeDamage *= Constants.IGNITE_ROGUE;
        Math.round(rogue.overtimeDamage);

        igniteDamage *= Constants.IGNITE_ROGUE;
        damage += igniteDamage;
        if (landType == 'V') {
            damage *= 1.25f;
        }
        return damage;
    }

    @Override
    public float attack(Wizard wizard, char landType) {
        float damage;
        damage = Constants.FIREBLAST + wizard.getLevel() * Constants.FIREBLAST_BONUS;
        damage *= Constants.FIREBLAST_WIZARD;
        float igniteDamage;
        igniteDamage = Constants.IGNITE + wizard.getLevel() * Constants.IGNITE_BONUS;
        wizard.overtimeRounds = 2;
        wizard.overtimeDamage = Constants.IGNITE_OVERTIME + (Constants.IGNITE_OVERTIME_BONUS * wizard.getLevel());
        wizard.overtimeDamage *= Constants.IGNITE_WIZARD;
        Math.round(wizard.overtimeDamage);
        igniteDamage *= Constants.IGNITE_WIZARD;
        damage += igniteDamage;
        if (landType == 'V') {
            damage *= 1.25f;
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
            this.hp = Constants.PYROMANCER_HP + Constants.PYROMANCER_HP_PER_LEVEL * level;
        }
    }
}
