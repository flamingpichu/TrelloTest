import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testing edit card API
 */
public class EditCardTest {

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
   public void testEditCard() {
      String name = client.editCard(idCard);
      assertEquals("Edited Card", name);
   }
}
