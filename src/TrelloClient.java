import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * HTTP client to send requests to Trello
 */
public class TrelloClient {

   private CloseableHttpClient httpClient;
   private String appKey;
   private String token;
   private TrelloRequestFactory requestFactory;

   public TrelloClient(String applicationKey, String userToken) {
      this.httpClient = HttpClients.createDefault();
      this.appKey = applicationKey;
      this.token = userToken;
      this.requestFactory = new TrelloRequestFactory();
   }

   /**
    * Create New Board
    * @return id of newly created board, null if failed to create
    */
   public String createBoard() {
      Map<String,String> args = new HashMap<>();
      args.put("name","New Board");
      args.put("key",appKey);
      args.put("token",token);
      TrelloRequest request = requestFactory.getTrelloRequest("POST", "https://api.trello.com/1/boards", args);

      JsonObject json = executeRequest(request.getRequest());

      return json.getString("id", null);
   }

   /**
    * Create New List under specified board
    * @param idBoard id of the board
    * @return id of new list, null if failed to create
    */
   public String createList(String idBoard) {
      Map<String,String> args = new HashMap<>();
      args.put("name", "New List");
      args.put("key", appKey);
      args.put("token", token);
      args.put("idBoard", idBoard);
      TrelloRequest request = requestFactory.getTrelloRequest("POST", "https://api.trello.com/1/lists", args);

      JsonObject json = executeRequest(request.getRequest());

      return json.getString("id", null);
   }

   /**
    * Create New Card under specified list
    * @param idList id of the list
    * @return id of the new card, null if failed to create
    */
   public String createCard(String idList) {
      Map<String,String> args = new HashMap<>();
      args.put("name", "New Card");
      args.put("key", appKey);
      args.put("token", token);
      args.put("idList", idList);
      TrelloRequest request = requestFactory.getTrelloRequest("POST", "https://api.trello.com/1/cards", args);

      JsonObject json = executeRequest(request.getRequest());

      return json.getString("id", null);
   }

   public boolean deleteCard(String idCard) {
      String url = "https://api.trello.com/1/cards/" + idCard + "?key=" + appKey + "&token=" + token;
      TrelloRequest request = requestFactory.getTrelloRequest("DELETE", url, null);

      JsonObject json = executeRequest(request.getRequest());

      return json.containsKey("_value");
   }

   public String editCard(String idCard) {
      String url = "https://api.trello.com/1/cards/" + idCard;
      Map<String,String> args = new HashMap<>();
      args.put("name", "Edited Card");
      args.put("key", appKey);
      args.put("token", token);
      TrelloRequest request = requestFactory.getTrelloRequest("PUT", url, args);

      JsonObject json = executeRequest(request.getRequest());

      return json.getString("name", null);
   }

   // helper function to get JSON response from request
   private JsonObject executeRequest(HttpUriRequest httpRequest) {
      try {
         CloseableHttpResponse response = httpClient.execute(httpRequest);

         if (response.getStatusLine().getStatusCode() != 200) {
            // return empty JSON object
            return Json.createObjectBuilder().build();
         }
         BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
         JsonReader jsonReader = Json.createReader(reader);
         JsonObject object = jsonReader.readObject();

         jsonReader.close();
         response.close();
         return object;

      } catch (IOException e) {
         return Json.createObjectBuilder().build();
      }
   }
}
