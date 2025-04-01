package pet;

public enum AnimalType {
    GATO("GATO"),
    CACHORRO("CACHORRO");
    private String tipo;

    AnimalType(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
