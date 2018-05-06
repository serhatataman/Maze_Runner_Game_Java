import java.util.Scanner;

public class MazeRunner {

	static Maze myMap = new Maze();
	
	public static void main(String[] args) 
	{
		String direction;
		intro();
		userMove();
	}
	
	public static void intro()
	{
		System.out.println("Welcome to the Maze Runner!");
		System.out.println("Here is your current position: ");
	}
	
	public static void userMove()
	{
		String direction = "";
		Scanner input = new Scanner(System.in);
		
		while(true) 
		{
		
		myMap.printMap();
		System.out.print("Where would you like to move? ( R, L, U, D ) ");
		direction = input.next();
	
		if (direction.equalsIgnoreCase("R")) {	
			if(!myMap.canIMoveRight() && myMap.isThereAPit(direction)) 
				myMap.jumpOverPit(direction);
			
			else if(myMap.canIMoveRight())
					myMap.moveRight();	
				
			else
				System.out.println("Sorry, you have hit the wall! R");
			
		} else if (direction.equalsIgnoreCase("U")) {	
			if(!myMap.canIMoveUp() && myMap.isThereAPit(direction)) 
				myMap.jumpOverPit(direction);
			
			else if(myMap.canIMoveUp())
					myMap.moveUp();	
				
			else
				System.out.println("Sorry, you have hit the wall! U");
			
		} else if (direction.equalsIgnoreCase("L")) {
			if(!myMap.canIMoveLeft() && myMap.isThereAPit(direction)) 
				myMap.jumpOverPit(direction);
			
			else if(myMap.canIMoveLeft())
					myMap.moveLeft();	
				
			else
				System.out.println("Sorry, you have hit the wall! L");
			
		} else if (direction.equalsIgnoreCase("D")) { 
			if(!myMap.canIMoveDown() && myMap.isThereAPit(direction)) 
				myMap.jumpOverPit(direction);
			
			else if(myMap.canIMoveDown())
					myMap.moveDown();	
				
			else
				System.out.println("Sorry, you have hit the wall! D");
		}
		else 
			System.out.println("Please enter a valid direction!");
			
		if(myMap.didIWin())
		{
			System.out.println("CONGRATULATIONS! YOU WON!");
			break;
		}
	}
	}
}
