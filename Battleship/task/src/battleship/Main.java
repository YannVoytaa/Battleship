package battleship;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void Enter() {
        System.out.println("Press Enter and pass the move to another player");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        player1.placeShips();
        Enter();
        player2.placeShips();
        Enter();
        boolean turn1 = true;
        while (true) {
            if (turn1) {
                player2.showBoard(true);
                System.out.println("---------------------");
                player1.showBoard(false);
                System.out.println("Player 1, it's your turn:");
                player2.takeShot();
                if (player2.lost()) break;
                Enter();
            } else {
                player1.showBoard(true);
                System.out.println("---------------------");
                player2.showBoard(false);
                System.out.println("Player 2, it's your turn:");
                player1.takeShot();
                if (player1.lost()) break;
                Enter();
            }
            turn1 = !turn1;
        }
        System.out.println("You sank the last ship. You won. Congratulations!");
    }
}

class Player {
    public static Scanner scanner = new Scanner(System.in);
    char[][] board;
    int id;

    public Player(int id) {
        this.id = id;
        this.board = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = '~';
            }
        }
    }

    private boolean all_hit(int x, int y, int dirx, int diry) {
        if (x < 0 || x > 9 || y < 0 || y > 9) return true;
        if (board[x][y] == 'X') return all_hit(x + dirx, y + diry, dirx, diry);
        else if (board[x][y] == 'O') return false;
        else /* (board[x][y] == '~' || board[x][y] == 'M') */ return true;
    }

    public boolean wholeShip(int x, int y) {
        return (all_hit(x, y, 1, 0) && all_hit(x, y, -1, 0) && all_hit(x, y, 0, 1) && all_hit(x, y, 0, -1));
    }

    public void takeShot() {
        System.out.println("Take a shot!");
        String point;
        int[] pt = new int[2];
        do {
            point = scanner.next();
            convert(point, pt);
            if (pt[0] == -1) System.out.println("Error! You entered the wrong coordinates!");
            else {
                if (board[pt[0]][pt[1]] == 'O') {
                    board[pt[0]][pt[1]] = 'X';
                    if (wholeShip(pt[0], pt[1])) System.out.println("You sank a ship!");
                    else System.out.println("You hit a ship!");
                } else if (board[pt[0]][pt[1]] == '~') {
                    board[pt[0]][pt[1]] = 'M';
                    System.out.println("You missed!");
                }
                break;
            }
        } while (true);
    }

    public void showBoard(boolean covered) {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < 10; i++) {
            System.out.print((char) ('A' + i));
            System.out.print(' ');
            for (int j = 0; j < 10; j++) {
                if (covered && board[i][j] == 'O') System.out.print("~ ");
                else System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean lost() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == 'O') return false;
            }
        }
        return true;
    }

    private boolean taken(int x, int y) {
        if (x < 0 || x > 9 || y < 0 || y > 9) return false;
        else if (board[x][y] == '~') return false;
        else return true;
    }

    private boolean close(int x, int y) {
        return taken(x - 1, y - 1) || taken(x - 1, y) || taken(x - 1, y + 1) || taken(x, y - 1) ||
                taken(x, y) || taken(x, y + 1) || taken(x + 1, y - 1) || taken(x + 1, y) || taken(x + 1, y + 1);
    }

    private void convert(String s, int[] arr) {
        if (s.length() < 2 || s.length() > 3) {
            arr[0] = -1;
        } else {
            if (s.charAt(0) >= 'A' && s.charAt(0) <= 'J') arr[0] = s.charAt(0) - 'A';
            else arr[0] = -1;
            if (s.length() == 3 && s.charAt(1) == '1' && s.charAt(2) == '0') arr[1] = 9;
            else if (s.length() == 2 && s.charAt(1) >= '1' && s.charAt(1) <= '9') arr[1] = s.charAt(1) - '1';
            else arr[0] = -1;
        }
    }

    private boolean isProperAndAvailable(int[] start, int[] end, int size) {
        if (start[0] == end[0]) {
            if (Math.abs(start[1] - end[1]) + 1 == size) {
                for (int i = Math.min(start[1], end[1]); i <= Math.max(start[1], end[1]); i++) {
                    if (close(start[0], i)) {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        return false;
                    }
                }
                for (int i = Math.min(start[1], end[1]); i <= Math.max(start[1], end[1]); i++) {
                    board[start[0]][i] = 'O';
                }
                return true;
            } else {
                System.out.println("Error! Wrong length! Try again:");
                return false;
            }
        } else if (start[1] == end[1]) {
            if (Math.abs(start[0] - end[0]) + 1 == size) {
                for (int i = Math.min(start[0], end[0]); i <= Math.max(start[0], end[0]); i++) {
                    if (close(i, start[1])) {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        return false;
                    }
                }
                for (int i = Math.min(start[0], end[0]); i <= Math.max(start[0], end[0]); i++) {
                    board[i][start[1]] = 'O';
                }
                return true;
            } else {
                System.out.println("Error! Wrong length! Try again:");
                return false;
            }
        } else {
            System.out.println("Error! Wrong ship location! Try again:");
            return false;
        }
    }

    private void place(String name, int size) {
        System.out.printf("Enter the coordinates of the %s (%d cells):", name, size);
        String start, end;
        int[] begin = new int[2];
        int[] finish = new int[2];
        do {
            start = scanner.next();
            end = scanner.next();
            convert(start, begin);
            convert(end, finish);
            if (begin[0] == -1 || finish[0] == -1) System.out.println("Error! Wrong input! Try again:");
            else if (isProperAndAvailable(begin, finish, size)) break;
        } while (true);
        showBoard(false);
    }

    public void placeShips() {
        System.out.println("Player " + id + ", place your ships on the game field");
        showBoard(false);
        place("Aircraft Carrier", 5);
        place("Battleship", 4);
        place("Submarine", 3);
        place("Cruiser", 3);
        place("Destroyer", 2);
    }
}