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
		HumanPlayer humanPlayer = new HumanPlayer(10);
		char decision = humanPlayer.humanMove(9);
		assertEquals('r', decision);
		
		decision = humanPlayer.humanMove(10);
		assertEquals('h', decision);
		
		decision = humanPlayer.humanMove(11);
		assertEquals('h', decision);
		
		//humanPlayer = new HumanPlayer();
		//decision = humanPlayer.human(10);
		//org.junit.Assert.assertTrue(decision == 'r' ||decision == 'h');
	}
	
	@Test
	public void testComputerMove(){
		//test computer decisions, as well as set get and mutators for ComputerPlayer
		ComputerPlayer computerPlayer = new ComputerPlayer();
		computerPlayer.setComputerScore(71);
		char decision = computerPlayer.computerMove(computerPlayer.getComputerScore(), 70, 10 );
		assertEquals('r', decision);
		
		computerPlayer.setComputerScore(70);
		decision = computerPlayer.computerMove(computerPlayer.getComputerScore(), 71, 10 );
		assertEquals('r', decision);
		
		computerPlayer.setComputerScore(71);
		decision = computerPlayer.computerMove(computerPlayer.getComputerScore(), 71, 10 );
		assertEquals('r', decision);
		
		computerPlayer.setComputerScore(70);
		decision = computerPlayer.computerMove(computerPlayer.getComputerScore(), 70, 10 );
		assertEquals('r', decision);
		
		computerPlayer.setComputerScore(70);
		decision = computerPlayer.computerMove(computerPlayer.getComputerScore(), 70, 30 );
		assertEquals('h', decision);
		
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
		//test controller with fixed seed value
		ComputerPlayer computerPlayer = new ComputerPlayer();
		HumanPlayer humanPlayer = new HumanPlayer(10);
		Controller controller = new Controller(computerPlayer, humanPlayer, new Dice(1234));
		controller.start();
		assertEquals(37, computerPlayer.getComputerScore());
		assertEquals(101, humanPlayer.getHumanScore());
	}
}
