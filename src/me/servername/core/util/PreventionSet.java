package me.servername.core.util;

public class PreventionSet {

    private boolean canBreak;
    private boolean canPlace;
    private boolean canDamage;
    private boolean canMove;
    private boolean canConsume;

    public boolean canPlace() {
        return canPlace;
    }

    public void setCanPlace(boolean canPlace) {
        this.canPlace = canPlace;
    }

    public boolean canBreak() {
        return canBreak;
    }

    public void setCanBreak(boolean canBreak) {
        this.canBreak = canBreak;
    }

    public boolean canDamage() {
        return canDamage;
    }

    public void setCanDamage(boolean canDamage) {
        this.canDamage = canDamage;
    }

    public boolean canMove() {
        return canMove;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }

    public boolean canConsume() {
        return canConsume;
    }

    public void setCanConsume(boolean canConsume) {
        this.canConsume = canConsume;
    }

    public String toString(){
        return ("{break="+canBreak+",place="+canPlace+",damage="+canDamage+",move="+canMove+",consume="+canConsume+"}");
    }

}