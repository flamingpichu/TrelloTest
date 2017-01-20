import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.util.Map;

/**
 * This class prepares a HTTP POST request for the Trello API
 */
public class TrelloPost implements TrelloRequest {

   private HttpPost request;

   public TrelloPost(String url, Map<String, String> args) {
      HttpPost postRequest = new HttpPost(url);
      JsonObjectBuilder builder = Json.createObjectBuilder();
      for (Map.Entry<String, String> entry : args.entrySet()) {
         builder.add(entry.getKey(), entry.getValue());
      }
      JsonObject json = builder.build();
      StringEntity input = new StringEntity(json.toString(), ContentType.APPLICATION_JSON);
      postRequest.setEntity(input);
      this.request = postRequest;
   }

   @Override
   public HttpUriRequest getRequest() {
      return request;
   }
}
