// TEAM Legendairy - Jennifer Yu, James Cao
// APCS1 pd9
// HW36 -- Some Folks Call it Memory
// 2015-11-24


import cs1.Keyboard;  //if comfortable with Scanner, you may comment this out

		
public class Concentration {

//instance variables

    private Tile[][] _board = new Tile[4][4];     //storage for 4x4 grid of Tiles.
    private int _numberFaceUp;   //count of Tiles with faces visible
    private String[] _words;     //list of unique Strings used for Tile vals
    private static int _numRows = 4;
 

    //insert constructor and methods here

    public Concentration() {
	    _numberFaceUp = 0;
	    _words = new String[] {"a", "b", "c", "d", "e", "f", "g", "h"};
	    _board = setBoard();
    }

    public Tile[][] setBoard() {
	    int index = 0;
	    for (int r = 0; r < 4; r++) {
	        for (int c = 0; c < 4; c++) {
		        Tile t = new Tile (_words[index]);
		        _board[r][c] = t;
		        index ++;
	            if (index == 8) {
		            index = 0;
	            }
	        }
	    }
	
	    for (int r = 0; r < 4; r++) {
	        for (int c = 0; c < 4; c++) {
	            int rand1 = (int)(Math.random() * 4);
	            int rand2 = (int)(Math.random() * 4);
	            swap(_board, r, c, rand1, rand2);
	        }
	    }

	    return _board;
    }

    public static void swap(Object[][] a, int r1, int r2, int c1, int c2) {
	    Object holder = a[r1][c1];
        a[r1][c1] = a[r2][c2];
        a[r2][c2] = holder;      
    }

    public String toString() {
	    String retBoard = "";
	    for (int r = 0; r < 4; r++) {
	        for (int c = 0; c < 4; c++) {
	            retBoard += _board[r][c] + "\t";
	        }
	        retBoard += "\n";
	    }
	    return retBoard;
    }

    public String ready () {
	    String response = Keyboard.readString();
	    if (response.equals("Y")) {
	        return ("Then let's begin.\n");
	    }
	    else {
	    System.out.println ("Take your time...");
		return ready ();
	    }
    }
    
    public static int indicate (String message) {
    	System.out.println (message);
    	int number = Keyboard.readInt();
	        while (number > 4  || number <= 0) {
	            System.out.println ("That row does not exist. Try again.");
	            number = Keyboard.readInt();
	        }
	    return number;
    }

    public void play() {
        
	    int score = 0;
	    int number = 0;
	    System.out.println ("Welcome to Concetration!");
	    System.out.println ("Please observe the board below.");
	    System.out.print (this);
	    System.out.println ("Ready?(Y/N)");
	    System.out.print (ready ());

	    
	    while (score < 8) {
	     
	        int rowA = indicate ("\nPlease indicate the row of the first element.");
	        int columnA = indicate ("\nPlease indicate the column of the first element.");
	       
	       /*
            if ((_board[rowA-1][columnA-1]).equals (true)) {
                while ((_board[rowA-1][columnA-1]).equals (true)) {
	                System.out.println ("That card is already face up"); 
	                System.out.println("Try again. Row:")
	                int rowA = Keyboard.readInt();
	                System.out.println("Try again. Column:")
	                int columnA = Keyboard.readInt();
                }
            }
            */
	        
	        
	        int rowB = indicate ("\nPlease indicate the row of the second element.");
	        

	        int columnB = indicate("\nPlease indicate the column of the second element.");
	        
		    while ((_board[rowA-1][columnA-1].isFaceUp()) || (_board[rowB-1][columnB-1].isFaceUp())){
			    System.out.println ("One or more of these cards are already flipped up!");
			    System.out.println ("Pick two new cards.");
			    rowA = indicate ("\nPlease indicate the row of the first element.");
	            columnA = indicate ("\nPlease indicate the column of the first element.");
	            rowB = indicate ("\nPlease indicate the row of the second element.");
	     	    columnB = indicate("\nPlease indicate the column of the second element.");
		    }
		    
            _board[rowA-1][columnA-1].flip();
	        _board[rowB-1][columnB-1].flip();
	        System.out.print(this);
	        
	        
	  

	        if ((rowA == rowB) && (columnA == columnB)) {
		        System.out.println ("You chose the same element twice. Try again.");
	        }
	        else if (_board[rowA-1][columnA-1].equals (_board[rowB-1][columnB-1])) {
		        score += 1;
		        System.out.println ("Correct!");
	        }
	        else {
		        _board[rowA-1][columnA-1].flip();
		        _board[rowB-1][columnB-1].flip(); 
		        System.out.println ("Wrong.");
	        }
		 
		    System.out.println (this);
	    }
	    
	   
	        System.out.println ("Game Over.");
    }

    //DO NOT MODIFY main()
    public static void main(String[] args){
	Concentration game = new Concentration();
	//System.out.print(game);
	game.play();
    }

}//end class Concentration

