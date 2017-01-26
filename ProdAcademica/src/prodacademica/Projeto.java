package prodacademica;

import java.util.Date;
import java.util.Scanner;

public class Projeto {
    String titulo;
    Date dataInicio;
    Date dataTermino;
    String agenciaFinanciadora;
    double valorFinanciado;
    String objetivo;
    String descricao;
    int participantes; //Ter pelo menos 1 professor participante
    String status; //"Em elaboração" -> "Em andamento" -> "Concluído"

    public Projeto(String titulo, Date dataInicio, Date dataTermino, String agenciaFinanciadora, double valorFinanciado, String objetivo, String descricao, int participantes, String status) {
        this.titulo = titulo;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.agenciaFinanciadora = agenciaFinanciadora;
        this.valorFinanciado = valorFinanciado;
        this.objetivo = objetivo;
        this.descricao = descricao;
        this.participantes = participantes;
        this.status = status;
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
    
    
    public void cadastrarProjeto(){
        Scanner scan = new Scanner(System.in);
        String nome;
        
        System.out.println("Digite o titulo do projeto : ");
        nome = scan.nextLine();
        setTitulo(nome);
        
        System.out.println("Digite a data de início do projeto (dd/mm/yyyy hh:mm:ss) : ");
        
        
    }

    public void mostrarProjeto(){
        System.out.println("Titulo : " + getTitulo());
        System.out.println("Data Inicio : " + getDataInicio());
        System.out.println("Data Término : " + getDataTermino());
        System.out.println("Agência financiadora : " + getAgenciaFinanciadora());
        System.out.println("Valor financiado : " + getValorFinanciado());
        System.out.println("Objetivo : " + getObjetivo());
        System.out.println("Descricao : " + getDescricao());
    }
    
}
