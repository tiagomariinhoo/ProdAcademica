package prodacademica;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Projeto {
    private String titulo;
    private Date dataInicio;
    private Date dataTermino;
    private String agenciaFinanciadora;
    private double valorFinanciado;
    private String objetivo;
    private String descricao;
    private int participantes; //Ter pelo menos 1 professor participante
    private String status; //"Em elaboração" -> "Em andamento" -> "Concluído"
    private boolean alocado;
     ArrayList<Colaboradores> colab;
     ArrayList<Publicacoes> publicacoes;

    

    /*public Projeto(String titulo, Date dataInicio, Date dataTermino, String agenciaFinanciadora, double valorFinanciado, String objetivo, String descricao, int participantes, String status) {
        this.titulo = titulo;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.agenciaFinanciadora = agenciaFinanciadora;
        this.valorFinanciado = valorFinanciado;
        this.objetivo = objetivo;
        this.descricao = descricao;
        this.participantes = participantes;
        this.status = status;
    }*/

     public boolean getAlocado() { //VERIFICAR SE HÁ PUBLICAÇÃO ALOCADA A ESSE PROJETO
        return alocado;
    }

    public void setAlocado(boolean alocado) {
        this.alocado = alocado;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public String getAgenciaFinanciadora() {
        return agenciaFinanciadora;
    }

    public void setAgenciaFinanciadora(String agenciaFinanciadora) {
        this.agenciaFinanciadora = agenciaFinanciadora;
    }

    public double getValorFinanciado() {
        return valorFinanciado;
    }

    public void setValorFinanciado(double valorFinanciado) {
        this.valorFinanciado = valorFinanciado;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getParticipantes() {
        return participantes;
    }

    public void setParticipantes(int participantes) {
        this.participantes = participantes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    public ArrayList<Publicacoes> getPublicacoes() {
        return publicacoes;
    }

    public void addPublicacoes(Publicacoes pub) {
        
    }
    
    public Projeto adicionarProjeto() throws ParseException{
        Projeto proj = new Projeto();
        
        
        Scanner scan = new Scanner(System.in);
        String nome;
        
        System.out.println("Digite o titulo do projeto : ");
        nome = scan.nextLine();
        proj.setTitulo(nome);
        
        System.out.println("Digite a data de início do projeto (dd/mm/yyyy hh:mm:ss) : ");
        GregorianCalendar cal = new GregorianCalendar();
        String inicio = scan.nextLine();
        proj.setDataInicio(DateFormat.getDateTimeInstance().parse(inicio));
        cal.setTime(proj.getDataInicio());
        
        System.out.println("Digite a data de término do projeto (dd/mm/yyyy hh:mm:ss) : ");
        GregorianCalendar cal2 = new GregorianCalendar();
        String fim = scan.nextLine();
        proj.setDataTermino(DateFormat.getDateTimeInstance().parse(fim));
        cal.setTime(proj.getDataTermino());
        
        System.out.println("Informe a agência financiadora : ");
        String agencia = scan.nextLine();
        proj.setAgenciaFinanciadora(agencia);
        
        System.out.println("Informe o valor financiado : ");
        double valor = scan.nextDouble();
        proj.setValorFinanciado(valor);
        
        scan.nextLine();
        System.out.println("Objetivo : ");
        String objetivo  = scan.nextLine();
        proj.setObjetivo(objetivo);
        
        System.out.println("Descrição : ");
        String descricao = scan.nextLine();
        proj.setDescricao(descricao);
        
        proj.setStatus("Em elaboração");
        proj.setAlocado(false);
        proj.colab = new ArrayList <Colaboradores>();
        proj.publicacoes = new ArrayList <Publicacoes>();
        
        return proj;
    }

    public void mostrarProjeto(ArrayList <Projeto> proj){
        
        if(proj.size()==0){
            System.out.println("Ainda não há projetos registrados!");
            return ;
        }
        
        for(int i=0;i<proj.size();i++){
            System.out.println("Titulo : " + proj.get(i).getTitulo());
            System.out.println("Data Inicio : " + proj.get(i).getDataInicio());
            System.out.println("Data Término : " + proj.get(i).getDataTermino());
            System.out.println("Agência financiadora : " + proj.get(i).getAgenciaFinanciadora());
            System.out.println("Valor financiado : " + proj.get(i).getValorFinanciado());
            System.out.println("Objetivo : " + proj.get(i).getObjetivo());
            System.out.println("Descricao : " + proj.get(i).getDescricao());
            System.out.println("Status : " + proj.get(i).getStatus());
                if(proj.get(i).getAlocado()==true){
                    System.out.println("PUBLICAÇÃO ALOCADA : ");
                    Publicacoes pub_aux = new Publicacoes();
                    
                    pub_aux.mostrarPublicacao(proj.get(i).publicacoes);
                }
                
                if(proj.get(i).colab.size()>0){
                    for(int j=0;i<proj.get(i).colab.size();j++){
                        System.out.println("------ COLABORADORES ------");
                        System.out.println("Colaborador : " + proj.get(i).colab.get(j).getNome());
                            if(proj.get(i).colab.get(j).getCargo()==1){
                                System.out.println("Cargo : Aluno de graduação");
                            } else if (proj.get(i).colab.get(j).getCargo()==2){
                                System.out.println("Cargo : Aluno de mestrado");
                            } else if (proj.get(i).colab.get(j).getCargo()==3){
                                System.out.println("Cargo : Aluno de doutorado");
                            } else if (proj.get(i).colab.get(j).getCargo()==4){
                                System.out.println("Cargo : Professor");
                            } else if (proj.get(i).colab.get(j).getCargo()==5){
                                System.out.println("Cargo : Pesquisador");
                            }
                        System.out.println("----------");
                    }
                }
            System.out.println("---------------");
        }
        
    }
    
    public void removerProjeto(ArrayList <Projeto> proj){
        Scanner scan = new Scanner(System.in);
        
        if(proj.size()==0){
            System.out.println("Não há projetos cadastrados!");
            return ;
        }
        
        System.out.println("----- PROJETOS CADASTRADOS -----");
        
        for(int i=0;i<proj.size();i++){
            System.out.println("Titulo : " + proj.get(i).getTitulo());
            System.out.println("Numero : " + i);
            System.out.println("-----------");
        }
        
        System.out.println("Digite o numero do projeto que será removido : ");
        int numb = scan.nextInt();
        
        if(numb<0 || numb>proj.size()){
            System.out.println("Por favor, selecione um projeto existente!");
            return ;
        }
        
        System.out.println("Projeto " + proj.get(numb).getTitulo() + " removido com sucesso!");
        System.out.println("-------------");
        proj.remove(numb);
        

    }
    
    
    public void alterarProjeto(ArrayList <Projeto> proj) throws ParseException{
        Scanner scan = new Scanner(System.in);
        
        if(proj.size()==0){
            System.out.println("Não há projetos cadastrados!");
            return ;
        }
        
        System.out.println("----- PROJETOS CADASTRADOS -----");
        
        for(int i=0;i<proj.size();i++){
            System.out.println("Titulo : " + proj.get(i).getTitulo());
            System.out.println("Numero : " + i);
            System.out.println("-----------");
        }
        
        System.out.println("Digite o numero do projeto que será editado : ");
        int numb = scan.nextInt();
        
        if(numb<0 || numb>proj.size()){
            System.out.println("Por favor, digite o número de um projeto existente.");
            return ;
        }
        
        System.out.println("Selecione a opção que deseja ser alterada no projeto : ");
        System.out.println("1 - Titulo");
        System.out.println("2 - Data inicio");
        System.out.println("3 - Data término");
        System.out.println("4 - Agência financiadora");
        System.out.println("5 - Valor financiado");
        System.out.println("6 - Objetivo");
        System.out.println("7 - Descrição");
        System.out.println("0 - Sair");
        
        int op = scan.nextInt();

        if(op==1){
            scan.nextLine();
            System.out.println("Digite o novo titulo : ");
            String titulo = scan.nextLine();
            proj.get(numb).setTitulo(titulo);
        } else if (op==2){
            scan.nextLine();
            System.out.println("Digite a nova data de inicio : ");
            GregorianCalendar cal = new GregorianCalendar();
            String inicio = scan.nextLine();
            proj.get(numb).setDataInicio(DateFormat.getDateTimeInstance().parse(inicio));
            cal.setTime(proj.get(numb).getDataInicio());
        } else if (op==3){
            scan.nextLine();
            System.out.println("Digite a nova data de término : ");
            GregorianCalendar cal2 = new GregorianCalendar();
            String fim = scan.nextLine();
            proj.get(numb).setDataTermino(DateFormat.getDateTimeInstance().parse(fim));
            cal2.setTime(proj.get(numb).getDataInicio());
        } else if (op==4){
            scan.nextLine();
            System.out.println("Digite a nova agência financiadora : ");
            String agencia = scan.nextLine();
            proj.get(numb).setAgenciaFinanciadora(agencia);
        } else if (op==5){
            System.out.println("Digite o novo valor financiado : ");
            double valor = scan.nextDouble();
            proj.get(numb).setValorFinanciado(valor);
        } else if (op==6){
            scan.nextLine();
            System.out.println("Digite o novo objetivo : ");
            String obj = scan.nextLine();
            proj.get(numb).setObjetivo(obj);
        } else if (op==7){
            scan.nextLine();
            System.out.println("Digite a nova descrição : ");
            String desc = scan.nextLine();
            proj.get(numb).setDescricao(desc);
        } else if (op==0){
            return ;
        }
        
        System.out.println("Alteração feita com sucesso!");
        
    }
    public int menuProjeto(){
        Scanner scan = new Scanner(System.in);
        //Colaboradores col_aux = new Colaboradores();
        Projeto proj = new Projeto();
        
        System.out.println("--------------------");
        System.out.println("1 - Adicionar projeto");
        System.out.println("2-  Remover projeto");
        System.out.println("3 - Alterar projeto");
        System.out.println("4 - Listar projetos");
        System.out.println("0 - Sair");
        try{
            int op = scan.nextInt();
                return op;
            
        } catch(Exception e){
            System.out.println("Selecione uma opção válida!");
        }
        
        return -1;
    }
    
}
