package it.polimi.ingsw.model.Market;

import it.polimi.ingsw.model.Player;
import it.polimi.ingsw.model.Resource;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GreyMarbleTest {

    /*
    this Test is implemented to check if a GreyMarble is transformed in a correctly
    */
    @Test
    void changeMarbleTest() {
        GreyMarble marble=new GreyMarble();
        Player p=new Player("0");
        marble.changeMarble(p);
        ArrayList<Resource> resources=new ArrayList<>();
        resources.add(Resource.STONE);
        assertEquals(resources,p.getResourceSupply().getResources());
    }

}