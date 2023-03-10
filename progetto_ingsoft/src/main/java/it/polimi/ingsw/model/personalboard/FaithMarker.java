package it.polimi.ingsw.model.personalboard;

import it.polimi.ingsw.model.Points;

public class FaithMarker implements Points {

    /**
     * this is the position of the faith marker in faith track
     */
    private int faithPosition;

    /**
     * this boolean indicates if the cross is in a Vatican zone
     */
    private boolean inVaticanZone;

    /**
     * this is the amount of points gained from the faith track
     */
    private int points;

        public FaithMarker( ) {
        this.faithPosition = 0;
        this.inVaticanZone = false;
    }

    /**
     * @return the position of faith marker
     */
    public int getFaithPosition() {
        return faithPosition;
    }


    /**
     * @return reset faith marker position, then return the starting position
     */
   public int reset(){
       return faithPosition = 0;
   }

    /**
     * @return true if this faith marker is in a Vatican zone
     * @param i is the number of the Pope meeting to check
     */
    public boolean isVaticanZone(int i){
        inVaticanZone=false;
        switch (i){
            case 1:
                if (getFaithPosition() >= 5 && getFaithPosition() <= 8){
                    inVaticanZone=true;
                    break;
                }
            case 2:
                if (getFaithPosition() >= 12 && getFaithPosition() <= 16){
                    inVaticanZone=true;
                    break;
                }
            case 3:
                if (getFaithPosition() >= 19 && getFaithPosition() <= 24){
                    inVaticanZone=true;
                    break;
                }
        }
        return inVaticanZone;
    }

    /**
     * @return points according to current faith position
     */
    public int setPoints(){
        switch (faithPosition) {
            case 3 :points = 1;
            break;
            case 6 : points = 2;
            break;
            case 9 : points = 4;
            break;
            case 12 : points = 6;
            break;
            case 15 : points = 9;
            break;
            case 18 : points = 12;
            break;
            case 21 : points = 16;
            break;
            case 24 : points = 20;
        }
        return points;
    }

    /**
     * @return points of faith track
     */
    @Override
    public int getPoints() {
        return points;
    }

    /**
     * @return following position & checking if it will be in a pope space or in a vatican zone
     */
    public int updatePosition(){
        faithPosition= faithPosition +1;
        setPoints();
        isVaticanZone(24);
        return faithPosition;
    }
}