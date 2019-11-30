package main.heroes;

public class Wizard extends Player {
//    public final String name;
    private int bonusHpPerLevel = 30;
    private float initialHp = 400;
    public Wizard(int x, int y) {
        this.hp = initialHp;
        this.x = x;
        this.y = y;
        this.name = "W";
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
        float damage, firstSkill, secondSkill;
        float procentFirstSkill;
        float procentSecondSkill;
        procentFirstSkill = 0.2f + 0.05f * knight.getLevel();
        float baseHp;
        float damageReceived;
        float opponentMaxHp = Constants.knightHp + Constants.knightHpPerLevel * knight.getLevel();
        baseHp = (float) Math.min(0.3 * opponentMaxHp, knight.getHp());
        procentFirstSkill *= Constants.drainKnight;
        procentFirstSkill = procentFirstSkill + (0.2f * procentFirstSkill);
        firstSkill = procentFirstSkill * baseHp;
        firstSkill = Math.round(firstSkill);
        // deflect
        float damageDeflect;
        damageReceived = Constants.execute + Constants.executeBonus * this.level;
        damageReceived += Constants.slam + Constants.slamBonus * this.level;
        damageDeflect = 0.35f * damageReceived;
        damageDeflect = Math.round(damageDeflect);
        procentSecondSkill = (0.02f * knight.getLevel());

        if (procentSecondSkill <= 0.7f) {
            secondSkill = (procentSecondSkill * damageDeflect +  damageDeflect);
        } else {
            secondSkill = (0.7f * damageReceived);
        }

        secondSkill *= Constants.deflectKnight;
        secondSkill = Math.round(secondSkill);

        damage = firstSkill + secondSkill;

        if (landType == 'D') {
            damage *= 1.1f;
        }
        return damage;
    }

    @Override
    public float attack(Pyromancer pyromancer, char landType) {
        float damage, firstSkill, secondSkill;
        float procentFirstSkill;
        float procentSecondSkill;

        procentFirstSkill = 0.2f + 0.05f * this.getLevel();

        float baseHp;
        float damageReceived;
        float opponentMaxHp = Constants.pyromancerHp + Constants.pyromancerHpPerLevel * pyromancer.getLevel();
        baseHp = (float) Math.min(0.3 * opponentMaxHp, pyromancer.getHp());
        procentFirstSkill *= Constants.drainPyormancer;
        firstSkill = procentFirstSkill * baseHp;
        firstSkill = Math.round(firstSkill);
        if (landType == 'D') {
            firstSkill *= 1.1f;
        }

        // deflect
        float damageDeflect;

        damageReceived = Constants.fireblast + Constants.fireblastBonus * pyromancer.level;
        damageReceived += Constants.ignite + Constants.ignite * pyromancer.level;

        procentSecondSkill = 0.35f + (1.02f * pyromancer.getLevel());
        if (procentSecondSkill > 0.7f) {
            procentSecondSkill = 0.7f;
        }

        damageDeflect = procentSecondSkill * damageReceived;
        damageDeflect = Math.round(damageDeflect);
        secondSkill = damageDeflect;

        secondSkill *= Constants.deflectPyromancer;
        secondSkill = Math.round(secondSkill);

        if (landType == 'D') {
            secondSkill *= 1.1f;
        }

        secondSkill = Math.round(secondSkill);
        damage = firstSkill + secondSkill;
//        System.out.println("First: " + firstSkill);
//        System.out.println("Second: " + secondSkill);
        return damage;
    }

    @Override
    public float attack(Rogue rogue, char landType) {
//        System.out.println("Damage by wizard to rogue on land: " + landType);
        float damage, firstSkill, secondSkill;
        float procentFirstSkill;
        float procentSecondSkill;
        procentFirstSkill = 0.2f + 0.05f * rogue.getLevel();
        float baseHp;
        float damageReceived;
        float opponentMaxHp = 600 + 40 * rogue.getLevel();
        baseHp = (float) Math.min(0.3 * opponentMaxHp, rogue.getHp());
        procentFirstSkill = procentFirstSkill - (float) (0.2f * procentFirstSkill);
        firstSkill = procentFirstSkill * baseHp;
        firstSkill = Math.round(firstSkill);
        // deflect
        float damageDeflect;
        damageReceived = 200 + 20 * this.level;
        damageReceived += 40 + 10 * this.level;
        damageDeflect = 0.35f * damageReceived;
        damageDeflect = Math.round(damageDeflect);
        procentSecondSkill = (float) (0.02f * rogue.getLevel());
        if (procentSecondSkill <= 0.7f) {
            secondSkill = (float) (procentSecondSkill * damageDeflect +  damageDeflect);
        } else {
            secondSkill = (float) (0.7f * damageReceived);
        }

        secondSkill *= 1.2f;
        secondSkill = Math.round(secondSkill);

        damage = firstSkill + secondSkill;

        if (landType == 'D') {
            damage *= 1.1f;
        }
        return damage;
    }

    @Override
    public float attack(Wizard wizard, char landType) {
        // WIZARD LA WIZARD NU ARE DEFLECT
        float damage, firstSkill;
        float procentFirstSkill;
        procentFirstSkill = 0.2f + 0.05f * wizard.getLevel();
        float baseHp;
        float opponentMaxHp = Constants.wizardHp + Constants.wizardHpPerLevel * wizard.getLevel();
        baseHp = (float) Math.min(0.3 * opponentMaxHp, wizard.getHp());
        procentFirstSkill *= Constants.drainWizard;
        procentFirstSkill = procentFirstSkill - (0.2f * procentFirstSkill);
        firstSkill = procentFirstSkill * baseHp;
        firstSkill = Math.round(firstSkill);
        damage = firstSkill;
        // deflect
//        float damageDeflect;
//        damageReceived = Constants.dra + Constants.fireblastBonus * this.level;
//        damageReceived += Constants.ignite + Constants.ignite * this.level;
//        damageDeflect = 0.35f * damageReceived;
//        damageDeflect = Math.round(damageDeflect);
//        procentSecondSkill = (0.02f * wizard.getLevel());
//        if (procentSecondSkill <= 0.7f) {
//            secondSkill = (procentSecondSkill * damageDeflect +  damageDeflect);
//        } else {
//            secondSkill = (0.7f * damageReceived);
//        }
//
//        secondSkill *= Constants.deflectPyromancer;
//        secondSkill = Math.round(secondSkill);
//
//        damage = firstSkill + secondSkill;

        if (landType == 'D') {
            damage *= 1.1f;
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
            this.hp = initialHp + bonusHpPerLevel * level;
        }
    }
}
