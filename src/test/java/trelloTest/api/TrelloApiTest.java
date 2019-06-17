package trelloTest.api;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import trelloTest.api.model.Cards;
import trelloTest.api.model.CheckList;
import trelloTest.api.model.ListOnBoard;

import java.io.IOException;
import java.util.List;

public class TrelloApiTest {

    private TrelloApi trelloApi;
    private List<ListOnBoard> listOnBoardList;
    private List<Cards> cardList;
    private List<CheckList> checklistsList;

    private static final String BOARD_ID_SHORT = "tBlWs9fq";
    private static final String BOARD_ID = "5ce422edf8b1357014edf236";

    @BeforeSuite
    public void getBoardsListTest() throws IOException {
        trelloApi = new TrelloApi();
        listOnBoardList = trelloApi.getFieldsOnBoardsList(BOARD_ID);
        cardList = trelloApi.getCardList(listOnBoardList.get(0).id);
        checklistsList = trelloApi.getCheckListsList(cardList.get(0).id);
    }

    @Test
    public void createListTest() throws IOException {
        Cards list = new Cards();
        list.name = "New List";
        trelloApi.createList(BOARD_ID, list);
    }

    @Test
    public void createCardTest() throws IOException {
        ListOnBoard list = listOnBoardList.get(0);
        Cards card = new Cards();
        card.name = "CardTemp: " + list.name;
        card.desc = "New Awersome CardTemp";
        trelloApi.createCard(list.id, card);
    }

    @Test
    public void CreateChecklistTest() throws IOException {
        Cards card = cardList.get(0);
        CheckList checkList = new CheckList();
        checkList.name = "New checklist";
        trelloApi.createChecklist(card.id, checkList);
    }

    TrelloRestClient client = new TrelloRestClient();

//    @Test
//    public void adasda() throws IOException {
//        List<ListOnBoard> body = client.boardsService.getLists("0L69AHpE").execute().body();
//        body.forEach(t -> System.out.println(t.name));
//    }
//
//    @Test
//    public void createBoard() throws IOException, InterruptedException {
//        Board board = client.boardsService.createBoard("Lolik 25").execute().body();
//        board.desc = "ASDASDDSADASSDASDASASDDASDAS";
//        client.boardsService.updateBoard(board.id, board).execute();
//
//    }
}

