import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UnitTest {
	@Test
	public void TestDecision() {
		//test human decisions	
		HumanPlayer humanPlayer = new HumanPlayer(10, 'a');
		char decision = humanPlayer.human(9);
		assertEquals('r', decision);
		
		humanPlayer = new HumanPlayer(10, 'a');
		decision = humanPlayer.human(10);
		assertEquals('h', decision);
		
		humanPlayer = new HumanPlayer(10, 'a');
		decision = humanPlayer.human(11);
		assertEquals('h', decision);
		
		humanPlayer = new HumanPlayer(-1, 'i');
		decision = humanPlayer.human(10);
		org.junit.Assert.assertTrue(decision == 'r' ||decision == 'h');
		
		//test human constructor, accessor, and mutator
		humanPlayer.setHumanScore(10);
		assertEquals(10, humanPlayer.getHumanScore());

		//test computer decisions
		ComputerPlayer computerPlayer = new ComputerPlayer(71);
		decision = computerPlayer.computer(computerPlayer.getComputerScore(), 70, 10 );
		assertEquals('r', decision);
		
		computerPlayer = new ComputerPlayer(70);
		decision = computerPlayer.computer(computerPlayer.getComputerScore(), 71, 10 );
		assertEquals('r', decision);
		
		computerPlayer = new ComputerPlayer(71);
		decision = computerPlayer.computer(computerPlayer.getComputerScore(), 71, 10 );
		assertEquals('r', decision);
		
		computerPlayer = new ComputerPlayer(70);
		decision = computerPlayer.computer(computerPlayer.getComputerScore(), 70, 10 );
		assertEquals('r', decision);
		
		computerPlayer = new ComputerPlayer(70);
		decision = computerPlayer.computer(computerPlayer.getComputerScore(), 70, 30 );
		assertEquals('h', decision);
		
		computerPlayer = new ComputerPlayer(70);
		decision = computerPlayer.computer(computerPlayer.getComputerScore(), 70, 21 );
		assertEquals('h', decision);
		
		//test computer constructor, accessor, and mutator
		computerPlayer.setComputerScore(10);
		assertEquals(10, computerPlayer.getComputerScore());
	}

}
