package main.heroes;

public abstract class Player {
    protected int xp = 0;
    protected float hp;
    protected int maxHp;
    protected int level = 0;
    protected int xpLevelUp;
    protected int damage;
    protected int x;
    protected int y;
    public int overtimeRounds;
    protected float overtimeDamage;
    protected boolean fight;
    protected String name;
//    protected float damageReceived;
    protected boolean canMove;

//    public void setDamageReceived(float damage) {
//        this.damageReceived = damage;
//    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public abstract void addXp(Player loser);

    public boolean getFight() {
        return fight;
    }

    public void checkOvertime() {
//        System.out.println(hp + " in functie" + this.getName());
        if (overtimeRounds > 0 && hp > 0) {
            hp -= overtimeDamage;
            hp = Math.round(hp);
        }
//        System.out.println(hp + " in functie" + this.getName());
        overtimeRounds = overtimeRounds - 1;
        if (overtimeRounds == 0) {
            canMove = true;
        }
//        if (this.hp <= 0) {
//            source.addXp(this);
//        }
    }

    public void setFight() {
        this.fight = true;
    }
    public void resetFight() {
        this.fight = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveU() {
        if (this.canMove == true) {
            this.x--;
        }
    }

    public void moveD() {
        if (this.canMove == true) {
            this.x++;
        }
    }

    public void moveL() {
        if (this.canMove == true) {
            this.y--;
        }
    }

    public void moveR() {
        if (this.canMove == true) {
            this.y++;
        }
    }

    public void noMove() { }

    public int getXp() {
        return xp;
    }

    public float getHp() {
        return hp;
    }

    public int getLevel() {
        return level;
    }

    public int getXpLevelUp() {
        return xpLevelUp;
    }

    public String getName() {
        return name;
    }



//    public void checkIgniteToTake(int roundsRemained, float modificator) {
//        int damage;
//        if (roundsRemained == 3) {
//            roundsRemained--;
//            return;
//        }
//        if (roundsRemained > 0) {
//            damage = Constants.
//            hp -= 50 + 30 * level;
//            roundsRemained--;
//        }
//    }

    public abstract float isAttackedBy(Player player, char landType);
    public abstract float attack(Knight knight, char landType);
    public abstract float attack(Pyromancer pyromancer, char landType);
    public abstract float attack(Rogue rogue, char landType);
    public abstract float attack(Wizard wizard, char landType);
}
