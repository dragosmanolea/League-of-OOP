package main;


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

        List<heroes.Player> players = new ArrayList<>();

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
            players.add(heroes.PlayerCreator.getPlayer(hero, x, y));
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
//            System.out.println(currMove);
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
            for (heroes.Player it : players) {
                it.resetFight();
            }
            int X, Y;
            double firstDamage, secondDamage;
            for (int j = 0; j < p; ++j) {
                for (heroes.Player it : players) {
                    if (!players.get(j).equals(it)) {
                        X = players.get(j).getX();
                        Y = players.get(j).getY();
                        if (X == it.getX() && Y == it.getY()
                                && it.getFight() == false && players.get(j).getFight() == false) {

                                firstDamage = it.isAttackedBy(players.get(j), map[X][Y]);
                                it.setFight();

                                secondDamage = players.get(j).isAttackedBy(it, map[X][Y]);
                                players.get(j).setFight();

                                it.checkOvertime(players.get(j));
                                players.get(j).checkOvertime(it);

                            if (firstDamage < it.getHp()) {
                                it.setHp(it.getHp() - firstDamage);
                            }
                            if (secondDamage < players.get(j).getHp()) {
                                players.get(j).setHp((players.get(j).getHp() - secondDamage));
                            }

                            if (firstDamage >= it.getHp()) {
                                it.setHp(0);
                                players.get(j).addXp(it);
                            }

//                            System.out.println(it.getName() + " " + it.getHp());
//                            System.out.println(players.get(j).getName() + " " + players.get(j).getHp());
                        }
                    }
                }
            }
        }

        // update positions arraylist
        for (int i = 0; i < p; ++i) {
            for (int j = 1; j <= 2; ++j) {
                if (j % 2 == 1) {
                    positions.get(i).remove(1);
                    positions.get(i).add(1, Integer.toString(players.get(i).getX()));
                } else {
                    positions.get(i).remove(2);
                    positions.get(i).add(2, Integer.toString(players.get(i).getY()));
                }
            }
        }

        for (heroes.Player it : players) {
            if (it.getHp() <= 0) {
                System.out.println(it.getName() + " dead");
            } else {
                System.out.println(it.getName() + " " + it.getLevel()
                + " " + it.getXp() + " " + it.getHp() + " "
                + it.getX() + " " + it.getY());
            }
        }
    }
}
