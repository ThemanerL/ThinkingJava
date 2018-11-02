package thinkingjava.chapter10.practice;

/**
 * 不继承外围类直接继承内部类重新了内部类方法
 * @author 李重辰
 * @date 2018/11/2 12:11
 */
class P26 {
    class P26Inner{
        private int i;
        public P26Inner(int i) {
            this.i = i;
        }
        void overWriter(){
            System.out.println("P26.P26Inner.overWriter");
        }
    }
}

class P26final extends P26.P26Inner{
    P26final(P26 p26,int i) {
        p26.super(i);
    }

    @Override
    void overWriter() {
        System.out.println("P26final.overWriter");
    }

    public static void main(String[] args) {
        P26 p26 = new P26();
        P26final p26final = new P26final(p26,32);
        p26final.overWriter();
    }
}