package thinkingjava.typeinfo;

/**
 * @author 李重辰
 * @date 2019/12/20 11:31
 */
public class Position {
  private String title;
  private Person person;

  public Position(String title, Person person) {
    this.title = title;
    this.person = person;
    if (person == null) {
      person = Person.NULL;
    }
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Person getPerson() {
    return person;
  }

  @Override
  public String toString() {
    return "{\"Position\":{" +
        "\"title\":\"" + title + '\"' +
        ", \"person\":" + person +
        "}}";
  }

  public void setPerson(Person person) {
    this.person = person;
    if (person == null) {
      person = Person.NULL;
    }
  }

  public Position(String title) {
    this.title = title;
    person = Person.NULL;
  }
}
