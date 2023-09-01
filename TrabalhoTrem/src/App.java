public class App {
    public static void main(String[] args) throws Exception {
        Patio p1 = new Patio();
        
        Locomotiva l1 = new Locomotiva(111, 10, 10);
        Locomotiva l2 = new Locomotiva(222, 10, 10);
        Locomotiva l3 = new Locomotiva(333, 10, 10);
        Locomotiva l4 = new Locomotiva(444, 10, 10);
        Vagao v1 = new Vagao(111, 1);
        Vagao v2 = new Vagao(222, 1);
        Vagao v3 = new Vagao(333, 1);
        Vagao v4 = new Vagao(444, 1);

        Trem t1 = new Trem(111);
        p1.add(t1);

        t1.addLocomotiva(l1);
        t1.addLocomotiva(l2);
        t1.addLocomotiva(l3);
        t1.addLocomotiva(l4);
        t1.addVagao(v1);
        t1.addVagao(v2);
        t1.addVagao(v3);
        t1.addVagao(v4);

        System.out.print(p1);

    }
}
