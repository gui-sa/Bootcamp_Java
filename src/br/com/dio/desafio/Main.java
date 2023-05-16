package br.com.dio.desafio;

import java.time.LocalDateTime;

import br.com.dio.desafio.dominio.*;

public class Main {
        public static void main(String[] args) {
                Dev dev1 = new Dev("Guilherme", 22211133300l);
                Conteudo git1 = new Curso("GIT-basic", 2, "From basics to push");
                Conteudo git2 = new Curso("GIT-advanced", 5, "Learning pull-request");
                Conteudo git3 = new Curso("GIT-advanced", 5, "Learning pull-request");
                Conteudo git4 = new Curso("GIT-advanced", 5, "Learning pull-request");
                Conteudo docker1 = new Curso("Docker-basic", 8, "From what is it to container run");
                Conteudo docker2 = new Curso("Docker-advanced", 5, "Learning Dockerfile and docker-compose");
                Conteudo java1 = new Curso("Java", 15, "POO and Java Sintaxe");
                Conteudo java2 = new Curso("Kotlin", 15, "Using Kotlin");

                Bootcamp tqi = new Bootcamp("Java & Kotlin", "Java and Kotlin") {
                        {
                                adicionarConteudo(git1);
                                adicionarConteudo(git2);
                                adicionarConteudo(git3);
                                adicionarConteudo(git4);
                                adicionarConteudo(docker1);
                                adicionarConteudo(docker2);
                                adicionarConteudo(java1);
                                adicionarConteudo(java2);
                        }
                };

                for (Conteudo conteudo : tqi.getConteudos()) {
                        System.out.println(conteudo);
                } // OK! Adicionou uma vez só e na ordem!

                System.out.println("\n\n Inscritos:");
                dev1.seInscreverBootcamp(tqi);

                for (Conteudo conteudo : dev1.getConteudosInscritos()) {
                        System.out.println(conteudo);
                }

                System.out.println("\n Finalizou git1:");
                dev1.finalizarConteudo(git1);
                for (Conteudo conteudo : dev1.getConteudosInscritos()) {
                        System.out.println(conteudo);
                }

                System.out.println("\n>>");
                for (Conteudo conteudo : dev1.getConteudosConcluidos()) {
                        System.out.println(conteudo);
                }

                System.out.println("\n Finalizou bootcamp:");
                dev1.finalizarBootcamp(tqi);
                for (Conteudo conteudo : dev1.getConteudosInscritos()) {
                        System.out.println(conteudo);
                }
                System.out.println("\n>>");
                for (Conteudo conteudo : dev1.getConteudosConcluidos()) {
                        System.out.println(conteudo);
                }
        }
}