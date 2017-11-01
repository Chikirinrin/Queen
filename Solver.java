import java.util.*;
import java.lang.*;

/**
 * Write a description of class Solver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Solver
{
    // instance varables - replace the example below with your own
    public int noOfQueens;
    private int[] queens;
    private int noOfSolutions;
    private boolean showSolutions; // styrer om løsningerne udskrives på terminalen
    private long duration;

    /**
     * Constructor for objects of class Solver
     */
    public Solver(int noOfQueens)
    {
        this.noOfQueens = noOfQueens;
        this.queens = new int[noOfQueens];
        this.noOfSolutions = noOfSolutions;
        Arrays.fill(queens, 99);
        this.duration = duration;

    }

   public void findAllSolutions(int noOfQueens){
        /*System.out.format("   %3d  %,12d     %,8d     %,8d %n", noOfQueens, noOfSolutions,
                duration, noOfSoultions/duration);*/
       System.out.println("*****************************");
       System.out.println("Solutions for " + noOfQueens + " queens:");

       positionQueens(0);

       System.out.println();
       System.out.println();
       duration = System.currentTimeMillis();
       System.out.println("Were found in " + System.currentTimeMillis() + "s");
       System.out.println("*****************************");

    }

    public void testLegal() {
        queens = new int[]{4, 6, 3, 0, 0, 0, 0, 0};
        System.out.println("Queens in: " + Arrays.toString(queens) + " => Legal positions: ");
        for (int i = 0; i < 8; i++) {
            if (legal(3, i)) {
                System.out.println(i + " ");
            }
            System.out.println();
        }
    }


    private void positionQueens(int row) {
        for (int i = 0; i < noOfQueens; i++) {
            if (legal(row, i)) {
                queens[row] = i;
                if (row + 1 < noOfQueens) {
                    positionQueens(row + 1);
                    queens[row] = 99;
                } else {
                    printSolution();
                    queens[row] = 99;
                }
            } else {
                queens[row] = 99;
            }
        }
    }

    private boolean legal(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || queens[i] - col == row - i ||  col - queens[i] == row - i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solver s1 = new Solver(14);
       // s1.findAllSolutions(14);
        s1.findNoOfSolutions(7,9);
    }



    private void printSolution() {

       System.out.println();
        for(int i = 0; i< queens.length; i++){
                System.out.print(convert(i, queens[i]) + " ");

        }
    }

    public void findNoOfSolutions(int min, int max){

       findAllSolutions(max-min);
    }

    private String convert(int row, int col) {
        return String.valueOf((char)('a'+col))+(row+1);

    }


}