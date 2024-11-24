package shadenade62.http.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private int port;

    public Server(int port){
        this.port=port;
    }

    public void start(){
        try (ServerSocket serverSocket= new ServerSocket(port))
        {
            System.out.println("Server is online,port: "+ port);
            Map<String, MyWebApp> router= new HashMap<>();
            router.put("/calculator", new CalculatorWebApp());
            router.put("/greetings", new GreetingsWebApp());
            router.put("/items",new ItemWebApp());
            System.out.println("mapping is built for endpoints");
            router.entrySet().forEach(e-> System.out.println(e.getKey()+": "+ e.getValue().getClass().getSimpleName()));
            System.out.println("server is ready to work");

            while(true){
                try(Socket socket=serverSocket.accept())
                {
                    System.out.println("User connected");
                    byte[] buffer=new byte[2048];
                    int n=socket.getInputStream().read(buffer);
                    String rawRequest=new String(buffer,0,n);
                    Request request=new Request(socket.getInputStream());

                    request.show();
                    boolean executed=false;
                    for (Map.Entry<String,MyWebApp> e : router.entrySet()){
                        if(request.getUri().startsWith(e.getKey())){
                            e.getValue().execute(request,socket.getOutputStream());
                            executed=true;
                            break;
                        }
                    }
                    if(!executed){
                        socket.getOutputStream().write(("HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n<html><body><h1>Unknown app</h1></body></hwml>").getBytes(StandardCharsets.UTF_8));
                    }
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}

