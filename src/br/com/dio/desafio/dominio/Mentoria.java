package br.com.dio.desafio.dominio;

import java.time.LocalDateTime;

public class Mentoria extends Conteudo {

        private LocalDateTime data;

        public LocalDateTime getData() {
                return data;
        }

        public void setData(LocalDateTime data) {
                this.data = data;
        }

        public Mentoria(String titulo, String descricao, LocalDateTime data) {
                super(titulo, descricao);
                setData(data);
        }

        public Mentoria(String titulo, String descricao) {
                super(titulo, descricao);
        }

        public Mentoria(String titulo, LocalDateTime data) {
                super(titulo);
                setData(data);
        }

        public Mentoria(String titulo) {
                super(titulo);
        }

        @Override
        public double calcularXp() {
                return this.XpPadrao + 20d;
        }

        @Override
        public String toString() {
                return super.toString() + " at " + this.getData();
        }

}
