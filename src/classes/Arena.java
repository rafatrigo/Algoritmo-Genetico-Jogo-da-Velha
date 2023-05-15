/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 13636978705
 */
public class Arena {
    private ArrayList<ArrayList<Integer>> tabuleiro;
    private ArrayList<Integer> a;
    private ArrayList<Integer> testeP1; // usado para conferir se o player 1 ganhou
    private ArrayList<Integer> testeP2; // usado para conferir se o player 2 ganhou
    
    int nVitorias;
    int nEmpates;
    
//    private int[] a = {0,0,0}; //0 1 2
//    private int[] b = {0,0,0}; //3 4 5
//    private int[] c = {0,0,0}; //6 7 8
    
    public Arena()
    {
        this.nVitorias = 0;
        this.nEmpates = 0;
        this.tabuleiro = new ArrayList<>();
        this.a = new ArrayList<>();
        this.a.add(0);
        this.a.add(0);
        this.a.add(0);

        this.tabuleiro.add((ArrayList)a.clone());
        this.tabuleiro.add((ArrayList)a.clone());
        this.tabuleiro.add((ArrayList)a.clone());
        
        this.testeP1 = new ArrayList<>();
        this.testeP1.add(1);
        this.testeP1.add(1);
        this.testeP1.add(1);
        
        this.testeP2 = new ArrayList<>();
        this.testeP2.add(2);
        this.testeP2.add(2);
        this.testeP2.add(2);

    }
    
    public void competir(Individuo p1, Individuo p2)
    {
        int fim = -1;
        int player = 1;
        
        List<Integer> dnaP1 = p1.getCm().getDna();
        List<Integer> dnaP2 = p2.getCm().getDna();
        
        int i = 0;
        int j = 1;
        int mov;
        
        do{
            if(player != 2)
            {
                mov = dnaP1.get(i);
                
                switch(mov)
                {
                    case 0:
                        
                        if(this.tabuleiro.get(0).get(0).equals(0))
                        {
                            this.tabuleiro.get(0).set(0, 1);
                            player++;
                        }
                        
                        break;
                    case 1:
                        if(this.tabuleiro.get(0).get(1).equals(0))
                        {
                            this.tabuleiro.get(0).set(1, 1);
                            player++;
                        }
                        break;
                    case 2:
                        if(this.tabuleiro.get(0).get(2).equals(0))
                        {
                            this.tabuleiro.get(0).set(2, 1);
                            player++;
                        }
                        break;
                    case 3:
                        if(this.tabuleiro.get(1).get(0).equals(0))
                        {
                            this.tabuleiro.get(1).set(0, 1);
                            player++;
                        }
                        break;
                    case 4:
                        if(this.tabuleiro.get(1).get(1).equals(0))
                        {
                            this.tabuleiro.get(1).set(1, 1);
                            player++;
                        }
                        break;
                    case 5:
                        if(this.tabuleiro.get(1).get(2).equals(0))
                        {
                            this.tabuleiro.get(1).set(2, 1);
                            player++;
                        }
                        break;
                    case 6:
                        if(this.tabuleiro.get(2).get(0).equals(0))
                        {
                            this.tabuleiro.get(2).set(0, 1);
                            player++;
                        }
                        break;
                    case 7:
                        if(this.tabuleiro.get(2).get(1).equals(0))
                        {
                            this.tabuleiro.get(2).set(1, 1);
                            player++;
                        }
                        break;
                    case 8:
                        if(this.tabuleiro.get(2).get(2).equals(0))
                        {
                            this.tabuleiro.get(2).set(2, 1);
                            player++;
                        }
                        break;
                }
                
               i+=2;
            }else{
                mov = dnaP2.get(j);
                
                switch(mov)
                {
                    case 0:
                        
                        if(this.tabuleiro.get(0).get(0).equals(0))
                        {
                            this.tabuleiro.get(0).set(0, 2);
                            player--;
                        }
                        
                        break;
                    case 1:
                        if(this.tabuleiro.get(0).get(1).equals(0))
                        {
                            this.tabuleiro.get(0).set(1, 2);
                            player--;
                        }
                        break;
                    case 2:
                        if(this.tabuleiro.get(0).get(2).equals(0))
                        {
                            this.tabuleiro.get(0).set(2, 2);
                            player--;
                        }
                        break;
                    case 3:
                        if(this.tabuleiro.get(1).get(0).equals(0))
                        {
                            this.tabuleiro.get(1).set(0, 2);
                            player--;
                        }
                        break;
                    case 4:
                        if(this.tabuleiro.get(1).get(1).equals(0))
                        {
                            this.tabuleiro.get(1).set(1, 2);
                            player--;
                        }
                        break;
                    case 5:
                        if(this.tabuleiro.get(1).get(2).equals(0))
                        {
                            this.tabuleiro.get(1).set(2, 2);
                            player--;
                        }
                        break;
                    case 6:
                        if(this.tabuleiro.get(2).get(0).equals(0))
                        {
                            this.tabuleiro.get(2).set(0, 2);
                            player--;
                        }
                        break;
                    case 7:
                        if(this.tabuleiro.get(2).get(1).equals(0))
                        {
                            this.tabuleiro.get(2).set(1, 2);
                            player--;
                        }
                        break;
                    case 8:
                        if(this.tabuleiro.get(2).get(2).equals(0))
                        {
                            this.tabuleiro.get(2).set(2, 2);
                            player--;
                        }
                        break;
                }
                j+=2;
            }
            fim = ganhou();
            
            if(fim == 1)
            {
                p1.setVitorias(p1.getVitorias()+1);
                p2.setVitorias(p2.getVitorias()-1);
                this.nVitorias++;
            }else if(fim == 2)
            {
                p2.setVitorias(p2.getVitorias()+1);
                p1.setVitorias(p1.getVitorias()-1);
                this.nVitorias++;
            }else if(fim == 0)
            {
                this.nEmpates++;
                fim = -1;
            }
            
        }while(fim == -1 && i < p1.getCm().getNAlelos() && j < p2.getCm().getNAlelos() - 1);
        this.clear();
    }
    
    // 0 = empate | 1= p1 ganhou | 2= p2 ganhou | -1= niguem ganhou
    public int ganhou(){
        if(
                this.tabuleiro.get(0).equals(this.testeP1)
                ||
                this.tabuleiro.get(1).equals(this.testeP1)
                ||
                this.tabuleiro.get(2).equals(this.testeP1)
                ||
                this.tabuleiro.get(0).get(0).equals(1) && this.tabuleiro.get(1).get(0).equals(1) && this.tabuleiro.get(2).get(0).equals(1)
                ||
                this.tabuleiro.get(0).get(1).equals(1) && this.tabuleiro.get(1).get(1).equals(1) && this.tabuleiro.get(2).get(1).equals(1)
                ||
                this.tabuleiro.get(0).get(2).equals(1) && this.tabuleiro.get(1).get(2).equals(1) && this.tabuleiro.get(2).get(2).equals(1)
                ||
                this.tabuleiro.get(0).get(0).equals(1) && this.tabuleiro.get(1).get(1).equals(1) && this.tabuleiro.get(2).get(2).equals(1)
                ||
                this.tabuleiro.get(0).get(2).equals(1) && this.tabuleiro.get(1).get(1).equals(1) && this.tabuleiro.get(2).get(0).equals(1)
                
                )
        {
            return 1;
        }else if(
                this.tabuleiro.get(0).equals(this.testeP2)
                ||
                this.tabuleiro.get(1).equals(this.testeP2)
                ||
                this.tabuleiro.get(2).equals(this.testeP2)
                ||
                this.tabuleiro.get(0).get(0).equals(2) && this.tabuleiro.get(1).get(0).equals(2) && this.tabuleiro.get(2).get(0).equals(2)
                ||
                this.tabuleiro.get(0).get(1).equals(2) && this.tabuleiro.get(1).get(1).equals(2) && this.tabuleiro.get(2).get(1).equals(2)
                ||
                this.tabuleiro.get(0).get(2).equals(2) && this.tabuleiro.get(1).get(2).equals(2) && this.tabuleiro.get(2).get(2).equals(2)
                ||
                this.tabuleiro.get(0).get(0).equals(2) && this.tabuleiro.get(1).get(1).equals(2) && this.tabuleiro.get(2).get(2).equals(2)
                ||
                this.tabuleiro.get(0).get(2).equals(2) && this.tabuleiro.get(1).get(1).equals(2) && this.tabuleiro.get(2).get(0).equals(2)
                
                )
        {
            return 2;
        }else if(
                !this.tabuleiro.get(0).get(0).equals(0) && !this.tabuleiro.get(0).get(1).equals(0) && !this.tabuleiro.get(0).get(2).equals(0)
                &&
                !this.tabuleiro.get(1).get(0).equals(0) && !this.tabuleiro.get(1).get(1).equals(0) && !this.tabuleiro.get(1).get(2).equals(0)
                &&
                !this.tabuleiro.get(2).get(0).equals(0) && !this.tabuleiro.get(2).get(1).equals(0) && !this.tabuleiro.get(2).get(2).equals(0)
                ){
            return 0;
        }else{
            return 7;
        }
            
        
    }
    
    public void clear()
    {
        this.tabuleiro.set(0, (ArrayList)this.a.clone());
        this.tabuleiro.set(1,(ArrayList)this.a.clone());
        this.tabuleiro.set(2,(ArrayList)this.a.clone());
    }
    
    public int getNVitorias()
    {
        return this.nVitorias;
    }
    
    public void setNVitorias(int n)
    {
        this.nVitorias = n;
    }
    
    public int getNEmpates()
    {
        return this.nEmpates;
    }
    
    public void setNEmpates(int n)
    {
        this.nEmpates = n;
    }

}
