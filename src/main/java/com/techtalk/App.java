package com.techtalk;

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        String host = InetAddress.getLocalHost().getHostName();
        HttpServer server = HttpServer.create(new InetSocketAddress(9090), 0);
        server.createContext("/", exchange -> {
            String html = "<html><body style='font-family:sans-serif;text-align:center;margin-top:60px'>"
                + "<h1>TechTalk Sample Application</h1>"
                + "<p>Server: " + host + "</p>"
                + "<p>Java: " + System.getProperty("java.version") + "</p>"
                + "<p>10 + 20 = " + calc.add(10, 20) + "</p>"
                + "<p>5 x 6 = " + calc.multiply(5, 6) + "</p>"
                + "<h3>Built by Maven, deployed by Jenkins</h3>"
                + "</body></html>";
            byte[] bytes = html.getBytes();
            exchange.getResponseHeaders().add("Content-Type", "text/html");
            exchange.sendResponseHeaders(200, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) { os.write(bytes); }
        });
        server.start();
        System.out.println("App running on port 9090");
    }
}
