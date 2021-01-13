package Models.About_Page;

public class AboutPage_Model_es {

    String txt1, txt2;
    String[] texts;

    public AboutPage_Model_es(){
        txt1 = "Desarrollado por:";
        txt2 = "Todos los derechos reservados.";
        texts = new String[2];
    }

    public String getTxt1() {
        return txt1;
    }

    public String getTxt2() {
        return txt2;
    }

    public String[] getTexts() {
        texts[0] = txt1;
        texts[1] = txt2;
        return texts;
    }
}
