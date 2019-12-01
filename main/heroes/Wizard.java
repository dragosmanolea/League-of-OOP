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
        // drain
        float damage, firstSkill, secondSkill;
        float damageFromKnight;
        float procentFirstSkill;
        float procentSecondSkill;
        procentFirstSkill = 0.2f + 0.05f * this.getLevel();
        float baseHp;
        float damageReceived;
        float opponentMaxHp = Constants.KNIGHT_HP + Constants.KNIGHT_HP_PER_LEVEL * knight.getLevel();
        baseHp = (float) Math.min(0.3 * opponentMaxHp, knight.getHp());
        procentFirstSkill *= Constants.drainKnight;
        firstSkill = procentFirstSkill * baseHp;
//        firstSkill = Math.round(firstSkill);
        if (landType == 'D') {
            firstSkill *= 1.1f;
        }
        firstSkill = Math.round(firstSkill);
//        System.out.println("first skill:" + firstSkill);
        float damageDeflect;
        float hpLimit;

        float teoreticMaxHp = Constants.wizardHp + Constants.wizardHpPerLevel * this.getLevel();
//        System.out.println(teoreticMaxHp);
        float maxProcent = 0.01f * this.getLevel();
        if (maxProcent > 0.4f) {
            maxProcent = 0.4f;
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
            damageReceived *= 1.15f;
        }
        procentSecondSkill = 0.35f + (1.02f * knight.getLevel());
        if (procentSecondSkill > 0.7f) {
            procentSecondSkill = 0.7f;
        }

        damageDeflect = procentSecondSkill * damageReceived;
        damageDeflect = Math.round(damageDeflect);
        secondSkill = damageDeflect;

        secondSkill *= Constants.deflectKnight;
        secondSkill = Math.round(secondSkill);

        if (landType == 'D') {
            secondSkill *= 1.1f;
        }

        secondSkill = Math.round(secondSkill);
//        System.out.println(secondSkill);
        damage = firstSkill + secondSkill;
//        System.out.println("Wizard -> knight:" + firstSkill + ":" + secondSkill);
        return damage;
    }

    @Override
    public float attack(Pyromancer pyromancer, char landType) {
        // drain
        float damage, firstSkill, secondSkill;
        float procentFirstSkill;
        float procentSecondSkill;

        procentFirstSkill = 0.2f + 0.05f * this.getLevel();

        float baseHp;
        float damageReceived;
        float opponentMaxHp = Constants.PYROMANCER_HP + Constants.PYROMANCER_HP_PER_LEVEL * pyromancer.getLevel();
        baseHp = (float) Math.min(0.3 * opponentMaxHp, pyromancer.getHp());
        procentFirstSkill *= Constants.drainPyormancer;
        firstSkill = procentFirstSkill * baseHp;
        if (landType == 'D') {
            firstSkill *= 1.1f;
        }

        // deflect
        float damageDeflect;

        damageReceived = Constants.FIREBLAST + Constants.FIREBLAST_BONUS * pyromancer.level;
        damageReceived += Constants.IGNITE + Constants.IGNITE * pyromancer.level;
        if (landType == 'V') {
            damageReceived *= 1.25f;
        }
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
        return damage;
    }

    @Override
    public float attack(Rogue rogue, char landType) {
        float damage, firstSkill, secondSkill;
        float procentFirstSkill;
        float procentSecondSkill;

        procentFirstSkill = 0.2f + 0.05f * this.getLevel();

        float baseHp;
        float damageReceived;
        float opponentMaxHp = Constants.ROGUE_HP + Constants.ROGUE_HP_PER_LEVEL * rogue.getLevel();
        baseHp = (float) Math.min(0.3 * opponentMaxHp, rogue.getHp());
        procentFirstSkill *= Constants.drainRogue;
        firstSkill = procentFirstSkill * baseHp;
        if (landType == 'D') {
            firstSkill *= 1.1f;
        }

        // deflect
        float damageDeflect;

        damageReceived = Constants.BACKSTAB + Constants.BACKSTAB_BONUS * rogue.level;
        if (landType == 'W') {
            damageReceived *= 1.5f;
        }

        damageReceived += Constants.PARALYSIS + Constants.PARALYSIS_BONUS * rogue.level;

        if (landType == 'W') {
            damageReceived *= 1.15f;
        }

        procentSecondSkill = 0.35f + (1.02f * rogue.getLevel());
        if (procentSecondSkill > 0.7f) {
            procentSecondSkill = 0.7f;
        }

        damageDeflect = procentSecondSkill * damageReceived;
        damageDeflect = Math.round(damageDeflect);
        secondSkill = damageDeflect;

        secondSkill *= Constants.deflectRogue;
        secondSkill = Math.round(secondSkill);

        if (landType == 'D') {
            secondSkill *= 1.1f;
        }

        secondSkill = Math.round(secondSkill);
        damage = firstSkill + secondSkill;
        return damage;
    }

    @Override
    public float attack(Wizard wizard, char landType) {
        // WIZARD LA WIZARD NU ARE DEFLECT
        // drain
        float damage, firstSkill;
        float procentFirstSkill;

        procentFirstSkill = 0.2f + 0.05f * this.getLevel();

        float baseHp;
        float opponentMaxHp = Constants.wizardHp + Constants.wizardHpPerLevel * wizard.getLevel();
        baseHp = (float) Math.min(0.3 * opponentMaxHp, wizard.getHp());
        procentFirstSkill *= Constants.drainWizard;
        firstSkill = procentFirstSkill * baseHp;
        if (landType == 'D') {
            firstSkill *= 1.1f;
        }
        damage = firstSkill;
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
