import java.util.ArrayList;
import java.util.List;

public class Veiculo {
    private String placa;
    private String modelo;
    private Cliente dono;
    private List<Servico> servicos;

    public Veiculo(String placa, String modelo, Cliente dono) {
        this.placa = placa;
        this.modelo = modelo;
        this.dono = dono;
        this.servicos = new ArrayList<>();
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public Cliente getDono() {
        return dono;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void adicionarServico(Servico servico) {
        servicos.add(servico);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Veiculo {")
          .append("Placa: '").append(placa).append('\'')
          .append(", Modelo: '").append(modelo).append('\'')
          .append(", Dono: ").append(dono.getNome())
          .append(", Serviços: ").append(servicos)
          .append('}');
        return sb.toString();
    }
}
