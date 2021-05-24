package it.polimi.ingsw.model.personalboard;

import it.polimi.ingsw.exceptions.InvalidSlotException;
import it.polimi.ingsw.model.Points;
import it.polimi.ingsw.model.cards.DevCard;

import java.util.ArrayList;
import java.util.Iterator;

public class DevCardSlot implements Points {
    private final ArrayList<DevCard>[] slot;
    private final ArrayList<DevCard> ActiveCards;
    private int VictoryPoints;

    public DevCardSlot() {
        this.slot = new ArrayList[3];
        slot[0]=new ArrayList<>();
        slot[1]=new ArrayList<>();
        slot[2]=new ArrayList<>();
        ActiveCards=new ArrayList<>();
        VictoryPoints=0;
    }


    /**
     * @return actual slot at the call moment
     */
    public ArrayList<DevCard>[] getSlot() {
        return slot;
    }

    public ArrayList<DevCard> getDevCards(){
        ArrayList<DevCard> cards= new ArrayList<>();
        for(int i=0;i<3;i++)
            cards.addAll(slot[i]);
        return cards;
    }

    public ArrayList<DevCard> getDevCards(){
        ArrayList<DevCard> cards=new ArrayList<>();
        for (int i=0;i<3;i++)
            cards.addAll(slot[i]);
        return cards;
    }

    /**
     * @param devCard is the card that is added in slot
     * @param slotID is the selected row
     * @return slot after overlapped devcard, if it is possible
     * @throws InvalidSlotException if selected slot is not between 0 and 2
     */
    public ArrayList<DevCard>[] overlap(DevCard devCard, int slotID)  {
        for(int row=0;row<3;row++){
                if(!slot[slotID].isEmpty()){
                    if(devCard.getLevel()==slot[slotID].get(row).getLevel()+1 && slot[slotID].get(row).isActive()) {
                        slot[slotID].get(row).setActive(false);
                        slot[slotID].add(devCard);
                        slot[slotID].get(row + 1).setActive(true);
                        return slot;
                    }
                }
                else if (devCard.getLevel()==1&&slot[slotID].isEmpty()){
                    slot[slotID].add(devCard);
                    slot[slotID].get(0).setActive(true);
                    return slot;
                }
        }
        return slot;
    }

    /**
     * @return only active cards in game
     */
    public ArrayList<DevCard> getActiveCards() {
        for(int i=0;i<=2;i++){
                Iterator<DevCard> iterator = slot[i].iterator();
                while (iterator.hasNext()) {
                    DevCard dev= iterator.next();
                    if (dev.isActive())
                        ActiveCards.add(dev);
                }
            }
        return ActiveCards;
    }

    /**
     * @return at the end of game points aggregated in all development cards
     */
    @Override
    public int getPoints(){
        for (int i=0;i<=2;i++){
                for(DevCard dev:slot[i])
                       VictoryPoints = (int) (VictoryPoints + dev.getPoints());
        }
        return VictoryPoints;
    }

}
