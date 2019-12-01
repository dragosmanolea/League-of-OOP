package main;


import main.heroes.Player;
import main.heroes.PlayerCreator;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(final String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();
        int x, y;
        int n = gameInput.getN();
        int m = gameInput.getM();
        int p = gameInput.getP();
        int r = gameInput.getR();

        List<List<String>> land = gameInput.getLand();
        List<List<String>> positions = gameInput.getPositions();
        List<List<String>> moves = gameInput.getMoves();

        List<Player> players = new ArrayList<>();

        List<String> currPlayer = new ArrayList<>();
        String hero = new String();
        for (int i = 0; i < p; ++i) {
            currPlayer = positions.get(i);
            hero = currPlayer.get(0);
            x = Integer.parseInt(currPlayer.get(1));
            y = Integer.parseInt(currPlayer.get(2));
            players.add(PlayerCreator.getPlayer(hero, x, y));
        }

        char[][] map = new char[n][m];
        List<String> currLands = new ArrayList<>();
        String currLand = new String();
        for (int i = 0; i < land.size(); ++i) {
            currLands = land.get(i);
            currLand = currLands.get(0);
            for (int j = 0; j < currLand.length(); ++j) {
                map[i][j] = currLand.charAt(j);
            }
        }

        List<String> currMoves = new ArrayList<>();
        String currMove = new String();
        for (int i = 0; i < r; ++i) {
            currMoves = moves.get(i);
            currMove = currMoves.get(0);
            for (int j = 0; j < p; ++j) {
                switch (currMove.charAt(j)) {
                    case 'L':
                        players.get(j).moveL();
                        break;
                    case 'D':
                        players.get(j).moveD();
                        break;
                    case 'U':
                        players.get(j).moveU();
                        break;
                    case 'R':
                        players.get(j).moveR();
                        break;
                    case '_':
                        players.get(j).noMove();
                        break;
                    default:
                        break;
                }
            }
            for (Player it : players) {
                it.resetFight();
                it.checkOvertime();
            }
            int playerX, playerY;
            float firstDamage = 0;
            float secondDamage = 0;
            for (int j = 0; j < p; ++j) {
                for (Player it : players) {
                    if (!players.get(j).equals(it)) {
                        playerX = players.get(j).getX();
                        playerY = players.get(j).getY();
                        if (playerX == it.getX() && playerY == it.getY()
                                && !it.getFight() && !players.get(j).getFight()
                                && it.getHp() > 0 && players.get(j).getHp() > 0) {

                            secondDamage = players.get(j).isAttackedBy(it, map[playerX][playerY]);
                            players.get(j).setFight();

                            firstDamage = it.isAttackedBy(players.get(j), map[playerX][playerY]);
                            it.setFight();

                            it.setHp(it.getHp() - firstDamage);
                            players.get(j).setHp((players.get(j).getHp()
                                    - secondDamage));

                            if (it.getHp() <= 0) {
                                it.setHp(0);
                                players.get(j).addXp(it);
                            }

                            if (players.get(j).getHp() <= 0) {
                                players.get(j).setHp(0);
                                it.addXp(players.get(j));
                            }
                        }
                    }
                }
            }
            System.out.println("Round: " + i);
            for (Player xxx : players) {
                if (xxx.getHp() <= 0) {
                    System.out.println(xxx.getName() + " dead");
                } else {
                    System.out.println((xxx.getName() + " " + xxx.getLevel()
                            + " " + xxx.getXp() + " " + (int) xxx.getHp() + " "
                            + xxx.getX() + " " + xxx.getY()));
                }
            }
            System.out.println("-----------END ROUND--------");
        }

        String filename = args[1];
        try {
            fileio.implementations.FileWriter fileWriter
                    = new fileio.implementations.FileWriter(filename);
            for (Player it : players) {
                if (it.getHp() <= 0) {
                    fileWriter.writeWord(it.getName() + " dead");
                    fileWriter.writeNewLine();
                } else {
                    fileWriter.writeWord((it.getName() + " " + it.getLevel()
                            + " " + it.getXp() + " " + (int) it.getHp() + " "
                            + it.getX() + " " + it.getY()));
                    fileWriter.writeNewLine();
                }
            }
            fileWriter.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        for (Player it : players) {
            if (it.getHp() <= 0) {
                System.out.println((it.getName() + " dead"));
            } else {
                System.out.println((it.getName() + " " + it.getLevel()
                        + " " + it.getXp() + " " + (int) it.getHp() + " "
                        + it.getX() + " " + it.getY()));
            }
        }
    }
}
