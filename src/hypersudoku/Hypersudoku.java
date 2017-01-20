/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hypersudoku;

/**
 *
 * @author Johan
 */
public class Hypersudoku {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        matriks solver = new matriks();
        
        solver.isimatriks();
        System.out.println("sudoku awal : ");
        solver.printmatriks();
        
        long start = System.nanoTime();
        if (solver.solve())
        {
            System.out.println("Jawaban :");
            solver.printmatriks();
            System.out.println("Total Assignment :" + solver.count);
        }
        else
        {
            System.out.println("Tidak ada solusi");
        }
        
        long end = System.nanoTime();
        long duration = (end-start)/1000000;
        
        System.out.println("Waktu Eksekusi " + duration + " ms");
    }
    
}
