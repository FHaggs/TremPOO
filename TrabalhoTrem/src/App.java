import java.util.ArrayList;
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
        Vagao v1 = new Vagao(111, 3);
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
                    if(!garagemLocomotivas.cheio()){
                        System.out.println("\nA garagem de locomotivas está vazia");
                        break;
                    }

                    criarTrem(p1, garagemLocomotivas);
                    
                    break;
                case 2:
                    if(!p1.cheio()){
                        System.out.println("Não existe trens no patio para edita-los");
                        break;
                    }
                    System.out.println("\nSelecione um trem do pátio para editar");
                    System.out.println(p1);

                    int idTrem = input.nextInt();

                    Trem editarTrem = p1.getTrem(idTrem);
                    editarTrem(editarTrem, garagemVagoes, garagemLocomotivas);
                    break;

            case 3:
                System.out.println(p1);
                break;

            case 4:
                    if(p1.cheio()){
                    
                        System.out.println("\nSelecione um trem do pátio para desmontar:");
    
                        System.out.println(p1);
    
                        int idTremDesmontar = input.nextInt();

                        Trem desmontarTrem = p1.getTrem(idTremDesmontar);
                        desmontaTrem(desmontarTrem, p1, garagemLocomotivas, garagemVagoes);
                        break;

                    }
                    
                    System.out.println("\nO pátio está vazio, não é possivel desmontar");
                    break;
            }

        }

        input.close();
    }
    public static void desmontaTrem(Trem t, Patio p1, GaragemLocomotivas garagemLocomotivas, GaragemVagao garagemVagoes){
        ArrayList<Vagao> vagoesLivres = t.desmontaVagao();
        ArrayList<Locomotiva> locomotivasLivres = t.desmontaLocomotiva();

        for(Vagao v: vagoesLivres){
            v.sairTrem();
            garagemVagoes.add(v);
        }
        for(Locomotiva l: locomotivasLivres){
            l.sairTrem();
            garagemLocomotivas.add(l);
        }
        p1.removePorId(t.getId());

        System.out.println("\nTrem desmontado\n");
        
    }
    private static void addLocomotiva(Trem t, GaragemLocomotivas garagemLocomotivas){
        System.out.println("\nAdicione uma locomotiva:\n");
        System.out.println(garagemLocomotivas);

        Locomotiva aux;

        do {
            int idLocomotiva = input.nextInt();
            aux = garagemLocomotivas.retiraPorId(idLocomotiva);

            if(aux == null){
                System.out.println("Essa locomotiva não existe");
            }
        }while(aux == null);

        t.addLocomotiva(aux);

        System.out.println("Locomotiva adicionada");
        System.out.println(t);
    }

    private static void addVagao(Trem t, GaragemVagao garagemVagoes){
        System.out.println("Escolha um vagão para ser adicionado:");
        System.out.println(garagemVagoes);

        Vagao aux;

        do {
            int idVagao = input.nextInt();
            aux = garagemVagoes.retiraPorId(idVagao);

            if(aux == null){
                System.out.println("Esse Vagao não existe");
            }
        }while(aux == null);

        boolean foiAdicionado = t.addVagao(aux);
        if(foiAdicionado){
            System.out.println("Vagao adicionado");
        }else {
            System.out.println("Esse trem não tem capacidade!");
        }
    }
    public static void editarTrem(Trem t, GaragemVagao garagemVagoes, GaragemLocomotivas garagemLocomotivas){
        int opcao = 0;
        


        System.out.println("\nDeseja adicionar partes ou remove-las?");
        System.out.println("[1] Adicionar");
        System.out.println("[2] Remover");
        opcao = input.nextInt();
        while(opcao != 1 && opcao != 2){
            System.out.println("\nUtilize uma opção valida.");
            opcao = input.nextInt();
        }

        if(opcao == 1){
            if(t.temVagao()){
                addVagao(t, garagemVagoes);
            }else {
                System.out.println("\nDeseja adicionar uma locomotiva ou um vagão?");
                System.out.println("[1] Locomotiva");
                System.out.println("[2] Vagão");
                opcao = input.nextInt();
                while(opcao != 1 && opcao != 2){
                    System.out.println("\nUtilize uma opção valida.");
                    opcao = input.nextInt();
                }
                if(opcao == 1 && garagemLocomotivas.cheio()){
                    addLocomotiva(t, garagemLocomotivas);
                }else if(opcao == 2 && garagemVagoes.cheio()){
                    addVagao(t, garagemVagoes);
                } else{
                    System.out.println("\nParece que a garagem selecionada está vazia");
                }
                
            }
        }
        else {
            if(t.temVagao()){
                // Remover  vagoes
                Vagao v = t.retiraVagao();
                garagemVagoes.add(v);
                System.out.println("\nEsse Vagão for retirado do trem e colocado na garagem");
                System.out.println(v);
                
            }else {
                if(t.ultimaLocomotiva()){
                    System.out.println("\nNão é possivel retirar a ultima locomotiva, se desejar é possivel desmontar esse trem");
                    
                }
                else{

                    Locomotiva l = t.retiraLocomotiva();
                    garagemLocomotivas.add(l);
                    System.out.println("\nEssa locomotiva foi retirada do trem e colocada na garagem");
                    System.out.println(l);

                }
            }
        }


    }

    public static void criarTrem(Patio p1, GaragemLocomotivas garagemLocomotivas){

        System.out.println("\nDigite o id do novo trem:\n");
        int id = input.nextInt();

        if(!p1.verificarId(id)){
            System.out.println("\nId de trem já existe, tente outra Id\n");
            
        } else{
            
            Trem novoTrem = new Trem(id);
            p1.add(novoTrem);
            addLocomotiva(novoTrem, garagemLocomotivas);

        }

        
    }

    public static void opcoes(){
        System.out.println("\nDigite uma opção: ");
        System.out.println("[1] Criar trem");
        System.out.println("[2] Editar trem");
        System.out.println("[3] Listar trens");
        System.out.println("[4] Desmontar trem");
        System.out.println("[5] Sair do programa");
    }
}
