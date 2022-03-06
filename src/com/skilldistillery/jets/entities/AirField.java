package com.skilldistillery.jets.entities;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AirField {
	private List<Jet> jets = new ArrayList<>();
	
	// Constructor takes in List<Jet> and assigns it to it's own.
	
	public AirField() {
		super();
	}
	
	public AirField(List<Jet> newJets) {
		this.jets = newJets;
	}
	
	// Adds a Jet to the Jet List and pushes the List to the jets.txt file.
	
	public void addJet(Jet newJet) {
		jets.add(newJet);
		
		AirField AF = new AirField();
		AF.pushJet(this.jets);
	}
	
	public List<Jet> getJets() {
		return jets;
	}
	
	// Removes a Jet from the Jet List and pushes the List to the jets.txt file.
	
	public void removeJet(int index) {
		jets.remove(index-1);
		
		AirField AF = new AirField();
		AF.pushJet(this.jets);
	}
	
	// pushJet sends the current Jet List and sends the create() class of each Jet into each line of the text file.
	
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
