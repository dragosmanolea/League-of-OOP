package main.heroes;

public class Pyromancer extends Player {
//    public final String name;
    private double initialHp = 500;
    private int bonusHpPerLevel = 50;
    private int bonusDamagePerLevel = 50;
    private int currentRound;
    public Pyromancer(int x, int y) {
        this.hp = initialHp;
        this.x = x;
        this.y = y;
        this.name = "P";
        currentRound = 0;
    }


    @Override
    public double isAttackedBy(Player player, char landType) {
        double damage = player.attack(this, landType);
        damage = Math.round(damage);
        return damage;
    }
    @Override
    public double attack(Knight knight, char landType) {
        return 0;
    }

    @Override
    public double attack(Pyromancer pyromancer, char landType) {
        System.out.println("pyromancer attacked by pyromancer");
        return 0;
    }

    @Override
    public double attack(Rogue rogue, char landType) {
        System.out.println("rogue attacked by pyromancer");
        return 0;
    }

    @Override
    public double attack(Wizard wizard, char landType) {
        System.out.println("Wizard attacked by pyromancer");
        return 0;
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
