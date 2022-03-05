package com.skilldistillery.jets.app;

import java.io.*;
import java.util.*;

import com.skilldistillery.jets.entities.*;

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
			System.out.println("================================================================");
			System.out.println("============================= MENU =============================");
			System.out.println("================================================================");
			System.out.println("= 1. List the fleet                                            =");
			System.out.println("= 2. Fly all the jets                                          =");
			System.out.println("= 3. View the fastest jet                                      =");
			System.out.println("= 4. View the jet with the longest range                       =");
			System.out.println("= 5. Load all of the existing Cargo Jets                       =");
			System.out.println("= 6. Initiate a dogfight with one of the existing combat jets  =");
			System.out.println("= 7. Add a jet to the fleet                                    =");
			System.out.println("= 8. Remove a jet from the fleet                               =");
			System.out.println("= 9. Exit the menu                                             =");
			System.out.println("================================================================");
			System.out.println("=                    (Input option number)                     =");
			System.out.println("================================================================");
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
				
				break;
				
			case 2:
				
				List<Jet> jetList2 = airField.getJets();
				
				System.out.println("Flying all of the jets...");
				System.out.println();
				
				for (Jet jet : jetList2) {
					System.out.println("----------------------------");
					jet.fly();
					System.out.println();
				}
				
				break;
				
			case 3:
				
				List<Jet> jetList3 = airField.getJets();
				
				System.out.println("Finding the fastest jet...");
				System.out.println();
				
				Jet fastest = jetList3.get(0);
				
				for (Jet jet : jetList3) {
					if (jet.getSpeed() > fastest.getSpeed()) {
						fastest = jet;
					}
				}
				
				System.out.println("The fastest jet: ");
				System.out.println(fastest);
				
				break;
				
			case 4:
				
				List<Jet> jetList4 = airField.getJets();
				
				System.out.println("Finding the jet that can travel the furthest...");
				System.out.println();
				
				Jet furthest = jetList4.get(0);
				
				for (Jet jet : jetList4) {
					if (jet.getRange() > furthest.getRange()) {
						furthest = jet;
					}
				}
				
				System.out.println("The jet that can travel the furthest: ");
				System.out.println(furthest);
				
				break;
				
			case 5:
				
				List<Jet> jetList5 = airField.getJets();
				
				System.out.println("Loading all cargo planes...");
				System.out.println();
				
				for (Jet jet : jetList5) {
					if (jet instanceof CargoCarrier) {
						((CargoCarrier) jet).loadCargo();
					}
				}
				
				break;
				
			case 6:
				
				List<Jet> jetList6 = airField.getJets();
				
				System.out.println("Sending all combat ready jets to fight...");
				System.out.println();
				
				for (Jet jet : jetList6) {
					if (jet instanceof CombatReady) {
						((CombatReady) jet).fight();
					}
				}
				
				break;
				
			case 7:
				
				System.out.println();
				System.out.println("================================================================");
				System.out.println("============================= JETS =============================");
				System.out.println("=========== What kind of jet would you like to add? ============");
				System.out.println("================================================================");
				System.out.println("= 1. Attack Helicopter [Cargo Carrier & Combat Ready]          =");
				System.out.println("= 2. Bomber Jet [Combat Ready]                                 =");
				System.out.println("= 3. Cargo Plane [Cargo Carrier]                               =");
				System.out.println("= 4. Fighter Jet [Combat Ready]                                =");
				System.out.println("================================================================");
				System.out.println("=                    (Input option number)                     =");
				System.out.println("================================================================");
				System.out.println();
				int answer2 = kb.nextInt();
				
				switch (answer2) {
				
				case 1:
					
					String name = "Attack Helicopter";
					
					JetsApplication JA = new JetsApplication();
					
					String[] info = JA.displayNewJets(name);
					
					Jet newJet = new AttackHelicopter(info[0], Double.parseDouble(info[1]), Integer.parseInt(info[2]), Long.parseLong(info[3]));
					
					airField.addJet(newJet);
					
					break;
					
				case 2:
					
					String name1 = "Bomber Jet";
					
					JetsApplication JA1 = new JetsApplication();
					
					String[] info1 = JA1.displayNewJets(name1);
					
					Jet newJet1 = new BomberJet(info1[0], Double.parseDouble(info1[1]), Integer.parseInt(info1[2]), Long.parseLong(info1[3]));
					
					airField.addJet(newJet1);
					
					break;
					
				case 3:
					
					String name2 = "Cargo Plane";
					
					JetsApplication JA2 = new JetsApplication();
					
					String[] info2 = JA2.displayNewJets(name2);
					
					Jet newJet2 = new CargoPlane(info2[0], Double.parseDouble(info2[1]), Integer.parseInt(info2[2]), Long.parseLong(info2[3]));
					
					airField.addJet(newJet2);
					
					break;
					
				case 4:
					
					String name3 = "Fighter Jet";
					
					JetsApplication JA3 = new JetsApplication();
					
					String[] info3 = JA3.displayNewJets(name3);
					
					Jet newJet3 = new FighterJet(info3[0], Double.parseDouble(info3[1]), Integer.parseInt(info3[2]), Long.parseLong(info3[3]));
					
					airField.addJet(newJet3);
					
					break;
					
				default:
					
					System.out.println("Input invalid. Sending back to main menu.");
					
					break;
					
				}
				
				break;
				
			case 8:
				
				System.out.println();
				System.out.println("================================================================");
				System.out.println("============================= JETS =============================");
				System.out.println("=========== What kind of jet would you like to remove? =========");
				System.out.println("================================================================");
				System.out.println("= 1. Attack Helicopter [Cargo Carrier & Combat Ready]          =");
				System.out.println("= 2. Bomber Jet [Combat Ready]                                 =");
				System.out.println("= 3. Cargo Plane [Cargo Carrier]                               =");
				System.out.println("= 4. Fighter Jet [Combat Ready]                                =");
				System.out.println("================================================================");
				System.out.println("=                    (Input option number)                     =");
				System.out.println("================================================================");
				System.out.println();
				int answer3 = kb.nextInt();
				
				//TODO: Finish the remove list. My idea was to list out what they'd like to remove by number, User Story #10;
				
			case 9:
				
				inMenu = false;
				
				break;
				
			default:
				
				System.out.println("Invalid input! Try again...");
				
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
	
	private String[] displayNewJets(String name) {
		
		String[] info = new String[4];
		
		System.out.println();
		System.out.println(" Please input your " + name + " information in the following format: ");
		System.out.println();
		System.out.println("=====================================================================");
		System.out.println("=                    Model, Speed, Range, Price                     =");
		System.out.println("=            (Please put a \", \" in between each value)              =");
		System.out.println("=====================================================================");
		System.out.println();
		
		String input = kb.next();
		input = input + kb.nextLine();
		
		info = input.split(", ");
		
		return info;
		
	}

}
