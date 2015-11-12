package me.servername.core.util;

import me.servername.core.Main;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Config {

    private File f;
    private YamlConfiguration conf;

    public Config(String name){
        try {
            if(!Main.getInstance().getDataFolder().exists()) Main.getInstance().getDataFolder().mkdir();
            name += ".yml";
            if(name.contains("/")){
                String[] arr = name.split("/");
                gen(arr);
            }else{
                gen(name);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public YamlConfiguration getConfiguration(){
        return this.conf;
    }

    public void save(){
        try{
            conf.save(f);
        }catch(Exception ignored){}
    }

    private void gen(String[] arr) {
        try {
            File last_file = Main.getInstance().getDataFolder();
            for (String s : arr) {
                last_file = new File(last_file, s);
                if (!last_file.exists()) {
                    if (s.endsWith(".yml")) {
                        last_file.createNewFile();
                        break;
                    } else last_file.mkdir();
                }
            }
            this.f = last_file;
            this.conf = YamlConfiguration.loadConfiguration(f);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void gen(String name){
        gen(new String[]{name});
    }

}