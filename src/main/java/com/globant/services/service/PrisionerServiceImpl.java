package com.globant.services.service;

import org.springframework.stereotype.Service;

import com.globant.services.model.PrisionerException;
@Service
public class PrisionerServiceImpl implements PrisionerService  {
	private int numberOfPrisons=0;
	private int numberOfExits=0;
	private int[] startPosition= new int[2];
	private boolean exitFound;
	
	public boolean prisioner(String[] dna) throws Exception{
		
		String[][]mat=createMatriz(dna);
		mat=modifyMat(mat);
		if(have1Prison())
		{
			if(haveExit())
			{
				return havePossibleWay(mat,startPosition[0],startPosition[1],mat.length-1,mat[2].length-1) ;
			}
		}
		return false;
	}
	
	public boolean have1Prison() {
		
		return numberOfPrisons==1?true:false;
	}
	
	public boolean haveExit() {
		return numberOfExits>0?true:false;
	}
	

	@Override
	public String[][] createMatriz(String[] dna) throws Exception {
		System.out.println("Create the matriz, : ");
		if (dna.length == 0  ) {
			throw new Exception("the dna is empty");
		}
		String mat[][] = new String[dna.length][dna[1].length()];
		for (int i = 0; i < dna.length; i++) {
			if (dna[i].length() != dna.length) {
				//throw new PrisionerException("the array is not a square");
			}
			for (int j = 0; j < dna[i].length(); j++) {
				
				mat[i][j] = dna[i].substring(j,j+1);
			}
		}
		return mat;
		//  return modifyMat(mat);
	}

	@Override
	public String [][] modifyMat(String[][] mat) throws Exception {
		
		int files=mat.length;
		int columns=mat[1].length;
      System.out.println("Start modify the matriz, : "+files+" x "+columns);
		for(int i=0;i<files;i++) {
			for (int j=0;j<columns;j++) {
				if(mat[i][j].equals("P"))
				{
					numberOfPrisons++;
					startPosition[0]=i;
					startPosition[1]=j;
				}
				else if(mat[i][j].equals("S"))
					numberOfExits++;
				else if(mat[i][j].equals(">"))
				{
					if(j<columns && mat[i][j+1].equals(" "))
						mat[i][j+1]="|";
				}
				else if(mat[i][j].equals("<"))
				{
					if(j>0 && mat[i][j-1].equals(" "))
						mat[i][j-1]="|";
				}
				else if(mat[i][j].equals("^"))
				{
					if(i>0 && mat[i+1][j].equals(" "))
						mat[i+1][j]="|";
				}
				else if(mat[i][j].equals("v"))
				{
					if(i<files && mat[i-1][j].equals(" "))
						mat[i-1][j]="|";
				} 			
			}    	
		}
		if(numberOfPrisons!=1 || numberOfExits==0)
		{
			throw new PrisionerException("No valid mat");
		}
		else
		{
			//print the matriz
		for(int i=0;i<files;i++) {
			System.out.println("");
			for (int j=0;j<columns;j++) {
				System.out.print(mat[i][j]);
			}
		}
		System.out.println("Finish modify the matriz, : ");
			return mat;
		}
		
		

	}
	@Override
	public boolean havePossibleWay(String[][] mat, int positionX, int positionY,  int matYLenght, int matXLenght) {
	
		if(exitFound)
			return true;
		else if(mat[positionX][ positionY].equals("S"))
		{
			System.out.println("Se encontro la salida");
			exitFound=true;
			return true;
		}

		if((positionX+1)<=matXLenght)//Go right side
		{
			if(!mat[positionX][ positionY+1].equals("|"))
			{   
				//System.out.println("x: "+matXLenght+" y: "+ matYLenght);
//				System.out.println("Punto actual: "+ positionX+" "+ positionY);
//				System.out.println("Punto Der sig: "+ (positionX)+" "+ (positionY+1));
				mat[positionX][positionY]="|";
				havePossibleWay(mat,positionX,positionY+1,matXLenght,matYLenght);

			}
		}
		
		if((positionY+1)<=matYLenght )//Go down side
		{
			if(!mat[positionX+1][positionY].equals("|"))
			{
//				System.out.println("Punto actual: "+ positionX+" "+ positionY);
//				System.out.println("Punto abajo sig: "+ (positionX+1)+" "+ positionY);
				mat[positionX][positionY]="|";
				havePossibleWay(mat,positionX+1,positionY,matXLenght,matYLenght);
			}
		}


		if((positionY-1)>=0 )//Go up side
		{
			if(!mat[positionX-1][ positionY].equals("|"))
			{
//				System.out.println("Punto actual: "+ positionX+" "+ positionY);
//				System.out.println("Punto arriba sig: "+ (positionX-1)+" "+ (positionY));
				mat[positionX][positionY]="|";
				havePossibleWay(mat,positionX-1,positionY,matXLenght,matYLenght);

			}

		}				

		if((positionX-1)>=0 )//Go left side
		{
			if(!mat[positionX][ positionY-1].equals("|"))
			{
//				System.out.println("Punto actual: "+ positionX+" "+ positionY);
//				System.out.println("Punto izq sig: "+ (positionX)+" "+ (positionY-1));
				mat[positionX][positionY]="|";
				havePossibleWay(mat,positionX,positionY-1,matXLenght,matYLenght);

			}

		}

		return exitFound?true:false;
		//		return false;// no have solution
	}	
}
