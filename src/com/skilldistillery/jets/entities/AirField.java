package com.skilldistillery.jets.entities;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AirField {
	private List<Jet> jets = new ArrayList<>();
	
	public AirField() {
		
	}
	
	public AirField(List<Jet> newJets) {
		this.jets = newJets;
	}
	
	public void addJet(Jet newJet) {
		jets.add(newJet);
		
		AirField AF = new AirField();
		AF.pushJet(this.jets);
	}
	
	public List getJets() {
		return jets;
	}
	
	public void removeJets() {
		
	}
	
	public void pushJet(List<Jet> jets1) {
		try (PrintWriter pw = new PrintWriter(new FileWriter("jets.txt"))){
			
			
			for (Jet jet : jets1) {
				pw.println(jet.create());
			}
			
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
