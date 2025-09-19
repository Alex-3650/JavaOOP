package Singleton;

import java.util.ArrayList;
import java.util.List;

public class DataStore {
    private static  List<String> data=new ArrayList<>();

    private static  DataStore instance;




    private DataStore(List<String> data)  {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
       DataStore.data =data;

    }

    public  void addInfo(String str){
        data.add(str);
    }

    public String getAllStrings(){
        return String.join(" ",data);
    }

    public static DataStore getInstance() {
        if (instance==null){
            instance=new DataStore(data);
        }
        return instance;
    }

}
