package br.com.dio.desafio.dominio;

public class Curso extends Conteudo {

        private int cargaHoraria;

        public int getCargaHoraria() {
                return cargaHoraria;
        }

        public void setCargaHoraria(int cargaHoraria) {
                this.cargaHoraria = cargaHoraria;
        }

        public Curso(String titulo, int cargaHoraria, String descricao) {
                super(titulo, descricao);
                setCargaHoraria(cargaHoraria);
        }

        public Curso(String titulo, String descricao) {
                super(titulo, descricao);
        }

        public Curso(String titulo) {
                super(titulo);
        }

        @Override
        public double calcularXp() {
                return this.XpPadrao;
        }

        @Override
        public String toString() {
                return getTitulo() + " - " + getCargaHoraria() + " horas - " + getDescricao();
        }

}
