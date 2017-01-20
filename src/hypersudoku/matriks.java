/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hypersudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Johan
 */
public class matriks {
    
    //atribut
    int [][] Matriks = new int [9][9];
	
    public int count =0;
    
    void isimatriks()
	{
            try{
                int i, j;
                
                Scanner in = new Scanner (new File ("sudoku.txt"));
		for (i=0; i<9; i++)
		{
			for (j=0; j<9; j++)
			{
				if(in.hasNextInt()){
					this.Matriks[i][j] = in.nextInt();
				}
			}
		}
		in.close();
            }
            catch (FileNotFoundException ex) {
                System.err.println("Error FNF" + ex.getMessage());
            }
            catch (IOException ex) {
                System.err.println("Error IO" + ex.getMessage());
            }
	}
    
    void printmatriks()
	{
		int i, j;
		
		System.out.println("+-----+-----+-----+");
		for(i=0; i<9; i++)
		{
			for(j=0; j<9; j++)
			{
				System.out.print("|" + Matriks[i][j]);
                                
                        }
                        System.out.println("|");
                        if (i%3 == 2) System.out.println("+-----+-----+-----+");
		}
	}
    
    public boolean isfilled (memory m)
    {
        for (int i=0; i<9; i++)
        {
            for (int j=0; j<9; j++)
            {
                if (Matriks[i][j] == 0)
                {
                    m.brs = i;
                    m.kol = j;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean cekbrs (int brs, int nilai)
    //mengecek apakah dalam satu baris terdapat angka yang sama dengan nilai yang akan diassign
        {
            int j; //kolom
            for (j=0; j<9; j++)
            {
                if (this.Matriks[brs][j] == nilai){
                    return false;
                }
                
            }
            return true;            
        }
        
    public boolean cekkol (int kol, int nilai)
    //mengecek apakah dalam satu kolom terdapat angka yang sama dengan nilai yang akan diassign
    {
        int i; //baris
   
        for(i=0; i<9; i++)
        {
            if (this.Matriks[i][kol] == nilai){
                return false;
            }
        }
        return true;
    }
        
    int nokotak(int brs, int kol)
        {
            if (brs>=0 && brs<9 && kol>=0 && kol<9)
            {
                if (brs>=0 && brs <3 && kol >= 0 && kol <3)
                    return 1;
                if (brs>=0 && brs <3 && kol >= 3 && kol <6)
                    return 2;
                if (brs>=0 && brs <3 && kol >= 6 && kol <9)
                    return 3;
                if (brs>=3 && brs <6 && kol >= 0 && kol <3)
                    return 4;
                if (brs>=3 && brs <6 && kol >= 3 && kol <6)
                    return 5;
                if (brs>=3 && brs <6 && kol >= 6 && kol <9)
                    return 6;
                if (brs>=6 && brs <9 && kol >= 0 && kol <3)
                    return 7;
                if (brs>=6 && brs <9 && kol >= 3 && kol <6)
                    return 8;
                if (brs>=6 && brs <9 && kol >= 6 && kol <9)
                    return 9;
            }
            return 0;
        }
        
        boolean cekbox (int nokotak, int nilai)
        {
            switch (nokotak) { 
                    case 0 : System.out.println("Error kotak");
                    case 1 : return this.Matriks[0][0] != nilai && this.Matriks[0][1] != nilai && this.Matriks[0][2] != nilai &&
                this.Matriks[1][0] != nilai && this.Matriks[1][1] != nilai && this.Matriks[1][2] != nilai &&
                this.Matriks[2][0] != nilai && this.Matriks[2][1] != nilai && this.Matriks[2][2] != nilai;
                    case 2 : return this.Matriks[0][3] != nilai && this.Matriks[0][4] != nilai && this.Matriks[0][5] != nilai &&
                this.Matriks[1][3] != nilai && this.Matriks[1][4] != nilai && this.Matriks[1][5] != nilai &&
                this.Matriks[2][3] != nilai && this.Matriks[2][4] != nilai && this.Matriks[2][5] != nilai;
                    case 3 : return this.Matriks[0][6] != nilai && this.Matriks[0][7] != nilai && this.Matriks[0][8] != nilai &&
                this.Matriks[1][6] != nilai && this.Matriks[1][7] != nilai && this.Matriks[1][8] != nilai &&
                this.Matriks[2][6] != nilai && this.Matriks[2][7] != nilai && this.Matriks[2][8] != nilai;
                    case 4: return this.Matriks[3][0] != nilai && this.Matriks[3][1] != nilai && this.Matriks[3][2] != nilai &&
                this.Matriks[4][0] != nilai && this.Matriks[4][1] != nilai && this.Matriks[4][2] != nilai &&
                this.Matriks[5][0] != nilai && this.Matriks[5][1] != nilai && this.Matriks[5][2] != nilai;
                    case 5 : return this.Matriks[3][3] != nilai && this.Matriks[3][4] != nilai && this.Matriks[3][5] != nilai &&
                this.Matriks[4][3] != nilai && this.Matriks[4][4] != nilai && this.Matriks[4][5] != nilai &&
                this.Matriks[5][3] != nilai && this.Matriks[5][4] != nilai && this.Matriks[5][5] != nilai;
                    case 6 : return this.Matriks[3][6] != nilai && this.Matriks[3][7] != nilai && this.Matriks[3][8] != nilai &&
                this.Matriks[4][7] != nilai && this.Matriks[4][7] != nilai && this.Matriks[4][8] != nilai &&
                this.Matriks[5][7] != nilai && this.Matriks[5][7] != nilai && this.Matriks[5][8] != nilai;
                    case 7 : return this.Matriks[6][0] != nilai && this.Matriks[6][1] != nilai && this.Matriks[6][2] != nilai &&
                this.Matriks[7][0] != nilai && this.Matriks[7][1] != nilai && this.Matriks[7][2] != nilai &&
                this.Matriks[8][0] != nilai && this.Matriks[8][1] != nilai && this.Matriks[8][2] != nilai;
                    case 8 : return this.Matriks[6][3] != nilai && this.Matriks[6][4] != nilai && this.Matriks[6][5] != nilai &&
                this.Matriks[7][3] != nilai && this.Matriks[7][4] != nilai && this.Matriks[7][5] != nilai &&
                this.Matriks[8][3] != nilai && this.Matriks[8][4] != nilai && this.Matriks[8][5] != nilai;
                    case 9 : return this.Matriks[6][6] != nilai && this.Matriks[6][7] != nilai && this.Matriks[6][8] != nilai &&
                this.Matriks[7][6] != nilai && this.Matriks[7][7] != nilai && this.Matriks[7][8] != nilai &&
                this.Matriks[8][6] != nilai && this.Matriks[8][7] != nilai && this.Matriks[8][8] != nilai;
                    default: return false;
            }
        }
        
    int nokotakhyper(int brs, int kol)
    {
        if (brs>=1 && brs <4 && kol >= 1 && kol <4)
            return 1;
        if (brs>=1 && brs <4 && kol >= 5 && kol <8)
            return 2;
        if (brs>=5 && brs <8 && kol >= 1 && kol <4)
            return 3;
        if (brs>=5 && brs <8 && kol >= 1 && kol <4)
            return 4;
        else return 0;
    }
    
    public boolean cekhyper (int nokotakhyper, int nilai)
    //mengecek apakah dalam satu kotak 3x3 hyper terdapat angka yang sama dengan nilai yang akan diassign
    {
         switch (nokotakhyper) { 
                    case 0 : return true;
                    case 1 : return this.Matriks[1][1] != nilai && this.Matriks[1][2] != nilai && this.Matriks[1][3] != nilai &&
                this.Matriks[2][1] != nilai && this.Matriks[2][2] != nilai && this.Matriks[2][3] != nilai &&
                this.Matriks[3][1] != nilai && this.Matriks[3][2] != nilai && this.Matriks[3][3] != nilai;
                    case 2 : return this.Matriks[1][5] != nilai && this.Matriks[1][6] != nilai && this.Matriks[1][7] != nilai &&
                this.Matriks[2][5] != nilai && this.Matriks[2][6] != nilai && this.Matriks[2][7] != nilai &&
                this.Matriks[3][5] != nilai && this.Matriks[3][6] != nilai && this.Matriks[3][7] != nilai;
                    case 3 : return this.Matriks[5][1] != nilai && this.Matriks[5][2] != nilai && this.Matriks[5][3] != nilai &&
                this.Matriks[6][1] != nilai && this.Matriks[6][2] != nilai && this.Matriks[6][3] != nilai &&
                this.Matriks[7][1] != nilai && this.Matriks[7][2] != nilai && this.Matriks[7][3] != nilai;
                    case 4: return this.Matriks[5][5] != nilai && this.Matriks[5][6] != nilai && this.Matriks[5][7] != nilai &&
                this.Matriks[6][5] != nilai && this.Matriks[6][7] != nilai && this.Matriks[6][7] != nilai &&
                this.Matriks[7][5] != nilai && this.Matriks[7][7] != nilai && this.Matriks[7][7] != nilai;
                    default : return true;
         }    
    }
      
    public boolean ceksemua(int brs, int kol, int nilai)
    //mengecek apakah suatu nilai mungkin dimasukkan ke dalam matriks ke brs dan kol
    {
        return (cekbrs (brs, nilai) && cekkol(kol, nilai) && cekbox(nokotak(brs-brs%3, kol-kol%3), nilai) && cekhyper(nokotakhyper(brs, kol), nilai));
    }
    
    public boolean solve()
    {
        memory m = new memory(0,0);
        int brs, kol, nilai;
        
        if (!isfilled(m))
            return true;
        
        for (nilai=1; nilai <= 9; nilai++)
        {
            count++;
            if (ceksemua(m.brs, m.kol, nilai))
            {
                
                Matriks[m.brs][m.kol] = nilai;
                if (solve())
                    return true;
                Matriks[m.brs][m.kol] = 0;
                
            }
        }
        return false;
    }
}
