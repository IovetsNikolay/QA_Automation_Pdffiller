package trelloTest.api.servises;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import trelloTest.api.model.Card;
import trelloTest.api.model.ListOnBoard;

import java.util.List;

public interface CardService {

    @GET("cards/{id}/list")
    Call<List<Card>> getCards(@Path("id")String id);

    @POST("cards")
    Call<Card> createCard(@Query("name") String name, @Query("idList") String idList);

    @PUT("cards/{id}")
    Call<Card> UpdateCard(@Path("id")String id, @Body Card card);

    @DELETE("/cards/{id}")
    Call<ResponseBody> deleteCard(@Path("id")String id);
}
