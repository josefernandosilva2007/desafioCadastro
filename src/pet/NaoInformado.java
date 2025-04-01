package pet;

public enum NaoInformado {
    NAOINFORMADO("NAO INFORMADO");
    private String tipo;

    NaoInformado(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
