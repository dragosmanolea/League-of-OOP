package main.heroes;

public final class Knight extends Player {
    public Knight(final int x, final int y) {
        this.hp = Constants.KNIGHT_HP;
        this.initialHp = this.hp;
        this.bonusHpPerLevel = Constants.KNIGHT_HP_PER_LEVEL;
        this.x = x;
        this.y = y;
        this.name = "K";
        this.overtimeRounds = 0;
    }

    @Override
    public float isAttackedBy(final Player player, final char landType) {
        float firstDamage = player.attack(this, landType);
        firstDamage = Math.round(firstDamage);
        return firstDamage;
    }

    @Override
    public float attack(final Knight knight, final char landType) {
        float damage;
        damage = Constants.EXECUTE + Constants.EXECUTE_BONUS * knight.getLevel();
        float hpLimit;
        float teoreticMaxHp = knight.getHp()
                + Constants.KNIGHT_HP + Constants.KNIGHT_HP_PER_LEVEL * knight.getLevel();
        float maxProcent = Constants.PROCENTAGE * knight.getLevel();
        if (maxProcent > Constants.MAX_PROCENTAGE) {
            maxProcent = Constants.MAX_PROCENTAGE;
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
        knight.overtimeRounds = Constants.OVERTIME_ROUNDS_KNIGHT;
        slam = Constants.SLAM + Constants.SLAM_BONUS * knight.getLevel();
        slam *= Constants.SLAM_KNIGHT;
        damage += slam;
        if (landType == 'L') {
            damage *= Constants.KNIGHT_LAND_BONUS;
        }
        return damage;
    }

    @Override
    public float attack(final Pyromancer pyromancer, final char landType) {
        float damage;
        damage = Constants.EXECUTE
                + Constants.EXECUTE_BONUS * pyromancer.getLevel();
        float hpLimit;
        float teoreticMaxHp = pyromancer.getHp()
                + Constants.KNIGHT_HP
                + Constants.KNIGHT_HP_PER_LEVEL * pyromancer.getLevel();
        float maxProcent = Constants.PROCENTAGE * pyromancer.getLevel();
        if (maxProcent > Constants.MAX_PROCENTAGE) {
            maxProcent = Constants.MAX_PROCENTAGE;
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
        pyromancer.overtimeRounds = Constants.OVERTIME_ROUNDS_KNIGHT;
        slam = Constants.SLAM + Constants.SLAM_BONUS * pyromancer.getLevel();
        slam *= Constants.SLAM_PYROMANCER;
        damage += slam;
        if (landType == 'L') {
            damage *= Constants.KNIGHT_LAND_BONUS;
        }
        return damage;
    }

    @Override
    public float attack(final Rogue rogue, final char landType) {
        float damage;
        damage = Constants.EXECUTE + Constants.EXECUTE_BONUS * rogue.getLevel();
        float hpLimit;
        float teoreticMaxHp = rogue.getHp()
                + Constants.KNIGHT_HP + Constants.KNIGHT_HP_PER_LEVEL * rogue.getLevel();
        float maxProcent = Constants.PROCENTAGE * rogue.getLevel();
        if (maxProcent > Constants.MAX_PROCENTAGE) {
            maxProcent = Constants.MAX_PROCENTAGE;
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
        rogue.overtimeRounds = Constants.OVERTIME_ROUNDS_KNIGHT;
        slam = Constants.SLAM + Constants.SLAM_BONUS * rogue.getLevel();
        slam *= Constants.SLAM_ROGUE;
        damage += slam;
        damage = Math.round(damage);
        if (landType == 'L') {
            damage *= Constants.KNIGHT_LAND_BONUS;
        }
        return damage;
    }

    @Override
    public float attack(final Wizard wizard, final char landType) {
        float damage;
        damage = Constants.EXECUTE + Constants.EXECUTE_BONUS * wizard.getLevel();
        float hpLimit;
        float teoreticMaxHp = wizard.getHp()
                + Constants.KNIGHT_HP + Constants.KNIGHT_HP_PER_LEVEL * wizard.getLevel();
        float maxProcent = Constants.PROCENTAGE * wizard.getLevel();
        if (maxProcent > Constants.MAX_PROCENTAGE) {
            maxProcent = Constants.MAX_PROCENTAGE;
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
        wizard.overtimeRounds = Constants.OVERTIME_ROUNDS_KNIGHT;
        slam = Constants.SLAM + Constants.SLAM_BONUS * wizard.getLevel();
        slam *= Constants.SLAM_WIZARD;
        damage += slam;
        if (landType == 'L') {
            damage *= Constants.KNIGHT_LAND_BONUS;
        }
        return damage;
    }

    @Override
    public String toString() {
        return name + " " + x + " " + y;
    }


    public void addXp(final Player loser) {
        if (this.getHp() <= 0) {
            return;
        }
        this.xp = xp + Math.max(0, Constants.DOUA_SUTE
                - (this.level - loser.level)
                * Constants.PATRUZECI);
        if (this.xp > (Constants.DOUA_SUTE_CINCIZECI
                + level * Constants.CINCIZECI)) {
            level += (this.xp - Constants.DOUA_SUTE_CINCIZECI)
                    / Constants.CINCIZECI + Constants.UNU;
            this.hp = this.initialHp + this.bonusHpPerLevel * this.level;
        }
    }
}
