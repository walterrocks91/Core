package me.servername.core.wrappers;

import me.servername.core.util.PreventionSet;

public class User {

    private PreventionSet prevention;

    public PreventionSet getPreventionSet(){
        if(prevention == null) prevention = new PreventionSet();
        return prevention;
    }

}