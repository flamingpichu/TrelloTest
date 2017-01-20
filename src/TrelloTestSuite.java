import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Trello Test Suite
 */

@RunWith(Suite.class)

@Suite.SuiteClasses({
      CreateCardTest.class,
      EditCardTest.class,
      DeleteCardTest.class
})

public class TrelloTestSuite {
}
