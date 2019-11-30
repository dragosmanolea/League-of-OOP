package main.heroes;

public abstract class Player {
    protected int xp = 0;
    protected double hp;
    protected int maxHp;
    protected int level = 0;
    protected int xpLevelUp;
    protected int damage;
    protected int x;
    protected int y;
    public int overtimeRounds;
    protected double overtimeDamage;
    protected boolean fight;
    protected String name;
//    protected double damageReceived;
    protected boolean canMove;

//    public void setDamageReceived(double damage) {
//        this.damageReceived = damage;
//    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public abstract void addXp(Player loser);

    public boolean getFight() {
        return fight;
    }

    public void checkOvertime() {
//        System.out.println(hp + " in functie" + this.getName());
        if (overtimeRounds > 0) {
            hp -= overtimeDamage;
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

    public double getHp() {
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



//    public void checkIgniteToTake(int roundsRemained, double modificator) {
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

    public abstract double isAttackedBy(Player player, char landType);
    public abstract double attack(Knight knight, char landType);
    public abstract double attack(Pyromancer pyromancer, char landType);
    public abstract double attack(Rogue rogue, char landType);
    public abstract double attack(Wizard wizard, char landType);
}
