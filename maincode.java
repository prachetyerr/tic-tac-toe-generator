import java.util.Scanner;

public class TicTacToe {
  static Scanner sc = new Scanner(System.in);
  static char[][] b = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
  static boolean x = true;

  public static void main(String[] args) {
    while (true) {
      display();
      System.out.println((x ? "X" : "O") + " turn. Enter row and column:");
      int r = sc.nextInt() - 1, c = sc.nextInt() - 1;
      if (b[r][c] != ' ') {
        System.out.println("Space occupied. Try again.");
        continue;
      }
      b[r][c] = x ? 'X' : 'O';
      if (win(r, c)) {
        System.out.println((x ? "X" : "O") + " wins!");
        break;
      }
      if (draw()) {
        System.out.println("Draw.");
        break;
      }
      x = !x;
    }}

  static void display() {
    System.out.println("\n" + b[0][0] + "|" + b[0][1] + "|" + b[0][2]);
    System.out.println("-+-+-");
    System.out.println(b[1][0] + "|" + b[1][1] + "|" + b[1][2]);
    System.out.println("-+-+-");
    System.out.println(b[2][0] + "|" + b[2][1] + "|" + b[2][2] + "\n");
  }

  static boolean win(int r, int c) {
    return (b[0][c] == b[1][c] && b[1][c] == b[2][c]) ||
           (b[r][0] == b[r][1] && b[r][1] == b[r][2]) ||
           (b[0][0] == b[1][1] && b[1][1] == b[2][2] && r == c) ||
           (b[0][2] == b[1][1] && b[1][1] == b[2][0] && r + c == 2);
  }

  static boolean draw() {
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 3; j++)
        if (b[i][j] == ' ')
          return false;
    return true;
  }}
