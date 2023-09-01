import java.util.Scanner;

public class App {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        


        Patio p1 = new Patio();
        GaragemLocomotivas garagemLocomotivas = new GaragemLocomotivas();
        GaragemVagao garagemVagoes = new GaragemVagao();

        
        Locomotiva l1 = new Locomotiva(111, 10, 10);
        Locomotiva l2 = new Locomotiva(222, 10, 10);
        Locomotiva l3 = new Locomotiva(333, 10, 10);
        Locomotiva l4 = new Locomotiva(444, 10, 10);
        Vagao v1 = new Vagao(111, 1);
        Vagao v2 = new Vagao(222, 1);
        Vagao v3 = new Vagao(333, 1);
        Vagao v4 = new Vagao(444, 1);

        garagemLocomotivas.add(l1);
        garagemLocomotivas.add(l2);
        garagemLocomotivas.add(l3);
        garagemLocomotivas.add(l4);
        garagemVagoes.add(v1);
        garagemVagoes.add(v2);
        garagemVagoes.add(v3);
        garagemVagoes.add(v4);

        int opcao = -1;

        while(opcao != 5){
           opcoes();
           opcao = input.nextInt();

           switch(opcao) {
            case 1:
                criarTrem(p1, garagemLocomotivas);
            
            }


        }


        Trem t1 = new Trem(111);
        Trem t2 = new Trem(222);

        p1.add(t1);
        p1.add(t2);

        System.out.print(p1);
        input.close();
    }
    public static void criarTrem(Patio p1, GaragemLocomotivas garagemLocomotivas){

        System.out.println("Digite o id do novo trem");
        int id = input.nextInt();
        Trem novoTrem = new Trem(id);
        p1.add(novoTrem);

        System.out.println("Adicione uma locomotiva");
        System.out.println(garagemLocomotivas);

        Locomotiva aux;

        do {
            int idLocomotiva = input.nextInt();
            aux = garagemLocomotivas.retiraPorId(idLocomotiva);

            if(aux == null){
                System.out.println("Essa locomotiva não existe");
            }
        }while(aux == null);

        novoTrem.addLocomotiva(aux);

        System.out.println("Novo Trem criado");
        System.out.println(novoTrem);

    }

    public static void opcoes(){
        System.out.println("Digite uma opção: ");
        System.out.println("[1] Criar trem");
        System.out.println("[2] Editar trem");
        System.out.println("[3] Listar trens");
        System.out.println("[4] Desmontar trem");
        System.out.println("[5] Sair do programa");
    }
}
