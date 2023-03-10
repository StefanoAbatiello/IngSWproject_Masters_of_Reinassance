package it.polimi.ingsw.model.singlePlayerMode;

import it.polimi.ingsw.model.SinglePlayer;
import it.polimi.ingsw.model.cards.DevCard;
import it.polimi.ingsw.model.cards.DevDeckMatrix;

import java.io.IOException;
import java.util.ArrayList;

import it.polimi.ingsw.model.cards.cardExceptions.playerLeadsNotEmptyException;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiscardDevCardActionTest {

    /*
    this Test is implemented to check if the token's effect of removing a card works correctly
     */
    @Test
    void applyEffect() throws playerLeadsNotEmptyException, IOException, ParseException {
        int i=1;
        SinglePlayer sP = new SinglePlayer("USER");
        ArrayList<DevCard> devDeck = sP.getDevDeckMatrix().getDevMatrix()[i][0].getLittleDevDeck();
        String color = devDeck.get(0).getColor();
        DiscardDevCardAction token = new DiscardDevCardAction(color,sP);
        token.applyEffect(sP.getTokensStack());
        devDeck.remove(0);
        assertEquals(devDeck,sP.getDevDeckMatrix().getDevMatrix()[i][0].getLittleDevDeck());
    }
}