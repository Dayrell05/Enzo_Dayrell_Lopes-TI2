package exercicio_2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private static UsuarioDAO usuarioDAO;

    public static void main(String[] args) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            usuarioDAO = new UsuarioDAO(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Falha na conexão com o banco de dados.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Menu:");
            System.out.println("1. Listar Usuários");
            System.out.println("2. Inserir Usuário");
            System.out.println("3. Excluir Usuário");
            System.out.println("4. Atualizar Usuário");
            System.out.println("5. Sair");

            System.out.print("Escolha uma opção: ");
            try {
                option = scanner.nextInt();
                scanner.nextLine(); 

                switch (option) {
                    case 1:
                        listarUsuarios();
                        break;
                    case 2:
                        inserirUsuario(scanner);
                        break;
                    case 3:
                        excluirUsuario(scanner);
                        break;
                    case 4:
                        atualizarUsuario(scanner);
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.next(); 
                option = -1; 
            }
        } while (option != 5);

        scanner.close();
    }

    private static void listarUsuarios() {
        try {
            List<Usuario> usuarios = usuarioDAO.listarTodos();
            if (usuarios.isEmpty()) {
                System.out.println("Nenhum usuário encontrado.");
            } else {
                for (Usuario usuario : usuarios) {
                    System.out.println(usuario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao listar usuários.");
        }
    }

    private static void inserirUsuario(Scanner scanner) {
        try {
            System.out.print("Nome do Usuário: ");
            String nome = scanner.nextLine();
            System.out.print("Email do Usuário: ");
            String email = scanner.nextLine();
            Usuario usuario = new Usuario(nome, email);
            usuarioDAO.inserir(usuario);
            System.out.println("Usuário inserido com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao inserir usuário.");
        }
    }

    private static void excluirUsuario(Scanner scanner) {
        try {
            System.out.print("ID do Usuário a ser excluído: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 
            usuarioDAO.excluir(id);
            System.out.println("Usuário excluído com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao excluir usuário.");
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Digite um número.");
            scanner.next(); 
        }
    }

    private static void atualizarUsuario(Scanner scanner) {
        try {
            System.out.print("ID do Usuário a ser atualizado: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Novo Nome do Usuário: ");
            String nome = scanner.nextLine();
            System.out.print("Novo Email do Usuário: ");
            String email = scanner.nextLine();
            Usuario usuario = new Usuario(id, nome, email);
            usuarioDAO.atualizar(usuario);
            System.out.println("Usuário atualizado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao atualizar usuário.");
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Digite um número.");
            scanner.next(); 
        }
    }
}
