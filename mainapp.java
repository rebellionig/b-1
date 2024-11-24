package shadenade62.http.server;



public class mainapp {
    public static final int PORT = 8189;


    public static void main(String[] args) {
        Server server=new Server(PORT);
        server.start();
    }
}

/*ADD LOGGING(computing)
* threads pull for many users
* db connectivity pull
*
* add error when adding e.g.: a and c instead of b like error 4xx for html
*
*
//ability to choose answer code status
//ability to add into html body json object answer
//servlet scanning; on/off ability