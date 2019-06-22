package trelloTest.api;

import org.testng.annotations.Test;
import trelloTest.api.model.Board;
import trelloTest.api.model.Card;
import trelloTest.api.model.ListOnBoard;

import java.io.IOException;
import java.util.List;

public class BoardServiceClass {

    TrelloRestClient client = new TrelloRestClient();
    List<Board> boardList;
    Board board;

    @Test(dependsOnMethods = "updateBoard")
    public void getBoardList() throws IOException {
        boardList = (client.boardsService.getMembersBoards("mykola175").execute().body());
        boardList.forEach(e -> System.out.println(e));
    }

    @Test
    public void createBoard() throws IOException {
        board = client.boardsService.createBoard("Vasia Pupkin1").execute().body();
        System.out.println(board);
    }

    @Test(dependsOnMethods = "createBoard")
    public void updateBoard() throws IOException {
        board.desc = "ASDASDDSADASSDASDASASDDASDAS";
        client.boardsService.updateBoard(board.id, board).execute();
    }

    @Test(dependsOnMethods = "getBoardList")
    public void deleteBoard() throws IOException {
        client.boardsService.deleteBoard(boardList.get(0).id).execute();
    }

}
