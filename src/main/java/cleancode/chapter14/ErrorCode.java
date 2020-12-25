package cleancode.chapter14;

/**
 * 异常错误码枚举类
 *
 * @author 李重辰
 * @date 2020/12/25 14:01
 */
public enum ErrorCode {
  OK(0),
  INVALID_ARGUMENT_FORMAT(1), UNEXPECTED_ARGUMENT(2), INVALID_ARGUMENT_NAME(3),
  MISSING_STRING(4),
  MISSING_INTEGER(5), INVALID_INTEGER(6),
  MISSING_DOUBLE(7), INVALID_DOUBLE(8);
  int code;

  ErrorCode(int code) {
    this.code = code;
  }
}
