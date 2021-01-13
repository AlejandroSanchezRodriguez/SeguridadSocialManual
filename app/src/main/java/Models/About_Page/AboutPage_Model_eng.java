package Models.About_Page;

public class AboutPage_Model_eng {

    String txt1, txt2;
    String[] texts;

    public AboutPage_Model_eng(){
        txt1 = "Developed by:";
        txt2 = "All rights reserved.";
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
