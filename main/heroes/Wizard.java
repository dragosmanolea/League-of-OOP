package main.heroes;

public final class Wizard extends Player {
//    public final String name;
    public Wizard(final int x, final int y) {
        this.hp = Constants.WIZARD_HP;
        this.x = x;
        this.y = y;
        this.name = "W";
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
        // drain
        float damage, firstSkill, secondSkill;
        float damageFromKnight;
        float procentFirstSkill;
        float procentSecondSkill;
        procentFirstSkill = Constants.PROCENT_DRAIN
                + Constants.PROCENT_DRAIN_LEVEL * this.getLevel();
        float baseHp;
        float damageReceived;
        float opponentMaxHp = Constants.KNIGHT_HP
                + Constants.KNIGHT_HP_PER_LEVEL * knight.getLevel();
        baseHp = (float) Math.min(Constants.ZERO_TREI * opponentMaxHp, knight.getHp());
        procentFirstSkill *= Constants.DRAIN_KNIGHT;
        firstSkill = procentFirstSkill * baseHp;
//        firstSkill = Math.round(firstSkill);
        if (landType == 'D') {
            firstSkill *= Constants.WIZARD_LAND_BONUS;
        }
        firstSkill = Math.round(firstSkill);
//        System.out.println("first skill:" + firstSkill);
        float damageDeflect;
        float hpLimit;

        float teoreticMaxHp = Constants.WIZARD_HP
                + Constants.WIZARD_HP_PER_LEVEL * this.getLevel();
//        System.out.println(teoreticMaxHp);
        float maxProcent = Constants.MIN_PROCENTAGE * this.getLevel();
        if (maxProcent > Constants.MAX_PROCENTAGE) {
            maxProcent = Constants.MAX_PROCENTAGE;
        }
        hpLimit = Constants.PROCENT_HP * teoreticMaxHp + maxProcent;
//        System.out.println(hpLimit);
        if (this.getHp() < hpLimit) {
            damageFromKnight = this.getHp();
            damageReceived = damageFromKnight;
            return damageReceived;
        }
//        System.out.println("Pe aici ajunge?");

        damageReceived = Constants.EXECUTE + Constants.EXECUTE_BONUS * this.level;
        damageReceived += Constants.SLAM + Constants.SLAM_BONUS * this.level;
        if (landType == 'L') {
            damageReceived *= Constants.KNIGHT_LAND_BONUS;
        }
        procentSecondSkill = Constants.ZERO_TREI_CINCI
                + (Constants.UNU_ZERO_DOI * knight.getLevel());
        if (procentSecondSkill > Constants.ZERO_SAPTE) {
            procentSecondSkill = Constants.ZERO_SAPTE;
        }

        damageDeflect = procentSecondSkill * damageReceived;
        damageDeflect = Math.round(damageDeflect);
        secondSkill = damageDeflect;

        secondSkill *= Constants.DEFLECT_KNIGHT;
        secondSkill = Math.round(secondSkill);

        if (landType == 'D') {
            secondSkill *= Constants.WIZARD_LAND_BONUS;
        }

        secondSkill = Math.round(secondSkill);
//        System.out.println(secondSkill);
        damage = firstSkill + secondSkill;
//        System.out.println("Wizard -> knight:" + firstSkill + ":" + secondSkill);
        return damage;
    }

    @Override
    public float attack(final Pyromancer pyromancer, final char landType) {
        // drain
        float damage, firstSkill, secondSkill;
        float procentFirstSkill;
        float procentSecondSkill;

        procentFirstSkill = Constants.PROCENT_DRAIN
                + Constants.PROCENT_DRAIN_LEVEL * this.getLevel();

        float baseHp;
        float damageReceived;
        float opponentMaxHp = Constants.PYROMANCER_HP
                + Constants.PYROMANCER_HP_PER_LEVEL * pyromancer.getLevel();
        baseHp = (float) Math.min(Constants.ZERO_TREI * opponentMaxHp, pyromancer.getHp());
        procentFirstSkill *= Constants.DRAIN_PYROMANCER;
        firstSkill = procentFirstSkill * baseHp;
        if (landType == 'D') {
            firstSkill *= Constants.WIZARD_LAND_BONUS;
        }

        // deflect
        float damageDeflect;

        damageReceived = Constants.FIREBLAST
                + Constants.FIREBLAST_BONUS * pyromancer.level;
        damageReceived += Constants.IGNITE + Constants.IGNITE * pyromancer.level;
        if (landType == 'V') {
            damageReceived *= Constants.PYROMANCER_LAND_BONUS;
        }
        procentSecondSkill = Constants.ZERO_TREI_CINCI
                + (Constants.UNU_ZERO_DOI * pyromancer.getLevel());
        if (procentSecondSkill > Constants.ZERO_SAPTE) {
            procentSecondSkill = Constants.ZERO_SAPTE;
        }

        damageDeflect = procentSecondSkill * damageReceived;
        damageDeflect = Math.round(damageDeflect);
        secondSkill = damageDeflect;

        secondSkill *= Constants.DEFLECT_PYROMANCER;
        secondSkill = Math.round(secondSkill);

        if (landType == 'D') {
            secondSkill *= Constants.WIZARD_LAND_BONUS;
        }

        secondSkill = Math.round(secondSkill);
        damage = firstSkill + secondSkill;
        return damage;
    }

    @Override
    public float attack(final Rogue rogue, final char landType) {
        float damage, firstSkill, secondSkill;
        float procentFirstSkill;
        float procentSecondSkill;

        procentFirstSkill = Constants.PROCENT_DRAIN
                + Constants.PROCENT_DRAIN_LEVEL * this.getLevel();

        float baseHp;
        float damageReceived;
        float opponentMaxHp = Constants.ROGUE_HP
                + Constants.ROGUE_HP_PER_LEVEL * rogue.getLevel();
        baseHp = (float) Math.min(Constants.ZERO_TREI * opponentMaxHp, rogue.getHp());
        procentFirstSkill *= Constants.DRAIN_ROGUE;
        firstSkill = procentFirstSkill * baseHp;
        if (landType == 'D') {
            firstSkill *= Constants.WIZARD_LAND_BONUS;
        }

        // deflect
        float damageDeflect;

        damageReceived = Constants.BACKSTAB + Constants.BACKSTAB_BONUS * rogue.level;
        if (landType == 'W') {
            damageReceived *= Constants.ROGUE_CRITICAL;
        }

        damageReceived += Constants.PARALYSIS + Constants.PARALYSIS_BONUS * rogue.level;

        if (landType == 'W') {
            damageReceived *= Constants.ROGUE_LAND_BONUS;
        }

        procentSecondSkill = Constants.ZERO_TREI_CINCI
                + (Constants.UNU_ZERO_DOI * rogue.getLevel());
        if (procentSecondSkill > Constants.ZERO_SAPTE) {
            procentSecondSkill = Constants.ZERO_SAPTE;
        }

        damageDeflect = procentSecondSkill * damageReceived;
        damageDeflect = Math.round(damageDeflect);
        secondSkill = damageDeflect;

        secondSkill *= Constants.DEFLECT_ROGUE;
        secondSkill = Math.round(secondSkill);

        if (landType == 'D') {
            secondSkill *= Constants.WIZARD_LAND_BONUS;
        }

        secondSkill = Math.round(secondSkill);
        damage = firstSkill + secondSkill;
        return damage;
    }

    @Override
    public float attack(final Wizard wizard, final char landType) {
        // WIZARD LA WIZARD NU ARE DEFLECT
        // drain
        float damage, firstSkill;
        float procentFirstSkill;

        procentFirstSkill = Constants.PROCENT_DRAIN
                + Constants.PROCENT_DRAIN_LEVEL * this.getLevel();

        float baseHp;
        float opponentMaxHp = Constants.WIZARD_HP
                + Constants.WIZARD_HP_PER_LEVEL * wizard.getLevel();
        baseHp = (float) Math.min(Constants.ZERO_TREI * opponentMaxHp, wizard.getHp());
        procentFirstSkill *= Constants.DRAIN_WIZARD;
        firstSkill = procentFirstSkill * baseHp;
        if (landType == 'D') {
            firstSkill *= Constants.WIZARD_LAND_BONUS;
        }
        damage = firstSkill;
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
            level++;
            this.hp = Constants.WIZARD_HP + Constants.WIZARD_HP_PER_LEVEL * level;
        }
    }
}
