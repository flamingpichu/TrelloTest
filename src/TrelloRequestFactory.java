import java.util.Map;

/**
 * Factory to make requests
 */
public class TrelloRequestFactory {

   public TrelloRequest getTrelloRequest(String type, String url, Map<String, String> args) {
      if (type == null) {
         return null;
      }
      if (type.equalsIgnoreCase("POST")) {
         return new TrelloPost(url, args);
      } else if (type.equalsIgnoreCase("PUT")) {
         return new TrelloPut(url, args);
      } else if (type.equalsIgnoreCase("DELETE")) {
         return new TrelloDelete(url);
      }
      return null;
   }
}
