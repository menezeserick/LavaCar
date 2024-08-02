import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lavacar {
    private List<Cliente> clientes;
    private List<Veiculo> veiculos;

    public Lavacar() {
        this.clientes = new ArrayList<>();
        this.veiculos = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== Lava-car <3 =====\n\n");

        sb.append("Clientes:\n");
        for (Cliente cliente : clientes) {
            sb.append(cliente).append("\n");
        }

        sb.append("\nVeículos:\n");
        for (Veiculo veiculo : veiculos) {
            sb.append(veiculo).append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lavacar lavacar = new Lavacar();
        boolean running = true;

        while (running) {
            System.out.println("===== Menu =====");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Adicionar Veículo");
            System.out.println("3. Adicionar Serviço a Veículo");
            System.out.println("4. Exibir Informações");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do cliente:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o CPF do cliente:");
                    String cpf = scanner.nextLine();
                    System.out.println("Digite o telefone do cliente:");
                    String telefone = scanner.nextLine();
                    Cliente cliente = new Cliente(nome, cpf, telefone);
                    lavacar.adicionarCliente(cliente);
                    break;
                case 2:
                    System.out.println("Digite a placa do veículo:");
                    String placa = scanner.nextLine();
                    System.out.println("Digite o modelo do veículo:");
                    String modelo = scanner.nextLine();
                    System.out.println("Digite o CPF do dono do veículo:");
                    String cpfDono = scanner.nextLine();

                    Cliente dono = null;
                    for (Cliente c : lavacar.getClientes()) {
                        if (c.getCpf().equals(cpfDono)) {
                            dono = c;
                            break;
                        }
                    }

                    if (dono == null) {
                        System.out.println("Cliente não encontrado. Adicione o cliente primeiro.");
                        break;
                    }

                    Veiculo veiculo = new Veiculo(placa, modelo, dono);
                    lavacar.adicionarVeiculo(veiculo);
                    break;
                case 3:
                    System.out.println("Digite a placa do veículo:");
                    String placaVeiculo = scanner.nextLine();

                    Veiculo veiculoEncontrado = null;
                    for (Veiculo v : lavacar.getVeiculos()) {
                        if (v.getPlaca().equals(placaVeiculo)) {
                            veiculoEncontrado = v;
                            break;
                        }
                    }

                    if (veiculoEncontrado == null) {
                        System.out.println("Veículo não encontrado. Adicione o veículo primeiro.");
                        break;
                    }

                    System.out.println("Digite a descrição do serviço:");
                    String descricao = scanner.nextLine();
                    System.out.println("Digite o preço do serviço:");
                    double preco = scanner.nextDouble();
                    scanner.nextLine(); 

                    Servico servico = new Servico(descricao, preco);
                    veiculoEncontrado.adicionarServico(servico);
                    break;
                case 4:
                    System.out.println(lavacar);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
