package trelloTest.api;

import org.testng.annotations.Test;
import trelloTest.api.model.Board;
import trelloTest.api.model.Card;
import trelloTest.api.model.TrelloList;

import java.io.IOException;
import java.util.List;

public class TrelloApiTest {

    @Test
    public void TrelloTest() throws IOException {
        TrelloApi trelloApi = new TrelloApi();
        List<TrelloList> boardsList = trelloApi.GetBoardList("tBlWs9fq");
        for (TrelloList list : boardsList) {
            System.out.println(list.name);
            Card card = new Card();
            card.name = "Card: " + list.name;
            card.desc = "Awersome Card";
            trelloApi.createCard(list.id, card);
        }
//        trelloApi.createCard("5cf68fb106b2587cf694ba6b");
    }

    TrelloRestClient client = new TrelloRestClient();

    @Test
    public void adasda() throws IOException {
        List<TrelloList> body = client.boardsService.getLists("0L69AHpE").execute().body();
        body.forEach(t -> System.out.println(t.name));
    }

    @Test
    public void createBoard() throws IOException, InterruptedException {
        Board board = client.boardsService.createBoard("Lolik 25").execute().body();
        board.desc = "ASDASDDSADASSDASDASASDDASDAS";
        client.boardsService.updateBoard(board.id, board).execute();

    }
}

