package shadenade62.http.server;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ItemWebApp implements MyWebApp{
    private String name;
    private List<Item> items;

    public ItemWebApp(){
        this.name="Item web app";
        this.items= List.of(
                new Item("box",1L),
                new Item("phone",2L),
                new Item("table",3L)
        );
    }
    @Override
    public void execute(Request request, OutputStream output) throws IOException{
        StringBuilder builder=new StringBuilder("[ ");
        for (int i =0; i<items.size(); i++){
            builder.append("{ \"id\": ").append(items.get(i).getId()).append(",\"title\":\"").append(items.get(i).getTitle()).append("\"}");
            if (i<items.size()- 1){
                builder.append(", ");
            }
            builder.append(" ]");
        }
        output.write(("" +
                "HTTP/1.1 200 OK\r\n" +
                "Content Type: application/json\r\n" +
                "Access-Control-Allow-Origin: *\r\n" +
                "\r\n" +
                builder
        ).getBytes(StandardCharsets.UTF_8));

    }

}
