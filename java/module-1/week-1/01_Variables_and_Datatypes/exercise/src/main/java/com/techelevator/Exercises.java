package com.techelevator;

public class Exercises {

    public static void main(String[] args) {

        /* Exercise 1
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */
        // ### EXAMPLE:
        int birdsOnABranch = 4;
        int birdsThatFlyAway = 1;
        int birdsRemaining = birdsOnABranch - birdsThatFlyAway;

        /* Exercise 2
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */
        // ### EXAMPLE:
        int numberOfBirds = 6;
        int numberOfNests = 3;
        int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /* Exercise 3
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
        int raccoonsPlaying = 3;
        int racoonsEatingDinner = 2;
        int racoonsLeft = raccoonsPlaying - racoonsEatingDinner;


        /* Exercise 4
        4. There are 5 flowers and 3 bees. How many less bees than flowers?

         */
        int flowers = 5;
        int bees = 3;
        int difference = flowers - bees;



        /* Exercise 5
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
        int pigeons = 1;
        int otherPigeon = 1;
        int total = pigeons + otherPigeon;

        /* Exercise 6
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
        int owl = 3;
        int otherOwl = 2;
        int totalOwl = owl + otherOwl;

        /* Exercise 7
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
        int beaver = 2;
        int swimmingBeaver = 1;
        int workingBeaver = beaver - swimmingBeaver;

        /* Exercise 8
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
        int sitToucan = 2;
        int toucan = 1;
        int totalToucan = sitToucan + toucan;

        /* Exercise 9
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
        int squirrels = 4;
        int nuts = 2;
        int squirrelsThanNuts = squirrels - nuts;

        /* Exercise 10
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
        double quater = 0.25;
        double dime = 0.10;
        double nickel = 0.10;
        double totalMoney = quater + dime + nickel;


        /* Exercise 11
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
        int brier = 18;
        int macAdam = 20;
        int flannery = 17;
        int totalMuffins = brier + macAdam + flannery;

        /* Exercise 12
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
        double yoyo = 0.24;
        double whistle = 0.14;
        double totalToys = yoyo + whistle;

        /* Exercise 13
        13. Mrs. Hilt made 5 Rice Krispies Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
        int mini = 10;
        int large = 8;
        int totalMarshmallows = mini + large;

        /* Exercise 14
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
        int hilts = 29;
        int brecknock = 17;
        int moreSnow = hilts - brecknock;

        /* Exercise 15
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2.50 on a pencil
        case. How much money does she have left?
        */
        int money = 10;
        int toyTruck = 3;
        double pencil = 2.50;
        double moneyLeft = money - toyTruck - pencil;

        /* Exercise 16
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
        int marbles = 16;
        int marblesLost = 7;
        int marblesLeft = marbles - marblesLost;

        /* Exercise 17
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
        int seashells = 19;
        int seashlessNeeded = 25;
        int seashellsInHerCollection = seashlessNeeded - seashells;

        /* Exercise 18
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
        int totalBalloons = 17;
        int redBalloons = 8;
        int greenBallons = totalBalloons - redBalloons;

        /* Exercise 19
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
        int booksOnShelf = 38;
        int moreBooksOnShelf = 10;
        int totalBooksOnShelf = booksOnShelf + moreBooksOnShelf;

        /* Exercise 20
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
        int beeLegs = 6;
        int totalBees = 8;
        int totalBeeLegs = totalBees * beeLegs;

/*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */

        double iceCreamConeCost = 0.99;
        int numberOfIceCream = 2;
        double totalCostOfIceCreamCone = iceCreamConeCost * numberOfIceCream;
        /* Exercise 22
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
        int rocksNedded = 125;
        int rocksHas = 64;
        int moreRocks = rocksNedded - rocksHas;

        /* Exercise 23
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
         int marblesHad = 38;
         int marbesLost= 15;
         int totalMarblesLeft = marblesHad - marbesLost;

        /* Exercise 24
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
        int mileAway = 78;
        int mileDrove = 32;
        int milesLeft= mileAway - mileDrove;

        /* Exercise 25
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time (in minutes) did she spend shoveling snow?
        */
        int minutesShovelingMorning = 90;
        int minitesShovelingAfternoon = 45;
        int totalMinutesShoveling =  minutesShovelingMorning + minitesShovelingAfternoon;

        /* Exercise 26
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
        int numberOfHotDog = 6;
        int costOfHotDog= (int) 0.50;
        int costOfTotalHotDog= numberOfHotDog * costOfHotDog;

        /* Exercise 27
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
     int moneyMrsHiltHas = 50;
     int costOfPencil= 7;
     int pencilsMrsHiltCanBuy= moneyMrsHiltHas/ costOfPencil;

        /* Exercise 28
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
        int totalButterfly = 33;
        int orangeButterfly = 20;
        int redButterfly = totalButterfly - orangeButterfly;


        /* Exercise 29
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */

        double moneyGave = 1.00;
        double costOfCandy= 0.54;
        double changeBack = moneyGave - costOfCandy;
        /* Exercise 30
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
    int amountOfTree = 13;
    int treePlanted = 12;
    int totalTree=  amountOfTree + treePlanted;

        /* Exercise 31
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
        int daysUntilJoySeesHerGrandma = 2;
        int hoursInADay = 24;
        int hoursUntilJoYSeesHerGrandma= hoursInADay * daysUntilJoySeesHerGrandma;


        /* Exercise 32
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
        int kimCousins = 4;
        int gumToGive = 5;
        int gumNeeded = kimCousins * gumToGive;

        /* Exercise 33
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
        int moneyDanHas = 3;
        int candyBar = 1;
        int moneyLeftOver = moneyDanHas - candyBar;

        /* Exercise 34
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */

    int boatsInLake = 5;
    int peopleOnBoat= 3;
    int totalPeopleOnBoats = boatsInLake * peopleOnBoat;

        /* Exercise 35
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
        int legos = 380;
        int legosLost = 57;
        int legosLeftOver = legos- legosLost;


        /* Exercise 36
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
    int muffinsBaked = 35;
    int totalMuffinsBaked = 83;
    int muffinsNeeded = totalMuffinsBaked - muffinsBaked;

        /* Exercise 37
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
int willyCrayons = 1400;
int lucyCrayons = 290;
int moreCrayonsthanLucy = willyCrayons - lucyCrayons;

        /* Exercise 38
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */

int stickersOnAPage = 10;
int pagesOfStickers = 22;
int totalStickersInTotal = stickersOnAPage * pagesOfStickers;
        /* Exercise 39
        39. There are 100 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
    int cupcakes = 100;
    int numberOfChildren = 8;
    double numberOfCupcakesPerChild = cupcakes / numberOfChildren;

        /* Exercise 40
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies, how many
        cookies will not be placed in a jar?
        */
    int gingerBreadCookies = 47;
    int cookiesInJar = 6;
    int cookiesLeft = gingerBreadCookies % cookiesInJar;

        /* Exercise 41
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received an equal number of croissants,
        how many will be left with Marian?
        */
int croissants = 59;
int neighbor = 8;
int croissantsLeft = croissants % neighbor;

        /* Exercise 42
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
int totalOatmealCookies = 276;
int cookiesOnTray = 12;
int totalAmountOfTray = totalOatmealCookies / cookiesOnTray;

        /* Exercise 43
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
int totalBiteSizedPretzels = 480;
int servingSize = 12;
int servingsOfPretzels = totalBiteSizedPretzels / servingSize;

        /* Exercise 44
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
int lemonCakes =  51;
int cakesInBox = 3;
int boxesGivenAway = lemonCakes / cakesInBox;

        /* Exercise 45
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
int carrotSticks = 74;
int carrotsServed = 12;
int carrotsLeft = carrotSticks % carrotsServed;

        /* Exercise 46
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
int teddyBear = 98;
int shelves = 7;
int shelvesFilled = teddyBear/ shelves;

        /* Exercise 47
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
int albums = 20;
int pictures= 480;
int totalAmountOFAlbums = pictures / albums;

        /* Exercise 48
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
int tradingCards = 94;
int boxOfCards = 8;
int unfilledBox = tradingCards % boxOfCards;

        /* Exercise 49
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
    int susieFathersBooks = 210;
    int susieFatherShelve = 10;
    int totalBooksOnSusieFatherShelves = susieFathersBooks / susieFatherShelve;

        /* Exercise 50
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */

        int bakedCroissants = 17;
        int cristinaGuest = 7;
        double croissantsGuestGet = (bakedCroissants / cristinaGuest);


	    /* Exercise 51
	    51. Bill and Jill are house painters. Bill can paint a standard room in 2.15 hours, while Jill averages
	    1.90 hours. How long will it take the two painters working together to paint 5 standard rooms?
	    Hint: Calculate the rate at which each painter can complete a room (rooms / hour), combine those rates, 
	    and then divide the total number of rooms to be painted by the combined rate.
	    */
     double combinedTimeToPaintRoom = 4.05;
     int totalNumberOfRooms = 5;
     double timeForBothToPaintRoom = combinedTimeToPaintRoom / totalNumberOfRooms;


	    /* Exercise 52
	    52. Create and assign variables to hold a first name, last name, and middle initial. Using concatenation,
		build an additional variable to hold the full name in the order of last name, first name, middle initial. The
		last and first names should be separated by a comma followed by a space, and the middle initial must end
		with a period. Use "Grace", "Hopper, and "B" for the first name, last name, and middle initial.
		Example: "John", "Smith, "D" —> "Smith, John D."
	    */
String stringone = "Grace";
String stringtwo = "Hopper, ";
String stringthree = " B.";
String stringfour = stringtwo + stringone + stringthree;

	    /* Exercise 53
	    53. The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
	    What percentage of the trip as a whole number has been completed?
	    */
    int totalDistance = 800;
    int distanceTravled = 537;
    double precentageCompleted = distanceTravled /totalDistance *100;
    }

}
