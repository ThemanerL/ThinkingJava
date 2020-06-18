package multithread;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 多线程可能有问题，待测试
 *
 * @author 李重辰
 * @date 2020/6/12 10:47
 */
@Slf4j
public class AppStaticFileDefault {
  private static final List<String> SUFFIX = new ArrayList<>();

  public AppStaticFileDefault() {
    SUFFIX.add(".css");
    SUFFIX.add(".js");
    SUFFIX.add(".jsp");
    SUFFIX.add(".htm");
    SUFFIX.add(".html");
    SUFFIX.add(".map");
    SUFFIX.add(".jpg");
    SUFFIX.add(".png");
    SUFFIX.add(".gif");
    SUFFIX.add(".icon");
    SUFFIX.add(".bmp");
    SUFFIX.add(".ico");
    SUFFIX.add(".mp3");
    SUFFIX.add(".mp4");
    SUFFIX.add(".apk");
    SUFFIX.add(".exe");
    SUFFIX.add(".manifest");
    SUFFIX.add(".ttf");
    System.out.println("实例化了一次");
  }

  public boolean isStaticFile(String uri) {
    System.out.println(uri);
    return SUFFIX.stream().anyMatch(uri::endsWith);
  }

  public static void main(String[] args) {
    ThreadPoolExecutor threadPool = new ThreadPoolExecutor(99999, 99999, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new UserThreadFactory("localhost"));
    for (int i = 0; i < 99; i++) {
      threadPool.execute(() -> {
        AppStaticFileDefault appStaticFileDefault = new AppStaticFileDefault();
        String s = RandomStringUtils.randomAlphanumeric(6) + SUFFIX.get(new Random().nextInt(SUFFIX.size()));
        appStaticFileDefault.isStaticFile(s);
      });
    }
  }
}
