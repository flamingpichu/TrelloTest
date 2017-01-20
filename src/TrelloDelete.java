import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpUriRequest;

import java.util.Map;

/**
 * This class prepares a HTTP DELETE request for the Trello API
 */
public class TrelloDelete implements TrelloRequest {

   private HttpDelete request;

   public TrelloDelete(String url) {
      HttpDelete deleteRequest = new HttpDelete(url);
      this.request = deleteRequest;
   }

   @Override
   public HttpUriRequest getRequest() {
      return request;
   }
}
