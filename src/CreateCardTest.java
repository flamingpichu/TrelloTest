import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

/**
 * Testing create card API
 */
public class CreateCardTest {

   private TrelloClient client;
   private String idList;

   @Before
   public void setUp() {
      client = new TrelloClient(Constants.APPLICATION_KEY, Constants.USER_TOKEN);
      String idBoard = client.createBoard();
      this.idList = client.createList(idBoard);
   }


   @Test
   public void testCreateCard() {
      String id = client.createCard(idList);
      assertNotNull(id);
   }
}
