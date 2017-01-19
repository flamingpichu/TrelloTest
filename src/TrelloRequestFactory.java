import java.util.Map;

/**
 * Created by Jonathan on 1/19/2017.
 */
public class TrelloRequestFactory {


   public TrelloRequest getTrelloRequest(String type, String url, Map<String, String> args) {
      if (type == null) {
         return null;
      }
      if (type.equalsIgnoreCase("POST")) {
         return new TrelloPost();
      } else if (type.equalsIgnoreCase("PUT")) {
         return new TrelloPut();
      } else if (type.equalsIgnoreCase("DELETE")) {
         return new TrelloDelete();
      }
      return null;
   }
}
