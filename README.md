# Jets Project

## Description

This program is designed to create Jet classes and store them in an airfield. The program pulls the information from the initial input file, splits it into a String, parses the data, and creates a Jet object that is specific to the type entered in the file.

These are the Jet objects available in the program:

1. FighterJet
2. BomberJet
3. CargoPlane
4. AttackHelicopter

After the initial creation of these Objects, the user is presented with a menu that loops until asked to quit. It has several options for interacting with the program. This includes options like listing the entire fleet, making all combat ready jets fight, finds the jet with the highest speed, adds and removes jets from the fleet, and more.

Here is the full list of options presented to the user in this program:

1. List the fleet
2. Fly all the jets
3. View the fastest jet
4. View the jet with the longest range
5. Load all of the existing Cargo Jets
6. Initiate a dogfight with all of the existing combat jets
7. Add a jet to the fleet
8. Remove a jet from the fleet
9. Exit the menu  

When the user adds or removes jets from the airfield, it updates the input file as well as the fleet array, so the changes are live and permanent to the user, it does not reset after the program is done running.

## Lessons Learned

I was having a hard time determining the most efficient way to pull the object data from the input file and differentiate which Jet object I needed to create. I tried using a generic in the Jet class, but that did not work.

I eventually tried splitting the array and taking that specific data point and verifying which one it was in a series of if/else statements. Once the program figured out which Object it was supposed to be, it would create that specific Object.

This solution is simple in concept, but very effective. It also checks if the Object input is incorrect, therefore not creating any errors upon creating the Object in case it doesn't exist.

I also wanted to push the Jet array in the AirField out to the input file to keep it updated. In order to do this, I had to get the information sent as a String in the exact format I used to pull the data at the start of the program. In order to do this, I had to create a new abstract method in the Jet class called create(). This method was essentially a toString() method but formatted in the required format for the start of the program.

Here is an example of the create() method in one of the classes:

`public String create() {
		return "CargoPlane," + super.getModel() + "," + super.getSpeed() + ","
				+ super.getRange() + "," + super.getPrice();
	}`

## Technologies Used

There were an immense amount of technologies and ideas used to make this program work. They include the following:

- The Java utility, Scanner.
- Inheritance and superclasses.
- Constructors, 'Setters', and 'Getters'.
- FileReader and BufferedReader.
- PrintWriter and FileWriter.
- IOException.
- Lists/ArrayLists.
- Interfaces.
- Use of nested switch/case.
- Polymorphism in creating the individual Jet Objects.
- String.split().
- Double, Integer, and Long parses.
- Use of abstract superclass.

## What was the most difficult part of this project?

The most difficult part of this project was having to refer to multiple different Objects in reference, as well as trying to differentiate which one to create from the text file input.

Although I came up with the simple solution to read them as Strings and create the Object from there, I thought there may have been a way to use generics in the Jet class to tell which Object to create. However, I could not figure that out, so I went with reading the data as a String and creating the Object based on that.

Referring to the different Lists and Objects would be difficult at times. I would forget to refer to return a List<Jet> rather than just a List or a Jet.
