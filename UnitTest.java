import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
* Assignment 1
* @author Daniel Van Leusen
* Student id: 10064708
* E-mail: danvanleusen@yahoo.co.uk
* @version October 14, 2016
* <p>
* This is the Unit Test file to test refactored codes. 
*/

public class UnitTest {
	@Test
	public void testHumanMove() {
		//test human decisions
		//points < base on automatic, 'r' is expected
		HumanPlayer humanPlayer = new HumanPlayer(10);
		char decision = humanPlayer.humanMove(9);
		assertEquals('r', decision);
		
		//points = base on automatic, 'h' is expected
		decision = humanPlayer.humanMove(10);
		assertEquals('h', decision);
		
		//points > base on automatic, 'h' is expected
		decision = humanPlayer.humanMove(11);
		assertEquals('h', decision);
		
		//manual input test: on interactive, only 'r' or 'h' is expected
		//humanPlayer = new HumanPlayer();
		//decision = humanPlayer.humanMove(10);
		//org.junit.Assert.assertTrue(decision == 'r' ||decision == 'h');
	}
	
	@Test
	public void testComputerMove(){
		//test computer decisions, as well as set get and mutators for ComputerPlayer
		//computerScore >= 71, 'r' is expected
		ComputerPlayer computerPlayer = new ComputerPlayer();
		computerPlayer.setComputerScore(71);
		char decision = computerPlayer.computerMove(computerPlayer.getComputerScore(), 70, 10 );
		assertEquals('r', decision);
		
		//humanScore >= 71, 'r' is expected
		computerPlayer.setComputerScore(70);
		decision = computerPlayer.computerMove(computerPlayer.getComputerScore(), 71, 10 );
		assertEquals('r', decision);
		
		// humanScore and computerScore >= 71, 'r' is expected
		computerPlayer.setComputerScore(71);
		decision = computerPlayer.computerMove(computerPlayer.getComputerScore(), 71, 10 );
		assertEquals('r', decision);
		
		// both are < 71, and points < base, 'r' is expected
		computerPlayer.setComputerScore(70);
		decision = computerPlayer.computerMove(computerPlayer.getComputerScore(), 70, 10 );
		assertEquals('r', decision);
		
		// both are < 71, and points > base, 'h' is expected
		computerPlayer.setComputerScore(70);
		decision = computerPlayer.computerMove(computerPlayer.getComputerScore(), 70, 30 );
		assertEquals('h', decision);
		
		// both are < 71, and points = base, 'h' is expected
		computerPlayer.setComputerScore(70);
		decision = computerPlayer.computerMove(computerPlayer.getComputerScore(), 70, 21 );
		assertEquals('h', decision);
	}
	
	@Test
	public void testHumanSetGetMutator(){
		//test human constructor, accessor, and mutator
		HumanPlayer humanPlayer = new HumanPlayer(10);
		humanPlayer.setHumanScore(10);
		assertEquals(10, humanPlayer.getHumanScore());
	}
	
	@Test
	public void testController() {		
		//test controller on automatic, with fixed seed values and base values
		//seed is 1234, and base is 10; 37 is expected for computer, 101 is expected for human
		ComputerPlayer computerPlayer = new ComputerPlayer();
		HumanPlayer humanPlayer = new HumanPlayer(10);
		Controller controller = new Controller(computerPlayer, humanPlayer, new Dice(1234));
		controller.start();
		assertEquals(37, computerPlayer.getComputerScore());
		assertEquals(101, humanPlayer.getHumanScore());
		
		//seed is 4321, and base is 10; 37 is expected for computer, 101 is expected for human
		computerPlayer = new ComputerPlayer();
		humanPlayer = new HumanPlayer(10);
		controller = new Controller(computerPlayer, humanPlayer, new Dice(4321));
		controller.start();
		assertEquals(104, computerPlayer.getComputerScore());
		assertEquals(66, humanPlayer.getHumanScore());
		
		//seed is 4321, and base is 20; 37 is expected for computer, 101 is expected for human
		computerPlayer = new ComputerPlayer();
		humanPlayer = new HumanPlayer(20);
		controller = new Controller(computerPlayer, humanPlayer, new Dice(4321));
		controller.start();
		assertEquals(100, computerPlayer.getComputerScore());
		assertEquals(21, humanPlayer.getHumanScore());
	}
}
