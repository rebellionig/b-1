package shadenade62.http.server;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class GreetingsWebApp implements MyWebApp
{
    public String name;

    public GreetingsWebApp()
    {
        this.name="Greetings Web Application";
    }
    @Override
    public void execute(Request request, OutputStream output) throws IOException {
        String username=request.getParam("username");
        output.write(("HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n<html><body><h1>" + name + "</h1><h2>Hello, " + username + "</h2></body></html>").getBytes(StandardCharsets.UTF_8));
    }
}
