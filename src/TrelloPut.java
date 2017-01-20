import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.util.Map;

/**
 * This class prepares a HTTP PUT request for the Trello API
 */
public class TrelloPut implements TrelloRequest {

   private HttpPut request;

   public TrelloPut(String url, Map<String,String> args) {
      HttpPut putRequest = new HttpPut(url);
      JsonObjectBuilder builder = Json.createObjectBuilder();
      for (Map.Entry<String, String> entry : args.entrySet()) {
         builder.add(entry.getKey(), entry.getValue());
      }
      JsonObject json = builder.build();
      StringEntity input = new StringEntity(json.toString(), ContentType.APPLICATION_JSON);
      putRequest.setEntity(input);
      this.request = putRequest;
   }

   @Override
   public HttpUriRequest getRequest() {
      return request;
   }
}
