package com.skilldistillery.jets.entities;

import java.util.ArrayList;
import java.util.List;

public class AirField {
	private List<Jet> jets = new ArrayList<>();
	
	public AirField() {
		
	}
	
	public AirField(List<Jet> newJets) {
		this.jets = newJets;
	}
	
	public void addJet() {
		
	}
	
	public List getJets() {
		return jets;
	}
	
	public void removeJets() {
		
	}
}
