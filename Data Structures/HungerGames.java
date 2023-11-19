package games;

import java.util.ArrayList;

/**
 * This class contains methods to represent the Hunger Games using BSTs.
 * Moves people from input files to districts, eliminates people from the game,
 * and determines a possible winner.
 * 
 * @author Pranay Roni
 * @author Maksims Kurjanovics Kravcenko
 * @author Kal Pandit
 */
public class HungerGames {

    private ArrayList<District> districts;  // all districts in Panem.
    private TreeNode            game;       // root of the BST. The BST contains districts that are still in the game.

    /**
     * ***** DO NOT REMOVE OR UPDATE this method *********
     * Default constructor, initializes a list of districts.
     */
    public HungerGames() {
        districts = new ArrayList<>();
        game = null;
        StdRandom.setSeed(2023);
    }

    /**
     * ***** DO NOT REMOVE OR UPDATE this method *********
     * Sets up Panem, the universe in which the Hunger Games takes place.
     * Reads districts and people from the input file.
     * 
     * @param filename will be provided by client to read from using StdIn
     */
    public void setupPanem(String filename) { 
        StdIn.setFile(filename);  // open the file - happens only once here
        setupDistricts(filename); 
        setupPeople(filename);
    }

    /**
     * Reads the following from input file:
     * - Number of districts
     * - District ID's (insert in order of insertion)
     * Insert districts into the districts ArrayList in order of appearance.
     * 
     * @param filename will be provided by client to read from using StdIn
     */
    public void setupDistricts (String filename) {

        // WRITE YOUR CODE HERE
        if( !StdIn.hasNextLine() )
            return;

        int districtAmount = StdIn.readInt();

        for( int i = 0; i < districtAmount; i++ )
        {
            District newDistrict = new District(StdIn.readInt() );
            districts.add(newDistrict);
        }
    }

    /**
     * Reads the following from input file (continues to read from the SAME input file as setupDistricts()):
     * Number of people
     * Space-separated: first name, last name, birth month (1-12), age, district id, effectiveness
     * Districts will be initialized to the instance variable districts
     * 
     * Persons will be added to corresponding district in districts defined by districtID
     * 
     * @param filename will be provided by client to read from using StdIn
     */
    public void setupPeople (String filename) {

        // WRITE YOUR CODE HERE
        if( !StdIn.hasNextLine() )
            return;

        int headCount = StdIn.readInt();
        int startingCount = 0;


        while( StdIn.hasNextLine() && startingCount < headCount )
        {
            // create person
            String playerName = StdIn.readString();
            String playerSurname = StdIn.readString();
            int playerBirthMonth = StdIn.readInt();
            int playerAge = StdIn.readInt();
            int playerDistrictID = StdIn.readInt();
            int playerEfficacy = StdIn.readInt();

            Person newPerson = new Person(playerBirthMonth, playerName, playerSurname, playerAge, playerDistrictID, playerEfficacy);
            
            // check if person is Tessera
            if( newPerson.getAge() >= 12 && newPerson.getAge() < 18 )
                newPerson.setTessera(true);
            else
                newPerson.setTessera(false);

            // assign person to district
            District targetDistrict = districts.get(0);
            for( int j = 1; j <= districts.size() - 1; j++ )
            {
                if( targetDistrict.getDistrictID() == playerDistrictID )
                    break;

                targetDistrict = districts.get(j);
            }
            
            if( playerBirthMonth % 2 == 0 )
                targetDistrict.addEvenPerson(newPerson);
            else
                targetDistrict.addOddPerson(newPerson);

            startingCount++;
        }
    }

    /**
     * Adds a district to the game BST.
     * If the district is already added, do nothing
     * 
     * @param root        the TreeNode root which we access all the added districts
     * @param newDistrict the district we wish to add
     */
    public void addDistrictToGame(TreeNode root, District newDistrict) {

        // WRITE YOUR CODE HERE
        TreeNode checkNode = game;
        if( checkNode == null )
        {
            checkNode = new TreeNode(newDistrict, null, null);
            game = checkNode;
            return;
        }
        
        checkNode = root;
        while( checkNode.getDistrict().getDistrictID() != newDistrict.getDistrictID() )
        {
               if( newDistrict.getDistrictID() > checkNode.getDistrict().getDistrictID() )
            {
                if( checkNode.getRight() == null )
                {
                    TreeNode targetNode = new TreeNode(newDistrict, null, null);
                    checkNode.setRight(targetNode);
                    break;
                }
                else
                {
                    checkNode = checkNode.getRight();
                }
            }
            else if( newDistrict.getDistrictID() < checkNode.getDistrict().getDistrictID() )
            {
                if( checkNode.getLeft() == null )
                {
                    TreeNode targetNode = new TreeNode(newDistrict, null, null);
                    checkNode.setLeft(targetNode);
                    break;
                }
                else
                {
                    checkNode = checkNode.getLeft();
                }
            }
        }
    }

    /**
     * Searches for a district inside of the BST given the district id.
     * 
     * @param id the district to search
     * @return the district if found, null if not found
     */
    public District findDistrict(int id) {

        // WRITE YOUR CODE HERE
        final TreeNode root = game;
        if( game == null )
            return null;

        if( id < game.getDistrict().getDistrictID() )
        {
            game = game.getLeft();
            return findDistrict(id);
        }
        else if( id > game.getDistrict().getDistrictID() )
        {
            game = game.getRight();
            return findDistrict(id);
        }

        TreeNode foundNode = game;
        game = root;
        return foundNode.getDistrict();
    }

    /**
     * Selects two duelers from the tree, following these rules:
     * - One odd person and one even person should be in the pair.
     * - Dueler with Tessera (age 12-18, use tessera instance variable) must be
     * retrieved first.
     * - Find the first odd person and even person (separately) with Tessera if they
     * exist.
     * - If you can't find a person, use StdRandom.uniform(x) where x is the respective 
     * population size to obtain a dueler.
     * - Add odd person dueler to person1 of new DuelerPair and even person dueler to
     * person2.
     * - People from the same district cannot fight against each other.
     * 
     * @return the pair of dueler retrieved from this method.
     */
    public DuelPair selectDuelers() {
        
        // WRITE YOUR CODE HERE
        TreeNode firstDistrict = game;
        TreeNode secondDistrict = new TreeNode();
        boolean foundOddTessera = false;
        while( firstDistrict != null )
        {
            ArrayList<Person> oddPopulation = firstDistrict.getDistrict().getOddPopulation();
            ArrayList<Person> evenPopulation = firstDistrict.getDistrict().getEvenPopulation();
            if( oddPopulation.size() != 0 )
            {
                int populationSize = oddPopulation.size();
                for( int i = 0; i < populationSize; i++ )
                {
                    Person checkPerson = oddPopulation.get(i);
                    if( checkPerson.getTessera() == true )
                    {
                        foundOddTessera = true;

                        break;
                    }
                }
            }
        }
        return null; // update this line
    }


    /**
     * Deletes a district from the BST when they are eliminated from the game.
     * Districts are identified by id's.
     * If district does not exist, do nothing.
     * 
     * This is similar to the BST delete we have seen in class.
     * 
     * @param id the ID of the district to eliminate
     */
    public void eliminateDistrict(int id) {

        // WRITE YOUR CODE HERE
    }

    /**
     * Eliminates a dueler from a pair of duelers.
     * - Both duelers in the DuelPair argument given will duel
     * - Winner gets returned to their District
     * - Eliminate a District if it only contains a odd person population or even
     * person population
     * 
     * @param pair of persons to fight each other.
     */
    public void eliminateDueler(DuelPair pair) {

        // WRITE YOUR CODE HERE
    }

    /**
     * ***** DO NOT REMOVE OR UPDATE this method *********
     * 
     * Obtains the list of districts for the Driver.
     * 
     * @return the ArrayList of districts for selection
     */
    public ArrayList<District> getDistricts() {
        return this.districts;
    }

    /**
     * ***** DO NOT REMOVE OR UPDATE this method *********
     * 
     * Returns the root of the BST
     */
    public TreeNode getRoot() {
        return game;
    }
}
