package study.nio;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class PathDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path path = Paths.get("d:/tmp");
        final WatchService ws = path.getFileSystem().newWatchService();
        path.register(ws, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE
                , StandardWatchEventKinds.ENTRY_MODIFY);
        new Thread(() -> {
            while (true) {
                try {
                    WatchKey key = ws.take();
                    List<WatchEvent<?>> events = key.pollEvents();
                    events.stream().forEach(a -> {
                        System.out.println(a.context() + "#" + a.kind());
                    });
                    key.reset();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
