package model.beans;

import java.util.ArrayList;

public class Evento extends LocalDeEvento {

    private int id;
    private String duracao, dataInicio, dataFim, horaInicio, horaFim, nomeEvento;
    private float valorIngresso;
    private int idadeMin, quantidadeIngressos;
    private ArrayList<Ingresso> ingressos;
    private ArrayList<Assento> assentos; // Só terá valores quando o local de evento possuir assentos

    public Evento(LocalDeEvento local, String nomeEvento, int quantidadeIngressos, String duracao, String dataInicio, String dataFim, String horaInicio, String horaFim,
            float valorIngresso, int idadeMin) {
        super(local.getLogradouro(), local.getCEP(), local.getNumero(), local.getCapacidade(), local.hasAssentos());
        this.duracao = duracao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.nomeEvento = nomeEvento;
        this.valorIngresso = valorIngresso;
        this.idadeMin = idadeMin;
        this.quantidadeIngressos = quantidadeIngressos;
        gerarIngressos();
        gerarAssentos();//Só gera os assentos se o local do evento tiver assentos
    }

    private void gerarIngressos() {
        ingressos.add(new Ingresso());
    }

    private void gerarAssentos() {
        if (hasAssentos()) {
            assentos.add(new Assento());
        }

    }

    public Evento() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public float getValorIngresso() {
        return valorIngresso;
    }

    public void setValorIngresso(float valorIngresso) {
        this.valorIngresso = valorIngresso;
    }

    public int getQuantidadeIngressos() {
        return quantidadeIngressos;
    }

    public void setQuantidadeIngressos(int quantidadeIngressos) {
        this.quantidadeIngressos = quantidadeIngressos;
    }

    public int getIdadeMin() {
        return idadeMin;
    }

    public void setIdadeMin(int idadeMin) {
        this.idadeMin = idadeMin;
    }

    public ArrayList<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(ArrayList<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }

    public ArrayList<Assento> getAssentos() {
        return assentos;
    }

    public void setAssentos(ArrayList<Assento> assentos) {
        this.assentos = assentos;
    }


}
