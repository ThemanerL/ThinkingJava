package multithread;

import java.util.ArrayList;
import java.util.List;

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
}
