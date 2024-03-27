import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

// Java 로 HTTP 서버(EndPoint) 만들기 예제
public class EndPointExample {
    // 생성자
    public EndPointExample() throws IOException {

    }

    // 서버 생성
    private void createServer() throws IOException {

    }

    static class SampleHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "REST Full API Test";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    // 서버 실행
    public void start() {

    }

    // 서버 종료
    public void stop() {

    }

    public static void main(String[] args) throws IOException {
        // HTTP 서버 생성
        HttpServer server = HttpServer.create(new InetSocketAddress(8083), 0);

        // http://localhost:8083/ 엔드포인트 생성
        server.createContext("/", new SampleHandler());

        // http://localhost:8083/new 엔드포인트 생성
        server.createContext("/new", new SampleHandler());
        server.setExecutor(null);

        // 서버 시작
        server.start();
        System.out.println("서버 시작, port - 8083");

        // 서버 종료
        // server.stop(1);
        System.out.println("서버 종료");
    }
}
