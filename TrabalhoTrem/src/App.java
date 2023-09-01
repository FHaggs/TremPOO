public class App {
    public static void main(String[] args) throws Exception {
        Locomotiva l1 = new Locomotiva(01, 1, 10);
        Locomotiva l2 = new Locomotiva(02, 1, 10);
        Vagao v1 = new Vagao(01, 0.5);
        Vagao v2 = new Vagao(02, 0.5);
        Trem t1 = new Trem(01);

        t1.addLocomotiva(l1);
        t1.addLocomotiva(l2);
        t1.addVagao(v1);
        t1.addVagao(v2);

        System.out.print(t1);
    }
}
