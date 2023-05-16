package br.com.dio.desafio.dominio;

import java.util.*;
import java.util.Objects;

public class Dev implements Comparable {
        private String nome;
        private long cpf;
        private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
        private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

        // Manter a classe mae Conteudo permite reaproveitamente
        // LinkedHashSet porque queremos manter ordem de inserção sem duplicadas.

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public long getCpf() {
                return cpf;
        }

        public void setCpf(long cpf) {
                this.cpf = cpf;
        }

        public Set<Conteudo> getConteudosInscritos() {
                return conteudosInscritos;
        }

        public Set<Conteudo> getConteudosConcluidos() {
                return conteudosConcluidos;
        }

        public Dev(String nome, long cpf) {
                setNome(nome);
                setCpf(cpf);
        }

        public boolean seInscreverBootcamp(Bootcamp bootcamp) {
                boolean sucess = this.conteudosInscritos.addAll(bootcamp.getConteudos()); // ao se inscrever em um
                                                                                          // bootcamp todos os conteudo
                boolean sucess2 = bootcamp.getDevsInscritos().add(this);
                return sucess && sucess2;
        };

        public boolean finalizarConteudo(Conteudo conteudo) {
                if (this.getConteudosInscritos().contains(conteudo)) {
                        boolean added = this.getConteudosConcluidos().add(conteudo);
                        boolean removed = this.getConteudosInscritos().remove(conteudo);
                        return true;
                }
                return false;
        };

        public void finalizarBootcamp(Bootcamp bootcamp) {
                for (Conteudo conteudo : bootcamp.getConteudos()) {
                        boolean sucess = finalizarConteudo(conteudo);
                }
        };

        public double contabilizarXp() {
                return this.getConteudosConcluidos().stream().mapToDouble(conteudo -> conteudo.calcularXp()).sum();
        };

        @Override
        public String toString() {
                return this.getNome() + "- CPF: " + this.getCpf();
        }

        @Override
        public boolean equals(Object obj) {
                if (obj == null)
                        return false;
                if (!(obj instanceof Dev))
                        return false;
                if (obj == this)
                        return true;
                return Objects.equals(this.getNome(), ((Dev) obj).getNome())
                                && Objects.equals(this.getCpf(), ((Dev) obj).getCpf());
        }

        @Override
        public int hashCode() {
                return Objects.hash(this.getNome(), this.getCpf());
        }

        @Override
        public int compareTo(Object o) {
                if (this.getCpf() > ((Dev) o).getCpf())
                        return 1;
                if (this.getCpf() < ((Dev) o).getCpf())
                        return -1;
                return 0;
        }
}
