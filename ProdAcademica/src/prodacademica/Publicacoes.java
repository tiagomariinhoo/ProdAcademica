package prodacademica;

import java.util.ArrayList;
import java.util.Scanner;

public class Publicacoes {
    private String titulo;
    private String nome_conf;
    private int ano;
    ArrayList <Colaboradores> autores = new ArrayList <Colaboradores>();
    private boolean alocado;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNome_conf() {
        return nome_conf;
    }

    public void setNome_conf(String nome_conf) {
        this.nome_conf = nome_conf;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    public boolean getAlocado() {
        return alocado;
    }

    public void setAlocado(boolean alocado) {
        this.alocado = alocado;
    }
    
    public void alocarPublicacao(ArrayList<Projeto> proj, ArrayList<Publicacoes> pub){
        Scanner scan = new Scanner(System.in);
        
        
        
        
        if(proj.size()==0){
            System.out.println("Ainda não há projetos registrados!");
            return ;
        }
        
        if(pub.size()==0){
            System.out.println("Ainda não há publicacoes registradas!");
            return ;
        }
        int contador=0;
        for(int i=0;i<proj.size();i++){
            if(proj.get(i).getStatus().equals("Em andamento")){
                System.out.println("------- PROJETOS -------");
                System.out.println("Projeto : " + proj.get(i).getTitulo());
                System.out.println("Numero : " + i);
                System.out.println("Está disponível para ser associado à essa publicação.");
                System.out.println("------------------------");
                contador++;
            }
        }
        
        if(contador==0){
            System.out.println("Não há projetos em andamento.");
            return ;
        }
        
        contador=0;
        
        
        for(int i=0;i<pub.size();i++){
            if(pub.get(i).getAlocado()==false){
                System.out.println("------- PUBLICAÇÕES -------");
                System.out.println("Publicação : " + pub.get(i).getTitulo());
                System.out.println("Numero : " + i);
                System.out.println("Pode ser alocada para algum projeto.");
                System.out.println("---------------------------");
            }
        }
        
        System.out.println("Escolha o projeto para associar a publicação : ");
        int op = scan.nextInt();
        
        if(op<0 || op>proj.size()-1){
            System.out.println("Por favor, selecione um projeto existente!");
            return ;
        }
        
        System.out.println("Escolha a publicação para associar ao projeto : ");
        int op_aux = scan.nextInt();
        
        if(op<0 || op>pub.size()-1){
            System.out.println("Por favor, selecione uma publicação existente! ");
        }
        
        
        proj.get(op).publicacoes.add(pub.get(op_aux));
        System.out.println("Publicação alocada com sucesso!");
        proj.get(op).setAlocado(true);
        
        
        
    }
    
    public Publicacoes lancarPublicacao(ArrayList <Colaboradores> col){
        Scanner scan = new Scanner(System.in);
        Publicacoes pub = new Publicacoes();
        
        if(col.size()==0){
            System.out.println("Registre algum colaborador primeiro!");
            return null;
        }
        
        System.out.println("Digite o titulo da publicação : ");
        String titulo = scan.nextLine();
        pub.setTitulo(titulo);
        
        System.out.println("Digite o nome da conferência : ");
        String conf = scan.nextLine();
        pub.setNome_conf(conf);
        
        System.out.println("Digite o ano de publicação : ");
        int ano = scan.nextInt();
        pub.setAno(ano);
        
        pub.setAlocado(false);
    
        System.out.println("Escolha os autores da publicação : ");
        for(int i=0;i<col.size();i++){
            System.out.println("Nome : " + col.get(i).getNome());
            System.out.println("Numero : " + i);
            System.out.println("---------");
        }
        System.out.println("Quantidade de autores : ");
        int qt = scan.nextInt();
        
        if(qt>col.size() || qt==0){
            System.out.println("Selecione uma quantidade válida!");
            return null;
        }
        for(int i=0;i<qt;i++){
            System.out.println("Digite o numero do autor : ");
            int autor = scan.nextInt();
            
                if(autor>col.size()-1 || autor<0){
                    System.out.println("Selecione um autor valido!");
                    return null;
                }
            col.get(autor).pub.add(pub);
            pub.autores.add(col.get(autor));
        }
        
        System.out.println("Publicação registrada com sucesso!");
        
        
        return pub;
    }
    
    public void removerPublicacao(ArrayList <Publicacoes> pub){
        Scanner scan = new Scanner(System.in);
        
        if(pub.size()==0){
            System.out.println("Não há publicações registradas.");
            return ;
        }
        
        for(int i=0;i<pub.size();i++){
            System.out.println("Titulo : " + pub.get(i).getTitulo());
            System.out.println("Numero : " + i);
        }
        
        System.out.println("Insira o numero da publicação que deseja ser removida : ");
        int op = scan.nextInt();
        if(op<0 || op >pub.size()-1){
            System.out.println("Por favor, selecione uma publicação existente.");
            return ;
        }
        
        pub.remove(op);
        System.out.println("Publicação removida com sucesso!");
        
    }
    
    public void mostrarPublicacao(ArrayList<Publicacoes> pub){
        for(int i=0;i<pub.size();i++){
            System.out.println("Titulo : " + pub.get(i).getTitulo());
            System.out.println("Nome da conferência : " + pub.get(i).nome_conf);
            System.out.println("Ano de publicação : " + pub.get(i).getAno());
                for(int j=0;j<pub.get(i).autores.size();j++){
                    System.out.println("-----AUTORES-----");
                    System.out.println("Nome : " + pub.get(i).autores.get(j).getNome());
                        if(pub.get(i).autores.get(j).getCargo()==1){
                            System.out.println("Cargo : Aluno de graduacao");
                        } else if (pub.get(i).autores.get(j).getCargo()==2){
                            System.out.println("Cargo : Aluno de mestrado");
                        } else if (pub.get(i).autores.get(j).getCargo()==3){
                            System.out.println("Cargo : Aluno de doutorado");
                        } else if (pub.get(i).autores.get(j).getCargo()==4){
                            System.out.println("Cargo : Professor");
                        } else if (pub.get(i).autores.get(j).getCargo()==5){
                            System.out.println("Cargo : Pesquisador");
                        }
                    System.out.println("-------");
                }
        }
    }
     
    public int menuPublicacoes(){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Selecione a opção desejada : ");
        System.out.println("1 - Lançar publicação");
        System.out.println("2 - Remover publicação");
        System.out.println("3 - Alocar publicação");
        System.out.println("4 - Mostrar publicações");
        System.out.println("0 - Sair");
        
        int op = scan.nextInt();
        
        return op;
   
    }
}