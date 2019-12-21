package thinkingjava.typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李重辰
 * @date 2019/12/21 17:02
 */
public class P15PetCreator extends AbstractPetCreator {
  @Override
  public List<Class<? extends Pet>> getTypes() {
//    ArrayList<Class ? ex
    return null;
  }

  @Override
  public Pet[] createArray(int size) {
    return super.createArray(size);
  }

  @Override
  public ArrayList<Pet> arraysList(int size) {
    return super.arraysList(size);
  }

  @Override
  public Pet randomPet(){
    return null;
  }
}
