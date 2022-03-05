package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.AttackHelicopter;
import com.skilldistillery.jets.entities.BomberJet;
import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Jet;

public class JetsApplication {
	
	private AirField airField = new AirField();
	private Scanner kb = new Scanner(System.in);
	
	public JetsApplication() {
		
	}

	public static void main(String[] args) {
		JetsApplication JA = new JetsApplication();
		JA.launch();
		JA.displayUserMenu();
	}
	
	private void launch() {
		try (BufferedReader br = new BufferedReader(new FileReader("jets.txt"))) {
			String line;
			JetsApplication JA = new JetsApplication();
			List<Jet> jetList = new ArrayList<>();
			while ((line = br.readLine()) != null) {
				String[] newData = new String[5];
				
				newData = line.split(",");
				
				jetList.add(JA.createJets(newData));
				
			}
			airField = new AirField(jetList);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	private void displayUserMenu() {
		boolean inMenu = false;
		
		System.out.println("Welcome to the Jets Application!");
		System.out.println();
		
		inMenu = true;
		
		while (inMenu) {
			System.out.println();
			System.out.println("===============================================================");
			System.out.println("============================ MENU =============================");
			System.out.println("===============================================================");
			System.out.println("= 1. List the fleet                                           =");
			System.out.println("= 2. Fly all the jets                                         =");
			System.out.println("= 3. View the fastest jet                                     =");
			System.out.println("= 4. View the jet with the longest range                      =");
			System.out.println("= 5. Load all of the existing Cargo Jets                      =");
			System.out.println("= 6. Initiate a dogfight with one of the existng fighter jets =");
			System.out.println("= 7. Add a jet to the fleet                                   =");
			System.out.println("= 4. Remove a jet from the fleet                              =");
			System.out.println("= 4. Exit the menu                                            =");
			System.out.println("===============================================================");
			System.out.println("=                    (Input option number)                    =");
			System.out.println("===============================================================");
			System.out.println();
			int answer = kb.nextInt();
			
			switch (answer) {
			
			case 1:
				List<Jet> jetList = airField.getJets();
				
				
				System.out.println("Printing out the entire fleet...");
				System.out.println();
				
				for (Jet jet : jetList) {
					System.out.println(jet);
				}
				
			case 2:
				
				List<Jet> jetList2 = airField.getJets();
				
				System.out.println("Flying all of the jets...");
				System.out.println();
				
				for (Jet jet : jetList2) {
					System.out.println("----------------------------");
					jet.fly();
					System.out.println();
				}
				
			case 3:
				
			case 4:
				
			case 5:
				
			case 6:
				
			case 7:
				
			case 8:
				
			case 9:
				
			}
		}
		
	}
	
	private Jet createJets(String[] newData) {
		Jet jet = null;
		
		if (newData[0].equals("AttackHelicopter")) {
			double newDouble = Double.parseDouble(newData[2]); 
			int newInt = Integer.parseInt(newData[3]);
			long newLong = Long.parseLong(newData[4]);
			
			jet = new AttackHelicopter(newData[1], newDouble, newInt, newLong);
			
		} else if (newData[0].equals("BomberJet")) {
			double newDouble = Double.parseDouble(newData[2]); 
			int newInt = Integer.parseInt(newData[3]);
			long newLong = Long.parseLong(newData[4]);
			
			jet = new BomberJet(newData[1], newDouble, newInt, newLong);

		} else if (newData[0].equals("CargoPlane")) {
			double newDouble = Double.parseDouble(newData[2]); 
			int newInt = Integer.parseInt(newData[3]);
			long newLong = Long.parseLong(newData[4]);
			
			jet = new CargoPlane(newData[1], newDouble, newInt, newLong);
			
		} else if (newData[0].equals("FighterJet")) {
			double newDouble = Double.parseDouble(newData[2]); 
			int newInt = Integer.parseInt(newData[3]);
			long newLong = Long.parseLong(newData[4]);
			
			jet = new FighterJet(newData[1], newDouble, newInt, newLong);
			
		} else {
			System.err.println("Jet type is incorrect.");
		}
		
		
		return jet;
	}

}
