package main.heroes;

public class Rogue extends Player {
//    public final String name;
    private int backstab;
    public Rogue(int x, int y) {
        this.hp = Constants.ROGUE_HP;
        this.x = x;
        this.y = y;
        this.name = "R";
        this.backstab = 0;
        this.overtimeRounds = 0;
    }

    public int getBackstab() {
        return backstab;
    }

    @Override
    public float isAttackedBy(Player player, char landType) {
        float damage = player.attack(this, landType);
        damage = Math.round(damage);
        return damage;
    }

    @Override
    public float attack(Knight knight, char landType) {
        // backstab
        float damage = Constants.BACKSTAB + Constants.BACKSTAB_BONUS * knight.getLevel();
        // paralysis
        damage *= 0.9f;
        if (landType == 'W') {
            damage *= 1.15f;
        }
        if ((backstab % 3) == 0 && landType == 'W') {
            damage *= 1.5f;
        }
        damage = Math.round(damage);
        float paralysisDamage;
        knight.canMove = false;

        paralysisDamage = Constants.PARALYSIS + Constants.PARALYSIS_BONUS * knight.getLevel();
        paralysisDamage *=  0.8f;
        paralysisDamage = Math.round(paralysisDamage);
        Math.round(knight.overtimeDamage);
        knight.overtimeRounds = 3;
        if (landType == 'W') {
            knight.overtimeRounds = 6;
            paralysisDamage *= 1.15f;
        }
        knight.overtimeDamage = paralysisDamage;
        damage += paralysisDamage;
        damage = Math.round(damage);
        backstab++;
        damage = Math.round(damage);
        return damage;
    }

    @Override
    public float attack(Pyromancer pyromancer, char landType) {
        // backstab
        float damage = Constants.BACKSTAB + Constants.BACKSTAB_BONUS * pyromancer.getLevel();
        // paralysis
        damage *= 1.25f;
        if (landType == 'W') {
            damage *= 1.15f;
        }
        if ((backstab % 3) == 0 && landType == 'W') {
            damage *= 1.5f;
        }
        damage = Math.round(damage);
        float paralysisDamage;
        pyromancer.canMove = false;

        paralysisDamage = Constants.PARALYSIS + Constants.PARALYSIS_BONUS * pyromancer.getLevel();
        paralysisDamage *=  1.2f;
        paralysisDamage = Math.round(paralysisDamage);
        Math.round(pyromancer.overtimeDamage);
        pyromancer.overtimeRounds = 3;
        if (landType == 'W') {
            pyromancer.overtimeRounds = 6;
            paralysisDamage *= 1.15f;
        }
        pyromancer.overtimeDamage = paralysisDamage;
        damage += paralysisDamage;
        damage = Math.round(damage);
        backstab++;
        damage = Math.round(damage);
        return damage;
    }

    @Override
    public float attack(Rogue rogue, char landType) {
        // backstab
        float damage = Constants.BACKSTAB + Constants.BACKSTAB_BONUS * rogue.getLevel();
        // paralysis
        damage *= 1.2f;
        if (landType == 'W') {
            damage *= 1.15f;
        }
        if ((backstab % 3) == 0 && landType == 'W') {
            damage *= 1.5f;
        }
        damage = Math.round(damage);
        float paralysisDamage;
        rogue.canMove = false;

        paralysisDamage = Constants.PARALYSIS + Constants.PARALYSIS_BONUS * rogue.getLevel();
        paralysisDamage *=  0.9f;
        paralysisDamage = Math.round(paralysisDamage);
        Math.round(rogue.overtimeDamage);
        rogue.overtimeRounds = 3;
        if (landType == 'W') {
            rogue.overtimeRounds = 6;
            paralysisDamage *= 1.15f;
        }
        rogue.overtimeDamage = paralysisDamage;
        damage += paralysisDamage;
        damage = Math.round(damage);
        backstab++;
        damage = Math.round(damage);
        return damage;
    }

    @Override
    public float attack(Wizard wizard, char landType) {
        // backstab
        float damage = Constants.BACKSTAB + Constants.BACKSTAB_BONUS * wizard.getLevel();
        // paralysis
        damage *= 1.25f;
        if (landType == 'W') {
            damage *= 1.15f;
        }
        if ((backstab % 3) == 0 && landType == 'W') {
            damage *= 1.5f;
        }
        damage = Math.round(damage);
        float paralysisDamage;
        wizard.canMove = false;

        paralysisDamage = Constants.PARALYSIS + Constants.PARALYSIS_BONUS * wizard.getLevel();
        paralysisDamage *=  1.25f;
        paralysisDamage = Math.round(paralysisDamage);
        Math.round(wizard.overtimeDamage);
        wizard.overtimeRounds = 3;
        if (landType == 'W') {
            wizard.overtimeRounds = 6;
            paralysisDamage *= 1.15f;
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

    public void addXp(Player loser) {
//        System.out.println("adaug xp");
        this.xp = xp + (int) Math.max(0, 200 - (this.level - loser.level) * Constants.PARALYSIS);
        if (this.xp > (250 + level * 50)) {
            level++;
            this.hp = Constants.ROGUE_HP + Constants.ROGUE_HP_PER_LEVEL * level;
        }
    }
}
