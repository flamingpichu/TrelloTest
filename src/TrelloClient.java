import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * HTTP client to send requests to Trello
 */
public class TrelloClient {

   private CloseableHttpClient httpClient;
   private String appKey;
   private String token;

   public TrelloClient(String applicationKey, String userToken) {
      this.httpClient = HttpClients.createDefault();
      this.appKey = applicationKey;
      this.token = userToken;
   }

   public String createBoard() {

      return "";
   }
}
