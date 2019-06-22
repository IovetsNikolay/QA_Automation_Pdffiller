package trelloTest.api.servises;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import trelloTest.api.model.Board;
import trelloTest.api.model.ListOnBoard;

import java.util.List;

public interface BoardsService {
    @GET("members/{id}/boards")
    Call<List<Board>> getMembersBoards(@Path("id")String id);

    @POST("boards")
    Call<Board> createBoard(@Query("name") String name);

    @DELETE("boards/{id}")
    Call<ResponseBody> deleteBoard(@Path("id")String id);

    @PUT("boards/{id}")
    Call<Board> updateBoard(@Path("id")String id, @Body Board board);

}
