package trelloTest.api;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import trelloTest.api.model.Board;
import trelloTest.api.model.Card;
import trelloTest.api.model.ListOnBoard;

import java.io.IOException;
import java.util.List;

public class CardsServiceClass {

    TrelloRestClient client = new TrelloRestClient();
    List<Board> boardList;
    List<ListOnBoard> listOnBoards;
    List<Card> cardList;
    Card card;

    @BeforeTest
    public void setUp() throws IOException {
        boardList = client.boardsService.getMembersBoards("mykola175").execute().body();
        listOnBoards = client.listsService.getLists(boardList.get(0).id).execute().body();
    }


    @Test
    public void getCardsList() throws IOException {
        cardList = (client.cardService.getCards(listOnBoards.get(0).id).execute().body());
        cardList.forEach(System.out::println);
    }

    @Test
    public void createCard() throws IOException {
        card = client.cardService.createCard("New Created Card", listOnBoards.get(0).id).execute().body();
    }

    @Test
    public void modifyCard() throws IOException {
        card.name = "Updated name";
        card = client.cardService.updateCard(card.id, card).execute().body();
    }

    @Test
    public void deleteCard() throws IOException {
        System.out.println(client.cardService.deleteCard(card.id).execute().body());
    }
}
