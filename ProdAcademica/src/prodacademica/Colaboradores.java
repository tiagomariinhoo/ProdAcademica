package prodacademica;

import java.util.ArrayList;
import java.util.Scanner;


public class Colaboradores {
    
    private String nome;
    private int idade;
    private String endereco;
    private String email;
    private int cargo;
    private boolean alocado;


    ArrayList <Projeto> proj = new ArrayList <Projeto>();
    ArrayList <Colaboradores> colab = new ArrayList<Colaboradores>();

    
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
    
    public boolean getAlocado() {
        return alocado;
    }

    public void setAlocado(boolean alocado) {
        this.alocado = alocado;
    }
    
    public void alocarColaborador(ArrayList <Colaboradores> col, ArrayList<Projeto> proj){ //Professor -> Aluno // Professor -> Projeto
        if(col.size()==0){
            System.out.println("Ainda não há colaboradores registrados!");
        }
        
        Scanner scan = new Scanner(System.in);
         
         System.out.println("Deseja alocar : ");
         System.out.println("1 - Professor para aluno");
         System.out.println("2 - Professor para projeto");
         System.out.println("3 - Aluno para projeto");
         System.out.println("4 - Mudar status do projeto");
         int op = scan.nextInt();
            if(op==1){
                
                int contador=0;
                for(int i=0;i<col.size();i++){
                    if(col.get(i).getCargo()==4){
                        System.out.println("----- PROFESSOR -----");
                        System.out.println("Nome : " + col.get(i).getNome());
                        System.out.println("Numero : " + i);
                        System.out.println("---------------------");
                        contador++;
                    }
                }

                if(contador==0){
                    System.out.println("Não há professores registrados!");
                    return ;
                }
                
                System.out.println("Escolha o professor por número : ");
                int numb = scan.nextInt();
                    if(col.get(numb).getCargo()==4){
                        
                        int contador2=0;    
                            for(int i=0;i<col.size();i++){
                                if(col.get(i).getCargo()!=4 && col.get(i).getCargo()!=5){
                                    System.out.println("----- ALUNO -----");
                                    System.out.println("Aluno : " + col.get(i).getNome());
                                    System.out.println("Numero : " + i);
                                    System.out.println("-----------------");
                                    contador2++;
                                }
                            }
                            if(contador2==0){
                                System.out.println("Não há alunos registrados!");
                                return ;
                            }
                            
                        System.out.println("Escolha o aluno que receberá o professor como orientador : ");
                        int op3 = scan.nextInt();
                            if(col.get(op3).getCargo()!=5 && col.get(op3).getCargo()!=4){
                                col.get(op3).colab.add(col.get(numb)); //Professor a um aluno
                                System.out.println("Professor alocado com sucesso!");
                            } else {
                                System.out.println("Selecione uma opção válida!");
                                return ;
                            }

                    } else {
                        System.out.println("Por favor, selecione uma opção válida");
                        return ;
                    }
            } else if (op==2){
                
                int contador=0;
                for(int i=0;i<col.size();i++){
                    if(col.get(i).getCargo()==4){
                        System.out.println("----- PROFESSOR -----");
                        System.out.println("Nome : " + col.get(i).getNome());
                        System.out.println("Numero : " + i);
                        System.out.println("---------------------");
                        contador++;
                    }
                }

                if(contador==0){
                    System.out.println("Não há professores registrados!");
                    return ;
                }
                
                if(proj.size()==0){
                    System.out.println("Não há projetos registrados!");
                    return ;
                }
                
                System.out.println("Escolha o professor por número : ");
                int numb = scan.nextInt();
                    if(col.get(numb).getCargo()==4){
                        for(int i=0;i<proj.size();i++){
                            if(proj.get(i).getStatus().equals("Em elaboração")){
                                System.out.println("----- PROJETO -----");
                                System.out.println("Projeto : " + proj.get(i).getTitulo());
                                System.out.println("Numero : " + i);
                                System.out.println("-------------------");
                            }
                            
                        }
                        
                        System.out.println("Selecione o projeto por numero : ");
                        int op2 = scan.nextInt();

                            col.get(numb).proj.add(proj.get(op2));
                            proj.get(op2).colab.add(col.get(numb));
                            System.out.println("Projeto alocado com sucesso!");
                    } else {
                        System.out.println("Selecione uma opção válida!");
                        return ;
                    }
                
            } else if (op==3){
                int contador2=0;
                for(int i=0;i<col.size();i++){
                    if(col.get(i).getCargo()!=4 && col.get(i).getCargo()!=5 && col.get(i).alocado==false){
                        System.out.println("----- ALUNO -----");
                        System.out.println("Nome : " + col.get(i).getNome());
                        System.out.println("Numero : " + i);
                        System.out.println("-----------------");
                        contador2++;
                    }
                }
                
                
                
                if(contador2==0){
                    System.out.println("Não há alunos registrados!");
                    return ;
                }
                
                contador2=0;
                
                for(int i=0;i<proj.size();i++){
                    if(proj.get(i).getStatus().equals("Em elaboração")){
                        System.out.println("----- PROJETO ------");
                        System.out.println("Titulo : " + proj.get(i).getTitulo());
                        System.out.println("Numero : " + i);
                        System.out.println("-------------------");
                        contador2++;
                    }
                }
                
                if(contador2==0){
                    System.out.println("Não há projetos disponíveis!");
                    return ;
                }
                
                System.out.println("Selecione o aluno por numero : ");
                int op2 = scan.nextInt();
                
                System.out.println("Selecione o projeto por numero : ");
                int op3 = scan.nextInt();
                
                if(col.get(op2).proj.size()==0){
                    col.get(op2).proj.add(proj.get(op3));
                    System.out.println("Aluno alocado com sucesso!");
                } else {
                    System.out.println("O aluno " + col.get(op2).getNome() + " já faz parte de um projeto!");
                }
                    
                
            } else if (op==4){
                if(proj.size()==0){
                    System.out.println("Não há projetos disponíveis!");
                    return ;
                }
                
                for(int i=0;i<proj.size();i++){
                    System.out.println("----- PROJETO -----");
                    System.out.println("Titulo : " + proj.get(i).getTitulo());
                    System.out.println("Numero : " + i);
                    System.out.println("Status : " + proj.get(i).getStatus());
                    System.out.println("-------------------");
                }
            
                System.out.println("Selecione o projeto por numero : ");
                int op2 = scan.nextInt();
                    
                if(op2<0 || op2>proj.size()-1){
                        System.out.println("Selecione um projeto existente!");
                        return ;
                    }
            
                System.out.println("Digite o novo status do projeto : ");
                System.out.println("1 - Em elaboração");
                System.out.println("2 - Em andamento");
                System.out.println("3 - Concluído");
                
                int op3 = scan.nextInt();
                
                boolean pode = false;
                    if(op3==1){
                        proj.get(op2).setStatus("Em elaboração");
                        System.out.println("Status alterado com sucesso!");
                        return;
                    }
                    if(op3==2){ //Verificar se há professor no projeto para passar para andamento
                        System.out.println("Titulo : " + proj.get(op2).getTitulo());
                        System.out.println("Colaboradores : " + proj.get(op2).colab.size());
                        if(proj.get(op2).colab.size()>0){
                            System.out.println("Aqui1");
                            for(int i=0;i<proj.get(op2).colab.size();i++){
                                if(proj.get(op2).colab.get(i).cargo==4){
                                    pode = true;
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Não há ninguém associado a esse projeto, não pode mudar os status.");
                            return ;
                        }
                        
                        if(pode){
                            proj.get(op2).setStatus("Em andamento");
                            System.out.println("Status alterado com sucesso!");
                        } else {
                            System.out.println("Para que o projeto seja alterado para essa opção, precisa ter um professor alocado no projeto.");
                            return ;
                        }
                    } else if (op3==3){
                        if(proj.get(op2).publicacoes.size()>0){
                            proj.get(op2).setStatus("Concluído");
                            System.out.println("Status alterado com sucesso!");
                        } else {
                            System.out.println("O projeto precisa ter alguma publicação para ser concluido.");
                            return ;
                        }
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
                            
                            if(col.get(i).proj.size()>0){
                                System.out.println("Projeto alocado : ");
                                    Projeto proj = new Projeto();
                                    proj.mostrarProjeto(col.get(i).proj);
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
                            
                            if(col.get(i).proj.size()>0){
                                System.out.println("----------");
                                System.out.println("Projeto alocado : ");
                                    Projeto proj = new Projeto();
                                    proj.mostrarProjeto(col.get(i).proj);
                                System.out.println("----------");
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
        col.setAlocado(false);
        
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
        System.out.println("4 - Consultar colaboradores");
        System.out.println("5 - Alocação");
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
