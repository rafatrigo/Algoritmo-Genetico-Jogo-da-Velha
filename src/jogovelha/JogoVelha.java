/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jogovelha;

import classes.Arena;
import classes.Individuo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafatrigo
 */
public class JogoVelha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double startTime = System.nanoTime();
        
        int nIndividuos = 100;
	int geracao = 0;
        
        Arena arena = new Arena();
        
        List<Individuo> populacao = new ArrayList<>();
	List<Individuo> melhores = new ArrayList<>();
        
        //cria primeira geracao
        for(int i = 0; i < nIndividuos; i++)
	{
            Individuo n = new Individuo();
			
            populacao.add(n);
	}
        
        
        do{
            
            //faz a populacao competir entre si
            for(int i = 0;i < nIndividuos; i++)
            {
                for(int j = 0; j < nIndividuos; j++)
                {
                    arena.competir(populacao.get(i), populacao.get(j));
                }
            }
            
            //ordena do melhor para o pior
            do {
				
		int indexMelhor = 0;
				
		for(int i = 0; i < populacao.size(); i++)
		{
                    if(populacao.get(indexMelhor).getVitorias() < populacao.get(i).getVitorias())
			{
                            indexMelhor = i;
			}
					
		}
		melhores.add(populacao.get(indexMelhor));
		populacao.remove(indexMelhor);
				
            }while(!populacao.isEmpty());
            
            
            //adiciona os 50% melhores a nova populacao
            for(int i = 0; i < nIndividuos/2; i++)
            {
		populacao.add(melhores.get(i));
            }
            
            //reproducao
            for(int i = 0; i <= nIndividuos - 1; i = i + 2)
            {
				
		Individuo pai = melhores.get(i);
		Individuo mae = melhores.get(i+1);
				
		Individuo n = new Individuo(pai, mae);
				
		populacao.add(n);
				
            }
            
            melhores.clear();
            
            System.out.println("-----GERACAO " + geracao + "-------");
            System.out.println("Vitorias: " + arena.getNVitorias());
            System.out.println("Empates: " + arena.getNEmpates());
            System.out.println("Partidas indefinidas: " + (arena.getNVitorias() + arena.getNEmpates() - nIndividuos));
            
            
            geracao++;
        }while(geracao < 300);
        
        
        
        double endTime = System.nanoTime();
        System.out.println("Tempo de execussao: " + (endTime - startTime)/1000000000);
    }
    
}
