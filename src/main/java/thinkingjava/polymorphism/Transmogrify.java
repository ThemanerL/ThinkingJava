package thinkingjava.polymorphism;

/**
 * 在设计类的时候,首先使用"组合",尤其是不能确定应该使用哪一种方式时,组合不会强制我们的程序设计进入继承的层次结构中.
 * 而且组合更加灵活,因为它可以动态选择类型(因此也就选择了行为):相反,继承在编译时就需要知道确切类型
 * <p>
 * 在这里引用(actor)在运行时与另一个不同的对象重新绑定起来,所以SadActor对象的引用可以在actor中被替代,
 * 然后performPlay()产生的行为也发生改变.这样一来,我们在运行时期获得了动态灵活性,(这也叫做状态模式)
 * <p>
 * 一条准则是:用继承表达行为之间的差异,并用字段表达状态上的变化.
 * 通过继承得到两个不同的子类,用于表达act的差异,而stage通过运用组合使自己的状态发生变化.于此处,状态的变化产生了行为的变化
 *
 * @author 李重辰
 * @date 2018/10/5 18:55
 */
public class Transmogrify {
  public static void main(String[] args) {
    Stage stage = new Stage();
    stage.performPlay();
    stage.change();
    stage.performPlay();
  }
}

class Stage {
  private Actor actor = new HappyActor();

  void change() {
    actor = new SadActor();
  }

  void performPlay() {
    actor.act();
  }
}

class Actor {
  public void act() {
  }
}

class HappyActor extends Actor {
  @Override
  public void act() {
    System.out.println("HappyActor.act");
  }
}

class SadActor extends Actor {
  @Override
  public void act() {
    System.out.println("SadActor.act");
  }
}