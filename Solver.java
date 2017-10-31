import java.util.*;

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

    /**
     * Constructor for objects of class Solver
     */
    public Solver(int noOfQueens)
    {
        this.noOfQueens = noOfQueens;
        this.queens = new int[noOfQueens];
        this.noOfSolutions = noOfSolutions;
    }

    public void findAllSolutions(int noOfQuuens){


    }

    public void testLegal(){
        queens = new int[] {4,6,3,0,0,0,0,0};
        System.out.println("Queens in: "+ Arrays.toString(queens)+" => Legal positions: ");
        for(int i=0;i<8;i++){
            if(legal(3,i)){
                System.out.println(i+" ");
            }
            System.out.println();
        }


    //private void positionQueens(int row){


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
        Solver s1 = new Solver(8);
        s1.testLegal();
    }

    }

    //private void printSolution(){




    //private String convert(int row, int col){





