import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Testing delete card API
 */
public class DeleteCardTest {

   private TrelloClient client;
   private String idCard;

   @Before
   public void setUp() {
      client = new TrelloClient(Constants.APPLICATION_KEY, Constants.USER_TOKEN);
      String idBoard = client.createBoard();
      String idList = client.createList(idBoard);
      this.idCard = client.createCard(idList);
   }

   @Test
   public void testDeleteCard() {
      boolean deleted = client.deleteCard(idCard);
      assertTrue(deleted);
   }
}
