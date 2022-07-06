package com.globant.services.service;

public interface PrisionerService {
	    public String[][] modifyMat(String[][] mat)throws Exception;
	    public String[][] createMatriz(String[] dna) throws Exception;    
	    public boolean havePossibleWay(String[][] mat,int positionX, int positionY,int matXLenght, int matYLenght);
	}

