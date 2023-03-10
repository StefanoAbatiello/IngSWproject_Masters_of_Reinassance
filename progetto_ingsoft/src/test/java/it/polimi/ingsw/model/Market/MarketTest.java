package it.polimi.ingsw.model.Market;

import it.polimi.ingsw.model.Player;
import it.polimi.ingsw.model.Resource;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MarketTest {



    /*
    this Test verifies if selecting a row(0<=selector<=2) the resources put in ResourceSupply are the expected ones
     */

    @Test
    void buyingRowTest() {
        Market market = new Market();
        MarketMarble[][] marketTray = market.getMarketBoard();
        ArrayList<Resource> resources = new ArrayList<>();
        Player p = new Player("0");
        int selector = 0;
        for (int i=0; i<4; i++) {
            MarketMarble marble = marketTray[selector][i];
            if (marble.getColor().equals("BLUE"))
                resources.add(Resource.SHIELD);
            else if (marble.getColor().equals("GREY"))
                resources.add(Resource.STONE);
            else if (marble.getColor().equals("PURPLE"))
                resources.add(Resource.SERVANT);
            else if (marble.getColor().equals("YELLOW"))
                resources.add(Resource.COIN);
        }
        market.buyResources(selector, p);
        assertEquals(resources, p.getResourceSupply().getResources());
    }

    /*
   this Test verifies if selecting a column(3<=selector<=6) the resources put in ResourceSupply are the expected ones
    */
    @Test
    void buyingColumnTest() {
        Market market = new Market();
        MarketMarble[][] marketTray = market.getMarketBoard();
        ArrayList<Resource> resources = new ArrayList<>();
        Player p = new Player("0");
        int selector = 4;
        for (int i=0; i<3; i++) {
            MarketMarble marble = marketTray[i][selector-3];
            if (marble.getColor().equals("BLUE"))
                resources.add(Resource.SHIELD);
            else if (marble.getColor().equals("GREY"))
                resources.add(Resource.STONE);
            else if (marble.getColor().equals("PURPLE"))
                resources.add(Resource.SERVANT);
            else if (marble.getColor().equals("YELLOW"))
                resources.add(Resource.COIN);
        }
        market.buyResources(selector, p);
        assertEquals(resources, p.getResourceSupply().getResources());
    }

    /*
   this Test verifies if selecting a row(0<selector<=2) the marketTray is modified correctly
    */
    @Test
    void insertExtMarbleInRowTest(){
        Market market=new Market();
        MarketMarble[][] marketTray= market.getMarketBoard();
        MarketMarble extMarble= market.getExtMarble();
        int selector = 2;
        MarketMarble[] line= new MarketMarble[4];
        MarketMarble[] newLine= new MarketMarble[4];
            for (int i = 1; i < 4; i++)
                line[i - 1] = marketTray[selector][i];
            line[3] = extMarble;
            market.buyResources(selector, new Player("0"));
            for (int i = 0; i < 4; i++)
                newLine[i] = marketTray[selector][i];
            assertArrayEquals(line, newLine);
    }

    /*
   this Test verifies if selecting a column(3<=selector<=6) the marketTray is modified correctly
    */
    @Test
    void insertExtMarbleInColumnTest(){
        Market market=new Market();
        MarketMarble[][] marketTray= market.getMarketBoard();
        MarketMarble extMarble= market.getExtMarble();
        int selector = 6;
        MarketMarble[] column= new MarketMarble[3];
        MarketMarble[] newColumn= new MarketMarble[3];
        for(int i=1; i<3; i++)
            column[i-1]=marketTray[i][selector-3];
        column[2]=extMarble;
        market.buyResources(selector,new Player("0"));
        for(int i=0; i<3; i++)
            newColumn[i]=marketTray[i][selector-3];
        assertArrayEquals(column,newColumn);
    }

}