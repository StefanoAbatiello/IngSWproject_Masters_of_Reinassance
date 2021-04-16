package it.polimi.ingsw.model.Market;

import it.polimi.ingsw.exceptions.FullSupplyException;
import it.polimi.ingsw.model.Player;
import it.polimi.ingsw.model.Resource;
import it.polimi.ingsw.model.personalboard.FaithMarker;

public class PurpleMarble implements MarketMarble {

    final Resource resource=Resource.SERVANT;
    /**
     * this subclass override this method and put a servant in  resourceSupply
     * @param faithMarker is a reference to the player's FaithMarker
     * @param player      is a reference to the player
     * @return true if method putResourceInContainer works correctly
     */
    @Override
    public boolean changeMarble(FaithMarker faithMarker, Player player) throws FullSupplyException {
        ResourceSupply.putResourceInContainer(resource);
        return true;
    }
}
