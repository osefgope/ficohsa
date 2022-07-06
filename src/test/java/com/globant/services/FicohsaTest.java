package com.globant.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.globant.services.service.PrisionerServiceImpl;

class FicohsaTest {
	@Autowired
	PrisionerServiceImpl prision = new PrisionerServiceImpl();
		
@Test
	void wallsAround() throws Exception {
	String[]dna=new String[]{"||||||S||","|| ||P| |","||  | | |","|v| | < |","| |   | |","|   |   |","||||||||X"};

		assertFalse(prision.prisioner(dna));
	}
	@Test
	void findSolutionIn() throws Exception {
		String[]dna=new String[]{"||||||S||","|| ||P  |","||  | | |","|v| | < |","| |   | |","|   |   |","||||||||X"};
		assertTrue(prision.prisioner(dna));
	}
	
	@Test
	void have1Prision() {
		assertFalse(prision.have1Prison());
	}
	@Test
	void haveAExit() {
		assertFalse(prision.haveExit());	
	}
	
	@Test
	void inMiidleDoorSolution() throws Exception {
		String[]dna=new String[]{"||||||S||","|| ||   |","||  | | |","|v| | < |","| |   | |","|P  |   |","||||||||X"};
		//String[]dna=new String[]{"|||||||||","|P ||   |","||  | | |","|v| | < |","|| |S  ||","|   |   |","||||||||X"};
		assertTrue(prision.prisioner(dna));
	}
	@Test
	void exitInRight() throws Exception {
		String[]dna=new String[]{"|||||||||","|PS||   |","||  | | |","|v| | < |","| |   | |","|   |   |","|||||||||"};
		assertTrue(prision.prisioner(dna));
	}
	@Test
	void findSolutionExample() throws Exception {
		String[]dna=new String[]{"||||||S||","|P ||   |","||  | | |","|v| | < |","| |   | |","|   |   |","||||||||X"};
		assertTrue(prision.prisioner(dna));
	}
	@Test
	void findSolutionIn15() throws Exception {
		String[]dna=new String[]{"||||||S||","|| ||P  |","||  | | |","|v| | < |","| |   | |","|   |   |","||||||||X"};
		assertTrue(prision.prisioner(dna));
	}

}
