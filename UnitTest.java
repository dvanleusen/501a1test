import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UnitTest {
	@Test
	public void TestDecision() {
		//test human decisions	
		HumanPlayer humanPlayer = new HumanPlayer(10);
		char decision = humanPlayer.human(9);
		assertEquals('r', decision);
		
		decision = humanPlayer.human(10);
		assertEquals('h', decision);
		
		decision = humanPlayer.human(11);
		assertEquals('h', decision);
		
		//humanPlayer = new HumanPlayer();
		//decision = humanPlayer.human(10);
		//org.junit.Assert.assertTrue(decision == 'r' ||decision == 'h');
		
		//test human constructor, accessor, and mutator
		humanPlayer.setHumanScore(10);
		assertEquals(10, humanPlayer.getHumanScore());

		//test computer decisions
		ComputerPlayer computerPlayer = new ComputerPlayer();
		computerPlayer.setComputerScore(71);
		decision = computerPlayer.computer(computerPlayer.getComputerScore(), 70, 10 );
		assertEquals('r', decision);
		
		computerPlayer.setComputerScore(70);
		decision = computerPlayer.computer(computerPlayer.getComputerScore(), 71, 10 );
		assertEquals('r', decision);
		
		computerPlayer.setComputerScore(71);
		decision = computerPlayer.computer(computerPlayer.getComputerScore(), 71, 10 );
		assertEquals('r', decision);
		
		computerPlayer.setComputerScore(70);
		decision = computerPlayer.computer(computerPlayer.getComputerScore(), 70, 10 );
		assertEquals('r', decision);
		
		computerPlayer.setComputerScore(70);
		decision = computerPlayer.computer(computerPlayer.getComputerScore(), 70, 30 );
		assertEquals('h', decision);
		
		computerPlayer.setComputerScore(70);
		decision = computerPlayer.computer(computerPlayer.getComputerScore(), 70, 21 );
		assertEquals('h', decision);
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
