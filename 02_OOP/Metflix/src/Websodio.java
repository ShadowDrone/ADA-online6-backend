
public class Websodio extends Episodio {

    public Websodio(int numero, String nombre, String link) {
        super(numero, nombre);//llamo al constructor del mapadre
        this.setLink(link);//seteo el link
    }

    private String link;

    public String getLink() {
        return this.link;

    }

    public void setLink(String link) {
        this.link = link;
    }

    //Redefinicion
    @Override
    public void reproducir() {
        System.out.println("Reproduciendo websodio del link " + this.link);
    }
}
