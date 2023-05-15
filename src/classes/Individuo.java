/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author 13636978705
 */
public class Individuo {
    private Individuo pai;
    private Individuo mae;
    private Cromossomo cm;
    private int partidas;
    private int vitorias;
    //private int status; // 0 = perdeu 1 = ganhou 2 = empatou
    private int mutacao = 100;
    
    public Individuo()
    {
        this.pai = null;
        this.mae = null;
        this.cm = new Cromossomo();
        this.partidas = 0;
        this.vitorias = 0;
    }
    
    public Individuo(Individuo pai, Individuo mae)
    {
        this.pai = pai;
        this.mae = mae;
        this.cm = new Cromossomo(this.crossover(pai, mae));
        this.partidas = 0;
        this.vitorias = 0;
    }
    
    private List<Integer> crossover(Individuo pai, Individuo mae)
        {
            Random r = new Random();
            
            List<Integer> dnaPai = pai.getCm().getDna();
            List<Integer> dnaMae = mae.getCm().getDna();
            List<Integer> dna = new ArrayList();
            
            int op, mt;
            
            
            for(int i = 0; i < pai.getCm().getNAlelos(); i++)
            {
                op = r.nextInt(2);
                
                if(op == 0)
                {
                    dna.add(dnaPai.get(i));
                }else{
                    dna.add(dnaMae.get(i));
                }
            }
            
            op = r.nextInt(pai.getCm().getNAlelos());
            
            //mutaciona um alelo
           mt = r.nextInt(100);
           if(mt < this.mutacao)
           {
               dna.set(op, r.nextInt(9));
           }
            
            
            return dna;
        }
    
    
    //----------------------GET/SET------------------------------------//

    public Individuo getPai() {
        return pai;
    }

    public void setPai(Individuo pai) {
        this.pai = pai;
    }

    public Individuo getMae() {
        return mae;
    }

    public void setMae(Individuo mae) {
        this.mae = mae;
    }

    public Cromossomo getCm() {
        return cm;
    }

    public void setCm(Cromossomo cm) {
        this.cm = cm;
    }

    public int getPartidas() {
        return partidas;
    }

    public void setPartidas(int partidas) {
        this.partidas = partidas;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getMutacao() {
        return mutacao;
    }

    public void setMutacao(int mutacao) {
        this.mutacao = mutacao;
    }
    
    
}
