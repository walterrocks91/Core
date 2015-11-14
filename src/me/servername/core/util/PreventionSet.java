package me.servername.core.util;

public class PreventionSet {

    private boolean canBreak = false;
    private boolean canPlace = false;
    private boolean canDamage = false;
    private boolean canMove = false;
    private boolean canConsume = false;
    private boolean isInvincible = false;

    public void setInvincible(boolean invincible){ this.isInvincible = invincible; }

    public boolean isInvincible(){ return isInvincible; }

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
        return ("{break="+canBreak+",place="+canPlace+",damage="+canDamage+",move="+canMove+",consume="+canConsume+",invincible="+isInvincible+"}");
    }

}