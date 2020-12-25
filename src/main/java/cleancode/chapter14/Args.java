package cleancode.chapter14;

import cleancode.chapter14.marshalerimpl.BooleanArgumentMarshaler;
import cleancode.chapter14.marshalerimpl.DoubleArgumentMarshaler;
import cleancode.chapter14.marshalerimpl.IntegerArgumentMarshaler;
import cleancode.chapter14.marshalerimpl.StringArgumentMarshaler;
import cleancode.chapter14.marshalerimpl.StringArrayArgumentMarshaler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import static cleancode.chapter14.ErrorCode.INVALID_ARGUMENT_FORMAT;
import static cleancode.chapter14.ErrorCode.INVALID_ARGUMENT_NAME;
import static cleancode.chapter14.ErrorCode.UNEXPECTED_ARGUMENT;

/**
 * @author 李重辰
 * @date 2020/12/25 9:50
 */
public class Args {
  private static final String SCHEMA_DELIMITER = ",";

  private Map<Character, ArgumentMarshaler> marshalerMap;
  private Set<Character> argsFound;
  private ListIterator<String> currentArgument;

  public Args(String schema, String[] args) throws ArgsException {
    marshalerMap = new HashMap<>();
    argsFound = new HashSet<>();
    parseSchema(schema);
    parseArgumentString(Arrays.asList(args));
  }

  private void parseSchema(String schema) throws ArgsException {
    for (String element : schema.split(SCHEMA_DELIMITER)) {
      if (element.length() > 0) {
        parseSchemaElement(element.trim());
      }
    }
  }

  private void parseSchemaElement(String element) throws ArgsException {
    char elementId = element.charAt(0);
    String elementTail = element.substring(1);
    validateSchemaElementId(elementId);
    if (elementTail.length() == 0) {
      marshalerMap.put(elementId, new BooleanArgumentMarshaler());
    } else if (elementTail.equals("*")) {
      marshalerMap.put(elementId, new StringArgumentMarshaler());
    } else if (elementTail.equals("#")) {
      marshalerMap.put(elementId, new IntegerArgumentMarshaler());
    } else if (elementTail.equals("##")) {
      marshalerMap.put(elementId, new DoubleArgumentMarshaler());
    } else if (elementTail.equals("[*]")) {
      marshalerMap.put(elementId, new StringArrayArgumentMarshaler());
    } else {
      throw new ArgsException(INVALID_ARGUMENT_FORMAT, elementId, elementTail);
    }
  }

  private void validateSchemaElementId(char elementId) throws ArgsException {
    if (!Character.isLetter(elementId)) {
      throw new ArgsException(INVALID_ARGUMENT_NAME, elementId, null);
    }
  }

  private void parseArgumentString(List<String> argsList) throws ArgsException {
    for (currentArgument = argsList.listIterator(); currentArgument.hasNext(); ) {
      String argString = currentArgument.next();
      if (argString.startsWith("-")) {
        parseArgumentCharacters(argString.substring(1));
      } else {
        currentArgument.previous();
        break;
      }
    }
  }

  private void parseArgumentCharacters(String argChars) throws ArgsException {
    for (int i = 0; i < argChars.length(); i++) {
      parseArgumentCharacter(argChars.charAt(i));
    }
  }

  private void parseArgumentCharacter(char argChar) throws ArgsException {
    ArgumentMarshaler marshaler = marshalerMap.get(argChar);
    if (marshaler == null) {
      throw new ArgsException(UNEXPECTED_ARGUMENT, argChar, null);
    } else {
      argsFound.add(argChar);
      try {
        marshaler.set(currentArgument);
      } catch (ArgsException e) {
        e.setErrorArgumentId(argChar);
        throw e;
      }
    }
  }

  public boolean has(char arg) {
    return argsFound.contains(arg);
  }

  public int nextArgument() {
    return currentArgument.nextIndex();
  }

  public boolean getBoolean(char arg) {
    return BooleanArgumentMarshaler.getValue(marshalerMap.get(arg));
  }

  public String getString(char arg) {
    return StringArgumentMarshaler.getValue(marshalerMap.get(arg));
  }

  public int getInt(char arg) {
    return IntegerArgumentMarshaler.getValue(marshalerMap.get(arg));
  }

  public double getDouble(char arg) {
    return DoubleArgumentMarshaler.getValue(marshalerMap.get(arg));
  }

  public String[] getStringArray(char arg) {
    return StringArrayArgumentMarshaler.getValue(marshalerMap.get(arg));
  }

  public static void main(String[] args)   {
    try {
      Args arg = new Args("l,p#,d*", args);
      boolean logging = arg.getBoolean('l');
      int port = arg.getInt('p');
      String directory = arg.getString('d');
//      executeApplication(logging, port, directory);
    }  catch (ArgsException e) {
      System.out.printf("Argument error: %s\n", e.errorMessage());
    }
  }
}
