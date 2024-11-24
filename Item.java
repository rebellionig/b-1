package shadenade62.http.server;

public class Item {
    private Long id;
    private String title;
    public long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public Item(){

    }
    public Item(String title, Long id){
        this.title=title;
        this.id=id;
    }

}
