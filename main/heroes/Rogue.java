package main.heroes;

public final class Rogue extends Player {
    private int backstab;
    public Rogue(final int x, final int y) {
        this.hp = Constants.ROGUE_HP;
        this.initialHp = this.hp;
        this.bonusHpPerLevel = Constants.ROGUE_HP_PER_LEVEL;
        this.x = x;
        this.y = y;
        this.name = "R";
        this.backstab = 0;
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
        // backstab
        float damage = Constants.BACKSTAB + Constants.BACKSTAB_BONUS * knight.getLevel();
        damage *= Constants.BACKSTAB_KNIGHT;
        if (landType == 'W') {
            damage *= Constants.ROGUE_LAND_BONUS;
        }
        if ((backstab % Constants.TREI) == 0 && landType == 'W') {
            damage *= Constants.ROGUE_CRITICAL;
        }
        damage = Math.round(damage);
        // paralysis
        float paralysisDamage;
        knight.canMove = false;

        paralysisDamage = Constants.PARALYSIS + Constants.PARALYSIS_BONUS * knight.getLevel();
        paralysisDamage *=  Constants.PARALYSIS_KNIGHT;
        paralysisDamage = Math.round(paralysisDamage);
        Math.round(knight.overtimeDamage);
        knight.overtimeRounds = Constants.TREI;
        if (landType == 'W') {
            knight.overtimeRounds = Constants.SASE;
            paralysisDamage *= Constants.ROGUE_LAND_BONUS;
        }
        knight.overtimeDamage = paralysisDamage;
        damage += paralysisDamage;
        damage = Math.round(damage);
        backstab++;
        damage = Math.round(damage);
        return damage;
    }

    @Override
    public float attack(final Pyromancer pyromancer, final char landType) {
        // backstab
        float damage = Constants.BACKSTAB + Constants.BACKSTAB_BONUS * pyromancer.getLevel();
        damage *= Constants.BACKSTAB_PYROMANCER;
        if (landType == 'W') {
            damage *= Constants.ROGUE_LAND_BONUS;
        }
        if ((backstab % Constants.TREI) == 0 && landType == 'W') {
            damage *= Constants.ROGUE_CRITICAL;
        }
        damage = Math.round(damage);
        // paralysis
        float paralysisDamage;
        pyromancer.canMove = false;

        paralysisDamage = Constants.PARALYSIS + Constants.PARALYSIS_BONUS * pyromancer.getLevel();
        paralysisDamage *=  Constants.PARALYSIS_PYROMANCER;
        paralysisDamage = Math.round(paralysisDamage);
        Math.round(pyromancer.overtimeDamage);
        pyromancer.overtimeRounds = Constants.TREI;
        if (landType == 'W') {
            pyromancer.overtimeRounds = Constants.SASE;
            paralysisDamage *= Constants.ROGUE_LAND_BONUS;
        }
        pyromancer.overtimeDamage = paralysisDamage;
        damage += paralysisDamage;
        damage = Math.round(damage);
        backstab++;
        damage = Math.round(damage);
        return damage;
    }

    @Override
    public float attack(final Rogue rogue, final char landType) {
        // backstab
        float damage = Constants.BACKSTAB + Constants.BACKSTAB_BONUS * rogue.getLevel();
        damage *= Constants.BACKSTAB_ROGUE;
        if (landType == 'W') {
            damage *= Constants.ROGUE_LAND_BONUS;
        }
        if ((backstab % Constants.TREI) == 0 && landType == 'W') {
            damage *= Constants.ROGUE_CRITICAL;
        }
        damage = Math.round(damage);
        // paralysis
        float paralysisDamage;
        rogue.canMove = false;

        paralysisDamage = Constants.PARALYSIS + Constants.PARALYSIS_BONUS * rogue.getLevel();
        paralysisDamage *=  Constants.PARALYSIS_ROGUE;
        paralysisDamage = Math.round(paralysisDamage);
        Math.round(rogue.overtimeDamage);
        rogue.overtimeRounds = Constants.TREI;
        if (landType == 'W') {
            rogue.overtimeRounds = Constants.SASE;
            paralysisDamage *= Constants.ROGUE_LAND_BONUS;
        }
        rogue.overtimeDamage = paralysisDamage;
        damage += paralysisDamage;
        damage = Math.round(damage);
        backstab++;
        damage = Math.round(damage);
        return damage;
    }

    @Override
    public float attack(final Wizard wizard, final char landType) {
        // backstab
        float damage = Constants.BACKSTAB + Constants.BACKSTAB_BONUS * wizard.getLevel();
        damage *= Constants.BACKSTAB_WIZARD;
        if (landType == 'W') {
            damage *= Constants.ROGUE_LAND_BONUS;
        }
        if ((backstab % Constants.TREI) == 0 && landType == 'W') {
            damage *= Constants.ROGUE_CRITICAL;
        }
        damage = Math.round(damage);
        // paralysis
        float paralysisDamage;
        wizard.canMove = false;

        paralysisDamage = Constants.PARALYSIS + Constants.PARALYSIS_BONUS * wizard.getLevel();
        paralysisDamage *=  Constants.PARALYSIS_WIZARD;
        paralysisDamage = Math.round(paralysisDamage);
        Math.round(wizard.overtimeDamage);
        wizard.overtimeRounds = Constants.TREI;
        if (landType == 'W') {
            wizard.overtimeRounds = Constants.SASE;
            paralysisDamage *= Constants.ROGUE_LAND_BONUS;
        }
        wizard.overtimeDamage = paralysisDamage;
        damage += paralysisDamage;
        damage = Math.round(damage);
        backstab++;
        damage = Math.round(damage);
        return damage;
    }


    @Override
    public String toString() {
        return name + " " + x + " " + y;
    }

    public void addXp(final Player loser) {
        this.xp = xp + Math.max(0, Constants.DOUA_SUTE
                - (this.level - loser.level) * Constants.PATRUZECI);
        if (this.xp > (Constants.DOUA_SUTE_CINCIZECI + level * Constants.CINCIZECI)) {
            level += (this.xp - 250) / 50 + 1;
            this.hp = this.initialHp + this.bonusHpPerLevel * this.level;
        }
    }
}
