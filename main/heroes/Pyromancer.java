package main.heroes;

public final class Pyromancer extends Player {
    public Pyromancer(final int x, final int y) {
        this.hp = Constants.PYROMANCER_HP;
        this.x = x;
        this.y = y;
        this.name = "P";
        this.overtimeRounds = 0;
    }

    @Override
    public float isAttackedBy(final Player player, final char landType) {
        float damage = player.attack(this, landType);
        damage = Math.round(damage);
        return damage;
    }
    @Override
    public float attack(final Knight knight, final char landType) {
        float damage;
        damage = Constants.FIREBLAST + knight.getLevel() * Constants.FIREBLAST_BONUS;
        damage *= Constants.FIREBLAST_KNIGHT;
        float igniteDamage;
        igniteDamage =
                Constants.IGNITE + knight.getLevel() * Constants.IGNITE_BONUS;
        knight.overtimeRounds = Constants.ROGUE_OVERTIME_ROUNDS;
        knight.overtimeDamage =
                Constants.IGNITE_OVERTIME + (Constants.IGNITE_OVERTIME_BONUS * knight.getLevel());
        knight.overtimeDamage *= Constants.IGNITE_KNIGHT;
        Math.round(knight.overtimeDamage);
        igniteDamage *= Constants.IGNITE_KNIGHT;
        damage += igniteDamage;
        if (landType == 'V') {
            damage *= Constants.PYROMANCER_LAND_BONUS;
        }
        return damage;
    }

    @Override
    public float attack(final Pyromancer pyromancer, final char landType) {
        float damage;
        damage = Constants.FIREBLAST + pyromancer.getLevel() * Constants.FIREBLAST_BONUS;
        damage *= Constants.FIREBLAST_PYROMANCER;
        float igniteDamage;
        igniteDamage = Constants.IGNITE + pyromancer.getLevel() * Constants.IGNITE_BONUS;
        pyromancer.overtimeRounds = Constants.ROGUE_OVERTIME_ROUNDS;
        pyromancer.overtimeDamage =
                Constants.IGNITE_OVERTIME
                        + (Constants.IGNITE_OVERTIME_BONUS * pyromancer.getLevel());
        pyromancer.overtimeDamage *= Constants.IGNITE_PYROMANCER;
        Math.round(pyromancer.overtimeDamage);

        igniteDamage *= Constants.IGNITE_PYROMANCER;
        damage += igniteDamage;
        if (landType == 'V') {
            damage *= Constants.PYROMANCER_LAND_BONUS;
        }
        return damage;
    }

    @Override
    public float attack(final Rogue rogue, final char landType) {
        float damage;
        damage = Constants.FIREBLAST + rogue.getLevel() * Constants.FIREBLAST_BONUS;
        damage *= Constants.FIREBLAST_ROGUE;
        float igniteDamage;
        igniteDamage = Constants.IGNITE + rogue.getLevel() * Constants.IGNITE_BONUS;
        rogue.overtimeRounds = Constants.ROGUE_OVERTIME_ROUNDS;
        rogue.overtimeDamage =
                Constants.IGNITE_OVERTIME
                        + (Constants.IGNITE_OVERTIME_BONUS * rogue.getLevel());
        rogue.overtimeDamage *= Constants.IGNITE_ROGUE;
        Math.round(rogue.overtimeDamage);

        igniteDamage *= Constants.IGNITE_ROGUE;
        damage += igniteDamage;
        if (landType == 'V') {
            damage *= Constants.PYROMANCER_LAND_BONUS;
        }
        return damage;
    }

    @Override
    public float attack(final Wizard wizard, final char landType) {
        float damage;
        damage = Constants.FIREBLAST + wizard.getLevel() * Constants.FIREBLAST_BONUS;
        damage *= Constants.FIREBLAST_WIZARD;
        float igniteDamage;
        igniteDamage = Constants.IGNITE + wizard.getLevel() * Constants.IGNITE_BONUS;
        wizard.overtimeRounds = Constants.ROGUE_OVERTIME_ROUNDS;
        wizard.overtimeDamage = Constants.IGNITE_OVERTIME
                + (Constants.IGNITE_OVERTIME_BONUS * wizard.getLevel());
        wizard.overtimeDamage *= Constants.IGNITE_WIZARD;
        Math.round(wizard.overtimeDamage);
        igniteDamage *= Constants.IGNITE_WIZARD;
        damage += igniteDamage;
        if (landType == 'V') {
            damage *= Constants.PYROMANCER_LAND_BONUS;
        }
        return damage;
    }

    @Override
    public String toString() {
        return name + " " + x + " " + y;
    }

    public void addXp(final Player loser) {
        this.xp = xp + Math.max(0,
                Constants.DOUA_SUTE
                        - (this.level - loser.level) * Constants.PATRUZECI);
        if (this.xp > (Constants.DOUA_SUTE_CINCIZECI
                + level * Constants.CINCIZECI)) {
            level++;
            this.hp = Constants.PYROMANCER_HP
                    + Constants.PYROMANCER_HP_PER_LEVEL * level;
        }
    }
}
