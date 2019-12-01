package main.heroes;

public abstract class Player {
    protected int xp = 0;
    protected float hp;
    protected int level = 0;
    protected int xpLevelUp;
    protected int x;
    protected int y;
    protected int overtimeRounds;
    protected float overtimeDamage;
    protected boolean fight;
    protected String name;
    protected boolean canMove = true;

    public final void setHp(final float hp) {
        this.hp = hp;
    }

    public abstract void addXp(Player loser);

    public final boolean getFight() {
        return fight;
    }

    public final void checkOvertime() {
        if (overtimeRounds > 0 && hp > 0) {
            hp -= overtimeDamage;
            hp = Math.round(hp);
        }
        overtimeRounds = overtimeRounds - 1;
        if (overtimeRounds == 0) {
            canMove = true;
        }
    }

    public final void setFight() {
        this.fight = true;
    }
    /*
    * Campul fight e resetat pentru urmatoarea runda, in care va putea lupta
    * Am facut asta ca sa evit duplicarea luptelor
    * */
    public final void resetFight() {
        this.fight = false;
    }
    /*
    * Returneaza Linia
    * */
    public final int getX() {
        return x;
    }

    /*
    * Returneaza coloana
    * */

    public final int getY() {
        return y;
    }

    public final void moveU() {
        if (this.canMove) {
            this.x--;
        }
    }

    public final void moveD() {
        if (this.canMove) {
            this.x++;
        }
    }

    public final void moveL() {
        if (this.canMove) {
            this.y--;
        }
    }

    public final void moveR() {
        if (this.canMove) {
            this.y++;
        }
    }

    public final void noMove() { }

    public final int getXp() {
        return xp;
    }

    public final float getHp() {
        return hp;
    }

    public final int getLevel() {
        return level;
    }

    public final String getName() {
        return name;
    }

    public abstract float isAttackedBy(Player player, char landType);
    public abstract float attack(Knight knight, char landType);
    public abstract float attack(Pyromancer pyromancer, char landType);
    public abstract float attack(Rogue rogue, char landType);
    public abstract float attack(Wizard wizard, char landType);
}
