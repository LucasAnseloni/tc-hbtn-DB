package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestaoCursosMain {

    public static void main(String[] args) {
        CursoModel cursoModel = new CursoModel();
        AlunoModel alunoModel = new AlunoModel();
        List<Aluno> alunos;
        List<Curso> cursos;

        Telefone tel1 = new Telefone();
        tel1.setDdd("11");
        tel1.setNumero("97711-2330");

        Telefone tel2 = new Telefone();
        tel2.setDdd("11");
        tel2.setNumero("97711-2340");

        Telefone tel3 = new Telefone();
        tel3.setDdd("11");
        tel3.setNumero("97711-2350");


        Endereco end1 = new Endereco();
        end1.setLogradouro("Rua");
        end1.setEndereco("Maria de azevedo");
        end1.setNumero("199");
        end1.setBairro("Conceição");
        end1.setCidade("Diadema");
        end1.setEstado("São Paulo");
        end1.setCep(9912250);

        Endereco end2 = new Endereco();
        end2.setLogradouro("Avenida");
        end2.setEndereco("Pereira Barreto");
        end2.setNumero("199");
        end2.setBairro("Demarch");
        end2.setCidade("São Bernardo do Campo");
        end2.setEstado("São Paulo");
        end2.setCep(9912350);

        // 1) Criando Aluno com telefone e endereço
        System.out.println("*** Criando dois Alunos ***");
        Aluno aluno1 = new Aluno();
        Aluno aluno2 = new Aluno();
        aluno1.setNomeCompleto("Lucas Barros");
        aluno1.setMatricula("A01");
        aluno1.setNascimento(LocalDate.of(1992,8,4));
        aluno1.setEmail("lucas@email.com");
        aluno1.setTelefones(new ArrayList<Telefone>(List.of(tel1,tel2)));
        aluno1.setEnderecos(new ArrayList<Endereco>(List.of(end1)));
        aluno2.setNomeCompleto("Carolina Martins");
        aluno2.setMatricula("C01");
        aluno2.setNascimento(LocalDate.of(1993,10,26));
        aluno2.setEmail("carolina@email.com");
        aluno2.setTelefones(new ArrayList<Telefone>(List.of(tel3)));
        aluno2.setEnderecos(new ArrayList<Endereco>(List.of(end2)));
        alunoModel.create(aluno1);
        alunoModel.create(aluno2);


        //2) Buscando alunos
        System.out.println("Buscando Alunos");
        Aluno alunoId1 = new Aluno();
        Aluno alunoId2 = new Aluno();
        alunoId1.setId(1L);
        alunoId1 = alunoModel.findById(alunoId1);
        alunoId2.setId(2L);
        alunoId2 = alunoModel.findById(alunoId2);
        System.out.println(alunoId1);
        System.out.println(alunoId2);

        //3) Deletando Aluno
        System.out.println("Deletando Aluno");
        Aluno deleteAlunoId1 = new Aluno();
        deleteAlunoId1.setId(2L);
        alunoModel.delete(deleteAlunoId1);

        //4) Buscando todos os Alunos
        System.out.println("Buscando Todos os Alunos");
        alunos = alunoModel.findAll();
        System.out.println(alunos);

        //5) Update Produto Status to False do P1
        System.out.println("Atualizado Nome e numero do Aluno");
        Aluno updateAlunoId1 = new Aluno();
        updateAlunoId1.setId(1L);
        updateAlunoId1 = alunoModel.findById(updateAlunoId1);
        updateAlunoId1.setNomeCompleto("Lucas Anseloni Barros");
        updateAlunoId1.getTelefones().forEach(telefone -> {
            if (telefone.getId() == 1L)
                telefone.setNumero("1111-1111");
        });
        alunoModel.update(updateAlunoId1);

        //4) Buscando todos os Alunos
        System.out.println("Buscando Todos os Alunos");
        alunos = alunoModel.findAll();
        System.out.println(alunos);

        Professor prof1 = new Professor();
        prof1.setNomeCompleto("Rogerio de Silva");
        prof1.setMatricula("R01");
        prof1.setEmail("rogerio@email.com");
        Professor prof2 = new Professor();
        prof2.setId(1L);

        MaterialCurso material1 = new MaterialCurso();
        material1.setUrl("www.google.com");

        MaterialCurso material2 = new MaterialCurso();
        material1.setUrl("www.bring.com");

        // 6) Criando dois cursos
        System.out.println("Criando Cursos");
        Curso curso1 = new Curso();
        curso1.setNome("Analise e Desenvolvimento de Software");
        curso1.setSigla("ADS");
        curso1.setProfessor(prof1);
        curso1.setMaterialCurso(material1);
        Curso curso2 = new Curso();
        curso2.setNome("Sistemas da Informação");
        curso2.setSigla("SI");
        curso2.setProfessor(prof2);
        curso2.setMaterialCurso(material2);
        cursoModel.create(curso1);
        cursoModel.create(curso2);



        //7) Buscando curso 1 e curso 2
        System.out.println("Buscando curso 1 e curso 2");
        Curso cursoId1 = new Curso();
        Curso cursoId2 = new Curso();
        cursoId1.setId(1L);
        cursoId2.setId(2L);
        cursoId1 = cursoModel.findById(cursoId1);
        cursoId2 = cursoModel.findById(cursoId2);
        System.out.println(cursoId1);
        System.out.println(cursoId2);

        //8) Deletando curso 1
        System.out.println("Deletando o curso com ID 1");
        Curso deleteCursoId1 = new Curso();
        deleteCursoId1.setId(1L);
        cursoModel.delete(deleteCursoId1);

        Professor prof3 = new Professor();
        prof3.setNomeCompleto("Joaquim Aparecido");
        prof3.setMatricula("J01");
        prof3.setEmail("joaquim@email.com");

        //9) atualizando nome do curso, professor e url do material
        System.out.println("Atualizando nome do curso, professor e url do material");
        Curso updateCursoId2 = new Curso();
        updateCursoId2.setId(2L);
        updateCursoId2 = cursoModel.findById(updateCursoId2);
        updateCursoId2.setNome("Sistemas da Informação Atualizado");
        updateCursoId2.setProfessor(prof3);
        updateCursoId2.getMaterialCurso().setUrl("www.bring.com/courses");
        cursoModel.update(updateCursoId2);

        //10) Buscando todos os cursos
        System.out.println("Buscando todos os cursos");
        cursos = cursoModel.findAll();
        System.out.println(cursos);

        //11) atualizando o curso 2 e adicionando Aluno 1
        System.out.println("Atualizando o curso 2 e adicionando Aluno 1");
        updateCursoId2 = cursoModel.findById(updateCursoId2);
        alunoId1 = alunoModel.findById(alunoId1);
        updateCursoId2.setAlunos(new ArrayList<Aluno>(List.of(alunoId1)));
        cursoModel.update(updateCursoId2);

        //12) Buscando todos os cursos
        System.out.println("Buscando todos os cursos");
        cursos = cursoModel.findAll();
        System.out.println(cursos);



    }




}
