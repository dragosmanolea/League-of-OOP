package heroes;

public class Knight extends Player {
//    public final String name;
    private int bonusHpPerLevel = 80;
    private double initialHp = 900;
    public Knight(int x, int y) {
        this.hp = initialHp;
        this.x = x;
        this.y = y;
        this.name = "K";
    }

    @Override
    public double isAttackedBy(Player player, char landType) {
        double firstDamage = player.attack(this, landType);
        System.out.println(player.getLevel());
        System.out.println(player.getName());
        System.out.println("Tipul pamantului: " + landType);
        System.out.println("____________");
        return 0;
    }

    @Override
    public double attack(Knight knight, char landType) {
        System.out.println("knight attacked by knight");
        return 0;
    }

    @Override
    public double attack(Pyromancer pyromancer, char landType) {
        System.out.println("pyromancer attacked by knight");
        return 0;
    }

    @Override
    public double attack(Rogue rogue, char landType) {
        System.out.println("rogue attacked by knight");
        return 0;
    }

    @Override
    public double attack(Wizard wizard, char landType) {
        System.out.println("Wizard attacked by knight");
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
            this.hp = 900 + 80 * level;
        }
    }
}
