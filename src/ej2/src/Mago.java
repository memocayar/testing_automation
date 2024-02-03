package ej2.src;

public class Mago extends Personaje {
    private String magia;

    public Mago(int salud, String magia) {
        super(salud);
        this.magia = magia;
    }

    public String getMagia() {
        return magia;
    }

    public void setMagia(String magia) {
        this.magia = magia;
    }

    @Override
    public void entrenar() {
        // Los magos no entrenan, no sucede nada
    }
}