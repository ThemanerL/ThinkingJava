package multithread;

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
  }

  public boolean isStaticFile(String uri) {
    return SUFFIX.stream().anyMatch(uri::endsWith);
  }

  public static void main(String[] args) {
    ThreadPoolExecutor threadPool = new ThreadPoolExecutor(99999, 99999, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new UserThreadFactory("localhost"));
    for (int i = 0; i < 99980; i++) {
      threadPool.execute(() -> new AppStaticFileDefault().isStaticFile(RandomStringUtils.randomAlphanumeric(6) + SUFFIX.get(new Random().nextInt(SUFFIX.size()))));
    }
  }
}
