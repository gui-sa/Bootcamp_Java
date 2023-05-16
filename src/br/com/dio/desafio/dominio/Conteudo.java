package br.com.dio.desafio.dominio;

public abstract class Conteudo implements Comparable {

        protected final double XpPadrao = 10d;
        private String titulo;
        private String descricao;

        public String getTitulo() {
                return titulo;
        }

        public void setTitulo(String titulo) {
                this.titulo = titulo;
        }

        public String getDescricao() {
                return descricao;
        }

        public void setDescricao(String descricao) {
                this.descricao = descricao;
        }

        public Conteudo(String titulo, String descricao) {
                setDescricao(descricao);
                setTitulo(titulo);
        }

        public Conteudo(String titulo) {
                setTitulo(titulo);
        }

        public abstract double calcularXp();

        @Override
        public int hashCode() {
                return this.titulo.hashCode();
        }

        @Override
        public int compareTo(Object o) {
                return this.getTitulo().compareToIgnoreCase(((Conteudo) o).getTitulo());
        }

        @Override
        public boolean equals(Object obj) {
                if (obj == null)
                        return false;
                if (!(obj instanceof Curso))
                        return false;
                if (obj == this)
                        return true;
                return this.getTitulo().equalsIgnoreCase(((Conteudo) obj).getTitulo());
        }

        @Override
        public String toString() {
                return this.getTitulo() + " - " + this.getDescricao();
        }
}