package Singleton;

public class Demo_Singleton {
    public static void main(String[] args) throws InterruptedException {



        DataStore dataStore1=DataStore.getInstance();
        dataStore1.addInfo("H");
        DataStore dataStore2=DataStore.getInstance();
        dataStore2.addInfo("E");
        DataStore dataStore3=DataStore.getInstance();
        dataStore3.addInfo("L");
        DataStore dataStore4=DataStore.getInstance();
        dataStore4.addInfo("L");
        DataStore dataStore5=DataStore.getInstance();
        dataStore5.addInfo("0");
        System.out.println(dataStore1.getAllStrings());


    }
}
