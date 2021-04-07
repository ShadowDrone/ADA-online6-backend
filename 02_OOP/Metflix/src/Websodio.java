
public class Websodio extends Episodio {
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
