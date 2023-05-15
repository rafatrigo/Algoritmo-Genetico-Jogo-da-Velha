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
 * @author rafatrigo
 */
public class Cromossomo {
    private  int nAlelos = 50;
    private List<Integer> dna;
	
	private void geraDna()
	{
		Random gerador = new Random();
		
		for(int i = 0; i < this.nAlelos; i++)
		{
			int alelo = gerador.nextInt(9); //gera um numero aleatorio entre 0 e 9
			
			this.dna.add(alelo);
		}
	}
	
	
	public Cromossomo()
	{
		this.dna = new ArrayList<>(nAlelos);
		
		this.geraDna();
	}
	
	public Cromossomo(List<Integer> dna)
	{
		this.dna = new ArrayList<>(nAlelos);
		
		this.setDna(dna);
	}
	
	public int getNAlelos()
	{
		return this.nAlelos;
	}
	
	public void setNAlelos(int n)
	{
		this.nAlelos = n;
	}
	
	public List<Integer> getDna()
	{
		return this.dna;
	}
	
	public void setDna(List<Integer> dna)
	{
		this.dna = dna;
	}
}
