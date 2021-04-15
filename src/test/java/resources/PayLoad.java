package resources;

public class PayLoad {

    public static String addUser(int userId,String name){
        return "{\n" +
                "        \"id\": "+userId+",\n" +
                "        \"name\": \""+name+"\",\n" +
                "        \"username\": \"Harry.Stanton\",\n" +
                "        \"email\": \"Ram.Padberg@karina.biz\",\n" +
                "        \"address\": {\n" +
                "            \"street\": \"Abbey Raod\",\n" +
                "            \"suite\": \"Suite 198\",\n" +
                "            \"city\": \"London\",\n" +
                "            \"zipcode\": \"31428-2261\",\n" +
                "            \"geo\": {\n" +
                "                \"lat\": \"-38.2386\",\n" +
                "                \"lng\": \"57.2232\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"phone\": \"024-648-1122\",\n" +
                "        \"website\": \"ambrose.net\",\n" +
                "        \"company\": {\n" +
                "            \"name\": \"Hoeger LLC\",\n" +
                "            \"catchPhrase\": \"Centralized empowering task-force\",\n" +
                "            \"bs\": \"target end-to-end models\"\n" +
                "        }\n" +
                "    }";
    }
}
