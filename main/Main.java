package main;


import main.heroes.Player;
import main.heroes.PlayerCreator;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
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

//        System.out.println(land.toString());
//        System.out.println(positions.toString());
//        System.out.println(moves.toString());

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

//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < m; ++j) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        List<String> currMoves = new ArrayList<>();
        String currMove = new String();
//        System.out.println("Inainte de miscari:");
//        System.out.println(players.toString());


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
                }
            }
            for (Player it : players) {
                it.resetFight();
                it.checkOvertime();
            }
            int X, Y;
            float firstDamage = 0;
            float secondDamage = 0;
            for (int j = 0; j < p; ++j) {
                for (Player it : players) {
                    if (!players.get(j).equals(it)) {
                        X = players.get(j).getX();
                        Y = players.get(j).getY();
                        if (X == it.getX() && Y == it.getY()
                                && it.getFight() == false && players.get(j).getFight() == false
                                && it.getHp() > 0 && players.get(j).getHp() > 0) {

                            if (players.get(j).getHp() > 0) {
                                firstDamage = it.isAttackedBy(players.get(j), map[X][Y]);
//                            System.out.println(it.getName() + " : " + firstDamage);
                                it.setFight();
                            }

                            if (it.getHp() > 0) {
                                secondDamage = players.get(j).isAttackedBy(it, map[X][Y]);
                                players.get(j).setFight();
                            }

                            if (firstDamage >= it.getHp() && it.getHp() > 0) {
                                it.setHp(0);
                                players.get(j).addXp(it);
                            }

                            if (secondDamage >= players.get(j).getHp() && players.get(j).getHp() > 0) {
                                players.get(j).setHp(0);
                                it.addXp(players.get(j));
                            }


                            if (secondDamage < players.get(j).getHp() && players.get(j).getHp() > 0) {
                                players.get(j).setHp((players.get(j).getHp() - secondDamage));
//                                players.get(j).checkOvertime(it);
//                                it.addXp(players.get(j));
                            }

                            if (firstDamage < it.getHp() && it.getHp() > 0) {
                                it.setHp(it.getHp() - firstDamage);
//                                it.checkOvertime(players.get(j));
//                                players.get(j).addXp(it);
                            }


                            System.out.println((players.get(j).getName() + " " + players.get(j).getLevel()
                                    + " " + players.get(j).getXp() + " " + (int) players.get(j).getHp() + " "
                                    + players.get(j).getX() + " " + players.get(j).getY()));

                            System.out.println((it.getName() + " " + it.getLevel()
                                    + " " + it.getXp() + " " + (int) it.getHp() + " "
                                    + it.getX() + " " + it.getY()));

//                            System.out.println(it.getName() + " " + it.getHp());
//                            System.out.println(players.get(j).getName() + " " + players.get(j).getHp());
                        }
                    }
                }
            }

        }

        // update positions arraylist
//        for (int i = 0; i < p; ++i) {
//            for (int j = 1; j <= 2; ++j) {
//                if (j % 2 == 1) {
//                    positions.get(i).remove(1);
//                    positions.get(i).add(1, Integer.toString(players.get(i).getX()));
//                } else {
//                    positions.get(i).remove(2);
//                    positions.get(i).add(2, Integer.toString(players.get(i).getY()));
//                }
//            }
//        }

        System.out.println("*************************************");
        String filename = args[1];
        try {
            fileio.implementations.FileWriter fileWriter = new fileio.implementations.FileWriter(filename);
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
