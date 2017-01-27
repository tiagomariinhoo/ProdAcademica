package prodacademica;

import java.util.ArrayList;
import java.util.Scanner;


public class Colaboradores {
    
    private String nome;
    private int idade;
    private String endereco;
    private String email;
    private int cargo;


    Projeto projeto_alocado[] = new Projeto [50]; //Array contendo os ids dos projetos alocados ao colaborador
    ArrayList <Projeto> proj = new ArrayList<Projeto>();
    /*public Colaboradores(String nome, String endereco, String email, int idade) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.idade= idade;
    }*/

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }
    
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
   
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void listarProjetos(){
        for(int i=0;i<projeto_alocado.length;i++){
            if(projeto_alocado[i]!=null){
                System.out.println("Projeto alocado ao colaborador " + getNome());
                projeto_alocado[i].mostrarProjeto();
                System.out.println("----------");
            }
        }
    }
    
    public void mostrarColaborador(ArrayList <Colaboradores> col){
        Scanner scan = new Scanner (System.in);
        
        if(col.size()==0){
            System.out.println("Ainda não há colaboradores registrados!");
            return ;
        }
        
        System.out.println("1 - Procurar colaborador");
        System.out.println("2 - Listar colaboradores");
        int op = scan.nextInt();
        
            if(op==1){
                System.out.println("Digite o nome do colaborador que deseja ser encontrado : ");
                scan.nextLine();
                String nome = scan.nextLine();
            }
                for(int i=0;i<col.size();i++){
                    if(op==1){
                        if(col.get(i).nome.equals(nome)){
                            System.out.println("Nome : " + col.get(i).getNome());
                            System.out.println("Idade : " + col.get(i).getIdade());
                            System.out.println("Endereco : " + col.get(i).getEndereco());
                            System.out.println("Email : " + col.get(i).getEmail());
                            if(col.get(i).getCargo()==1){
                                System.out.println("Cargo : Aluno de graduação");
                            } else if (col.get(i).getCargo()==2){
                                System.out.println("Cargo : Aluno de mestrado");
                            } else if (col.get(i).getCargo()==3){
                                System.out.println("Cargo : Aluno de doutorado");
                            } else if (col.get(i).getCargo()==4){
                                System.out.println("Cargo : Professor");
                            } else if (col.get(i).getCargo()==5){
                                System.out.println("Cargo : Pesquisador");
                            }
                            System.out.println("---------------");
                        }
                    return ;
                    } else if (op==2){
                            System.out.println("Nome : " + col.get(i).getNome());
                            System.out.println("Idade : " + col.get(i).getIdade());
                            System.out.println("Endereco : " + col.get(i).getEndereco());
                            System.out.println("Email : " + col.get(i).getEmail());
                            if(col.get(i).getCargo()==1){
                                System.out.println("Cargo : Aluno de graduação");
                            } else if (col.get(i).getCargo()==2){
                                System.out.println("Cargo : Aluno de mestrado");
                            } else if (col.get(i).getCargo()==3){
                                System.out.println("Cargo : Aluno de doutorado");
                            } else if (col.get(i).getCargo()==4){
                                System.out.println("Cargo : Professor");
                            } else if (col.get(i).getCargo()==5){
                                System.out.println("Cargo : Pesquisador");
                            }
                            System.out.println("---------------");
                    }
            }
        
        
    
    }
    
    public Colaboradores adicionarColaborador(){
        Colaboradores col = new Colaboradores();
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Digite o nome do colaborador : ");
        String nome = scan.nextLine();
        col.setNome(nome);
        
        System.out.println("Digite a idade do colaborador : ");
        int idade = scan.nextInt();
        col.setIdade(idade);
        
        scan.nextLine();
        System.out.println("Digite o endereço do colaborador : ");
        String endereco = scan.nextLine();
        col.setEndereco(endereco);
        
        System.out.println("Digite o email do colaborador : ");
        String email = scan.nextLine();
        col.setEmail(email);
       
        System.out.println("Digite o cargo do colaborador : ");
        System.out.println("1 - Graduação");
        System.out.println("2 - Mestrado");
        System.out.println("3 - Doutorado");
        System.out.println("4 - Professor");
        System.out.println("5 - Pesquisador");
        
        int flag=0;
        int op;
        do{
            op = scan.nextInt();
            if(op>0 && op<6) flag=1;
            else {
                System.out.println("Por favor, selecione uma opção válida!");
            }
        } while(flag==0);
        
        col.setCargo(op);
        
        System.out.println("Colaborador adicionado com sucesso!");
        return col;
    }
    
    
    public int menuColaborador(){
        Scanner scan = new Scanner(System.in);
        Colaboradores col_aux = new Colaboradores();
        
        System.out.println("--------------------");
        System.out.println("1 - Adicionar colaborador");
        System.out.println("2-  Remover colaborador");
        System.out.println("3 - Alterar colaborador");
        System.out.println("4 - Listar colaboradores");
        System.out.println("0 - Sair");
        try{
            int op = scan.nextInt();
                return op;
            
        } catch(Exception e){
            System.out.println("Selecione uma opção válida!");
        }
        
        return -1;
    }
    
    public void removerColaborador(ArrayList <Colaboradores> col){
        if(col.size()==0){
            System.out.println("Ainda não há colaboradores registrados!");
            return ;
        }
        System.out.println("----- LISTA DE COLABORADORES -----");
        for(int i=0;i<col.size();i++){
            System.out.println("Colaborador : " + col.get(i).getNome());
        }
        System.out.println("---------------");
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o nome do colaborador que será removido : ");
        String nome = scan.nextLine();
        
        for(int i=0;i<col.size();i++){
            if(col.get(i).nome.equals(nome)){
                System.out.println("Colaborador "+ col.get(i).nome + " removido com sucesso!");
                System.out.println("----------");
                col.remove(i);
                return ;
            }
        }
        System.out.println("Colaborador não encontrado.");
        System.out.println("----------");
    }
   
    public void alterarColaborador(ArrayList <Colaboradores> col){
        if(col.size()==0){
            System.out.println("Ainda não há colaborador registrado!");
            return;
        }
        Scanner scan = new Scanner(System.in);
        
        for(int i=0;i<col.size();i++){
            System.out.println("Colaborador : " + col.get(i).getNome());
            System.out.println("----------");
        }
    
        System.out.println("Digite o nome do colaborador que terá alteração : ");
        String nome = scan.nextLine();
            for(int i=0;i<col.size();i++){
                if(col.get(i).getNome().equals(nome)){
                    System.out.println("Selecione o que deseja alterar : ");
                    System.out.println("1 - Nome");
                    System.out.println("2 - Idade");
                    System.out.println("3 - Endereço");
                    System.out.println("4 - Email");
                    System.out.println("5 - Cargo");
                    System.out.println("0 - Sair");
                    int op = scan.nextInt();
                        if(op==1){
                            scan.nextLine();
                            System.out.println("Digite o nome : ");
                            nome = scan.nextLine();
                            col.get(i).setNome(nome);
                        } else if(op==2){
                            System.out.println("Digite a idade : ");
                            int idade = scan.nextInt();
                            col.get(i).setIdade(idade);
                        } else if(op==3){
                            System.out.println("Digite o endereço : ");
                            scan.nextLine();
                            nome = scan.nextLine();
                            col.get(i).setEndereco(nome);
                        } else if(op==4){
                            System.out.println("Digite o email : ");
                            scan.nextLine();
                            nome = scan.nextLine();
                            col.get(i).setEmail(nome);
                        } else if(op==5){
                            System.out.println("Digite o novo cargo : ");
                            System.out.println("1 - Graduação");
                            System.out.println("2 - Mestrado");
                            System.out.println("3 - Doutorado");
                            System.out.println("4 - Professor");
                            System.out.println("5 - Pesquisador");
                            int cargo = scan.nextInt();
                            col.get(i).setCargo(cargo);
                        }
                }
            }
        
        
    }
}
