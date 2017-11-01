import java.time.Duration;
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




   public void findAllSolutions(int noOfQueens){
       this.noOfQueens = noOfQueens;
       this.queens = new int[noOfQueens];
       Arrays.fill(queens, 99);
       if(showSolutions) {
           System.out.println("*****************************************************");

           long duration = System.currentTimeMillis();
           positionQueens(0);
           duration = System.currentTimeMillis() - 10;

           System.out.println();
           System.out.format("Queens       Solutions      Time(ms)    Solutions/ms%n" +
                           "   %3d    %,12d    %,8d          %,8d %n", noOfQueens, noOfSolutions,
                   duration, noOfSolutions/duration);
           System.out.println("******************************************************");

       }else {

           System.out.println("*****************************");
           System.out.println("Solutions for " + noOfQueens + " queens:");

           positionQueens(0);

           System.out.println();
           System.out.println();

           System.out.println("Were found in " + System.currentTimeMillis() + "ms");
           System.out.println("no of Solutions " + noOfSolutions);


           System.out.println("*****************************");
       }

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

    public void setShowSolutions(boolean showSolutions) {
        this.showSolutions = showSolutions;
    }

    private void positionQueens(int row) {

        for (int i = 0; i < noOfQueens; i++) {
            if (legal(row, i)) {
                queens[row] = i;
                if (row + 1 < noOfQueens) {
                    positionQueens(row + 1);
                    queens[row] = 99;
                } else {
                    noOfSolutions++;
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
        Solver s1 = new Solver();
        s1.setShowSolutions(false);
        s1.findAllSolutions(6);


        s1.findNoOfSolutions(4,6);
    }



    private void printSolution() {
        if(showSolutions){



        }
        else {
            System.out.println();
            for (int i = 0; i < queens.length; i++) {
                System.out.print(convert(i, queens[i]) + " ");

            }
        }
    }

    public void findNoOfSolutions(int min, int max) {
        showSolutions = true;
        for (int i = min; i <= max; i++) {
            noOfSolutions = 0;
            findAllSolutions(i);

        }
    }


    private String convert(int row, int col) {
        return String.valueOf((char)('a'+col))+(row+1);

    }


}