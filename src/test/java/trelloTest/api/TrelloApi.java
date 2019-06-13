package trelloTest.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import trelloTest.api.model.Card;
import trelloTest.api.model.TrelloList;

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

    public List<TrelloList> GetBoardList(String boardId) throws IOException {
        Request request = new Request.Builder().url("https://api.trello.com/1/boards/" +boardId+ "/lists?cards=none&fields=all&key=" +KEY+ "&token="+TOKEN)
                .build();
        String response = client.newCall(request).execute().body().string();
        Type type = new TypeToken<List<TrelloList>>(){}.getType();
        List<TrelloList> trelloLists = gson.fromJson(response, type);
        return trelloLists;
    }

    public void createCard(String listId, Card card) throws IOException {
        String json = gson.toJson(card);            //???
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/cards?idList="+listId+"&keepFromSource=all&key="+KEY+"&token="+TOKEN)
                .post(body)
                .build();
        String response = client.newCall(request).execute().body().string();
        System.out.println(response);
    }

//    public void createList (String boardId, Card card) {
//        String json = gson.toJson(card);
//        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
//        RequestBody body = new Request.Builder()
//                .url("https://api.trello.com/1/lists?name=name&idBoard=" + boardId + "&key="+KEY+"&token="+TOKEN)
//                .post();
//
//
//
//    }
}
