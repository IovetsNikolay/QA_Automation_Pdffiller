package trelloTest.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import trelloTest.api.model.Cards;
import trelloTest.api.model.CheckList;
import trelloTest.api.model.ListOnBoard;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TrelloApi {

    public static final String KEY = "854673677fcfa7ebe096e48ba019982a";
    public static final String TOKEN = "eb0a688d69badfd17c66087857003fe4ff63667bdbcd012d4dd1d8bcdb124854";
    Gson gson = new Gson();

    OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build();

    public List<ListOnBoard> getFieldsOnBoardsList(String boardId) throws IOException {               ///boards/{id}/lists
        Request request = new Request.Builder().url("https://api.trello.com/1/boards/" +boardId+ "/lists?cards=none&fields=all&key=" +KEY+ "&token="+TOKEN)
                .build();
        String response = client.newCall(request).execute().body().string();
        Type type = new TypeToken<List<ListOnBoard>>(){}.getType();
        List<ListOnBoard> listOnBoard1s = gson.fromJson(response, type);
        System.out.println(response);
        return listOnBoard1s;
    }

    public List<Cards> getCardList(String listId) throws IOException {           ///lists/{id}/cards
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/lists/" + listId + "/cards?key=" + KEY + "&token="+ TOKEN)
                .build();
        String response = client.newCall(request).execute().body().string();
        Type type = new TypeToken<List<Cards>>(){}.getType();
        List<Cards> cards = gson.fromJson(response, type);
        System.out.println(response);
        return cards;
    }

    public List<CheckList> getCheckListsList (String cardID) throws IOException {           ///cards/{id}/checklists
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/cards/" + cardID + "/checklists?checkItems=all&checkItem_fields=name%2CnameData%2Cpos%2Cstate&filter=all&fields=all&key=" + KEY + "&token="+ TOKEN)
                .build();
        String response = client.newCall(request).execute().body().string();
        Type type = new TypeToken<List<CheckList>>(){}.getType();
        List<CheckList> checklistList = gson.fromJson(response, type);
        System.out.println(response);
        return checklistList;
    }

    public void createList (String boardId, Cards list) throws IOException {          ///lists
        String json = gson.toJson(list);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/lists?name=" + list.name + "&idBoard=" + boardId + "&key=" + KEY + "&token=" +TOKEN)
                .post(body)
                .build();
        String response = client.newCall(request).execute().body().string();
        System.out.println(response);
    }

    public void createCard(String listId, Cards card) throws IOException {
        String json = gson.toJson(card);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/cards?name="+ card.name + "&desc=" + card.desc + "&idList=" + listId + "&keepFromSource=all&key=" + KEY + "&token=" + TOKEN)
                .post(body)
                .build();
        String response = client.newCall(request).execute().body().string();
        System.out.println(response);
    }

    public void createChecklist (String cardId, CheckList checkList) throws IOException {
        String json = gson.toJson(checkList);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/checklists?idCard=" + cardId + "&name=" + checkList.name + "&key=" + KEY + "&token=" + TOKEN)
                .post(body)
                .build();
        String response = client.newCall(request).execute().body().string();
        System.out.println(response);
    }
}
