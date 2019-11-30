package main.heroes;
public class PlayerCreator {
    public static Player getPlayer(String playerName, int x, int y) {
        switch (playerName) {
            case "K":
                return new Knight(x, y);
            case "P":
                return new Pyromancer(x, y);
            case "R":
                return new Rogue(x, y);
            case "W":
                return new Wizard(x, y);
            default:
                return null;
        }
    }
}
