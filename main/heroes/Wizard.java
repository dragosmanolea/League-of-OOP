package main.heroes;

public class Wizard extends Player {
//    public final String name;
    private int bonusHpPerLevel = 30;
    private double initialHp = 400;
    public Wizard(int x, int y) {
        this.hp = initialHp;
        this.x = x;
        this.y = y;
        this.name = "W";
        this.overtimeRounds = 0;
    }

    @Override
    public double isAttackedBy(Player player, char landType) {
        double damage = player.attack(this, landType);
        damage = Math.round(damage);
        return damage;
    }
    @Override
    public double attack(Knight knight, char landType) {
        double damage, firstSkill, secondSkill;
        double procentFirstSkill;
        double procentSecondSkill;
        procentFirstSkill = 0.2f + 0.05f * knight.getLevel();
        double baseHp;
        double damageReceived;
        double opponentMaxHp = Constants.knightHp + Constants.knightHpPerLevel * knight.getLevel();
        baseHp = Math.min(0.3 * opponentMaxHp, knight.getHp());
        procentFirstSkill *= Constants.drainKnight;
        procentFirstSkill = procentFirstSkill + (0.2f * procentFirstSkill);
        firstSkill = procentFirstSkill * baseHp;
        firstSkill = Math.round(firstSkill);
        // deflect
        double damageDeflect;
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
    public double attack(Pyromancer pyromancer, char landType) {
        double damage, firstSkill, secondSkill;
        double procentFirstSkill;
        double procentSecondSkill;
        procentFirstSkill = 0.2f + 0.05f * pyromancer.getLevel();
        double baseHp;
        double damageReceived;
        double opponentMaxHp = Constants.pyromancerHp + Constants.pyromancerHpPerLevel * pyromancer.getLevel();
        baseHp = (double) Math.min(0.3 * opponentMaxHp, pyromancer.getHp());
        procentFirstSkill *= Constants.drainPyormancer;
        procentFirstSkill = procentFirstSkill - (double) (0.2f * procentFirstSkill);
        firstSkill = procentFirstSkill * baseHp;
        firstSkill = Math.round(firstSkill);
        // deflect
        double damageDeflect;
        damageReceived = Constants.fireblast + Constants.fireblastBonus * this.level;
        damageReceived += Constants.ignite + Constants.ignite * this.level;
        damageDeflect = 0.35f * damageReceived;
        damageDeflect = Math.round(damageDeflect);
        procentSecondSkill = (double) (0.02f * pyromancer.getLevel());
        if (procentSecondSkill <= 0.7f) {
            secondSkill = (double) (procentSecondSkill * damageDeflect +  damageDeflect);
        } else {
            secondSkill = (double) (0.7f * damageReceived);
        }

        secondSkill *= Constants.deflectPyromancer;
        secondSkill = Math.round(secondSkill);

        damage = firstSkill + secondSkill;

        if (landType == 'D') {
            damage *= 1.1f;
        }
        return damage;
    }

    @Override
    public double attack(Rogue rogue, char landType) {
//        System.out.println("Damage by wizard to rogue on land: " + landType);
        double damage, firstSkill, secondSkill;
        double procentFirstSkill;
        double procentSecondSkill;
        procentFirstSkill = 0.2f + 0.05f * rogue.getLevel();
        double baseHp;
        double damageReceived;
        double opponentMaxHp = 600 + 40 * rogue.getLevel();
        baseHp = (double) Math.min(0.3 * opponentMaxHp, rogue.getHp());
        procentFirstSkill = procentFirstSkill - (double) (0.2f * procentFirstSkill);
        firstSkill = procentFirstSkill * baseHp;
        firstSkill = Math.round(firstSkill);
        // deflect
        double damageDeflect;
        damageReceived = 200 + 20 * this.level;
        damageReceived += 40 + 10 * this.level;
        damageDeflect = 0.35f * damageReceived;
        damageDeflect = Math.round(damageDeflect);
        procentSecondSkill = (double) (0.02f * rogue.getLevel());
        if (procentSecondSkill <= 0.7f) {
            secondSkill = (double) (procentSecondSkill * damageDeflect +  damageDeflect);
        } else {
            secondSkill = (double) (0.7f * damageReceived);
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
    public double attack(Wizard wizard, char landType) {
        // WIZARD LA WIZARD NU ARE DEFLECT
        double damage, firstSkill;
        double procentFirstSkill;
        procentFirstSkill = 0.2f + 0.05f * wizard.getLevel();
        double baseHp;
        double opponentMaxHp = Constants.wizardHp + Constants.wizardHpPerLevel * wizard.getLevel();
        baseHp = Math.min(0.3 * opponentMaxHp, wizard.getHp());
        procentFirstSkill *= Constants.drainWizard;
        procentFirstSkill = procentFirstSkill - (0.2f * procentFirstSkill);
        firstSkill = procentFirstSkill * baseHp;
        firstSkill = Math.round(firstSkill);
        damage = firstSkill;
        // deflect
//        double damageDeflect;
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
