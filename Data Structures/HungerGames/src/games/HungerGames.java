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
            districts.remove(newDistrict);
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
                    districts.remove(newDistrict);
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
                    districts.remove(newDistrict);
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
    private TreeNode findNode( int id, TreeNode node )
    {
        if( node == null )
        {
            return null;
        }
        
        if( id < node.getDistrict().getDistrictID() )
        {
            return findNode(id, node.getLeft());
        }
        else if( id > node.getDistrict().getDistrictID() )
        {
            return findNode(id, node.getRight());
        }
        return node;
    }
    public District findDistrict(int id) {

        // // WRITE YOUR CODE HERE
        TreeNode foundDistrictNode = findNode(id, game);
        if( foundDistrictNode == null )
        {
            return null;
        }
        return foundDistrictNode.getDistrict();
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
    private Person findTesseraPerson1( TreeNode node )
    {
        if( node == null )
            return null;
        
        ArrayList<Person> oddPopulation = node.getDistrict().getOddPopulation();
        ArrayList<Person> evenPopulation = node.getDistrict().getEvenPopulation();

        if( oddPopulation.size() != 0 )
        {
            for( int i = 0; i < oddPopulation.size(); i++ )
            {
                Person checkPerson = oddPopulation.get(i);
                if( checkPerson.getTessera() == true )
                    return checkPerson;
            }
        }
        if( evenPopulation.size() != 0 )
        {
            for( int i = 0; i < evenPopulation.size(); i++ )
            {
                Person checkPerson = evenPopulation.get(i);
                if( checkPerson.getTessera() == true )
                    return checkPerson;
            }

        }

        Person foundPerson = findTesseraPerson1(node.getLeft() );
        if( foundPerson == null )
            foundPerson = findTesseraPerson1(node.getRight() );
        
        return foundPerson;

    }
    private Person findTesseraPerson2( TreeNode node, int districtID, int evenOrOdd )
    {
        if( node == null )
            return null;

        ArrayList<Person> oddPopulation = node.getDistrict().getOddPopulation();
        ArrayList<Person> evenPopulation = node.getDistrict().getEvenPopulation();

        if( districtID != node.getDistrict().getDistrictID() )
        {

            if( evenOrOdd == 0 && evenPopulation.size() > 0 )
            {
                for( int i = 0; i < evenPopulation.size(); i++ )
                {
                    Person checkPerson = evenPopulation.get(i);
                    if( checkPerson.getTessera() == true )
                        return checkPerson;
                }
            }
            else if( evenOrOdd == 1 && oddPopulation.size() > 0 )
            {
                for( int i = 0; i < oddPopulation.size(); i++ )
                {
                    Person checkPerson = oddPopulation.get(i);
                    if( checkPerson.getTessera() == true )
                        return checkPerson;
                }
            }
        }

        Person foundPerson = findTesseraPerson2(node.getLeft(), districtID, evenOrOdd);
        if( foundPerson == null )
            foundPerson = findTesseraPerson2(node.getRight(), districtID, evenOrOdd);

        return foundPerson;
    }
    private Person findRandomPerson1( TreeNode node )
    {
        if( node == null )
            return null;
        
        ArrayList<Person> oddPopulation = node.getDistrict().getOddPopulation();
        ArrayList<Person> evenPopulation = node.getDistrict().getEvenPopulation();

        if( oddPopulation.size() != 0 )
        {
            Person checkPerson = oddPopulation.get( StdRandom.uniform( oddPopulation.size() ) );
            return checkPerson;
        }
        if( evenPopulation.size() != 0 )
        {
            Person checkPerson = evenPopulation.get( StdRandom.uniform( oddPopulation.size() ) );
            return checkPerson;
        }

        Person foundPerson = findRandomPerson1(node.getLeft() );
        if( foundPerson == null )
            foundPerson = findRandomPerson1(node.getRight() );
        
        return foundPerson;
    }
    private Person findRandomPerson2( TreeNode node, int districtID, int evenOrOdd )
    {
        if( node == null )
            return null;
        
        ArrayList<Person> oddPopulation = node.getDistrict().getOddPopulation();
        ArrayList<Person> evenPopulation = node.getDistrict().getEvenPopulation();

        if( districtID != node.getDistrict().getDistrictID() )
        {

            if( evenOrOdd == 0 && evenPopulation.size() > 0 )
            {
                Person checkPerson = evenPopulation.get( StdRandom.uniform( evenPopulation.size() ) );
                return checkPerson;
            }
            if( evenOrOdd == 1 && oddPopulation.size() > 0 )
            {
                Person checkPerson = oddPopulation.get( StdRandom.uniform( oddPopulation.size() ) );
                return checkPerson;
            }
        }

        Person foundPerson = findRandomPerson2(node.getLeft(), districtID, evenOrOdd);
        if( foundPerson == null )
            foundPerson = findRandomPerson2(node.getRight(), districtID, evenOrOdd);
        
        return foundPerson;
    }
    private TreeNode removePerson( Person person, TreeNode node )
    {
        if( node == null )
            return null;
        
        if( person.getDistrictID() > node.getDistrict().getDistrictID() )
            removePerson(person, node.getRight() );
        else if( person.getDistrictID() < node.getDistrict().getDistrictID() )
            removePerson(person, node.getLeft() );
        else if( person.getDistrictID() == node.getDistrict().getDistrictID() )
        {
            if( person.getBirthMonth() % 2 != 0 )
            {
                ArrayList<Person> oddPopulation = node.getDistrict().getOddPopulation();
                oddPopulation.remove(person);
            }
            else
            {
                ArrayList<Person> evenPopulation = node.getDistrict().getEvenPopulation();
                evenPopulation.remove(person);
            }
        }
        return node;
    }
    public DuelPair selectDuelers() {
        
        // WRITE YOUR CODE HERE
        if( game == null )
            return null;

        int evenOrOdd = 0;
        Person person1 = findTesseraPerson1(game);
        Person person2 = null;
        if( person1 == null )
        {
            person1 = findRandomPerson1(game);
            if( person1.getBirthMonth() % 2 == 0 )
                evenOrOdd = 1;
            person2 = findTesseraPerson2(game, person1.getDistrictID(), evenOrOdd);
            if( person2 == null )
                person2 = findRandomPerson2(game, person1.getDistrictID(), evenOrOdd);

            if( evenOrOdd == 1 )
            {
                Person temp = person1;
                person1 = person2;
                person2 = temp;
            }
        }
        else 
        {
            if( person1.getBirthMonth() % 2 == 0 )
                evenOrOdd = 1;
            person2 = findTesseraPerson2(game, person1.getDistrictID(), evenOrOdd);
            if( person2 == null )
                person2 = findRandomPerson2(game, person1.getDistrictID(), evenOrOdd);
            if( evenOrOdd == 1 )
            {
                Person temp = person1;
                person1 = person2;
                person2 = temp;
            }

        }
        game = removePerson(person1, game);
        game = removePerson(person2, game);
        return new DuelPair(person1, person2);
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
    private TreeNode getMinDistrict( TreeNode node )
    {
        if( node.getLeft() == null )
            return node;
        
        return getMinDistrict(node.getLeft() );
    }
    private TreeNode eliminateMinDistrict( TreeNode node )
    {
        if( node.getLeft() == null )
            return node.getRight();
        
        node.setLeft( eliminateMinDistrict(node.getLeft() ) );

        return node;
    }
    private TreeNode eliminateDistrict( TreeNode node, int id )
    {
        if( node == null )
            return null;
        
        if( id < node.getDistrict().getDistrictID() )
            node.setLeft(eliminateDistrict(node.getLeft(), id) );
        else if( id > node.getDistrict().getDistrictID() )
            node.setRight(eliminateDistrict(node.getRight(), id) );
        
        else
        {
            if( node.getRight() == null )
                return node = node.getLeft();
            if( node.getLeft() == null )
                return node = node.getRight();
            
            TreeNode x = node;
            node = getMinDistrict( x.getRight() );
            node.setRight( eliminateMinDistrict(x.getRight() ) );
            node.setLeft(x.getLeft() );
        }

        return node;
    }
    public void eliminateDistrict(int id) {

        // WRITE YOUR CODE HERE
        District districtFound = findDistrict(id);
        if( districtFound != null )
            game = eliminateDistrict(game, id);
        else
            return;
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
    private TreeNode addPersonBack( Person person, TreeNode node )
    {
        if( node == null )
            return null;
        
        if( person.getDistrictID() > node.getDistrict().getDistrictID() )
            addPersonBack(person, node.getRight() );
        else if( person.getDistrictID() < node.getDistrict().getDistrictID() )
            addPersonBack(person, node.getLeft() );
        else
        {
            if( person.getBirthMonth() % 2 != 0 )
                node.getDistrict().addOddPerson(person);
            else 
                node.getDistrict().addEvenPerson(person);
        }
        return node;
    }
    public void eliminateDueler(DuelPair pair) {

        // WRITE YOUR CODE HERE
        Person person1 = pair.getPerson1();
        Person person2 = pair.getPerson2();

        // if pair is incomplete return person back to district
        if( person1 != null && person2 == null )
        {
            game = addPersonBack(person1, game);
            return;
        }
        else if( person2 != null && person1 == null )
        {
            game = addPersonBack(person2, game);
            return;
        }
        else if( person1 == null && person2 == null ) // if pair is empty
            return;

        // if pair is complete duel
        Person winner = person1.duel(person2);
        game = addPersonBack(winner, game);

        District person1District = findDistrict(person1.getDistrictID() );
        District person2District = findDistrict(person2.getDistrictID() );

        if( person1District.getEvenPopulation().size() == 0 || person1District.getOddPopulation().size() == 0 )
            eliminateDistrict(person1District.getDistrictID() );
        else if( person2District.getEvenPopulation().size() == 0 || person2District.getOddPopulation().size() == 0 )
            eliminateDistrict(person2District.getDistrictID() );

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
