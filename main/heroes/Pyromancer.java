package main.heroes;

public class Pyromancer extends Player {
//    public final String name;
    private double initialHp = 500;
    private int bonusHpPerLevel = 50;
    private int bonusDamagePerLevel = 50;
    private int currentRound;
    public Pyromancer(int x, int y) {
        this.hp = initialHp;
        this.x = x;
        this.y = y;
        this.name = "P";
        currentRound = 0;
    }


    @Override
    public double isAttackedBy(Player player, char landType) {
        double damage = player.attack(this, landType);
        damage = Math.round(damage);
        return damage;
    }
    @Override
    public double attack(Knight knight, char landType) {
        double damage;
        damage = Constants.fireblast + knight.getLevel() * Constants.fireblastBonus;
        damage *= Constants.fireblastKnight;
        double igniteDamage;
        igniteDamage = Constants.ignite + knight.getLevel() * Constants.igniteBonus;
        knight.overtimeRounds = 2;
        knight.overtimeDamage = Constants.igniteOvertime + (Constants.igniteOvertimeBonus * knight.getLevel());
        knight.overtimeDamage *= Constants.igniteKnight;
        igniteDamage *= Constants.igniteKnight;
        damage += igniteDamage;
//        if (landType == 'V') {
//            damage *= 1.25f;
//        }
        return damage;
    }

    @Override
    public double attack(Pyromancer pyromancer, char landType) {
        double damage;
        damage = Constants.fireblast + pyromancer.getLevel() * Constants.fireblastBonus;
        damage *= Constants.fireblastPyromancer;
        double igniteDamage;
        igniteDamage = Constants.ignite + pyromancer.getLevel() * Constants.igniteBonus;
        pyromancer.overtimeRounds = 2;
        pyromancer.overtimeDamage = Constants.igniteOvertime + (Constants.igniteOvertimeBonus * pyromancer.getLevel());
        pyromancer.overtimeDamage *= Constants.ignitePyromancer;
        igniteDamage *= Constants.ignitePyromancer;
        damage += igniteDamage;
//        if (landType == 'V') {
//            damage *= 1.25f;
//        }
        return damage;
    }

    @Override
    public double attack(Rogue rogue, char landType) {
        double damage;
        damage = Constants.fireblast + rogue.getLevel() * Constants.fireblastBonus;
        damage *= Constants.fireblastRogue;
        double igniteDamage;
        igniteDamage = Constants.ignite + rogue.getLevel() * Constants.igniteBonus;
        rogue.overtimeRounds = 2;
        rogue.overtimeDamage = Constants.igniteOvertime + (Constants.igniteOvertimeBonus * rogue.getLevel());
        rogue.overtimeDamage *= Constants.igniteRogue;
        igniteDamage *= Constants.igniteRogue;
        damage += igniteDamage;
//        if (landType == 'V') {
//            damage *= 1.25f;
//        }
        return damage;
    }

    @Override
    public double attack(Wizard wizard, char landType) {
        double damage;
        damage = Constants.fireblast + wizard.getLevel() * Constants.fireblastBonus;
        damage *= Constants.fireblastWizard;
        double igniteDamage;
        igniteDamage = Constants.ignite + wizard.getLevel() * Constants.igniteBonus;
        wizard.overtimeRounds = 2;
        wizard.overtimeDamage = Constants.igniteOvertime + (Constants.igniteOvertimeBonus * wizard.getLevel());
        wizard.overtimeDamage *= Constants.igniteWizard;
        igniteDamage *= Constants.igniteWizard;
        damage += igniteDamage;
//        if (landType == 'V') {
//            damage *= 1.25f;
//        }
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
            this.hp = initialHp + bonusHpPerLevel * level;
        }
    }
}
