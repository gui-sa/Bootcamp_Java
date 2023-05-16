package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.*;

public class Bootcamp implements Comparable {
        private String nome;
        private String descricao;
        private final LocalDate dataInicial = LocalDate.now();
        private final LocalDate dataFinal = dataInicial.plusDays(45); // 45 days later
        private Set<Dev> devsInscritos = new HashSet<>();
        private Set<Conteudo> conteudos = new LinkedHashSet<>(); // Insertion Ordering matters

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public String getDescricao() {
                return descricao;
        }

        public void setDescricao(String descricao) {
                this.descricao = descricao;
        }

        public LocalDate getDataInicial() {
                return dataInicial;
        }

        public LocalDate getDataFinal() {
                return dataFinal;
        }

        public Set<Dev> getDevsInscritos() {
                return devsInscritos;
        }

        public Set<Conteudo> getConteudos() {
                return conteudos;
        }

        public boolean adicionarConteudo(Conteudo conteudo) {
                return this.getConteudos().add(conteudo);
        };

        public Bootcamp(String nome, String descricao) {
                this.setDescricao(descricao);
                this.setNome(nome);
        }

        public Bootcamp(String nome) {
                this.setNome(nome);
        }

        @Override
        public int hashCode() {
                return Objects.hash(this.getNome(), this.getDataInicial());
        }

        @Override
        public boolean equals(Object obj) {
                if (obj == null)
                        return false;
                if (!(obj instanceof Bootcamp))
                        return false;
                if (obj == this)
                        return true;
                Bootcamp boot = (Bootcamp) obj; // cast to reduce typing
                return Objects.equals(this.getNome(), boot.getNome())
                                && Objects.equals(this.getDataInicial(), boot.getDataInicial());
        }

        @Override
        public int compareTo(Object o) {
                return this.getDataInicial().compareTo(((Bootcamp) o).getDataInicial());
        }

        @Override
        public String toString() {
                return this.nome + " criado em " + this.getDataFinal() + " - " + this.getDescricao()
                                + " - Numero de Inscritos: " + this.getDevsInscritos().size();
        }

}